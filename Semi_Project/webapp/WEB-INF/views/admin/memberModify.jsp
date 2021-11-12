<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원등급변경</title>

    <!-- 외부 스타일 시트 -->
    <link href="../css/memberRevisePopup.css" rel="stylesheet">

    <!-- 글꼴 (Noto Sans) -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>

<body>
    <div class="page body">
        <h2 id="title">회원 정보 수정</h2>
        <form id="revise" action="${contextPath }/member/modifyview" method="post">

            <div class="line">

            <div class="label-input">
            <label class="id"></label><br>
            <input type="text" class="id-text" name="userId" value="${member.userId}">
            </div>

            <div class="label-input">
            <label class="name"></label><br>
            <input type="text" class="birth-text" name="name" value="${member.userName }">
            </div>

            <div class="label-input">
            <label class="phone"></label><br>
            <input type="text" class="phone-text" name="phone" value="${member.userPhone }"><br>
            </div>
            
            <div class="label-input">
            <label class="phone"></label><br>
            <input type="text" class="gender-text" name="gender" value="${member.gender }"><br>
            </div>
            
    
            <div class="btnArea">
            <button type="button" id="cancel" onclick="window.close()">취소</button>
            <button type="submit" id="sub">확인</button>
            </div>

            </div>
        </form>
    </div>
</body>

</html>