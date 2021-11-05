<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%
	String userId = (String)session.getAttribute("userId"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<!-- 외부 스타일 시트 -->
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/wishlist-style.css">
<!-- 외부 폰트 -->
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
</head>
<body>
	<!-- 헤더 가져오기 -->
	<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<!-- 위시리스트 화면 -->
	<div class="container">
		<div class="wish-title">
			<h1>장바구니</h1>
		</div>
		<div class="wish-heardLine">
			<hr>
			<h4>
				<span class="class-info text"> 클래스 정보 </span>
			</h4>
			<h4>
				<span class="class-date text"> 날짜/기한 </span>
			</h4>
			<h4>
				<span class="class-price text"> 가격 </span>
			</h4>
			<hr>
		</div>

		<c:forEach var="wishlist" items="${ wishlist }">
		<!-- 클래스 썸네일 이미지 영역 / 테스트 이미지 삽입 -->
		<div class="wish-class" id="wish-class">
			<div class="wish-content">

				<!-- 체크박스 -->
				<div class="class-checkbox">
					<input type="checkbox" class="order-check" id="order1" name="order" checked>
				</div>
				<div class="wish-class img">
					<img src="${ contextPath }${ wishlist.photoList.get(0).filePath }${ wishlist.photoList.get(0).changeName }"
						width="200px" height="150px">
				</div>
			</div>

			<!-- 장바구니 추가한 클래스 정보 가져올 영역 -->
			<div class="wish-class-info">
				<p class="category">${ wishlist. }</p>
				<p class="title"></p>
			</div>

			<div class="wish-class-date">
				<p class="date"></p>
			</div>

			<div class="wish-class-price">
				<p class="price"></p>
			</div>

			<!-- 신청하기(결제페이지로 이동) 버튼 -->
			<div class="wish-class-btn">
				<button type="button" class="order-button">신청하기</button>
			</div>
			<hr class="hr-line">
		</div>
	</c:forEach>
	<!-- 선택버튼 / 총결제금액 표시 부분 -->
	<div class="wish-content-foot">

		<div class="class-checkbox-btn">
			<div class="checkbox-btn">
				<button type="button" name="order" class="check-btn">전체선택</button>
				<button type="button" name="order" class="check-btn2">선택삭제</button>
			</div>


			<div class="class-total-pay">
				<div class="total">선택된 클래스의 총 금액</div>
				<div class="totalPay"></div>
				<div class="total">원</div>
			</div>

		</div>
		<hr class="hr-line">

		<!-- 이전으로 가기 버튼 -->
		<div class="wish-footer">
			<div class="back-btn">
				<button type="button" id="back-button" class="back">이전으로</button>
			</div>
		</div>
	</div>

	<!-- 푸터 가져오기 -->
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
	
	<!-- <script>
		$(function(){
			if(!list) {
				$("#wish-class").css("display", "none");
				}else{
				$("#wish-class").css("display", "block");
				}
			
		}); -->
	</script>
</body>
</html>