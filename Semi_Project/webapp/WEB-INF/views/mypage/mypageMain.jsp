<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>

	<!--외부 스타일 시트-->
    <link rel="stylesheet" href="${ contextPath }/resources/css/mypage/mypage_main.css?1">
    <!--폰트-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500&display=swap" rel="stylesheet">

</head>
<body>
    <!-- header -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<div class="mypage_main">
    <div class="wrapper1">
        <div class="info">
            <h2>마이 페이지</h2>
            <a class="notice" href="#"><img width="7%" src="${ contextPath }/resources/images/yewon/bell.png"></a>
            <a class="notice" href="#"><p>알림</p></a>
            
            <div class="profile">
                <a href="#"><img width="45%" src="${ contextPath }/resources/images/yewon/profile.png"></a>
                <p id="name">홍길동</p>
                <p id="level">회원</p>
                <p id="mail">kh@gmail.com</p>
                <a id="myfeed" href="${contextPath }/myfeed">내 피드 <img width="5%" src="${ contextPath }/resources/images/yewon/next.png"></a>
            </div>

            <ul class="move">
                <li><a class="mv" id="modify" href="#">정보수정 <img class="pmv" width="5%" src="${ contextPath }/resources/images/yewon/next.png"> </a></li>
                <li><a class="mv" id="slist" href="#">모임내역 <img class="pmv" width="5%" src="${ contextPath }/resources/images/yewon/next.png"> </a> </li>
                <li><a class="mv" id="plist" href="#">결제내역 <img class="pmv" width="5%" src="${ contextPath }/resources/images/yewon/next.png"> </a> </li>
                <li><a class="mv" id="logout" href="#">로그아웃 <img class="pmv" width="5%" src="${ contextPath }/resources/images/yewon/next.png"> </a> </li>
            </ul>
        </div>
    </div> 
    
    <div class="wrapper2">
        <div class="interest">
            <span>
                <h3>관심 소셜링</h3>
                <p>5건</p>
            </span>
            <div class="socialing">
                <div class="item1">
                    <a href="#"><img class="ipic" width="92%" height="70%" src="${ contextPath }/resources/images/yewon/friend.jpg"></a>
                    <a id="stitle" href="#">주말에 관악산 등산하실 분</a>
                    <p id="stime">사당역 10/8 토요일 오전 10시</p>
                </div>
                <div class="item1">
                    <a href="#"><img class="ipic" width="92%" height="70%" src="${ contextPath }/resources/images/yewon/friend.jpg"></a>
                    <a id="stitle" href="#">주말에 관악산 등산하실 분</a>
                    <p id="stime">사당역 10/8 토요일 오전 10시</p>
                </div>
                <div class="item1">
                    <a href="#"><img class="ipic" width="92%" height="70%" src="${ contextPath }/resources/images/yewon/friend.jpg"></a>
                    <a id="stitle" href="#">주말에 관악산 등산하실 분</a>
                    <p id="stime">사당역 10/8 토요일 오전 10시</p>
                </div>
                <div class="item1">
                    <a href="#"><img class="ipic" width="92%" height="70%" src="${ contextPath }/resources/images/yewon/friend.jpg"></a>
                    <a id="stitle" href="#">주말에 관악산 등산하실 분</a>
                    <p id="stime">사당역 10/8 토요일 오전 10시</p>
                </div>
                <div class="item1">
                    <a href="#"><img class="ipic" width="92%" height="70%" src="${ contextPath }/resources/images/yewon/friend.jpg"></a>
                    <a id="stitle" href="#">주말에 관악산 등산하실 분</a>
                    <p id="stime">사당역 10/8 토요일 오전 10시</p>
                </div>
                <div class="item1">
                    <a href="#"><img class="ipic" width="92%" height="70%" src="${ contextPath }/resources/images/yewon/friend.jpg"></a>
                    <a id="stitle" href="#">주말에 관악산 등산하실 분</a>
                    <p id="stime">사당역 10/8 토요일 오전 10시</p>
                </div>
            </div>
            <div class="smv">
                <a class="sarr" href="#"><img width="13px" src="${ contextPath }/resources/images/yewon/previous.png"></a>
                <a href="#"><img width="13px" src="${ contextPath }/resources/images/yewon/circle_sky.png"></a>
                <a href="#"><img width="13px" src="${ contextPath }/resources/images/yewon/circle_beige.png"></a>
                <a href="#"><img width="13px" src="${ contextPath }/resources/images/yewon/circle_beige.png"></a>
                <a href="#"><img width="13px" src="${ contextPath }/resources/images/yewon/circle_beige.png"></a>
                <a class="sarr" href="#"><img width="13px" src="${ contextPath }/resources/images/yewon/next.png"></a>
            </div>
        </div>
    </div>
</div>
	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>