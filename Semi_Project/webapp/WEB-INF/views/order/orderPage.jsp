<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String selDate = (String) request.getAttribute("selDate");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신청/결제</title>
<!-- 외부 스타일 시트 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/order/payment-style.css?2">
<!-- 외부 폰트 -->
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
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
					<input type="hidden" name="nNum">
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
							<p class="date">${ wishList.lessonDate }<br> ${ wishList.cTime1 } ~
								${ wishList.cTime2 }
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

		<!-- 주문자정보 / 결제금액 -->
		<c:forEach var="wishList" items="${ wishList }">
			<div class="order-info">
				<form id="order-info form" method="post">
					<h2>주문자 정보</h2>
					<div class="order-name">${ member.userName }</div>
					<span class="input-area"> <input type="text" id="phone"
						name="order-phone" maxlength="11" value="${ member.userPhone }">
					</span>
					<button type="button" id="orderPhoneBtn">수정</button>
					<br> <br> <span class="input-area"> <input
						type="email" id="email" name="order-email"
						value="${ member.userId }">
					</span>
					<button type="button" id="orderPhoneBtn">수정</button>
				</form>

				<div class="order-price">
					<div class="total-price-first">
						<h2>결제 금액</h2>
					</div>
					<div class="total-price-last">
						<p>총 결제 금액</p>
						<p class="orderPrice">
							<fmt:formatNumber value="${ wishList.cPrice }"
								pattern="###,###,###" />
							원
						</p>

					</div>
				</div>

			</div>
		</c:forEach>

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
				<input type="button" id="back-button" class="back" onclick="back()"
					value="이전으로">
			</div>

			<!-- 결제하기 버튼 -->
			<div class="pay-btn">
				<button type="button" id="pay-button" class="pay">결제하기</button>
			</div>
		</div>
	</div>
</div>
	<!-- 푸터 가져오기 -->
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>

	<script>
		function back() {
			history.back();
		}
	</script>
</body>
</html>