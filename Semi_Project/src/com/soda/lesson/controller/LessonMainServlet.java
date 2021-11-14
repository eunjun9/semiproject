package com.soda.lesson.controller;

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
import com.soda.lesson.model.vo.Lesson;

/**
 * Servlet implementation class ClassMainServlet
 */
@WebServlet("/lesson/main")
public class LessonMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LessonMainServlet() {
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
		String keyword = request.getParameter("keyword");
		String price1 = request.getParameter("price1");
		String price2 = request.getParameter("price2");
		String bigC = request.getParameter("bigC");
		String smallC = request.getParameter("smallC");
		String oneday = request.getParameter("oneday");
		String vod = request.getParameter("vod");
		//String sort = request.getParameter("classSort");
		
		// 페이징과 관련된 데이터, 조회 된 게시판List를 담아서 map에 리턴
		Map<String, Object> map = new LessonService().selectList(page, new Filter(keyword ,price1, price2, bigC, smallC, oneday, vod));
		
	
		/* 비즈니스 로직 수행 후 */ 
		request.setAttribute("pi", map.get("pi"));
		request.setAttribute("lessonList", map.get("lessonList"));
		request.getRequestDispatcher("/WEB-INF/views/lesson/lessonMain.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}		

}
