package com.soda.member.controller;

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
 * Servlet implementation class PwdFindUpdateServlet
 */
@WebServlet(name="PwdFindUpdateServlet", urlPatterns="/find/update")
public class PwdFindUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PwdFindUpdateServlet() {
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
		String randomStr = (String) request.getSession().getAttribute("randomStr");
		String randomPwd = request.getParameter("randomPwd");
		String newPwd = request.getParameter("newPwd");		// 변경할 비밀번호
		String userId = request.getParameter("userId");

		if(!randomStr.equals(randomPwd)){
			request.setAttribute("message", "인증번호가 일치하지 않습니다");
			return;
		}
		
		// 비즈니스 로직 수행 (DB update)
		Member findPwdUpdate = new MemberService().findPwdUpdate(userId, newPwd);
		
		if(findPwdUpdate != null) {
			// 비밀번호 수정이 잘 되었음을 result success로 표시
			request.setAttribute("result", "success");
			// 수정된 loginUser 다시 session에 저장
			request.getSession().setAttribute("loginUser", findPwdUpdate);
		} else {
			// 비밀번호 수정에 실패했음을 result fail로 표시
			request.setAttribute("result", "fail");
		}
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/pwdUpdateForm.jsp");
		view.forward(request, response);
	}

}
