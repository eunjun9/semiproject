<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자_매출조회</title>

<!-- 외부 스타일 시트 -->
<link href="/resources/css/admin/admin-sales.css" rel="stylesheet">

<!-- 글꼴 (Noto Sans) -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
	<!--header-->
    <%@ include file="/WEB-INF/views/common/header.jsp" %>

    <!-- body -->
    <div class="sales body">
        <div class="body-inner">
            <div class="manager-content">
                <aside>
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
                    <h1 id="main-title">매출조회</h1>
                    <div class="combo-area">
                        <select name="filter">
                            <option value="">클래스별</option>
                            <option value="">년도별</option>
                            <option value="">월별</option>
                            <option value="">일별</option>
                            <option value="">결제수단별</option>
                        </select>
                    </div>
                    <table class="tbl">
                        <thead>
                          <tr>
                            <th class="tbl-title">클래스별</th>
                            <th class="tbl-title">총 매출액</th>
                            <th class="tbl-title">결제 건수</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td class="tbl-content">클래스명1</td>
                            <td class="tbl-content">500,000</td>
                            <td class="tbl-content">60</td>
                          </tr>
                          <tr>
                            <td class="tbl-content">클래스명2</td>
                            <td class="tbl-content">300,000</td>
                            <td class="tbl-content">40</td>
                          </tr>
                          <tr>
                            <td class="tbl-content">클래스명3</td>
                            <td class="tbl-content">800,000</td>
                            <td class="tbl-content">90</td>
                          </tr>
                        </tbody>
                    </table>
                </article>
            </div>
        </div>
    </div>

    <!--footer-->
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>

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