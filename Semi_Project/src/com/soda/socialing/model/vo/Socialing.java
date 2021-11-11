package com.soda.socialing.model.vo;

import java.sql.Date;
import java.util.List;

public class Socialing {
	// Notice
	private int nNum;			// 게시글 번호 (pk)
	private String nTitle;		// 게시글 제목
	private String nContent;	// 게시글 내용
	private String nStatus;		// 등록 상태 (Y/N)
	private String nType;		// 게시판 종류 (클래스, 소셜링, 매거진)
	private String userId;		// 작성자 아이디 (Member_info 테이블 참조)
	private String userName; 	// 작성자명 (Member_info 테이블 참조)
	private Date nDate;			// 작성 날짜
	private Date modifyDate;	// 수정 날짜
	private int nCount;			// 게시글 조회수
	// Socialing
	private String splace;		// 모임 장소
	private Date sdate;			// 모임 날짜
	private String stime;		// 모임 시간
	private String stype;		// 온오프라인 여부 (ON/OFF)
	private int maxMember;		// 최대 참여 인원
	private int minMember;		// 최소 참여 인원
	private String introduction;// 작성자 자기소개 (Profile 테이블 참조)

	// SodaFile
	private List<SodaFile> photoList;	// 사진 첨부 파일
	
	// ProfileFile
	private ProfileFile profileList;	// 프로필사진 첨부 파일 (작성자 프로필사진)
	
	public Socialing() {}

	public Socialing(int nNum, String nTitle, String nContent, String nStatus, String nType, String userId,
			String userName, Date nDate, Date modifyDate, int nCount, String splace, Date sdate, String stime,
			String stype, int maxMember, int minMember, String introduction, List<SodaFile> photoList,
			ProfileFile profileList) {
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
		this.nCount = nCount;
		this.splace = splace;
		this.sdate = sdate;
		this.stime = stime;
		this.stype = stype;
		this.maxMember = maxMember;
		this.minMember = minMember;
		this.introduction = introduction;
		this.photoList = photoList;
		this.profileList = profileList;
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

	public int getnCount() {
		return nCount;
	}

	public void setnCount(int nCount) {
		this.nCount = nCount;
	}

	public String getSplace() {
		return splace;
	}

	public void setSplace(String splace) {
		this.splace = splace;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public int getMaxMember() {
		return maxMember;
	}

	public void setMaxMember(int maxMember) {
		this.maxMember = maxMember;
	}

	public int getMinMember() {
		return minMember;
	}

	public void setMinMember(int minMember) {
		this.minMember = minMember;
	}

	public List<SodaFile> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<SodaFile> photoList) {
		this.photoList = photoList;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public ProfileFile getProfileList() {
		return profileList;
	}

	public void setProfileList(ProfileFile profileList) {
		this.profileList = profileList;
	}

	@Override
	public String toString() {
		return "Socialing [nNum=" + nNum + ", nTitle=" + nTitle + ", nContent=" + nContent + ", nStatus=" + nStatus
				+ ", nType=" + nType + ", userId=" + userId + ", userName=" + userName + ", nDate=" + nDate
				+ ", modifyDate=" + modifyDate + ", nCount=" + nCount + ", splace=" + splace + ", sdate=" + sdate
				+ ", stime=" + stime + ", stype=" + stype + ", maxMember=" + maxMember + ", minMember=" + minMember
				+ ", introduction=" + introduction + ", photoList=" + photoList + ", profileList=" + profileList + "]";
	}

}
