package com.soda.order.model.vo;

import java.sql.Date;

public class Payment {
	
	private int payNum;			// 주문결제번호
	private Date payDate;		// 주문일자
	private String payOption;	// 결제수단
	private String payPhone;	// 주문자연락처
	private String payEmail;	// 주문자이메일
	private String payCancle;	// 취소,환불여부(N/Y)
	private String userId;		// 주문자아이디
	private String payId;		// 결제승인번호
	private int nNum;			// 주문게시글번호
	
	private Date selectDate;	// 원데이선택날짜 (class_member 테이블 참고)
	
	private String payListDate1;	// 마이페이지 결제내역 선택날짜1
	private String payListDate2;
	private String refundAccount;	// 환불 계좌
	private String refundBank;		// 환불 은행
	private String accountHolder;	// 환불 예금주
	
	
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

// 마이페이지 - 결제내역 생성자
public Payment(int payNum, Date payDate, String payOption, String payPhone, String payEmail, String payCancle,
		String userId, String payId, int nNum, Date selectDate, String payListDate1, String payListDate2) {
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
	this.payListDate1 = payListDate1;
	this.payListDate2 = payListDate2;
}


// 마이페이지 - 환불 용 생성자
public Payment(int payNum, Date payDate, String payOption, String payPhone, String payEmail, String payCancle,
		String userId, String payId, int nNum, Date selectDate, String payListDate1, String payListDate2,
		String refundAccount, String refundBank, String accountHolder) {
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
	this.payListDate1 = payListDate1;
	this.payListDate2 = payListDate2;
	this.refundAccount = refundAccount;
	this.refundBank = refundBank;
	this.accountHolder = accountHolder;
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



public String getPayListDate1() {
	return payListDate1;
}


public void setPayListDate1(String payListDate1) {
	this.payListDate1 = payListDate1;
}



public String getPayListDate2() {
	return payListDate2;
}



public void setPayListDate2(String payListDate2) {
	this.payListDate2 = payListDate2;
}


public String getRefundAccount() {
	return refundAccount;
}


public void setRefundAccount(String refundAccount) {
	this.refundAccount = refundAccount;
}

public String getRefundBank() {
	return refundBank;
}

public void setRefundBank(String refundBank) {
	this.refundBank = refundBank;
}


public String getAccountHolder() {
	return accountHolder;
}


public void setAccountHolder(String accountHolder) {
	this.accountHolder = accountHolder;
}

@Override
public String toString() {
	return "Payment [payNum=" + payNum + ", payDate=" + payDate + ", payOption=" + payOption + ", payPhone=" + payPhone
			+ ", payEmail=" + payEmail + ", payCancle=" + payCancle + ", userId=" + userId + ", payId=" + payId
			+ ", nNum=" + nNum + ", selectDate=" + selectDate + ", payListDate1=" + payListDate1 + ", payListDate2="
			+ payListDate2 + ", refundAccount=" + refundAccount + ", refundBank=" + refundBank + ", accountHolder="
			+ accountHolder + "]";
}

}