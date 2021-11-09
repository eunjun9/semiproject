package com.soda.order.model.vo;


public class WishList {
	private String userId;
	private int nNum;
	private int wishNum;		// 시퀀스 번호
	private String wishStatus;	// 장바구니 클래스 삭제 여부 (Y/N)
	
	private String nTitle;		// 게시글 제목 (notice 테이블 참조)
	private int cPrice;			// 가격 (class 테이블 참조)
	private String cCategory;	// 카테고리 (원데이 vod) (class 테이블 참조)
	private String vDate;		// 시작 날짜 (class 테이블 참조)
	private String cTime1;		// 클래스 시간1 (class 테이블 참조)
	private String cTime2;		// 클래스 시간2 (class 테이블 참조)
	private String lessonDate;	// 원데이 선택 날짜
	
	private String cLocation;	// 장소 (class 테이블 참조)
	private String route;		// 업로드 파일 저장 경로 (tbl_file 테이블 참조)
	private String changeName;	// 바뀐 이름 (tbl_file 테이블 참조)
	
	
	/*
	USER_ID	VARCHAR2(30 BYTE)
	NOTICE_NUM	NUMBER
	WISH_NUM	NUMBER
	WISH_STATUS	VARCHAR2(2 BYTE)
	*/
	
	public WishList() {}
	

	public WishList(String userId, int nNum, int wishNum, String wishStatus) {
		super();
		this.userId = userId;
		this.nNum = nNum;
		this.wishNum = wishNum;
		this.wishStatus = wishStatus;
	}
	
	// 장바구니 리스트 조회
	public WishList(String nTitle, int cPrice, String cCategory, String vDate, String cTime1, String cTime2,
			String cLocation, String route, String changeName) {
		super();
		this.nTitle = nTitle;
		this.cPrice = cPrice;
		this.cCategory = cCategory;
		this.vDate = vDate;
		this.cTime1 = cTime1;
		this.cTime2 = cTime2;
		this.cLocation = cLocation;
		this.route = route;
		this.changeName = changeName;
	}
	

	// 전체
	public WishList(String userId, int nNum, int wishNum, String wishStatus, String nTitle, int cPrice,
			String cCategory, String vDate, String cTime1, String cTime2, String lessonDate, String cLocation,
			String route, String changeName) {
		super();
		this.userId = userId;
		this.nNum = nNum;
		this.wishNum = wishNum;
		this.wishStatus = wishStatus;
		this.nTitle = nTitle;
		this.cPrice = cPrice;
		this.cCategory = cCategory;
		this.vDate = vDate;
		this.cTime1 = cTime1;
		this.cTime2 = cTime2;
		this.lessonDate = lessonDate;
		this.cLocation = cLocation;
		this.route = route;
		this.changeName = changeName;
	}


	public WishList(int nNum, int wishNum, String wishStatus, String nTitle, int cPrice, String cCategory, String vDate,
			String cTime1, String cTime2, String cLocation) {
		super();
		this.nNum = nNum;
		this.wishNum = wishNum;
		this.wishStatus = wishStatus;
		this.nTitle = nTitle;
		this.cPrice = cPrice;
		this.cCategory = cCategory;
		this.vDate = vDate;
		this.cTime1 = cTime1;
		this.cTime2 = cTime2;
		this.cLocation = cLocation;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getnNum() {
		return nNum;
	}

	public void setnNum(int nNum) {
		this.nNum = nNum;
	}
	
	
	
	public int getWishNum() {
		return wishNum;
	}


	public void setWishNum(int wishNum) {
		this.wishNum = wishNum;
	}
	
	

	public String getWishStatus() {
		return wishStatus;
	}


	public void setWishStatus(String wishStatus) {
		this.wishStatus = wishStatus;
	}


	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public int getcPrice() {
		return cPrice;
	}

	public void setcPrice(int cPrice) {
		this.cPrice = cPrice;
	}

	public String getcCategory() {
		return cCategory;
	}

	public void setcCategory(String cCategory) {
		this.cCategory = cCategory;
	}

	public String getvDate() {
		return vDate;
	}

	public void setvDate(String vDate) {
		this.vDate = vDate;
	}

	public String getcTime1() {
		return cTime1;
	}

	public void setcTime1(String cTime1) {
		this.cTime1 = cTime1;
	}

	public String getcTime2() {
		return cTime2;
	}

	public void setcTime2(String cTime2) {
		this.cTime2 = cTime2;
	}
	
	

	public String getlessonDate() {
		return lessonDate;
	}


	public void setlessonDate(String lessonDate) {
		this.lessonDate = lessonDate;
	}


	public String getcLocation() {
		return cLocation;
	}

	public void setcLocation(String cLocation) {
		this.cLocation = cLocation;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}


	@Override
	public String toString() {
		return "WishList [userId=" + userId + ", nNum=" + nNum + ", wishNum=" + wishNum + ", wishStatus=" + wishStatus
				+ ", nTitle=" + nTitle + ", cPrice=" + cPrice + ", cCategory=" + cCategory + ", vDate=" + vDate
				+ ", cTime1=" + cTime1 + ", cTime2=" + cTime2 + ", lessonDate=" + lessonDate
				+ ", cLocation=" + cLocation + ", route=" + route + ", changeName=" + changeName + "]";
	}





	
	
}
