package com.soda.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.admin.model.service.AdminService;
import com.soda.admin.model.vo.Report;
import com.soda.member.model.vo.Member;

/**
 * Servlet implementation class ReportFormServlet
 */
@WebServlet("/reportForm")
public class ReportFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportFormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 팝업창 화면 보여주기
		request.getRequestDispatcher("/WEB-INF/views/common/reportFormPopup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reason = "";
		if(request.getParameter("rep-reason").equals("기타")) {
			reason = request.getParameter("detail");		// 신고 사유(기타-직접 입력)
		} else {
			reason = request.getParameter("rep-reason");	// 신고 사유 (라디오 버튼)
		}
		int nNum = Integer.parseInt(request.getParameter("rNum"));	// 신고 게시판 번호
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId(); // 신고한 회원 id

		// 신고 테이블에 값 담기
		Report report = new Report();
		report.setrReason(reason);
		report.setnNum(nNum);
		report.setUserId(userId);

		int result = new AdminService().insertReport(report);
		
		if (result > 0) {
			request.setAttribute("result", "success");
		} else {
			request.setAttribute("result", "fail");
		}
		
		request.getRequestDispatcher("/WEB-INF/views/common/reportFormPopup.jsp").forward(request, response);
	}

}
