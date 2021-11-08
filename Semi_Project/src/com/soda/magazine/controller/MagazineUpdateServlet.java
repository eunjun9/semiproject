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
import com.soda.magazine.model.vo.Magazine;
import com.soda.magazine.model.vo.MagazineFile;

/**
 * Servlet implementation class MagazineUpdateServlet
 */
@WebServlet("/magazine/update")
public class MagazineUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MagazineUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
	      
	      
	      /* Board 테이블 수정 값 설정*/
	      Magazine magazine = new Magazine();
	      magazine.setnNum(Integer.parseInt(multiRequest.getParameter("nNum")));
	      magazine.setnType(multiRequest.getParameter("category"));
	      magazine.setnTitle(multiRequest.getParameter("title"));
	      magazine.setnContent(multiRequest.getParameter("content"));
	      
	      
	      /* Attachment 테이블 수정 값 설정*/
	      List<MagazineFile> photoList = new ArrayList<>();
	      String[] fileNames = {"thumbnail", "contentImg1", "contentImg2"};
	      String[] changeNames = multiRequest.getParameterValues("changeName");
	      
	      for(int i = 0 ; i < fileNames.length; i++) {
	         // 넘어온 파일이 없는 경우 수정 사항이 없으므로 continue로 반복문 다음으로 진행
	         if(multiRequest.getFilesystemName(fileNames[i])== null)
	            continue;
	        
	         
	         // 수정을 위해 첨부 된 파일이 있는 경우
	         MagazineFile photo = new MagazineFile();
	         photo.setRoute("/resources/images/woo_uploadFiles/");
	         photo.setOriginName(multiRequest.getOriginalFileName(fileNames[i]));
	         photo.setChangeName(multiRequest.getFilesystemName(fileNames[i]));
	         
	        // System.out.println(multiRequest.getOriginalFileName(fileNames[0]));
	        // System.out.println(multiRequest.getFilesystemName(fileNames[0]));
	         if(i == 0 ) {
	            photo.setFileLevel(1);
	         }else {
	            photo.setFileLevel(2);
	         }
	      
	         // 원래 저장된 파일이 있었다면 -> DB에서 update 처리 & 서버에서 기존 파일 delete 처리
	         if(changeNames.length >= i+1) {
	            photo.setDeletedName(changeNames[i]);
//	            System.out.println(changeNames.length);
//	            System.out.println(changeNames[i]);
	         }
	         photoList.add(photo);
	      }
	      magazine.setPhotoList(photoList);
	      
	      
	      
	      int result = new MagazineService().updateMagazine(magazine);
	      
	      
	      
	      if(result> 0) {
	    	 // 수정 성공시 덮어쓰기된 사진 삭제
	    	  for(MagazineFile photo : photoList) {
	    		  if(photo.getDeletedName() != null) {
	    			 File deletedFile = new File(savePath + photo.getDeletedName());
	    			 deletedFile.delete();
	    		  }
	    	  }
	    	  
	         response.sendRedirect(request.getContextPath()+"/magazine/detail?nNum="
	                                 +Integer.parseInt(multiRequest.getParameter("nNum")));
	      }else {
	    	  
	    	 // 수정 실패시 수정을 위해 첨부된 사진 삭제
	    	  for(MagazineFile photo : photoList) {
	    		  File failedFile = new File(savePath + photo.getChangeName());
	    		  failedFile.delete();
	    	  }
	         request.setAttribute("message", "사진 게시글 수정에 실패했습니다.");
	         request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
	      }
	   }
	}

