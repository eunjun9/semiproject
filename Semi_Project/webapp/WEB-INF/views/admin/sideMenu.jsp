<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지 사이드메뉴</title>
    <!-- 외부 스타일 시트 -->
    <link href="${ contextPath }/resources/css/admin/admin-style.css?4" rel="stylesheet">
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

  <div class="admin-menu">
                        <ul id="menu">
                          <li class="member menu">
                            <a href="${ contextPath }/mypage/adminmain"> <img src="${ contextPath }/resources/images/admin1.png">회원관리</a> 
                          </li> 
                  
                         <li class="content menu">
                            <a href="${ contextPath }/admin/report"><img src="${ contextPath }/resources/images/admin2.png">신고관리</a> 
                         </li>
                  
                        <li class="sales menu">
                           <a href="#"><img src="${ contextPath }/resources/images/admin3.png">매출관리</a> 
                           <ul class="submenu"> 
                            <li><a href="#">매출조회</a></li> 
                            <li><a href="${ contextPath }/payroll/page">정산내역</a></li> 
                            <li><a href="${ contextPath }/refund">환불내역</a></li> 
                           </ul> 
                         </li>
                      </ul>
                  </div>

<!-- 사이드바 드롭다운 메뉴 -->
    <script>
        $(document).ready(function(){ 
          $(".menu").mouseover(function(){ 
            $(this).children(".submenu").show(300); 
          }); 
            $(".menu").mouseleave(function(){ 
              $(this).children(".submenu").hide(300); 
            });
          });
        
        </script>
        
</body>
</html>