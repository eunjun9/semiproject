package com.soda.socialing.model.vo;

public class SocialingLike {
	private String userId;	// 회원 아이디
	private int likeNum;	// 관심글 번호

	public SocialingLike() {}

	public SocialingLike(String userId, int likeNum) {
		super();
		this.userId = userId;
		this.likeNum = likeNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}

	@Override
	public String toString() {
		return "SocialingLike [userId=" + userId + ", likeNum=" + likeNum + "]";
	}
	
}
