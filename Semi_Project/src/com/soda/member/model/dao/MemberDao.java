package com.soda.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.common.JDBCTemplate.close;

import com.soda.magazine.model.vo.Magazine;
import com.soda.magazine.model.vo.MagazineFile;
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
			pstmt.setString(5, joinMember.getGender());
		
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

	// 아이디 체크
	public int idCheck(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String sql = memberQuery.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	// 회원정보수정
	public int updateMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = memberQuery.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserName());
			pstmt.setString(2, member.getUserPhone());
			pstmt.setString(3, member.getUserId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// 회원조회
	public Member selectMember(Connection conn, String userId) {
		Member updatedMember = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = memberQuery.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				updatedMember = new Member(rset.getString("user_id"),
										rset.getString("user_name"),
										rset.getString("user_phone"),
										rset.getString("user_pwd"),
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

		return updatedMember;
	}

	// 비밀번호 변경
	public int updatePwd(Connection conn, String userId, String userPwd, String newPwd) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = memberQuery.getProperty("updatePwd");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newPwd);
			pstmt.setString(2, userId);
			pstmt.setString(3, userPwd);

      result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// 회원탈퇴
	public int deleteAccount(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = memberQuery.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	// 관리자 회원 조회
	public Member selectAdminMember(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = memberQuery.getProperty("selectAdminMember");
		Member member = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member(rset.getString("user_id"),
										rset.getString("user_name"),
										rset.getString("user_phone"),
										rset.getString("user_pwd"),
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

		return member;
	}

	// 관리자 회원 수정
	public int memberModify(Connection conn, Member member) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = memberQuery.getProperty("updateAdminMember");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getUserName());
			pstmt.setString(2, member.getUserPhone());
			pstmt.setString(3, member.getGender());
			pstmt.setString(4, member.getUserGrade());
			pstmt.setString(5, member.getStatus());
			pstmt.setString(6, member.getUserId());

			
      result = pstmt.executeUpdate();
			
      
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	// 관리자 회원 조회(수정을 위한)
	public Member selectMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = memberQuery.getProperty("selectAdminMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserId());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member(rset.getString("user_id"),
										rset.getString("user_name"),
										rset.getString("user_phone"),
										rset.getString("user_pwd"),
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
		

		return member;
	}

	public int memberGrade(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = memberQuery.getProperty("updateMemberGrade");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getUserGrade());
			pstmt.setString(2, member.getStatus());
			pstmt.setString(3, member.getUserId());

      result = pstmt.executeUpdate();
			
      
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<Member> selectMemberList(Connection conn) {
		 PreparedStatement pstmt = null;
         ResultSet rset = null;
         List<Member> memberList = new ArrayList<>();
         String sql = memberQuery.getProperty("selectMemberList");
         
            try {
               pstmt = conn.prepareStatement(sql);
               rset = pstmt.executeQuery();
               while(rset.next()) {   // next() : 다음 행
            	   Member member = new Member();
                 
            	   member.setUserId(rset.getString("user_id"));
            	   member.setUserName(rset.getString("user_name"));
            	   member.setUserPhone(rset.getString("user_phone"));
            	   member.setUserPwd(rset.getString("user_pwd"));
            	   member.setStatus(rset.getString("status"));
            	   member.setJoinDate(rset.getDate("join_date"));
            	   member.setUserGrade(rset.getString("user_grade"));
            	   member.setGender(rset.getString("user_gender"));
            	   memberList.add(member);
               }
               
            } catch (SQLException e) {
               e.printStackTrace();
            } finally {
               close(rset);
               close(pstmt);
            }
            
         
         return memberList;
	}




}
