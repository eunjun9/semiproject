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
		// 장바구니에 클래스 추가하는 서블릿
		
		int nNum = Integer.parseInt(request.getParameter("nNum"));
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		
		// 테스트
		System.out.println(nNum);
		System.out.println(userId);
		
		WishList wishlist = new WishList();
		wishlist.setnNum(nNum);
		wishlist.setUserId(userId);
		
		
		// 장바구니에 insert하는 로직
		int result = new WishListService().wishListAdd(wishlist);
		

		// insert 성공 시
		if(result > 0) {
			request.setAttribute("message", "장바구니 담기가 완료되었습니다.");
			response.sendRedirect(request.getContextPath() + "/wishlist");
		}
		// insert 실패 시
		else {
			request.setAttribute("message", "장바구니 조회에 실패하였습니다. 다시 시도해주세요.");
			PrintWriter writer = response.getWriter();
			writer.println("<script>history.back();</script>");
			writer.close();
		}
		
	}

}
