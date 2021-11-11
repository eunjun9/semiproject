<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
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
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/order/payment-style.css?1">
<!-- 외부 폰트 -->
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
	<!-- iamport.payment.js -->
  <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
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
							<p class="date">${ selDate }<br>
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

				<!-- 주문자정보 / 결제금액 -->
				<div class="order-info">
					<form id="order-info form" method="post">
						<h2>주문자 정보</h2>
						<div class="order-name" id="orderName">${ member.userName }</div>
						<span class="input-area1">
						<input type="text" id="phone" name="order-phone" maxlength="13" value="${ member.userPhone }">
						</span>
						<input type="button" id="orderPhoneBtn" value="수정"><br> <br>
						<span class="input-area2">
						<input type="email" id="email" name="order-email" value="${ member.userId }">
						</span>
						<input type="button" id="orderEmailBtn" value="수정">
					</form>

					<div class="order-price">
						<div class="total-price-first">
							<h2>결제 금액</h2>
						</div>
						<div class="total-price-last">
							<p>총 결제 금액</p>
							<p class="orderPrice" id="orderPrice">
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
					<div class="card">
						<input type="radio" name="radio" id="cardPay" value="카드결제">카드결제
					</div>
					<div class="kakaopay">
						<input type="radio" name="radio" id="kakaoPay" value="카카오페이">카카오페이
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
						<input type="hidden" name="name" value="${ member.userName }" /> 
						<input type="hidden" name="email" value="${ member.userId }" /> 
						<input type="hidden" name="phone" value="${ member.userPhone }" />
						<input type="hidden" name="totalPrice" value="${ totalPrice }" /> 
				
						<button type="submit" id="pay-button" class="pay" onclick="iamport();">결제하기</button>
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


	<!-- 아임포트 카카오페이 API -->
	<script>
	function iamport(){
        //가맹점 식별코드
        IMP.init('imp46363326');
        IMP.request_pay({
            pg : 'kakaopay',
            pay_method : '$(":input:radio[id=kakaoPay]:checked").val()',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : '소셜다이닝',
            amount : ${ totalPrice },
            buyer_email : '${ member.userId }',
            buyer_name : '${ member.userName }',
            buyer_tel : '${ member.userPhone }',
            buyer_addr : '대한민국',
            buyer_postcode : '123-456'
        }, function(rsp) {
        	 if ( rsp.success ) {
 		    	//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
 		    	jQuery.ajax({
 		    		url: "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
 		    		type: 'POST',
 		    		dataType: 'json',
 		    		data: { imp_uid : rsp.imp_uid, pg_provider : pg_provider }
 			    		//기타 필요한 데이터가 있으면 추가 전달
 		   		 }).done(function(data) {
		    		//[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
		    		if ( everythings_fine ) {
		    			var msg = '결제가 완료되었습니다.';
		    			msg += '\n고유ID : ' + rsp.imp_uid;
		    			msg += '\n상점 거래ID : ' + rsp.merchant_uid;
		    			msg += '\결제 금액 : ' + rsp.paid_amount;
		    			msg += '카드 승인번호 : ' + rsp.apply_num;
		    			
		    			alert(msg);
		    			console.log(rsp);
                
            		} else {
               		 var msg = '결제에 실패하였습니다.';
                	msg += '에러내용 : ' + rsp.error_msg;
                	//[3] 아직 제대로 결제가 되지 않았습니다.
	    			//[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
            		}
         	   });
		    	//성공시 이동할 페이지
		    	location.href='<%=request.getContextPath()%>/pay/success';
		    } else {
		        msg = '결제에 실패하였습니다.';
		        msg += '에러내용 : ' + rsp.error_msg;
		        //실패시 이동할 페이지
		        location.href="<%=request.getContextPath()%>/wishlist";
		        alert(msg);
		    }
        });
    }

	</script>


</body>
</html>