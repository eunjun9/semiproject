<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>이용약관 및 개인정보 페이지</title>
    <link href="resources/css/common/joincheck.css" rel="stylesheet">
    <link href="resources/css/header_footer.css" rel="stylesheet">
    
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

    <!--body-->
    <div class="form-body">
        <div class="form-check mb-2"> 
            <input class="form-check-input" type='checkbox' name='n_agree' id='n_agree' required="">  [필수] 이용약관
            <div class="form-body2">
               <p>
                소다는 기본적으로 여러분 모두에게 동일한 내용의 서비스를 제공합니다. 다만, '청소년보호법' 등 관련 법령이나 기타 개별 서비스 제공에서의 특별한 필요에 의해서 연령 또는 일정한 등급을 기준으로 이용자를 구분하여 제공하는 서비스의 내용, 이용 시간, 이용 횟수 등을 다르게 하는 등 일부 이용을 제한하는 경우가 있습니다. 자세한 내용은 역시 각 서비스 상의 안내, 공지사항, 고객센터 도움말 등에서 확인하실 수 있습니다.

                소다 서비스에는 기본적으로 본 약관이 적용됩니다만 소다가 다양한 서비스를 제공하는 과정에서 부득이 본 약관 외 별도의 약관, 운영정책 등을 적용하는 경우(예, 소다페이, V LIVE 등)가 있습니다. 그리고 소다 계열사가 제공하는 특정 서비스의 경우에도(예, LINE, SNOW등) 해당 운영 회사가 정한 고유의 약관, 운영정책 등이 적용될 수 있습니다. 이러한 내용은 각각의 해당 서비스 초기 화면에서 확인해 주시기 바랍니다.
                
                회원으로 가입하시면 소다 서비스를 보다 편리하게 이용할 수 있습니다.
               </p>
            </div> 
        </div>
        <div class="form-check mb-2"> 
            <input class="form-check-input" type='checkbox' name='n_agree' id='n_agree' required="">  [필수] 개인정보처리방침 
            <div class="form-body2">
               <p>
                소다는 기본적으로 여러분 모두에게 동일한 내용의 서비스를 제공합니다. 다만, '청소년보호법' 등 관련 법령이나 기타 개별 서비스 제공에서의 특별한 필요에 의해서 연령 또는 일정한 등급을 기준으로 이용자를 구분하여 제공하는 서비스의 내용, 이용 시간, 이용 횟수 등을 다르게 하는 등 일부 이용을 제한하는 경우가 있습니다. 자세한 내용은 역시 각 서비스 상의 안내, 공지사항, 고객센터 도움말 등에서 확인하실 수 있습니다.

                소다 서비스에는 기본적으로 본 약관이 적용됩니다만 소다가 다양한 서비스를 제공하는 과정에서 부득이 본 약관 외 별도의 약관, 운영정책 등을 적용하는 경우(예, 소다페이, V LIVE 등)가 있습니다. 그리고 소다 계열사가 제공하는 특정 서비스의 경우에도(예, LINE, SNOW등) 해당 운영 회사가 정한 고유의 약관, 운영정책 등이 적용될 수 있습니다. 이러한 내용은 각각의 해당 서비스 초기 화면에서 확인해 주시기 바랍니다.
                
                회원으로 가입하시면 소다 서비스를 보다 편리하게 이용할 수 있습니다.
               </p>
            </div> 
        </div>
        <div>
            <input class="form-check-input" type='checkbox' name='n_agree' id='n_agree' onclick='selectAll(this)' required="">
              <b>위 내용에 모두 동의합니다.</b>
              
              <div class="form-check"> 
                <button id="register_button" class="btn-joinsoda"> <a class="joinsoda-check" href="memberjoin.html"> 확 인 </a></button> 
            </div>
        </div> 
    </div>
    <script>
        function selectAll(selectAll)  {
           const checkboxes 
          = document.getElementsByName('n_agree');
     
           checkboxes.forEach((checkbox) => {
               checkbox.checked = selectAll.checked;
            })
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