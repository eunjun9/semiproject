package com.soda.lesson.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.soda.lesson.model.vo.Notice;
import com.soda.lesson.model.vo.PageInfo;
import static com.common.JDBCTemplate.*;

public class noticeDao {

		// xml 읽어오기
		private static Properties noticeQuery;
		
		public noticeDao() { 
			noticeQuery = new Properties();
			// 작성한 쿼리문(xml) 경로 읽어오기
			String fileName = noticeDao.class.getResource("/com/sql/lesson/notice-query.xml").getPath();
			try {
				// 읽어온 경로를 FileInputStream을 이용해서 쿼리문의 entry를 프로퍼티인 memberQuery로 로드
				noticeQuery.loadFromXML(new FileInputStream(fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	
	public static List<Notice> selectList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = noticeQuery.getProperty("selectList");
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
				
				
				noticeList.add(notice);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

}
