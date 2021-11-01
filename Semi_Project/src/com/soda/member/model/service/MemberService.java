package com.soda.member.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;

import com.soda.member.model.dao.MemberDao;
import com.soda.member.model.vo.Member;

public class MemberService {
	
	private MemberDao memberDao = new MemberDao();

	public Member loginMember(String userId, String userPwd) {
		Connection conn = getConnection();
		
		Member loginMember = memberDao.loginMember(conn, userId, userPwd);
		
		close(conn);

		return loginMember;
	}

	public Member memberLogin(String userId) {
		Connection conn = getConnection();
		
		
		
		return null;
	}
	
	

}
