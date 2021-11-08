package com.soda.socialing.model.vo;

import java.util.Date;

public class Search {
	private String keyword;		// 키워드
	private String local;		// 지역
	private Date dateIn;		// 날짜
	private String onoff;		// 온오프라인

	public Search() {}

	public Search(String keyword, String local, Date dateIn, String onoff) {
		super();
		this.keyword = keyword;
		this.local = local;
		this.dateIn = dateIn;
		this.onoff = onoff;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getDateIn() {
		return dateIn;
	}

	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}

	public String getOnoff() {
		return onoff;
	}

	public void setOnoff(String onoff) {
		this.onoff = onoff;
	}

	@Override
	public String toString() {
		return "Search [keyword=" + keyword + ", local=" + local + ", dateIn=" + dateIn + ", onoff=" + onoff + "]";
	}
}
