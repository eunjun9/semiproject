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

  // 비밀번호 찾기 - 임시비밀번호 발급받아 비밀번호 수정
	public Member sendPwd(String userId, int random) {
		Connection conn = getConnection();
		Member sendPwd = null;
		
		int result = memberDao.sendPwd(conn, userId, random);
		
		if(result > 0) {
			sendPwd = memberDao.loginMember(conn, userId);

			commit(conn);
		} else {
			rollback(conn);
		}
    
    close(conn);
		
		return sendPwd;
	}


	// 아이디 체크
	public int idCheck(String userId) {
		Connection conn = getConnection();
		
		int result = memberDao.idCheck(conn, userId);
		
		close(conn);
		
		return result;
	}

	// 회원정보 변경
	public Member updateMember(Member member) {
		Connection conn = getConnection();
		Member updatedMember = null;
		
		// 1. 수정하려는 정보가 담신 member 객체를 가지고 updateMember
		int result = memberDao.updateMember(conn, member);
		
		// 2. 수정이 잘 되었다면 수정된 정보의 member 객체 select
		if(result > 0) {
			updatedMember = memberDao.selectMember(conn, member.getUserId());
      commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return updatedMember;
	}

	// 비밀번호 변경
	public Member updatePwd(String userId, String userPwd, String newPwd) {
		Connection conn = getConnection();
		Member updatedMember = null;
		
		int result = memberDao.updatePwd(conn, userId, userPwd, newPwd);
			
		if(result > 0) {
			updatedMember = memberDao.selectMember(conn, userId);
			commit(conn);
		} else {
			rollback(conn);
		}
  
			return null;
	}

	// 회원탈퇴
	public int deleteAccount(String userId) {
		Connection conn = getConnection();
		
		int result = memberDao.deleteAccount(conn, userId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	

}
