<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emailLogin</title>

<%-- session에 담긴 message 있을 경우 alert 하는 script --%>
	<% if(session.getAttribute("message") != null) { %>
	<script>
	alert('<%= session.getAttribute("message") %>');
	</script>
	<% 
			session.removeAttribute("message");
		} 
	%>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<!-- 외부 스타일 시트 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/member/loginpage-style.css">
<!-- 외부 폰트 -->
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
</head>
<body>
	<c:set var="contextPath" value="<%=request.getContextPath()%>"></c:set>

	<div class="login-main">

		<div class="login-bar">
			<div class="login-logo center">
				<div class="login-logo center">
					<a href="${ contextPath }"> <img
						src="${ contextPath }/resources/images/logo.png" width="400"></a>
				</div>

				<div class="login-text center">
					<span class="text"> 나의 일상을 더욱 풍성하게<br> 만들어줄 소셜다이닝
					</span>
				</div>

				<div class="loginArea center">
					<form class="login-input" action="${ contextPath }/email/login" method="post">
						<h1>로그인</h1>
						<h4>이메일</h4>
						<span class="input_area">
						<input type="email" id="email" name="email" placeholder="이메일을 입력해주세요." required>
						</span>
						<h4>비밀번호</h4>
						<span class="input_area">
						<input type="password" id="pwd" name="pwd" placeholder="비밀번호를 입력해주세요." required>
						</span>
						
						<div class="login-fail-text" id="login-fail">
						</div>

						<span class="input_area text">
						<input id="login-button text" class="btn" type="submit" value="로그인하기"
						 style='cursor:pointer; border:none;'>
						</span>
					</form>
				</div>

				<div class="login-join-find">
					<div class="login-join">
						<a href="${ contextPath }/memberjoin" class="join-text">회원가입</a>
					</div>
					<div class="login-find">
						<span class="email-find" style='cursor:pointer;'
						onclick="openPopup('${ contextPath }/email/find', 'emailFind', 500, 500);">
						이메일 찾기</span>
						<span class="pwd-find" style='cursor:pointer;'
						onclick="openPopup('${ contextPath }/pwd/find', 'pwdFind', 500, 500);">
						/ 비밀번호 찾기</span>
					</div>

				</div>
				<br>
				<hr width="350px" color="lightgray" size="1px">
				<br>

				<div class="login-button center">
					<div class="login-kakao">
						<button id="kakao-button-ep" class="btn" type="button"
							onclick="kakaoLogin();">
							<span class="img"> <img
								src="${ contextPath }/resources/images/minju/kakao-sm.f3f473d5.svg"
								alt="kakao_icon">
							</span> <span class="kakao-text text">카카오톡으로 5초만에 로그인하기</span>
						</button>
					</div>
					
				</div>
			</div>
		</div>

		<!-- 로그인페이지 우측 이미지 부분 -->
		<div class="login-img"
			style="background-image: url(../resources/images/minju/loginPhoto2.jpg)"></div>



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
                        var userEmail = res.kakao_account.email; // 카카오 email
                        console.log(userEmail);	 				 // 테스트용 콘솔 노출
                        var userName = res.properties.nickname; 	// 카카오 닉네임(이름)
                        console.log(userName);					// 테스트용 콘솔 노출
                        var kakaoId = res.id					// 비밀번호로 사용할 카카오 아이디
                        console.log(kakaoId);					// 테스트용 콘솔 노출
                        
                       var kakaoGender = res.kakao_account.gender;	 // 카카오 성별
                       if( kakaoGender != null) {
                    	   if (kakaoGender == 'female') {
                    		   kakaoGender = kakaoGender.replaceAll(res.kakao_account.gender, "female", "여");
                        } else {
                        	kakaoGender = kakaoGender.replaceAll(res.kakao_account.gender, "male", "남");
                        }
                       }else{
                    	    kakaoGender = "null";
                       }
                       
                        
                        console.log(kakaoGender);
                  

                       $.ajax({
                        url:"${ contextPath }/kakao/login",
                        data:{ "userEmail" : userEmail, "userName" : userName, "kakaoId" : kakaoId, "kakaoGender" : kakaoGender },
                        Type:"post",
                        success:function(data){
                        	location.href="${ contextPath }/mainpage";
                        	console.log("로그인 성공");
                        }
                        
                    });
                       if(Kakao.Auth.getAccessToken()){
                       	// console.log(Kakao.Auth.getAccessToken() + "토큰이 존재합니다.");
                       }
                     Kakao.Auth.setAccessToken(res.access_token);
                  },
    		     
                  fail: function (error) {
                	  // 카카오 로그인 실패 시 alert 창
                	  alert('로그인에 실패하였습니다.');
                  },
                })
              },
              fail: function (error) {
            	  location.href="${ contextPath }/errorpage";
              },
            })
          }
     
        </script>
        
	     

</body>
</html>