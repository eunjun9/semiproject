<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
  
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보수정 페이지</title>

    
    <!-- 외부 스타일 시트 -->
    <link href="resources/css/mypage_userinfomodify.css" rel="stylesheet">
    <!-- favicon (Real Favicon Generator)-->
    <link rel="icon" type="image/x-icon" href="resources/image/khfavicon.ico">
    <!-- 글꼴 -->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <!--font-family: 'Noto Sans KR', sans-serif;-->
    <!-- JQuery-->
    <script src="../js/jquery-3.6.0.min.js"></script>




</head>

<body>

	<%@ include file="/WEB-INF/views/main/mainpage.jsp" %>

    <!--header-->

    <div class="header">
        <div class="head-inner">

          <div class="logo">
            <img src="resources/images/logo.png">
          </div>

            <div class="big-category">
                <div class="category1">
                    <a href="#">SOCIALING</a>
                    <a href="#">CLASS</a>
                    <a href="#">MAGAZINE</a>
                </div>
                <div class="category2">
                    <a href="#">CART</a>
                    <a href="#">MYPAGE</a>
                </div>
            </div>

        </div>
    </div>

    <div class="joinInfoArea" id="register_row">
        <form id="register_form" action="<%= request.getContextPath() %>/mypage/userinfomodify"
        method="post" onsubmit="return validate();">
            <div class="common-form title">
                <h2 class="firstjoin">회원 정보 수정</h2>
            </div>
            <div class="common-form">
                <div class="form-group">
                    <label class="form-label">이메일</label><br>
                    <input class="form-control" id="email" type="email" name="userId" 
                    maxlength="30" placeholder="이메일을 입력해주세요" size="25" value="<%= loginUser.getUserId() %>" readonly>
                </div>
            </div>
            <div class="common-form">
                <div class="form-group">
                    <label class="form-label">비밀번호</label><br>
                    <input class="form-control" id="password" type="password" name="userPwd" 
                    maxlength="20" size="25" readonly>
                    <button id="pwdUpdateBtn" type="button" 
	                onclick = "openPopup('<%= request.getContextPath() %>/pwdModify', 'pwdModify', 500, 500);">비밀번호 변경</button>
                </div>
            </div>
        
            <div class="common-form">
                <div class="form-group">
                    <label class="form-label">이름</label><br>
                    <input class="form-control" id="name" type="text" name="userName" 
                    placeholder="이름을 입력해주세요" size="25" value="<%= loginUser.getUserName() %>" required>
                </div>
            </div>
            <div class="common-form">
                <div class="form-group">
                    <label class="form-label">연락처</label><br>
                    <input class="form-control" id="phone_num" type="text" name="userPhone" 
                    placeholder="전화번호를 입력해주세요" size="25" value="<%= loginUser.getUserPhone() != null ? loginUser.getUserPhone() : "" %>">
                </div>
            </div>
            <div class="common-form"> 
                <div class="form-group"> 
                    <label class="form-label">성별</label> 
                    <div class="row" id="gender_box"> 
                        <label for="male">남자</label>&nbsp;
                        <input type="radio" id="female" name="gender" value="M" checked>&nbsp;&nbsp;&nbsp;
                        <label for="female">여자</label>&nbsp; 
                        <input type="radio" id="female" name="gender" value="F" checked>

                    </div> 
                </div> 
            </div>
                <div class="form-check"> 
                    <button id="btn-modify">수정하기</button>
                    <button id="btn-delete" type="button"
					onclick="confirmAccountDelete();">탈퇴하기</button>
                </div>
            </div> 
        </form>
    </div>
    
    <!-- jQuery와 Postcodify를 로딩한다 -->
	<!-- api 주소 연결 -->
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	
	<!-- "검색" 단추를 누르면 팝업 레이어가 열리도록 설정한다 -->
	<script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>
	
	<script>
		// 일단 생략 (서버로 제출하기 전에 유효성 검사를 하는데 자바스크립트에서 하니까 여기서는 넘어감) -> 우리가 자바스크립로 알아서 구현해라
		// 사용자 입력 값 유효성 검사용 함수
		function validate(){
			// 알맞은 값 입력 시 넘어가게 js로 구현
			return true;
		}
	
	// 비밀번호 변경 팝업창 호출
	function openPopup(url, title, width, height) {
		
		var left = (document.body.clientWidth/2) - (width/2);
		left += window.screenLeft;	// 듀얼 모니터
		// clientWidth : 듀얼 모니터 사용 시 주 모니터 확인
		var top = (screen.availHeight/2) - (height/2);
		
		var options = "width="+width+",height="+height+",left="+left+",top="+top;
		// 문자열로 합쳐서 보냄
			
		window.open(url, title, options);
		// 팝업창 열 때 (주소, 팝업창 이름, 속성값 문자열)
	}
	
	function confirmAccountDelete() {
		if(confirm("정말로 탈퇴하시겠습니까?"))
			// confirm : 확인 취소 버튼 달린 확인 메세지창
			// location : 새로운 페이지로 이동되는 기능 (객체 속성)
			location.href='<%= request.getContextPath() %>/accountDelete';
	}
	</script>


    <!--footer-->
    <div class="footer">
        <div class="foot-inner">
            <div class="foot-logo foot-all">
                S O D A</div>
            <div class="information foot-all">
                <ul>주식회사 소셜 다이닝</ul>
                <ul>대표 : 홍길동 | 개인정보관리책임자 : 홍길동 | 전화 : 02-123-4567 | 이메일 : soda@gmail.com</ul>
                <ul>주소 : 서울 강남구 테헤란로 14길 6 남도빌딩 2층 | 사업자등록번호 : 000-00-00000</ul>
                <ul> 통신판매 : 제 2021-서울강남-0000호</ul>
                <ul>영업시간 : 월-금 오후 2시-7시</ul>
            </div>
            <div class="foot-category foot-all">
                <ul><a href="#">소다소개</a></ul>
                <ul><a href="#">공지사항 </a></ul>
                <ul><a href="#">강사신청</a></ul>
                <ul><a href="#">자주묻는질문</a></ul>
            </div>


        </div>
    </div>
    <div class="final">
        <div class="foot-final">
            <a href="#">이용약관 | </a>
            <a href="#">개인정보처리방침 | </a>
            <a href="#">사업자정보확인</a>
        </div>
    </div>
</body>

</html>