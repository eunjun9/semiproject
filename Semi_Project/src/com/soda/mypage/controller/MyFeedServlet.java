package com.soda.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.magazine.model.service.MagazineService;
import com.soda.magazine.model.vo.Magazine;
import com.soda.member.model.vo.Member;
import com.soda.mypage.model.service.ProfileService;
import com.soda.mypage.model.vo.Profile;

/**
 * Servlet implementation class MyFeedServlet
 */
@WebServlet("/myfeed")
public class MyFeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyFeedServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Magazine> userselfList = new MagazineService().selectUserselfList();
		request.setAttribute("userselfList", userselfList);

		ProfileService profileService = new ProfileService();

		String userId = ((Member) request.getSession().getAttribute("loginUser")).getUserId();
		Profile profile = profileService.selectProfile(userId);
		
//		System.out.println(profile);

		
		request.setAttribute("profile", profile);
		request.getRequestDispatcher("/WEB-INF/views/mypage/myfeedMain.jsp").forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
