<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>

	<!--외부 스타일 시트-->
    <link rel="stylesheet" href="resources/css/mypage/mypage_mainT.css">
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
            <a class="notice" href="#"><img width="7%" src="../resources/icon/bell.png"></a>
            <a class="notice" href="#"><p>알림</p></a>
            
            <div class="profile">
                <a href="#"><img width="45%" src="../resources/icon/프로필.png"></a>
                <p id="name">김철수</p>
                <p id="level">강사</p>
                <p id="mail">kh@gmail.com</p>
                <a id="myfeed" href="#">내 피드 <img width="5%" src="../resources/icon/next.png"></a>
            </div>

            <ul class="move">
                <li><a class="mv" id="modify" href="#">정보수정 <img class="pmv" width="5%" src="../resources/icon/next.png"> </a></li>
                <li><a class="mv" id="logout" href="#">로그아웃 <img class="pmv" width="5%" src="../resources/icon/next.png"> </a> </li>
            </ul>
        </div>
    </div> 
    
    <div class="wrapper2">
        <div class="interest">
            <div class="oneday">
                <h3>나의 클래스 - 원데이</h3>
                <p>9건</p>
            </div>

            <!-- Swiper -->
            <div class="slide1">
                <div class="swiper mySwiper1 socialing">
                    <div class="swiper-wrapper sw">
                        <div class="swiper-slide">
                            <a href="#"><img class="ipic" width="92%" height="20%" src="../resources/icon/friend.jpg"></a>
                            <a id="stitle" href="#">오일 파스텔 원데이 클래스</a>
                            <p id="stime">사당역 10/8 토요일 오전 10시</p>
                        </div>
                        <div class="swiper-slide">
                            <a href="#"><img class="ipic" width="92%" height="70%" src="../resources/icon/friend.jpg"></a>
                            <a id="stitle" href="#">도자기 공방 원데이 클래스</a>
                            <p id="stime">망원역 11/8 토요일 오전 12시</p>
                        </div>
                        <div class="swiper-slide">
                            <a href="#"><img class="ipic" width="92%" height="70%" src="../resources/icon/friend.jpg"></a>
                            <a id="stitle" href="#">오일 파스텔 원데이 클래스</a>
                            <p id="stime">사당역 10/8 토요일 오전 10시</p>
                        </div>
                        <div class="swiper-slide">
                            <a href="#"><img class="ipic" width="92%" height="70%" src="../resources/icon/friend.jpg"></a>
                            <a id="stitle" href="#">위빙 원데이 클래스</a>
                            <p id="stime">성수역 11/12 토요일 오전 10시</p>
                        </div>
                        <div class="swiper-slide">
                            <a href="#"><img class="ipic" width="92%" height="70%" src="../resources/icon/friend.jpg"></a>
                            <a id="stitle" href="#">오일 파스텔 원데이 클래스</a>
                            <p id="stime">사당역 10/8 토요일 오전 10시</p>
                        </div>
                        <div class="swiper-slide">
                            <a href="#"><img class="ipic" width="92%" height="70%" src="../resources/icon/friend.jpg"></a>
                            <a id="stitle" href="#">위빙 원데이 클래스</a>
                            <p id="stime">성수역 11/12 토요일 오전 10시</p>
                        </div>
                        <div class="swiper-slide">
                            <a href="#"><img class="ipic" width="92%" height="70%" src="../resources/icon/friend.jpg"></a>
                            <a id="stitle" href="#">오일 파스텔 원데이 클래스</a>
                            <p id="stime">사당역 10/8 토요일 오전 10시</p>
                        </div>
                        <div class="swiper-slide">
                            <a href="#"><img class="ipic" width="92%" height="70%" src="../resources/icon/friend.jpg"></a>
                            <a id="stitle" href="#">스콘 베이킹 원데이 클래스</a>
                            <p id="stime">홍대입구 11/10 일요일 오전 10시</p>
                        </div>
                        
                    </div>
                </div>
                

                <!-- 슬라이드 버튼 설정 -->
                <div class=button1>
                    <!-- If we need navigation buttons -->
                    <div class="but1"><img width="20px" src="../resources/icon/prev_b.png"></div>
                </div>
                

                <div class=button2>
                    <div class="but2"><img width="20px" src="../resources/icon/next_b.png"></div>
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
                                <a href="#"><img class="ipic" width="92%" height="70%" src="../resources/icon/friend.jpg"></a>
                                <a id="stitle" href="#">오일 파스텔 원데이 클래스</a>
                                <p id="stime">사당역 10/8 토요일 오전 10시</p>
                            </div>
                            <div class="swiper-slide">
                                <a href="#"><img class="ipic" width="92%" height="70%" src="../resources/icon/friend.jpg"></a>
                                <a id="stitle" href="#">도자기 공방 원데이 클래스</a>
                                <p id="stime">망원역 11/8 토요일 오전 12시</p>
                            </div>
                            <div class="swiper-slide">
                                <a href="#"><img class="ipic" width="92%" height="70%" src="../resources/icon/friend.jpg"></a>
                                <a id="stitle" href="#">위빙 원데이 클래스</a>
                                <p id="stime">성수역 11/12 토요일 오전 10시</p>
                            </div>
                            <div class="swiper-slide">
                                <a href="#"><img class="ipic" width="92%" height="70%" src="../resources/icon/friend.jpg"></a>
                                <a id="stitle" href="#">오일 파스텔 원데이 클래스</a>
                                <p id="stime">사당역 10/8 토요일 오전 10시</p>
                            </div>
                            <div class="swiper-slide">
                                <a href="#"><img class="ipic" width="92%" height="70%" src="../resources/icon/friend.jpg"></a>
                                <a id="stitle" href="#">위빙 원데이 클래스</a>
                                <p id="stime">성수역 11/12 토요일 오전 10시</p>
                            </div>
                            <div class="swiper-slide">
                                <a href="#"><img class="ipic" width="92%" height="70%" src="../resources/icon/friend.jpg"></a>
                                <a id="stitle" href="#">스콘 베이킹 원데이 클래스</a>
                                <p id="stime">홍대입구 11/10 일요일 오전 10시</p>
                            </div>
                        </div>
                    </div>
                    
                    <!-- 슬라이드 버튼 설정 -->
                    <div class=button3>
                        <!-- If we need navigation buttons -->
                        <div class="but3"><img width="20px" src="../resources/icon/prev_b.png"></div>
                    </div>
                    
                    <div class=button4>
                        <div class="but4"><img width="20px" src="../resources/icon/next_b.png"></div>
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