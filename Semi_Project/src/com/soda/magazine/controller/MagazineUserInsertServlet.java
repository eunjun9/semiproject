package com.soda.magazine.controller;

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
import com.soda.magazine.model.service.MagazineService;
import com.soda.magazine.model.vo.MagazineFile;
import com.soda.magazine.model.vo.Magazine;
import com.soda.member.model.vo.Member;

/**
 * Servlet implementation class MagazineWrite
 */
@WebServlet("/user/insert")
public class MagazineUserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MagazineUserInsertServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("/WEB-INF/views/magazine/magazineUserInsert.jsp").forward(request, response);
	   }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
      
		/* enctype이 multipart/form-data로 전송 되었는지 확인하고, 아닐 경우 에러페이지 이동 */
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("message", "잘못 된 전송입니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
			return;
		}
		
		/* 1. 전송 파일 용량 제한 : 10MB로 제한 */
		int maxSize = 1024*1024*10;
		
		/* 2. 웹 서버 컨테이너 경로 추출 후 파일이 실제 저장 될 경로 지정 */
		String root = request.getSession().getServletContext().getRealPath("/"); // E:\Server\workspace\JSPProject\webapp\
		String savePath = root + "resources\\images\\woo_uploadFiles\\"; // \는 이스케이프 처리
		
		/* HttpServletRequest => MultipartRequest 타입으로 변경 */
		MultipartRequest multiRequest 
			= new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
		// 요청, 저장할 경로, 최대 용량, 인코딩 타입, 파일의 리네임 규칙에 따라 리네임하는 객체(cos.jar)
		
		/* DB의 Magazine에 데이터 저장 */
		String mCategory = multiRequest.getParameter("category");
		String mtitle = multiRequest.getParameter("title");
		String mcontent = multiRequest.getParameter("content");
		String mwriter = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
			
	
		
		Magazine user = new Magazine();
		user.setnType(mCategory);
		user.setnTitle(mtitle);
		user.setnContent(mcontent);
		user.setUserId(mwriter);
		
		
		// 첨부파일 썸네일로 받아오기
		List<MagazineFile> photoList = new ArrayList<>();
		  String[] fileNames = {"thumbnail", "contentImg1","contentImg2"};
		  
	      for(int i = 0 ; i < fileNames.length; i++) {
	         /* contentImg는 optional이므로 파일 첨부 되지 않았을 수도 있음 
	          * 해당 태그에 파일이 업로드 되지 않았을 경우 다음 fileName으로 넘어감 */
	         if(multiRequest.getFilesystemName(fileNames[i]) == null)
	            continue;
	         
	         MagazineFile file = new MagazineFile();
	         file.setRoute("/resources/images/woo_uploadFiles/");
	         // 다양한 파일 패스에 저장되는 상황이 있기 떄문에 이런 컬럼을 만들어놓고 설정하면 된다
	         
	         /* getOriginalFileName() : 실제 사용자가 업로드 한 파일명 */
	         file.setOriginName(multiRequest.getOriginalFileName(fileNames[i]));
	         /* getFilesystemName() : MyRenamePolicy의 rename 메소드에서 작성한대로 rename 된 파일명 */
	         file.setChangeName(multiRequest.getFilesystemName(fileNames[i]));
	         /* thumbnail file_level => 0, contentImg file_level => 1 */
	         if(i == 0)
	        	 file.setFileLevel(1);
	         else
	        	 file.setFileLevel(2);
	         
	         /* 파일이 첨부 된 개수만큼 attachment 객체가 photoList에 담김 */
	         photoList.add(file);
	      }
	      
	      /* magazine에 만들어진 attachment 데이터 설정 */
	      user.setPhotoList(photoList);
	      
	      System.out.println(photoList.get(0).getChangeName());
//	      System.out.println(photoList);
//	      System.out.println(user);
	      
	      
	      
	      /* 사진 게시판 작성 비즈니스 로직 처리할 서비스 요청 */
	      int result = new MagazineService().insertUser(user);
	      
	     
	      
	      if(result > 0) {
	    	  
	    	  // 사진 게시판 목록 재요청
	    	  response.sendRedirect(request.getContextPath() + "/user/list");
	    	  
	      } else {
	    	
	    	  // 실패시 자동 저장된 사진을 삭제해 줘야 함
	    	  // 경로와 파일명을 알면 지워줄 수 있음ㅋ
	    	  for(MagazineFile photo : photoList) {
	    		  File failedFile = new File(savePath + photo.getChangeName());
	    		  failedFile.delete();
	    	  }
	    	  request.setAttribute("message", "사진 게시판 게시글 등록에 실패하였습니다");
	    	  request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
	      }
	   }

}
