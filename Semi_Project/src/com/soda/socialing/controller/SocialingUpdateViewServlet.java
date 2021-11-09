package com.soda.socialing.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.socialing.model.service.SocialingService;
import com.soda.socialing.model.vo.Socialing;

/**
 * Servlet implementation class SocialingUpdateViewServlet
 */
@WebServlet("/socialing/updateView")
public class SocialingUpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocialingUpdateViewServlet() {
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
		
		Socialing socialing = new SocialingService().selectSocialing(nNum);
		
		if(socialing != null) {
			request.setAttribute("socialing", socialing);
			request.getRequestDispatcher("/WEB-INF/views/socialing/socialingUpdateForm.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "수정할 게시글을 불러오는데 실패했습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
		}
	}

}
