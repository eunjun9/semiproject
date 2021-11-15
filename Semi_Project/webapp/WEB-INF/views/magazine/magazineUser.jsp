<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Main</title>

<!-- 외부 스타일 시트 -->
<link
	href="<%=request.getContextPath()%>/resources/css/magazine/magazineUser.css"
	rel="stylesheet">


<!-- favicon (Real Favicon Generator)-->
<link rel="icon" type="image/x-icon"
	href="resources/image/khfavicon.ico">

<!-- 글꼴 -->
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
<!--font-family: 'Noto Sans KR', sans-serif;-->

<!-- JQuery-->
<script src="../js/jquery-3.6.0.min.js"></script>

<!--슬라이드-->
<link rel="stylesheet"
	href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<style>
.swiper {
	width: 800px;
	height: 250px;
}
</style>


</head>

<body>
	<!--header-->

	<%@ include file="/WEB-INF/views/common/header.jsp"%>


	<div class="body-super">
		<div class="board1">
			<div class=body-inner1>
				<div class="title-big">
					<div class="title">우리들의 이야기</div>
					<div class="word">다른 이들과 나누는 우리 이야기</div><c:if test="${ !empty loginUser }">
					<div class="view1">
						<a href="<%=request.getContextPath()%>/user/insert">글쓰기</a>
					</div>
				</c:if>
			</div>
			</div>

				
	

		<!--body-->
						<div class="list_div">
							<ul class="board_list">
								<c:forEach var="magazine" items="${ userList }">
								<div class="box">
									<div class="pics" onclick="detailView(${ magazine.nNum })">
										<img src="${ contextPath }${ magazine.photoList.get(0).route }${ magazine.photoList.get(0).changeName }">
											<p class="category">[${ magazine.nType }]</p>
											<p class="list-title">${ magazine.nTitle }</p><br> 
								   </div>
									<div class="writer-par">
									<c:choose>
							<c:when test="${ loginUser.userId == magazine.userId}">
							<!-- 이 때 아이디값 넘어감 -->
							<a href="${contextPath}/myfeed">${ magazine.userId }</a>
							
							</c:when>
							<c:otherwise>
							<!-- 이 때 아이디값 넘어감 -->
							<a href="${contextPath}/others/feed?userId=${magazine.userId}">${ magazine.userId }</a>
							</c:otherwise>
							</c:choose>
									</div>
								</div>
								</c:forEach>
							</ul>
						</div>

					</div>
				</div>






	<!-- 페이지 로직 (필터링 조건문 추후에 작성) -->
                <div class="pagebox">
                
                	<!-- (<<) 제일 첫 페이지로 이동 -->
                	<a class="paging" href="${ contextPath }/user/list?page=1${search1}${search2}${search3}${search4}${search5}">
                	<img width="16px" src="${ contextPath }/resources/images/eunjung/previous.png">
		            <img width="16px" src="${ contextPath }/resources/images/eunjung/previous.png"></a>
		            
		            <!--  (<) 이전 페이지  : 현재 페이지 - 1이니까 -->
		            <c:choose>
		             	<c:when test="${ pi.page > 1 }"> <!--  현재 페이지가 1보다 클 때는 이동하고  -->
		             		<a class="paging" href="${ contextPath }/user/list?page=${ pi.page - 1 }${search1}${search2}${search3}${search4}${search5}"><img width="18px" src="${ contextPath }/resources/images/eunjung/previous.png"></a>
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
					 			<a class="paging" href="${ contextPath }/user/list?page=${ p }${search1}${search2}${search3}${search4}${search5}"><img width="20px" src="${ contextPath }/resources/images/eunjung/circle_beige.png"></a>
					 		</c:otherwise>
					 	</c:choose>
					 	</li>
		            </c:forEach>
		            
		            <!-- (>) 다음 페이지 : 제일 끝 페이지에서 버튼 누를 것을 고려하여 조건문 사용 -->
		            <c:choose>
		            	<c:when test="${ pi.page < pi.maxPage }"> <!-- 현재 페이지가 최대 페이지보다 아래일 때 이동 -->
		            		<a class="paging" href="${ contextPath }/user/list?page=${ pi.page + 1 }${search1}${search2}${search3}${search4}${search5}"><img width="18px" src="${ contextPath }/resources/images/eunjung/next.png"></a>
		            	</c:when>
		            	<c:otherwise>
		            		<a class="paging" href="#"><img width="18px" src="${ contextPath }/resources/images/eunjung/next.png"></a>
		            	</c:otherwise>
		            </c:choose>
	                
	                <!-- (>>) 제일 끝 페이지로 이동 -->
		            <a class="paging" href="${ contextPath }/user/list?page=${ pi.maxPage }${search1}${search2}${search3}${search4}${search5}">
		            <img width="16px" src="${ contextPath }/resources/images/eunjung/next.png">
		            <img width="16px" src="${ contextPath }/resources/images/eunjung/next.png"></a>
                </div>





	
 <script>
   		function detailView(nNum){
   			location.href = '${contextPath}/magazine/detail?nNum=' + nNum;
   		}
   
   </script>




	<!--footer-->
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
	

</body>

</html>