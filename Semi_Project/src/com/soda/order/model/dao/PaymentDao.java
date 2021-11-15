package com.soda.order.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.soda.member.model.dao.MemberDao;
import com.soda.order.model.vo.Payment;

public class PaymentDao {
	
private Properties paymentQuery = new Properties();
	
	public PaymentDao() {
		paymentQuery = new Properties();
		String fileName = MemberDao.class.getResource("/com/sql/wishlist/payment-query.xml").getPath();
		try {
			paymentQuery.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int lessonMemberInsert(Connection conn, Payment payment) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = paymentQuery.getProperty("lessonMemberInsert");
		
		try {
			pstmt =conn.prepareStatement(sql);
			
			pstmt.setString(1, payment.getUserId());
			pstmt.setInt(2, payment.getnNum());
			pstmt.setDate(3, payment.getSelectDate());
			pstmt.setString(4, payment.getcType());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}

	public int payInsert(Connection conn, Payment payment) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = paymentQuery.getProperty("payInsert");
		
		try {
			pstmt =conn.prepareStatement(sql);
			
			pstmt.setString(1, payment.getPayOption());
			pstmt.setString(2, payment.getPayPhone());
			pstmt.setString(3, payment.getPayEmail());
			pstmt.setString(4, payment.getUserId());
			pstmt.setInt(5, payment.getnNum());
			pstmt.setString(6, payment.getPayId());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;

	}

	public int wishlistEnd(Connection conn, Payment payment) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = paymentQuery.getProperty("wishlistEnd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, payment.getUserId());
			pstmt.setInt(2, payment.getnNum());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
		
	}

}
