<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>매거진 게시글 작성</title>

<!-- 외부 스타일 시트 -->
<link
	href="<%=request.getContextPath()%>/resources/css/magazine/magazineInsert.css"
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

</head>


<body>

	<!--header-->
	<%@ include file="/WEB-INF/views/common/header.jsp"%>


	<!-- body -->

	<div class="body-super">
		<div class="body-inner">

			<div class="board_content">
				<!-- 
               파일 업로드를 위해서는 반.드.시 enctype을 지정해주어야 함 : 인코딩 타입 지정
               application/x-www-form-urlencoded
               : 기본값, 모든 문자들은 서버로 보내지기 전에 인코딩 됨을 명시
               multipart/form-data
               : 모든 문자들을 인코딩하지 않음을 명시
               이 방식은 form 요소가 파일이나 이미지를 서버로 전송할 때 사용
               text/plain
               : 공백 문자(만)는 "+" 기호로 변환하지만, 나머지 문자는 모두 인코딩 되지 않음을 명시
             -->

				<div class="title-big">
					<div class="title">작성하기</div>
				</div>


				<form method="post" name="insertForm" action="${contextPath }/user/insert" enctype="multipart/form-data">
					<div class="content">
						<h4>
							<span class="title_span">&nbsp;</span> 카테고리
						</h4>
						<span class="input_area"> <select name="category">
								<option value="소셜링">소셜링</option>
								<option value="원데이클래스">원데이클래스</option>
								<option value="VOD">VOD</option>
								<option value="기타">기타</option>
						</select>
						</span>
						<h4>
							<br> <span class="title_span">&nbsp;</span> 제목
						</h4>
						<span class="input_area"> <input type="text" name="title" required>
						</span>

						<h4>
							<br> <span class="title_span">&nbsp;</span> 내용
						</h4>

						<textarea class="textarea" rows="20" cols="100" name="content"
							required></textarea>

						<h4>
							<span class="title_span">&nbsp;</span> 대표 이미지 첨부
						</h4>

						<div class="image_area"></div>

						<div class="filebox">
							 <input class="upload-name" id="file" type="file"
								name="thumbnail" accept="image/gif, image/jpeg, image/png"
								required>
						</div>

						<h4>
							<span class="title_span">&nbsp;</span> 추가 이미지 첨부(최대 3개)
						</h4>

						<div class="image_area"></div>
						<div class="image_area"></div>


						<div class="filebox-par">
							<div class="filebox">
								<input class="upload-name"
									name="contentImg1" id="file" type="file"
									name="thumbnail" accept="image/gif, image/jpeg, image/png">
							</div>
							<div class="filebox">
								<input class="upload-name"
									name="contentImg2" id="file" type="file" 
									name="thumbnail" accept="image/gif, image/jpeg, image/png">
							</div>
							
						</div>

						</div>
						<div class="btn_area">
							<button class="button" type="button" onclick="location.href='${ contextPath }/magazine/main'">목록으로</button>
							<button class="submit" type="submit" onclick="action();">작성하기</button>
							
						</div>
				</form>
			</div>
		</div>
	</div>

	<script src="${ contextPath }/resources/js/imagePreview.js"></script>


	<!-- 라벨로 바꾼거 스크립트-->
	<script>
		$("#file").on('change', function() {
			var fileName = $("#file").val();
			$(".upload-name").val(fileName);
		});
	</script>


	<!--footer-->
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>

</body>

</html>