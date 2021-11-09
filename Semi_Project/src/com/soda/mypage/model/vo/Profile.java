package com.soda.mypage.model.vo;

import java.sql.Connection;
import java.util.List;

import com.soda.magazine.model.vo.MagazineFile;

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
	private String profile;
	private String Introduction;
	private String feedStatus;
	private String socialing;
	private String sns;
	private String interest;
	private String likeSocialing;
	
	private List<ProfileFile> photoList; 
	
	
	
	public Profile() {}
	
	
	
	
	
	













	public Profile(String userId, String profile, String introduction, String feedStatus, String socialing, String sns,
			String interest, String likeSocialing, List<ProfileFile> photoList) {
		super();
		this.userId = userId;
		this.profile = profile;
		Introduction = introduction;
		this.feedStatus = feedStatus;
		this.socialing = socialing;
		this.sns = sns;
		this.interest = interest;
		this.likeSocialing = likeSocialing;
		this.photoList = photoList;
	}



















	public List<ProfileFile> getPhotoList() {
		return photoList;
	}



















	public void setPhotoList(List<ProfileFile> photoList) {
		this.photoList = photoList;
	}



















	public String getUserId() {
		return userId;
	}














	public void setUserId(String userId) {
		this.userId = userId;
	}














	public String getProfile() {
		return profile;
	}














	public void setProfile(String profile) {
		this.profile = profile;
	}














	public String getIntroduction() {
		return Introduction;
	}














	public void setIntroduction(String introduction) {
		Introduction = introduction;
	}














	public String getFeedStatus() {
		return feedStatus;
	}














	public void setFeedStatus(String feedStatus) {
		this.feedStatus = feedStatus;
	}














	public String getSocialing() {
		return socialing;
	}














	public void setSocialing(String socialing) {
		this.socialing = socialing;
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














	public String getLikeSocialing() {
		return likeSocialing;
	}














	public void setLikeSocialing(String likeSocialing) {
		this.likeSocialing = likeSocialing;
	}





	@Override
	public String toString() {
		return "Profile [userId=" + userId + ", profile=" + profile + ", Introduction=" + Introduction + ", feedStatus="
				+ feedStatus + ", socialing=" + socialing + ", sns=" + sns + ", interest=" + interest
				+ ", likeSocialing=" + likeSocialing + ", photoList=" + photoList + "]";
	}



	
	
}
