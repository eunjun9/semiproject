<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>관리자 회원관리</title>

  <!-- 외부 스타일 시트 -->
<link
	href="<%=request.getContextPath()%>/resources/css/admin/admin-member.css?1" rel="stylesheet">
  

  <!-- 글꼴 (Noto Sans) -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

  <!-- jQuery -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>

<body>
      <!--header-->
    <%@ include file="/WEB-INF/views/common/header.jsp"%>
 
 
 
 

  <!-- body -->
  <div class="sales body">
    <div class="body-inner">
      <div class="manager-content">
        <aside>
           <!-- 관리자페이지 사이드바 메뉴 -->
                   <%@ include file="/WEB-INF/views/admin/sideMenu.jsp"%>
        </aside>


        <article>
          <h1 id="main-title">회원관리</h1>
          <table class="tbl">
            <thead>
              <tr>
                <th class="tbl-title th2">아이디</th>
                <th class="tbl-title th3">이름</th>
                <th class="tbl-title th4">휴대폰번호</th>
                <th class="tbl-title th5">성별</th>
                <th class="tbl-title th6">가입일</th>
                <th class="tbl-title th7">회원등급</th>
                <th class="tbl-title th8">활동여부</th>
                <th class="tbl-title th9">회원정보수정</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach var="member" items="${ memberList}">
            <tr>
                <td class="tbl-content">${member.userId}</td>
                <td class="tbl-content">${member.userName }</td>
                <td class="tbl-content">${member.userPhone }</td>
                <td class="tbl-content">${member.gender }</td>
                <td class="tbl-content">${member.joinDate }</td>
                <td class="tbl-content">${member.userGrade }</td>
                 <td>
                 <c:choose>
                <c:when test="${member.status =='Y'}">활동중</c:when>
                <c:when test="${member.status =='N'}">정지</c:when>
                </c:choose>
                
                </td>
                
                <td class="tbl-content">
                
				
				
				<form name="memberForm" method="post">
				<input type="hidden" name="userId" id="userId"> 
				 <input name="userId" value="수정" type="submit" class="revise-button" onclick="document.getElementById('userId').value='${ member.userId }'"> 
				</form>
				
               
                </td>
                
              </tr>
			</c:forEach>	
			</tbody>              
          </table>
          
          
        </article>
		
			

         
      </div>
    </div>
  </div>

  <!--footer-->
     <!--header-->
    <%@ include file="/WEB-INF/views/common/footer.jsp"%>

  <!--회원관리 왼쪽 메뉴 스크립트-->
  <script>
    $(document).ready(function () {
      $(".menu").mouseover(function () {
        $(this).children(".submenu").show(300);
      });
      $(".menu").mouseleave(function () {
        $(this).children(".submenu").hide(300);
      });
    });

  </script>



  <!--수정 버튼 누를때 팝업창 스크립트-->
<!--   <script>
    function openPopup(url, title, width, height) {
    
    	
      let left = (document.body.clientWidth / 2) - (width / 2);
      left += window.screenLeft;
      let top = (screen.availHeight / 2) - (height / 2);

      let options = "width=" + width + ",height=" + height + ",left=" + left + ",top=" + top;

      window.open(url, title, options);
    }
  </script> -->
  
<script>
 	/* function modify(){
		document.forms.memberForm.action = "${ contextPath }/member/modify";
		document.forms.memberForm.submit();
	} */
  
 	
 	/* function modify(userId) {
 		 var form = document.forms.memberForm;
 		 window.open("","popup","width=210,height=300,left=700,top=300,scrollbars=no");
 		 form.target = "popup";
 		 form.action = "${ contextPath }/member/modify?userId=" + userId;
 		 form.method = "post";
 		 form.submit();
 		} */
	
	
 		$(".revise-button").on("click", function() {
 			 var form = document.forms.memberForm;
 			 var modifyChild=window.open("","popup","width=510,height=460,left=700,top=300,scrollbars=no");
 	 		 form.target = "popup";
 	 		 form.action = "${ contextPath }/member/modify";
 	 		 form.method = "post";
 	 		 form.submit();
 		});
 		
 		
 		
/* 	function modify(userId) {
		 var form = document.forms.memberForm;
		 window.open("","popup","width=210,height=300,left=700,top=300,scrollbars=no");
		 form.target = "popup";
		form.action = "${ contextPath }/member/modify";
		 form.method = "post";
		 form.submit();
		 
		 
		}
 	 */
  
</script>
  

  
  

  	
</body>

</html>