package com.soda.admin.model.vo;

import java.sql.Date;

public class SalesList {
	private String filter;	// 콤보박스 필터
	// notice
	private String nTitle;	// 클래스명(group)
	// payment
	private Date pDate;		// 결제일(group)
	private String pOption;	// 결제수단(group)
	private int pCount;		// 결제건수(count)
	// class
	private int pTotal;		// 총매출액(sum - c_price)
	
	public SalesList() {}

	public SalesList(String filter, String nTitle, Date pDate, String pOption, int pCount, int pTotal) {
		super();
		this.filter = filter;
		this.nTitle = nTitle;
		this.pDate = pDate;
		this.pOption = pOption;
		this.pCount = pCount;
		this.pTotal = pTotal;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public Date getpDate() {
		return pDate;
	}

	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}

	public String getpOption() {
		return pOption;
	}

	public void setpOption(String pOption) {
		this.pOption = pOption;
	}

	public int getpCount() {
		return pCount;
	}

	public void setpCount(int pCount) {
		this.pCount = pCount;
	}

	public int getpTotal() {
		return pTotal;
	}

	public void setpTotal(int pTotal) {
		this.pTotal = pTotal;
	}

	@Override
	public String toString() {
		return "SalesList [filter=" + filter + ", nTitle=" + nTitle + ", pDate=" + pDate + ", pOption=" + pOption
				+ ", pCount=" + pCount + ", pTotal=" + pTotal + "]";
	}
}
