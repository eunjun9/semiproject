<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신청/결제</title>
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
			<h1>신청/결제</h1>
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
			<hr class="hr-line">

			<!-- 두번째 클래스 영역 -->

			<div class="wish-content">

				<div class="wish-class img">
					<img src="../wishlistPage/resources/image/sample2.jpg"
						width="200px" height="150px">
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

			<hr class="hr-line">
		</div>

		<!-- 주문자정보 / 결제금액 -->

		<div class="order-info">

			<!-- user_name 불러오기 -->
			<form id="order-info form" method="post">
				<h2>주문자 정보</h2>
				<h3>홍길동</h3>
				<span class="input-area"> <!-- 가입할 때 입력한 휴대폰번호 불러오기 --> <input
					type="text" id="phone" name="order-phone" maxlength="11"
					placeholder="(-없이)휴대폰번호입력" required>
				</span>
				<button type="button" id="orderPhoneBtn">수정</button>
				<br> <br> <span class="input-area"> <input
					type="email" id="email" name="order-email" placeholder="이메일주소입력">
				</span>
				<button type="button" id="orderPhoneBtn">수정</button>
			</form>

			<div class="order-price">
				<div class="total-price-first">
					<h2>결제 금액</h2>
				</div>
				<div class="total-price">
					<p>ㄴ 합계 금액 :</p>
					<p class="totalPrice">150,000원</p>
				</div>
				<div class="total-price">
					<p>ㄴ 혜택 금액 :</p>
					<p class="discountPrice">0원</p>
				</div>
				<div class="total-price-last">
					<p>총 결제 금액 :</p>
					<p class="orderPrice">150,000원</p>
				</div>
			</div>

		</div>


		<hr class="hr-line">


		<!--  ** ajax로 결제완료/미완료 비동기식  처리하기...? **  -->
		<!--  결제완료 팝업창 닫히면 결제수단 부분이 결제내역 텍스트로 바뀌는 기능 만들기! -->

		<!-- 	 <div class="pay-after">
            <span class="text">주문이 정상적으로 처리되었습니다.<br>
                결제 내역은 마이페이지에서 확인 가능합니다.<br>
            (주문 실패 시 주문 실패 문구 노출)</span>
        </div>
		-->
		
		<!-- 메인화면으로 이동 버튼
		<div class="wish-footer">
			<div class="back-btn">
				<button type="button" id="back-button" class="back">메인화면</button>
			</div> -->

			<!-- 결제내역으로 이동 버튼
			<div class="pay-btn">
				<button type="button" id="pay-button" class="pay">결제내역</button>
			</div>
		</div>
	</div> -->
			

	<!-- 결제수단 선택 부분 -->
	<div class="payment">
		<div class="pay-title">결제수단</div>
		<div class="order-select">
			<div class="bank">
				<input type="radio" name="pay" id="pay" value="무통장입금">무통장입금
			</div>
			<div class="card">
				<input type="radio" name="pay" id="pay" value="카드결제">카드결제
			</div>
			<div class="kakaopay">
				<input type="radio" name="pay" id="pay" value="카카오페이">카카오페이
			</div>
		</div>
	</div>

	<!-- 이전으로 가기 버튼 -->
	<div class="wish-footer">
		<div class="back-btn">
			<button type="button" id="back-button" class="back">이전으로</button>
		</div>

		<!-- 결제하기 버튼 -->
		<div class="pay-btn">
			<button type="button" id="pay-button" class="pay">결제하기</button>
		</div>
	</div>
	</div>
	<!-- 푸터 가져오기 -->
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>

</body>
</html>