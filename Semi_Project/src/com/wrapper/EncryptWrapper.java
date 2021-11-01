package com.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper{

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String key) {
		String value ="";
		
		// request 객체에 담긴 파라미터 키 값이 userPwd 또는 newPwd인 경우 암호화
		if(key != null && (key.equals("userPwd") || key.equals("newPwd"))) {
			value = getSha512(super.getParameter(key));
		}else {
			// request 객체에 담긴 파라미터 키 값이 userPwd, newPwd가 아닌 경우 기존 값 그대로 사용
			value = super.getParameter(key);
		}
		return value;
	}
	
	public String getSha512(String userPwd) {
		
		String encPwd = null;
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = userPwd.getBytes(Charset.forName("UTF-8"));
			
			md.update(bytes);
			
			encPwd = Base64.getEncoder().encodeToString(md.digest());
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return encPwd;
	}

}
