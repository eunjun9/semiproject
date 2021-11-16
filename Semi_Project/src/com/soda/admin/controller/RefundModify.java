package com.soda.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.admin.model.service.AdminService;
import com.soda.admin.model.vo.Refund;

/**
 * Servlet implementation class RefundModify
 */
@WebServlet("/refund/modify")
public class RefundModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefundModify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId= request.getParameter("userId");
		
	
		
		
//		List<Refund> refundList = new AdminService().selectRefundUserList(userId);
		
		Refund refund = new AdminService().selectRefund(userId);
		
//		System.out.println(refund);

		request.setAttribute("refund", refund);
		request.getRequestDispatcher("/WEB-INF/views/admin/refundModify.jsp").forward(request, response);
	}

}
