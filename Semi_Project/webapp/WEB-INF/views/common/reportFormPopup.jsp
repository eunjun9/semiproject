<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고하기</title>

<!-- 외부 스타일 시트 -->
<link href="resources/css/report_style.css" rel="stylesheet">

<!-- 글꼴 (Noto Sans) -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
	<div class="page body">
        <h2 id="title">신고하기</h2>
        <form id="report" action="" method="post">
            <div class="radioArea">
                <p id="subTitle">신고 사유</p>
                <input type="radio" id="rep1" name="rep-reason" value="1">
                <label for="rep1">개인정보 노출</label><br>
                <input type="radio" id="rep2" name="rep-reason" value="2">
                <label for="rep2">불법성</label><br>
                <input type="radio" id="rep3" name="rep-reason" value="3">
                <label for="rep3">음란성</label><br>
                <input type="radio" id="rep4" name="rep-reason" value="4">
                <label for="rep4">명예훼손</label><br>
                <input type="radio" id="rep5" name="rep-reason" value="5">
                <label for="rep5">기타</label><br>
                <!-- 신고 사유 입력은 기타 선택시에만 활성화 되게 -->
                <textarea id="detail" name="detail" placeholder="신고 사유를 구체적으로 기재해 주세요."></textarea>
            </div><br>
            <div class="btnArea">
                <button type="button" id="cancel" onclick="window.close()">취소</button>
                <button type="submit" id="sub">신고</button>
            </div>
        </form>
    </div>
</body>
</html>