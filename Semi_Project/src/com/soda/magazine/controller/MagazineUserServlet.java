package com.soda.magazine.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.lesson.model.service.LessonService;
import com.soda.lesson.model.vo.Filter;
import com.soda.magazine.model.service.MagazineService;
import com.soda.magazine.model.vo.Magazine;
import com.soda.socialing.model.service.SocialingService;
import com.soda.socialing.model.vo.Search;

/**
 * Servlet implementation class MagazineUserServlet
 */
@WebServlet("/user/list")
public class MagazineUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MagazineUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		/* 페이징 처리 */
		// 페이지 초기값 (첫 페이지)
		int page = 1;
		
		// 전달 받은 페이지가 있을 때 
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
//		/* 필터 관련 파라미터 추출 */
//		String keyword = request.getParameter("keyword");	// 키워드 검색
//		String local = request.getParameter("local");		// 지역
////		String dateIn = request.getParameter("dateIn");		// 날짜
//		String onoff = request.getParameter("onoff");		// 온오프라인
		
//		String startDate = "";
//	      String date2 = "";
//	      LocalDate endDate2 = null;
//	      String endDate = "";
//	      if(request.getParameter("endDate") != null && !request.getParameter("endDate").equals("")) {
//	         startDate = request.getParameter("startDate");
//	         date2 = request.getParameter("endDate");
//	         String[] e = date2.split("-");
//	         int d1 = Integer.parseInt(e[0]);
//	         int d2 = Integer.parseInt(e[1]);
//	         int d3 = Integer.parseInt(e[2]);
//	         endDate2 = LocalDate.of(d1, d2, d3);
//	         endDate2 = endDate2.plusDays(1);
//	         System.out.println(endDate2);
//	         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
//	         endDate = endDate2.format(formatter);   // String 형 변환
//	      }
		
//		/* 정렬 관련 파라미터 추출 */
//		String sort = request.getParameter("lineup");
		
		// 페이징과 관련된 데이터, 조회 된 게시판 List를 담아서 map에 리턴
//		Map<String, Object> map = new SocialingService().selectList(page);
		Map<String, Object> map = new MagazineService().selectList(page);
		
		request.setAttribute("pi", map.get("pi"));	
		
		
		
		
		
		
		
		
		
		
		
		
	List<Magazine> userList = new MagazineService().selectUserList();
	
//	System.out.println(boardList);
	
	request.setAttribute("userList", userList);
	request.getRequestDispatcher("/WEB-INF/views/magazine/magazineUser.jsp").forward(request, response);
//	System.out.println(magazineList);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
