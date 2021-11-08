package com.soda.magazine.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.magazine.model.service.MagazineService;
import com.soda.magazine.model.vo.MagazineFile;

/**
 * Servlet implementation class MagazineDeleteServlet
 */
@WebServlet("/magazine/delete")
public class MagazineDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MagazineDeleteServlet() {
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

		int nNum = Integer.parseInt(request.getParameter("nNum"));

		// Magazine, MagazineFile 테이블의 bid 일치하는 행 status N -> Y으로 변경
		// 서버에 저장된 이미지 파일의 정보를 알아와서 삭제 처리
		List<MagazineFile> deletedPhotoList = new MagazineService().deleteMagazine(nNum);

		if (deletedPhotoList != null) {
			// DB에서 Y -> N update 수행 완료되었으므로 서버의 파일 삭제
			String root = request.getSession().getServletContext().getRealPath("/");
			for (MagazineFile photo : deletedPhotoList) {
				File deletedPhoto = new File(root + photo.getRoute() + photo.getChangeName());
				deletedPhoto.delete();
			}
			response.sendRedirect(request.getContextPath() + "/magazine/main");

		} else {
			request.setAttribute("message", "사진 게시판 게시글 삭제에 실패했습니다");
			request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
		}
	}
}
