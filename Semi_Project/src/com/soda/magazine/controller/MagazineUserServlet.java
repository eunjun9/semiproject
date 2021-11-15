package com.soda.magazine.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.magazine.model.service.MagazineService;
import com.soda.magazine.model.vo.Magazine;


/**
 * Servlet implementation class MagazineUserServlet
 */
@WebServlet("/user/list")
public class MagazineUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MagazineUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* 페이징 처리 */
		// 페이지 초기값 (첫 페이지)
		int page = 1;
		
		// 전달 받은 페이지가 있을 때 
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		// 페이징과 관련된 데이터, 조회 된 게시판 List를 담아서 map에 리턴
		// Map<String, Object> map = new SocialingService().selectList(page);
		Map<String, Object> map = new MagazineService().selectList(page);
		
		
		request.setAttribute("pi", map.get("pi"));
		request.setAttribute("magazineList", map.get("magazineList"));
		
//List<Magazine> userList = new MagazineService().selectUserList();
//	request.setAttribute("userList", userList);
	request.getRequestDispatcher("/WEB-INF/views/magazine/magazineUser.jsp").forward(request, response);
//	System.out.println(magazineList);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
