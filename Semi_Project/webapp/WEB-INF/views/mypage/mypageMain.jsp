<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>

	<!--외부 스타일 시트-->
    <link rel="stylesheet" href="${ contextPath }/resources/css/mypage/mypage_main.css?6">
    <!--폰트-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500&display=swap" rel="stylesheet">

</head>
<body>
    <!-- header -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<div id="mypage_wrapper">
	<div class="mypage_main">
    <div class="wrapper1">
        <div class="info">
            <h2>마이 페이지</h2>
        </div>
            
            <div class="profile">
            	<div id="mypic">
                <c:choose>
					<c:when test="${ not empty profile.profileFile.get(0).changeName}">
                		<img src="${ contextPath }${ profile.profileFile.get(0).route}${profile.profileFile.get(0).changeName}"></a>
					</c:when>
					<c:otherwise>
						<img src="${ contextPath }/resources/images/yewon/profile.png"></a>
					</c:otherwise>
                </c:choose>
            	</div>
                
                <div id="infoarea">
                <p id="name">${ loginUser.userName }</p>
                <p id="level">${ loginUser.userGrade }</p><br>
                <p id="mail">${ loginUser.userId }</p> <br>
                <a id="myfeed" href="${contextPath }/myfeed">내 피드 <img width="5%" src="${ contextPath }/resources/images/yewon/next.png"></a>
                </div>
            </div>
			
			<div id="movebox">
            <ul class="move">
                <li><a class="mv" id="modify" href="<%= request.getContextPath() %>/mypage/userinfomodify">정보수정 <img class="pmv" width="5%" src="${ contextPath }/resources/images/yewon/next.png"> </a></li>
                <li><a class="mv" id="slist" href="${ contextPath }/mypage/socialinglist">모임내역 <img class="pmv" width="5%" src="${ contextPath }/resources/images/yewon/next.png"> </a> </li>
                <li><a class="mv" id="plist" href="${ contextPath }/mypage/paylist">결제내역 <img class="pmv" width="5%" src="${ contextPath }/resources/images/yewon/next.png"> </a> </li>
                <li><a class="mv" id="logout" href="${contextPath }/logout">로그아웃 <img class="pmv" width="5%" src="${ contextPath }/resources/images/yewon/next.png"> </a> </li>
            </ul>
			</div>
    </div> 
    
    <div class="wrapper2">
        <div class="interest">
            <span>
                <h3>관심 소셜링</h3>
            </span>
            <div class="socialing">
            	<c:forEach var = "socialing" items = "${ socialingList }">
                <div class="item1" onclick="detailView(${socialing.nNum})">
                    <img class="ipic" src="${ contextPath }${ socialing.photoList.get(0).route}${ socialing.photoList.get(0).changeName }">
                    <p id="stitle">${ socialing.nTitle }</p>
                    <c:choose>
						<c:when test='${ socialing.splace.contains("|") }'>
                    		<p class="sdate">${ socialing.splace.split("\\|")[0]  }</p>
                   		 </c:when>
						<c:otherwise>
							<p class="sdate">${ socialing.splace }</p>
						</c:otherwise>
				 </c:choose>
                	<p id="stime"> ${ socialing.sdate }</p>
                </div>
            	</c:forEach>
            </div>
    </div>
    
    <script>
    	function detailView(nNum){
    		location.href = "${ contextPath }/socialing/detail?nNum=" + nNum;
    	}
    
    </script>
            
        <!-- 페이지 로직 -->
        <c:if test="${ not empty socialingList }">
        <div class="wrapper5">
        	<!-- (<<) 제일 첫 페이지로 이동 -->
            <a class="paging" href="${ contextPath }/mypage/main?page=1"><img width="16px" src="${ contextPath }/resources/images/yewon/previous.png">
            <img width="16px" src="${ contextPath }/resources/images/yewon/previous.png"></a>
             
             <!--  (<) 이전 페이지  : 현재 페이지 - 1이니까 -->	
             <c:choose>
             	<c:when test="${ pi.page > 1 }"> <!--  현재 페이지가 1보다 클 때는 이동하고  -->
             		<a class="paging" href="${ contextPath }/lesson/main?page=${ pi.page - 1}"><img width="18px" src="${ contextPath }/resources/images/yewon/previous.png"></a>
             	</c:when>
             	<c:otherwise> <!-- 1이면 현재 페이지에 머뭄 -->
             		<a class="paging" href="#"><img width="18px" src="${ contextPath }/resources/images/yewon/previous.png"></a>
             	</c:otherwise>
             </c:choose>
             	<!-- 최대 3개의 페이지 목록  생성 -->
             	<c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
	             	<li>
				 	<c:choose>
				 		<c:when test="${ p eq pi.page }"> <!-- p와 현재 요청 페이지가 같다면 = 현재 페이지 임을 나타낼 수 있는 색 변경-->
				 			<a href="#" class="pagingcircle"><img width="20px" src="${ contextPath }/resources/images/yewon/circle_sky.png"></a>
				 		</c:when>
				 		<c:otherwise> <!-- 현재 페이지 외에는 페이지 목록 숫자만 출력 -->
				 			<a class="pagingcircle" href="${ contextPath }/mypage/main?page=${ p }"><img width="20px" src="${ contextPath }/resources/images/yewon/circle_beige.png"></a>
				 		</c:otherwise>
				 	</c:choose>
				 	</li>
             	</c:forEach>
            
            <!--  (>) 다음 페이지 : 제일 끝 페이지에서 버튼 누를 것을 고려하여 조건문 사용 -->
            <c:choose>
            	<c:when test="${ pi.page < pi.maxPage }"> <!-- 현재 페이지가 최대 페이지보다 아래일 때 이동 -->
            	 	<a class="paging" href="${ contextPath }/mypage/main?page=${ pi.page + 1 }"><img width="18px" src="${ contextPath }/resources/images/yewon/next.png"></a>
            	</c:when>
            	<c:otherwise>
            		<a class="paging" href="#"><img width="18px" src="${ contextPath }/resources/images/yewon/next.png"></a>
            	</c:otherwise>
            </c:choose>
            
            <!-- (>>) 제일 끝 페이지로 이동 -->
            <a class="paging" href="${ contextPath }/mypage/main?page=${ pi.maxPage }"><img width="16px" src="${ contextPath }/resources/images/yewon/next.png">
            <img width="16px" src="${ contextPath }/resources/images/yewon/next.png"></a>
        </div>
        </c:if>
        </div>
</div>
</div>	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>