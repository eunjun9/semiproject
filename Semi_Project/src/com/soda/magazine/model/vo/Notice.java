package com.soda.magazine.model.vo;

import java.util.Date;
import java.util.List;

import com.soda.lesson.model.vo.File;

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
	
	private List<File> photoList;  // 첨부파일
	
	public Notice() {}

	
	
	
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




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public Date getnDate() {
		return nDate;
	}




	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}




	public Date getModifyDate() {
		return modifyDate;
	}




	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}




	public List<File> getPhotoList() {
		return photoList;
	}




	public void setPhotoList(List<File> photoList) {
		this.photoList = photoList;
	}




	@Override
	public String toString() {
		return "Notice [nNum=" + nNum + ", nTitle=" + nTitle + ", nContent=" + nContent + ", nStatus=" + nStatus
				+ ", nType=" + nType + ", userId=" + userId + ", userName=" + userName + ", nDate=" + nDate
				+ ", modifyDate=" + modifyDate + ", photoList=" + photoList + "]";
	}


	
}
