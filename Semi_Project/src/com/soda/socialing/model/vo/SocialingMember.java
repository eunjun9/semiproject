package com.soda.socialing.model.vo;

public class SocialingMember {
	private int noticeNum;			// 게시판 번호 (pfk - Socialing 테이블 noticeNum 참조 값)
	private String memberId;		// 참여자 아이디 (pfk - Member 테이블 user_id 참조 값)
	private String status;			// 참여 완료 여부 (Y/N)
	private String memberName;		// 참여자명 (Member 테이블 join 결과 값)
	private String introduction;	// 참여자 자기소개 (Profile 테이블 join 결과 값)
	
	// ProfileFile
	private ProfileFile profile;	// 프로필사진 첨부 파일 (참여자 프로필사진)
	
	public SocialingMember() {}
	
	public SocialingMember(int noticeNum, String memberId, String status, String memberName, String introduction,
			ProfileFile profile) {
		super();
		this.noticeNum = noticeNum;
		this.memberId = memberId;
		this.status = status;
		this.memberName = memberName;
		this.introduction = introduction;
		this.profile = profile;
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

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public ProfileFile getProfile() {
		return profile;
	}

	public void setProfile(ProfileFile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "SocialingMember [noticeNum=" + noticeNum + ", memberId=" + memberId + ", status=" + status
				+ ", memberName=" + memberName + ", introduction=" + introduction + ", profile=" + profile + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((introduction == null) ? 0 : introduction.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + noticeNum;
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SocialingMember other = (SocialingMember) obj;
		if (introduction == null) {
			if (other.introduction != null)
				return false;
		} else if (!introduction.equals(other.introduction))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (noticeNum != other.noticeNum)
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

}
