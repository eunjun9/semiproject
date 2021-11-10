<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클래스 상세페이지</title>

	<!--외부 스타일 시트-->
    <link href="${ contextPath }/resources/css/lesson/lesson_detail.css?7" rel="stylesheet">
	
    <!-- font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500&display=swap" rel="stylesheet">

    <!-- JQuery-->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

</head>
<body>

<div class="class_detail_wrapper">
    <!-- header -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
        
        <!-- 클래스 상세 페이지 헤더-->
        <div class="class_detail1">
            <div class="cDetail_h" >
                <h2 class="cMTitle">${ lesson.nTitle }</h2>
                <img class="cThumbnail" src="${ contextPath }${ lesson.photoList.get(0).route }${ lesson.photoList.get(0).changeName }">
            </div>
            <h4 class="cTutor">강사</h4><p>${ lesson.userName }</p>
            <h4 class="cCategory">타입</h4><p>${ lesson.cCategory } 클래스</p>
        </div>
        
        <c:choose>
        	<c:when test="${ lesson.cCategory == 'vod'}" >
	        	<form name="orderForm" method="get">
					<input type="hidden" name="noticeNum" value="${ lesson.nNum }">
        			<div class="payment">
       				 <!-- vod 클래스는 날짜 선택이 필요없기 때문에 모달창이 뜨지 않고 / 장바구니 결제하기 버튼이 바로 생성되어 있음 
       				 -> 각각 클릭 시 nNum과 함께 각 페이지로 이동  -->
			            <h4 id="pTitle">${ lesson.nTitle }</h4>
			            <p id="pTime">${ lesson.vDate } 일 <hr></p>
			            <h3 id="pPrice">50,000원</h3>
			            <div>
			            <button id="cart">장바구니</button>
			            <button id="apply">결제하기</button>
			            </div>
					</div>
				</form>
				<script>
	            $(function(){ 
	                 $("#apply").click(function(){ 
	                    if(confirm('결제화면으로 이동하시겠습니까?')){
	                        document.forms.orderForm.action = "${ contextPath }/lesson/order";
			                document.forms.orderForm.submit();
	                    } else {
	                    	return false;
	                    } 
	                 }); 
	                 $("#cart").click(function(){ 
		                 if(confirm('장바구니에 추가하시겠습니까?')){
		                   document.forms.orderForm.action = "${ contextPath }/wishlist/add";
		                   document.forms.orderForm.submit();
		                } else {
		                	return false;
		                }
	                }); 
	           });
	          </script> 
        	</c:when>
        	
        	<c:when test="${ lesson.cCategory == '원데이'}" >
        	<!-- 원데이 클래스는 수강하기 버튼만 있고 클릭 시 , 날짜 선택 모달창 -> 장바구니 / 결제하기로 넘어갈 수 있음 -->
       				<div class="payment">
        				<form name="testForm" method="get">
						<input type="hidden" name="noticeNum" value="${ lesson.nNum }">
			            <h4 id="pTitle">${ lesson.nTitle }</h4>
			            <input type="date" id="pDate" min="${ lesson.oDate1 }" max="${ lesson.oDate2 }" name="selDate">
			            <p id="pTime">${ lesson.cTime1 } ~ ${ lesson.cTime2 } <hr></p>
			            <h3 id="pPrice">50,000원</h3>
			            <button type="submit" id="cart">장바구니</button>
			            <button type="submit" id="apply">결제하기</button>
						</form>
	    			</div>
	    			
	    			<script>
		        	$(function(){
		        		 $("#apply").click(function(){ 
			        			 if($("#pDate").val() == ""){
			        				 alert('날짜를 선택하세요');
			        				 $("#pDate").focus();
			        				 return false;
			        			 } else {
					                    if(confirm('결제화면으로 이동하시겠습니까?')){
					                        document.forms.orderForm.action = "${ contextPath }/lesson/order";
							                document.forms.orderForm.submit();
					                    }else {
					                    	return false;
					                    } 
			                	} 
		        		 })
		        		 $("#cart").click(function(){ 
		        			 if($("#pDate").val() == ""){
		        				 alert('날짜를 선택하세요');
		        				 $("#pDate").focus();
		        				 return false;
		        			 } else {
				                    if(confirm('장바구니로 이동하시겠습니까?')){
				                        document.forms.orderForm.action = "${ contextPath }/wishlist/add";
						                document.forms.orderForm.submit();
				                    }else {
				                    	return false;
				                    } 
		 	       			 }
		                }); 
		        	});
        	</script>
        	</c:when>
        </c:choose>
        
