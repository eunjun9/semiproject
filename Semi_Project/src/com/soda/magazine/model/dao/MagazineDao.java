package com.soda.magazine.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.soda.lesson.model.dao.LessonDao;
import com.soda.lesson.model.vo.File;
import com.soda.lesson.model.vo.Lesson;
import com.soda.lesson.model.vo.PageInfo;
import com.soda.magazine.model.vo.Notice;

public class MagazineDao {
	
	// xml 읽어오기
	private Properties magazineQuery;
	
	public MagazineDao() { 
		magazineQuery = new Properties();
		// 작성한 쿼리문(xml) 경로 읽어오기
		String fileName = LessonDao.class.getResource("/com/sql/magazine/magazine-query.xml").getPath();
		try {
			// 읽어온 경로를 FileInputStream을 이용해서 쿼리문의 entry를 프로퍼티인 memberQuery로 로드
			magazineQuery.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// 게시물 개수 조회
	public int getListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = magazineQuery.getProperty("getListCount");
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
		public List<Notice> selectList(Connection conn, PageInfo pi) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = magazineQuery.getProperty("selectList");
			List<Notice> noticeList = new ArrayList<>();
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				int startRow = (pi.getPage() - 1) * pi.getBoardLimit() + 1;
				int endRow = startRow + pi.getBoardLimit() - 1;
				
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					Notice notice = new Notice();
					notice.setnNum(rset.getInt("notice_num"));
					notice.setnTitle(rset.getNString("notice_title"));
					notice.setnStatus(rset.getString("notice_status"));
					notice.setnDate(rset.getDate("notice_date"));
					notice.setUserId(rset.getString("user_name"));
					notice.setModifyDate(rset.getDate("modify_date"));
					
					List<File> photoList = new ArrayList<>();
					File photo = new File();
					photo.setFileNum(rset.getInt("file_num"));
					photo.setOriginName(rset.getString("origin_name"));
					photo.setChangeName(rset.getString("change_name"));
					photo.setRoute(rset.getString("route"));
					photo.setFileLevel(rset.getInt("file_level"));
					photo.setStatus(rset.getString("status"));
					
					photoList.add(photo);
					
					notice.setPhotoList(photoList);
					
					noticeList.add(notice);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return noticeList;
		}
		
	}