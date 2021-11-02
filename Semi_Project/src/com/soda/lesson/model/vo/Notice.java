package com.soda.lesson.model.vo;

import java.util.Date;

public class Notice {
	private int nNum;			// 게시글 번호 pk
	private String nTitle;		// 게시글 제목
	private String nContent;	// 게시글 내용
	private String nStatus;		// 상태 (Y, N)
	private String nType;		// 게시판 종류 (클래스, 소셜링, 매거진)
	private String userId;		// 사용자 아이디 (Member_info 테이블 참조)
	private String userName; 	// 사용자 이름 (Member_info 테이블 참조)
	private Date nDate;			// 작성 날짜
	private Date modifyDate;	// 수정 날짜
	
	public Notice() {}


	public Notice(int nNum, String nTitle, String nContent, String nStatus, String nType, String userId,
			String userName, Date nDate, Date modifyDate) {
		super();
		this.nNum = nNum;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nStatus = nStatus;
		this.nType = nType;
		this.userId = userId;
		this.userName = userName;
		this.nDate = nDate;
		this.modifyDate = modifyDate;
	}



	public int getnNum() {
		return nNum;
	}

	public void setnNum(int nNum) {
		this.nNum = nNum;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public Date getnDate() {
		return nDate;
	}

	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}

	public String getnStatus() {
		return nStatus;
	}

	public void setnStatus(String nStatus) {
		this.nStatus = nStatus;
	}

	public String getnType() {
		return nType;
	}

	public void setnType(String nType) {
		this.nType = nType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}


	@Override
	public String toString() {
		return "Notice [nNum=" + nNum + ", nTitle=" + nTitle + ", nContent=" + nContent + ", nDate=" + nDate
				+ ", nStatus=" + nStatus + ", nType=" + nType + ", userId=" + userId + ", modifyDate=" + modifyDate
			 + "]";
	};
	
	
}
