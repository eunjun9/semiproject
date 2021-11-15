package com.soda.magazine.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.soda.magazine.model.service.MagazineService;
import com.soda.magazine.model.vo.Reply;
import com.soda.member.model.vo.Member;

/**
 * Servlet implementation class replyInsertServlet
 */
@WebServlet("/magazine/insertReply")
public class ReplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReplyInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int nnum = Integer.parseInt(request.getParameter("nNum"));
		String rcontent = request.getParameter("rContent");
		
		
		 String rwriter = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		 

		Reply reply = new Reply();
		reply.setnNum(nnum);
		reply.setrContent(rcontent);
		reply.setrWriter(rwriter);

		// 댓글 insert 후 갱신된 댓글 리스트 select하여 리턴
//		List<Reply> replyList = new MagazineService().insertReply(reply);
		
		int result = new MagazineService().insertReply(reply);
		
//		System.out.println(result);

		
//		 response.sendRedirect(request.getHeader("referer"));

		 response.sendRedirect(request.getContextPath() + "/magazine/detail?nNum="+nnum);
		
		
		
//		System.out.println(replyList);

		// GSON 라이브러리 추가 후 GSON 객체의 toJson 메소드로 처리
//		response.setContentType("application/json; charset=utf-8");
//		new Gson().toJson(replyList, response.getWriter());

		// GSON 사용시 날짜 값은 date 포맷에 대한 컨트롤이 필요함
		// GsonBuilder 클래스의 setDateFormat 메소드 사용
//		Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd HH:mm:ss").create();
//		gson.toJson(replyList, response.getWriter());

	}
}
