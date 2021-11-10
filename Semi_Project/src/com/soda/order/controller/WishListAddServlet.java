package com.soda.order.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soda.member.model.vo.Member;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 장바구니에 클래스 추가하는 서블릿
		int nNum = Integer.parseInt(request.getParameter("noticeNum"));
		// 원데이클래스는 사용자가 직접 원하는 날짜 선택하기때문에 선택한 날짜 받아오기
		String selDate = request.getParameter("selDate");
		
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();

		// 테스트
		System.out.println("nNum : " + nNum);
		System.out.println("userId : " + userId);
		System.out.println("selDate : " + selDate);

		WishList wishlist = new WishList();
		wishlist.setnNum(nNum);
		wishlist.setUserId(userId);
		wishlist.setlessonDate(selDate);
		
		// 장바구니에 insert하고 바로 리스트 조회해오기
		List<WishList> wishList = new WishListService().wishListAdd(wishlist);

		if (wishList != null) { /* 장바구니 insert 성공 시 */
			request.setAttribute("wishList", wishList);
			response.sendRedirect(request.getContextPath() + "/wishlist");
		} else { /* 장바구니 insert 실패 시 */
			request.setAttribute("message", "장바구니 추가에 실패하였습니다. 다시 시도해주세요.");
			PrintWriter writer = response.getWriter();
			writer.println("<script>history.back();</script>");
			writer.close();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
