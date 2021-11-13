<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클래스_메인</title>

	<!--외부 스타일 시트-->
    <link href="${ contextPath }/resources/css/lesson/lesson_main.css?6" rel="stylesheet">

    <!-- font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500&display=swap" rel="stylesheet">

    <!-- JQuery-->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

    <!--슬라이드-->
    <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

	<!-- 클래스 -->
	<div class="class_wrapper">
    <div class="class_main">
        <div class="wrapper1">
            <h1>클래스</h1>
            <p>새로운 나, 24시간이면 충분해요</p>
        </div>

	<article>
        <div class="wrapper2">
            <div class="slide">
                <ul>
                    <li><img src="${ contextPath }/resources/images/yewon/painting.jpg" width="380px" height="400px"></li>
                    <li><img src="${ contextPath }/resources/images/yewon/dance.jpg" width="380px" height="400px"></li>
                    <li><img src="${ contextPath }/resources/images/yewon/weaving.jpg" width="380px" height="400px"></li>
                    <li><img src="${ contextPath }/resources/images/yewon/baking.jpg" width="380px"  height="400px"></li>
                </ul>
            </div>
        
            <div class="filtering">
                <form method="get" action="${ contextPath }/lesson/main">
                
                    <img id="search" width="20px" src="${ contextPath }/resources/images/yewon/search.png">
                    <input type="text" maxlength="25" size="40" placeholder="검색할 키워드를 입력해주세요" name="keyword" id="keyword" value="${ param.keyword }" ><br>
                    
                    <label>가격</label>
                    <input id="price1" type="text" value="${ param.price1 }" name="price1" ><label> 원&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;  </label>
                    <input id="price2" type="text" value="${ param.price2 }" name="price2"><label> 원</label><br>

                    <!-- 조건문으로 설정하기 -->
                    <label>카테고리</label>
                    <select id="bigC" name="bigC" required>
                        <option value="big" selected disabled>대분류 선택</option>
                        <option value="art" id="art" <c:if test="${ param.bigC == 'art' }">selected</c:if>>예술</option>
                        <option value="food" id="food" <c:if test="${ param.bigC == 'food' }">selected</c:if>>음식</option>
                        <option value="sport" id="sport" <c:if test="${ param.bigC == 'sport' }">selected</c:if>>운동</option>
                    </select>
                    
                     <select name="smallC" id="smallC" required>
                        <option id="small" selected disabled>소분류 선택</option>
                        <option value="draw" class="artS" <c:if test="${ param.smallC == 'draw' }">selected</c:if>>드로잉</option>
                        <option value="instrument" class="artS" <c:if test="${ param.smallC == 'instrument' }">selected</c:if>>악기</option>
                        <option value="illust" class="artS" <c:if test="${ param.smallC == 'illust' }">selected</c:if>>일러스트</option>
                        <option value="bake" class="foodS" <c:if test="${ param.smallC == 'bake' }">selected</c:if>>베이킹</option>
                        <option value="ws" class="foodS" <c:if test="${ param.smallC == 'ws' }">selected</c:if>>양식</option>
                        <option value="jp" class="foodS" <c:if test="${ param.smallC == 'jp' }">selected</c:if>>일식</option>
                        <option value="ch" class="foodS" <c:if test="${ param.smallC == 'ch' }">selected</c:if>>중식</option>
                        <option value="ko" class="foodS" <c:if test="${ param.smallC == 'ko' }">selected</c:if>>한식</option>
                        <option value="musc" class="sportS" <c:if test="${ param.smallC == 'musc' }">selected</c:if>>근력운동</option>
                        <option value="yoga" class="sportS" <c:if test="${ param.smallC == 'yoga' }">selected</c:if>>요가</option>
                        <option value="fila" class="sportS" <c:if test="${ param.smallC == 'fila' }">selected</c:if>>필라테스</option>
                    </select><br>
                    
                    <script>
                      $('#small').show();
           			  $('.artS').hide();
           		 	  $('.foodS').hide();
           		 	  $('.sportS').hide();
                     $(document).on('change', '#bigC', changeoption);
                     
                     function changeoption(){
                    	 if($(this).val() == 'big'){
                    		 $('#small').show();
                    		 $('.artS').hide();
                    		 $('.foodS').hide();
                    		 $('.sportS').hide();
                    	 } else if($(this).val() == 'art'){
                    		 $('.artS').show();
                    		 $('.foodS').hide();
                    		 $('.sportS').hide();
                    		 $('#small').hide();
                    	 } else if($(this).val() == 'food'){
                    		 $('.foodS').show();
                    		 $('.artS').hide();
                    		 $('.sportS').hide();
                    		 $('#small').hide();
                    	 } else if($(this).val() == 'sport'){
                    		 $('.sportS').show();
                    		 $('.artS').hide();
                    		 $('.foodS').hide();
                    		 $('#small').hide();
                    	 } 
                     }
                    </script>

                    <label>클래스 타입</label>
                    <input type="checkbox" value="oneday" name="oneday" <c:if test="${ param.oneday == '원데이' }">checked</c:if>><label class="ckboxlabel">원데이 클래스</label>
                    <input type="checkbox" value="vod" name="vod" <c:if test="${ param.vod == 'vod' }">checked</c:if>><label class="ckboxlabel">VOD 클래스</label> <br>

                    <button type="reset" name="reSel" onclick="locatation.href='${contextPath}/lesson/main'">조건 초기화</button>
                    <button type="submit" name="selEnd">선택 검색</button>
			        
			       <%--  <div class="wrapper3">
			        <select name="classSort">
			            <option disabled selected>정렬 방식</option>
			            <option value="pop" <c:if test="${ param.classSort == 'pop' }">selected</c:if>>인기순</option>
			            <option value="rec" <c:if test="${ param.classSort == 'rec' }">selected</c:if>>최신순</option>
			        </select><br>
			        </div> --%>
                </form>
            </div>
        </div>
        
        <!-- <script>
        	$(function(){
        		$("select[name=classSort]").change(sortList);
        	});
        	
        	function sortList(){
        		if($(this).val() == 'pop'){
        			$("button[name=selEnd]").click();
        		} else if($(this).val() == 'rec'){
        			$("button[name=selEnd]").click();
        		}
        	}
        </script> -->
        
        
        <div class="wrapper4">
        <!-- 게시글 반복문으로 삽입  -->
     	<c:forEach var="lesson" items="${ lessonList }">
            <div class="cItem" onclick="detailView(${lesson.nNum})">
            	<!-- a태그에 제목, 사진, 가격 넣어서 클릭 시 해당 페이지로 이동 nNum으로 구분  (아래 href 코드 수정 필요)-->
                    <img class="cThumbnail" src="${ contextPath }${ lesson.photoList.get(0).route}${ lesson.photoList.get(0).changeName }">
                    <h4 class="cMTitle">${ lesson.nTitle }</h4>
                    <p class="cPrice"><fmt:formatNumber value="${ lesson.cPrice }" type="currency" currencySymbol=""/>원</p>
                    <%-- <P>${ lesson.nCount }번</P> --%>
               <%--  <a onclick="detailView(${lesson.nNum})">
                </a> --%>
            </div>
        </c:forEach>
        </div>
        
        <c:if test="${ loginUser.userGrade == '강사' }">
        <button id="classBtn" onclick="location.href='${ contextPath }/lesson/insert'">클래스 등록</button>
        </c:if>
        
         <!-- 필터가 있을 때 페이징에 사용할 변수 정의 -->			
                <c:choose>
	                <c:when test="${ !empty param.keyword }">
	                	<c:set var="f1" value="&keyword=${ param.keyword }"/>
	                 </c:when>
	                 <c:when test="${ !empty param.price1 }">
	                	<c:set var="f2" value="&price1=${ param.price1 }"/>
	                 </c:when>
	                 <c:when test="${ !empty param.price2 }">
	                	<c:set var="f3" value="&price2=${ param.price2 }"/>
	                 </c:when>
	                 <c:when test="${ !empty param.bigC }">
	                	<c:set var="f4" value="&bigC=${ param.bigC }"/>
	                 </c:when>
	                <c:when test="${ !empty param.smallC }">
	                	<c:set var="f5" value="&smallC=${ param.smallC }"/>
	                </c:when>
	                <c:when test="${ !empty param.oneday }">
	                	<c:set var="f6" value="&oneday=${ param.oneday }"/>
	                </c:when>
	                <c:when test="${ !empty param.vod }">
	                	<c:set var="f7" value="&vod=${ param.vod }"/>
	                </c:when>
                </c:choose>
        
		<!-- 페이지 로직 (필터링 조건문 추후에 작성) -->
        <div class="wrapper5">
        	<!-- (<<) 제일 첫 페이지로 이동 -->
            <a class="paging" href="${ contextPath }/lesson/main?page=1${ f1 }${ f2 }${ f3 }${ f4 }${ f5 }${ f6 }${ f7 }"><img width="16px" src="${ contextPath }/resources/images/yewon/previous.png">
            <img width="16px" src="${ contextPath }/resources/images/yewon/previous.png"></a>
             
             <!--  (<) 이전 페이지  : 현재 페이지 - 1이니까 -->	
             <c:choose>
             	<c:when test="${ pi.page > 1 }"> <!--  현재 페이지가 1보다 클 때는 이동하고  -->
             	<a class="paging" href="${ contextPath }/lesson/main?page=${ pi.page - 1}${ f1 }${ f2 }${ f3 }${ f4 }${ f5 }${ f6 }${ f7 }"><img width="18px" src="${ contextPath }/resources/images/yewon/previous.png"></a>
             	</c:when>
             	<c:otherwise> <!-- 1이면 현재 페이지에 머뭄 -->
             	<a class="paging" href="#"><img width="18px" src="${ contextPath }/resources/images/yewon/previous.png"></a>
             	</c:otherwise>
             </c:choose>
             	<!-- 최대 5개의 페이지 목록  생성 -->
             	<c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
             	<li>
			 	<c:choose>
			 		<c:when test="${ p eq pi.page }"> <!-- p와 현재 요청 페이지가 같다면 = 현재 페이지 임을 나타낼 수 있는 색 변경-->
			 		<a href="#" class="paging"><img width="20px" src="${ contextPath }/resources/images/yewon/circle_sky.png"></a>
			 		</c:when>
			 		<c:otherwise> <!-- 현재 페이지 외에는 페이지 목록 숫자만 출력 -->
			 		<a class="paging" href="${ contextPath }/lesson/main?page=${ p }${ f1 }${ f2 }${ f3 }${ f4 }${ f5 }${ f6 }${ f7 }"><img width="20px" src="${ contextPath }/resources/images/yewon/circle_beige.png"></a>
			 		</c:otherwise>
			 	</c:choose>
			 	</li>
             	</c:forEach>
            
            <!--  (>) 다음 페이지 : 제일 끝 페이지에서 버튼 누를 것을 고려하여 조건문 사용 -->
            <c:choose>
            	<c:when test="${ pi.page < pi.maxPage }"> <!-- 현재 페이지가 최대 페이지보다 아래일 때 이동 -->
            	 <a class="paging" href="${ contextPath }/lesson/main?page=${ pi.page + 1 }${ f1 }${ f2 }${ f3 }${ f4 }${ f5 }${ f6 }${ f7 }"><img width="18px" src="${ contextPath }/resources/images/yewon/next.png"></a>
            	</c:when>
            	<c:otherwise>
            	<a class="paging" href="#"><img width="18px" src="${ contextPath }/resources/images/yewon/next.png"></a>
            	</c:otherwise>
            </c:choose>
            
            <!-- (>>) 제일 끝 페이지로 이동 -->
            <a class="paging" href="${ contextPath }/lesson/main?page=${ pi.maxPage }${ f1 }${ f2 }${ f3 }${ f4 }${ f5 }${ f6 }${ f7 }"><img width="16px" src="${ contextPath }/resources/images/yewon/next.png">
            <img width="16px" src="${ contextPath }/resources/images/yewon/next.png"></a>
        </div>
</article>
    </div>
</div>

	<!-- footer -->
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	

	<!-- 클래스 상세 페이지 스크립트 -->	
	<c:choose>
		<c:when test="${ !empty loginUser }"> <!-- 로그인 했을 때 볼 수 있게 -->
			<script>
				function detailView(nNum){
					location.href = '${contextPath}/lesson/detail?nNum=' + nNum;
				}
			</script>
		</c:when>
		<c:otherwise>	<!-- 로그인 안 했을 때 -->
			<script>
				function detailView(){
					alert('로그인 후 이용 가능합니다. 로그인 해주세요.');
					location.href='${ contextPath }/login';
				}			
			</script>
		</c:otherwise>
	</c:choose>
	
	
</body>
</html>