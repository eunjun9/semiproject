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
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import com.soda.lesson.model.service.LessonService;
import com.soda.lesson.model.vo.Attachment;
import com.soda.lesson.model.vo.Lesson;
import com.soda.member.model.vo.Member;

/**
 * Servlet implementation class LessonInsertServlet
 */
@WebServlet("/lesson/insert")
public class LessonInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LessonInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // 작성 폼으로 넘어가는 서블렛
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/lesson/lessonForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// 작성 폼에서 작성 후 작성한 글 상세페이지로 넘어가는 서블렛
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("message", "잘못 된 전송입니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
			return; 	// 인코딩 설정 안 됐을 땐 더이상 코드 실행 안 되게고 끝내게 return
		}
		
		int maxSize = 1024*1024*10;
		String root = request.getSession().getServletContext().getRealPath("/");
		String savePath = root + "resources\\uploadFiles\\";  
		
		MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, 
							"UTF-8" , new MyFileRenamePolicy());
		
		String bigC = multiRequest.getParameter("bigC");
		String smallC = multiRequest.getParameter("smallC");
		int cPrice = Integer.parseInt(multiRequest.getParameter("cPrice"));
		String nTitle = multiRequest.getParameter("nTitle");
		String cCategory = multiRequest.getParameter("class_type");
		String nContent = multiRequest.getParameter("editordata");
		String tInfo = multiRequest.getParameter("tutor_intro");
		String vDate = multiRequest.getParameter("v_date");
		
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
		
		String ctime1 = multiRequest.getParameter("class_time1");
		String ctime2 = multiRequest.getParameter("class_time2");
		String cLocation = multiRequest.getParameter("postcode") 
						+ " " + multiRequest.getParameter("address") 
						+ " " + multiRequest.getParameter("detailaddress");
		String cwriter = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		
		Lesson lesson = new Lesson();
		lesson.setnType("클래스");
		lesson.setCtag1(bigC);
		lesson.setCtag2(smallC);
		lesson.setcPrice(cPrice);
		lesson.setnTitle(nTitle);
		lesson.setcCategory(cCategory);
		lesson.setnContent(nContent);
		lesson.setcTutor(tInfo);
		lesson.setvDate(vDate);
		lesson.setoDate1(oDate1);
		lesson.setoDate2(oDate2);
		lesson.setcTime1(ctime1);
		lesson.setcTime2(ctime2);
		lesson.setcLocation(cLocation);
		lesson.setUserId(cwriter);
		
		
		List<Attachment> photoList = new ArrayList<>();
		String[] fileNames = {"cThumbnail", "contentImg1", "contentImg2"};
		
		for(int i =0; i < fileNames.length; i++ ) {
			if(multiRequest.getFilesystemName(fileNames[i]) == null)  
				continue;
			
			Attachment attachment = new Attachment();
			attachment.setRoute("/resources/uploadFiles/");
			
			/* getOriginFileName() : 실제 사용자가 업로드한 파일명*/
			attachment.setOriginName(multiRequest.getOriginalFileName(fileNames[i]));
			/* getFilesystemName() : MyRenamePolicy의 rename 메소드에 작성한대로 rename 된 파일명*/
			attachment.setChangeName(multiRequest.getFilesystemName(fileNames[i]));
			/* thumbnail file_level => 0, contentImg file_level => 1 */
			if( i == 0 ) {
				attachment.setFileLevel(1);
			} else {
				attachment.setFileLevel(2);
			}
			
			/* 파일이 첨부된 개수만큼 attachment 객체가 photoList에 담김 */
			photoList.add(attachment);
		}
		
			lesson.setPhotoList(photoList);
			System.out.println(lesson);
			
			int result = new LessonService().insertLesson(lesson);
			
			if(result > 0 ) {
				// 클래스 메인 재요청
				response.sendRedirect(request.getContextPath() + "/lesson/main");
			} else {
				// 실패 시 저장된 사진 삭제 : 경로와 변경된 이름 필요
				for(Attachment photo : photoList) {
					File failedFile = new File(savePath + photo.getChangeName());   // java.io 임포트
					failedFile.delete();	// 메모리상에 저장된 파일 delete()메소드로 삭제 가능
				}
				// 사진 삭제 후 에러페이지로 이동
				request.setAttribute("message", "클래스 등록에 실패하였습니다.");
				request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
			}
	}
}
