package com.soda.mypage.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.member.model.vo.Member;
import com.soda.mypage.model.service.MypageService;
import com.soda.mypage.model.service.ProfileService;
import com.soda.mypage.model.vo.Profile;
import com.soda.socialing.model.vo.Socialing;

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
    // 마이페이지 메인 - 관심소셜링, 프로필
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이지 초기값 (첫 페이지)
		int page = 1;

		// 전달 받은 페이지가 있을 때
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		Socialing socialing = new Socialing();
		socialing.setUserId(userId);
		
		Map<String, Object> map = new MypageService().likeSocialingList(page, socialing);
		//List<Socialing> socialingList = new MypageService().likeSocialingList(userId);
		
		/* 프로필 사진 */
	    Profile profile = new MypageService().selectProfile(userId);
		
	    request.setAttribute("profile", profile);
		request.setAttribute("pi", map.get("pi"));
		request.setAttribute("socialingList", map.get("socialingList"));
		request.getRequestDispatcher("/WEB-INF/views/mypage/mypageMain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
