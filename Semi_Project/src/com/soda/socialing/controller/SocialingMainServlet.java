package com.soda.socialing.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.lesson.model.service.LessonService;
import com.soda.socialing.model.service.SocialingService;
import com.soda.socialing.model.vo.Search;
import com.soda.socialing.model.vo.Socialing;

/**
 * Servlet implementation class SocialingMainServlet
 */
@WebServlet("/socialing/main")
public class SocialingMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocialingMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 페이징 처리 */
		// 페이지 초기값 (첫 페이지)
		int page = 1;
		
		// 전달 받은 페이지가 있을 때 
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		/* 필터 관련 파라미터 추출 */
//		String keyword = request.getParameter("keyword");	// 키워드 검색
//		String local = request.getParameter("local");		// 지역
//		String dateIn = request.getParameter("dateIn");		// 날짜 (ex. 2021-11-03)
//		String onoff = request.getParameter("onoff");		// 온/오프라인
		
		// 날짜 Date 타입으로 변환
//		Date date = Date.valueOf(dateIn);
		
		// 페이징과 관련된 데이터, 조회 된 게시판 List를 담아서 map에 리턴
		Map<String, Object> map = new SocialingService().selectList(page);
//		Map<String, Object> map = new SocialingService().selectList(page, new Search(keyword, local, dateIn.getTime(), onoff));
		
		request.setAttribute("pi", map.get("pi"));
		request.setAttribute("socialingList", map.get("socialingList"));
		request.getRequestDispatcher("/WEB-INF/views/socialing/socialingMainView.jsp").forward(request, response);
		
//		List<Socialing> socialingList = new SocialingService().selectList();
//		request.setAttribute("socialingList", socialingList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
