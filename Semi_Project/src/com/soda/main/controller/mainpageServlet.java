package com.soda.main.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.lesson.model.service.LessonService;
import com.soda.lesson.model.vo.Filter;
import com.soda.lesson.model.vo.Lesson;
import com.soda.member.model.vo.Member;

import com.soda.socialing.model.service.SocialingService;
import com.soda.socialing.model.vo.Search;
import com.soda.socialing.model.vo.Socialing;


/**
 * Servlet implementation class mainpageServlet
 */
@WebServlet("/mainpage")
public class mainpageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mainpageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Socialing> socialingList = new  SocialingService().socialinglistview();
		
		List<Lesson> lessonList = new LessonService().lessonlistview();
		// System.out.println(lessonList);
		request.setAttribute("socialingList", socialingList);
		
		request.setAttribute("lessonList", lessonList);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/main/mainpage.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
