<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 계정 찾기</title>
	<!-- JQuery-->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<!-- 외부 스타일 시트 -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/member/loginfind-style.css">
    <!-- 외부 폰트 -->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
</head>
<body>
<c:set var="contextPath" value="${ pageContext.servletContext.contextPath }" />

<div class="emailFindPopup popup">
        <div class="title-text">
            <h2>소다에 가입한<br>
                계정정보를 입력해주세요.</h2><br>
                
        <form id="emailFindForm" name="findForm" class="form" action="${ contextPath }/email/find" 
        method="post" onsubmit="return findFilter();">
            <h3>이름</h3>
            <span class="input_area">
                <input type="text" id="nameInput" name="userName" placeholder="이름을 입력해주세요.">
            </span>
            <h3>휴대폰번호</h3>
            <span class="input_area">
                <input type="text" id="phoneInput" name="userPhone" placeholder="010-0000-0000" maxlength="13">
            </span>
            <div class="btnArea">
                <button id="emailFindButton" class="btn">이메일 계정 찾기</button>
            </div>
        </form>

        </div>

    </div>
    
    <script>
    function findFilter() { 
	 	var form = document.findForm;

	 	/* 입력한 이름이 두자리 미만일 경우 alert 창 */
	 	if(form.userName.value.length < 2) {
		  alert("이름을 입력해주세요.");
		  return false;
		 }

	 	/* 입력한 휴대폰번호가 13자리가 아닐 경우 alert 창 */
		if(form.userPhone.value.length != 13) {
			
			// 휴대폰번호 검증하는 정규식
			var regPhone = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
			
			if(emailVal.match(regExp) == null) {
				alert("휴대폰번호를 정확하게 입력해주세요.");
			  	return false;
			}
			  
		 }
		return true;
	 }
    </script>

</body>
</html>