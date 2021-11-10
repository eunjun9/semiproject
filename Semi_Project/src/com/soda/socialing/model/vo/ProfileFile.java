package com.soda.socialing.model.vo;

public class ProfileFile {
	private int fileNum;		// 파일 번호 (pk)
	private String userId;		// 프로필 유저 아이디 (Member_info 테이블 참조)
	private String route;		// 업로드 파일 저장 경로
	private String originName;	// 원본 파일명
	private String changeName;	// 변경 파일명
	private String deletedName;	// 삭제 시 파일명
	private String status;		// 상태 (삭제 여부)
	
	public ProfileFile() {}

	public ProfileFile(int fileNum, String userId, String route, String originName, String changeName,
			String deletedName, String status) {
		super();
		this.fileNum = fileNum;
		this.userId = userId;
		this.route = route;
		this.originName = originName;
		this.changeName = changeName;
		this.deletedName = deletedName;
		this.status = status;
	}

	public int getFileNum() {
		return fileNum;
	}

	public void setFileNum(int fileNum) {
		this.fileNum = fileNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getDeletedName() {
		return deletedName;
	}

	public void setDeletedName(String deletedName) {
		this.deletedName = deletedName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProfileFile [fileNum=" + fileNum + ", userId=" + userId + ", route=" + route + ", originName="
				+ originName + ", changeName=" + changeName + ", deletedName=" + deletedName + ", status=" + status
				+ "]";
	}

}
