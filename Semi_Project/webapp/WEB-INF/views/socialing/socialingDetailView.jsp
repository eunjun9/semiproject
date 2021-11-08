<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소셜링_상세페이지</title>

<!-- 외부 스타일 시트 -->
<link href="${ contextPath }/resources/css/socialing/socialing_detail.css?2" rel="stylesheet">
<link href="${ contextPath }/resources/css/socialing/socialing_check.css?1" rel="stylesheet">

<!-- 글꼴 (Noto Sans) -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
	<!--header-->
    <%@ include file="/WEB-INF/views/common/header.jsp" %>

    <!-- body -->
    <div class="page body">
        <div class="body-inner">
            <div class="wrapper1">
                <p id="title">${ socialing.nTitle }</p>
                <hr>
                <h3 id="subTitle">장소</h3><p id="subTitle2">${ socialing.splace }</p><br>
                <h3 id="subTitle">날짜</h3><p id="subTitle2"><fmt:formatDate value="${ socialing.sdate }" type="both" pattern="M.dd(E) a h시 m분"/></p>
                <!-- 조회수 추가....? -->
            </div>
            <div class="wrapper2">
                <img src="${ contextPath }${ socialing.photoList.get(0).route }${ socialing.photoList.get(0).changeName }">
            </div>
            <div class="wrapper3">
                <p id="content">${ socialing.nContent }</p>
            </div>
            <div class="wrapper4">
                <div class="profileBox">
                	<!-- 프로필 이미지 border-radius로 동그랗게 출력 -->
                    <img id="p-image" src="${ contextPath }/resources/images/eunjung/profile.png"><br>
                    <p id="p-name">${ socialing.userName }</p><br>
                    <!-- if문으로 일반 회원 : 참여하기 버튼 / 작성자 : 참여확인 버튼 출력되게 -->
                    <c:choose>
						<c:when test="${ loginUser.userId == socialing.userId }">
							<button type="button" id="p-button2">소셜링 참여확인</button>
						</c:when>
						<c:otherwise>
							<button type="button" id="p-button" onclick="join()">소셜링 참여하기</button>
						</c:otherwise>
					</c:choose>           
                </div>
            </div>
            <hr>
            <h3 id="subTitle3">함께하는 멤버</h3>
            <!-- 작성자 프로필(기본) -->
            <div class="subWrap">
                <a href="#"> <!-- 참여자 피드로 이동 -->
                    <img id="s-image" src="${ contextPath }/resources/images/eunjung/profile.png">
                    <div class="subWrap2">
                        <p id="s-name">${ socialing.userName }</p>
                        <p id="s-intro">${ socialing.introduction }</p>
                    </div>
                </a>
            </div>
            <!-- 참여 회원 목록 -->
            <c:forEach var="m" items="${ memberList }">
            <div class="subWrap">
                <a href="#">
                    <img id="s-image" src="${ contextPath }/resources/images/eunjung/profile.png">
                    <div class="subWrap2">
                        <p id="s-name">${ m.memberName }</p>
                        <p id="s-intro">${ m.introduction }</p>
                    </div>
                </a>
            </div>
            </c:forEach>
            
            <h3 id="subTitle4">자세한 정보를 알려드릴게요</h3>
            <div class="subWrap3">
                <img id="icon" src="${ contextPath }/resources/images/eunjung/user.png">
                <p id="detail">최소 ${ socialing.minMember }명 ~ 최대 ${ socialing.maxMember }명</p>
            </div>
            <div class="subWrap3">
                <img id="icon" src="${ contextPath }/resources/images/eunjung/pin.png">
                <p id="detail">${ socialing.splace } (서울특별시 도봉구 창동 343)</p>
            </div>
            <div class="subWrap3">
                <img id="icon" src="${ contextPath }/resources/images/eunjung/time.png">
                <p id="detail"><fmt:formatDate value="${ socialing.sdate }" type="both" pattern="M.dd(E) a h시 m분"/></p>
            </div>
            <div class="buttons"> <!-- 삭제, 수정은 작성자/관리자만 표시 -->
            <c:if test="${ loginUser.userId == socialing.userId || loginUser.userId.equals('admin') }">
            	<button type="button" id="delete" onclick="deleteBoard()">삭제</button>
                <button type="button" id="update" onclick="updateBoard()">수정</button>
            </c:if>
            	<!-- 신고 팝업에 글번호 값 보내기 -->
            	<div style="display: none">
	            	<jsp:include page="/WEB-INF/views/common/reportFormPopup.jsp">
						<jsp:param name="nNum" value="${ socialing.nNum }"/>
					</jsp:include>
            	</div>
                <button type="button" id="report" 
                onclick="openPopup('${ contextPath }/reportForm', 'reportForm', 370, 500)">신고</button>
            </div>
        </div>
    </div>

    <div class="checkPop" style="display:none;">
        <h2 id="chk_title">참여 회원 체크</h2>
        <form name="checking" action="${ contextPath }/socialing/detail" method="post">
        	<input type="hidden" name="nNum" value="${ socialing.nNum }">
            <div class="checkArea">
                <!-- 체크 후 submit 하면 체크 유지되게 (checked) -->
	            <c:forEach var="m" items="${ memberList }">
		        	<input type="hidden" name="mId" value="${ m.memberId }">
		            <input type="checkbox" id="${ m.memberId }" name="check" value="${ m.memberId }"
		            <c:if test="${ m.status == 'Y' }">checked</c:if>>
		            <label for="person1">${ m.memberName }</label><br>
	            </c:forEach>
            </div><br>
            <div class="btnArea">
                <button type="button" id="cancel">취소</button>
                <button type="button" id="sub" onclick="checkSub()">체크</button>
            </div>
        </form>
    </div>
    
    <c:choose>
		<c:when test="${ !empty loginUser }">
			<form name="memberForm" method="post">
				<input type="hidden" name="nNum" value="${ socialing.nNum }">
			</form>
			<script>
				function openPopup(url, title, width, height) {
		            let left = (document.body.clientWidth/2)-(width/2);
		            left += window.screenLeft;
		            let top = (screen.availHeight/2)-(height/2);
		                
		            let options = "width="+width+",height="+height+",left="+left+",top="+top;
		                
		            window.open(url, title, options);
		        }
	
		        function join() {
		            if(confirm('모임에 참여하시겠습니까?')) {
		                // 참여회원 테이블에 id 추가
		            	document.forms.memberForm.action = "${contextPath}/socialingMember";
		    			document.forms.memberForm.submit();
		            }
		        }
	
		        function checkSub() {
		            if(confirm('참석 처리 하시겠습니까?')) {
		                // 참여 여부 'Y'로 변경
		                document.forms.checking.action = "${contextPath}/socialingMember/update";
		                document.forms.checking.submit();
		            }
		        }
		        
		        function updateBoard() {
		        	// 글 작성 페이지로 이동
		        }
	
		        function deleteBoard() {
		            if(confirm('이 게시글을 삭제하시겠습니까?')) {
		                // 글 삭제 후 목록으로 이동
		            }
		        }
	
		        $(document).ready(function() {
		            $('#p-button2').click(function() {
		                $('.checkPop').show();
		            });
	
		            $('#cancel').click(function() {
		                $('.checkPop').hide();
		            });
		        });
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