package com.soda.socialing.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.member.model.vo.Member;
import com.soda.socialing.model.service.SocialingService;
import com.soda.socialing.model.vo.Socialing;
import com.soda.socialing.model.vo.SocialingMember;

/**
 * Servlet implementation class SocialingDetailServlet
 */
@WebServlet("/socialing/detail")
public class SocialingDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocialingDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nNum = Integer.parseInt(request.getParameter("nNum"));
		
		SocialingService socialingService = new SocialingService();
		
		/* 동일 게시글에 대한 조회수 무한 증가 방지 처리 -> cookie 활용 */
		
		// 요청으로부터 Cookie 정보들을 얻어옴 -> Cookie 배열 안에 bcount값이 있는지 확인
		Cookie[] cookies = request.getCookies();
		
		// bcount라는 쿠키의 값 담을 변수 선언
		String bcount = "";
		
		// 쿠키가 잘 넘어 왔다면
		if(cookies != null && cookies.length > 0) {
			// 넘어온 쿠키 값 배열을 처음부터 끝까지 반복하며 탐색
			for(Cookie c : cookies) {
				// 읽은 게시물 nNum을 저장해두는 쿠키의 이름 bcount가 있는지 확인
				if(c.getName().equals("bcount")) {
					bcount = c.getValue();
				}
			}
		}
		
		// 처음 읽는 게시글일 경우 (-1 : 저장되어 있지 않음)
		// Ex. "|1||22||100|"와 같은 bcount Cookie의 value 값에서 indexOf로 해당 문자열 찾기
		if(bcount.indexOf("|" + nNum + "|") == -1) {
			
			// 기본 bcount 값에 지금 요청한 bid 값 추가하여 새로운 쿠키 생성
			Cookie newBcount = new Cookie("bcount", bcount + "|" + nNum + "|");
			
			// 초 단위로 유효 기간 설정 가능
			// 설정하지 않을 시 session cookie
			// newBcount.setMaxAge(1 * 24 * 60 * 60);
			
			// 클라이언트가 저장하고 있을 수 있도록 응답에 담는다
			response.addCookie(newBcount);
			
			// DB의 해당 게시글 조회수 증가
			int result = socialingService.increaseCount(nNum);
			
			if(result > 0) {
				System.out.println("조회수 증가 성공");
			} else {
				System.out.println("조회수 증가 실패");
			}
		}
		
		/* 소셜링 게시글 조회 */
		Socialing socialing = socialingService.selectSocialing(nNum);
		
		/* 참여자 리스트 조회 */
		List<SocialingMember> memberList = socialingService.selectMember(nNum);
		
		System.out.println(memberList);
		
		if(socialing != null) {
			request.setAttribute("socialing", socialing);
			request.setAttribute("memberList", memberList);
			request.getRequestDispatcher("/WEB-INF/views/socialing/socialingDetailView.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "소셜링 게시글 상세보기에 실패하였습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
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
