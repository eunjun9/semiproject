<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 계정 찾기</title>
	<!-- 외부 스타일 시트 -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/loginfind-style.css">
    <!-- 외부 폰트 -->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
</head>
<body>
<div class="emailFindPopup popup">
        <div class="title-text">
            <h2>소다에 가입한<br>
                계정정보를 입력해주세요.</h2><br>
                
        <form id="emailFindForm" class="form" action="" method="post" onsubmit="">
            <h3>이름</h3>
            <span class="input_area">
                <input type="text" id="nameInput" placeholder="이름을 입력해주세요.">
            </span>
            <h3>휴대폰번호</h3>
            <span class="input_area">
                <input type="text" id="phoneInput" placeholder="010-0000-0000" maxlength="13">
            </span>
            <div class="btnArea">
                <button id="emailFindButton" class="btn">이메일 계정 찾기</button>
            </div>
        </form>

        </div>

    </div>

</body>
</html>