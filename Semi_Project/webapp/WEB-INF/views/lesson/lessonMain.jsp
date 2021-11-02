<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클래스_메인</title>

	<!--외부 스타일 시트-->
    <link href="resources/css/lesson/lesson_main.css" rel="stylesheet">

    <!-- font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500&display=swap" rel="stylesheet">

    <!-- JQuery-->
     <script src="resources/js/jquery-3.6.0.min.js"></script>

    <!--슬라이드-->
    <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

	<!-- 클래스 -->
    <div class="class_main">
        <div class="wrapper1">
            <h1>클래스</h1>
            <p>새로운 나, 24시간이면 충분해요</p>
        </div>

        <div class="wrapper2">
            <div class="slide">
                <ul>
                    <li><img src="resources/image/yewon/painting.jpg" width="340px" height="380px"></li>
                    <li><img src="resources/image/yewon/dance.jpg" width="340px" height="380px"></li>
                    <li><img src="resources/image/yewon/weaving.jpg" width="340px" height="380px"></li>
                    <li><img src="resources/image/yewon/baking.jpg" width="340px"  height="380px"></li>
                </ul>
            </div>
            <div class="filtering">
                <form>
                    <img id="search" width="20px" src="resources/images/yewon/search.png">
                    <input type="text" maxlength="25" size="40" placeholder="검색할 키워드를 입력해주세요" name="keyword" id="keyword" ><br>
                    
                    <label>가격</label>
                    <input id="price1" type="number" value="0" name="price1"><label> 원&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;  </label>
                    <input id="price2" type="number" value="50000" name="price2"><label> 원</label><br>

                    <label>위치</label>
                    <select name="city">
                        <option value="city"selected disabled>지역 선택</option>
                        <option value="seoul">서울</option>
                        <option value="incheon">인천</option>
                    </select>

                    <!-- 조건문으로 설정하기 -->
                    <!--지역이 서울일때 -->
                    <select name="town">
                        <option value="town"selected disabled>구 선택</option>
                        <option value="gawnak">관악구</option>
                        <option value="gangnam">강남구</option>
                        <option value="mapo">마포구</option>
                        <option value="seocho">서초구</option>
                        <option value="seongdong">성동구</option>
                        <option value="yongsan">용산구</option>
                    </select><br>   
                    <!--지역이 인천일때 -->
                    <!-- <select name="town">
                        <option value="town"selected disabled>구</option>
                        <option value="geyang">계양구</option>
                        <option value="nam">남구</option>
                        <option value="namdong">남동구</option>
                        <option value="seo">서구</option>
                        <option value="yeonsu">연수구</option>
                    </select><br>                           -->

                    <label>카테고리</label>
                    <select name="bigC">
                        <option selected disabled>대분류 선택</option>
                        <option value="it">IT</option>
                        <option value="craft">공예</option>
                        <option value="art">예술</option>
                        <option value="food">음식</option>
                        <option value="sport">운동</option>
                    </select>

                    <!-- 조건문으로 대분류 선택에 따른 소분류 목록 출력 -->
                    <!--value=it일때-->
                    <select name="smallC">
                        <option selected disabled>소분류 선택</option>
                        <option>AI·머신러닝</option>
                        <option>게임 개발</option>
                        <option>데이터 분석</option>
                        <option>모바일 App개발</option>
                        <option>서버·백엔드</option>
                        <option>프론트엔드</option>
                    </select><br>

                    <!--value=craft일때-->
                    <!-- <select name="smallC">
                        <option selected disabled>소분류 선택</option>
                        <option>도자기</option>
                        <option>뜨개질</option>
                        <option>레진아트</option>
                        <option>위빙</option>
                    </select><br> -->

                    <!--value=art일때-->
                    <!-- <select name="smallC">
                        <option selected disabled>소분류 선택</option>
                        <option>드로잉</option>
                        <option>악기</option>
                        <option>일러스트</option>
                    </select><br> -->

                    <!--value=food일때-->
                    <!-- <select name="smallC">
                        <option selected disabled>소분류 선택</option>
                        <option>베이킹</option>
                        <option>양식</option>
                        <option>와인</option>
                        <option>일식</option>
                        <option>중식</option>
                        <option>커피</option>
                        <option>한식</option>
                    </select><br> -->

                    <!--value=sport일때-->
                    <!-- <select name="smallC">
                        <option selected disabled>소분류 선택</option>
                        <option>근력운동</option>
                        <option>요가</option>
                        <option>유산소운동</option>
                        <option>폴댄스</option>
                        <option>필라테스</option>
                    </select><br> -->

                    <label>진행방식</label>
                    <input type="checkbox" value="online" name="online"><label class="ckboxlabel">온라인</label>
                    <input type="checkbox" value="offline" name="offline"><label class="ckboxlabel">오프라인</label><br>

                    <label>클래스 타입</label>
                    <input type="checkbox" value="oneday" name="oneday"><label class="ckboxlabel">원데이 클래스</label>
                    <input type="checkbox" value="vod" name="vod"><label class="ckboxlabel">VOD 클래스</label> <br>

                    <button type="reset" name="reSel">조건 초기화</button>
                    <button type="submit" name="selEnd">선택 검색</button>
                </form>
            </div>
        </div>
        
        <div class="wrapper3">
        <select>
            <option disabled>정렬 방식</option>
            <option selected >인기순</option>
            <option>최신순</option>
            <option>가격 낮은순</option>
            <option>가격 높은순</option>
        </select><br>
        </div>
        
        <div class="wrapper4">
            <div class="cItem" >
                <a href="class_detail.html">
                    <img class="cThumbnail" src="../resources/image/class_ex1.jpg">
                    <h4 class="cMTitle">펀치니들을 이용한 티프팅 소품 제작법 </h4>
                    <p class="cPrice">50,000원</p>
                </a>
            </div>
            <div class="cItem">
                <img class="cThumbnail" src="../resources/image/class_ex2.JPG">
                <h4 class="cMTitle">펀치니들을 이용한 티프팅 소품 제작법 </h4>
                <p class="cPrice">50,000원</p>
            </div>
            <div class="cItem">
                <img class="cThumbnail" src="../resources/image/class_ex1.jpg">
                <h4 class="cMTitle">펀치니들을 이용한 티프팅 소품 제작법 </h4>
                <p class="cPrice">50,000원</p>
            </div>
            <div class="cItem">
                <img class="cThumbnail" src="../resources/image/class_ex2.JPG">
                <h4 class="cMTitle">펀치니들을 이용한 티프팅 소품 제작법 </h4>
                <p class="cPrice">50,000원</p>
            </div>
            <div class="cItem">
                <img class="cThumbnail" src="../resources/image/class_ex1.jpg">
                <h4 class="cMTitle">펀치니들을 이용한 티프팅 소품 제작법 </h4>
                <p class="cPrice">50,000원</p>
            </div>
            <div class="cItem">
                <img class="cThumbnail" src="../resources/image/class_ex2.JPG">
                <h4 class="cMTitle">펀치니들을 이용한 티프팅 소품 제작법 </h4>
                <p class="cPrice">50,000원</p>
            </div>
            <div class="cItem">
                <img class="cThumbnail" src="../resources/image/class_ex1.jpg">
                <h4 class="cMTitle">펀치니들을 이용한 티프팅 소품 제작법 </h4>
                <p class="cPrice">50,000원</p>
            </div>
            <div class="cItem">
                <img class="cThumbnail" src="../resources/image/class_ex2.JPG">
                <h4 class="cMTitle">펀치니들을 이용한 티프팅 소품 제작법 </h4>
                <p class="cPrice">50,000원</p>
            </div>
            <div class="cItem">
                <img class="cThumbnail" src="../resources/image/class_ex1.jpg">
                <h4 class="cMTitle">펀치니들을 이용한 티프팅 소품 제작법 </h4>
                <p class="cPrice">50,000원</p>
            </div>
        </div>

        <div class="wrapper5">
            <a class="paging" href="#"><img width="18px" src="../resources/icon/previous.png"></a>
                <a class="paging" href="#"><img width="20px" src="../resources/icon/circle_sky.png"></a>
                <a class="paging" href="#"><img width="20px" src="../resources/icon/circle_beige.png"></a>
                <a class="paging" href="#"><img width="20px" src="../resources/icon/circle_beige.png"></a>
                <a class="paging" href="#"><img width="20px" src="../resources/icon/circle_beige.png"></a>
                <a class="paging" href="#"><img width="20px" src="../resources/icon/circle_beige.png"></a>
            <a class="paging" href="#"><img width="18px" src="../resources/icon/next.png"></a>
        </div>


    </div>



	<!-- footer -->
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	
</body>
</html>