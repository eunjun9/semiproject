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
 * Servlet implementation class PwdModifyServlet
 */
@WebServlet(name="PwdModifyServlet", urlPatterns="/pwdModify")
public class PwdModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PwdModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 팝업창 화면 보여주기
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/mypage/pwdModifyForm.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 값 인코딩 생략
		// 요청에 담긴 값 추출
		String userPwd = request.getParameter("userPwd");	// 현재 비밀번호
		String newPwd = request.getParameter("newPwd");		// 변경할 비밀번호
		// 세션에 저장된 loginUser를 통해 userNo 추출
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		
		// 비즈니스 로직 수행 (DB update)
		Member updatedMember = new MemberService().updatePwd(userId, userPwd, newPwd);
		
		// System.out.println(updatedMember);
		// 수정 실패 시 null
		// 수정 성공 시 updatedMember
		
		if(updatedMember != null) {
			// 비밀번호 수정이 잘 되었음을 result success로 표시
			request.setAttribute("result", "success");
			// 수정된 loginUser 다시 session에 저장
			request.getSession().setAttribute("loginUser", updatedMember);
		} else {
			// 비밀번호 수정에 실패했음을 result fail로 표시
			request.setAttribute("result", "fail");
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/pwdModifyForm.jsp");
		view.forward(request, response);
	}

}
