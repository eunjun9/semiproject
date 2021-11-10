package com.soda.mypage.model.vo;

public class ProfileFile {

	private int fileNo;		// 파일 번호 (pk)
	private String route;		// 업로드 파일 저장 경로
	private String userId;			// 게시글 번호 (Notice 테이블 참조)
	private String originName;	// 원본 파일명
	private String changeName;	// 변경 파일명
	private String status;		// 상태 (삭제 여부)
	
	public ProfileFile(){}

	public ProfileFile(int fileNo, String route, String userId, String originName, String changeName, String status) {
		super();
		this.fileNo = fileNo;
		this.route = route;
		this.userId = userId;
		this.originName = originName;
		this.changeName = changeName;
		this.status = status;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProfileFile [fileNo=" + fileNo + ", route=" + route + ", userId=" + userId + ", originName="
				+ originName + ", changeName=" + changeName + ", status=" + status + "]";
	}

	
	
	
}