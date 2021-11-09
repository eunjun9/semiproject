package com.soda.mypage.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import com.soda.magazine.model.vo.MagazineFile;
import com.soda.member.model.vo.Member;
import com.soda.mypage.model.service.ProfileService;
import com.soda.mypage.model.vo.Profile;
import com.soda.mypage.model.vo.ProfileFile;

/**
 * Servlet implementation class ProfileReviseServlet
 */
@WebServlet("/profile/modifyview")
public class ProfileModifyViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileModifyViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* enctype이 multipart/form-data 로 전송되었는지 확인*/
	      if(!ServletFileUpload.isMultipartContent(request)) {
	         request.setAttribute("message", "잘못된 전송입니다.");
	         request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
	         return;
	      }
	      
	      int maxSize = 1024*1024*10;
	      String root = request.getSession().getServletContext().getRealPath("/");
	      String savePath = root +  "resources\\images\\woo_uploadFiles\\"; 
	      /* input type file에 첨부 된 파일 서버에 저장 됨*/
	      MultipartRequest multiRequest
	         = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
	      
	      
	
	      
	      
	      
	  	/* 요청에 담긴 클라이언트가 입력한 값 추출 (글제목, 글내용) +) 게시글 번호 */
	      String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
	      String sns = multiRequest.getParameter("sns");
			String introduction = multiRequest.getParameter("introduction");
			String[] interestArr = multiRequest.getParameterValues("interest");
			
			
			String interest = "";
			
			if(interestArr != null) {
				interest= String.join("|", interestArr);
			}
			
			
		      /* 프로필 수정정 값 설정*/
		      Profile profile = new Profile();
		      
		      profile.setUserId(userId);
		      profile.setSns(sns);
		      profile.setIntroduction(introduction);
		      profile.setInterest(interest);
			
System.out.println(profile);
		      
		      
				List<ProfileFile> photoList = new ArrayList<>();
				
				String fileName = multiRequest.getParameter("pic");
				String changeName = multiRequest.getParameter("changeName");				   
				
//				System.out.println(multiRequest.getParameter("pic"));
//				System.out.println(changeName);
				
				ProfileFile photo = new ProfileFile();
				
				photo.setRoute("/resources/images/woo_uploadFiles/");
			         // 다양한 파일 패스에 저장되는 상황이 있기 떄문에 이런 컬럼을 만들어놓고 설정하면 된다
			         
			         /* getOriginalFileName() : 실제 사용자가 업로드 한 파일명 */
				photo.setOriginName(multiRequest.getOriginalFileName(fileName));
			         /* getFilesystemName() : MyRenamePolicy의 rename 메소드에서 작성한대로 rename 된 파일명 */
				photo.setChangeName(multiRequest.getFilesystemName(fileName));

				
				if(changeName != null ) {
		            photo.setDeletedName(changeName);
//		            System.out.println(changeName);
		         }
				
				photoList.add(photo);
			      
			      
			      /* profile에 만들어진 photolist 데이터 설정 */
			    profile.setPhotoList(photoList);
		      
				
		      
		      
		      
		      
		      
	      
	      int result = new ProfileService().modifyProfile(profile);
	      
	      if(result> 0) {
		    	 // 수정 성공시 덮어쓰기된 사진 삭제
		    	  for(ProfileFile photo2 : photoList) {
		    		  if(photo.getDeletedName() != null) {
		    			 File deletedFile = new File(savePath + photo2.getDeletedName());
		    			 deletedFile.delete();
		    		  }
		    	  }
		    	  
		         response.sendRedirect(request.getContextPath()+"/myfeed");
		      }else {
		    	  
		    	 // 수정 실패시 수정을 위해 첨부된 사진 삭제
		    	  for(ProfileFile photo2 : photoList) {
		    		  File failedFile = new File(savePath + photo2.getChangeName());
		    		  failedFile.delete();
		    	  }
		         request.setAttribute("message", "사진 게시글 수정에 실패했습니다.");
		         request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
		      }
		   }
	     
}
	
