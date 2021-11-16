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
import com.soda.admin.model.vo.SalesList;
import com.soda.admin.model.vo.Refund;

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
	
	// 신고 내역 조회 - 정렬 o
	public List<Report> selectreportList(Connection conn, Report report2) {
		PreparedStatement pstmt = null;
		String sql= adminQuery.getProperty("selectreportList");
		ResultSet rset = null;
		List<Report> reportList = new ArrayList<>();
		
		if(report2.getSort() != null) {
			if(report2.getSort().equals("magazine")) {
				sql = adminQuery.getProperty("selectmagazineList");
			} else if(report2.getSort().equals("socialing")) {
				sql = adminQuery.getProperty("selectsocialingList");
			}else {
				sql= adminQuery.getProperty("selectreportList");
			}
		}
			
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				Report report = new Report();
				report.setnNum(rset.getInt("notice_num"));
				report.setCategory(rset.getString("notice_type"));
				report.setNoticeTitle(rset.getString("notice_title"));
				report.setReportedId(rset.getString(4));
				report.setUserId(rset.getString(5));
				report.setrDate(rset.getDate("report_date"));
				report.setrReason(rset.getString("report_reason"));
				
				reportList.add(report);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return reportList;
	}

	
	// 매출조회
	public List<SalesList> selectSalesList(Connection conn, String filter) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<SalesList> salesList = new ArrayList<>();
		String sql = "";
		
		if(filter.equals("class")) {
			sql = adminQuery.getProperty("selectClassList");
		} else if(filter.equals("date")) {
			sql = adminQuery.getProperty("selectDateList");
		} else if(filter.equals("option")) {
			sql = adminQuery.getProperty("selectOptionList");
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			SalesList slist = null;
			while(rset.next()) {
				if(filter.equals("class")) {
					slist = new SalesList();
					slist.setnTitle(rset.getString("notice_title"));
					slist.setpTotal(rset.getInt("ptotal"));
					slist.setpCount(rset.getInt("pcount"));
				} else if(filter.equals("date")) {
					slist = new SalesList();
					slist.setpDate(rset.getDate("pdate"));
					slist.setpTotal(rset.getInt("ptotal"));
					slist.setpCount(rset.getInt("pcount"));
				} else if(filter.equals("option")) {
					slist = new SalesList();
					slist.setpOption(rset.getString("pay_option"));
					slist.setpTotal(rset.getInt("ptotal"));
					slist.setpCount(rset.getInt("pcount"));
				}
			
			salesList.add(slist);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return salesList;
	}

	public List<Refund> selectRefundList(Connection conn, Refund refund) {
		PreparedStatement pstmt = null;
		String sql= adminQuery.getProperty("selectRefundList");
		ResultSet rset = null;
		List<Refund> refundList = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Refund refund2 = new Refund();
				refund2.setnTitle(rset.getString("notice_title"));
				refund2.setpDate(rset.getDate("pay_date"));
				refund2.setfDate(rset.getDate("refund_date"));
				refund2.setUserId(rset.getString("user_id"));
				refund2.setpNum(rset.getInt("pay_num"));
				refund2.setPrice(rset.getInt("c_price"));
				refund2.setrAccount(rset.getString("refund_account"));
				refund2.setBank(rset.getString("bank"));
				refund2.setaHolder(rset.getString("account_holder"));
				refund2.setrProcess(rset.getString("refund_process"));
				
				refundList.add(refund2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return refundList;
	}

	public List<Refund> selectRefundList(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		String sql= adminQuery.getProperty("selectRefundUserList");
		ResultSet rset = null;
		List<Refund> refundList = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Refund refund2 = new Refund();
				
				
				refund2.setnTitle(rset.getString("notice_title"));
				refund2.setpDate(rset.getDate("pay_date"));
				refund2.setfDate(rset.getDate("refund_date"));
				refund2.setUserId(rset.getString("user_id"));
				refund2.setPrice(rset.getInt("c_price"));
				refund2.setrAccount(rset.getString("refund_account"));
				refund2.setBank(rset.getString("bank"));
				refund2.setaHolder(rset.getString("account_holder"));
				
				refundList.add(refund2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return refundList;
	}

	
	
	public Refund selectRefund(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		String sql= adminQuery.getProperty("selectRefund");
		ResultSet rset = null;
		Refund refund = new Refund();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				
				refund.setnTitle(rset.getString("notice_title"));
				refund.setpDate(rset.getDate("pay_date"));
				refund.setfDate(rset.getDate("refund_date"));
				refund.setUserId(rset.getString("user_id"));
				refund.setPrice(rset.getInt("c_price"));
				refund.setrAccount(rset.getString("refund_account"));
				refund.setBank(rset.getString("bank"));
				refund.setaHolder(rset.getString("account_holder"));
				refund.setrProcess(rset.getString("refund_process"));
				refund.setpNum(rset.getInt("pay_num"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return refund;
	
	}

	public int refundModify(Connection conn, Refund refund) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = adminQuery.getProperty("updateAdminRefund");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, refund.getrAccount());
			pstmt.setString(2, refund.getBank());
			pstmt.setString(3, refund.getaHolder());
			pstmt.setString(4, refund.getrProcess());
			pstmt.setInt(5, refund.getpNum());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Refund seletRefundInfo(Connection conn, Refund refund) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = adminQuery.getProperty("selectAdminRefund");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, refund.getpNum());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				refund = new Refund(rset.getString("notice_title"),
									rset.getDate("pay_date"),
									rset.getDate("refund_date"),
									rset.getString("user_id"),
									rset.getInt("pNum"),
									rset.getInt("c_price"),
									rset.getString("refund_account"),
									rset.getString("bank"),
									rset.getString("account_holder"),
									rset.getString("refund_process"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return refund;
	}
}
