<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/common/mainpage.css">
    <title>SODA 메인페이지</title>

	<%-- session에 담긴 message 있을 경우 alert 하는 script --%>
	<% if(session.getAttribute("message") != null) { %>
	<script>
	alert('<%= session.getAttribute("message") %>');
	</script>
	<% 
			session.removeAttribute("message");
		} 
	%>
	
    <!-- 글꼴 (Noto Sans) -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

    <!-- Slide -->
    <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
</head>
<body>
<!-- 변수 선언 -->
<c:set var="contextPath" value="${ pageContext.servletContext.contextPath }" scope="application"/>

<!--header-->

<div class="header">
    <div class="head-inner">
        <div class="left-menu">
            <ul class="main-menu">
                <li><a class="main-logo" href="#"><b>SODA</b></a></li><br>
                <li><a class="main-menu2" href="${ contextPath }/socialing/main">SOCIALING</a></li>
                <li><a class="main-menu2" href="${ contextPath }/lesson/main">CLASS</a></li>
                <li><a class="main-menu2" href="${ contextPath }/magazine/main">MAGAZINE</a></li>
                <li><a class="main-menu2" href="#"><img class="icon" src="resources/images/장바구니.png"></img></a></li>
                <li><a class="main-menu2" href="${ contextPath }/mypage/main"><img class="icon2" src="resources/images/사람아이콘3.png"></img></a></li>
            </ul>
            <h1 class="under-logo">
                <b><span style="color: lightgray">S</span>ocial <br>
                    <span style="color: lightgray">D</span>ining</b>
            </h1>
        </div>

        <div class="banner-slide1">
            <div class="banner">
                <div>
                    <img class="header-banner" src="resources/images/main/메인페이지그림1.png">
                </div>
                
            </div>
            <div>
                <h3 class="right-title">배우고 싶다면 망설이지 말고 원데이 클래스</h3>
            </div>
            <article>
                <div class="slide">
                    <div class="swiper mySwiper1" style="width: 580px; height: 300px; margin-left: 70px;">
                        <div class="swiper-wrapper">
                        <div class="swiper-slide">
                            <div id="thumbox">
                                <ul>
                                    <li><img src="resources/images/main/climing.png"><br></li>
                                </ul>
                                
                            </div>
                            <a href="#">
                                <div id="titlebox">
                                    <p id="s-thumtitle">클라이밍</p><br>
                                    <h5 id="s-thumsub" style="margin-left: 30px;">나는 나를 이긴다</h5>
                                    
                                </div>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <div id="thumbox">
                                <ul>
                                    <li><img src="resources/images/main/surfing.png"><br></li>
                                </ul>
  
                            </div>
                            <a href="#">
                                <div id="titlebox">
                                    <p id="s-thumtitle">서핑</p><br>
                                    <h5 id="s-thumsub" style="margin-left: 30px;">두려움을 넘어서</h5>
                                    
                                </div>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <div id="thumbox">
                                <ul>
                                    <li><img src="resources/images/main/poledancing.png"><br></li>
                                </ul>

                            </div>
                            <a href="#">
                                <div id="titlebox">
                                    <p id="s-thumtitle">폴댄스</p><br>
                                    <h5 id="s-thumsub" style="margin-left: 30px;">내 한계에 도전하다</h5>
                                    
                                </div>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <div id="thumbox">
                                <ul>
                                    <li><img src="resources/images/main/climing.png"><br></li>
                                </ul>
 
                            </div>
                            <a href="#">
                                <div id="titlebox">
                                    <p id="s-thumtitle">클라이밍</p><br>
                                    <h5 id="s-thumsub" style="margin-left: 30px;">나는 나를 이긴다</h5>
                                    
                                </div>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <div id="thumbox">
                                <ul>
                                    <li><img src="resources/images/main/surfing.png"><br></li>
                                </ul>
     
                            </div>
                            <a href="#">
                                <div id="titlebox">
                                    <p id="s-thumtitle">서핑</p><br>
                                    <h5 id="s-thumsub" style="margin-left: 30px;">두려움을 넘어서</h5>
                                    
                                </div>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <div id="thumbox">
                                <ul>
                                    <li><img src="resources/images/main/poledancing.png"><br></li>
                                </ul>
  
                            </div>
                            <a href="#">
                                <div id="titlebox">
                                    <p id="s-thumtitle">폴댄스</p><br>
                                    <h5 id="s-thumsub" style="margin-left: 30px;">내 한계에 도전하다</h5>
                                    
                                </div>
                            </a>
                        </div>
                        </div> 
                        
                    </div> 
                        <div class="button1">
                            <!-- If we need navigation buttons -->
                            <div class="but1"><img width="30px" src="resources/images/main/prev_b.png"></div>
                        </div>
                        
                        <div class="button2">
                            <div class="but2"><img width="30px" src="resources/images/main/next_b.png"></div>
                        </div>
                </div>
                </article>

            <!-- Swiper JS -->
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
        
    <!-- Initialize Swiper -->
    <script>
        var swiper1 = new Swiper(".mySwiper1", {
            slidesPerView: 3,
            spaceBetween: 25,

            loop: true,

            autoplay:{
                delay: 2000, 
                disableOnInteraction: false,
            },
            
            // Navigation arrows
            navigation: {
                nextEl: '.but1',
                prevEl: '.but2',
            },
        });
    </script>

        </div>

     </div>

     <div class="socialing-content">
        <div>
            <h3 class="content-title">취향이 통하는 친구와 원데이 소셜링</h3>
            <h5><a class="view-all" href="#">전체보기</a></h5>
        </div>

        <article>
                <div class="slide">
                    <div class="swiper mySwiper2">
                        <div class="swiper-wrapper">
                        <div class="swiper-slide">
                            <div id="thumbox">
                                <img src="resources/images/main/flower1.PNG"><br>
                            </div>
                            <a href="#">
                                <div id="titlebox">
                                    <p id="s-thumtitle">할로윈 같이 즐겨요</p><br>
                                    <h5 id="s-thumsub">이태원역 6호선 10.31(일) 오후 6:00</h5>
                                    
                                </div>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <div id="thumbox">
                                <img src="resources/images/main/flower1.PNG"><br>
                               
                            </div>
                            <a href="#">
                                <div id="titlebox">
                                    <p id="s-thumtitle">아침에 공원에서 산책하실 분!</p><br>
                                    <h5 id="s-thumsub">평촌 중앙공원 10.20(수) 오전 9:00</h5>
                                    
                                </div>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <div id="thumbox">
                                <img src="resources/images/main/flower1.PNG"><br>
                                
                            </div>
                            <a href="#">
                                <div id="titlebox">
                                    <p id="s-thumtitle">이터널스 같이 보러가요</p><br>
                                    <h5 id="s-thumsub">CGV 용산아이파크몰 11.20(토) 오...</h5>
                                    
                                </div>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <div id="thumbox">
                                <img src="resources/images/main/flower1.PNG"><br>
                                
                            </div>
                            <a href="#">
                                <div id="titlebox">
                                    <p id="s-thumtitle">할로윈 같이 즐겨요</p><br>
                                    <h5 id="s-thumsub">이태원역 6호선 10.31(일) 오후 6:00</h5>
                                    
                                </div>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <div id="thumbox">
                                <img src="resources/images/main/flower1.PNG"><br>
                                
                            </div>
                            <a href="#">
                                <div id="titlebox">
                                    <p id="s-thumtitle">아침에 공원에서 산책하실 분!</p><br>
                                    <h5 id="s-thumsub">평촌 중앙공원 10.20(수) 오전 9:00</h5>
                                    
                                </div>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <div id="thumbox">
                                <img src="resources/images/main/flower1.PNG"><br>
                                
                            </div>
                            <a href="#">
                                <div id="titlebox">
                                    <p id="s-thumtitle">이터널스 같이 보러가요</p><br>
                                    <h5 id="s-thumsub">CGV 용산아이파크몰 11.20(토) 오...</h5>
                                    
                                </div>
                            </a>
                        </div>
                        </div> 
                    </div> 
                </div>
                    
                    <div class="button3">
                        <!-- If we need navigation buttons -->
                        <div class="but3"><img width="30px" src="resources/images/main/prev_b.png"></div>
                    </div>
                    
                    <div class="button4">
                        <div class="but4"><img width="30px" src="resources/images/main/next_b.png"></div>
                    </div>
            </article>

            <!-- Swiper JS -->
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
        
    <!-- Initialize Swiper -->
    <script>
        var swiper2 = new Swiper(".mySwiper2", {
            slidesPerView: 3,
            spaceBetween: 30,

            loop: true,
            
            // Navigation arrows
            navigation: {
                nextEl: '.but3',
                prevEl: '.but4',
            },
        });
    </script>

     </div>
     
     <div class="onedayclass-content">
        <div>
            <h3 class="content-title">취향을 더 깊이있게 알아가는 원데이클래스</h3>
            <h5><a class="view-all" href="#">전체보기</a></h5>
        </div>
        <article>
                <div class="slide">
                    <div class="swiper mySwiper3">
                        <div class="swiper-wrapper">
                        <div class="swiper-slide">
                            <div id="thumbox">
                                <img src="resources/images/main/flower1.PNG"><br>
                            </div>
                            <a href="#">
                                <div id="titlebox">
                                    <p id="s-thumtitle">할로윈 같이 즐겨요</p><br>
                                    <h5 id="s-thumsub">이태원역 6호선 10.31(일) 오후 6:00</h5>
                                    
                                </div>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <div id="thumbox">
                                <img src="resources/images/main/flower1.PNG"><br>
                               
                            </div>
                            <a href="#">
                                <div id="titlebox">
                                    <p id="s-thumtitle">아침에 공원에서 산책하실 분!</p><br>
                                    <h5 id="s-thumsub">평촌 중앙공원 10.20(수) 오전 9:00</h5>
                                    
                                </div>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <div id="thumbox">
                                <img src="resources/images/main/flower1.PNG"><br>
                                
                            </div>
                            <a href="#">
                                <div id="titlebox">
                                    <p id="s-thumtitle">이터널스 같이 보러가요</p><br>
                                    <h5 id="s-thumsub">CGV 용산아이파크몰 11.20(토) 오...</h5>
                                    
                                </div>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <div id="thumbox">
                                <img src="resources/images/main/flower1.PNG"><br>
                                
                            </div>
                            <a href="#">
                                <div id="titlebox">
                                    <p id="s-thumtitle">할로윈 같이 즐겨요</p><br>
                                    <h5 id="s-thumsub">이태원역 6호선 10.31(일) 오후 6:00</h5>
                                    
                                </div>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <div id="thumbox">
                                <img src="resources/images/main/flower1.PNG"><br>
                                
                            </div>
                            <a href="#">
                                <div id="titlebox">
                                    <p id="s-thumtitle">아침에 공원에서 산책하실 분!</p><br>
                                    <h5 id="s-thumsub">평촌 중앙공원 10.20(수) 오전 9:00</h5>
                                    
                                </div>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <div id="thumbox">
                                <img src="resources/images/main/flower1.PNG"><br>
                                
                            </div>
                            <a href="#">
                                <div id="titlebox">
                                    <p id="s-thumtitle">이터널스 같이 보러가요</p><br>
                                    <h5 id="s-thumsub">CGV 용산아이파크몰 11.20(토) 오...</h5>
                                    
                                </div>
                            </a>
                        </div>
                        </div> 
                    </div> 
                </div>
    
            </div>
                <div class="button5">
                    <!-- If we need navigation buttons -->
                    <div class="but5"><img width="30px" src="resources/images/main/prev_b.png"></div>
                </div>
                
                <div class="button6">
                    <div class="but6"><img width="30px" src="resources/images/main/next_b.png"></div>
                </div>
            </article>
    
    
     <!-- Swiper JS -->
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
        
    <!-- Initialize Swiper -->
    <script>
        var swiper3 = new Swiper(".mySwiper3", {
            slidesPerView: 3,
            spaceBetween: 30,

            loop: true,
            
            // Navigation arrows
            navigation: {
                nextEl: '.but5',
                prevEl: '.but6',
            },
        });
    </script>

</div>

    
      
    
    <!-- 예제 종료 -->
    <!--footer-->
    <div class="footer" >
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
                <ul><a href="#">소다소개</a></ul>
                <ul><a href="#">공지사항 </a></ul>
                <ul><a href="#">강사신청</a></ul>
                <ul><a href="#">자주묻는질문</a></ul>
            </div>


        </div>
    </div>
    <div class="final">
        <div class="foot-final">
            <a href="#">이용약관 | </a>
            <a href="#">개인정보처리방침 | </a>
            <a href="#">사업자정보확인</a>
        </div>
    </div>

</div>


</body>

</html>