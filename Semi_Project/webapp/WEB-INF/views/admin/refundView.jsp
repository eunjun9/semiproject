<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자_환불내역</title>

    <!-- 외부 스타일 시트 -->
    <link href="resources/css/header_footer.css" rel="stylesheet">
    <link href="resources/CSS/refundView.css" rel="stylesheet">

    <!-- 글꼴 (Noto Sans) -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
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
                    <h1 id="main-title">환불내역</h1>
                    <div class="combo-area">
                        <select name="filter">
                            <option value="">2021년 11월</option>
                            <option value="">2021년 10월</option>
                            <option value="">2020년 09월</option>
                            <option value="">2020년 08월</option>
                            <option value="">2020년 07월</option>
                        </select>
                    </div>
                    <table class="tbl">
                        <thead>
                          <tr>
                            <th class="tbl-title">클래스명</th>
                            <th class="tbl-title">강사명</th>
                            <th class="tbl-title">강사계정</th>
                            <th class="tbl-title">회원아이디</th>
                            <th class="tbl-title">결제금액</th>
                            <th class="tbl-title">결제방식</th>
                            <th class="tbl-title">환불계좌</th>
                            <th class="tbl-title">은행</th>
                            <th class="tbl-title">예금주</th>
                            <th class="tbl-title">처리현황</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td class="tbl-content">클래스명1</td>
                            <td class="tbl-content">홍길동</td>
                            <td class="tbl-content">sample@gmail.com</td>
                            <td class="tbl-content">gsdga@gmail.com</td>
                            <td class="tbl-content">200,000</td>
                            <td class="tbl-content">미완료</td>
                            <td class="tbl-content">12-235-222</td>
                            <td class="tbl-content">신한</td>
                            <td class="tbl-content">김혜수</td>
                            <td class="tbl-content">미완료</td>
                          </tr>
                          <tr>
                            <td class="tbl-content">클래스명2</td>
                            <td class="tbl-content">김길동</td>
                            <td class="tbl-content">sample@naver.com</td>
                            <td class="tbl-content">squidgame@naver.com</td>
                            <td class="tbl-content">2,000,000</td>
                            <td class="tbl-content">완료</td>
                            <td class="tbl-content">222-555-8421</td>
                            <td class="tbl-content">국민</td>
                            <td class="tbl-content">이정재</td>
                            <td class="tbl-content">완료</td>
                          </tr>
                          <tr>
                            <td class="tbl-content"></td>
                            <td class="tbl-content"></td>
                            <td class="tbl-content"></td>
                            <td class="tbl-content"></td>
                            <td class="tbl-content"></td>
                            <td class="tbl-content"></td>
                            <td class="tbl-content"></td>
                            <td class="tbl-content"></td>
                            <td class="tbl-content"></td>
                            <td class="tbl-content"></td>
                          </tr>
                          <tr>
                            <td class="tbl-content"></td>
                            <td class="tbl-content"></td>
                            <td class="tbl-content"></td>
                            <td class="tbl-content"></td>
                            <td class="tbl-content"></td>
                            <td class="tbl-content"></td>
                            <td class="tbl-content"></td>
                            <td class="tbl-content"></td>
                            <td class="tbl-content"></td>
                            <td class="tbl-content"></td>
                          </tr>
                        </tbody>
                    </table>
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

    <script>
        $(document).ready(function(){ 
          $(".menu").mouseover(function(){ 
            $(this).children(".submenu").show(300); 
          }); 
            $(".menu").mouseleave(function(){ 
              $(this).children(".submenu").hide(300); 
            });
          });
        
        </script>
</body>
</html>