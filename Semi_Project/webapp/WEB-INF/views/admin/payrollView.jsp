<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지_정산내역</title>
<link rel="stylesheet"
	href="<%= request.getContextPath() %>/resources/css/admin-style.css">
	<!-- 외부 폰트 -->
	<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap"
	rel="stylesheet">
	<!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
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
                    <h1 id="main-title">정산내역</h1>
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
                            <th class="tbl-title">당월 총 수익</th>
                            <th class="tbl-title">정산금액(수수료제외)</th>
                            <th class="tbl-title">지급현황</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td class="tbl-content">클래스명1</td>
                            <td class="tbl-content">홍길동</td>
                            <td class="tbl-content">sample@gmail.com</td>
                            <td class="tbl-content">1,000,000</td>
                            <td class="tbl-content">0</td>
                            <td class="tbl-content">미완료</td>
                          </tr>
                          <tr>
                            <td class="tbl-content">클래스명2</td>
                            <td class="tbl-content">김길동</td>
                            <td class="tbl-content">sample@naver.com</td>
                            <td class="tbl-content">2,000,000</td>
                            <td class="tbl-content">1,740,000</td>
                            <td class="tbl-content">완료</td>
                          </tr>
                          <tr>
                            <td class="tbl-content">클래스명3</td>
                            <td class="tbl-content">최길동</td>
                            <td class="tbl-content">sample@daum.net</td>
                            <td class="tbl-content">500,000</td>
                            <td class="tbl-content">350,000</td>
                            <td class="tbl-content">완료</td>
                          </tr>
                        </tbody>
                    </table>
                </article>
            </div>
        </div>
    </div>

    <!--footer-->
    <%@ include file="/WEB-INF/views/common/footer.jsp"%>

	<!-- 사이드바 드롭다운 메뉴 -->
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