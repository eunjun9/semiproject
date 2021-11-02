<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지_모임내역</title>

	<!--외부 스타일 시트-->
    <link href="resources/css/mypage/mypage_socialingList.css" rel="stylesheet">

     <!-- font -->
     <link rel="preconnect" href="https://fonts.googleapis.com">
     <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
     <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500&display=swap" rel="stylesheet">

  	<!--슬라이드-->
  	<link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
  	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

    <!-- JQuery -->
    <script src="resources/js/jquery-3.6.0.min.js"></script> 

</head>
<body>
    <!-- header -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

<!-- 모임내역 바디 -->
    <div class="sList_wrapper">
        <div id="sList_box">
            <div class="sList_title">
                <a id="back" href="#">&lt; 마이페이지</a>
                <h2>모임내역</h2>
                <p id="main_title">최근 2개월 이내 모임내역</p>
                <hr>
            </div>
            
            <div class="sList_before">
                <h3>참여 전 모임</h3> 
                <p id="before_count">6건</p>
            </div>
                
                <!-- Swiper -->
                <div class="slide1">
                    <div class="swiper mySwiper1 socialing">
                        <div class="swiper-wrapper sw">
                            <div class="swiper-slide">
                                <a href="#"><img class="ipic" width="75%" height="15%" src="../resources/icon/friend.jpg"></a>
                                <a id="stitle" href="#">주말에 관악산 등산하실 분</a>
                                <p id="stime">사당역 10/8 토요일 오전 10시</p>
                            </div>
                            <div class="swiper-slide">
                                <a href="#"><img class="ipic" width="75%" height="15%" src="../resources/icon/friend.jpg"></a>
                                <a id="stitle" href="#">망원동 카페 투어 가요~!</a>
                                <p id="stime">망원역 11/8 토요일 오전 12시</p>
                            </div>
                            <div class="swiper-slide">
                                <a href="#"><img class="ipic" width="75%" height="15%" src="../resources/icon/friend.jpg"></a>
                                <a id="stitle" href="#">배드민턴 내기 하실 분</a>
                                <p id="stime">홍대입구 10/30 토요일 오전 10시</p>
                            </div>
                            <div class="swiper-slide">
                                <a href="#"><img class="ipic" width="75%" height="18%" src="../resources/icon/friend.jpg"></a>
                                <a id="stitle" href="#">주말에 관악산 등산하실 분</a>
                                <p id="stime">사당역 10/8 토요일 오전 10시</p>
                            </div>
                            <div class="swiper-slide">
                                <a href="#"><img class="ipic" width="75%" height="18%" src="../resources/icon/friend.jpg"></a>
                                <a id="stitle" href="#">배드민턴 내기 하실 분</a>
                                <p id="stime">홍대입구 10/30 토요일 오전 10시</p>
                            </div>
                            <div class="swiper-slide">
                                <a href="#"><img class="ipic" width="75%" height="18%" src="../resources/icon/friend.jpg"></a>
                                <a id="stitle" href="#">망원동 카페 투어 가요~!</a>
                                <p id="stime">망원역 11/8 토요일 오전 12시</p>
                            </div>  
                        </div>
                        <br><br><hr>
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
        

            <div class="sList_after">
                <h3>참여 완료 모임</h3>
                <p id="after_count">5건</p>
            </div>   
            <!-- Swiper -->
            <div class="slide1">
                <div class="swiper mySwiper2 socialing">
                    <div class="swiper-wrapper sw">
                        <div class="swiper-slide">
                            <a href="#"><img class="ipic" width="75%" height="15%" src="../resources/icon/friend.jpg"></a>
                            <a id="stitle" href="#">주말에 관악산 등산하실 분</a>
                            <p id="stime">사당역 10/8 토요일 오전 10시</p>
                        </div>
                        <div class="swiper-slide">
                            <a href="#"><img class="ipic" width="75%" height="15%" src="../resources/icon/friend.jpg"></a>
                            <a id="stitle" href="#">망원동 카페 투어 가요~!</a>
                            <p id="stime">망원역 11/8 토요일 오전 12시</p>
                        </div>
                        <div class="swiper-slide">
                            <a href="#"><img class="ipic" width="75%" height="15%" src="../resources/icon/friend.jpg"></a>
                            <a id="stitle" href="#">배드민턴 내기 하실 분</a>
                            <p id="stime">홍대입구 10/30 토요일 오전 10시</p>
                        </div>
                        <div class="swiper-slide">
                            <a href="#"><img class="ipic" width="75%" height="18%" src="../resources/icon/friend.jpg"></a>
                            <a id="stitle" href="#">주말에 관악산 등산하실 분</a>
                            <p id="stime">사당역 10/8 토요일 오전 10시</p>
                        </div>
                        <div class="swiper-slide">
                            <a href="#"><img class="ipic" width="75%" height="18%" src="../resources/icon/friend.jpg"></a>
                            <a id="stitle" href="#">배드민턴 내기 하실 분</a>
                            <p id="stime">홍대입구 10/30 토요일 오전 10시</p>
                        </div>
                        <div class="swiper-slide">
                            <a href="#"><img class="ipic" width="75%" height="18%" src="../resources/icon/friend.jpg"></a>
                            <a id="stitle" href="#">망원동 카페 투어 가요~!</a>
                            <p id="stime">망원역 11/8 토요일 오전 12시</p>
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
        
            <!-- Initialize Swiper -->
            <script>
                var swiper1 = new Swiper(".mySwiper2", {
                    slidesPerView: 3,
                    spaceBetween: 1,
                    
                    loop : true, 
                    
                    // Navigation arrows
                    navigation: {
                        nextEl: '.but3',
                        prevEl: '.but4',
                    }
                });
            </script>

        </div>
            
    </div>


	<!-- footer -->
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>