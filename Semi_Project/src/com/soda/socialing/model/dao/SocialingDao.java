package com.soda.socialing.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.common.JDBCTemplate.close;

import com.soda.socialing.model.vo.PageInfo;
import com.soda.socialing.model.vo.ProfileFile;
import com.soda.socialing.model.vo.Search;
import com.soda.socialing.model.vo.Socialing;
import com.soda.socialing.model.vo.SocialingLike;
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
	public int getListCount(Connection conn, Search search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = socialingQuery.getProperty("getListCount");
		int listCount = 0;
		
		// 검색 된 목록을 조회해야 하는 경우 다른 SQL문 수행 (검색 조건이 설정되어 있을 때)
		if(search.getKeyword() != null) {
			sql = socialingQuery.getProperty("getKeywordListCount"); // 키워드 검색
		} else if(search.getLocal() != null) {
			sql = socialingQuery.getProperty("getLocalListCount"); // 지역 검색
		}/* else if(search.getDateIn() != null) {
			sql = socialingQuery.getProperty("getDateListCount"); // 날짜 검색
		}*/ else if(search.getOnoff() != null) {
			sql = socialingQuery.getProperty("getOnoffListCount"); // 온오프라인 검색
		}
		
		// 정렬은 읽어오는 갯수는 다르지 않기 때문에 X

		try {
			pstmt = conn.prepareStatement(sql);
			
			// 검색 SQL문을 실행하는 경우 검색 값 설정
			if(search.getKeyword() != null) {
				pstmt.setString(1, search.getKeyword());
			} else if(search.getLocal() != null) {
				pstmt.setString(1, search.getLocal());
			}/* else if(search.getDateIn() != null) {
//				pstmt.setDate(1, search.getDateIn());
			}*/ else if(search.getOnoff() != null) {
				pstmt.setString(1, search.getOnoff());
			}

			rset = pstmt.executeQuery();

			if(rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}

	// 게시물 리스트 조회
	public List<Socialing> selectList(Connection conn, PageInfo pi, Search search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = socialingQuery.getProperty("selectList");
		List<Socialing> socialingList = new ArrayList<>();
		
		// 검색 시 수행할 쿼리문 변경
		if(search.getKeyword() != null) {
			sql = socialingQuery.getProperty("selectKeywordList"); // 키워드 검색
		} else if(search.getLocal() != null) {
			sql = socialingQuery.getProperty("selectLocalList"); // 지역 검색
		}/* else if(search.getDateIn() != null) {
			sql = socialingQuery.getProperty("selectDateList"); // 날짜 검색
		}*/ else if(search.getOnoff() != null) {
			sql = socialingQuery.getProperty("selectOnoffList"); // 온오프라인 검색
		}
		
		// 정렬 시 수행할 쿼리문 변경
		if(search.getSort() != null) {
			if(search.getSort().equals("rec")) {
				sql = socialingQuery.getProperty("selectRecList"); // 최신순 정렬 (작성일 순)
			} else if(search.getSort().equals("pop")) {
				sql = socialingQuery.getProperty("selectPopList"); // 인기순 정렬 (참여 인원 순...에서 일단 조회수 순)
			}
		}

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			int index = 1;
			// 검색 sql 실행 시
			if(search.getKeyword() != null) {
				pstmt.setString(index++, search.getKeyword());
			} else if(search.getLocal() != null) {
				pstmt.setString(index++, search.getLocal());
				pstmt.setString(index++, search.getKeyword());
			}/* else if(search.getDateIn() != null) {
//				pstmt.setDate(index++, search.getDateIn());
			}*/ else if(search.getOnoff() != null) {
				pstmt.setString(index++, search.getOnoff());
				pstmt.setString(index++, search.getKeyword());
			}
			
			// if문에 안 걸림(검색X) : 1 -> 2
			// if문에 걸림(검색O) : if문 안의 index가 1 / 2 -> 3
			pstmt.setInt(index++, startRow);
			pstmt.setInt(index, endRow);

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
	
	// 게시물 리스트 조회 (시작 임박)
	public List<Socialing> selectSoonList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = socialingQuery.getProperty("selectSoonList");
		List<Socialing> socialingSoonList = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				Socialing socialing = new Socialing();
				socialing.setnNum(rset.getInt("notice_num"));
				socialing.setnTitle(rset.getString("notice_title"));
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
				
				socialingSoonList.add(socialing);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return socialingSoonList;
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
				socialing.setSdate(rset.getDate("s_date"));
				socialing.setStime(rset.getString("s_time"));
				socialing.setStype(rset.getString("s_type"));
				socialing.setMaxMember(rset.getInt("max_member"));
				socialing.setMinMember(rset.getInt("min_member"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return socialing;
	}
	
	public Socialing selectWriterProfile(Connection conn, int nNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Socialing writerProfile = null;
		String sql = socialingQuery.getProperty("selectWriterProfile");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				writerProfile = new Socialing();
				
				ProfileFile profile = new ProfileFile();
				profile.setRoute(rset.getString("route"));
				profile.setChangeName(rset.getString("change_name"));
				writerProfile.setProfile(profile);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return writerProfile;
	}
	
	public Socialing selectWriterItd(Connection conn, int nNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Socialing writerItd = null;
		String sql = socialingQuery.getProperty("selectWriterItd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				writerItd = new Socialing();
				writerItd.setIntroduction(rset.getString("introduction"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return writerItd;
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
			
			// 썸네일 사진 1개 (사진 추가해야 되면 while문으로 변경)
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
	
	// 소셜링 참여 멤버 조회
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
				if(rset.getString("route") != null && rset.getString("change_name") != null) {
					ProfileFile profile = new ProfileFile();
					profile.setRoute(rset.getString("route"));
					profile.setChangeName(rset.getString("change_name"));
					sMember.setProfile(profile);
				}
				if(rset.getString("introduction") != null) {
					sMember.setIntroduction(rset.getString("introduction"));
				}
				
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
	
	public List<SocialingMember> selectMemberProfile(Connection conn, int nNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<SocialingMember> memberProfile = new ArrayList<>();
		String sql = socialingQuery.getProperty("selectMemberProfile");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nNum);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				SocialingMember sMember = new SocialingMember();
				
				ProfileFile profile = new ProfileFile();
				profile.setRoute(rset.getString("route"));
				profile.setChangeName(rset.getString("change_name"));
				sMember.setProfile(profile);
				
				memberProfile.add(sMember);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return memberProfile;
	}

	public List<SocialingMember> selectMemberItd(Connection conn, int nNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<SocialingMember> memberItd = new ArrayList<>();
		String sql = socialingQuery.getProperty("selectMemberItd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nNum);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				SocialingMember sMember = new SocialingMember();
				sMember.setIntroduction(rset.getString("introduction"));
				
				memberItd.add(sMember);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return memberItd;
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
			pstmt.setDate(2, (Date)socialing.getSdate());
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

	public int updateNotice(Connection conn, Socialing socialing) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = socialingQuery.getProperty("updateNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, socialing.getnTitle());
			pstmt.setString(2, socialing.getnContent());
			pstmt.setInt(3, socialing.getnNum());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateSocialing(Connection conn, Socialing socialing) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = socialingQuery.getProperty("updateSocialing");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setDate(1, (Date)socialing.getSdate());
			pstmt.setString(2, socialing.getStime());
			pstmt.setString(3, socialing.getStype());
			pstmt.setString(4, socialing.getSplace());
			pstmt.setInt(5, socialing.getMinMember());
			pstmt.setInt(6, socialing.getMaxMember());
			pstmt.setInt(7, socialing.getnNum());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updatePhoto(Connection conn, SodaFile photo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = socialingQuery.getProperty("updatePhoto");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, photo.getOriginName());
			pstmt.setString(2, photo.getChangeName());
			pstmt.setString(3, photo.getDeletedName());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteSocialing(Connection conn, int nNum) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = socialingQuery.getProperty("deleteSocialing");
		
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

	public int deletePhoto(Connection conn, int nNum) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = socialingQuery.getProperty("deletePhoto");
		
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

	public int likeSocialing(Connection conn, int nNum, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = socialingQuery.getProperty("likeSocialing");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setInt(2, nNum);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public SocialingLike selectLikedList(Connection conn, int nNum, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		SocialingLike socialingLike = null;
		String sql = socialingQuery.getProperty("selectLikedList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nNum);
			pstmt.setString(2, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				socialingLike = new SocialingLike();
				socialingLike.setUserId(rset.getString("user_id"));
				socialingLike.setLikeNum(rset.getInt("like_num"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return socialingLike;
	}

	public int unLikeSocialing(Connection conn, int nNum, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = socialingQuery.getProperty("unLikeSocialing");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setInt(2, nNum);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<Socialing> socialinglistview(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Socialing> socialingList = new ArrayList<>();
		String sql = socialingQuery.getProperty("socialinglistview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				Socialing socialing = new Socialing();
				socialing.setnNum(rset.getInt("notice_num"));
				socialing.setnTitle(rset.getString("notice_title"));
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

}
