package com.soda.order.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soda.order.model.service.WishListService;
import com.soda.order.model.vo.WishList;

/**
 * Servlet implementation class WishListAddServlet
 */
@WebServlet("/wishlist/add")
public class WishListAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishListAddServlet() {
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
		
		WishList lessonAdd = new WishList();
		lessonAdd.setnNum(Integer.parseInt(request.getParameter("nNum")));
		lessonAdd.setUserId((String)session.getAttribute("userId"));
		
		// 장바구니에 insert하는 로직
		int wishListAdd = new WishListService().wishListAdd(lessonAdd);
		
		PrintWriter out = response.getWriter();
		out.println(wishListAdd);
		

	}

}
