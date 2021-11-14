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
/*
		request.setCharacterEncoding("UTF-8");
		
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		
		String refundAccount = request.getParameter("refundAccount");
		String bank = request.getParameter("bank");
		String accountHolder = request.getParameter("accountHolder");
		
		Refund refund = new Refund();
		refund.setRefundAccount(refundAccount);
		refund.setBank(bank);
		refund.setAccountHolder(accountHolder);
		refund.setUserId(userId);
		
		// System.out.println("수정할 정보 : " + member);
		
		Refund insertRefundInfo = new RefundService().insertRefundInfo(refund);
		
		// System.out.println("수정 된 정보 : " + updatedMember);
		
		if(insertRefundInfo != null) {
			
			request.getSession().setAttribute("message", "환불 접수가 완료되었습니다.");
			request.getSession().setAttribute("loginUser", insertRefundInfo);
			response.sendRedirect(request.getContextPath() + "/mypage/main");
		
		} else {  회원 정보 수정 실패 시 
			request.setAttribute("message", "환불 접수가 실패하였습니다.");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp");
			view.forward(request, response);
		}
 */
		
	}
}
