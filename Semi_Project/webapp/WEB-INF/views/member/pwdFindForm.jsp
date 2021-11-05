<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
	<!-- JQuery-->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<!-- 외부 스타일 시트 -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/member/loginfind-style.css">
    <!-- 외부 폰트 -->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
</head>
<body>
<c:set var="contextPath" value="${ pageContext.servletContext.contextPath }" />
	<div class="pwdFindPopup popup">
        <div class="title-text">
            <h2>소다에 가입한<br>
                계정정보를 입력해주세요.</h2><br>
                
        <form id="pwdFindForm" class="form" action="${ contextPath }/pwd/find" method="post"
        onsubmit="return findFilter();">
            <h3>이름</h3>
            <span class="input_area">
                <input type="text" id="nameInput" name="userName" placeholder="이름을 입력해주세요.">
            </span>
            <h3>이메일주소</h3>
            <span class="input_area">
                <input type="text" id="emailInput" name="userEmail" placeholder="이메일계정을 입력해주세요.">
            </span>
            <div class="btnArea">
                <button id="pwdFindButton" class="btn">비밀번호 찾기</button>
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

	 	/* 입력한 이메일주소가 네자리 미만일 경우 alert 창 */
		if(form.userEmail.value.length < 4) {
			  // 입력 받은 이메일 값
		     var emailVal = $("#emailInput").val();
			  
			 // 이메일 주소 검증하는 정규식
		     var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		     
		     if(emailVal = ""){
		    	 alert("이메일을 입력해주세요.");
		    	 return false;
		    	 
		    // 입력된 이메일주소가 정규식에 부합하는 지 확인
		    }else(emailVal.match(regExp) == null) {
		    	 alert("이메일 형식에 맞게 입력해주세요.");
		    	 return false;
		     }
		 } else{
			 alert("이메일 형식에 맞게 입력해주세요.");
			 return false;
		 }
		return true;
	 }
    </script>
    
</body>
</html>