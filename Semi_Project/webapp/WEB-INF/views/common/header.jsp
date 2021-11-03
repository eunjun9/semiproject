<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.soda.member.model.vo.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// 로그인 여부에 따라 헤더 메뉴바 마이페이지 메뉴 다르게 노출되게 설정함
 	// session 객체에 담긴 loginUser 정보를 변수에 담아두기
 	Member loginUser = (Member)session.getAttribute("loginUser");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
	<%-- session에 담긴 message 있을 경우 alert 하는 script --%>
	<% if(session.getAttribute("message") != null) {%>
	<script>
		alert('<%= session.getAttribute("message") %>');	
	</script>
	<% 
		session.removeAttribute("message");
		} 
	%>

    <!-- 외부 스타일 시트 -->
    <link href="${ contextPath }/resources/css/common/header_footer.css" rel="stylesheet">
    <!-- favicon (Real Favicon Generator)-->
    <link rel="icon" type="image/x-icon" href="${ contextPath }/resources/images/khfavicon.ico">
    <!-- 글꼴 -->
  	<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500&display=swap" rel="stylesheet">
    <!--font-family: 'Noto Sans KR', sans-serif;-->

    <!-- JQuery-->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>


</head>

<body>
    <!-- 헤더 -->
    <div class="header">
        <div class="head-inner">

          <div class="logo">
            <a href="${ contextPath }/mainpage"><img src="${ contextPath }/resources/images/logo.png"></a>

          </div>

            <div class="big-category">
                <div class="category1">
                    <a href="${ contextPath }/socialing/main">SOCIALING</a>
                    <a href="${ contextPath }/lesson/main">CLASS</a>
                    <a href="#">MAGAZINE</a>
                </div>
                
                <div class="category2">
                <a href="#">CART</a>
                <ul class="mypage">
                    <li class="mypage">
                    	<a href="${ contextPath }/mypage/main" >MYPAGE</a>
                        <ul class="mypage_sub">
                        <% if(loginUser == null) { %>
                          <li><a href="${ contextPath }/mypage/main">마이페이지</a></li>
                          <li><a href="${ contextPath }/logout">로그아웃</a></li>
                        <% } else { %>
                          <li><a href="${ contextPath }/login">로그인</a></li>
                        <% } %>
                        </ul>
                  </li></ul>
                </div>
            </div>
        </div>
    </div>
    <!-- 마이페이지 마우스 오버 시 리스트 출력 스크립트 -->
    <script>
        $(document).ready(function(){ 
          $(".mypage").mouseover(function(){ 
            $(this).children(".mypage_sub").show(300); 
          }); 
            $(".mypage").mouseleave(function(){ 
              $(".mypage_sub").hide(300); 
            });
          });
        
    </script>
</body>
</html>