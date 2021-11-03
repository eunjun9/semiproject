package com.soda.lesson.model.vo;

import java.sql.Date;
import java.util.List;

public class Lesson {
	private int nNum; 			// 게시판 번호 (notice 테이블 참조)
	private String nTitle;		// 게시글 제목 (notice 테이블 참조)
	private String nContent;	// 게시글 내용 (notice 테이블 참조)
	private int nCount;			// 게시판 조회수
	private String nStatus;		// 상태 (Y, N) (notice 테이블 참조)
	private String nType;		// 게시판 종류 (클래스, 소셜링, 매거진)
	private String userId;		// 사용자 아이디 (Member_info 테이블 참조)
	private String userName; 	// 사용자 이름 (Member_info 테이블 참조)
	private Date nDate;			// 작성 날짜 (notice 테이블 참조)
	private Date modifyDate;	// 수정 날짜 (notice 테이블 참조)
	private String ctag1;		// 카테고리 대분류
	private String ctag2;		// 카테고리 소분류
	private int cPrice;			// 가격
	private String cType;		// 타입 (온 오프라인)
	private String cCategogy;	// 카테고리 (원데이 vod)
	private Date cSDate;		// 시작 날짜
	private Date cEDate;		// 종료날짜
	private String cLocation;	// 장소
	private String cTutor;		// 강사 소개
	
	private List<File> photoList;  // 첨부파일
	
	public Lesson() {}


	public Lesson(int nNum, String nTitle, String nContent, int nCount, String nStatus, String nType, String userId,
			String userName, Date nDate, Date modifyDate, String ctag1, String ctag2, int cPrice, String cType,
			String cCategogy, Date cSDate, Date cEDate, String cLocation, String cTutor, List<File> photoList) {
		super();
		this.nNum = nNum;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nCount = nCount;
		this.nStatus = nStatus;
		this.nType = nType;
		this.userId = userId;
		this.userName = userName;
		this.nDate = nDate;
		this.modifyDate = modifyDate;
		this.ctag1 = ctag1;
		this.ctag2 = ctag2;
		this.cPrice = cPrice;
		this.cType = cType;
		this.cCategogy = cCategogy;
		this.cSDate = cSDate;
		this.cEDate = cEDate;
		this.cLocation = cLocation;
		this.cTutor = cTutor;
		this.photoList = photoList;
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

	
	
	public int getnCount() {
		return nCount;
	}


	public void setnCount(int nCount) {
		this.nCount = nCount;
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

	public String getCtag1() {
		return ctag1;
	}

	public void setCtag1(String ctag1) {
		this.ctag1 = ctag1;
	}

	public String getCtag2() {
		return ctag2;
	}

	public void setCtag2(String ctag2) {
		this.ctag2 = ctag2;
	}

	public int getcPrice() {
		return cPrice;
	}

	public void setcPrice(int cPrice) {
		this.cPrice = cPrice;
	}

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType;
	}

	public String getcCategogy() {
		return cCategogy;
	}

	public void setcCategogy(String cCategogy) {
		this.cCategogy = cCategogy;
	}

	public Date getcSDate() {
		return cSDate;
	}

	public void setcSDate(Date cSDate) {
		this.cSDate = cSDate;
	}

	public Date getcEDate() {
		return cEDate;
	}

	public void setcEDate(Date cEDate) {
		this.cEDate = cEDate;
	}

	public String getcLocation() {
		return cLocation;
	}

	public void setcLocation(String cLocation) {
		this.cLocation = cLocation;
	}

	public String getcTutor() {
		return cTutor;
	}

	public void setcTutor(String cTutor) {
		this.cTutor = cTutor;
	}

	public List<File> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<File> photoList) {
		this.photoList = photoList;
	}


	@Override
	public String toString() {
		return "Lesson [nNum=" + nNum + ", nTitle=" + nTitle + ", nContent=" + nContent + ", nCount=" + nCount
				+ ", nStatus=" + nStatus + ", nType=" + nType + ", userId=" + userId + ", userName=" + userName
				+ ", nDate=" + nDate + ", modifyDate=" + modifyDate + ", ctag1=" + ctag1 + ", ctag2=" + ctag2
				+ ", cPrice=" + cPrice + ", cType=" + cType + ", cCategogy=" + cCategogy + ", cSDate=" + cSDate
				+ ", cEDate=" + cEDate + ", cLocation=" + cLocation + ", cTutor=" + cTutor + ", photoList=" + photoList
				+ "]";
	}


}
