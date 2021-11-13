package com.soda.admin.model.dao;

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

import com.soda.admin.model.vo.Payroll;
import com.soda.admin.model.vo.Report;

public class AdminDao {
	
private Properties adminQuery = new Properties();
	
	public AdminDao() {
		adminQuery = new Properties();
		String fileName = AdminDao.class.getResource("/com/sql/admin/admin-query.xml").getPath();
		
		try {
			adminQuery.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 게시글 신고 접수
	public int insertReport(Connection conn, Report report) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = adminQuery.getProperty("insertReport");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, report.getrReason());
			pstmt.setInt(2, report.getnNum());
			pstmt.setString(3, report.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	// 정산 내역 조회
	public List<Payroll> payrollSelect(Connection conn, String year, String month) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Payroll> payroll = new ArrayList<>();
		String sql = adminQuery.getProperty("payrollSelect");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, year);
			pstmt.setString(2, month);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				payroll.add(new Payroll(rset.getString("notice_title"),
										rset.getString("user_name"),
										rset.getString("c_writer"),
										rset.getInt("notice_num"),
										rset.getInt("total"),
										rset.getInt("taxtotal")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return payroll;
		
	}

	// 정산내역 옵션값 조회해오기
	public List<Payroll> payrollYear(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Payroll> payrollYear = new ArrayList<>();
		String sql = adminQuery.getProperty("payrollYear");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				payrollYear.add(new Payroll(rset.getInt("optionyear")));
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return payrollYear;
		
		}

}
