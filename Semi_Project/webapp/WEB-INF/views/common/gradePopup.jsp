<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 등급 변경 팝업</title>

    <!-- 외부 스타일 시트 -->
    <link href="../css/gradePopup.css" rel="stylesheet">

    <!-- 글꼴 (Noto Sans) -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
    <div class="page body">
        <h2 id="title">회원 등급 변경</h2>
        <form id="revise" action="" method="post">
            <div class="optionArea">
                <select id="grade" name="grade">
                    <option value="member">회원</option>
                    <option value="tutor">강사</option>
                    <option value="stop">활동정지</option>
                    <option value="admin">관리자</option>
                </select>
                <p id="subTitle">회원등급을 변경하시겠습니까?</p>
            </div><br>
            <div class="btnArea">
                <button type="button" id="cancel" onclick="window.close()">취소</button>
                <button type="submit" id="sub">확인</button>
            </div>
        </form>
    </div>
</body>
</html>