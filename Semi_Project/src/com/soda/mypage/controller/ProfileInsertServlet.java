package com.soda.mypage.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.member.model.vo.Member;
import com.soda.mypage.model.service.ProfileService;
import com.soda.mypage.model.vo.Profile;



/**
 * Servlet implementation class ProfileInsertServlet
 */
@WebServlet("/profile/insert")
public class ProfileInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 

		String userId = ((Member) request.getSession().getAttribute("loginUser")).getUserId();
		
		


		ProfileService profileService = new ProfileService();

		
		// 사용자 본인이 올린 사진 및 정보 알려줌
		Profile profile = profileService.selectProfile(userId);
		
		
		request.setAttribute("profile", profile);
		request.getRequestDispatcher("/WEB-INF/views/mypage/profileInsert.jsp").forward(request, response);
	   
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
