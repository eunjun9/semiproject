<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클래스_메인</title>

	<!--외부 스타일 시트-->
    <link href="${ contextPath }/resources/css/lesson/lesson_main.css" rel="stylesheet">

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
                    <li><img src="${ contextPath }/resources/images/yewon/painting.jpg" width="340px" height="380px"></li>
                    <li><img src="${ contextPath }/resources/images/yewon/dance.jpg" width="340px" height="380px"></li>
                    <li><img src="${ contextPath }/resources/images/yewon/weaving.jpg" width="340px" height="380px"></li>
                    <li><img src="${ contextPath }/resources/images/yewon/baking.jpg" width="340px"  height="380px"></li>
                </ul>
            </div>
            <div class="filtering">
                <form method="get" action="${ contextPath }/lesson/main }">
                    <img id="search" width="20px" src="${ contextPath }/resources/images/yewon/search.png">
                    <input type="text" maxlength="25" size="40" placeholder="검색할 키워드를 입력해주세요" name="keyword" id="keyword" ><br>
                    
                    <label>가격</label>
                    <input id="price1" type="number" value="0" name="price1"><label> 원&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;  </label>
                    <input id="price2" type="number" value="50000" name="price2"><label> 원</label><br>

                    <!-- 조건문으로 설정하기 -->

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
        <!-- 게시글 반복문으로 삽입  -->
       <%--  <c:forEach var="" items="">
            <div class="cItem" >
            	<!-- a태그에 제목, 사진, 가격 넣어서 클릭 시 해당 페이지로 이동 nNum으로 구분  (아래 href 코드 수정 필요)-->
                <a href="${ contextPath }/lesson/detail?nNum=">
                    <img class="cThumbnail" src="">
                    <h4 class="cMTitle"></h4>
                    <p class="cPrice"></p>
                </a>
            </div>
        </c:forEach> --%>
        </div>

		<!-- 페이지 로직 (필터링 조건문 추후에 작성) -->
        <%-- <div class="wrapper5">
        	<!-- (<<) 제일 첫 페이지로 이동 -->
            <a class="paging" href="${ contextPath }/lesson/main?page=1"><img width="16px" src="resources/images/yewon/previous.png">
            <img width="16px" src="resources/images/yewon/previous.png"></a>
             
             <!--  (<) 이전 페이지  : 현재 페이지 - 1이니까 -->
             <c:choose>
             	<!--  현재 페이지가 1보다 클 때는 이동하고  -->
             	<c:when test="${ pi.page > 1 }">
             	<a class="paging" href="${ contextPath }/lesson/main?page=${ pi.page - 1}"><img width="18px" src="resources/images/previous.png"></a>
             	</c:when>
             	<!-- 1이면 현재 페이지에 머뭄 -->
             	<c:otherwise>
             	<a class="paging" href="#"><img width="18px" src="resources/images/previous.png"></a>
             	</c:otherwise>
             </c:choose>
                <a class="paging" href="#"><img width="20px" src="resources/images/yewon/circle_beige.png"></a>
                <a class="paging" href="#"><img width="20px" src="resources/images/yewon/circle_beige.png"></a>
                <a class="paging" href="#"><img width="20px" src="resources/images/yewon/circle_beige.png"></a>
                <a class="paging" href="#"><img width="20px" src="resources/images/yewon/circle_beige.png"></a>
                <a class="paging" href="#"><img width="20px" src="resources/images/yewon/circle_beige.png"></a>
            <!--  (>) 다음 페이지 -->
            <a class="paging" href="#"><img width="18px" src="resources/images/yewon/next.png"></a>
            <!-- (>>) 제일 끝 페이지로 이동 -->
            <a class="paging" href="${ contextPath }/lesson/list?page=${ pi.maxPage }"><img width="16px" src="resources/images/yewon/next.png">
            <img width="16px" src="resources/images/yewon/next.png"></a>
        </div>
 --%>


    </div>



	<!-- footer -->
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	
</body>
</html>