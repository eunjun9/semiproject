package com.soda.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.member.model.service.MemberService;
import com.soda.member.model.vo.Member;

/**
 * Servlet implementation class MypageUserInfoModifyServlet
 */
@WebServlet("/mypage/userinfomodify")
public class MypageUserInfoModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageUserInfoModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/mypage/userinfoModify.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		
		Member member = new Member(userId, userName, userPhone);
		
		System.out.println("수정할 정보 : " + member);
		
		Member updatedMember = new MemberService().updateMember(member);
		
		System.out.println("수정 된 정보 : " + updatedMember);
		
		if(updatedMember != null) {
			
			request.getSession().setAttribute("message", "회원 정보 수정이 완료되었습니다.");
			request.getSession().setAttribute("loginUser", updatedMember);
			response.sendRedirect(request.getContextPath() + "/mainpage");
		
		} else { /* 회원 정보 수정 실패 시 */
			request.setAttribute("message", "회원 정보 수정에 실패하였습니다.");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp");
			view.forward(request, response);
		}
	}

}
