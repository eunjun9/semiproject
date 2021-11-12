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
	href="<%=request.getContextPath()%>/resources/css/admin/admin-member.css" rel="stylesheet">
  

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
          <!-- 관리자페이지 메뉴 -->
          <div class="admin-menu">
            <ul id="menu">
              <li class="member menu">
                <a href="#">회원관리</a>
              </li>

              <li class="content menu">
                <a href="#">컨텐츠관리</a>
              </li>

              <li class="sales menu">
                <a href="#">매출관리</a>
                <ul class="submenu">
                  <li><a href="#">매출조회</a></li>
                  <li><a href="#">정산내역</a></li>
                  <li><a href="#">환불내역</a></li>
                </ul>
              </li>
            </ul>
          </div>
        </aside>

 <form name="memberForm" method="post">
        <article>
          <h1 id="main-title">회원관리</h1>
          <table class="tbl">
            <thead>
              <tr>
                <th class="tbl-title th1">선택</th>
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
                <td class="tbl-content">
                  <input type="checkbox" class="check" name="check" value="${member.userId}">
                </td>
                <td class="tbl-content">${member.userId}</td>
                <td class="tbl-content">${member.userName }</td>
                <td class="tbl-content">${member.userPhone }</td>
                <td class="tbl-content">${member.gender }</td>
                <td class="tbl-content">${member.joinDate }</td>
                <td class="tbl-content">${member.userGrade }</td>
                <td class="tbl-content">
                 
                 <c:choose>
                <c:when test="${member.status =='Y'}">활동가능</c:when>
                <c:when test="${member.status =='N'}">활동중지</c:when>
                </c:choose>
                
                </td>
                
                <td class="tbl-content">
			 <input type="hidden" name="userId" value="${ member.userId}"> 
			 <button class="revise-button" onclick="javascript: form.action='${contextPath}/member/modify'">수정</button>
                
                </td>
              </tr>
				
			</c:forEach>	
				              
          </table>
          
			 <button class="grade-revise" onclick="javascript: form.action='${contextPath}/member/grade'">회원등급변경</button>
          
        </article>
		</form>
			

         
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

  <!--회원 등급 변경 팝업창 스크립트-->
  <script>
    function openPopup(url, title, width, height) {
      let left = (document.body.clientWidth / 2) - (width / 2);
      left += window.screenLeft;
      let top = (screen.availHeight / 2) - (height / 2);

      let options = "width=" + width + ",height=" + height + ",left=" + left + ",top=" + top;

      window.open(url, title, options);
    }

  </script>


  <!--수정 버튼 누를때 팝업창 스크립트-->
  <script>
    function openPopup(url, title, width, height) {
      let left = (document.body.clientWidth / 2) - (width / 2);
      left += window.screenLeft;
      let top = (screen.availHeight / 2) - (height / 2);

      let options = "width=" + width + ",height=" + height + ",left=" + left + ",top=" + top;

      window.open(url, title, options);
    }
  </script>
  
  
<!--   	<script>
			function modify(){
				document.forms.memberForm.action = "${ contextPath }/member/modify";
				document.forms.memberForm.submit();
			}
	= -->
  
  
  
  
  <script>
  
  
  /* function grade(){
	  
	  var rowData = new Array();
		var tdArr = new Array();
		var checkbox = $("input[name=chb]:checked");
		
		// 체크된 체크박스 값을 가져온다
		checkbox.each(function(i) {

			// checkbox.parent() : checkbox의 부모는 <td>이다.
			// checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();
			
			// 체크된 row의 모든 값을 배열에 담는다.
			rowData.push(tr.text());
			
			// td.eq(0)은 체크박스 이므로  td.eq(1)의 값부터 가져온다.
			var userId = td.eq(1).text()+" ";
			
			
			// 가져온 값을 배열에 담는다.
			tdArr.push(userId);
			
		});
		
	};
	   */
  
  
			
			

  	</script>	
  	
</body>

</html>