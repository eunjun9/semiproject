package com.soda.lesson.model.dao;

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

import com.soda.lesson.model.vo.Attachment;
import com.soda.lesson.model.vo.Lesson;
import com.soda.lesson.model.vo.PageInfo;

import static com.common.JDBCTemplate.*;

public class LessonDao {

	// xml 읽어오기
	private Properties lessonQuery;
	
	public LessonDao() { 
		lessonQuery = new Properties();
		// 작성한 쿼리문(xml) 경로 읽어오기
		String fileName = LessonDao.class.getResource("/com/sql/lesson/lesson-query.xml").getPath();
		try {
			// 읽어온 경로를 FileInputStream을 이용해서 쿼리문의 entry를 프로퍼티인 memberQuery로 로드
			lessonQuery.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 게시물 개수 조회
	public int getListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = lessonQuery.getProperty("getListCount");
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
	public List<Lesson> selectList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = lessonQuery.getProperty("selectList");
		List<Lesson> lessonList = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Lesson lesson = new Lesson();
				lesson.setnNum(rset.getInt("notice_num"));
				lesson.setnTitle(rset.getNString("notice_title"));
				lesson.setnCount(rset.getInt("nCount"));
				lesson.setnStatus(rset.getString("notice_status"));
				lesson.setnDate(rset.getDate("notice_date"));
				lesson.setUserId(rset.getString("user_name"));
				lesson.setModifyDate(rset.getDate("modify_date"));
				lesson.setcPrice(rset.getInt("c_price"));
				
				List<Attachment> photoList = new ArrayList<>();
				Attachment photo = new Attachment();
				photo.setFileNum(rset.getInt("file_num"));
				photo.setOriginName(rset.getString("origin_name"));
				photo.setChangeName(rset.getString("change_name"));
				photo.setRoute(rset.getString("route"));
				photo.setFileLevel(rset.getInt("file_level"));
				photo.setStatus(rset.getString("status"));
				
				photoList.add(photo);
				
				lesson.setPhotoList(photoList);
				
				lessonList.add(lesson);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return lessonList;
	}

	// 조회수 증가
	public int increaseCount(Connection conn, int nNum) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = lessonQuery.getProperty("increaseCount");
		
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
	
	// 클래스 상세페이지 조회
	public Lesson selectLesson(Connection conn, int nNum) {
		PreparedStatement pstmt = null;
		Lesson lesson = null;
		ResultSet rset = null;
		String sql = lessonQuery.getProperty("selectLesson");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nNum);
	
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				lesson = new Lesson();
				lesson.setnNum(rset.getInt("notice_num"));
				lesson.setnTitle(rset.getString("notice_title"));
				lesson.setUserName(rset.getString("user_name"));
				lesson.setUserId(rset.getString("c_writer"));
				lesson.setcCategory(rset.getString("c_category"));
				lesson.setcPrice(rset.getInt("c_price"));
				lesson.setnContent(rset.getString("notice_content"));
				lesson.setCtag1(rset.getString("c_tag1"));
				lesson.setCtag2(rset.getString("c_tag2"));
				lesson.setvDate(rset.getString("v_date")); // 시작 날짜는 날짜만
				lesson.setoDate1(rset.getDate("o_date1"));
				lesson.setoDate2(rset.getDate("o_date2"));
				lesson.setcTime1(rset.getString("c_time1"));
				lesson.setcTime2(rset.getString("c_time2"));
				lesson.setcLocation(rset.getString("c_location"));
				lesson.setcTutor(rset.getString("c_tutor"));
				lesson.setnDate(rset.getDate("notice_date")); // 작성-수정 날짜는 시간까지
				lesson.setModifyDate(rset.getDate("modify_date"));
				lesson.setnStatus(rset.getString("notice_status"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return lesson;
	}

	public List<Attachment> selectPhotoList(Connection conn, int nNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Attachment> photoList = new ArrayList<>();
		String sql = lessonQuery.getProperty("selectPhotoList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nNum);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				Attachment attachment = new Attachment();
				attachment.setFileNum(rset.getInt("file_num"));
				attachment.setOriginName(rset.getString("origin_name"));
				attachment.setChangeName(rset.getString("change_name"));
				attachment.setRoute(rset.getString("route"));
				attachment.setFileLevel(rset.getInt("file_level"));
				
				photoList.add(attachment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return photoList;
	}

	// 글 삽입 - notice 테이블
	public int insertNotice(Connection conn, Lesson lesson) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = lessonQuery.getProperty("insertNotice");
		
		try {
			pstmt =conn.prepareStatement(sql);
			
			pstmt.setString(1, lesson.getnTitle());
			pstmt.setString(2, lesson.getnContent());
			pstmt.setString(3, lesson.getnType());
			pstmt.setString(4, lesson.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	// 클 삽입 - lesson 테이블
	public int insertLesson(Connection conn, Lesson lesson) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = lessonQuery.getProperty("insertLesson");
		
		try {
			pstmt =conn.prepareStatement(sql);
			
			pstmt.setString(1, lesson.getCtag1());
			pstmt.setString(2, lesson.getCtag2());
			pstmt.setInt(3, lesson.getcPrice());
			pstmt.setString(4, lesson.getcCategory());
			pstmt.setString(5,lesson.getvDate());
			pstmt.setDate(6, (Date) lesson.getoDate1());
			pstmt.setDate(7, (Date) lesson.getoDate2());
			pstmt.setString(8, lesson.getcLocation());
			pstmt.setString(9, lesson.getcTutor());
			pstmt.setString(10, lesson.getUserId());
			pstmt.setString(11, lesson.getcTime1());
			pstmt.setString(12, lesson.getcTime2());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	// 사진 삽입
	public int insertAttachment(Connection conn, Attachment photo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = lessonQuery.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, photo.getRoute());
			pstmt.setString(2, photo.getOriginName());
			pstmt.setString(3, photo.getChangeName());
			pstmt.setInt(4, photo.getFileLevel());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteLesson(Connection conn, int nNum) {
		PreparedStatement pstmt = null;
		String sql = lessonQuery.getProperty("deleteLesson");
		int result = 0;
		
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
		String sql = lessonQuery.getProperty("deletePhoto");
		int result = 0;
		
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


}
