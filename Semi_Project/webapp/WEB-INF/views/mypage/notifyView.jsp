<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알림</title>

<!-- 외부 스타일 시트 -->
<link href="resources/css/header_footer.css" rel="stylesheet">
<link href="resources/css/notify_style.css" rel="stylesheet">

<!-- 글꼴 (Noto Sans) -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
	<!--header-->
    <div class="header">
        <div class="head-inner">
            <div class="logo">
                <img src="resources/image/logo.png">
            </div>
            <div class="big-category">
                <div class="category1">
                    <a href="socialing_main.html">SOCIALING</a>
                    <a href="#">CLASS</a>
                    <a href="#">MAGAZINE</a>
                </div>
                <div class="category2">
                    <a href="#">CART</a>
                    <a href="#">MYPAGE</a>
                </div>
            </div>
        </div>
    </div>

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
    <div class="footer">
        <div class="foot-inner">
            <div class="foot-logo foot-all">
                S O D A</div>
            <div class="information foot-all">
                <ul>주식회사 소셜 다이닝</ul>
                <ul>대표 : 홍길동 | 개인정보관리책임자 : 홍길동 | 전화 : 02-123-4567 | 이메일 : soda@gmail.com</ul>
                <ul>주소 : 서울 강남구 테헤란로 14길 6 남도빌딩 2층 | 사업자등록번호 : 000-00-00000</ul>
                    <ul> 통신판매 : 제 2021-서울강남-0000호</ul>
                        <ul>영업시간 : 월-금 오후 2시-7시</ul>
            </div>
            <div class="foot-category foot-all">
                <ul><a href="#">소다소개</a></ul>
                <ul><a href="#">공지사항 </a></ul>
                <ul><a href="#">강사신청</a></ul>
                <ul><a href="#">자주묻는질문</a></ul>
            </div>
        </div>
    </div>
    <div class="final">
        <div class="foot-final">
            <a href="terms.html">이용약관 | </a>
            <a href="personalInfo.html">개인정보처리방침 | </a>
            <a href="#">사업자정보확인</a>
        </div>
    </div>
</body>
</html>