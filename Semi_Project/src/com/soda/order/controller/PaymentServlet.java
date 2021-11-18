package com.soda.order.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.member.model.vo.Member;
import com.soda.order.model.service.WishListService;
import com.soda.order.model.vo.WishList;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		String userName = ((Member)request.getSession().getAttribute("loginUser")).getUserName();
		String userPhone = ((Member)request.getSession().getAttribute("loginUser")).getUserPhone();
		String selDate = request.getParameter("selDate");
		
		
		// 신청하기 누른 장바구니 클래스 번호 가져오기
		int nNum = Integer.parseInt(request.getParameter("noticeNum"));
		
		Member member = new Member();
		member.setUserName(userName);
		member.setUserPhone(userPhone);
		member.setUserId(userId);

		// 결제하려는 클래스 조회
		List<WishList> wishList = new WishListService().whsilistPay(nNum, selDate);

		int totalPrice = 0;
		for(WishList cart : wishList) {
		    int price = cart.getcPrice();
		    totalPrice += price;
		}
		
		if (wishList != null) { 
			request.setAttribute("wishList", wishList);
			request.setAttribute("member", member);
			request.setAttribute("totalPrice", totalPrice);
			request.setAttribute("selDate", selDate);
			request.setAttribute("nNum", nNum);
			request.getRequestDispatcher("/WEB-INF/views/order/orderPage.jsp").forward(request, response);
		} else { 
			PrintWriter writer = response.getWriter();
			writer.print("<script>alert('결제 페이지 접속에 실패하였습니다. 다시 시도해주세요.'); </script>");
			writer.println("<script>history.back();</script>");
			writer.close();
		}

	
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
