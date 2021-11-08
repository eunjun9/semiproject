<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<!-- 외부 스타일 시트 -->
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/order/wishlist-style.css?1">
<!-- 외부 폰트 -->
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
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
			<ul>
				<li class="class-info text"> 클래스 정보 </li>
				<li class="class-date text"> 날짜/기한 </li>
				<li class="class-price text"> 가격 </li>
			</ul>
			<hr>
		</div>

		<c:forEach var="wishList" items="${ wishList }">
		<form name="classForm" action="${ contextPath }/payment" method="post">
		<div class="wish-class" id="wish-class">
			<div class="wish-content">

				<!-- 체크박스 -->
				<div class="class-checkbox">
					<input type="checkbox" class="order-check" id="order1" name="checkClass" value="${ wishList.wishNum }">
				</div>
				
				<!-- 클래스 썸네일 이미지 / 클래스 등록하기 완료되면 수정할 예정 -->
				<div class="wish-class img">
				<img src="#" width="200px" height="150px">
					<!--  <img src="${ contextPath }${ wishList.route }${ wishList.changeName }"
						width="200px" height="150px"> -->
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
					<p class="date">${ wishList.cTime1 }</p>
				</div>
			</c:when>
			<c:when test="${ wishList.cCategory eq '원데이' }">
				<div class="wish-class-date">
					<p class="date"><fmt:formatDate value="${ wishList.cSDate }" pattern="yyyy/MM/dd" /><br>
					${ wishList.cTime1 } ~ ${ wishList.cTime2 }</p>
				</div>
			</c:when>
			</c:choose>

			
			<div class="wish-class-price">
				<p class="price"><fmt:formatNumber value="${ wishList.cPrice }" pattern="#,###"/></p>
			</div>
			
			
			<!-- 신청하기(결제페이지로 이동) 버튼 -->
			<div class="wish-class-btn">
				<button type="button" class="order-button" type="submit">신청하기</button>
			</div>
			<hr class="hr-line">
		</div>
		</form>
	</c:forEach>

	
	
	<!-- 클래스 선택버튼 -->
	<div class="wish-content-foot">

		<div class="class-checkbox-btn">
			<div class="checkbox-btn">
				<button type="button" name="order" class="check-btn" onclick="checkAll();">전체선택</button>
				<button type="button" name="order" class="check-btn2" onclick="checkDelete();">선택삭제</button>
			</div>

	<!-- 장바구니 총 합계 -->
	<div class="class-total-pay">
			<div class="total">장바구니 총 합계 금액</div>
			<div class="totalPay"><fmt:formatNumber value="${ totalPrice }" pattern="###,###,###" /></div>
			<div class="total">원</div>
	</div>
			

		</div>
		<hr class="hr-line">

		<!-- 이전으로 가기 버튼 -->
		<div class="wish-footer">
			<div class="back-btn">
				<input type="button" id="back-button" class="back" onclick="back()" value="이전으로">
				<br>
			</div>
		</div>
	</div>

	<!-- 푸터 가져오기 -->
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
	
	
	<script>
		<!-- 전체 선택 버튼 클릭 -->
		function checkAll() {
			$("input[name=checkClass]").prop("checked", true);
		}
		
	</script>
	
	<script>
		<!-- 선택된 체크박스 클래스 삭제 -->
		function checkDelete() {
			var checkArr = [];
			// 선택된 체크박스 값 반복문으로 배열에 push
			$("input:checkbox[name='checkClass']:checked").each(function(){
				checkArr.push($(this).val());
				console.log(checkArr);
			});
			
				if( checkArr.length == 0 ){
					alert('선택된 클래스가 없습니다.');
				}else{
					var chk = confirm("정말 삭제하시겠습니까?");
					$.ajax({
						url : "${ contextPath }/wishlist/delete",
						type : "post",
						data : { checkArr : checkArr },
						traditional : true,					// 배열 넘겨줄 때 꼭 작성해야함
						success : function(result){
							if(result > 0){
								alert('삭제되었습니다.');
								location.replace("${ contextPath }/wishlist");
							}else{
								alert('삭제에 실패했습니다.');
						}
					}
				});
			}
		}
	</script>
	
	<script>
	function back(){
		history.back();
	}
	</script>
	

</div>
</body>
</html>