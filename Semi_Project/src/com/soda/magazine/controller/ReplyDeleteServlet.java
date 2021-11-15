package com.soda.magazine.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.magazine.model.service.MagazineService;
import com.soda.magazine.model.vo.Reply;

/**
 * Servlet implementation class MagazineDeleteServlet
 */
@WebServlet("/reply/delete")
public class ReplyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReplyDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int nNum = Integer.parseInt(request.getParameter("nNum"));
		int rNum = Integer.parseInt(request.getParameter("reNum"));

	
		// Magazine, MagazineFile 테이블의 bid 일치하는 행 status N -> Y으로 변경
		// 서버에 저장된 이미지 파일의 정보를 알아와서 삭제 처리
		
		Reply reply = new Reply();
		reply.setnNum(nNum);
		reply.setrNum(rNum);
		
		int result = new MagazineService().deleteReply(rNum);
		
		
		if(result>0){
			
			response.sendRedirect(request.getContextPath() + "/magazine/detail?nNum="+nNum);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
		}
	
	}
	

}
