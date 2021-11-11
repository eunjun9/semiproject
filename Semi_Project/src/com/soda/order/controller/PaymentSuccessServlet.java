package com.soda.order.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.soda.member.model.vo.Member;
import com.soda.order.model.service.PaymentService;
import com.soda.order.model.service.WishListService;
import com.soda.order.model.vo.Payment;
import com.soda.order.model.vo.WishList;

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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		String userEmail = request.getParameter("email");

		System.out.println("결제완료 : " + userId + userEmail);
		
		
		int nNum = Integer.parseInt(request.getParameter("noticeNum"));
		String selectDate = request.getParameter("selDate");		// 원데이 선택 날짜
		int payNum = Integer.parseInt(request.getParameter("imp_uid"));		// 주문 번호
		String pg = request.getParameter("pg_provider");		// 결제사 (ex. 카카오페이)
		String userPhone = request.getParameter("buyer_tel");	// 주문자 연락처
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date SelDate = null;
		try {
			SelDate = (Date) formatter.parse(selectDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Payment payment = new Payment();
		payment.setUser_id(userId);
		payment.setPayEmail(userEmail);
		payment.setNotice_num(nNum);
		payment.setSelectDate(SelDate);
		payment.setPayNum(payNum);
		payment.setPayOption(pg);
		payment.setPayPhone(userPhone);
		
		// 결제한 클래스 조회
		List<WishList> wishList = new WishListService().wishlistList(nNum);

		// 결제한 클래스 insert
		int payInsert = new PaymentService().payInsert(payment);

		 System.out.println("결제한 클래스 조회" + wishList);
		 
		 response.setContentType("application/json; charset=utf-8");
			new Gson().toJson(payInsert, response.getWriter());

	//	if (payInsert > 0) { 
			//	request.setAttribute("payInsert", payInsert);
			//	request.setAttribute("wishList", wishList);
			//	request.getRequestDispatcher("/WEB-INF/views/order/paySuccess.jsp").forward(request, response);
		//} else { 
		//	request.setAttribute("message", "결제 내역 조회에 실패하였습니다. 마이페이지에서 확인해주세요.");
		//	request.getRequestDispatcher("/WEB-INF/views/main/mainpage.jsp").forward(request, response);
		//}
	}

}
