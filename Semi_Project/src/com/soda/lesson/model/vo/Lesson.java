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
	private String cCategory;	// 카테고리 (원데이 vod)
	private String vDate;		// vod 날짜
	private Date oDate1;		// 원데이 날짜 1
	private Date oDate2;		// 원데이 날짜 2
	private String cTime1;		// 클래스 시간1
	private String cTime2;		// 클래스 시간2
	private String cLocation;	// 장소
	private String cTutor;		// 강사 소개
	private Date selectDate; 	// 클래스 선택 날짜
	private Date payDate;		// 클래스 결제 날짜
	private int pNum;			// 주문번호
	
	
	private List<Attachment> photoList;  // 첨부파일
	
	public Lesson() {}

	public Lesson(int nNum, String nTitle, String nContent, int nCount, String nStatus, String nType, String userId,
			String userName, Date nDate, Date modifyDate, String ctag1, String ctag2, int cPrice, String cCategory,
			String vDate, Date oDate1, Date oDate2, String cTime1, String cTime2, String cLocation, String cTutor,
			Date selectDate, List<Attachment> photoList) {
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
		this.cCategory = cCategory;
		this.vDate = vDate;
		this.oDate1 = oDate1;
		this.oDate2 = oDate2;
		this.cTime1 = cTime1;
		this.cTime2 = cTime2;
		this.cLocation = cLocation;
		this.cTutor = cTutor;
		this.selectDate = selectDate;
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

	public String getcCategory() {
		return cCategory;
	}

	public void setcCategory(String cCategory) {
		this.cCategory = cCategory;
	}

	public String getvDate() {
		return vDate;
	}

	public void setvDate(String vDate) {
		this.vDate = vDate;
	}

	public Date getoDate1() {
		return oDate1;
	}

	public void setoDate1(Date oDate1) {
		this.oDate1 = oDate1;
	}

	public Date getoDate2() {
		return oDate2;
	}

	public void setoDate2(Date oDate2) {
		this.oDate2 = oDate2;
	}

	public String getcTime1() {
		return cTime1;
	}

	public void setcTime1(String cTime1) {
		this.cTime1 = cTime1;
	}

	public String getcTime2() {
		return cTime2;
	}

	public void setcTime2(String cTime2) {
		this.cTime2 = cTime2;
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

	public List<Attachment> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<Attachment> photoList) {
		this.photoList = photoList;
	}

	public Date getSelectDate() {
		return selectDate;
	}

	public void setSelectDate(Date selectDate) {
		this.selectDate = selectDate;
	}
	
	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	
	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	@Override
	public String toString() {
		return "Lesson [nNum=" + nNum + ", nTitle=" + nTitle + ", nContent=" + nContent + ", nCount=" + nCount
				+ ", nStatus=" + nStatus + ", nType=" + nType + ", userId=" + userId + ", userName=" + userName
				+ ", nDate=" + nDate + ", modifyDate=" + modifyDate + ", ctag1=" + ctag1 + ", ctag2=" + ctag2
				+ ", cPrice=" + cPrice + ", cCategory=" + cCategory + ", vDate=" + vDate + ", oDate1=" + oDate1
				+ ", oDate2=" + oDate2 + ", cTime1=" + cTime1 + ", cTime2=" + cTime2 + ", cLocation=" + cLocation
				+ ", cTutor=" + cTutor + ", selectDate=" + selectDate + ", photoList=" + photoList + "]";
	}

}

