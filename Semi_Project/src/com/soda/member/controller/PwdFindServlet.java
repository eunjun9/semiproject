package com.soda.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soda.member.model.service.MemberService;
import com.soda.member.model.vo.Member;

/**
 * Servlet implementation class PwdFindServlet
 */
@WebServlet(name="PwdFindServlet", urlPatterns="/pwd/find")
public class PwdFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PwdFindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/pwdFindForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userEmail");
		
		// 가입되어 있는 회원정보가 있는지  아이디(메일계정)로 조회하기
		Member loginUser = new MemberService().loginMember(userId);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		// 입력한 메일주소와 가입된 메일계정이 일치한지 확인
		 if( loginUser == null || !loginUser.getUserName().equals(userName)){
	        	writer.println("<script>alert('일치하는 정보가 없습니다.');</script>");
				writer.println("<script>history.back();</script>");
				writer.close();
	            return;
	      }else {
	        
	        //mail server 설정
            String host = "smtp.gmail.com";
            String user = "minju.write@gmail.com"; 	// 보내는 사람의 메일 주소
            String password = "xptmxmdyd1!";		// 보내는 사람의 메일 패스워드
            
            //메일 받을 주소
            String toEmail = loginUser.getUserId();
            
            //SMTP 서버 정보를 설정한다.
            Properties props = new Properties();
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", 465);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");
            props.put("mail.smtp.ssl.enable", "true");

			// 5자리 임시비밀번호 생성
			int random = (int)(Math.random() * (99999 - 10000 + 1)) + 10000;
			System.out.println("임시비밀번호 : " + random);
			
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
				}
			});
			
			// email 전송
			try {
				MimeMessage send = new MimeMessage(session);
				send.setFrom(new InternetAddress(user, "SODA"));
				send.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
				
				// 메일 제목
				send.setSubject("소셜다이닝 임시 비밀번호 발급");
				// 메일 내용
				send.setText("임시 비밀번호는 " + random + " 입니다. 로그인 후 비밀번호 변경을 진행해주세요.");

				Transport.send(send);
				System.out.println("이메일 전송 완료");
				
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}

			// 발급된 임시비밀번호로 비밀번호 변경해주는 로직 만들어야함 !!
			// 이메일 전송 성공하면 alert 창 뜨게 해야함!!
			
			
	      }

	}

}
