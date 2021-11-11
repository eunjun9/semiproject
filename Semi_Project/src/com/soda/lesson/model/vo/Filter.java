package com.soda.lesson.model.vo;

public class Filter {
	private String keyword;		// 키워드
	private String price1;			// 최소 가격
	private String price2;			// 최대 가격
	private String bigC;		// 대분류
	private String smallC;		// 소분류
	private String oneday;		// 원데이 클래스
	private String vod;		 	// vod 클래스
	
	public Filter(){}

	public Filter(String keyword, String price1, String price2, String bigC, String smallC, String oneday, String vod) {
		super();
		this.keyword = keyword;
		this.price1 = price1;
		this.price2 = price2;
		this.bigC = bigC;
		this.smallC = smallC;
		this.oneday = oneday;
		this.vod = vod;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getPrice1() {
		return price1;
	}

	public void setPrice1(String price1) {
		this.price1 = price1;
	}

	public String getPrice2() {
		return price2;
	}

	public void setPrice2(String price2) {
		this.price2 = price2;
	}

	public String getBigC() {
		return bigC;
	}

	public void setBigC(String bigC) {
		this.bigC = bigC;
	}

	public String getSmallC() {
		return smallC;
	}

	public void setSmallC(String smallC) {
		this.smallC = smallC;
	}

	public String getOneday() {
		return oneday;
	}

	public void setOneday(String oneday) {
		this.oneday = oneday;
	}

	public String getVod() {
		return vod;
	}

	public void setVod(String vod) {
		this.vod = vod;
	}

	@Override
	public String toString() {
		return "Filter [keyword=" + keyword + ", price1=" + price1 + ", price2=" + price2 + ", bigC=" + bigC
				+ ", smallC=" + smallC + ", oneday=" + oneday + ", vod=" + vod + "]";
	}
	
}
