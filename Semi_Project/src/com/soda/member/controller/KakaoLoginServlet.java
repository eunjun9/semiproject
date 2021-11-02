package com.soda.member.controller;

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
 * Servlet implementation class KakaoLoginServlet
 */
@WebServlet("/kakao/login")
public class KakaoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KakaoLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userEmail");
		String userName = request.getParameter("userName");
		
		Member loginUser = new MemberService().loginMember(userId);
		
	
		if( loginUser == null ) {
			Member joinMember = new Member();
			joinMember.setUserId(userId);
			joinMember.setUserName(userName);
			joinMember.setUserPhone("없음");
			// 카카오계정 db 등록 시에 비밀번호 어떤 식으로 저장해야할 지 고민중
			joinMember.setUserPwd("3b86ff88ef6c490628285f482af15ddcb29541f94b");
			joinMember.setUserAddress("데이터가 없습니다.");
			
			//카카오 자동 회원가입 로직 실행
			int kakaoJoin = new MemberService().kakaoJoin(joinMember);
			
			if(kakaoJoin > 0) {
				request.getSession().setAttribute("message", "회원 가입이 완료 되었습니다. 다시 로그인 해주세요.");
				response.sendRedirect(request.getContextPath());
			}else {
				System.out.println("카카오 회원가입 실패");
			}
			
		}else {
			request.getSession().setAttribute("loginUser", loginUser);
			response.sendRedirect(request.getContextPath());
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
