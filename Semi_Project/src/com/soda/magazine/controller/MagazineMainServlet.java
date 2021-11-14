package com.soda.magazine.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.lesson.model.service.LessonService;
import com.soda.magazine.model.service.MagazineService;
import com.soda.magazine.model.vo.Magazine;
import com.soda.socialing.model.service.SocialingService;
import com.soda.socialing.model.vo.Notice;

/**
 * Servlet implementation class MagazineMainServlet
 */
@WebServlet("/magazine/main")
public class MagazineMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MagazineMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Magazine> userList = new MagazineService().selectUserList();
		
		List<Magazine> magazineAdminList = new MagazineService().selectAdminList();
		
//		System.out.println(magazineAdminList);
		request.setAttribute("magazineAdminList", magazineAdminList);
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/WEB-INF/views/magazine/magazineMain.jsp").forward(request, response);

	}	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
