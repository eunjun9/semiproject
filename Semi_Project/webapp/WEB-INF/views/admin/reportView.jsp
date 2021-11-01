<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지_신고내역</title>

	<!-- 외부 스타일 시트 -->
    <link rel="stylesheet" href="/resources/css/admin/admin-report.css">
    <!-- 글꼴 (Noto Sans) -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

</head>
<body>
    <!-- header -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
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
                    <h1 id="main-title">신고내역</h1>
                    <div class="combo-area">
                      <!-- 정렬 선택 전 전체보기가 디폴트, 오래된 순으로 정렬-->
                        <select name="filter">
                            <option value="" selected>전체보기</option>
                            <option value="">매거진</option>
                            <option value="">소셜링</option>
                        </select>
                    </div>
                    <table class="tbl">
                        <thead>
                          <tr>
                            <th class="tbl-title"> </th>
                            <th class="tbl-title">게시글 번호</th>
                            <th class="tbl-title">카테고리</th>
                            <th class="tbl-title">제목</th>
                            <th class="tbl-title">게시자</th>
                            <th class="tbl-title">게시일</th>
                            <th class="tbl-title">신고사유</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td class="tbl-content"><input type="checkbox" name="r_ckbox"></td>
                            <td class="tbl-content" name="r_bNo">1</td>
                            <td class="tbl-content" name="r_category">매거진</td>
                            <td class="tbl-content" name="r_title"><a href="#">독서토론 강사 xxx</a></td>
                            <td class="tbl-content" name="r_writer">김구라</td>
                            <td class="tbl-content" name="r_date">2021.11.02</td>
                            <td class="tbl-content" name="r_reason">명예훼손</td>
                          </tr>
                          <tr>
                            <td class="tbl-content"><input type="checkbox" name="r_ckbox"></td>
                            <td class="tbl-content" name="r_bNo">4</td>
                            <td class="tbl-content" name="r_category">매거진</td>
                            <td class="tbl-content" name="r_title"><a href="#">ㅇㅇ모임 노잼</a></td>
                            <td class="tbl-content" name="r_writer">박명수</td>
                            <td class="tbl-content" name="r_date">2021.10.29</td>
                            <td class="tbl-content" name="r_reason">불법성</td>
                          </tr>
                          <tr>
                            <td class="tbl-content"><input type="checkbox" name="r_ckbox"></td>
                            <td class="tbl-content" name="r_bNo">5</td>
                            <td class="tbl-content" name="r_category">소셜링</td>
                            <td class="tbl-content" name="r_title"><a href="#">xxx xxxx</a></td>
                            <td class="tbl-content" name="r_writer">신짱구</td>
                            <td class="tbl-content" name="r_date">2021.11.10</td>
                            <td class="tbl-content" name="r_reason">욕설</td>
                          </tr>
                        </tbody>
                      </table>
                      <button id="deleteBtn" onclick="deleteconfirm();">선택삭제</button>
                </article>
            </div>
        </div>
    </div>

    <script>
      function deleteconfirm(){
        if(confirm('게시글을 삭제하시겠습니까?')){
          // db에서 게시글 상태 y->n으로 바꾸고, 상태가 n이 된 글은 신고 내역에서 안 보이게
          
        }
      }
    </script>
    
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
	
	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>