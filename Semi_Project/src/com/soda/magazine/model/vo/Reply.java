package com.soda.magazine.model.vo;

import java.util.Date;

public class Reply {

	/*
	 * COMMENT_NUM NUMBER No 1 댓글번호 
	 * COMMENT_CONTENT VARCHAR2(50 BYTE) No 2 댓글내용
	 * CONMENT_DATE DATE No "SYSDATE	" 3 댓글작성일시
	 *  NOTICE_NUM NUMBER No 4 게시판번호
	 * COMMENT_SELF_NUM NUMBER No 5 대댓글
	 */
	
	private int commentNum;
	private String commentContent;
	private Date commentDate;
	private int noticeNum;
	private int commentSelfNum;
	
	
	public Reply(){}
	
	
	
	
	public Reply(int commentNum, String commentContent, Date commentDate, int noticeNum, int commentSelfNum) {
		super();
		this.commentNum = commentNum;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.noticeNum = noticeNum;
		this.commentSelfNum = commentSelfNum;
	}




	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public int getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}
	public int getCommentSelfNum() {
		return commentSelfNum;
	}
	public void setCommentSelfNum(int commentSelfNum) {
		this.commentSelfNum = commentSelfNum;
	}




	@Override
	public String toString() {
		return "Reply [commentNum=" + commentNum + ", commentContent=" + commentContent + ", commentDate=" + commentDate
				+ ", noticeNum=" + noticeNum + ", commentSelfNum=" + commentSelfNum + "]";
	}
	
	
	
	
}
