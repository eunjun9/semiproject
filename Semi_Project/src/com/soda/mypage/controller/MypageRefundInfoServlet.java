package com.soda.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.member.model.service.MemberService;
import com.soda.member.model.vo.Member;
import com.soda.mypage.model.service.MypageService;

/**
 * Servlet implementation class MypageUserInfoModifyServlet
 */
@WebServlet("/mypage/refundinfo")
public class MypageRefundInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageRefundInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		
		 int result = new MypageService().selectpayCancelList(pNum);
		
		 if(result > 0) {
			 request.getRequestDispatcher("/WEB-INF/views/mypage/refundinfo.jsp").forward(request, response);
		 }
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
