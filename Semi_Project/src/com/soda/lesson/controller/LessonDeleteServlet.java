package com.soda.lesson.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.lesson.model.service.LessonService;
import com.soda.lesson.model.vo.Attachment;

/**
 * Servlet implementation class LessonDeleteServlet
 */
@WebServlet("/lesson/delete")
public class LessonDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LessonDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nNum = Integer.parseInt(request.getParameter("nNum"));
		List<Attachment> deletedPhotoList = new LessonService().deleteLesson(nNum);
		
		if(deletedPhotoList != null) {
			String root = request.getSession().getServletContext().getRealPath("/");
			
			for(Attachment photo : deletedPhotoList) {
				File deletedPhoto = new File(root + photo.getRoute() + photo.getChangeName());
				deletedPhoto.delete();
			}
			
			response.sendRedirect(request.getContextPath() + "/lesson/main");
		} else {
			request.setAttribute("message", "클래스 삭제에 실패하였습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);;
		}
	
	}

}
