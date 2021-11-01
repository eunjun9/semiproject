<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>

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