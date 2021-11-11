package com.soda.order.model.vo;

import java.sql.Date;

public class Payment {
	
	private int payNum;		// 주문결제번호
	private Date payDate;		// 주문일자
	private String payOption;	// 결제수단
	private String payPhone;	// 주문자연락처
	private String payEmail;	// 주문자이메일
	private String payCancle;	// 취소,환불여부(N/Y)
	private String userId;		// 주문자아이디
	private String payId;		// 결제승인번호
	private int nNum;		// 주문게시글번호
	
	private Date selectDate;	// 원데이선택날짜 (class_member 테이블 참고)
	
	
	
/*	PAY_NUM	NUMBER
	PAY_DATE	DATE
	PAY_OPTION	VARCHAR2(10 BYTE)
	PAY_PHONE	VARCHAR2(10 BYTE)
	PAY_EMAIL	VARCHAR2(20 BYTE)
	PAY_CANCLE	VARCHAR2(5 BYTE)
	USER_ID	VARCHAR2(30 BYTE)
	NOTICE_NUM	NUMBER
 

	 * */
	
	public Payment() {}



public Payment(int payNum, Date payDate, String payOption, String payPhone, String payEmail, String payCancle,
		String userId, String payId, int nNum, Date selectDate) {
	super();
	this.payNum = payNum;
	this.payDate = payDate;
	this.payOption = payOption;
	this.payPhone = payPhone;
	this.payEmail = payEmail;
	this.payCancle = payCancle;
	this.userId = userId;
	this.payId = payId;
	this.nNum = nNum;
	this.selectDate = selectDate;
}



public int getPayNum() {
	return payNum;
}



public void setPayNum(int payNum) {
	this.payNum = payNum;
}



public Date getPayDate() {
	return payDate;
}



public void setPayDate(Date payDate) {
	this.payDate = payDate;
}



public String getPayOption() {
	return payOption;
}



public void setPayOption(String payOption) {
	this.payOption = payOption;
}



public String getPayPhone() {
	return payPhone;
}



public void setPayPhone(String payPhone) {
	this.payPhone = payPhone;
}



public String getPayEmail() {
	return payEmail;
}



public void setPayEmail(String payEmail) {
	this.payEmail = payEmail;
}



public String getPayCancle() {
	return payCancle;
}



public void setPayCancle(String payCancle) {
	this.payCancle = payCancle;
}



public String getUserId() {
	return userId;
}



public void setUserId(String userId) {
	this.userId = userId;
}



public String getPayId() {
	return payId;
}



public void setPayId(String payId) {
	this.payId = payId;
}



public int getnNum() {
	return nNum;
}



public void setnNum(int nNum) {
	this.nNum = nNum;
}



public Date getSelectDate() {
	return selectDate;
}



public void setSelectDate(Date selectDate) {
	this.selectDate = selectDate;
}



@Override
public String toString() {
	return "Payment [payNum=" + payNum + ", payDate=" + payDate + ", payOption=" + payOption + ", payPhone=" + payPhone
			+ ", payEmail=" + payEmail + ", payCancle=" + payCancle + ", userId=" + userId + ", payId=" + payId
			+ ", nNum=" + nNum + ", selectDate=" + selectDate + "]";
}


}