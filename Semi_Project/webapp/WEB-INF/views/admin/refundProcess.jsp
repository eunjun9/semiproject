<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>환불 처리 변경</title>

    <!-- 외부 스타일 시트 -->
    <link href="../css/gradePopup.css" rel="stylesheet">

    <!-- 글꼴 (Noto Sans) -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
    <div class="page body">
        <h2 id="title">환불 처리 변경</h2>
        <form id="revise" action="${contextPath }/refund/process" method="post">
            <div class="optionArea">
            
         
                
                <select id="account " name="account">
                    <option value="Y" <c:if test="${refund.rProcess=='Y'}"> selected</c:if>>접수중</option>
                    <option value="N" <c:if test="${refund.rProcess=='N'}"> selected</c:if>>처리완료</option>
                    
                </select>
                
                
                <p id="subTitle">${refund.userId }님의 환불처리를 변경하시겠습니까?</p>
            </div><br>
            <div class="btnArea">
                <button type="button" id="cancel" onclick="window.close()">취소</button>
                <button type="submit" id="sub">확인</button>
            </div>
        </form>
    </div>
</body>
</html>