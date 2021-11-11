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
@WebServlet("/member/modify")
public class memberModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberModify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String userId = ((Member) request.getSession().getAttribute("loginUser")).getUserId();
		
		MemberService memberService = new MemberService();
		
		// 사용자 정보 불러오기
		Member member = memberService.selectAdminMember(userId);
		
		request.setAttribute("member", member);
		request.getRequestDispatcher("/WEB-INF/views/admin/memberModify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = ((Member) request.getSession().getAttribute("loginUser")).getUserId();
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		
		Member member = new Member();
		member.setUserId(userId);
		member.setUserName(name);
		member.setUserPhone(phone);
		member.setGender(gender);
		
		Member updatedMember = new MemberService().memberModify(member);
		
		
		System.out.println(updatedMember);
	
			request.setAttribute("updatedMember", updatedMember);
			request.getRequestDispatcher("/WEB-INF/views/admin/memberModify.jsp").forward(request, response);
	
		
		
		
		
	}

}
