<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="com.soda.member.model.vo.Member"%>


<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>환불 정보 입력 페이지</title>

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
    
    <link href="${ contextPath }/resources/css/mypage/mypage_refundinfo.css" rel="stylesheet">
   
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
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
   

    <div class="joinInfoArea" id="register_row">
        <form id="register_form" action="${ contextPath }/mypage/refundinfo"
        method="post">
        <input type="hidden" name="pNum" value="${pNum}">
            <div class="common-form title">
                <p class="firstjoin">환불 정보 입력</p>
            </div>
            <div class="common-form">
                <div class="form-group">
                    <label class="form-label">계좌번호입력</label><br>
                    <input class="form-control" id="account" type="text" name="refundAccount" 
                    maxlength="30" placeholder="계좌번호를  '-' 빼고 입력해주세요" size="25" required>
                </div>
            </div>
            <div class="common-form">
                <div class="form-group">
                    <label class="form-label">은행</label><br>
                    <input class="form-control" id="bank" type="text" name="bank" 
                    placeholder="환불받을은행을 입력해주세요" size="25" required>
                </div>
            </div>
            <div class="common-form">
                <div class="form-group">
                    <label class="form-label">예금주</label><br>
                    <input class="form-control" id="name" type="text" name="accountHolder" 
                    placeholder="이름을 입력해주세요" size="25" required>
                </div>
            </div>
            
            
                <div class="form-check"> 
                    <button id="btn-confirm" type="button" onclick="confirmRefundinfo();">환불 접수 하기</button>
                </div>
        	</form>
         </div> 
    
		<script>
		 	function confirmRefundinfo(){
		 		alert('환불 접수가 완료되었습니다.');
		 	}
		</script>
	


    <!--footer-->
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
	
</body>

</html>