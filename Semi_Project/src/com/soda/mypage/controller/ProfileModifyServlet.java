package com.soda.mypage.controller;

import java.io.File;
import java.io.IOException;
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
import com.soda.magazine.model.vo.MagazineFile;
import com.soda.member.model.vo.Member;
import com.soda.mypage.model.service.ProfileService;
import com.soda.mypage.model.vo.Profile;
import com.soda.mypage.model.vo.ProfileFile;

/**
 * Servlet implementation class ProfileReviseServlet
 */
@WebServlet("/profile/modify")
public class ProfileModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileModifyServlet() {
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
		/* enctype이 multipart/form-data 로 전송되었는지 확인 */
		if (!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("message", "잘못된 전송입니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
			return;
		}

		int maxSize = 1024 * 1024 * 10;
		String root = request.getSession().getServletContext().getRealPath("/");
		String savePath = root + "resources\\images\\woo_uploadFiles\\";

		/* input type file에 첨부 된 파일 서버에 저장 됨 */
		MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
				new MyFileRenamePolicy());

		/* 요청에 담긴 클라이언트가 입력한 값 추출 */
		String userId = ((Member) request.getSession().getAttribute("loginUser")).getUserId();
		String sns = multiRequest.getParameter("sns");
		String introduction = multiRequest.getParameter("introduction");
		String[] interestArr = multiRequest.getParameterValues("interest");

		String interest = "";

		if (interestArr != null) {
			interest = String.join("|", interestArr);
		}

		/* 프로필 수정정 값 설정 */
		Profile profile = new Profile();
		profile.setUserId(userId);
		profile.setSns(sns);
		profile.setIntroduction(introduction);
		profile.setInterest(interest);

		
		
		// 프로필 파일에 값 넣어주기

	List<ProfileFile> profileFile = new ArrayList<>();
		
		ProfileFile file = new ProfileFile();
		
		String originName = multiRequest.getOriginalFileName("pic");
		String changeName= multiRequest.getFilesystemName("pic");
		String userId2 = ((Member) request.getSession().getAttribute("loginUser")).getUserId();
		file.setUserId(userId2);
		file.setOriginName(originName);
		file.setChangeName(changeName);
		file.setRoute("/resources/images/woo_uploadFiles/");
		
		profileFile.add(file);
		
		profile.setProfileFile(profileFile);
		
		System.out.println(profile);
		System.out.println(profileFile);
		
		int result = new ProfileService().modifyProfile(profile, file);
		
		System.out.println(result);

		
		if (result > 0) {
		
			response.sendRedirect(request.getContextPath() + "/myfeed");
		} else {

			request.setAttribute("message", "사진 게시글 수정에 실패했습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/errorpage.jsp").forward(request, response);
		}
	}

}
