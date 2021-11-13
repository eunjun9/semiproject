package com.soda.magazine.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.magazine.model.service.MagazineService;
import com.soda.magazine.model.vo.Magazine;
import com.soda.member.model.vo.Member;
import com.soda.mypage.model.service.ProfileService;
import com.soda.mypage.model.vo.Profile;


/**
 * Servlet implementation class MagazineDetailServlet
 */
@WebServlet("/magazine/detail")
public class MagazineDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MagazineDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int nNum = Integer.parseInt(request.getParameter("nNum"));
		MagazineService magazineService = new MagazineService();
    	
		
		//게시판 게시글 조회
    	Magazine magazine = magazineService.selectMagazine(nNum);
    	
    	
    	
    	
    	
    	
    	
    	
		
//		System.out.println(magazine);
		
		if(magazine != null) {
			request.setAttribute("magazine", magazine);
			request.getRequestDispatcher("/WEB-INF/views/magazine/magazineDetail.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "사진 게시판 게시글 상세보기에 실패하였습니다");
			request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
		}
		
    
}
		
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
	}

}
