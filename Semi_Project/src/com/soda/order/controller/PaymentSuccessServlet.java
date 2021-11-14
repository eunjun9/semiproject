package com.soda.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.member.model.vo.Member;
import com.soda.order.model.service.PaymentService;
import com.soda.order.model.vo.Payment;

/**
 * Servlet implementation class PaymentSuccessServlet
 */
@WebServlet("/pay/success")
public class PaymentSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentSuccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		String userEmail = request.getParameter("userEmail");

		// System.out.println("결제 후 받아온 값 : " + userId + "/" + userEmail);
		
		int nNum = Integer.parseInt(request.getParameter("nNum"));
		String selectDate = request.getParameter("selDate");		// 원데이 선택 날짜
		String payId = request.getParameter("imp_uid");				// 결제승인번호
		String pg = request.getParameter("pg_provider");			// 결제pg사 (ex. 카카오페이)
		String payPhone = request.getParameter("buyerTel");			// 주문자 연락처
		
		System.out.println(nNum +"/" + selectDate + "/" + 
				payId + "/" + pg + "/" + payPhone);
    	
		// 원데이 선택 날짜 String으로 넘어와서 sql Date로 변환
		java.sql.Date selDate = null;
		if( selectDate != null ) {
			selDate = java.sql.Date.valueOf(selectDate);
		}
		
		Payment payment = new Payment();
		payment.setUserId(userId);
		payment.setPayEmail(userEmail);
		payment.setnNum(nNum);
		payment.setSelectDate(selDate);
		payment.setPayId(payId);
		payment.setPayOption(pg);
		payment.setPayPhone(payPhone);
		
		// 결제하려는 클래스 조회
		// List<WishList> wishList = new WishListService().whsilistPay(nNum, selectDate);

		// 결제한 클래스 insert
		int payInsert = new PaymentService().payInsert(payment);

		 //System.out.println("결제한 클래스 조회" + wishList);
		 System.out.println("insert 결과 " + payInsert);
		 
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(payInsert);

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+"/WEB-INF/views/order/paySuccess.jsp");
	}

}
