<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                        <!-- 반복문으로 현재 날짜(date) 기준 시작일(sdate) 2일 이내로 남은 소셜링 글 목록 출력 (최대 6개) -->
                        <div class="swiper-slide">
                            <div id="thumbox">
                                <img src="${ contextPath }/resources/images/eunjung/flower1.PNG"><br>
                                <img id="like2" src="${ contextPath }/resources/images/eunjung/heart_empty.png">
                            </div>
                            <a href="#">
                                <div id="titlebox">
                                    <p id="s-thumtitle">할로윈 같이 즐겨요</p><br>
                                    <h5 id="s-thumsub">이태원역 6호선 10.31(일) 오후 6:00</h5>
                                    <a href=""><img id="profile2" src="${ contextPath }/resources/images/eunjung/profile.png"></a>
                                </div>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <div id="thumbox">
                                <img src="${ contextPath }/resources/images/eunjung/flower1.PNG"><br>
                                <img id="like2" src="${ contextPath }/resources/images/eunjung/heart_empty.png">
                            </div>
                            <a href="#">
                                <div id="titlebox">
                                    <p id="s-thumtitle">아침에 공원에서 산책하실 분!</p><br>
                                    <h5 id="s-thumsub">평촌 중앙공원 10.20(수) 오전 9:00</h5>
                                    <a href=""><img id="profile2" src="${ contextPath }/resources/images/eunjung/profile.png"></a>
                                </div>
                            </a>
                        </div>
                        <div class="swiper-slide">
                            <div id="thumbox">
                                <img src="${ contextPath }/resources/images/eunjung/flower1.PNG"><br>
                                <img id="like2" src="${ contextPath }/resources/images/eunjung/heart_empty.png">
                            </div>
                            <a href="#">
                                <div id="titlebox">
                                    <p id="s-thumtitle">이터널스 같이 보러가요</p><br>
                                    <h5 id="s-thumsub">CGV 용산아이파크몰 11.20(토) 오...</h5>
                                    <a href=""><img id="profile2" src="${ contextPath }/resources/images/eunjung/profile.png"></a>
                                </div>
                            </a>
                        </div>
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
                    <form>
                        <div id="search">
                            <img id="searchIcon" src="<%= request.getContextPath() %>/resources/images/eunjung/search.png">
                            <input type="search" name="keyword" size="31" maxlength="20" placeholder="검색할 키워드를 입력해주세요"
                            value="${ param.keyword }"><br><br>
                        </div>
                        <label id="flabel">지역</label>
                        <select name="local">
                        	<option value="" selected>지역 선택</option>
                            <option value="seoul">서울</option>
                            <option value="busan">부산</option>
                            <option value="daegu">대구</option>
                            <option value="incheon">인천</option>
                            <option value="gwanju">광주</option>
                            <option value="daejeon">대전</option>
                            <option value="ulsan">울산</option>
                            <option value="sejong">세종</option>
                            <option value="gyeonggi">경기</option>
                            <option value="gangwon">강원</option>
                            <option value="chungbuk">충북</option>
                            <option value="chungnam">충남</option>
                            <option value="jeonbuk">전북</option>
                            <option value="jeonnam">전남</option>
                            <option value="gyeongbuk">경북</option>
                            <option value="gyeongnam">경남</option>
                            <option value="jeju">제주</option>
                        </select>
                        
                        <br><br>
                        <label id="flabel">날짜</label>
                        <input type="date" name="dateIn"><br><br>
                        <label id="flabel">온오프라인</label>
                        <input type="radio" id="offline" name="onoff" value="offline">
                        <label for="offline">오프라인</label>&nbsp;
                        <input type="radio" id="online" name="onoff" value="online">
                        <label for="online">온라인</label>
                        <input type="reset" value="조건 초기화" id="s-reset">
                        <input type="submit" value="선택항목 검색" id="s-submit">
                    </form>
                </div>
                <div id="lineupbox">
                    <select name="lineup">
                        <option value="">최신순</option> <!-- 작성일 순 -->
                        <option value="">인기순</option> <!-- 참여 인원 순 -->
                    </select>
                </div>
                
                <!-- 
				 	String[] place;
				 	if(socialingList.getSplace() != null) {
				 		place = socialingList.getSplace().split("\\|");
				 	} else {
				 		place = new String[] {"", ""};
				 	}
				 -->
                
                <!-- 글 목록 출력 -->
                <div class="s-container2">
                	<c:forEach var="s" items="${ socialingList }">
                    <div id="s-list2">
                        <div id="thumbox">
                            <img id="s-thumbnail" onclick="detailView(${ s.nNum })" 
                            src="${ contextPath }${ s.photoList.get(0).route }${ s.photoList.get(0).changeName }"><br>
                            <!-- empty : 클릭 시 꽉찬 하트 아이콘으로 변경 + 관심 소셜링에 추가, full : 클릭 시 빈 하트 아이콘으로 변경 + 관심 소셜링에서 제거 -->
                            <!-- 관심 소셜링에 sNum 포함 여부에 따라 src 변경(if문) -->
                            <img id="like" src="<%= request.getContextPath() %>/resources/images/eunjung/heart_empty.png"
                            onclick="likeSocialing(${ s.nNum })">
                        </div>
                        <a href="${ contextPath }/socialing/detail?nNum=${ s.nNum }">
                            <div id="titlebox">
                                <p id="s-thumtitle">${ s.nTitle }</p><br>
                                <h5 id="s-thumsub">${ s.splace.split("\\|")[1] } 
                                <fmt:formatDate value="${ s.sdate }" type="both" pattern="M.dd(E) a h:mm"/></h5>
                                <a href="#"><img id="profile" src="<%= request.getContextPath() %>/resources/images/eunjung/profile.png"></a>
                            </div>
                        </a>
                    </div>
                	</c:forEach>
                </div>

				<!-- 페이지 로직 (필터링 조건문 추후에 작성) -->
                <div class="pagebox">
                
                	<!-- (<<) 제일 첫 페이지로 이동 -->
                	<a class="paging" href="${ contextPath }/socialing/main?page=1">
                	<img width="16px" src="${ contextPath }/resources/images/eunjung/previous.png">
		            <img width="16px" src="${ contextPath }/resources/images/eunjung/previous.png"></a>
		            
		            <!--  (<) 이전 페이지  : 현재 페이지 - 1이니까 -->
		            <c:choose>
		             	<c:when test="${ pi.page > 1 }"> <!--  현재 페이지가 1보다 클 때는 이동하고  -->
		             		<a class="paging" href="${ contextPath }/socialing/main?page=${ pi.page - 1 }"><img width="18px" src="${ contextPath }/resources/images/eunjung/previous.png"></a>
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
					 			<a class="paging" href="${ contextPath }/socialing/main?page=${ p }"><img width="20px" src="${ contextPath }/resources/images/eunjung/circle_beige.png"></a>
					 		</c:otherwise>
					 	</c:choose>
					 	</li>
		            </c:forEach>
		            
		            <!-- (>) 다음 페이지 : 제일 끝 페이지에서 버튼 누를 것을 고려하여 조건문 사용 -->
		            <c:choose>
		            	<c:when test="${ pi.page < pi.maxPage }"> <!-- 현재 페이지가 최대 페이지보다 아래일 때 이동 -->
		            		<a class="paging" href="${ contextPath }/socialing/main?page=${ pi.page + 1 }"><img width="18px" src="${ contextPath }/resources/images/eunjung/next.png"></a>
		            	</c:when>
		            	<c:otherwise>
		            		<a class="paging" href="#"><img width="18px" src="${ contextPath }/resources/images/eunjung/next.png"></a>
		            	</c:otherwise>
		            </c:choose>
	                
	                <!-- (>>) 제일 끝 페이지로 이동 -->
		            <a class="paging" href="${ contextPath }/socialing/main?page=${ pi.maxPage }">
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
    
    <!-- 로그인 여부에 따른 스크립트 -->
    <c:choose>
		<c:when test="${ !empty loginUser }">
			<script>
				function detailView(nNum){
					location.href = '${contextPath}/socialing/detail?nNum=' + nNum;
				}
				
				// 관심 소셜링에 추가 (프로필정보에 관심 소셜링 컬럼 추가(게시글번호 - 구분자 이용해서 여러 글 추가되게))
				function likeSocialing(nNum) {
					
					let like = document.querySelectorAll('#like');
			        let like2 = document.querySelectorAll('#like2');
			        
			        for(let i = 0; i < like.length; i++) {
			            like[i].onclick = function() {
			                if(like[i].src.indexOf('_empty') == -1) {
			                    like[i].src = like[i].src.replace('.png', '_empty.png');
			                } else {
			                	alert('관심 소셜링에 추가 되었습니다.');
			                    like[i].src = like[i].src.replace('_empty.png', '.png');
			                }
			            }

			            like2[i].onclick = function() {
			                if(like2[i].src.indexOf('_empty') == -1) {
			                    like2[i].src = like2[i].src.replace('.png', '_empty.png');
			                } else {
			                	alert('관심 소셜링에 추가 되었습니다.');
			                    like2[i].src = like2[i].src.replace('_empty.png', '.png');
			                }
			            }
			        }
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