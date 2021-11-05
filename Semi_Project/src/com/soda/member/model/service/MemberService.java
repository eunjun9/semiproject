package com.soda.member.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;

import com.soda.member.model.dao.MemberDao;
import com.soda.member.model.vo.Member;

public class MemberService {
	
	private MemberDao memberDao = new MemberDao();

	// 로그인 회원 정보 확인
	public Member loginMember(String userId, String userPwd) {
		Connection conn = getConnection();
		
		Member loginMember = memberDao.loginMember(conn, userId, userPwd);
		
		close(conn);

		return loginMember;
	}

	// 카카오 로그인 회원 정보 확인, 비밀번호 찾기할 때 회원 정보 확인
	public Member loginMember(String userId) {
		Connection conn = getConnection();
		
		Member loginMember = memberDao.loginMember(conn, userId);
		
		close(conn);

		return loginMember;
	}
	
	// 카카오 자동 회원가입
	public int kakaoJoin(Member joinMember) {
		Connection conn = getConnection();
		
		int result = memberDao.kakaoJoin(conn, joinMember);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	// 회원가입
	public int insertMember(Member member) {
		Connection conn = getConnection();

		int result = memberDao.insertMember(conn, member);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	// 이메일 계정 찾기
	public String findEmail(String userName, String userPhone) {
		Connection conn = getConnection();
		
		String findEmail = memberDao.findEmail(conn, userName, userPhone);
		
		close(conn);
		
		return findEmail;
	}


	
	

}
