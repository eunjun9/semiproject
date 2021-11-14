package com.soda.admin.model.vo;

import java.util.Date;

public class Report {
	private int rNum;			// 신고 번호
	private String rReason;		// 신고 사유
	private int cNum;			// 댓글 번호 (Comment 테이블 참조)
	private int nNum;			// 게시판 번호 (Notice 테이블 참조)
	private String userId;		// 신고한 회원아이디 (Member 테이블 참조)
	private Date rDate;			// 신고일
	private String reportedId;	// 신고된 회원 아이디
	private String category;	// 게시판 카테고리
	private String noticeTitle;	// 게시글 제목
	
	public Report() {}

	public Report(int rNum, String rReason, int cNum, int nNum, String userId, Date rDate) {
		super();
		this.rNum = rNum;
		this.rReason = rReason;
		this.cNum = cNum;
		this.nNum = nNum;
		this.userId = userId;
		this.rDate = rDate;
	}

	// 신고용 생성자
	public Report(int rNum, String rReason, int cNum, int nNum, String userId, Date rDate, String reportedId,
			String category, String noticeTitle) {
		super();
		this.rNum = rNum;
		this.rReason = rReason;
		this.cNum = cNum;
		this.nNum = nNum;
		this.userId = userId;
		this.rDate = rDate;
		this.reportedId = reportedId;
		this.category = category;
		this.noticeTitle = noticeTitle;
	}

	public int getrNum() {
		return rNum;
	}
	
	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	public String getrReason() {
		return rReason;
	}

	public void setrReason(String rReason) {
		this.rReason = rReason;
	}

	public int getcNum() {
		return cNum;
	}

	public void setcNum(int cNum) {
		this.cNum = cNum;
	}

	public int getnNum() {
		return nNum;
	}

	public void setnNum(int nNum) {
		this.nNum = nNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getrDate() {
		return rDate;
	}

	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}

	public String getReportedId() {
		return reportedId;
	}

	public void setReportedId(String reportedId) {
		this.reportedId = reportedId;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	@Override
	public String toString() {
		return "Report [rNum=" + rNum + ", rReason=" + rReason + ", cNum=" + cNum + ", nNum=" + nNum + ", userId="
				+ userId + ", rDate=" + rDate + ", reportedId=" + reportedId + ", category=" + category
				+ ", noticeTitle=" + noticeTitle + "]";
	}

}
