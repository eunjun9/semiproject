package com.soda.socialing.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import com.soda.member.model.vo.Member;
import com.soda.socialing.model.service.SocialingService;
import com.soda.socialing.model.vo.Socialing;
import com.soda.socialing.model.vo.SodaFile;
import com.sun.xml.internal.ws.api.message.Attachment;

/**
 * Servlet implementation class SocialingFormServlet
 */
@WebServlet("/socialing/form")
public class SocialingFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocialingFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/socialing/socialingForm.jsp").forward(request, response);
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
		String savePath = root + "resources\\uploadFiles\\"; // \는 이스케이프 처리
		
		/* HttpServletRequest => MultipartRequest 타입으로 변경 */
		MultipartRequest multiRequest 
			= new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
		// 요청, 저장할 경로, 최대 용량, 인코딩 타입, 파일의 리네임 규칙에 따라 리네임하는 객체(cos.jar)
		
		/* DB에 데이터 저장 */
		String stitle = multiRequest.getParameter("inputTitle");
		String scontent = multiRequest.getParameter("content");
		String sdate = multiRequest.getParameter("dateIn");		// ex. 2021-11-03
		String stime = multiRequest.getParameter("timeIn");		// ex. 13:10:20 (오후 1:10:20)
		String stype = multiRequest.getParameter("place");
		String splace = multiRequest.getParameter("inputPlace");
		int maxMember = Integer.parseInt(multiRequest.getParameter("max"));
		String bwriter = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		
		// 년월일시분초 잘라내기
		int ydate = Integer.parseInt(sdate.substring(0,4));
		int mdate = Integer.parseInt(sdate.substring(5,7));
		int ddate = Integer.parseInt(sdate.substring(8));
		int htime = Integer.parseInt(stime.substring(0,2));
		int mtime = Integer.parseInt(stime.substring(3,5));
		int sectime = Integer.parseInt(stime.substring(6));
		// sdate, stime 합쳐서 Date 타입으로 파싱
		Calendar formatDate = new GregorianCalendar(ydate, mdate, ddate, htime, mtime, sectime);
		
		Socialing socialing = new Socialing();
		socialing.setnTitle(stitle);
		socialing.setnContent(scontent);
		socialing.setSdate(formatDate.getTime());
		socialing.setStype(stype);
		socialing.setSplace(splace);
		socialing.setnType("소셜링");
		
		// 첨부파일 썸네일로 받아오기
		List<SodaFile> photo = new ArrayList<>();
		String fileName = "thumbnail";
		
		SodaFile thumbnail = new SodaFile();
		thumbnail.setRoute("/resources/uploadFiles/");
		/* getOriginalFileName() : 실제 사용자가 업로드 한 파일명 */
		thumbnail.setOriginName(multiRequest.getOriginalFileName(fileName));
		/* getFilesystemName() : MyRenamePolicy의 rename 메소드에서 작성한대로 rename 된 파일명 */
		thumbnail.setChangeName(multiRequest.getFilesystemName(fileName));
		
		/* socialing에 만들어진 File 데이터 설정 */
		socialing.setPhotoList(photo);
		
		/* 게시판 작성 비즈니스 로직 처리할 서비스 요청 */
		int result = new SocialingService().insertSocialing(socialing);

		if(result > 0) {
			// 게시판 목록 재요청
			response.sendRedirect(request.getContextPath() + "/socialing/main");
		} else {
			// 실패 시 저장 된 사진 삭제
			for(SodaFile p : photo) {
				File failedFile = new File(savePath + p.getChangeName());
				failedFile.delete();
			}
			request.setAttribute("message", "사진 게시판 게시글 등록에 실패하였습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
		}
	}

}
