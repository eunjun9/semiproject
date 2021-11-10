package com.soda.mypage.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.soda.lesson.model.vo.Attachment;
import com.soda.lesson.model.vo.Lesson;
import static com.common.JDBCTemplate.*;

public class MypageDao {
	
	// xml 읽어오기
	private Properties mypageQuery;

	public MypageDao() {
		mypageQuery = new Properties();
		// 작성한 쿼리문(xml) 경로 읽어오기
		String fileName = MypageDao.class.getResource("/com/sql/mypage/mypage-query.xml").getPath();
		try {
			// 읽어온 경로를 FileInputStream을 이용해서 쿼리문의 entry를 프로퍼티인 memberQuery로 로드
			mypageQuery.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 강사가 작성한 클래스 조회
	public List<Lesson> selectLessonList(Connection conn, String user) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Lesson> lessonList = new ArrayList<>();
		String sql = mypageQuery.getProperty("selectLessonList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				Lesson lesson = new Lesson();
				lesson.setnNum(rset.getInt("notice_num"));
				lesson.setnTitle(rset.getString("notice_title"));
				lesson.setnStatus(rset.getString("notice_status"));
				lesson.setnDate(rset.getDate("notice_date"));
				lesson.setcCategory(rset.getString("c_category"));
				lesson.setoDate1(rset.getDate("o_date1"));
				lesson.setoDate2(rset.getDate("o_date2"));
				lesson.setvDate(rset.getString("v_date"));
				
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

}
