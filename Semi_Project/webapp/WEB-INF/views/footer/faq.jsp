<%@ page language="java" 
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FAQ</title>

    <!-- 외부 스타일 시트 -->
 <link href="${ contextPath }/resources/css/footer/faq.css" rel="stylesheet">

    <!-- 글꼴 (Noto Sans) -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

    <!-- JQuery-->
    <script src="../js/jquery-3.6.0.min.js"></script>

</head>
<body>
  <%@ include file="/WEB-INF/views/common/header.jsp"%>

      <!-- body -->
      <div class="page body">
        <div class="titleArea">
            <div class="titleArea2">
                <h2 id="title">자주 묻는 질문 FAQ</h2>
            </div>
        </div>
        <div class="body-inner">

            <div class="cQnA">
                <form>
                    <div class="outer">
                        <p class="cQuestion2"> 대관이 필요할 경우에 빌릴 수 있을까요?</p>
                        <p class="cAnswer" >네, 소다에서 직접 컨택한 업체를 연결해드립니다. 소다로 전화 부탁드립니다.</p>
                    </div>
                    <div class="outer">
                        <p class="cQuestion2">환불 규정은 어떻게 되나요?</p>
                        <p class="cAnswer" >결제 후 작성해주신 계좌로 입금되는 형식입니다.</p>
                    </div>
                    <div class="outer">
                        <p class="cQuestion2"> 가져가야 될 준비물이 있을까요?</p>
                        <p class="cAnswer" >클래스에 따라 다릅니다.</p>
                    </div>

                    <div class="outer">
                        <p class="cQuestion2"> 대관이 필요할 경우에 빌릴 수 있을까요?</p>
                        <p class="cAnswer" >네, 소다에서 직접 컨택한 업체를 연결해드립니다. 소다로 전화 부탁드립니다.</p>
                    </div>
                    <div class="outer">
                        <p class="cQuestion2">환불 규정은 어떻게 되나요?</p>
                        <p class="cAnswer" >결제 후 작성해주신 계좌로 입금되는 형식입니다.</p>
                    </div>
                    <div class="outer">
                        <p class="cQuestion2"> 가져가야 될 준비물이 있을까요?</p>
                        <p class="cAnswer" >클래스에 따라 다릅니다.</p>
                    </div>

                    <div class="outer">
                        <p class="cQuestion2"> 대관이 필요할 경우에 빌릴 수 있을까요?</p>
                        <p class="cAnswer" >네, 소다에서 직접 컨택한 업체를 연결해드립니다. 소다로 전화 부탁드립니다.</p>
                    </div>
                    <div class="outer">
                        <p class="cQuestion2">환불 규정은 어떻게 되나요?</p>
                        <p class="cAnswer" >결제 후 작성해주신 계좌로 입금되는 형식입니다.</p>
                    </div>
                    <div class="outer">
                        <p class="cQuestion2"> 가져가야 될 준비물이 있을까요?</p>
                        <p class="cAnswer" >클래스에 따라 다릅니다.</p>
                    </div>
                
                </form>
            </div>
            
            <script>
                $('.cQuestion2').click(function(){
                    if($(this).siblings('.cAnswer').css('display') == 'none'){ // question다음의 컨텐츠 영역이 display=none일 때
                        $('p.cAnswer').slideUp();       // 기존에 열려있는 콘텐츠는 닫고
                        $(this).siblings('.cAnswer').slideDown();  // 클릭한 메뉴의 콘텐츠는 밑으로 스르륵 내려오게
                    }else{
                        $(this).siblings('.cAnswer').slideUp();    // display=none 이 아닐 때 클릭 시 위로 올라가게
                    }
                });
            </script>
          

    </div>
    </div>
 

    <!--footer-->
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>