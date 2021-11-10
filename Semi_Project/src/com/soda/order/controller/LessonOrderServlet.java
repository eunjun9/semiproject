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
 * Servlet implementation class LessonOrderServlet
 */
@WebServlet("/lesson/order")
public class LessonOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LessonOrderServlet() {
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
		
		// 결제하기 누른 게시물 번호 가져오기
		int nNum = Integer.parseInt(request.getParameter("noticeNum"));
		
		Member member = new Member();
		member.setUserName(userName);
		member.setUserPhone(userPhone);
		member.setUserId(userId);
		
		// 클래스 디테일 페이지에서 바로 넘어오는 결제 페이지 조회
		List<WishList> lessonPay = new WishListService().lessonPay(userId, nNum);
		
		System.out.println(lessonPay);

		if (lessonPay != null) { 
			request.setAttribute("wishList", lessonPay);
			request.setAttribute("member", member);
			request.getRequestDispatcher("/WEB-INF/views/order/orderPage.jsp").forward(request, response);
		} else { 
			request.setAttribute("message", "결제 페이지 접속에 실패하였습니다. 다시 시도해주세요.");
			PrintWriter writer = response.getWriter();
			writer.println("<script>history.back();</script>");
			writer.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
