<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>footer</title>

    <!-- 외부 스타일 시트 -->
    <link href="${ contextPath }/resources/css/common/header_footer.css" rel="stylesheet">
    <!-- favicon (Real Favicon Generator)-->
    <link rel="icon" type="image/x-icon" href="${ contextPath }/resources/image/khfavicon.ico">
    <!-- 글꼴 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500&display=swap" rel="stylesheet">

    <!-- JQuery-->
    <script src="${ contextPath }/resources/js/jquery-3.6.0.min.js"></script>

</head>
<body>
<!-- 변수 선언 -->
<c:set var="contextPath" value="${ pageContext.servletContext.contextPath }" scope="application"/>

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
                <ul><a href="${ contextPath }/footer/content">소다소개</a></ul>
                <ul><a href="#">공지사항 </a></ul>
                <ul><a href="https://forms.gle/Nf4z3FqR5zrg8WtU8">강사신청</a></ul>
                <ul><a href="#">자주묻는질문</a></ul>
            </div>


        </div>
    </div>
    <div class="final">
        <div class="foot-final">
            <a href="${ contextPath }/footer/terms">이용약관 | </a>
            <a href="${ contextPath }/footer/personalInfo">개인정보처리방침 | </a>
            <a href="#">사업자정보확인</a>
        </div>
    </div>

</body>
</html>