package com.soda.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.member.model.vo.Member;
import com.soda.mypage.model.service.MypageService;
import com.soda.mypage.model.service.ProfileService;
import com.soda.mypage.model.vo.Profile;

/**
 * Servlet implementation class MypageMainServlet
 */
@WebServlet("/mypage/main")
public class MypageMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // 마이페이지 메인 - 프로필
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("/WEB-INF/views/mypage/mypageMain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// 마이페이지 메인 - 관심 소셜링
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		
	      Profile profile = new MypageService().selectProfile(userId);
		
			request.setAttribute("profile", profile);
			request.getRequestDispatcher("/WEB-INF/views/mypage/mypageMain.jsp").forward(request, response);
	}

}
