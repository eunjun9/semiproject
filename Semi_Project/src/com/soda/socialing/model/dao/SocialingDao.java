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

import com.soda.socialing.model.vo.File;
import com.soda.socialing.model.vo.PageInfo;
import com.soda.socialing.model.vo.Socialing;

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

			if (rset.next()) {
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
	public List<Socialing> selectList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = socialingQuery.getProperty("selectList");
		List<Socialing> socialingList = new ArrayList<>();

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;

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

				List<File> photoList = new ArrayList<>();
				File file = new File();
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

//	public List<Socialing> selectList(Connection conn) {
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		List<Socialing> socialingList = new ArrayList<>();
//		String sql = socialingQuery.getProperty("selectList");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			
//			rset = pstmt.executeQuery();
//			
//			while(rset.next()) {
//				Socialing socialing = new Socialing();
//				socialing.setnNum(rset.getInt("notice_num"));
//				socialing.setnTitle(rset.getString("notice_title"));
//				socialing.setSplace(rset.getString("s_place"));
//				socialing.setSdate(rset.getDate("s_date"));
//				
//				List<File> photoList = new ArrayList<>();
//				File file = new File();
//				file.setRoute(rset.getString("route"));
//				file.setChangeName(rset.getString("change_name"));
//				photoList.add(file);
//				socialing.setPhotoList(photoList);
//				
//				socialingList.add(socialing);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rset);
//			close(pstmt);
//		}
//		
//		return socialingList;
//	}

}
