package com.soda.socialing.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import com.soda.member.model.vo.Member;
import com.soda.socialing.model.service.SocialingService;
import com.soda.socialing.model.vo.Socialing;
import com.soda.socialing.model.vo.SodaFile;

/**
 * Servlet implementation class SocialingUpdateServlet
 */
@WebServlet("/socialing/update")
public class SocialingUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocialingUpdateServlet() {
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
		/* enctype이 multipart/form-data로 전송 되었는지 확인하고, 아닐 경우 에러페이지 이동 */
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("message", "잘못 된 전송입니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
			return;
		}
		
		int maxSize = 1024*1024*10;
		String root = request.getSession().getServletContext().getRealPath("/");
		String savePath = root + "resources\\uploadFiles\\";
		
		MultipartRequest multiRequest 
			= new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
		
		/* Notice + Socialing 테이블 수정 값 설정 */
		Socialing socialing = new Socialing();
		socialing.setnTitle(multiRequest.getParameter("inputTitle"));
		socialing.setnContent(multiRequest.getParameter("content"));
		
		String sdate = multiRequest.getParameter("dateIn");
		// 모임 날짜 String -> Date로 변경
		Date date = Date.valueOf(sdate);
		socialing.setSdate(date);
		
		socialing.setStime(multiRequest.getParameter("timeIn"));
		socialing.setStype(multiRequest.getParameter("type"));
		
		String[] splaceArr = multiRequest.getParameterValues("inputPlace");
		// 주소 문자열 합치기
		String splace = "";
		if(splaceArr != null && !splaceArr[0].equals("") && !splaceArr[1].equals(""))
			splace = String.join("|", splaceArr);
		else
			splace = splaceArr[0]; // 온라인 모임일 경우 (상세 주소 x)
		socialing.setSplace(splace);
		
		socialing.setnType("소셜링");
		socialing.setMinMember(Integer.parseInt(multiRequest.getParameter("min")));
		socialing.setMaxMember(Integer.parseInt(multiRequest.getParameter("max")));
		
		/* Tbl_File 테이블 수정 값 설정 */
		List<SodaFile> photo = new ArrayList<>();
		String fileName = "thumbnail";
		String changeName = multiRequest.getParameter("changeName");
		
		SodaFile thumbnail = new SodaFile();
		thumbnail.setRoute("/resources/uploadFiles/");
		thumbnail.setOriginName(multiRequest.getOriginalFileName(fileName));
		thumbnail.setChangeName(multiRequest.getFilesystemName(fileName));
		thumbnail.setFileLevel(1);
		
		// 원래 저장 된 파일이 있었다면 -> DB에서 update 처리 & 서버에서 기존 파일 delete 처리 (deletedName을 기준값으로 설정)
		// 가지고 있는 값에서 덮어써야 하는지, 새로 추가해야 하는지를 결정
		thumbnail.setDeletedName(changeName);
		
		photo.add(thumbnail);
		
		socialing.setPhotoList(photo);

		int result = new SocialingService().updateSocialing(socialing);
		
		if(result > 0) {
			/* 수정 성공 시 덮어쓰기 된 사진 삭제 */
			for(SodaFile p : photo) {
				if(p.getDeletedName() != null) {
					File deletedFile = new File(savePath + p.getDeletedName());
					deletedFile.delete();
				}
			}
			response.sendRedirect(request.getContextPath() + "/socialing/detail?nNum=" 
									+ Integer.parseInt(multiRequest.getParameter("nNum")));
		} else {
			/* 수정 실패 시 수정을 위해 첨부 된 사진 삭제 */
			for(SodaFile p : photo) {
				File failedFile = new File(savePath + p.getChangeName());
				failedFile.delete();
			}
			
			request.setAttribute("message", "게시글 수정에 실패했습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
		}
	}

}
