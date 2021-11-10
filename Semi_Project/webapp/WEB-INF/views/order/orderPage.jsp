<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String selDate = (String) request.getAttribute("selDate");
%>
<%
	String name = (String) request.getAttribute("name");
	String email = (String) request.getAttribute("email");
	String phone = (String) request.getAttribute("phone");
	String totalPrice = (String) request.getAttribute("totalPrice");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신청/결제</title>
<!-- 외부 스타일 시트 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/order/payment-style.css?3">
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
		<div class="wish-title">신청/결제</div>
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
							<p class="date">${ wishList.lessonDate }<br> ${ wishList.cTime1 }
								~ ${ wishList.cTime2 }
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

				<!-- 주문자정보 / 결제금액 -->
				<div class="order-info">
					<form id="order-info form" method="post">
						<h2>주문자 정보</h2>
						<div class="order-name">${ member.userName }</div>
						<span class="input-area1"> <input type="text" id="phone"
							name="order-phone" maxlength="13" value="${ member.userPhone }">
						</span> <input type="button" id="orderPhoneBtn" value="수정"><br>
						<br> <span class="input-area2"> <input type="email"
							id="email" name="order-email" value="${ member.userId }">
						</span> <input type="button" id="orderEmailBtn" value="수정">
					</form>

					<div class="order-price">
						<div class="total-price-first">
							<h2>결제 금액</h2>
						</div>
						<div class="total-price-last">
							<p>총 결제 금액</p>
							<p class="orderPrice">
								<fmt:formatNumber value="${ wishList.cPrice }"
									pattern="###,###,###" /> 원
							</p>

						</div>
					</div>

				</div>
			</c:forEach>

			<hr class="hr-line">


			<!-- 결제수단 선택 부분 -->
			<div class="payment">
				<div class="pay-title">결제수단</div>
				<div class="order-select">
					<div class="bank">
						<input type="radio" name="bankPay" id="bankPay" value="무통장입금">무통장입금
					</div>
					<div class="card">
						<input type="radio" name="cardPay" id="cardPay" value="카드결제">카드결제
					</div>
					<div class="kakaopay">
						<input type="radio" name="kakaoPay" id="kakaoPay" value="카카오페이">카카오페이
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

					<form name="payForm" method="post">
						<input type="hidden" name="name" value="${ name }" /> 
						<input type="hidden" name="email" value="${ emalil }" /> 
						<input type="hidden" name="phone" value="${ phone }" /> 
						<input type="hidden" name="totalPrice" value="${ totalPrice }" />


						<button type="submit" id="pay-button" class="pay"
							onclick="radioCheck();">결제하기</button>
				
				</form>
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
		$("#phone").change(function() {
			if ($(this).val()) {
				$("#orderPhoneBtn").click(function() {
					alert('수정되었습니다.');
					$("#phone").prop("readonly", true);
					$(".input-area1").css("background-color", "#F3F2F2");
					$("#phone").css("background-color", "#F3F2F2");
				});
			} else {
				$("#phone").text($(this).val());
			}
		});

		$("#email").change(function() {
			if ($(this).val()) {
				$("#orderEmailBtn").click(function() {
					alert('수정되었습니다.');
					$("#email").prop("readonly", true);
					$(".input-area2").css("background-color", "#F3F2F2");
					$("#email").css("background-color", "#F3F2F2");
				});
			} else {
				$("#email").text($(this).val());
			}
		});
	</script>

	<script>
		function radioCheck() {
			// 카카오페이 라디오버튼 클릭 시
			if ($('input:radio[name="kakaoPay"]').is(":checked") == true){
				document.forms.payForm.action = "${ contextPath }/pay/check";
				document.forms.payForm.submit();
			}
		}
	</script>



</body>
</html>