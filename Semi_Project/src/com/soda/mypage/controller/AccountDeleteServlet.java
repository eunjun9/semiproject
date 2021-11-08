package com.soda.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soda.member.model.service.MemberService;
import com.soda.member.model.vo.Member;

/**
 * Servlet implementation class AccountDeleteServlet
 */
@WebServlet("/accountDelete")
public class AccountDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountDeleteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 탈퇴 유저에 대해서 처리할 수 있는 값 추출 */
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		
		/* DB에서 status 값  Y -> N으로 update
		 * MemberService 클래스에 deleteAccount 라는 메소드 호출 */
		Member deletedMember = new MemberService().deleteAccount(userId);
		
		// int result = new MemberService().deleteAccount(userNo);
		
		/* 수행 결과에 따라서 성공한 경우 로그인 세션 정보 삭제 후 메인 페이지로 이동
		 * "회원 탈퇴가 완료되었습니다." alert 처리  */
		/* 실패한 경우 "회원 탈퇴에 실패하였습니다." 메시지 가지고 에러 페이지 이동 */
		if(deletedMember == null) {		// 성공했을 때 null 값을 받아옴
	//  if(result > 0) {
			HttpSession session = request.getSession();
			session.removeAttribute("loginUser");
			request.getSession().setAttribute("message", "회원탈퇴에 성공하였습니다.");
			response.sendRedirect(request.getContextPath() + "/index");
			
			// request.getSession().removeAttribute("loginUser"); -> 로그인 세션 정보 삭제
			// request.getSession().setAttribute("message", "회원 탈퇴에 완료되었습니다."); -> 메뉴바에서 alert
			// response.sendRedirect(request.getContextPath()); -> 메인 페이지 이동
		} else {
			request.setAttribute("message", "회원 탈퇴에 실패하였습니다.");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp");
			view.forward(request, response);
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
