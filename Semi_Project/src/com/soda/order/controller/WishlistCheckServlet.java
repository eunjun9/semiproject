package com.soda.order.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soda.order.model.service.WishListService;

/**
 * Servlet implementation class WishlistCheckServlet
 */
@WebServlet("/wishlist/check")
public class WishlistCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishlistCheckServlet() {
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
		request.setCharacterEncoding("utf-8");
		// 세션에서 userId 가져오기
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId"); 
		
		// request로 넘겨받은 게시물 번호
		int nNum = Integer.parseInt(request.getParameter("nNum"));
		
		// 장바구니에 이미 추가한 클래스인지 확인하는 비즈니스 로직
		int wishListCheck = new WishListService().wishListCheck(nNum, userId);
		
		// ajax로 리턴
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(wishListCheck);
		
	}


}
