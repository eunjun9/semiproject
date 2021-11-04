package com.soda.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.member.model.service.MemberService;

/**
 * Servlet implementation class EmailFindServlet
 */
@WebServlet("/email/find")
public class EmailFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailFindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/emailFindForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		
		String findEmail = new MemberService().findEmail(userName, userPhone);
		
		// System.out.println(findEmail);

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		if(findEmail != null) {
			// 가입된 계정이 있을 때 alert
			writer.print("<script>alert('가입하신 이메일 계정은 ");
			writer.print(findEmail);
			writer.println(" 입니다.'); </script>");
			writer.println("<script>history.back();</script>");
			writer.close();
		} else {
			// 가입된 계정이 없을 때 alert
			writer.println("<script>alert('일치하는 정보가 없습니다.');</script>");
			writer.println("<script>history.back();</script>");
			writer.close();
		}
		
	}

}
