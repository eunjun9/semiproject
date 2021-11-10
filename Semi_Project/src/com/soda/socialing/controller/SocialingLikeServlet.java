package com.soda.socialing.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.member.model.vo.Member;
import com.soda.socialing.model.service.SocialingService;

/**
 * Servlet implementation class SocialingLikeServlet
 */
@WebServlet("/likeSocialing")
public class SocialingLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocialingLikeServlet() {
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
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		
		int result = new SocialingService().likeSocialing(nNum, userId);
		
		if(result > 0) {
			request.getSession().setAttribute("message", "관심 소셜링에 추가 되었습니다.");
			response.sendRedirect(request.getContextPath() + "/socialing/detail?nNum=" + nNum);
		} else {
			request.setAttribute("message", "관심 소셜링 추가에 실패하였습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
		}
	}

}
