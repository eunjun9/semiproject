package com.soda.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.member.model.vo.Member;
import com.soda.mypage.model.service.MypageService;
import com.soda.socialing.model.vo.Socialing;

/**
 * Servlet implementation class MypageSocialingList
 */
@WebServlet("/mypage/socialinglist")
public class MypageSocialingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageSocialingList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		
		List<Socialing> socialingListAfter = new MypageService().socialingListAfter(userId);
		List<Socialing> socialingListBefore = new MypageService().socialingListBefore(userId);
		
		request.setAttribute("socialingListAfter", socialingListAfter);
		request.setAttribute("socialingListBefore", socialingListBefore);
		request.getRequestDispatcher("/WEB-INF/views/mypage/mypageSocialingList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
