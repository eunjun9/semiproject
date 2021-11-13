package com.soda.mypage.model.vo;

import java.util.List;

public class Profile {
//	USER_ID	VARCHAR2(30 BYTE)
//	PROFILE	VARCHAR2(50 BYTE)
//	INTRODUCTION	VARCHAR2(100 BYTE)
//	FEED_STATUS	VARCHAR2(5 BYTE)
//	SOCIALING	VARCHAR2(5 BYTE)
//	SNS	VARCHAR2(20 BYTE)
//	INTEREST	VARCHAR2(30 BYTE)
//	LIKE_SOCIALING	VARCHAR2(30 BYTE)
	
	
	private String userId;
	private String introduction;
	private String sns;
	private String interest;
	
	private String userName;
	private String userGrade;
	
	List<ProfileFile> profileFile;
	
	
	
	public Profile() {}



	public Profile(String userId, String introduction, String sns, String interest, List<ProfileFile> profileFile) {
		super();
		this.userId = userId;
		this.introduction = introduction;
		this.sns = sns;
		this.interest = interest;
		this.profileFile = profileFile;
	}


	
	

	public Profile(String userId, String introduction, String sns, String interest, String userName, String userGrade,
			List<ProfileFile> profileFile) {
		super();
		this.userId = userId;
		this.introduction = introduction;
		this.sns = sns;
		this.interest = interest;
		this.userName = userName;
		this.userGrade = userGrade;
		this.profileFile = profileFile;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getIntroduction() {
		return introduction;
	}



	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}



	public String getSns() {
		return sns;
	}



	public void setSns(String sns) {
		this.sns = sns;
	}



	public String getInterest() {
		return interest;
	}



	public void setInterest(String interest) {
		this.interest = interest;
	}



	public List<ProfileFile> getProfileFile() {
		return profileFile;
	}



	public void setProfileFile(List<ProfileFile> profileFile) {
		this.profileFile = profileFile;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserGrade() {
		return userGrade;
	}



	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}



	@Override
	public String toString() {
		return "Profile [userId=" + userId + ", introduction=" + introduction + ", sns=" + sns + ", interest="
				+ interest + ", userName=" + userName + ", userGrade=" + userGrade + ", profileFile=" + profileFile
				+ "]";
	}




	}