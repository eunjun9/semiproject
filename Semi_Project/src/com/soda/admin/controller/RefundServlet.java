package com.soda.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.member.model.service.MemberService;
import com.soda.member.model.vo.Member;
import com.soda.mypage.model.service.RefundService;
import com.soda.mypage.model.vo.Refund;

/**
 * Servlet implementation class RefundServlet
 */
@WebServlet("/admin/refund")
public class RefundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RefundServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		//int pNum = Integer.parseInt(request.getParameter("pNum"));

		//request.setAttribute("pNum", pNum);
		request.getRequestDispatcher("/WEB-INF/views/admin/refundView.jsp").forward(request, response);
		// request.getRequestDispatcher("/WEB-INF/views/mypage/PayList.jsp").forward(request,
		// response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
