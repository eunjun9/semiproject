<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html lang="ko">

<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Full Screen Site">
    <title>시작페이지</title>
    <link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
    <link href="resources/css/common/startpage.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
</head>

<body>
<!-- 변수 선언 -->
<c:set var="contextPath" value="${ pageContext.servletContext.contextPath }" 
scope="application"/>

	<div id="home1" class="big-bg" style="background-image:url(resources/images/soda_home1.png)">

    <header class="page-header wrapper">
        <nav class="main-bar">
            <ul class="main-logo">
                <li><a href="<%= request.getContextPath() %>/mainpage"><b>SODA</b></a></li>
            </ul>
        </nav>
        <nav class="main-bar">
            <ul class="main-nav">
                <li><a class="button1" href="<%= request.getContextPath() %>/login">로그인</a></li>
            </ul>
        </nav>

    </header>
    
    <div class="home-content1">
        <h2 class="page-title1"><b>언제 어디서나 당신을 위한 새로운 친구</b></h2>
        <p class="page-subtitle1">
        소다에서 소셜링을 시작해보세요! 취향이 맞는 친구와 함께
        특별한 하루가 될 거에요.
        </p>
        <ul class="join-content">

            <li><a class="button2" href="<%= request.getContextPath() %>/memberjoin">가입하기</a></li>


        </ul>
    </div>
    <div class="page-under wrapper">
        <h1 class="under-logo">
            <b><span style="color: rgb(145, 224, 244)">S</span>ocial <br>
                <span style="color: rgb(145, 224, 244)">D</span>ining</b>
        </h1>
    </div>
</div>
<div id="home2" class="big-bg" style="background-image:url(resources/images/soda_home2.png)">
    <header class="page-header2">

    </header>
    
    <div class="home-content1">
        <h2 class="page-title1"><b>함께 배우고 성장하는 기쁨을 느껴보세요!</b></h2>
        <p class="page-subtitle1">
        원데이 클래스와 VOD 클래스를 통해 나를 위한 시간 갖기
        </p>
        <ul class="join-content">

            <li><a class="button2" href="<%= request.getContextPath() %>/memberjoin">가입하기</a></li>


        </ul>
    </div>
       
    <div class="img-cover"></div>
</div>
<div id="home3" class="big-bg" style="background-image:url(resources/images/soda_home3.png)">
    <header class="page-header3">
       
    </header>
    
    <div class="home-content3">
        <h2 class="page-title3"><b>꼭 오프라인이 아니어도 좋아요</b></h2>
        <p class="page-subtitle3">
        온라인에서도 만날 수 있어요. 매거진과 커뮤니티에서 취향 공유하기!
        </p>
        <ul class="join-content">
            <li><a class="button2" href="<%= request.getContextPath() %>/memberjoin">가입하기</a></li>
        </ul>
    </div>
    <div class="up-button">
        <a href="#"><img class="up-btn" src=""></a>
    </div>
        
    <div class="img-cover"></div>
    <div class="footer">
        <p>고객센터(이용 및 결제 문의)cs@kh.or.kr 02-123-4567</p><br>
        <p>주식회사 소셜 다이닝 | 대표 : 홍길동 | 개인정보관리책임자 : 홍길동 주소 : 서울 강남구 테헤란로 14길 6 남도빌딩 2층 | 사업자등록번호 : 000-00-00000</p>
    </div>
</div>

</body>
</html>