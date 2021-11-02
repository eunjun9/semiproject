<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알림</title>

<!-- 외부 스타일 시트 -->
<link href="/resources/css/mypage/mypage_notify.css" rel="stylesheet">

<!-- 글꼴 (Noto Sans) -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
	<!--header-->
    <%@ include file="/WEB-INF/views/common/header.jsp" %>

    <!-- body -->
    <div class="notify body">
        <div class="body-inner">
            <div class="n-title">
                <a id="back" href="#">&lt; 마이페이지</a>
                <p id="main-title">알림</p>
                <hr>
            </div>
            <article id="wrapper">
                <div class="new-no">
                    <a href="#">[시작 임박] 시작 날짜가 임박한 모임이 있어요!</a>
                    <a id="gt" href="#">&nbsp;&gt;</a>
                </div>
                <div class="new-no">
                    <a href="#">[결제 완료] '손쉽게 만드는 휘낭시에...' 클래스가 결제 완료되었습니다.</a>
                    <a id="gt" href="#">&nbsp;&gt;</a>
                </div>
                <div class="new-no">
                    <a href="#">[공지사항] 소셜다이닝의 가을 이벤트를 만나보세요!</a>
                    <a id="gt" href="#">&nbsp;&gt;</a>
                </div>
                <div class="new-no">
                    <a href="#">[후기 작성] '같이 공부하는 JS' 클래스는 만족하셨나요? 후기를 남겨주세요.</a>
                    <a id="gt" href="#">&nbsp;&gt;</a>
                </div>
            </article>
        </div>
    </div>

    <!--footer-->
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>