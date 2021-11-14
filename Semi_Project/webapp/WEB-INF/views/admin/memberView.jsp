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
                <th class="tbl-title">선택</th>
                <th class="tbl-title">아이디</th>
                <th class="tbl-title">이름<th>
                <th class="tbl-title">휴대폰번호</th>
                <th class="tbl-title">성별</th>
                <th class="tbl-title">가입일</th>
                <th class="tbl-title">회원등급</th>
                <th class="tbl-title">수정버튼</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td class="tbl-content">
                  <input type="checkbox" class="check" name="check">
                </td>
                <td class="tbl-content">${member.userId}</td>
                <td class="tbl-content">${member.userName }</td>
                <td class="tbl-content">${member.userPhone }</td>
                <td class="tbl-content">${member.gender }</td>
                <td class="tbl-content">${member.joinDate }</td>
                <td class="tbl-content">${member.userGrade }</td>
                <td class="tbl-content">
                  <button type="button" class="revise-button"
                    onclick="location.href='${ contextPath }/member/modify'">수정</button>
                </td>
              </tr>
              <tr>
              
          </table>

          <button type="button" class="grade-revise"
            onclick="location.href='${ contextPath }/member/grade'">회원등급변경</button>
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

</body>

</html>