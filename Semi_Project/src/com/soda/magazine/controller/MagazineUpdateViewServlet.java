package com.soda.magazine.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.magazine.model.service.MagazineService;
import com.soda.magazine.model.vo.Magazine;

/**
 * Servlet implementation class MagazineUpdateViewServlet
 */
@WebServlet("/magazine/updateView")
public class MagazineUpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MagazineUpdateViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int nNum = Integer.parseInt(request.getParameter("nNum"));
	      
	      Magazine magazine = new MagazineService().selectMagazine(nNum);
	      
	      if(magazine != null) {
	         request.setAttribute("magazine", magazine);
	         request.getRequestDispatcher("/WEB-INF/views/magazine/magazineUpdateView.jsp").forward(request, response);
	         
	      }else {
	         request.setAttribute("message", "게시판 게시글을 불러오는데 실패했습니다.");
	         request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
	         
	      }
	   }

}
