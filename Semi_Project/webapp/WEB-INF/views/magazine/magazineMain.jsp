<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>매거진 메인</title>

<!-- 외부 스타일 시트 -->
<link
	href="<%= request.getContextPath() %>/resources/css/magazine/magazineMain.css"
	rel="stylesheet">

<!-- favicon (Real Favicon Generator)-->
<link rel="icon" type="image/x-icon"
	href="resources/image/khfavicon.ico">

<!-- 글꼴 -->
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
<!--font-family: 'Noto Sans KR', sans-serif;-->

<!-- JQuery-->
<script src="../js/jquery-3.6.0.min.js"></script>

<!--슬라이드-->
<link rel="stylesheet"
	href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<style>
.swiper {
	width: 800px;
	height: 250px;
}
</style>


</head>

<body>
	<!--header-->

	<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<!--body-->

	<div class="board">
		<div class="board-inner">
			<div class="magazine"
				style="background-image: url(../resources/images/yeonjoo/turkey.jpg)">
				<div class="title">매거진</div>
				<div class="word">
					자신만의 스토리와 철학을 가진<br> 다양한 사람들의 다양한 이야기
				</div>
			</div>
		</div>
	</div>


	<!--슬라이드1-->

	<div class="first">
		<div class="title">
			<div class="title-inner">
				<div class="tit">
					<div class="b-title">다른 이들과 나누는 우리들의 이야기! 모임 후기 게시판</div>
					<div class="view1">
						<a href="<%= request.getContextPath() %>/magazine/user">전체보기</a> 
						<c:if test="${ !empty loginUser }">
						<a href="<%= request.getContextPath() %>/magazine/insert">글쓰기</a>
						</c:if>
					</div>
				</div>
			</div>
		</div>


		<!-- Swiper -->
		<div class="slide1">

			<div class="swiper mySwiper1">
				<div class="swiper-wrapper">


					<c:forEach var="magazine" items="${ magazineList }">
						<div class="swiper-slide">
							<ul class="board_list">
								<div class="box">
									<div class="pics" onclick="detailView(${ magazine.nNum })">
										<img src=${ contextPath }${ magazine.photoList.get(0).route }${ magazine.photoList.get(0).changeName }>
										<p class="category">[${ magazine.nType }]</p>
										<p class="list-title">${ magazine.nTitle }</p>
										<br>
									</div>
									<div class="writer-par">
										<a href="#" class="writer">${ magazine.userId }</a>
									</div>
								</div>
							</ul>
						</div>
					</c:forEach>
				</div>
			</div>


			<div class=button1>
				<!-- If we need navigation buttons -->
				<div class="swiper-button-prev but1"></div>
			</div>

			<div class=button2>
				<div class="swiper-button-next but2"></div>
			</div>

		</div>
	</div>

	<!-- Initialize Swiper -->
	<script>
    var swiper1 = new Swiper(".mySwiper1", {
      slidesPerView: 3,
      spaceBetween: 30,

      loop: true,

      // Navigation arrows
      navigation: {
        nextEl: '.but1',
        prevEl: '.but2',
      },

    });
  </script>




	<!--슬라이드2-->
	<div class="second">
		<div class="title">
			<div class="title-inner">
				<div class="tit">
					<div class="b-title">소다만의 STORY를 공개합니다</div>
					<div class="view1">
						<a href="#">전체보기</a>
						<c:if test="${ !empty loginUser && userId == 'y7230_@naver.com'}">
						<a href="<%= request.getContextPath() %>/magazine/insert">글쓰기</a>
						</c:if>
					</div>
				</div>

			</div>
		</div>


		<!-- Swiper -->
		<div class="slide2">
			<div class="swiper mySwiper2">
				<div class="swiper-wrapper">
					<div class="swiper-slide">
						<img
							src="<%= request.getContextPath() %>/resources/images/yeonjoo/white.jpg">
						<div class=all-title>
							<a href="#" class=first-title>요알못, 요리왕으로 거듭나다</a><br> <a
								href="#" class=name>SODA</a>
						</div>
					</div>
					


				</div>
			</div>

			<div class=button3>
				<!-- If we need navigation buttons -->
				<div class="swiper-button-prev but3"></div>
			</div>

			<div class=button4>
				<div class="swiper-button-next but4"></div>
			</div>

		</div>
	</div>
	<!-- Initialize Swiper -->
	<script>
    var swiper2 = new Swiper(".mySwiper2", {
      slidesPerView: 3,
      spaceBetween: 30,

      loop: true,

      // Navigation arrows
      navigation: {
        nextEl: '.but3',
        prevEl: '.but4',
      },
    });
  </script>


	<!--슬라이드-->

	<div class="third">
		<div class="title">
			<div class="title-inner">
				<div class="tit">
					<div class="b-title">내 팔로워는 지금 뭘 하고 있을까? 팔로워 게시판</div>
					<div class="view1">
						<a href="#">전체보기</a>
					</div>
				</div>
			</div>
		</div>


		<!-- Swiper -->
		<div class="slide3">
			<div class="swiper mySwiper3">
				<div class="swiper-wrapper">
					<div class="swiper-slide">
						<img
							src="<%= request.getContextPath() %>/resources/images/yeonjoo/white.jpg">
						<div class=all-title>
							<a href="#" class=first-title>퍼퓸 클래스 후기</a><br> <a href="#"
								class=name>perfume1004</a>
						</div>
					</div>
					<div class="swiper-slide">
						<img
							src="<%= request.getContextPath() %>/resources/images/yeonjoo/white.jpg">
						<div class=all-title>
							<a href="#" class=first-title>이태원 핫플, brewery</a><br> <a
								href="#" class=name>itawonzzang</a>
						</div>
					</div>
					<div class="swiper-slide">
						<img
							src="<%= request.getContextPath() %>/resources/images/yeonjoo/white.jpg">
						<div class=all-title>
							<a href="#" class=first-title>경기 광주 숨은 맛집 탐방</a><br> <a
								href="#" class=name>SODA</a>
						</div>
					</div>
					<div class="swiper-slide">
						<img
							src="<%= request.getContextPath() %>/resources/images/yeonjoo/white.jpg">
						<div class=all-title>
							<a href="#" class=first-title>할 수 있다! 번지점프</a><br> <a
								href="#" class=name>SODA</a>
						</div>
					</div>

				</div>
			</div>

			<div class=button5>
				<!-- If we need navigation buttons -->
				<div class="swiper-button-prev but5"></div>
			</div>

			<div class=button6>
				<div class="swiper-button-next but6"></div>
			</div>
		</div>
	</div>

	<!-- Initialize Swiper -->
	<script>
    var swiper3 = new Swiper(".mySwiper3", {
      slidesPerView: 3,
      spaceBetween: 30,

      loop: true,


      // Navigation arrows
      navigation: {
        nextEl: '.but5',
        prevEl: '.but6',
      },
    });
  </script>



	</div>


	<script>
   		function detailView(nNum){
   			location.href = '${contextPath}/magazine/detail?nNum=' + nNum;
   		}
   
   </script>

	<!--footer-->
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>


</body>

</html>