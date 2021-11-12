package com.soda.admin.model.service;

import java.util.List;

import java.sql.Connection;
import static com.common.JDBCTemplate.*;
import com.soda.admin.model.dao.AdminDao;
import com.soda.admin.model.vo.Payroll;
import com.soda.admin.model.vo.Report;

public class AdminService {
	
	private AdminDao adminDao = new AdminDao();

	
	
	public int insertReport(Report report) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	// 정산내역 조회
	public List<Payroll> payrollSelect(String year, String month) {
		Connection conn = getConnection();
		
		List<Payroll> payroll = adminDao.payrollSelect(conn, year, month);
		
		close(conn);
		
		return payroll;		
		
	}
	
}
