package com.soda.mypage.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.soda.lesson.model.vo.Attachment;
import com.soda.lesson.model.vo.Lesson;
import com.soda.lesson.model.vo.PageInfo;
import com.soda.mypage.model.vo.Profile;
import com.soda.mypage.model.vo.ProfileFile;
import com.soda.mypage.model.vo.Refund;
import com.soda.order.model.vo.Payment;
import com.soda.socialing.model.vo.Socialing;
import com.soda.socialing.model.vo.SocialingLike;
import com.soda.socialing.model.vo.SodaFile;

import static com.common.JDBCTemplate.*;

public class RefundDao {
	
	// xml 읽어오기
	private Properties refundQuery;

	public RefundDao() {
		refundQuery = new Properties();
		// 작성한 쿼리문(xml) 경로 읽어오기
		String fileName = RefundDao.class.getResource("/com/sql/mypage/refund-query.xml").getPath();
		try {
			// 읽어온 경로를 FileInputStream을 이용해서 쿼리문의 entry를 프로퍼티인 memberQuery로 로드
			refundQuery.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertRefundInfo(Connection conn, Refund refund) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = refundQuery.getProperty("insertRefundInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, refund.getRefundAccount());
			pstmt.setString(2, refund.getBank());
			pstmt.setString(3, refund.getAccountHolder());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	

}
