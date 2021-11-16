package com.soda.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.admin.model.service.AdminService;
import com.soda.admin.model.vo.Refund;
import com.soda.magazine.model.vo.Reply;
import com.soda.member.model.service.MemberService;
import com.soda.member.model.vo.Member;

/**
 * Servlet implementation class memberModify
 */
@WebServlet("/refund/modifyview")
public class RefundModifyView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefundModifyView() {
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
		
		String rAccount = request.getParameter("rAccount");
		String bank = request.getParameter("bank");
		String aHolder = request.getParameter("aHolder");
		String rProcess = request.getParameter("rProcess");
		Int pNum = request.getParameter("pNum");
		
		Refund refund = new Refund();
		refund.setrAccount(rAccount);
		refund.setBank(bank);
		refund.setaHolder(aHolder);
		refund.setrProcess(rProcess);
		refund.setpNum(pNum);
		
		Refund updateRefund = new AdminService().refundModify(refund);
		
		
	//	System.out.println(updateRefund);
		
		
			request.getRequestDispatcher("/WEB-INF/views/admin/refundModify.jsp").forward(request, response);
//			response.sendRedirect(request.getContextPath() + "/mypage/adminmain");
		
		
		
	}

}
