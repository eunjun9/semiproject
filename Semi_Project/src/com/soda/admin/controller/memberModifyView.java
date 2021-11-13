package com.soda.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.magazine.model.vo.Reply;
import com.soda.member.model.service.MemberService;
import com.soda.member.model.vo.Member;

/**
 * Servlet implementation class memberModify
 */
@WebServlet("/member/modifyview")
public class memberModifyView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberModifyView() {
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
		
		
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String grade = request.getParameter("grade");
		String account = request.getParameter("account");
	
		
		
		
		Member member = new Member();
		member.setUserId(userId);
		member.setUserName(name);
		member.setUserPhone(phone);
		member.setGender(gender);
		member.setUserGrade(grade);
		member.setStatus(account);
		
		
		Member updatedMember = new MemberService().memberModify(member);
		
//		System.out.println(updatedMember);
	
			request.setAttribute("updatedMember", updatedMember);
			response.sendRedirect(request.getContextPath() + "/mypage/adminmain");
		
		
		
	}

}
