package com.soda.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import static com.common.JDBCTemplate.close;

import com.soda.member.model.vo.Member;


public class MemberDao {

	private Properties memberQuery = new Properties();
	
	public MemberDao() {
		memberQuery = new Properties();
		String fileName = MemberDao.class.getResource("/com/sql/member/member-query.xml").getPath();
		try {
			memberQuery.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 이메일 로그인
	public Member loginMember(Connection conn, String userId, String userPwd) {
		PreparedStatement pstmt = null;
		Member loginUser = null;
		ResultSet rset = null;
		String sql = memberQuery.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new Member(rset.getString("user_id"),
										rset.getString("user_name"),
										rset.getString("user_phone"),
										rset.getString("user_pwd"),
										rset.getString("user_address"),
										rset.getDate("join_date"),
										rset.getString("status"),
										rset.getString("user_grade"),
										rset.getString("user_gender"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return loginUser;
	}

	// 카카오 로그인 회원 조회, 비밀번호 찾기할 때 회원 조회
	public Member loginMember(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		Member loginUser = null;
		ResultSet rset = null;
		String sql = memberQuery.getProperty("kakaoLoginMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new Member(rset.getString("user_id"),
										rset.getString("user_name"),
										rset.getString("user_phone"),
										rset.getString("user_pwd"),
										rset.getString("user_address"),
										rset.getDate("join_date"),
										rset.getString("status"),
										rset.getString("user_grade"),
										rset.getString("user_gender"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return loginUser;
	}

	// 카카오 자동 회원가입
	public int kakaoJoin(Connection conn, Member joinMember) {
		PreparedStatement pstmt =null;
		int result = 0;
		String sql = memberQuery.getProperty("kakaoJoin");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, joinMember.getUserId());
			pstmt.setString(2, joinMember.getUserName());
			pstmt.setString(3, joinMember.getUserPhone());
			pstmt.setString(4, joinMember.getUserPwd());
			pstmt.setString(5, joinMember.getUserAddress());
			pstmt.setString(6, joinMember.getGender());
		
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	// 회원가입
	public int insertMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = memberQuery.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserName());
			pstmt.setString(3, member.getUserPhone());
			pstmt.setString(4, member.getUserPwd());
			pstmt.setString(5, member.getGender());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	// 이메일 계정 찾기
	public String findEmail(Connection conn, String userName, String userPhone) {
		PreparedStatement pstmt = null;
		String findEmail = null;
		ResultSet rset = null;
		String sql = memberQuery.getProperty("findEmail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userName);
			pstmt.setString(2, userPhone);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				findEmail = rset.getString("user_id");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return findEmail;
	}

	// 비밀번호 찾기 - 임시비밀번호 발급받아 비밀번호 수정
	public int sendPwd(Connection conn, String userId, int random) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = memberQuery.getProperty("sendPwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, random);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