<!-- 클래스 상세 페이지 바디-->
<div class="class_detail2">
    <hr>
    <h4>클래스 소개</h4>
    <div class="cDetail_b">
         <pre class="cBodyText2">${ lesson.nContent }</pre>
			<div class="photoList">
					<c:if test="${ lesson.photoList.size() > 1 }">
						<img  src="${ contextPath }${ lesson.photoList.get(1).route }${ lesson.photoList.get(1).changeName }">
					</c:if>
			</div>
        <hr>
    </div>
</div>

<!-- 클래스 상세 페이지 푸터-->
<div class="class_detail3">
    <h4>강사 소개</h4>
    <pre id="cTutorIntro">${ lesson.cTutor }</pre> <hr>
    
    <c:if test="${ lesson.cCategory == '원데이'}" >
    <h4>위치</h4>
    <p id="cPlace">${ lesson.cLocation }</p><hr>
    </c:if>
    <h4>환불 정책</h4>
    <p>환불 정책에 따라 클래스 수강일로부터 7일 전 까지 전액 환불이 가능합니다.</p><hr>
    
    <!-- 문의사항 나중에 처리 -->
   <h4>문의 사항</h4>
    <div class="cQnA">
        <form>
            <input type="text" name="cQuestion" placeholder=" 강사님께 문의하실 내용을 입력해주세요." size="110">
            <button name="qSubmit" class="qBtn">등록</button><br>
            <div class="outer">
                <p class="cQuestion1"> 가져가야 될 준비물이 있을까요?</p>
                <p class="aStatus">답변 대기</p>
                <textarea class="cAnswer" placeholder="답변을 작성해주세요."></textarea>
                <button name="aSubmit" class="aBtn">등록</button> 
            </div>
            <div class="outer">
                <p class="cQuestion2"> 가져가야 될 준비물이 있을까요?</p>
                <p class="aStatus">답변 완료</p>
                <p class="cAnswer" >아니요 준비물은 없습니다.</p>
            </div>
            <div class="outer">
                <p class="cQuestion2"> 가져가야 될 준비물이 있을까요?</p>
                <p class="aStatus">답변 완료</p>
                <p class="cAnswer" >아니요 준비물은 없습니다.</p>
            </div>
            <div class="outer">
                <p class="cQuestion2"> 가져가야 될 준비물이 있을까요?</p>
                <p class="aStatus">답변 완료</p> 
                <p class="cAnswer" >아니요 준비물은 없습니다.</p>
            </div>
        </form> 

            <div class="btnArea">
              <button onclick="location.href='${ contextPath }/lesson/main'">목록보기</button>
              <!-- 작성자 본인만 가능 -->
              <c:if test="${ loginUser.userId == lesson.userId }">
              <button onclick="updateLessonView();">수정하기</button>
              <button onclick="deleteLesson();">삭제하기</button>
              </c:if>
            </div>
    </div>
    
    <!-- 문의사항 스크립트 -->
    <script>
        $('.cQuestion2').click(function(){
            if($(this).siblings('.cAnswer').css('display') == 'none'){ // question다음의 컨텐츠 영역이 display=none일 때
                $('p.cAnswer').slideUp();       // 기존에 열려있는 콘텐츠는 닫고
                $(this).siblings('.cAnswer').slideDown();  // 클릭한 메뉴의 콘텐츠는 밑으로 스르륵 내려오게
            }else{
                $(this).siblings('.cAnswer').slideUp();    // display=none 이 아닐 때 클릭 시 위로 올라가게
            }
        });
        </script>
	
</div>
</div>
	<!-- footer -->
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	
	<c:if test="${ loginUser.userId == lesson.userId }">
		<form name="lessonForm" method="post">
			<input type="hidden" name="nNum" value="${ lesson.nNum }">
		</form>
		<script>
			function updateLessonView(){
				document.forms.lessonForm.action = "${ contextPath }/lesson/updateView";
				document.forms.lessonForm.submit();
			}
			
			function deleteLesson(){
				if(confirm("이 게시글을 삭제하시겠습니까?")){
					document.forms.lessonForm.action = "${ contextPath }/lesson/delete";
					document.forms.lessonForm.submit();
				}
			}
		</script>
	</c:if>

</body>
</html>