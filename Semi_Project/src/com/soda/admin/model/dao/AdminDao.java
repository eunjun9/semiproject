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
										rset.getInt("total")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return payroll;
		
	}

}
