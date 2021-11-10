package com.soda.socialing.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.socialing.model.vo.SodaFile;
import com.soda.socialing.model.service.SocialingService;

/**
 * Servlet implementation class SocialingDeleteServlet
 */
@WebServlet("/socialing/delete")
public class SocialingDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocialingDeleteServlet() {
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
		
		/* Notice, Tbl_File 테이블의 nNum 일치하는 행 notice_status(게시판삭제) N -> Y로 변경 / status(파일등록여부) Y -> N으로 변경
		 * 서버에 저장 된 이미지 파일의 정보 알아와서 삭제 처리 */
		List<SodaFile> deletedPhotoList = new SocialingService().deleteSocialing(nNum);
		
		if(deletedPhotoList != null) {
			/* DB에서 Y -> N update 수행 완료 되었으므로 서버의 파일 삭제 */
			String root = request.getSession().getServletContext().getRealPath("/"); // "/" -> 어플리케이션 객체의 기본경로를 가져온다
			for(SodaFile photo : deletedPhotoList) {
				File deletedPhoto = new File(root + photo.getRoute() + photo.getChangeName());
				deletedPhoto.delete();
			}
			request.getSession().setAttribute("message", "삭제 완료 되었습니다.");
			response.sendRedirect(request.getContextPath() + "/socialing/main");
		} else {
			request.setAttribute("message", "사진 게시판 게시글 삭제에 실패했습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
		}
	}

}
