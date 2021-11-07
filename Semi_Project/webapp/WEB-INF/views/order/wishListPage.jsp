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
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/order/wishlist-style.css">
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

		<c:forEach var="wishlist" items="${ wishlist }">
		<form name="classForm" action="${ contextPath }/payment" method="post">
		<div class="wish-class" id="wish-class">
			<div class="wish-content">

				<!-- 체크박스 -->
				<div class="class-checkbox">
					<input type="checkbox" class="order-check" id="order1" name="checkClass">
				</div>
				
				<!-- 클래스 썸네일 이미지 -->
				<div class="wish-class img">
					<img src="${ contextPath }${ wishlist.photoList.get(0).filePath }${ wishlist.photoList.get(0).changeName }"
						width="200px" height="150px">
				</div>
			</div>

			<!-- 장바구니 추가한 클래스 정보 가져올 영역 -->
			<div class="wish-class-info">
				<p class="category">${ wishlist.ccategory }</p>
				<p class="title">${ wishlist.ntitle }</p>
			</div>
			
			<c:choose>
			<c:when test="${ wishlist.ccategory eq 'vod' }">
				<div class="wish-class-date">
					<p class="date">${ wishlist.ctime1 } ~ ${ wishlist.ctime2 }</p>
				</div>
			</c:when>
			<c:when test="${ wishlist.ccategory eq '원데이' }">
				<div class="wish-class-date">
					<p class="date">${ wishlist.csdate } ~ ${ wishlist.cedate }</p>
				</div>
			</c:when>
			</c:choose>

			<div class="wish-class-price">
				<p class="price">${ wishlist.cprice }</p>
			</div>

			<!-- 신청하기(결제페이지로 이동) 버튼 -->
			<div class="wish-class-btn">
				<button type="button" class="order-button" type="submit">신청하기</button>
			</div>
			<hr class="hr-line">
		</div>
		</form>
	</c:forEach>
	
	
	<!-- 선택버튼 / 총결제금액 표시 부분 -->
	<div class="wish-content-foot">

		<div class="class-checkbox-btn">
			<div class="checkbox-btn">
				<button type="button" name="order" class="check-btn" onclick="checkAll();">전체선택</button>
				<button type="button" name="order" class="check-btn2" onclick="checkDelete();">선택삭제</button>
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
			var arr = new Array();
			var list = $("input[name=checkClass]");
			for(var i = 0; i < list.length; i++){
				if(list[i].checked) {
					arr.push(list[i].value);
				}
			}
			if( arr.length == 0 ){
				alert('선택된 클래스가 없습니다.');
			}else{
				var chk = confirm("정말 삭제하시겠습니까?");
				$.ajax({
					url : "${ contextPath }/wishlist/delete",
					type : 'post',
					data : { arr : arr },
					success : function(result){
						if(result = 1){
							alert('삭제 완료');
							location.replace("${ contextPath }/wishlist");
						}else{
							alert('삭제 실패');
						}
					}
				});
			}
		}
	</script>
	

</div>
</body>
</html>