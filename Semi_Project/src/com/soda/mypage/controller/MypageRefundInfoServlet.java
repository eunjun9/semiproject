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
import com.soda.order.model.vo.Payment;

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
		int nNum = Integer.parseInt(request.getParameter("nNum"));
		
		 int result = new MypageService().selectpayCancelList(pNum);
		
		 if(result > 0) {
			 request.setAttribute("pNum", pNum);
			 request.setAttribute("nNum", nNum);
			 request.getRequestDispatcher("/WEB-INF/views/mypage/refundinfo.jsp").forward(request, response);
		 }
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		
		String refundAccount = request.getParameter("refundAccount");
		String bank = request.getParameter("bank");
		String accountHolder = request.getParameter("accountHolder");
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		int nNum = Integer.parseInt(request.getParameter("nNum"));
		
		Payment payment = new Payment();
		payment.setRefundAccount(refundAccount);
		payment.setRefundBank(bank);
		payment.setAccountHolder(accountHolder);
		payment.setPayNum(pNum);
		payment.setnNum(nNum);
		
		int result = new MypageService().insertRefundInfo(payment);
		
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/mypage/main" );
		
		} else {  //회원 정보 수정 실패 시 
			request.setAttribute("message", "환불 접수가 실패하였습니다.");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp");
			view.forward(request, response);
		}

		
	}

}
