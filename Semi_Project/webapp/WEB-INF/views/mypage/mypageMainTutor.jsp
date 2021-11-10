<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>

	<!--외부 스타일 시트-->
    <link rel="stylesheet" href="${ contextPath }/resources/css/mypage/mypage_mainT.css?1">
    <!-- font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500&display=swap" rel="stylesheet">

    <!--슬라이드-->
    <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
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
                <a href="#" id="profileimg"><img width="45%" src="${ contextPath }/resources/images/yewon/profile.png"></a>
                <p id="name">${ loginUser.userName }</p>
                <p id="level">${ loginUser.userGrade }</p>
                <p id="mail">${ loginUser.userId }</p>
                <a id="myfeed" href="${ contextPath }/myfeed">내 피드 <img width="5%" src="${ contextPath }/resources/images/yewon/next.png"></a>
            </div>

            <ul class="move">
                <li><a class="mv" id="modify" href="${ contextPath }/mypage/userinfomodify">정보수정 <img class="pmv" width="5%" src="${ contextPath }/resources/images/yewon/next.png"> </a></li>
                <li><a class="mv" id="logout" href="${ contextPath }/logout">로그아웃 <img class="pmv" width="5%" src="${ contextPath }/resources/images/yewon/next.png"> </a> </li>
            </ul>
        </div>
    </div> 
    
    <div class="wrapper2">
        <div class="interest">
            <div class="oneday">
                <h3>나의 클래스 - 원데이</h3>
                <p></p>
            </div>

            <!-- Swiper -->
            <div class="slide1">
                <div class="swiper mySwiper1 socialing">
                    <div class="swiper-wrapper sw">
                    	<!-- 반복문으로 글 넣기 -->
                    	<c:forEach var="lesson" items="${ lessonList }">
                    	<div class="swiper-slide" onclick="detailView(${lesson.nNum})">
                            <a><img class="ipic" width="92%" height="20%"src="${ contextPath }${ lesson.photoList.get(0).route}${ lesson.photoList.get(0).changeName }"></a>
                            <a id="stitle">${lesson.nTitle }</a>
                            <p id="stime">${lesson.cLocation }</p>
                        </div>
                    	</c:forEach>
                    </div>
                </div>
                

                <!-- 슬라이드 버튼 설정 -->
                <div class=button1>
                    <!-- If we need navigation buttons -->
                    <div class="but1"><img width="20px" src="${ contextPath }/resources/images/yewon/prev_b.png"></div>
                </div>
                

                <div class=button2>
                    <div class="but2"><img width="20px" src="${ contextPath }/resources/images/yewon/next_b.png"></div>
                </div>
                
            </div> 
            
            <!-- Initialize Swiper -->
            <script>
                var swiper1 = new Swiper(".mySwiper1", {
                    slidesPerView: 3,
                    spaceBetween: 1,
                    
                    loop : true, 
                    
                    // Navigation arrows
                    navigation: {
                        nextEl: '.but2',
                        prevEl: '.but1',
                    }
                    
                });
                </script>

            <!-- VOD 클래스 -->
            <div class="vod">
                <h3>나의 클래스 - VOD</h3>
                <p>6건</p>
            </div>

                <!-- Swiper -->
                <div class="slide1">
                    
                    <div class="swiper mySwiper2 socialing">
                        <div class="swiper-wrapper sw">
                            <div class="swiper-slide">
                                <a href="#"><img class="ipic" width="92%" height="70%" src="${ contextPath }/resources/images/yewon/friend.jpg"></a>
                                <a id="stitle" href="#">오일 파스텔 원데이 클래스</a>
                                <p id="stime">사당역 10/8 토요일 오전 10시</p>
                            </div>
                            <div class="swiper-slide">
                                <a href="#"><img class="ipic" width="92%" height="70%" src="${ contextPath }/resources/images/yewon/friend.jpg"></a>
                                <a id="stitle" href="#">도자기 공방 원데이 클래스</a>
                                <p id="stime">망원역 11/8 토요일 오전 12시</p>
                            </div>
                            <div class="swiper-slide">
                                <a href="#"><img class="ipic" width="92%" height="70%" src="${ contextPath }/resources/images/yewon/friend.jpg"></a>
                                <a id="stitle" href="#">위빙 원데이 클래스</a>
                                <p id="stime">성수역 11/12 토요일 오전 10시</p>
                            </div>
                            <div class="swiper-slide">
                                <a href="#"><img class="ipic" width="92%" height="70%" src="${ contextPath }/resources/images/yewon/friend.jpg"></a>
                                <a id="stitle" href="#">오일 파스텔 원데이 클래스</a>
                                <p id="stime">사당역 10/8 토요일 오전 10시</p>
                            </div>
                            <div class="swiper-slide">
                                <a href="#"><img class="ipic" width="92%" height="70%" src="${ contextPath }/resources/images/yewon/friend.jpg"></a>
                                <a id="stitle" href="#">위빙 원데이 클래스</a>
                                <p id="stime">성수역 11/12 토요일 오전 10시</p>
                            </div>
                            <div class="swiper-slide">
                                <a href="#"><img class="ipic" width="92%" height="70%" src="${ contextPath }/resources/images/yewon/friend.jpg"></a>
                                <a id="stitle" href="#">스콘 베이킹 원데이 클래스</a>
                                <p id="stime">홍대입구 11/10 일요일 오전 10시</p>
                            </div>
                        </div>
                    </div>
                    
                    <!-- 슬라이드 버튼 설정 -->
                    <div class=button3>
                        <!-- If we need navigation buttons -->
                        <div class="but3"><img width="20px" src="${ contextPath }/resources/images/yewon/prev_b.png"></div>
                    </div>
                    
                    <div class=button4>
                        <div class="but4"><img width="20px" src="${ contextPath }/resources/images/yewon/next_b.png"></div>
                    </div>
                    
                </div> 
            </div>
            
            <!-- Initialize Swiper -->
            <script>
                var swiper1 = new Swiper(".mySwiper2", {
                    slidesPerView: 3,
                    spaceBetween: 1,
                    
                    loop : true, 
                    
                    // Navigation arrows
                    navigation: {
                        nextEl: '.but4',
                        prevEl: '.but3',
                    }
                });
            </script>   

    </div>
</div>    
</div>

	<!-- footer -->
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>