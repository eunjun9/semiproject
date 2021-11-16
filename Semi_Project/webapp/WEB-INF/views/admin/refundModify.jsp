<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>환불 처리 현황 수정</title>

  <!-- 외부 스타일 시트 -->
    <link rel="stylesheet" href="${ contextPath }/resources/css/common/memberModify.css">

    <!-- 글꼴 (Noto Sans) -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        
        
        <%
   if(request.getAttribute("result") != null) {
      // 신고 요청을 수행하고 돌아온 상황일 때 (처음 팝업창을 여는 상황은 result가 null)
      if(request.getAttribute("result").equals("success")) {
         // 신고 요청에 성공
%>
<script>
alert("환불 처리 정보가 변경되었습니다.");
window.opener.location.reload();
   window.close();
</script>
<% 
      } else { // 신고 요청에 실패
%>
<script>
   alert("다시 확인해주세요.");
</script>
<%
      }
   }
%>
</head>

<body>
    <div class="page body">
        <h2 id="title">환불 처리 정보 수정</h2>
        <form name="modifyForm" id="modify" action="${contextPath }/refund/modifyview" method="post">
		<input type ="hidden" name="userId" value="${refund.userId}">
		
            <div class="line">

            <div class="label-input1">
            <label class="id">계좌번호  : </label>
            <input type="text" class="id-text" name="rAccount" value="${refund.rAccount}"><br>
            </div>
         
            <div class="label-input2">
            <label class="name">은행 : </label>
            <input type="text" class="birth-text" name="bank" value="${refund.bank }"><br>
            </div>
         
         
            <div class="label-input3">
            <label class="phone">예금주 : </label>
            <input type="text" class="phone-text" name="aHolder" value="${refund.aHolder }">
            </div>
            
            

          <label class="account">환불 처리 여부 : </label>        
                <select id="account " name="rProcess">
                
                   <option value="Y" <c:if test="${refund.rProcess =='Y'}">selected</c:if>>접수중</option>
                   <option value="N" <c:if test="${refund.rProcess =='N'}">selected</c:if>>처리완료</option>
                    
                </select>
                
                <div class="subTitle">
                <p id="subTitle">${refund.userId}님의 
                                <br>환불 처리 여부를 변경하시겠습니까?</p>
            </div>
            
    
            <div class="btnArea">
            <button type="button" id="cancel" onclick="window.close()">취소</button>
            
            <button id="sub" type="submit">확인</button>
            
            </div>

            </div>
        </form>
    </div>
    

    
</body>

</html>