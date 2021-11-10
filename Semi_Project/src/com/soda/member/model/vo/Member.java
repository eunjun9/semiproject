package com.soda.member.model.vo;

import java.sql.Date;

public class Member {
	private String userId;			
	private String userName;
	private String userPhone;
	private String userPwd;
	private Date joinDate;
	private String status;
	private String userGrade;
	private String gender;	
	
	/*
	 * USER_ID	VARCHAR2(30 BYTE)
		USER_NAME	VARCHAR2(20 BYTE)
		USER_PHONE	VARCHAR2(20 BYTE)
		USER_PWD	VARCHAR2(20 BYTE)
		JOIN_DATE	DATE
		STATUS	VARCHAR2(5 BYTE)
		USER_GRADE	VARCHAR2(10 BYTE)
		USER_GENDER	VARCHAR2(3 BYTE)
	 * 
	 */

	
	public Member() {}

	// gender 포함
	public Member(String userId, String userName, String userPhone, String userPwd, Date joinDate,
			String status, String userGrade, String gender) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userPwd = userPwd;
		this.joinDate = joinDate;
		this.status = status;
		this.userGrade = userGrade;
		this.gender = gender;
	}
	

	public Member(String userId, String userName, String userPhone, String userPwd, String gender) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userPwd = userPwd;
		this.gender = gender;
	}

	public Member(String userId, String userName, String userPhone) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userName=" + userName + ", userPhone=" + userPhone + ", userPwd="
				+ userPwd + ", joinDate=" + joinDate + ", status=" + status + ", userGrade=" + userGrade + ", gender="
				+ gender + "]";
	}

}
