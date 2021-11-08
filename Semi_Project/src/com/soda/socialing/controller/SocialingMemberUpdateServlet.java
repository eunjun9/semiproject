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
 * Servlet implementation class SocialingMemberUpdateServlet
 */
@WebServlet("/socialingMember/update")
public class SocialingMemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocialingMemberUpdateServlet() {
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
		// 참여 회원 체크 팝업 로직
		int nNum = Integer.parseInt(request.getParameter("nNum"));
		String userId = request.getParameter("mId");
		
		int result = new SocialingService().updateMember(nNum, userId);
		
		if(result > 0) {
			request.getSession().setAttribute("message", "참여 확인 처리 되었습니다.");
			response.sendRedirect(request.getContextPath() + "/socialing/main");
		} else {
			request.setAttribute("message", "참여 확인 처리에 실패하였습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
		}
	}

}
