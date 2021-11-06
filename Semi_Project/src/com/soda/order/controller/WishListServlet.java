package com.soda.order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
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
		// 장바구니 리스트 출력 화면 서블릿
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId"); 
		
		List<WishList> wishlist = new WishListService().wishlistList(userId);

		request.setAttribute("wishlist", wishlist);
		request.getRequestDispatcher("/WEB-INF/views/member/wishListPage.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

}
