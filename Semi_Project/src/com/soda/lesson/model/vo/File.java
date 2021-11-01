package com.soda.lesson.model.vo;

public class File {
	private int fileNum;		// 파일 번호
	private int nNum;			// 게시글 번호
	private String route;		// 업로드 파일 저장 경로
	private String originName;	// 원본 이름	
	private String changeName;	// 바뀐 이름
	private int fileLevel;		// 썸네일 0 내용 사진 1
	private String status;		// 상태
	
	public File(){}

	public File(int fileNum, int nNum, String route, String originName, String changeName, int fileLevel,
			String status) {
		super();
		this.fileNum = fileNum;
		this.nNum = nNum;
		this.route = route;
		this.originName = originName;
		this.changeName = changeName;
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
		return "File [fileNum=" + fileNum + ", nNum=" + nNum + ", route=" + route + ", originName=" + originName
				+ ", changeName=" + changeName + ", fileLevel=" + fileLevel + ", status=" + status + "]";
	};
	
	
}
