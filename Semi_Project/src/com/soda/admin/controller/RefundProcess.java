package com.soda.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.admin.model.service.AdminService;
import com.soda.member.model.service.MemberService;
import com.soda.member.model.vo.Member;

/**
 * Servlet implementation class memberGrade
 */
@WebServlet("/refund/process")
public class RefundProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefundProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @param check 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, String check) throws ServletException, IOException {
		
		
		String[] chbUserIdArr = request.getParameterValues(check);
		
		String chbUserId = "";

		if (chbUserIdArr != null) {
			chbUserId = String.join("|", chbUserIdArr);
		}
		
		
		
		// 사용자 정보 불러오기
		AdminService adminService = new AdminService();
				
				
		adminService.selectRefund(chbUserId);
		
		
		
		request.setAttribute("member1", adminService);
		request.getRequestDispatcher("/WEB-INF/views/admin/refundProcess.jsp").forward(request, response);
		
		
		
		
		String userId = ((Member) request.getSession().getAttribute("loginUser")).getUserId();
		String grade = request.getParameter("grade");
		String account = request.getParameter("account");
	
		
		Member member2 = new Member();
		member2.setUserId(userId);
		member2.setUserGrade(grade);
		member2.setStatus(account);
		
		Member updatedMember = new MemberService().memberGrade(member2);
		
		
	
			request.setAttribute("updatedMember", updatedMember);
			response.sendRedirect(request.getContextPath() + "/mypage/refund");
	}

}
