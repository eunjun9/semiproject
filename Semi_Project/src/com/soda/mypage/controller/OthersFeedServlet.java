package com.soda.mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.magazine.model.service.MagazineService;
import com.soda.magazine.model.vo.Magazine;
import com.soda.member.model.vo.Member;
import com.soda.mypage.model.service.ProfileService;
import com.soda.mypage.model.vo.Profile;

/**
 * Servlet implementation class OthersFeedServlet
 */
@WebServlet("/others/feed")
public class OthersFeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OthersFeedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 한글 값이 있을 경우 인코딩 처리 (필터 적용 후 주석)
				 request.setCharacterEncoding("UTF-8");
				
				// 2. request에 담긴 값을 꺼내서 변수에 저장
				String userId = request.getParameter("userId");
				
				
				ProfileService profileService = new ProfileService();
				
				// 사용자 본인이 올린 사진 및 정보 알려줌
				Profile others = profileService.selectOthersFeed(userId);
				
		
				
				// 사용자가 그동안 올렸던 게시글들 보여줌
				List<Magazine> othersList = new MagazineService().selectOthersList(userId);
				
				
				/*
				 * String str = others.getInterest();
				 * 
				 * System.out.println("str나와라 "+str);
				 * 
				 * if(str == null) { request.setAttribute("others", others);
				 * request.setAttribute("othersList", othersList);
				 * request.getRequestDispatcher("/WEB-INF/views/mypage/othersFeedMain.jsp").
				 * forward(request, response);
				 * 
				 * }else { String[] list = str.split("\\|"); request.setAttribute("list", list);
				 * request.setAttribute("others", others); request.setAttribute("othersList",
				 * othersList);
				 * request.getRequestDispatcher("/WEB-INF/views/mypage/othersFeedMain.jsp").
				 * forward(request, response);
				 * 
				 * }
				 */
				 
				
				
				
				  if (others == null || others.getInterest() ==null) {
					  
					  response.setContentType("text/html; charset=UTF-8");
					  
					  PrintWriter out = response.getWriter();
					   
					  out.println("<script>alert('이 사용자는 현재 마이 피드 기능을 이용하지 않습니다'); location.href='javascript:history.back()'</script>");
					  out.flush();
					  
						
					} else {
						String str  = others.getInterest();
						String[] list = str.split("\\|");
						request.setAttribute("list", list);
						
						request.setAttribute("others", others);
						request.setAttribute("othersList", othersList);
						request.getRequestDispatcher("/WEB-INF/views/mypage/othersFeedMain.jsp").forward(request, response);
					}
				
					

				
			
				

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	

}
