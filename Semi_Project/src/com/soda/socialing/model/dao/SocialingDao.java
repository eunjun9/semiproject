package com.soda.socialing.model.dao;

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

import com.soda.socialing.model.vo.PageInfo;
import com.soda.socialing.model.vo.Search;
import com.soda.socialing.model.vo.Socialing;
import com.soda.socialing.model.vo.SocialingMember;
import com.soda.socialing.model.vo.SodaFile;

public class SocialingDao {

	private Properties socialingQuery = new Properties();

	public SocialingDao() {
		String fileName = SocialingDao.class.getResource("/com/sql/socialing/socialing-query.xml").getPath();

		try {
			socialingQuery.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 게시물 개수 조회
	public int getListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = socialingQuery.getProperty("getListCount");
		int listCount = 0;

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return listCount;
	}

	// 게시물 리스트 조회
	public List<Socialing> selectList(Connection conn, PageInfo pi/*, Search search*/) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = socialingQuery.getProperty("selectList");
		List<Socialing> socialingList = new ArrayList<>();
		
		// 검색 시 수행할 쿼리문 변경
//		if(search.getKeyword() != null && search.getLocal() != null && search.getDateIn() != null && search.getOnoff() != null) {
//			if(search.getSearchCondition().equals("title")) {
//				sql = socialingQuery.getProperty("selectTitleList");
//			} else if(search.getSearchCondition().equals("content")) {
//				sql = socialingQuery.getProperty("selectContentList");
//			} else if(search.getSearchCondition().equals("writer")) {
//				sql = socialingQuery.getProperty("selectWriterList");
//			}
//		}

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
//			int index = 1;
//			// 검색 sql 실행 시
//			if(search.getSearchCondition() != null && search.getSearchValue() != null) {
//				pstmt.setString(index++, search.getSearchValue());
//			}
//			
//			// if문에 안 걸림(검색X) : 1 -> 2
//			// if문에 걸림(검색O) : if문 안의 index가 1 / 2 -> 3
//			pstmt.setInt(index++, startRow);
//			pstmt.setInt(index, endRow);

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Socialing socialing = new Socialing();
				socialing.setnNum(rset.getInt("notice_num"));
				socialing.setnTitle(rset.getString("notice_title"));
				socialing.setUserName(rset.getString("user_name"));
				socialing.setSplace(rset.getString("s_place"));
				socialing.setSdate(rset.getDate("s_date"));
				socialing.setStime(rset.getString("s_time"));
				socialing.setStype(rset.getString("s_type"));

				List<SodaFile> photoList = new ArrayList<>();
				SodaFile file = new SodaFile();
				file.setRoute(rset.getString("route"));
				file.setChangeName(rset.getString("change_name"));
				photoList.add(file);
				socialing.setPhotoList(photoList);
				
				socialingList.add(socialing);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return socialingList;
	}
	
	// 게시물 조회수 증가
	public int increaseCount(Connection conn, int nNum) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = socialingQuery.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nNum);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	// 게시글 상세페이지 읽어오기
	public Socialing selectSocialing(Connection conn, int nNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Socialing socialing = null;
		String sql = socialingQuery.getProperty("selectSocialing");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				socialing = new Socialing();
				socialing.setnNum(rset.getInt("notice_num"));
				socialing.setnTitle(rset.getString("notice_title"));
				socialing.setnContent(rset.getString("notice_content"));
				socialing.setUserId(rset.getString("user_id"));
				socialing.setUserName(rset.getString("user_name"));
				socialing.setnCount(rset.getInt("ncount"));
				socialing.setSplace(rset.getString("s_place"));
				socialing.setSdate(rset.getTimestamp("s_date"));
				socialing.setStime(rset.getString("s_time"));
				socialing.setStype(rset.getString("s_type"));
				socialing.setMaxMember(rset.getInt("max_member"));
				socialing.setMinMember(rset.getInt("min_member"));
				socialing.setProfile(rset.getString("profile"));
				socialing.setIntroduction(rset.getString("introduction"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return socialing;
	}
	
	public List<SodaFile> selectPhotoList(Connection conn, int nNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<SodaFile> photoList = new ArrayList<>();
		String sql = socialingQuery.getProperty("selectPhotoList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nNum);
			
			rset = pstmt.executeQuery();
			
			// 썸네일 사진 1개 (프로필사진 여기로 추가해야되면 while문으로 변경)
			if(rset.next()) {
				SodaFile file = new SodaFile();
				file.setFileNum(rset.getInt("file_num"));
				file.setRoute(rset.getString("route"));
				file.setOriginName(rset.getString("origin_name"));
				file.setChangeName(rset.getString("change_name"));
				file.setFileLevel(rset.getInt("file_level"));
				
				photoList.add(file);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return photoList;
	}
	
	public List<SocialingMember> selectMember(Connection conn, int nNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<SocialingMember> memberList = new ArrayList<>();
		String sql = socialingQuery.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nNum);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				SocialingMember sMember = new SocialingMember();
				sMember.setMemberId(rset.getString("user_id"));
				sMember.setStatus(rset.getString("s_status"));
				sMember.setMemberName(rset.getString("user_name"));
				sMember.setMemberProfile(rset.getString("profile"));
				sMember.setIntroduction(rset.getString("introduction"));
				
				memberList.add(sMember);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return memberList;
	}
	
	public int insertMember(Connection conn, int nNum, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = socialingQuery.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nNum);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateMember(Connection conn, int nNum, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = socialingQuery.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nNum);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// 게시글 추가하기 (notice, socialing, file 테이블 insert)
	public int insertNotice(Connection conn, Socialing socialing) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = socialingQuery.getProperty("insertNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, socialing.getnTitle());
			pstmt.setString(2, socialing.getnContent());
			pstmt.setString(3, socialing.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertSocialing(Connection conn, Socialing socialing) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = socialingQuery.getProperty("insertSocialing");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, socialing.getSplace());
			pstmt.setDate(2, new java.sql.Date(socialing.getSdate().getTime()));
			// pstmt.setDate(4, new java.sql.Date(java.util.Date.getTime()));
			pstmt.setString(3, socialing.getStype());
			pstmt.setInt(4, socialing.getMaxMember());
			pstmt.setInt(5, socialing.getMinMember());
			pstmt.setString(6, socialing.getStime());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertFile(Connection conn, SodaFile photo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = socialingQuery.getProperty("insertFile");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, photo.getRoute());
			pstmt.setString(2, photo.getOriginName());
			pstmt.setInt(3, photo.getFileLevel());
			pstmt.setString(4, photo.getChangeName());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
