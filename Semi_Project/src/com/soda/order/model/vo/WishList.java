package com.soda.order.model.vo;


public class WishList {
	private String userId;
	private int nNum;
	
	/*
	USER_ID	VARCHAR2(30 BYTE)
	NOTICE_NUM	NUMBER
	*/
	
	public WishList() {}
	
	public WishList(String userId, int nNum) {
		super();
		this.userId = userId;
		this.nNum = nNum;
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

	@Override
	public String toString() {
		return "WishList [userId=" + userId + ", nNum=" + nNum + "]";
	}
	
	
	
}
