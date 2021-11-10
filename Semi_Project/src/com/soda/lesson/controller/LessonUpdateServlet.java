package com.soda.lesson.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import com.soda.lesson.model.service.LessonService;
import com.soda.lesson.model.vo.Attachment;
import com.soda.lesson.model.vo.Lesson;
import com.soda.member.model.vo.Member;

/**
 * Servlet implementation class LessonUpdateServlet
 */
@WebServlet("/lesson/update")
public class LessonUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LessonUpdateServlet() {
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
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("message", "잘못 된 전송입니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
			return; 	// 에러페이지로 이동 후 아래 코드 수행 안 하고 메소드 벗어나게
		}
		
		int maxSize = 1024*1024*10;
		String root = request.getSession().getServletContext().getRealPath("/");
		String savePath = root + "resources\\uploadFiles\\";
		
		MultipartRequest multiRequest 
	 	= new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
	
		Lesson lesson = new Lesson();
		lesson.setnType("클래스");
		lesson.setnNum(Integer.parseInt(multiRequest.getParameter("nNum")));
		lesson.setCtag1(multiRequest.getParameter("bigC"));
		lesson.setCtag2(multiRequest.getParameter("smallC"));
		lesson.setcPrice(Integer.parseInt(multiRequest.getParameter("cPrice")));
		lesson.setnTitle(multiRequest.getParameter("nTitle"));
		lesson.setnContent(multiRequest.getParameter("editordata"));
		lesson.setcTutor(multiRequest.getParameter("tutor_intro"));
		
		if(multiRequest.getParameter("v_date") != null) {
		lesson.setvDate(multiRequest.getParameter("v_date"));
		}
		
		if(multiRequest.getParameter("o_date1") != null && multiRequest.getParameter("o_date2") !=null ) {
		// String으로 받아온 oneday클래스 날짜를 Date로 형변환
		String str1 = multiRequest.getParameter("o_date1");
		String str2 = multiRequest.getParameter("o_date2");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		java.sql.Date oDate1 = null;
		java.sql.Date oDate2 = null;
		try {
			Date d1 = df.parse(str1);
			Date d2 = df.parse(str2);

			long ch1 = d1.getTime();
			long ch2 = d2.getTime();

			oDate1 = new java.sql.Date(ch1);
			oDate2 = new java.sql.Date(ch2);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		lesson.setoDate1(oDate1);
		lesson.setoDate2(oDate2);
		}
		
		lesson.setcTime1(multiRequest.getParameter("class_time1"));
		lesson.setcTime2(multiRequest.getParameter("class_time2"));
		lesson.setcLocation( multiRequest.getParameter("postcode") 
						+ " " + multiRequest.getParameter("address") 
						+ " " + multiRequest.getParameter("detailaddress"));
		lesson.setUserId(((Member)request.getSession().getAttribute("loginUser")).getUserId());
		
		
		/* Attachment 테이블 수정 값 설정 : 고려할 사항이 두가지임  1.기존의 파일이 있을 경우 (덮어쓰기 필요) 2. 기존 파일 없을 경우 (새로 insert) */
		List<Attachment> photoList = new ArrayList<>();
		String[] fileNames = {"cThumbnail", "contentImg1"};  // 수정 후 사진의  name속성 
		String[] changeNames = multiRequest.getParameterValues("changeName"); // 수정 전 사진의 changeName
		
		for(int i = 0; i < fileNames.length; i++) {
			// 넘어온 파일이 없는 경우 수정 사항이 없으므로 continue로 반복문 다음으로 진행
			if(multiRequest.getFilesystemName(fileNames[i]) == null) // 파일 네임이 null = 넘어온 값이 없다
				continue;
			
			// 수정을 위해 첨부 된 파일이 있는 경우
			Attachment photo = new Attachment();
			photo.setRoute("/resources/uploadFiles/");
			photo.setOriginName(multiRequest.getOriginalFileName(fileNames[i]));
			photo.setChangeName(multiRequest.getFilesystemName(fileNames[i]));
			
			if(i == 0) { // 첫번째 사진 = 썸네일 이미지
				photo.setFileLevel(1);
			} else { // 그 외는 내용 이미지
				photo.setFileLevel(2);
			}
			
			// 원래 저장 된 파일이 있었다면  -> DB에서 update 처리  & 서버에서 기존 파일 delte 처리
			if(changeNames.length >= i+1) { // changeNames.length = 최소1 ~ 최대2
				photo.setDeletedName(changeNames[i]);  // 수정 전 기존 파일명을 삭제 이름으로 설정 (덮어쓰기 필요하기 때문에 ) => 원래 저장된 파일이 없다면 deletedName은 null
			} 
			photoList.add(photo);
		}
		
		lesson.setPhotoList(photoList);
		
		int result = new LessonService().updateLesson(lesson);
		
		if(result > 0) {
			// 수정 성공 시 덮어쓰기 된 사진 삭제
			for(Attachment photo : photoList) {
				if(photo.getDeletedName() != null) {
					File deletedFile = new File(savePath + photo.getDeletedName());
					deletedFile.delete();
				}
			}
			response.sendRedirect(request.getContextPath() + "/lesson/detail?nNum=" 
									+ Integer.parseInt(multiRequest.getParameter("nNum")));
		} else {
			// 수정 실패 시 수정을 위해 첨부 된 사진 삭제 => photoList의 모든 파일 
			for(Attachment photo : photoList) {
				File failedFile = new File(savePath + photo.getChangeName());
				failedFile.delete();
			}
			request.setAttribute("message", "클래스 게시글 수정에 실패하였습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
		}
	}

}
