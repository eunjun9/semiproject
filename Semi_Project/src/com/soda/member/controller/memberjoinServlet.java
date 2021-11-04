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
 * Servlet implementation class memberjoinServlet
 */
@WebServlet("/memberjoin")
public class memberjoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberjoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/memberJoin.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 정보 입력 후 회원 가입 버튼을 눌렀을 때
				// 요청을 통해 넘어온 정보 DB에 Insert 후 응답 화면
				
				// 1. 한글 값이 있을 경우 인코딩 처리 (필터 적용 후 주석)
				// request.setCharacterEncoding("UTF-8");
				
				// 2. request에 담긴 값을 꺼내서 변수에 저장
				String userId = request.getParameter("userId");
				String userPwd = request.getParameter("userPwd");
				String userName = request.getParameter("userName");
				String userPhone = request.getParameter("userPhone");
				String gender = request.getParameter("gender");
				
				
				
				// 가입 정보를 담을 Member 객체 생성
				Member member = new Member(userId, userPwd, userName, userPhone, gender);
				
				// System.out.println(member);
				
				// 3. 비즈니스 로직을 수행할 서비스 메소드로 Member 객체 전달 후 결과 값 리턴 받기
				int result = new MemberService().insertMember(member);
				
				// System.out.println(result);
				
				// 4. 결과 성공/실패 여부에 따라 응답 결정
				if(result > 0) {
					// 메인 화면으로 이동 후 alert로 "회원 가입이 완료되었습니다. 로그인 해주세요." 처리
					// sendRedirect 처리하면 request 갹채가 다시 만들어지므로 request.setAttribute는 소용이 없음
					// session 객체에 해당 메시지 담기
					request.getSession().setAttribute("message", "회원 가입이 완료되었습니다. 로그인 해주세요.");
					
					// 메인 화면으로 이동, 서버 재요청(sendRedirect)
					// forward 처리 시 / memberJoin에 대한 요청 남아 있음
					response.sendRedirect(request.getContextPath() + "/email/login");
				} else {
					// 회원 가입에 실패 했을 경우 error 페이지로 이동
					request.setAttribute("message", "회원 가입에 실패하였습니다.");
					RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp");
					view.forward(request, response);
				}
				
			}

		}
