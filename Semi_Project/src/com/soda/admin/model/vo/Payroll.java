package com.soda.admin.model.vo;

public class Payroll {
	
	private String nTitle;		// 클래스명 notice_title
	private String userName;	// 강사명 user_name
	private String userId;		// 강사계정 c_writer
	private int nNum;			// 게시물번호 notice_num
	private int total;			// 매출합계 sum(c_price)
	private int taxTotal;		// 정산금 total*0.2
	
	public Payroll() {}

	public Payroll(String nTitle, String userName, String userId, int nNum, int total) {
		super();
		this.nTitle = nTitle;
		this.userName = userName;
		this.userId = userId;
		this.nNum = nNum;
		this.total = total;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getnNum() {
		return nNum;
	}

	public void setnNum(int nNum) {
		this.nNum = nNum;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTaxTotal() {
		return (int) (total * 0.2);
	}

	public void setTaxTotal(int taxTotal) {
		this.taxTotal = (int) (total * 0.2);
	}

	@Override
	public String toString() {
		return "Payroll [nTitle=" + nTitle + ", userName=" + userName + ", userId=" + userId + ", nNum=" + nNum
				+ ", total=" + total + ", taxTotal=" + taxTotal + "]";
	}
	
	
	
	
	

}
