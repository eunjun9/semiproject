<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emailLogin</title>
<!-- 외부 스타일 시트 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/loginpage-style.css">
<!-- 외부 폰트 -->
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
</head>
<body>
<c:set var="contextPath" value="<%= request.getContextPath()%>"></c:set>  

	<div class="login-main">

		<div class="login-bar">
			<div class="login-logo center">
				<div class="login-logo center">
					<a href="${ contextPath }">
					<img src="${ contextPath }/resources/images/logo.png" width="400"></a>
				</div>
			
			<div class="login-text center">
				<span class="text"> 나의 일상을 더욱 풍성하게<br> 만들어줄 소셜다이닝
				</span>
			</div>

			<div class="loginArea center">
				<form class="login-input" action="${ contextPath }/login" method="post">
					<h1>로그인</h1>
					<h4>이메일</h4>
					<input type="email" id="email" name="email" placeholder="이메일을 입력해주세요." required>
					<h4>비밀번호</h4>
					<input type="password" id="pwd" name="pwd" placeholder="비밀번호를 입력해주세요." required>
				</form>
				<div class="login-fail-text" id="login-fail">
					<!-- 로그인 실패 시 텍스트 출력 부분 -->
				</div>

				<span class="button-text text">
				<input id="login-button text" class="btn" type="submit">로그인하기
				</span>

			</div>

			<div class="login-join-find">
				<div class="login-join">
					<a href="${ contextPath }/memberJoin"
						class="join-text">회원가입</a>
				</div>
				<div class="login-find">
					<a href="${ contextPath }/emailFind" class="email-find" 
					onclick="openPopup('${ contextPath }/emailFind', 'emailFind', 500, 500);">이메일 찾기</a>
					<a href="${ contextPath }/pwdFind" class="pwd-find" 
					onclick="openPopup('${ contextPath }/pwdFind', 'pwdFind', 500, 500);">/
						비밀번호 찾기</a>
				</div>

			</div>
			<br>
			<hr width="350px" color="lightgray" size="1px">
			<br>

			<div class="login-button center">
				<div class="login-kakao">
					<button id="kakao-button" class="btn" type="button"
						onclick="kakaoLogin();">
						<span class="img">
						<img src="${ contextPath }/resources/image/kakao-sm.f3f473d5.svg" alt="kakao_icon">
						</span> <span class="kakao-text text">카카오톡으로 5초만에 로그인하기</span>
					</button>
				</div>
			</div>


			<div class="login-img"></div>

		</div>
</div>
</div>
		<script>
            function openPopup(url, title, width, height) {
                var left = (document.body.clientWidth/2)-(width/2);
                left += window.screenLeft;	// 듀얼 모니터
                var top = (screen.availHeight/2)-(height/2);
                
                var options = "width="+width+",height="+height+",left="+left+",top="+top;
                
                window.open(url, title, options);
             }
        </script>


	<!-- 카카오로그인 api -->
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>

	<script>
        Kakao.init('10762705b6719eedabb3e0dcab4cb83d'); // 카카오에서 발급받은 JavaScript 키 (초기화 함수 호출)
        console.log(Kakao.isInitialized()); // sdk초기화여부판단 (초기화 잘 됐는지 확인하는 함수)

        //카카오로그인
        function kakaoLogin() {
            Kakao.Auth.login({
              success: function (res) {
                Kakao.API.request({
                  url: '/v2/user/me',
                  success: function (res) {
                      console.log(res);

                        var userEmail = res.kakao_account.email; //email
                        console.log(userEmail);

                         $.ajax({
                        url:"${ contextPath }/kakaoLogin",
                        data:{ "id" : res.id, "name" : JSON.stringify(res.properties.nickname)},
                        Type:"post",
                        success:function(data){
                            location.href="${ contextPath }";
                        }
                        
                    });
                    
                  },
    		     
                  fail: function (error) {
                    console.log(error)
                  },
                })
              },
              fail: function (error) {
                console.log(error)
              },
            })
          }
        //카카오로그아웃  
        function kakaoLogout() {
            if (Kakao.Auth.getAccessToken()) {
              Kakao.API.request({
                url: '/v1/user/unlink',
                success: function (res) {
                    console.log(res)
                },
                fail: function (error) {
                  console.log(error)
                },
              })
              Kakao.Auth.setAccessToken(undefined)
            }
          }  
        </script>
        
        
        <!-- 로그인 실패 시 로그인창 하단에 텍스트 노출 -->
        <script>
        	$(function(){
        		$("#login-button").click(function(){
        			$.ajax({
        				url : "${ contextPath }/login",
        				data : { userId : $("#email").val(), userPwd : $("#pwd").val()  },
        				type : "post",
        				success : function(user) {
        					console.log("success!");
        					},
        				error : function(e){
        					$("#login-fail").val(e.responseText);
        				}
        			});
        		});
        	});
        </script>
</body>
</html>