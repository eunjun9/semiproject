<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginPage</title>
	<!-- 외부 스타일시트 -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/loginpage-style.css">
    <!-- 외부 폰트 -->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
</head>
<body>
<div class="login-main">
        <div class="login-bar">
            <div class="login-logo center">
                    <a href="#">
                        <div class="logo"><img src="resources/image/logo.png" width="400"></div>
                    </a>
            </div>
                    <div class="login-text center">
                    <span class="text"> 나의 일상을 더욱 풍성하게<br>
                    만들어줄 소셜다이닝</span>
                    </div>

                    <div class="login-button center">
                        <div class="login-kakao">
                        <button id="kakao-button" class="btn" type="button" onclick="kakaoLogin()">
                        <span class="img">
                            <img src="resources/image/kakao-sm.f3f473d5.svg" alt="kakao_icon">
                        </span>
                        <span class="kakao-text text">카카오톡으로 5초만에 로그인하기</span>
                        </button>
                        </div>

                    <div class="login-email">
                        <a href="../loginPage/emailLogin.html" id="email-button" class="btn">
                        <span class="email-text text">이메일로 로그인하기</span>
                        </a>
                    </div>
                    </div>

        </div>

            <div class="login-img">
            </div>

    </div>
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

                        // 경로 생성하고 수정할 예정
                       /*  $.ajax({
                        url:"<%=request.getContextPath()%>/member/kakaoLogin",
                        data:{ "id" : res.id, "name" : JSON.stringify(res.properties.nickname)},
                        Type:"post",
                        success:function(data){
                            location.href="<%=request.getContextPath()%>/";
                        }
                        
                    }); */
                    
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

</body>
</html>