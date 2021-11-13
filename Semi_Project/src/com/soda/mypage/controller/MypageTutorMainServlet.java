package com.soda.mypage.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.lesson.model.vo.Lesson;
import com.soda.member.model.vo.Member;
import com.soda.mypage.model.service.MypageService;
import com.soda.mypage.model.vo.Profile;

/**
 * Servlet implementation class MypageTutorMainServlet
 */
@WebServlet("/mypage/tutormain")
public class MypageTutorMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageTutorMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		List<Lesson> lessonList = new MypageService().selectLessonList(user);
		
		Profile profile = new MypageService().selectProfile(user);
		
		request.setAttribute("profile", profile);
		request.setAttribute("lessonList", lessonList);
		request.getRequestDispatcher("/WEB-INF/views/mypage/mypageMainTutor.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
