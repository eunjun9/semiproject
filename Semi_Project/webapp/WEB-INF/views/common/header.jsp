<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.soda.member.model.vo.Member"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
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

 	<!-- CSS -->
    <!-- 브라우저별로 디폴트로 적용된 CSS에 차이(여백, 폰트 크기 등)가 있어 CSS가 별도로
   	 지정되지 않은 요소는 브라우져 별로 다르게 보일 가능성이 있음. 만들어져 있는 리셋 CSS 활용. -->
    <!-- ress.css (모든 CSS 리셋이 아니라 디폴트 스타일을 활용해서 브라우저들의 최소한의 오차를 없앰) 
    https://github.com/filipelinhares/ress -->
<!--     <link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css"> -->
    <!-- 외부 스타일 시트 -->
    <link href="header.css" rel="stylesheet">
    <!-- favicon (Real Favicon Generator)-->
    <link rel="icon" type="image/x-icon" href="resources/image/khfavicon.ico">
    <!-- 글꼴 -->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <!--font-family: 'Noto Sans KR', sans-serif;-->

    <!-- JQuery-->
    <script src="../js/jquery-3.6.0.min.js"></script>


</head>

<body>
<!-- 변수 선언 -->
<c:set var="contextPath" value="${ pageContext.servletContext.contextPath }" 
scope="application"/>

    <!-- 헤더 -->
    <div class="header">
        <div class="head-inner">

          <div class="logo">
            <a href="#"><img src="resources/images/logo.png"></a>
          </div>

            <div class="big-category">
                <div class="category1">
                    <a href="#">SOCIALING</a>
                    <a href="${ contextPath }/class/main">CLASS</a>
                    <a href="#">MAGAZINE</a>
                </div>
                <div class="category2">
                    <a href="#">CART</a>
                    <li class="mypage">
                        <a href="${ contextPath }/mypage/list" >MYPAGE</a>
                        <ul class="mypage_sub">
                            <li><a href="${ contextPath }/mypage/list">마이페이지</a></li>
                            <li><a href="${ contextPath }/logout">로그아웃</a></li>
                        </ul>
                    </li>
                </div>
            </div>

        </div>
    </div>
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