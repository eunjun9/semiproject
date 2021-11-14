package com.soda.mypage.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.lesson.model.vo.Lesson;
import com.soda.member.model.vo.Member;
import com.soda.mypage.model.service.MypageService;
import com.soda.order.model.vo.Payment;

/**
 * Servlet implementation class MypagePayListServlet
 */
@WebServlet("/mypage/paylist")
public class MypagePayListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypagePayListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/mypage/mypagePayList.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
		
		
		Payment payment = new Payment();
		payment.setUserId(userId);
		payment.setPayListDate1(date1);
		payment.setPayListDate2(date2);
		
		List<Lesson> lessonList = new MypageService().selectpayList(payment);
		
		
		request.setAttribute("lessonList", lessonList);
		request.setAttribute("payment", payment);
		request.getRequestDispatcher("/WEB-INF/views/mypage/mypagePayListResult.jsp").forward(request, response);
	}

}
