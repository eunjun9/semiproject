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
import com.soda.lesson.model.vo.Filter;
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
	public int getListCount(Connection conn, Filter filter) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = lessonQuery.getProperty("getListCount");
		int listCount = 0;
		
		/* 필터링, 정렬방식 선택 된 목록 조회할 때 사용할 SQL문 */
		// 검색 키워드 
		if(filter.getKeyword() != null ) {
			sql = lessonQuery.getProperty("getKeywordListCount");
		}
 
		// 가격 1 
		if(filter.getPrice1() != null && filter.getPrice2() != null) {
			sql = lessonQuery.getProperty("getPriceListCount");
		}
		
		// 원데이
		if(filter.getOneday() != null || filter.getVod() != null){
			sql = lessonQuery.getProperty("getOnedayListCount");
		}
		
		// 카테고리 대분류
		if(filter.getBigC() != null && filter.getSmallC() != null) {
			sql = lessonQuery.getProperty("getBigCListCount");
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			// 필터링 & 정렬 sql 문을 실행하는 경우 설정 
			if (filter.getKeyword() != null) {
				pstmt.setString(1, filter.getKeyword());
			}
			if(filter.getPrice1() != null && filter.getPrice2() != null) {
				pstmt.setString(1, filter.getPrice1());
				pstmt.setString(2, filter.getPrice2());
			}
			if(filter.getOneday() != null || filter.getVod() != null){
				pstmt.setString(1, filter.getOneday());
				pstmt.setString(2, filter.getVod());
			}
			
			// 카테고리 대분류
			if(filter.getBigC() != null && filter.getSmallC() != null ) {
				pstmt.setString(1, filter.getBigC());
				pstmt.setString(2, filter.getSmallC());
			}
			
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
	
	// 페이징 처리된 게시물 리스트 조회 (+필터링 / 정렬 기준)
	public List<Lesson> selectList(Connection conn, PageInfo pi, Filter filter) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = lessonQuery.getProperty("selectList");
		List<Lesson> lessonList = new ArrayList<>();
		
		// 키워드
		if(filter.getKeyword() != null ) {
			sql = lessonQuery.getProperty("getKeywordList");
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			int index = 1;
			
				if (filter.getKeyword() != null) {
					pstmt.setString(index++, filter.getKeyword());
					if (filter.getPrice1() != null && filter.getPrice2() != null) {
						pstmt.setString(index++, filter.getPrice1()); 
						pstmt.setString(index++, filter.getPrice2()); 
						if (filter.getOneday() != null || filter.getVod() != null) {
							  pstmt.setString(index++, filter.getOneday()); 
							  pstmt.setString(index++, filter.getVod()); 
							  if (filter.getBigC() != null && filter.getSmallC() != null) {
								   pstmt.setString(index++, filter.getBigC()); 
								   pstmt.setString(index++, filter.getSmallC());
							  } 
						}
					}
				}
			
			pstmt.setInt(index++, startRow);
			pstmt.setInt(index, endRow);
			
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
				lesson.setCtag1(rset.getString("c_tag1"));
				lesson.setCtag2(rset.getString("c_tag2"));
				lesson.setcCategory(rset.getString("c_category"));
				
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
				lesson.setnCount(rset.getInt("ncount"));
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
	
	// 클래스 조회
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

	// 클래스 삽입 : 글 (notice 테이블)
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
	
	// 클래스 삽입 : 글 (lesson 테이블)
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
	
	// 클래스 삽입 : 사진 
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
	
	// 클래스 삭제 : 글
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

	// 클래스 삭제 : 사진
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
	
	// 클래스 수정 : 글 (lesson 테이블)
	public int updateLesson(Connection conn, Lesson lesson) {
		PreparedStatement pstmt = null;
		String sql = lessonQuery.getProperty("updateLesson");
		int result = 0;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, lesson.getCtag1());
			pstmt.setString(2, lesson.getCtag2());
			pstmt.setInt(3, lesson.getcPrice());
			pstmt.setString(4,lesson.getvDate());
			pstmt.setDate(5, (Date) lesson.getoDate1());
			pstmt.setDate(6, (Date) lesson.getoDate2());
			pstmt.setString(7, lesson.getcLocation());
			pstmt.setString(8, lesson.getcTutor());
			pstmt.setString(9, lesson.getcTime1());
			pstmt.setString(10, lesson.getcTime2());
			pstmt.setInt(11, lesson.getnNum());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	// 클래스 수정 : 글 (notice 테이블)
	public int updateNotice(Connection conn, Lesson lesson) {
		PreparedStatement pstmt = null;
		String sql = lessonQuery.getProperty("updateNotice");
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, lesson.getnTitle());
			pstmt.setString(2, lesson.getnContent());
			pstmt.setInt(3, lesson.getnNum());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	// 클래스 수정 : 기존 사진 변경
	public int updatePhoto(Connection conn, Attachment photo) {
		PreparedStatement pstmt = null;
		String sql = lessonQuery.getProperty("updatePhoto");
		int result = 0;
		
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

	// 클래스 수정 : 사진 추가
	public int insertAddedPhoto(Connection conn, int nNum, Attachment photo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = lessonQuery.getProperty("insertAddedPhoto");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nNum);
			pstmt.setString(2, photo.getRoute());
			pstmt.setString(3, photo.getOriginName());
			pstmt.setString(4, photo.getChangeName());
			pstmt.setInt(5, photo.getFileLevel());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public List<Lesson> lessonlistview(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = lessonQuery.getProperty("selectlessonList");
		List<Lesson> lessonlistview = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Lesson lesson = new Lesson();
				lesson.setnNum(rset.getInt("notice_num"));
				lesson.setnTitle(rset.getString("notice_title"));
				lesson.setcLocation(rset.getString("c_location"));
				lesson.setvDate(rset.getString("v_date"));
				
				List<Attachment> photoList = new ArrayList<>();
				Attachment photo = new Attachment();
				photo.setChangeName(rset.getString("change_name"));
				photo.setRoute(rset.getString("route"));
				photo.setStatus(rset.getString("status"));
				
				photoList.add(photo);
				
				lesson.setPhotoList(photoList);
				
				lessonlistview.add(lesson);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return lessonlistview;
	}


	

}
