package com.soda.lesson.model.vo;

import java.sql.Date;
import java.util.List;

public class Lesson {
	private int nNum; 			// 게시판 번호
	private String ctag1;		// 카테고리 대분류
	private String ctag2;		// 카테고리 소분류
	private int cPrice;			// 가격
	private String cType;		// 타입 (온 오프라인)
	private String cCategogy;	// 카테고리 (원데이 vod)
	private Date cSDate;		// 시작 날짜
	private Date cEDate;		// 종료날짜
	private String cLocation;	// 장소
	private String cTutor;		// 강사 소개
	private String cWriter;		// 작성자 (강사 아이디)
	
	private List<File> photoList;  // 첨부파일
	
	public Lesson() {}

	public Lesson(int nNum, String ctag1, String ctag2, int cPrice, String cType, String cCategogy, Date cSDate,
			Date cEDate, String cLocation, String cTutor, String cWriter, List<File> photoList) {
		super();
		this.nNum = nNum;
		this.ctag1 = ctag1;
		this.ctag2 = ctag2;
		this.cPrice = cPrice;
		this.cType = cType;
		this.cCategogy = cCategogy;
		this.cSDate = cSDate;
		this.cEDate = cEDate;
		this.cLocation = cLocation;
		this.cTutor = cTutor;
		this.cWriter = cWriter;
		this.photoList = photoList;
	}

	public int getnNum() {
		return nNum;
	}

	public void setnNum(int nNum) {
		this.nNum = nNum;
	}
	
	public String getCtag1() {
		return ctag1;
	}

	public void setCtag1(String ctag1) {
		this.ctag1 = ctag1;
	}

	public String getCtag2() {
		return ctag2;
	}

	public void setCtag2(String ctag2) {
		this.ctag2 = ctag2;
	}

	public int getcPrice() {
		return cPrice;
	}

	public void setcPrice(int cPrice) {
		this.cPrice = cPrice;
	}

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType;
	}

	public String getcCategogy() {
		return cCategogy;
	}

	public void setcCategogy(String cCategogy) {
		this.cCategogy = cCategogy;
	}

	public Date getcSDate() {
		return cSDate;
	}

	public void setcSDate(Date cSDate) {
		this.cSDate = cSDate;
	}

	public Date getcEDate() {
		return cEDate;
	}

	public void setcEDate(Date cEDate) {
		this.cEDate = cEDate;
	}

	public String getcLocation() {
		return cLocation;
	}

	public void setcLocation(String cLocation) {
		this.cLocation = cLocation;
	}

	public String getcTutor() {
		return cTutor;
	}

	public void setcTutor(String cTutor) {
		this.cTutor = cTutor;
	}

	public String getcWriter() {
		return cWriter;
	}

	public void setcWriter(String cWriter) {
		this.cWriter = cWriter;
	}


	public List<File> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<File> photoList) {
		this.photoList = photoList;
	}

	
	@Override
	public String toString() {
		return "Lesson [nNum=" + nNum + ", ctag1=" + ctag1 + ", ctag2=" + ctag2 + ", cPrice=" + cPrice + ", cType="
				+ cType + ", cCategogy=" + cCategogy + ", cSDate=" + cSDate + ", cEDate=" + cEDate + ", cLocation="
				+ cLocation + ", cTutor=" + cTutor + ", cWriter=" + cWriter + ", photoList=" + photoList + "]";
	}


	
}
