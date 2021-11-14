<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = (String)request.getAttribute("userId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
<style>
	
	.outer{
		width:90%;
		min-width : 450px;
		margin:auto;
	}
	
	.outer h2 {
		text-align:center;
	}
	
	.changePwd{
		text-align:center;
		font-size:1.35rem;
		font-weight:600;
	}
	
	#updatePwdForm {
		width : 300px;
		margin:auto;
		
	}
	
	.input_area {
	    border: solid 1px #dadada;
	    padding : 10px 10px 14px 10px;
	    background : white;
	}
	
	.input_area input:focus {
		outline: none;
	}
	
	.input_area input{
		width : 270px;
		height : 30px;
		border: 0px;
	}
	
	.btnArea {
		text-align:center;
		padding : 30px;
	}
	
	button:hover {
		cursor:pointer
	}
	
	button {
		width : 100px;
		height : 35px;
		color:black;
		background:#282A35;
		margin : 5px;
		cursor : pointer;
		border: 1px solid #DAEFF5;
		border-radius: 17px;
	    background-color: #DAEFF5;
	    font-size: 1rem;
	    font-weight: 700;
	}
</style>
<%
	if(request.getAttribute("result") != null) {
		// 비밀번호 변경 요청을 수행하고 돌아온 상황일 때 (처음 팝업창을 여는 상황은 result가 null)
		if(request.getAttribute("result").equals("success")) {
			// 비밀번호 변경에 성공
%>
<script>
	alert("성공적으로 비밀번호를 변경하였습니다.");
	window.close();		// 비밀번호 팝업창 닫아줌
</script>
<% } else { // 비밀번호 변경에 실패 %>
<script>
	alert("비밀번호 변경에 실패하였습니다. 다시 확인해주세요.");
</script>
<%		}
	}
%>
</head>
<body>
	<div class="outer">
	<p class="changePwd">비밀번호 변경</p>
	
	<form id="updatePwdForm" action="<%= request.getContextPath() %>/find/update"
	method="post" onsubmit="return checkPwd();">
				<h5>인증번호 입력</h5>
				<span class="input_area">
				<input type="password" name="randomPwd" id="userPwd" maxlength="15">
				</span>
				<h5>변경할 비밀번호</h5>
				<span class="input_area">
				<input type="password" name="newPwd" id="newPwd" maxlength="15">
				</span>
				<h5>변경할 비밀번호 확인</h5>
				<span class="input_area">
				<input type="password" name="newPwd2" id="newPwd2" maxlength="15">
				</span>
				<input type="hidden" name="userId" value="<%= userId %>">
			<div class="btnArea">
			<button id="updatePwdBtn">변경하기</button>
			</div>
	</form>
	</div>
	<script>
		function checkPwd() {
			const newPwd = document.getElementById('newPwd');
			const newPwd2 = document.getElementById('newPwd2');
			
			/* 하나라도 공백으로 입력 시 alert 후  submit 하지 않음 */
			if(newPwd.value == "" || newPwd2.value == "") {
				alert("비밀번호를 입력해주세요.");
				return false;
			}
			
			/* 비밀번호와 비밀번호 확인의 값이 다를 시 alert 후 submit 하지 않음 */
			if(newPwd.value != newPwd2.value){
				alert("비밀번호와 비밀번호 확인이 다릅니다.");
				return false;
			}
			
			return true;
		}
	</script>
</body>
</html>