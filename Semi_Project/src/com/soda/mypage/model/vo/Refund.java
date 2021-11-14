package com.soda.mypage.model.vo;

import java.util.List;

public class Refund {
//	USER_ID	VARCHAR2(30 BYTE)
//	PROFILE	VARCHAR2(50 BYTE)
//	INTRODUCTION	VARCHAR2(100 BYTE)
//	FEED_STATUS	VARCHAR2(5 BYTE)
//	SOCIALING	VARCHAR2(5 BYTE)
//	SNS	VARCHAR2(20 BYTE)
//	INTEREST	VARCHAR2(30 BYTE)
//	LIKE_SOCIALING	VARCHAR2(30 BYTE)
	
//	REFUND_ACCOUNT	VARCHAR2(30 BYTE)
//	BANK	VARCHAR2(20 BYTE)
//	ACCOUNT_HOLDER	VARCHAR2(30 BYTE)
	
	private String userId;
	private int payNum;
	private String refundAccount;
	private String bank;
	private String accountHolder;
	
	
	
	public Refund() {}
	
	public Refund(String userId, int payNum, String refundAccount, String bank, String accountHolder) {
		super();
		this.userId = userId;
		this.payNum = payNum;
		this.refundAccount = refundAccount;
		this.bank = bank;
		this.accountHolder = accountHolder;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPayNum() {
		return payNum;
	}

	public void setPayNum(int payNum) {
		this.payNum = payNum;
	}

	public String getRefundAccount() {
		return refundAccount;
	}

	public void setRefundAccount(String refundAccount) {
		this.refundAccount = refundAccount;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	@Override
	public String toString() {
		return "Refund [userId=" + userId + ", payNum=" + payNum + ", refundAccount=" + refundAccount + ", bank=" + bank
				+ ", accountHolder=" + accountHolder + "]";
	}

	 
}
	