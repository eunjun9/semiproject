<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
 	// session 객체에 담긴 loginUser 정보를 변수에 담아두기
 	// Member loginUser = (Member)session.getAttribute("loginUser");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>

<%-- session에 담긴 message 있을 경우 alert 하는 script --%>
<% if(session.getAttribute("message") != null) { %>
<script>
	alert('<%= session.getAttribute("message") %>');
</script>
<% 
		session.removeAttribute("message"); // alert 창을 한번만 띄우기 위해 alert 후 세션 제거
	}
%>

    <!-- 외부 스타일 시트 -->
    <link href="<%= request.getContextPath() %>/resources/css/common/header_footer.css" rel="stylesheet">
    <!-- favicon (Real Favicon Generator)-->
    <link rel="icon" type="image/x-icon" href="resources/image/khfavicon.ico">
    <!-- 글꼴 -->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <!--font-family: 'Noto Sans KR', sans-serif;-->

    <!-- JQuery-->
    <script src="../js/jquery-3.6.0.min.js"></script>


</head>

<body>
<c:set var="contextPath" value="${ pageContext.servletContext.contextPath }" scope="application"/>

    <!--header-->
    <div class="header">
        <div class="head-inner">
		
          <div class="logo">
        	<!--  로고 이미지를 클릭하면 첫 화면으로 -->
         	<a href="<%= request.getContextPath() %>">
            <img src="<%= request.getContextPath() %>/resources/images/logo.png"></a>
          </div>

            <div class="big-category">
                <div class="category1">
                    <a href="#">SOCIALING</a>
                    <a href="#">CLASS</a>
                    <a href="#">MAGAZINE</a>
                </div>
                <div class="category2">
                    <a href="#">CART</a>
                    <a href="#">MYPAGE</a>
                    <!-- 마우스 오버 시  마이페이지 / 로그아웃 리스트 출력되게 변경해야됨(예원) -->
                </div>
            </div>
        </div>
    </div>

</body>
</html>