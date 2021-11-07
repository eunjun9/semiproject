<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>매거진 상세 페이지</title>

<!-- 외부 스타일 시트 -->
<link
	href="<%= request.getContextPath() %>/resources/css/magazine/magazineDetail.css"
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




<!--header-->
<%@ include file="/WEB-INF/views/common/header.jsp"%>


<!--body-->
<div class="body-super">
	<div class="body-inner-blue">
		<div class="buttons">
			<div class="back">
				<button><a href="${ contextPath }/magazine/main">back</a></button>
			</div>
			<div class="admin">
				<button>삭제</button>
				<button>수정</button>
				<button type="button" class="report-button"
					onclick="openPopup('Report_popup.html', 'checking', 450, 650)">신고</button>
			</div>

		</div>

		<div class="title">
			<p>${magazine.nTitle }</p>
		</div>

		<div class="write">
			<div class="content-inner">
				<div class="myinfo">
					<div class="myinfo1">
						<div class="profile">
							<img src="../image/pro.jpg">
						</div>
						<div class="id">
							<a href="#">${ magazine.userId }</a>
						</div>
						<div class="date">
							<p><fmt:formatDate value="${ magazine.nDate }"
						type="both" pattern="yyy.MM.dd HH:mm:ss" /></p>
						</div>
					</div>



					<div class="myinfo2">
						<div class="follow">
							<button>팔로워 추가</button>
						</div>
					</div>
				</div>

				<hr class="hr1">

				<h4>
					<span class="title_span">&nbsp;</span> 사진
				</h4>

				<c:forEach items="${ magazine.photoList}" var="photo">
					<div class="photoList">
						<img src="${ contextPath }${photo.route}${photo.changeName}">
						<p>${ photo.originName }</p>
						<p>
					</div>


				</c:forEach>
				<h4>
					<span class="title_span">&nbsp;</span> 내용
				</h4>
				<pre class="content">${ magazine.nContent }</pre>
			</div>
		</div>
	</div>

	
	<div class="comment">
		<div class="comment-title">
			<p>댓글 3</p>
		</div>

		<div class="comment-each">
			<div class="com-front">
				<div class="comment-pro">
					<img src="../image/pro2.png">
				</div>
				
				 <div class="reply_list">
                  <c:forEach items="${ board.replyList }" var="reply">
                     <ul class="reply_ul">
                        <li class="rwriter">${ reply.userName }</li>
                        <li class="rcontent">${ reply.rcontent }</li>
                        <li class="rdate">
                        <fmt:formatDate value="${ reply.createDate }" type="both"
                        pattern="yyyy.MM.dd HH:mm:ss"/>
                        </li>
                     </ul>
                  </c:forEach>
                  </div>
				
				
			</div>
			<div class="admin com-button">
				<button>삭제</button>
				<button>수정</button>
				<button type="button" class="report-button"
					onclick="openPopup('Report_popup.html', 'checking', 450, 650)">신고</button>
			</div>
		</div>
		<div>
			<hr class="hr2">
		</div>

		 <div class="reply_list">
                  <c:forEach items="${ board.replyList }" var="reply">
                     <ul class="reply_ul">
                        <li class="rwriter">${ reply.userName }</li>
                        <li class="rcontent">${ reply.rcontent }</li>
                        <li class="rdate">
                        <fmt:formatDate value="${ reply.createDate }" type="both"
                        pattern="yyyy.MM.dd HH:mm:ss"/>
                        </li>
                     </ul>
                  </c:forEach>
                  </div>


	<!-- <div class="comment-each">
			<div class="com-front">
				<div class="comment-pro">
					<img src="../image/pro2.png">
				</div>
				<div class="comment-info">
					<a href="#">Sodaisthebest</a>
					<p class="com-con">역시 제니님ㅋ 최고예요!</p>
					<p class="com-date">2021.10.30</p>
				</div>
			</div>
			<div class="admin com-button">
				<button>삭제</button>
				<button>수정</button>
				<button type="button" class="report-button"
					onclick="openPopup('Report_popup.html', 'checking', 450, 650)">신고</button>
			</div>
		</div>
		<div>
			<hr class="hr2">
		</div> -->



		<div class="reply_write">
			<textarea class="reply_content"></textarea>
			<button>댓글등록</button>
		</div>


	</div>
</div>



<!--footer-->
<%@ include file="/WEB-INF/views/common/footer.jsp"%>

</div>



<!--게시물 신고 팝업-->
<script>
      function openPopup(url, title, width, height) {
         let left = (document.body.clientWidth / 2) - (width / 2);
         left += window.screenLeft;
         let top = (screen.availHeight / 2) - (height / 2);

         let options = "width=" + width + ",height=" + height + ",left=" + left + ",top=" + top;

         window.open(url, title, options);
      }

   </script>




</body>

</html>