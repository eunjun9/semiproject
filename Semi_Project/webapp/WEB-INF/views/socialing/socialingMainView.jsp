<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소셜링</title>

<!-- 외부 스타일 시트 -->
<link href="${ contextPath }/resources/css/socialing/socialing_main.css?3" rel="stylesheet">

<!-- 글꼴 (Noto Sans) -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<!-- Slide -->
<link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

</head>
<body>
	<!--header-->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>

    <!-- body -->
    <div class="socialing body">
        <div class="body-inner">
            <div class="s-title">
                <p id="main-title">소셜링</p>
                <h3 id="sub-title">언제 어디서나 일상을 더 다채롭게</h3>
            </div>
            <hr>
            <article>
                <h3 id="soon-title">시작 임박 소셜링</h3>
                <div class="slide">
                    <div class="swiper mySwiper">
                        <div class="swiper-wrapper">
                        <!-- 현재날짜 기준 모임날짜 2일 이내로 남은 소셜링 글 목록 출력 -->
                        <c:forEach var="ss" items="${ soonSocialingList }">
	                        <div class="swiper-slide">
	                            <div id="thumbox">
	                                <img id="s-thumbnail2" onclick="detailView(${ ss.nNum })" 
	                                src="${ contextPath }${ ss.photoList.get(0).route }${ ss.photoList.get(0).changeName }"><br>
	                            </div>
	                            <a href="${ contextPath }/socialing/detail?nNum=${ ss.nNum }">
	                                <div id="titlebox">
	                                    <p id="s-thumtitle">${ ss.nTitle }</p><br>
	                                    <!-- 오프라인일 경우 상세주소, 온라인일 경우 기본 주소 출력 -->
		                                <c:choose>
											<c:when test='${ ss.splace.contains("|") }'>
												<h5 id="s-thumsub">${ ss.splace.split("\\|")[1] }
											</c:when>
											<c:otherwise>
												<h5 id="s-thumsub">${ ss.splace }
											</c:otherwise>
										</c:choose>
		                                <fmt:formatDate value="${ ss.sdate }" type="date" pattern="M.dd(E)"/>
		                                <fmt:parseDate value="${ ss.stime }" var="stime2" pattern="HH:mm" scope="page"/>
										<fmt:formatDate value="${ stime2 }" type="time" pattern="a h:mm"/></h5>
	                                    <a href="#"></a>
	                                </div>
	                            </a>
	                        </div>
                        </c:forEach>
                        </div> 
                    </div> 
                </div>

                <div class="button1">
                    <div class="button-prev">
                    <img width="30px" src="${ contextPath }/resources/images/eunjung/prev_b.png"></div>
                </div>
                <div class="button2">
                    <div class="button-next">
                    <img width="30px" src="${ contextPath }/resources/images/eunjung/next_b.png"></div>
                </div>
            </article>
            <article>
                <h3 id="all-title">소셜링 전체 보기</h3>
                <div id="filterbox">
                    <form name="filter">
                        <div id="search">
                            <img id="searchIcon" src="${ contextPath }/resources/images/eunjung/search.png">
                            <input type="search" name="keyword" size="31" maxlength="20" placeholder="검색할 키워드를 입력해주세요"
                            value="${ param.keyword }"><br><br>
                        </div>
                        
                        <label id="flabel">지역</label>
                        <select name="local">
                        	<option selected>지역 선택</option>
                            <option value="서울" <c:if test="${ param.local == '서울' }">selected</c:if>>서울</option>
                            <option value="부산" <c:if test="${ param.local == '부산' }">selected</c:if>>부산</option>
                            <option value="대구" <c:if test="${ param.local == '대구' }">selected</c:if>>대구</option>
                            <option value="인천" <c:if test="${ param.local == '인천' }">selected</c:if>>인천</option>
                            <option value="광주" <c:if test="${ param.local == '광주' }">selected</c:if>>광주</option>
                            <option value="대전" <c:if test="${ param.local == '대전' }">selected</c:if>>대전</option>
                            <option value="울산" <c:if test="${ param.local == '울산' }">selected</c:if>>울산</option>
                            <option value="세종" <c:if test="${ param.local == '세종' }">selected</c:if>>세종</option>
                            <option value="경기" <c:if test="${ param.local == '경기' }">selected</c:if>>경기</option>
                            <option value="강원" <c:if test="${ param.local == '강원' }">selected</c:if>>강원</option>
                            <option value="충북" <c:if test="${ param.local == '충북' }">selected</c:if>>충북</option>
                            <option value="충남" <c:if test="${ param.local == '충남' }">selected</c:if>>충남</option>
                            <option value="전북" <c:if test="${ param.local == '전북' }">selected</c:if>>전북</option>
                            <option value="전남" <c:if test="${ param.local == '전남' }">selected</c:if>>전남</option>
                            <option value="경북" <c:if test="${ param.local == '경북' }">selected</c:if>>경북</option>
                            <option value="경남" <c:if test="${ param.local == '경남' }">selected</c:if>>경남</option>
                            <option value="제주" <c:if test="${ param.local == '제주' }">selected</c:if>>제주</option>
                        </select>
                        
                        <br><br>
                        <!-- <label id="flabel">날짜</label>
                        <input type="date" name="dateIn" value="${ param.dateIn }"><br><br> -->
                        <label id="flabel">온오프라인</label>
                        <input type="radio" id="offline" name="onoff" value="OFF" <c:if test="${ param.onoff == 'OFF' }">checked</c:if>>
                        <label for="offline">오프라인</label>&nbsp;
                        <input type="radio" id="online" name="onoff" value="ON" <c:if test="${ param.onoff == 'ON' }">checked</c:if>>
                        <label for="online">온라인</label>
                        
                        <input type="reset" value="조건 초기화" id="s-reset">
                        <input type="submit" value="선택항목 검색" id="s-submit">
                </div>
                <div id="lineupbox">
                    <select name="lineup">
                    	<option selected>정렬 방식</option>
                        <option value="rec" <c:if test="${ param.lineup == 'rec' }">selected</c:if>>최신순</option>
                        <option value="pop" <c:if test="${ param.lineup == 'pop' }">selected</c:if>>인기순</option>
                    </select>
                </div>
                </form>
                
                <!-- 글 목록 출력 -->
                <div class="s-container2">
                	<c:forEach var="s" items="${ socialingList }">
                    <div id="s-list2">
                        <div id="thumbox">
                            <img id="s-thumbnail" onclick="detailView(${ s.nNum })" 
                            src="${ contextPath }${ s.photoList.get(0).route }${ s.photoList.get(0).changeName }"><br>
                        </div>
                        <a href="${ contextPath }/socialing/detail?nNum=${ s.nNum }">
                            <div id="titlebox">
                                <p id="s-thumtitle">${ s.nTitle }</p><br>
                                <!-- 오프라인일 경우 상세주소, 온라인일 경우 기본 주소 출력 -->
                                <c:choose>
									<c:when test='${ s.splace.contains("|") }'>
										<h5 id="s-thumsub">${ s.splace.split("\\|")[1] }
									</c:when>
									<c:otherwise>
										<h5 id="s-thumsub">${ s.splace }
									</c:otherwise>
								</c:choose>
                                <fmt:formatDate value="${ s.sdate }" type="date" pattern="M.dd(E)"/>
                                <fmt:parseDate value="${ s.stime }" var="stime2" pattern="HH:mm" scope="page"/>
								<fmt:formatDate value="${ stime2 }" type="time" pattern="a h:mm"/></h5>
                                <a href="#"><!-- <img id="profile" src="${ contextPath }/resources/images/eunjung/profile.png"> --></a>
                            </div>
                        </a>
                    </div>
                	</c:forEach>
                </div>
                
                <c:choose>
	                 <c:when test="${ !param.keyword }">
	                	<c:set var="search1" value="&keyword=${ param.keyword }"/>
	                 </c:when>
	                 <c:when test="${ !param.keyword && !empty param.local }">
	                	<c:set var="search2" value="&local=${ param.local }"/>
	                 </c:when>
	                 <c:when test="${ !param.dateIn }">
	                	<c:set var="search3" value="&dateIn=${ param.dateIn }"/>
	                 </c:when>
	                 <c:when test="${ !param.keyword && !empty param.onoff }">
	                	<c:set var="search4" value="&onoff=${ param.onoff }"/>
	                 </c:when>
	                <c:when test="${ !param.keyword && !empty param.lineup }">
	                	<c:set var="search5" value="&lineup=${ param.lineup }"/>
	                </c:when>
                </c:choose>

				<!-- 페이지 로직 (필터링 조건문 추후에 작성) -->
                <div class="pagebox">
                
                	<!-- (<<) 제일 첫 페이지로 이동 -->
                	<a class="paging" href="${ contextPath }/socialing/main?page=1${search1}${search2}${search3}${search4}${search5}">
                	<img width="16px" src="${ contextPath }/resources/images/eunjung/previous.png">
		            <img width="16px" src="${ contextPath }/resources/images/eunjung/previous.png"></a>
		            
		            <!--  (<) 이전 페이지  : 현재 페이지 - 1이니까 -->
		            <c:choose>
		             	<c:when test="${ pi.page > 1 }"> <!--  현재 페이지가 1보다 클 때는 이동하고  -->
		             		<a class="paging" href="${ contextPath }/socialing/main?page=${ pi.page - 1 }${search1}${search2}${search3}${search4}${search5}"><img width="18px" src="${ contextPath }/resources/images/eunjung/previous.png"></a>
		             	</c:when>
		             	<c:otherwise> <!-- 1이면 현재 페이지에 머뭄 -->
		             		<a class="paging" href="#"><img width="18px" src="${ contextPath }/resources/images/eunjung/previous.png"></a>
		             	</c:otherwise>
		            </c:choose>
		            
		            <!-- 최대 5개의 페이지 목록  생성 -->
		            <c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
		             	<li>
					 	<c:choose>
					 		<c:when test="${ p eq pi.page }"> <!-- p와 현재 요청 페이지가 같다면 = 현재 페이지 임을 나타낼 수 있는 색 변경-->
					 			<a href="#" class="paging"><img width="20px" src="${ contextPath }/resources/images/eunjung/circle_sky.png"></a>
					 		</c:when>
					 		<c:otherwise> <!-- 현재 페이지 외에는 페이지 목록 숫자만 출력 -->
					 			<a class="paging" href="${ contextPath }/socialing/main?page=${ p }${search1}${search2}${search3}${search4}${search5}"><img width="20px" src="${ contextPath }/resources/images/eunjung/circle_beige.png"></a>
					 		</c:otherwise>
					 	</c:choose>
					 	</li>
		            </c:forEach>
		            
		            <!-- (>) 다음 페이지 : 제일 끝 페이지에서 버튼 누를 것을 고려하여 조건문 사용 -->
		            <c:choose>
		            	<c:when test="${ pi.page < pi.maxPage }"> <!-- 현재 페이지가 최대 페이지보다 아래일 때 이동 -->
		            		<a class="paging" href="${ contextPath }/socialing/main?page=${ pi.page + 1 }${search1}${search2}${search3}${search4}${search5}"><img width="18px" src="${ contextPath }/resources/images/eunjung/next.png"></a>
		            	</c:when>
		            	<c:otherwise>
		            		<a class="paging" href="#"><img width="18px" src="${ contextPath }/resources/images/eunjung/next.png"></a>
		            	</c:otherwise>
		            </c:choose>
	                
	                <!-- (>>) 제일 끝 페이지로 이동 -->
		            <a class="paging" href="${ contextPath }/socialing/main?page=${ pi.maxPage }${search1}${search2}${search3}${search4}${search5}">
		            <img width="16px" src="${ contextPath }/resources/images/eunjung/next.png">
		            <img width="16px" src="${ contextPath }/resources/images/eunjung/next.png"></a>
                </div>
                
                <c:if test="${ !empty loginUser }">
	                <div id="writebox">
	                    <button id="writing" onclick="location.href='${ contextPath }/socialing/form'">글 쓰기</button>
	                </div>
                </c:if>
            </article>
        </div>
    </div>
        
    <!-- Initialize Swiper -->
    <script>
        var swiper = new Swiper(".mySwiper", {
            slidesPerView: 3,
            spaceBetween: 30,

            loop: true,
            
            // Navigation arrows
            navigation: {
                nextEl: '.button-next',
                prevEl: '.button-prev',
            },
        });
    </script>
    
    <script>
    	$(function(){
    		// 정렬 콤보박스 변경 시 글 목록 바로 정렬
    		$("select[name=lineup]").change(listChange);
    	});
    	
    	function listChange() {
            if($(this).val() == 'rec') {
    			$("#s-submit").click();
            } else if($(this).val() == 'pop') {
            	$("#s-submit").click();
            }
    	}
    </script>
    
    <!-- 로그인 여부에 따른 스크립트 -->
    <c:choose>
		<c:when test="${ !empty loginUser }">
			<script>
				function detailView(nNum){
					location.href = '${contextPath}/socialing/detail?nNum=' + nNum;
				}
			</script>
		</c:when>
		<c:otherwise>
			<script>
				function detailView(nNum){
					alert('로그인 후 이용 가능합니다.');
					location.href = '${contextPath}/login';
				}			
			</script>
		</c:otherwise>
	</c:choose>

    <!--footer-->
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>