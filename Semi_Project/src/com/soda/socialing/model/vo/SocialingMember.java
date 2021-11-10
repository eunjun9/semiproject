package com.soda.socialing.model.vo;

public class SocialingMember {
	private int noticeNum;			// 게시판 번호 (pfk - Socialing 테이블 noticeNum 참조 값)
	private String memberId;		// 참여자 아이디 (pfk - Member 테이블 user_id 참조 값)
	private String status;			// 참여 완료 여부 (Y/N)
	private String memberName;		// 참여자명 (Member 테이블 join 결과 값)
	private String memberProfile;	// 참여자 프로필사진 (Profile 테이블 join 결과 값)
	private String introduction;	// 참여자 자기소개 (Profile 테이블 join 결과 값)
	
	// ProfileFile
	private ProfileFile profile2;	// 프로필사진 첨부 파일 (참여자 프로필사진) -> String profile 삭제
	
	public SocialingMember() {}

	public SocialingMember(int noticeNum, String memberId, String status, String memberName, String memberProfile,
			String introduction) {
		super();
		this.noticeNum = noticeNum;
		this.memberId = memberId;
		this.status = status;
		this.memberName = memberName;
		this.memberProfile = memberProfile;
		this.introduction = introduction;
	}

	public int getNoticeNum() {
		return noticeNum;
	}

	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberProfile() {
		return memberProfile;
	}

	public void setMemberProfile(String memberProfile) {
		this.memberProfile = memberProfile;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Override
	public String toString() {
		return "SocialingMember [noticeNum=" + noticeNum + ", memberId=" + memberId + ", status=" + status
				+ ", memberName=" + memberName + ", memberProfile=" + memberProfile + ", introduction=" + introduction
				+ "]";
	}

}
