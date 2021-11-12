<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지_모임내역</title>

	<!--외부 스타일 시트-->
    <link href="${ contextPath }/resources/css/mypage/mypage_socialingList.css?2" rel="stylesheet">

     <!-- font -->
     <link rel="preconnect" href="https://fonts.googleapis.com">
     <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
     <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500&display=swap" rel="stylesheet">

  	<!--슬라이드-->
  	<link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
  	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    
	  <!-- JQuery-->
     <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
    <!-- header -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

<!-- 모임내역 바디 -->
    <div class="sList_wrapper">
        <div id="sList_box">
            <div class="sList_title">
                <a id="back" href="${ contextPath }/mypage/main">&lt; 마이페이지</a>
                <h2>모임내역</h2>
                <p id="main_title">최근 2개월 이내 모임내역</p>
                <hr>
            </div>
            
            <div class="sList_before">
                <h3>참여 전 모임</h3> 
                <br>
            </div>
				
                <!-- Swiper -->
              <div class="slist_body">
              <div id="firstline"> 
                <div class="slide1">
                    <div class="swiper mySwiper1 socialing">
                        <div class="swiper-wrapper sw">
                            <c:forEach var="socialing" items = "${ socialingListBefore }" >
	                            <div class="swiper-slide" onclick="detailView()">
	                                <img class="ipic" src="${ contextPath }${ socialing.photoList.get(0).route}${ socialing.photoList.get(0).changeName }">
	                               	<br><p id="stitle">${ socialing.nTitle }</p><br>
	                                <c:choose>
	                                	<c:when test="${socialing.splace.contains('|') }">
	                                		<p id="stime">${ socialing.splace.split("\\|")[0] } | ${ socialing.sdate }</p>
	                                	</c:when>
	                                	<c:otherwise>
	                                		<p id="stime">${ socialing.splace } | ${ socialing.sdate }</p>
	                                	</c:otherwise>
	                            	</c:choose>
	                            </div>
	                     </c:forEach>
                        </div>
                    </div>
                </div> 
             			    <!-- 슬라이드 버튼 설정 -->
                			<div class="btnArea1" >
		                    <div class=button1>
		                        <div class="but1"><img width="20px" src="${ contextPath }/resources/images/yewon/prev_b.png"></div>
		                    </div>
	                    
		                    <div class=button2>
		                        <div class="but2"><img width="20px" src="${ contextPath }/resources/images/yewon/next_b.png"></div>
		                    </div>    
                			</div>
                
              </div>
                <br><br><hr>
            
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
               <br>
            </div>   
            
           <div id="secondline">
            <!-- Swiper -->
            <div class="slide1">
                <div class="swiper mySwiper2 socialing">
                    <div class="swiper-wrapper sw">
                        <c:forEach var="socialing" items = "${ socialingListAfter }" >
	                            <div class="swiper-slide" onclick="detailView()">
	                                <img class="ipic" src="${ contextPath }${ socialing.photoList.get(0).route}${ socialing.photoList.get(0).changeName }">
	                               	<br><p id="stitle">${ socialing.nTitle }</p><br>
	                                <c:choose>
	                                	<c:when test="${socialing.splace.contains('|') }">
	                                		<p id="stime">${ socialing.splace.split("\\|")[0] } | ${ socialing.sdate }</p>
	                                	</c:when>
	                                	<c:otherwise>
	                                		<p id="stime">${ socialing.splace } | ${ socialing.sdate }</p>
	                                	</c:otherwise>
	                            	</c:choose>
	                            </div>
	                     </c:forEach>
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