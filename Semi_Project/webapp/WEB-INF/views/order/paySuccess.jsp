<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String msg = (String)request.getAttribute("msg");
%>    
<%
	String selDate = (String) request.getAttribute("selDate");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신청/결제</title>
<!-- 외부 스타일 시트 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/order/payment-style.css">
<!-- 외부 폰트 -->
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>

	<!-- 헤더 가져오기 -->
	<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<!-- 위시리스트 화면 -->
	<div class="container">
		<div class="wish-title">
			신청/결제
		</div>
		<div class="wish-heardLine">
			<hr>
			<ul>
				<li class="class-info text">클래스 정보</li>
				<li class="class-date text">날짜/기한</li>
				<li class="class-price text">가격</li>
			</ul>
			<hr>
		</div>
			<div class="wish-class">
			<c:forEach var="wishList" items="${ wishList }">
				<div class="wish-content">
					<input type="hidden" name="noticeNum">
					<div class="wish-class img">
						<img
							src="${ contextPath }${ wishList.route }${ wishList.changeName }"
							width='200px' height='150px'>
					</div>
				</div>

				<!-- 장바구니 추가한 클래스 정보 가져올 영역 -->
				<div class="wish-class-info">
					<p class="category">${ wishList.cCategory }</p>
					<p class="title">${ wishList.nTitle }</p>
				</div>

				<c:choose>
					<c:when test="${ wishList.cCategory eq 'vod' }">
						<div class="wish-class-date">
							<p class="date">${ wishList.vDate }일</p>
						</div>
					</c:when>
					<c:when test="${ wishList.cCategory eq '원데이' }">
						<div class="wish-class-date">
							<p class="date">${ wishList.lessonDate }<br>
							${ wishList.cTime1 } ~ ${ wishList.cTime2 }
							</p>
						</div>
					</c:when>
				</c:choose>

				<div class="wish-class-price">
					<p class="price">
						<fmt:formatNumber value="${ wishList.cPrice }" pattern="#,###" />
					</p>
				</div>
				<hr class="hr-line">

		
		</c:forEach>

		<hr class="hr-line">

			<!-- 결제 결과 텍스트  -->
		 	 <div class="pay-after">
		        <span class="text">주문이 정상적으로 처리되었습니다.<br>
		            결제 내역은 마이페이지에서 확인 가능합니다.<br>
		        </span>
		    </div>
			
		
			<div class="wish-footer">
				<div class="back-btn">
					<button type="button" id="back-button" class="back" onclick="mainMove()">메인화면</button>
				</div>
				
				<div class="pay-btn">
					<button type="button" id="pay-button" class="pay" onclick="payMove()">결제내역</button>
				</div>
			</div>
		</div> 
			</div>
		</div>


	<!-- 푸터 가져오기 -->
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>


	<!--  뒤로 가기 -->
	<script>
		function back() {
			history.back();
		}
	</script>
	
	
	<!-- 주문자 정보 수정 -->
	<script>
	 $("#phone").change(function(){
	        if($(this).val()){
	        	$("#orderPhoneBtn").click(function(){
	        		alert('수정되었습니다.');
	        		$("#phone").prop("readonly", true);
	        		$(".input-area1").css("background-color", "#F3F2F2");
	        		$("#phone").css("background-color", "#F3F2F2");
	        	});
	        }else{
	        	 $("#phone").text($(this).val());
	        }
	       }); 
		
	 $("#email").change(function(){
	        if($(this).val()){
	        	$("#orderEmailBtn").click(function(){
	        		alert('수정되었습니다.');
	        		$("#email").prop("readonly", true);
	        		$(".input-area2").css("background-color", "#F3F2F2");
	        		$("#email").css("background-color", "#F3F2F2");
	        	});
	        }else{
	        	 $("#email").text($(this).val());
	        }
	       }); 
	 
	</script>
	
	<script>
	function mainMove(){
			location.href='${ contextPath }/mainpage.jsp';
	}
	
	function payMove(){
			location.href='${ contextPath }/mypagePayList.jsp';
	}
	</script>
	


	


</body>
</html>