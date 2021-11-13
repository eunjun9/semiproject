<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지_결제내역</title>

 	 <!--외부 스타일 시트-->
     <link href="${ contextPath }/resources/css/mypage/mypage_payList.css?2" rel="stylesheet">

     <!-- font -->
     <link rel="preconnect" href="https://fonts.googleapis.com">
     <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
     <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500&display=swap" rel="stylesheet">

   	 <!-- JQuery-->
     <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

</head>
<body>
    <!-- header -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

 <!-- 결제 내역 바디 -->
    <div class="pList_wrapper">
        <div id="pList_box">
            <div id="firstbox">
                <a id="back" href="${ contextPath }/mypage/main">&lt; 마이페이지</a>
                <h2>결제 내역</h2>
                <p id="main_title">날짜를 선택하세요(1년 이내)</p>
                <hr>
            </div>
            <div class="pay_filter">
                <form>
                    <label>날짜 선택&nbsp;</label>
                    <input type="date" name="date1">
                    ― <input type="date" name="date2">
                    <button type="submit" name="filter_submit">검색</button>
                </form>
            </div>

            <hr>
            <div class="list_title">
                <h3 id="cInfo">클래스 정보 </h3>
                <h3 id="cDate">날짜/기한</h3>
                <h3 id="cPrice">가격</h3>
            </div>
            <hr>
            
            <!-- 결제내역 리스트는 hidden으로 해두고 필터링 거친 후 최신 순으로 정렬 -->
            <div class="list_detail">
                <form method="post">
                    <div class="class_info">
                        <div class="class_img"><a href="#"><img name="class_img" src="../resources/image/bakingclass.jpg"></a></div>
                        <div class="class_type"><p name="class_type">ONE-DAY</p></div>
                        <div class="class_title"><p name="class_title">프랑스 제과학교 출신 파티시에의 타르트 클래스</p></div>
                    </div>
                    
                    <div class="o_date">
                        <p class="o_dateP">2021-11-07 토요일 오후 7시</p>
                    </div>
                    
                    <div class="price">
                        <p class="class_priceP">60,000원</p>
                        <button type="button" class="refund_Btn">취소</button>
                    </div><hr>
    
                    <div class="class_info">
                        <div class="class_img"><img name="class_img" src="../resources/image/bakingclass.jpg"></div>
                        <div class="class_type"><p>ONE-DAY</p></div>
                        <div class="class_title"><p>프랑스 제과학교 출신 파티시에의 타르트 클래스</p></div>
                    </div>
                    
                    <div class="v_date">
                        <p class="v_dateP">40일</p>
                    </div>
                    
                    <div class="price">
                        <p class="class_priceP">60,000원</p>
                        <button type="button" class="refund_Btn">취소</button>
                    </div><hr>
                </form>
            </div>
        </div>
    </div>


	<!-- footer -->
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>