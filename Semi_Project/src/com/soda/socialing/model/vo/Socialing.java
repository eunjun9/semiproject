package com.soda.socialing.model.vo;

import java.util.Date;

public class Socialing {
	private int noticeNum;		// 게시판 번호 (pfk - Notice 테이블 noticeNum 참조 값)
	private String splace;		// 모임 장소
	private Date sdate;			// 모임 날짜
	private Date stime;			// 모임 시간
	private String stype;		// 온오프라인 여부 (ON/OFF)
	private int maxMember;		// 참여 가능 인원
	
	public Socialing() {}

	public Socialing(int noticeNum, String splace, Date sdate, Date stime, String stype,
			int maxMember) {
		super();
		this.noticeNum = noticeNum;
		this.splace = splace;
		this.sdate = sdate;
		this.stime = stime;
		this.stype = stype;
		this.maxMember = maxMember;
	}

	public int getNoticeNum() {
		return noticeNum;
	}

	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
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

	public Date getStime() {
		return stime;
	}

	public void setStime(Date stime) {
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

	@Override
	public String toString() {
		return "Socialing [noticeNum=" + noticeNum + ", splace=" + splace + ", sdate=" + sdate
				+ ", stime=" + stime + ", stype=" + stype + ", maxMember=" + maxMember + "]";
	}

}
