package com.soda.admin.model.service;

import java.util.List;

import java.sql.Connection;
import static com.common.JDBCTemplate.*;
import com.soda.admin.model.dao.AdminDao;
import com.soda.admin.model.vo.Payroll;
import com.soda.admin.model.vo.Report;

public class AdminService {
	
	private AdminDao adminDao = new AdminDao();

	
	// 게시글 신고 접수
	public int insertReport(Report report) {
		Connection conn = getConnection();
		
		int result = adminDao.insertReport(conn, report);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	
	// 정산내역 조회
	public List<Payroll> payrollSelect(String year, String month) {
		Connection conn = getConnection();
		
		List<Payroll> payroll = adminDao.payrollSelect(conn, year, month);
		
		close(conn);
		
		return payroll;		
		
	}

	// 정산내역 option 값 조회해오기
	public List<Payroll> payrollYear() {
		Connection conn = getConnection();
		
		List<Payroll> payrollYear = adminDao.payrollYear(conn);
		
		close(conn);
		
		return payrollYear;
	}
	
}
