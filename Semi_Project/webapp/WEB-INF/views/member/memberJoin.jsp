<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입페이지</title>

    
    <!-- 외부 스타일 시트 -->
    <link href="resources/css/member/memberjoin.css" rel="stylesheet">
    <link href="resources/css/common/header_footer.css" rel="stylesheet">
    <!-- favicon (Real Favicon Generator)-->
    <link rel="icon" type="image/x-icon" href="resources/image/khfavicon.ico">
    <!-- 글꼴 -->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <!--font-family: 'Noto Sans KR', sans-serif;-->
    <!-- JQuery-->
    <script src="../js/jquery-3.6.0.min.js"></script>


</head>

<body>
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
        <form id="register_form" action="<%= request.getContextPath() %>/memberjoin" method="post" onsubmit="return validate();">
            <div class="common-form title">
                <h2 class="firstjoin">회원가입</h2>
            </div>
            <div class="common-form">
                <div class="form-group">
                    <label class="form-label">이메일</label><br>
                    <input class="form-control" id="email" type="email" name="userId" 
                    maxlength="30" placeholder="이메일을 입력해주세요" size="25" required>
                    <button id="idCheck" type="button"> 중복 확인 </button>
                </div>
            </div>
            <div class="common-form">
                <div class="form-group">
                    <label class="form-label">비밀번호</label><br>
                    <input class="form-control" id="password" type="password" name="userPwd" 
                    maxlength="20" size="25" required>
                </div>
            </div>
            <div class="common-form">
                <div class="form-group">
                    <label class="form-label">비밀번호 확인</label><br>
                    <input class="form-control" id="password_check" type="password" name="userPwd2" 
                    maxlength="20" placeholder="비밀번호를 다시 입력해주세요" size="25" required>
                </div>
            </div>
            <div class="common-form">
                <div class="form-group">
                    <label class="form-label">이름</label><br>
                    <input class="form-control" id="name" type="text" name="userName" 
                    placeholder="이름을 입력해주세요" size="25">
                </div>
            </div>
            <div class="common-form">
                <div class="form-group">
                    <label class="form-label">연락처</label><br>
                    <input class="form-control" id="phone_num" type="text" name="userPhone" 
                    placeholder="전화번호를 입력해주세요" size="25">
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
            <div class="common-form" id="agree"> 
                <div class="form-check mb-2"> 
                    <input class="form-check-input" type="checkbox" name="n_agree" id="n_agree" value="체크"> 
                    <label class="form-check-label" for="n_agree"> [필수] 
                        <a class="link" href="<%= request.getContextPath() %>/joincheck">이용약관</a>과 <a class="link" href="<%= request.getContextPath() %>/joincheck">개인정보처리방침</a>에 동의 
                    </label> 
                </div> 
                <div class="form-check"> 
                    <input class="form-check-input" type="checkbox" name="m_agree" id="m_agree"> 
                    <label class="form-check-label" for="m_agree"> [선택] 마케팅 정보 수신에 동의<br> 
                        <small> 마케팅 정보 수신에 동의하시면, 소다 신규 모임 알림/ <br>
					                            멤버십 이벤트 /각종 혜택 등의 소식을 가장 빠르게 <br>
					                            받아보실 수 있습니다.</small> 
                    </label> 
                </div>
                <div class="form-check"> 
                    <button id="register_button" class="btn-joinsoda" > 가입하기 </button> 
                </div>
            </div> 
        </form>
    </div>
    
    
    <script>
		// 사용자 입력 값 유효성 검사용 함수
		function validate(){
			// 알맞은 값 입력 시 넘어가게 js로 구현
			return true;
		}
		
		$("#idCheck").on('click', function(){
			
			var userId = $("[name=userId]");
			// 아이디 중복 시 false, 아이디 사용 가능 시 true 값을 가지는 변수
			var isUsable = false;
			
			if(!userId || userId.val().length < 4) {
				alert("아이디는 최소 4자리 이상이어야 합니다.");
				userId.focus();
			} else {
				$.ajax({
					url : "${contextPath}/idCheck",
					type : "post",
					data : { userId : userId.val() },
					success : function(result) {
						console.log(result);
						if(result == "fail"){
							alert("사용할 수 없는 아이디입니다.");
							userId.focus();
						} else{
							if(confirm("사용 가능한 아이디입니다. 사용하시겠습니까?")){
								// 더 이상 아이디 입력 공간을 바꿀 수 없도록 처리
								userId.attr('readonly', true);
								/* 사용 가능한 아이디라는 flag */
								isUsable = true;
							} else {
								// 다시 아이디 입력 공간을 바꿀 수 있도록 처리
								userId.attr('readonly', false);
								userId.foucs();
								/* 사용 불가능한 아이디라는 flag */
								isUsable = false;
							}
						}
						/* 아이디 중복 체크 후 중복이 아니며 사용하겠다고 선택한 경우
						버튼의 disabled 속성 제거 */
						if(isUsable){
							$("#joinBtn").removeAttr("disabled");
						} else {
							$("#joinBtn").attr("disabled", true);
						}
					},
					error : function(e) {
						console.log(e);
					}
				});
			}

		});

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