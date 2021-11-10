package com.soda.order.controller;

import java.io.IOException;
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
 * Servlet implementation class WishListServlet
 */
@WebServlet("/wishlist")
public class WishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		
		// 테스트
		//System.out.println(userId);
		
		List<WishList> wishList = new WishListService().wishlistList(userId);

		// 장바구니 총 합계 금액
		int totalPrice = 0;
		for(WishList cart : wishList) {
		    int price = cart.getcPrice();
		    totalPrice += price;
		  }
		
		// 테스트
		// System.out.println(totalPrice);

			if(wishList != null) {
				request.setAttribute("wishList", wishList);
				request.setAttribute("totalPrice", totalPrice);
				request.getRequestDispatcher("/WEB-INF/views/order/wishListPage.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "장바구니 조회에 실패하였습니다.");
				request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
			}
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	}
