<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>


 <!-- 외부 스타일 시트 -->
  <link href="../css/Headerfooter.css" rel="stylesheet">
  <link href="../css/Manager_member_popup.css" rel="stylesheet">

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
  <div class="header">
    <div class="head-inner">
      <div class="logo">
        <img src="../image/logo.png">
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

        <article>
          <h1 id="main-title">회원관리</h1>

          <table class="tbl">
            <thead>
              <tr>
                <th class="tbl-title">선택</th>
                <th class="tbl-title">회원계정</th>
                <th class="tbl-title">이름</th>
                <th class="tbl-title">생년월일</th>
                <th class="tbl-title">휴대폰번호</th>
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
                <td class="tbl-content">admin</td>
                <td class="tbl-content">관리자</td>
                <td class="tbl-content">000000</td>
                <td class="tbl-content">02-1234-5678</td>
                <td class="tbl-content">21.10.30</td>
                <td class="tbl-content">관리자</td>
                <td class="tbl-content">
                  <button type="button" class="revise-button"
                    onclick="openPopup('../POPUP/Member_revise_popup.html', 'checking', 350, 520)">수정</button>
                </td>
              </tr>
              <tr>
                <td class="tbl-content">
                  <input type="checkbox" class="check" name="check">
                </td>
                <td class="tbl-content">hong@gmail.com</td>
                <td class="tbl-content">홍길동</td>
                <td class="tbl-content">940223</td>
                <td class="tbl-content">010-1234-5678</td>
                <td class="tbl-content">21.10.30</td>
                <td class="tbl-content">강사</td>
                <td class="tbl-content">
                  <button type="button" class="revise-button"
                    onclick="openPopup('../POPUP/Member_revise_popup.html', 'checking', 350, 520)">수정</button>
                </td>
              </tr>
              <tr>
                <td class="tbl-content">
                  <input type="checkbox" class="check" name="check">
                </td>
                <td class="tbl-content">jennieisback@naver.com</td>
                <td class="tbl-content">제니</td>
                <td class="tbl-content">960505</td>
                <td class="tbl-content">010-1344-5678</td>
                <td class="tbl-content">21.10.31</td>
                <td class="tbl-content">회원</td>
                <td class="tbl-content">
                  <button type="button" class="revise-button"
                    onclick="openPopup('../POPUP/Member_revise_popup.html', 'checking', 350, 520)">수정</button>
                </td>
              </tr>
            </tbody>
          </table>

          <button type="button" class="grade-revise"
            onclick="openPopup('../POPUP/Grade_popup.html', 'checking', 335, 350)">회원등급변경</button>
        </article>
      </div>
    </div>
  </div>

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