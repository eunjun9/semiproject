<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<!-- 외부 스타일 시트 -->
<link rel="stylesheet"
	href="<%= request.getContextPath() %>/resources/css/wishlist-style.css">
<!-- 외부 폰트 -->
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
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

		<!-- 클래스 썸네일 이미지 영역 / 테스트 이미지 삽입 -->
		<div class="wish-class">
			<div class="wish-content">

				<!-- 체크박스 -->
				<div class="class-checkbox">
					<input type="checkbox" class="order-check" id="order1" name="order"
						checked>
				</div>
				<div class="wish-class img">
					<img src="../wishlistPage/resources/image/sample1.jpg"
						width="200px" height="150px">
				</div>
			</div>

			<!-- 장바구니 추가한 클래스 정보 가져올 영역 -->
			<div class="wish-class-info">
				<p class="category">ONE-DAY</p>
				<p class="title">도예공방에서 나만의 도자기 만들기</p>
			</div>

			<div class="wish-class-date">
				<p class="date">2021-11-06 토요일 오후 7시</p>
			</div>

			<div class="wish-class-price">
				<p class="price">50,000원</p>
			</div>

			<!-- 신청하기(결제페이지로 이동) 버튼 -->
			<div class="wish-class-btn">
				<button type="button" class="order-button">신청하기</button>
			</div>
			<hr class="hr-line">
		</div>

		<!-- 두번째 클래스 영역 -->

		<div class="wish-content">
			<!-- 체크박스 -->
			<div class="class-checkbox">
				<input type="checkbox" class="order-check" id="order2" name="order"
					checked>
			</div>
			<div class="wish-class img">
				<img src="../wishlistPage/resources/image/sample2.jpg" width="200px"
					height="150px">
			</div>
		</div>

		<div class="wish-class-info">
			<p class="category">VOD</p>
			<p class="title">40년 경력 포토그래퍼가 알려주는 '초/중급자를 위한 사진 라이팅 테크닉 클래스'</p>
		</div>

		<div class="wish-class-date">
			<p class="date">150일</p>
		</div>

		<div class="wish-class-price">
			<p class="price">100,000원</p>
		</div>

		<!-- 신청하기(결제페이지로 이동) 버튼 -->
		<div class="wish-class-btn">
			<button type="button" class="order-button">신청하기</button>
		</div>

		<hr class="hr-line">
	</div>

	<!-- 선택버튼 / 총결제금액 표시 부분 -->
	<div class="wish-content-foot">

		<div class="class-checkbox-btn">
			<div class="checkbox-btn">
				<button type="button" name="order" class="check-btn">전체선택</button>
				<button type="button" name="order" class="check-btn2">선택삭제</button>
			</div>


			<div class="class-total-pay">
				<div class="total">선택된 클래스의 총 금액</div>
				<div class="totalPay">150,000</div>
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
</body>
</html>