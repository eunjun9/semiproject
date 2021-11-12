package com.soda.order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.order.model.service.WishListService;
import com.soda.order.model.vo.WishList;

/**
 * Servlet implementation class PaymentAfterServlet
 */
@WebServlet("/pay/after")
public class PaymentAfterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentAfterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nNum = Integer.parseInt(request.getParameter("nNum"));
		String selectDate = request.getParameter("selDate");
		
		// 결제한 클래스 조회
		List<WishList> wishList = new WishListService().whsilistPay(nNum, selectDate);

		// System.out.println("결제한 클래스 조회" + wishList);
		
		request.setAttribute("wishList", wishList);
		request.getRequestDispatcher("/WEB-INF/views/order/paySuccess.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
