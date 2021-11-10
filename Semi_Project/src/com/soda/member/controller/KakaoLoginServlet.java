package com.soda.member.controller;

import java.io.IOException;

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
@WebServlet(name="KakaoLoginServlet", urlPatterns="/kakao/login")
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
		String userPwd = request.getParameter("kakaoId");
		String kakaoGender = request.getParameter("kakaoGender");
		
		// 테스트
		// System.out.println(userId + "/" + userName + "/" + kakaoId + "/" + kakaoGender);
		
		// 카카오 계정으로 이미 가입된 회원이 있는지 조회
		Member loginUser = new MemberService().loginMember(userId);
		
		HttpSession session = request.getSession();
		
		// 가입된 정보 없으면 가입시켜주기
		if( loginUser == null ) {
			
			Member joinMember = new Member();
			joinMember.setUserId(userId);
			joinMember.setUserName(userName);
			joinMember.setUserPhone("정보없음");
			joinMember.setGender(kakaoGender);
			joinMember.setUserPwd(userPwd);
			
			// 카카오계정 고유ID를 암호화해서 비밀번호로 생성
			//String salt = SHA256Util.generateSalt();
	        //String newPassword = SHA256Util.getEncrypt(kakaoId, salt);
	        //joinMember.setUserPwd(newPassword);

			//카카오 자동 회원가입 로직 실행
			int kakaoJoin = new MemberService().kakaoJoin(joinMember);
			
			// 카카오 자동가입 성공 후 세션에 저장하고 비동기식 전송
			if(kakaoJoin > 0) {
				Member kakaoLoginUser = new MemberService().loginMember(userId);
				session.setAttribute("loginUser", kakaoLoginUser);
				response.sendRedirect(request.getContextPath() + "/mainpage");
			}else {
				System.out.println("카카오 회원가입 실패");
			}
			
			// 기존에 회원정보가 있었으면 바로 세션에 저장하고 비동기식 전송
		}else {
			session.setAttribute("loginUser", loginUser);
			response.sendRedirect(request.getContextPath() + "/mainpage");
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
