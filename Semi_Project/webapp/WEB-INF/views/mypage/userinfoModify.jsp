<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="com.soda.member.model.vo.Member"%>


<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보수정 페이지</title>

    <%-- session에 담긴 message 있을 경우 alert 하는 script --%>
	<% if(session.getAttribute("message") != null) { %>
	<script>
	alert('<%= session.getAttribute("message") %>');
	</script>
	<% 
			session.removeAttribute("message");
		} 
	%>
    
    <!-- 외부 스타일 시트 -->
    
    <link href="resources/css/mypage/mypage_userinfoModify.css" rel="stylesheet">
   
    <!-- favicon (Real Favicon Generator)-->
    <link rel="icon" type="image/x-icon" href="resources/image/khfavicon.ico">
    <!-- 글꼴 -->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <!--font-family: 'Noto Sans KR', sans-serif;-->
    <!-- JQuery-->
    <script src="../js/jquery-3.6.0.min.js"></script>

	<style>
		/* 배너 */
.board {
    width: 100%;
    display: flex;
 }
 
 .board-inner {
     max-width: 1000px;
     margin : 0 auto;
 }

 *{
    box-sizing: border-box;
   
}

div{
    display: block;
}

.joinInfoArea{
    max-width: 400px;
    width: 100%;
    padding-right: 0;
    padding-left: 0;
    margin-left: 38%;
    margin-bottom: 3rem!important;
    
}



form{
    display: block;
    margin-top: 0em;
}

body{
    margin: 0;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: #212529;
    text-align: left;
    background-color: #fff;
}
 
html{
    -webkit-text-size-adjust: 100%;
    -webkit-tap-highlight-color: transparent;
}

body, html{
    font-family: Noto Sans KR;
    letter-spacing: -.4px;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    text-align: left;
}

.firstjoin{
    font-size: 1.5rem;
    font-weight: 500px;
    margin-left: 60px;
    
}

.common-form{
    position: relative;
    width: 400px;
    height: 100%;
    min-height: 1px;
    padding-right: 0;
    padding-left: 0;
    margin-left: 50px;
    margin-bottom: .5rem!important;
    flex: 0 0 100%;
    max-width: 100%;
    display: block;
    
}

#idCheck{
    margin-left: 5px;
}

.form-group{
    margin-bottom: 0;
    margin: 0;
}

.form-label{
    font-size: 13px;
    color: #000;
    font-weight: 500;
    font-stretch: normal;
    font-style: normal;
    line-height: 1.54;
    letter-spacing: -.31px;
    margin-bottom: .25rem!important;
    width: 100px;
    font-size: 0.9rem;
    
}

.form-control{
    border-radius: 5px;
    width: 270px;
    height: 35px;
    border: 1px solid lightgray;
}

.form-check{
    position: relative;
    display: block;
    padding-left: 1.25rem;
}

.form-check-input{
    position: absolute;
    margin-top: .3rem;
    margin-left: -1.25rem;
    overflow: visible;
    display: flex;
}

#pwdUpdateBtn{
    border-radius: 3px;
    margin-left: 5px;
}

#btn-modify{
    width: 100px;
    margin-top: 25px;
    margin-left: 52px;
    padding: 9px;
    border-radius: 20px;
    border: 1px solid #DAEFF5;
    background-color: #DAEFF5;
    font-size: 1rem;
    font-weight: 700;
}

#btn-delete{
    width: 100px;
    margin-top: 30px;
    margin-left: 12px;
    padding: 9px;
    border-radius: 20px;
    border: 1px solid red;
    background-color: red;
    font-size: 1rem;
    font-weight: 700;
}
	</style>


</head>

<body>
	

    <!--header-->
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
   

    <div class="joinInfoArea" id="register_row">
        <form id="register_form" action="<%= request.getContextPath() %>/mypage/userinfomodify"
        method="post" onsubmit="return validate();">
            <div class="common-form title">
                <p class="firstjoin">회원 정보 수정</p>
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
            
                <div class="form-check"> 
                    <button id="btn-modify">수정하기</button>
                    <button id="btn-delete" type="button"
					onclick="confirmAccountDelete();">탈퇴하기</button>
                </div>
            </div> 
        </form>
    </div>
	
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
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
	
</body>

</html>