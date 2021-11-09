package com.soda.socialing.model.vo;

public class SodaFile {
	private int fileNum;		// 파일 번호 (pk)
	private int nNum;			// 게시글 번호 (Notice 테이블 참조)
	private String route;		// 업로드 파일 저장 경로
	private String originName;	// 원본 파일명
	private String changeName;	// 변경 파일명
	private String deletedName;	// 삭제 시 파일명
	private int fileLevel;		// 썸네일 0, 내용 사진 1
	private String status;		// 상태 (삭제 여부)
	
	public SodaFile() {}

	public SodaFile(int fileNum, int nNum, String route, String originName, String changeName, String deletedName,
			int fileLevel, String status) {
		super();
		this.fileNum = fileNum;
		this.nNum = nNum;
		this.route = route;
		this.originName = originName;
		this.changeName = changeName;
		this.deletedName = deletedName;
		this.fileLevel = fileLevel;
		this.status = status;
	}

	public int getFileNum() {
		return fileNum;
	}

	public void setFileNum(int fileNum) {
		this.fileNum = fileNum;
	}

	public int getnNum() {
		return nNum;
	}

	public void setnNum(int nNum) {
		this.nNum = nNum;
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

	public int getFileLevel() {
		return fileLevel;
	}

	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SodaFile [fileNum=" + fileNum + ", nNum=" + nNum + ", route=" + route + ", originName=" + originName
				+ ", changeName=" + changeName + ", deletedName=" + deletedName + ", fileLevel=" + fileLevel
				+ ", status=" + status + "]";
	}
	
}
