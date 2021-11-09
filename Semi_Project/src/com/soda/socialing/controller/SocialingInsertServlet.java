package com.soda.socialing.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
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

/**
 * Servlet implementation class SocialingFormServlet
 */
@WebServlet("/socialing/form")
public class SocialingInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocialingInsertServlet() {
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
		
		int maxSize = 1024*1024*10;
		
		String root = request.getSession().getServletContext().getRealPath("/");
		String savePath = root + "resources\\uploadFiles\\";
		
		MultipartRequest multiRequest 
			= new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
		
		String stitle = multiRequest.getParameter("inputTitle");				// 글 제목
		String scontent = multiRequest.getParameter("content");					// 본문
		String sdate = multiRequest.getParameter("dateIn");						// 모임 날짜 (ex. 2021-11-03)
		String stime = multiRequest.getParameter("timeIn");						// 모임 시간 (ex. 13:10)
		String stype = multiRequest.getParameter("type");						// 온라인/오프라인
		String[] splaceArr = multiRequest.getParameterValues("inputPlace");		// 모임 장소
		int minMember = Integer.parseInt(multiRequest.getParameter("min"));		// 최소 참여 인원
		int maxMember = Integer.parseInt(multiRequest.getParameter("max"));		// 최대 참여 인원
		String swriter = ((Member)request.getSession().getAttribute("loginUser")).getUserId();	// 작성자 아이디
		
		// 주소 문자열 합치기
		String splace = "";
		if(splaceArr != null && !splaceArr[0].equals("") && !splaceArr[1].equals(""))
			splace = String.join("|", splaceArr);
		else
			splace = splaceArr[0]; // 온라인 모임일 경우 (상세 주소 x)
		
		// 모임 날짜 String -> Date로 변경
		Date date = Date.valueOf(sdate);
		
		Socialing socialing = new Socialing();
		socialing.setnTitle(stitle);
		socialing.setnContent(scontent);
		socialing.setSdate(date);
		socialing.setStime(stime);
		socialing.setStype(stype);
		socialing.setSplace(splace);
		socialing.setnType("소셜링");
		socialing.setMinMember(minMember);
		socialing.setMaxMember(maxMember);
		socialing.setUserId(swriter);
		
		// 첨부파일 썸네일로 받아오기
		List<SodaFile> photo = new ArrayList<>();
		String fileName = "thumbnail";
		
		SodaFile thumbnail = new SodaFile();
		thumbnail.setRoute("/resources/uploadFiles/");
		/* getOriginalFileName() : 실제 사용자가 업로드 한 파일명 */
		thumbnail.setOriginName(multiRequest.getOriginalFileName(fileName));
		/* getFilesystemName() : MyRenamePolicy의 rename 메소드에서 작성한대로 rename 된 파일명 */
		thumbnail.setChangeName(multiRequest.getFilesystemName(fileName));
		/* 썸네일만 첨부 */
		thumbnail.setFileLevel(1);
		
		/* thumbnail 객체가 photo에 담김 */
		photo.add(thumbnail);
		
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
