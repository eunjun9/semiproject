package com.soda.magazine.model.vo;

import java.util.Date;

public class Reply {

//	REPLY_NUM
//	REPLY_CONTENT
//	RWRITER
//	NOTICE_NUM
//	REPLY_DATE
//	REPLY_MODIFYDATE
//	REPLY_STATUS
//	REPLY_SELF_NUM
	
	private int rNum;
	private String rContent;
	private String rWriter;
	private int nNum;
	private String UserId;
	private Date rDate;
	private Date rModifyDate;
	private String rStatus;
	private int rSelfNum;
	
	public Reply(){}

	public Reply(int rNum, String rContent, String rWriter, int nNum, String userId, Date rDate, Date rModifyDate,
			String rStatus, int rSelfNum) {
		super();
		this.rNum = rNum;
		this.rContent = rContent;
		this.rWriter = rWriter;
		this.nNum = nNum;
		UserId = userId;
		this.rDate = rDate;
		this.rModifyDate = rModifyDate;
		this.rStatus = rStatus;
		this.rSelfNum = rSelfNum;
	}


	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public String getrWriter() {
		return rWriter;
	}

	public void setrWriter(String rWriter) {
		this.rWriter = rWriter;
	}

	public int getnNum() {
		return nNum;
	}

	public void setnNum(int nNum) {
		this.nNum = nNum;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public Date getrDate() {
		return rDate;
	}

	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}

	public Date getrModifyDate() {
		return rModifyDate;
	}

	public void setrModifyDate(Date rModifyDate) {
		this.rModifyDate = rModifyDate;
	}

	public String getrStatus() {
		return rStatus;
	}

	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}

	public int getrSelfNum() {
		return rSelfNum;
	}

	public void setrSelfNnum(int rSelfNum) {
		this.rSelfNum = rSelfNum;
	}

	@Override
	public String toString() {
		return "Reply [rNum=" + rNum + ", rContent=" + rContent + ", rWriter=" + rWriter + ", nNum=" + nNum
				+ ", UserId=" + UserId + ", rDate=" + rDate + ", rModifyDate=" + rModifyDate + ", rStatus=" + rStatus
				+ ", rSelfNnum=" + rSelfNum + "]";
	}

	
	
	
	
	
	

}