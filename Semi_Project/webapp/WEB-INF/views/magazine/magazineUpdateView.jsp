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
					<div class="title">게시글 수정</div>
				</div>


				<form method="post" name="insertForm" enctype="multipart/form-data"
					action="${contextPath}/magazine/update">
				<input type ="hidden" name="nNum" value="${magazine.nNum}">
				<c:forEach items="${magazine.photoList }" var="photo">
				<input type="hidden" name="changeName" value="${ photo.changeName }">
				</c:forEach>	
					
					
					<div class="content">
						<h4>
							<span class="title_span">&nbsp;</span> 카테고리
						</h4>
						<span class="input_area"> <select name="category">
								<option value="소셜링"
									<c:if test="${magzine.nType=='소셜링'}">selected</c:if>>소셜링</option>
								<option value="원데이클래스"
									<c:if test="${magzine.nType=='원데이클래스'}">selected</c:if>>원데이클래스</option>
								<option value="VOD"
									<c:if test="${magzine.nType=='VOD'}">selected</c:if>>VOD</option>
								<option value="기타"
									<c:if test="${magzine.nType=='기타'}">selected</c:if>>기타</option>
						</select>
						</span>
						<h4>
							<br> <span class="title_span">&nbsp;</span> 제목 수정
						</h4>
						<span class="input_area"> <input type="text" name="title"
							value="${magazine.nTitle }" required>
						</span>

						<h4>
							<br> <span class="title_span">&nbsp;</span> 내용 수정
						</h4>

						<textarea class="textarea" rows="20" cols="100" name="content" required>${magazine.nContent }</textarea>

						<h4>
							<span class="title_span">&nbsp;</span> 대표 이미지 수정
						</h4>

						<div class="image_area">
							<img
								src="${ contextPath }${ magazine.photoList.get(0).route }${magazine.photoList.get(0).changeName }">
						</div>

						수정 파일 : <input type="file" name="thumbnail" accept="image/gif,image/jpeg,image/png">

						<h4>
							<span class="title_span">&nbsp;</span> 추가 이미지 수정(최대 2개)
						</h4>

						<div class="image_area">
							<c:if test="${ magazine.photoList.size() > 2 }">
								<img
									src="${ contextPath }${ magazine.photoList.get(1).route }${magazine.photoList.get(1).changeName }">
							</c:if>
						</div>


						수정 파일 : <input type="file" name="contentImg1" accept="image/gif,image/jpeg,image/png"> 


						<div class="image_area">
							<c:if test="${ magazine.photoList.size() > 2 }">
								<img
									src="${ contextPath }${ magazine.photoList.get(2).route }${magazine.photoList.get(2).changeName }">
							</c:if>
						</div>


						수정 파일 : <input type="file" name="contentImg2" accept="image/gif,image/jpeg,image/png"> 

					</div>

					<div class="btn_area">
						<button class="button" type="button" onclick="location.href='${ contextPath }/magazine/main'">목록으로</button>
						<button class="submit" type="submit" onclick="action();">작성하기</button>

					</div>
			
			</form>
			</div>

		</div>
	</div>
	</div>

	<script src="${ contextPath }/resources/js/imagePreview.js"></script>


	<!--footer-->
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>

</body>

</html>