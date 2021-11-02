package com.soda.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.filter.SHA256Util;
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
		String kakaoId = request.getParameter("kakaoId");
		
		Member loginUser = new MemberService().loginMember(userId);
		
		// 가입된 정보 없으면 가입시켜주기
		if( loginUser == null ) {
			Member joinMember = new Member();
			joinMember.setUserId(userId);
			joinMember.setUserName(userName);
			joinMember.setUserPhone("없음");
			
			// 카카오계정 고유ID를 암호화해서 비밀번호로 생성
			String salt = SHA256Util.generateSalt();
	        String newPassword = SHA256Util.getEncrypt(kakaoId, salt);
	        joinMember.setUserPwd(newPassword);

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
			response.sendRedirect(request.getContextPath() + "/mainpage");
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
