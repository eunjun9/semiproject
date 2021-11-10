package com.soda.lesson.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.lesson.model.service.LessonService;
import com.soda.lesson.model.vo.Lesson;

/**
 * Servlet implementation class LessonDetailServlet
 */
@WebServlet("/lesson/detail")
public class LessonDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LessonDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nNum = Integer.parseInt(request.getParameter("nNum"));
		// String nNum = request.getParameter("nNum");
		LessonService lessonService = new LessonService();
		
		/* 동일 게시글에 대한 조회수 무한 증가 방지 처리 -> cookie 활용 */
		// 요청으로부터 Cookie 정보들을 얻어옴 (Cookie[] : servlet.http로 임포트)
		Cookie[] cookies = request.getCookies();
		
		// 쿠키의 값 담을 변수
		String nCount = "";
		
		// 쿠키가 잘 넘어 왔다면
		if(cookies != null && cookies.length > 0) {
			// 넘어온 쿠키 값 배열을 처음부터 끝까지 반복하며 탐색
			for(Cookie c : cookies) {
				// 읽은 게시물 bid를 저장해두는 쿠키의 이름 ncount가 있는지 확인
				if(c.getName().equals("nCount")) {
					nCount = c.getValue();
				}
			}
		}
		
 		// -1 :  처음 읽은 게시글일 경우 쿠키를 찾음 처음이 아닌 경우는 찾지 않음 (중복 카운팅 방지)
		if(nCount.indexOf( "|" + nNum + "|") == -1 ) {
			// 기존 nCount 값에 지금 요청한 bid 값 추가하여 새로운 쿠키 생성
			Cookie newNcount = new Cookie("nCount", nCount + "|" + nNum + "|");
			
			// 클라이언트가 쿠키를 저장하고 있을 수 있도록 응답에 담는다
			response.addCookie(newNcount);
			
			// DB에 접근해서 해당 게시글 조회수 증가 처리
			int result = lessonService.increaseCount(nNum);
			
			if(result > 0 ) {
				System.out.println("조회수 증가 성공");
			} else {
				System.out.println("조회수 증가 실패");
			}
		}
		
		// 게시글 조회 로직
		Lesson lesson = lessonService.selectLesson(nNum);
		//System.out.println(lesson);
		if(lesson != null) {
			request.setAttribute("lesson", lesson);
			request.getRequestDispatcher("/WEB-INF/views/lesson/lessonDetail.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "클래스 게시판 게시글 상세보기에 실패하였습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
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
