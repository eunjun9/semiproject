<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지_신고내역</title>

	<!-- 외부 스타일 시트 -->
    <link rel="stylesheet" href="/resources/css/admin/admin-report.css?6">
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
                     <!-- 관리자페이지 사이드바 메뉴 -->
                   <%@ include file="/WEB-INF/views/admin/sideMenu.jsp"%>
                </aside>

                <article>
                    <h1 id="main-title">신고내역</h1>
                    <div class="combo-area">
                      <!-- 정렬 선택 전 전체보기가 디폴트, 오래된 순으로 정렬-->
                      <form method="get" action="${ contextPath }/admin/report">
                        <select name="filter">
                            <option value="all" selected>전체보기</option>
                            <option value="magazine">매거진</option>
                            <option value="socialing">소셜링</option>
                        </select>
                        <input type="submit" id="submitBtn" style="display:none"></input>
                      </form>
                    </div>
                    
                    <script>
                    	${function(){
                    		$("select[name=filter]").change(sortMethod);
                    	
                    	function sortMethod(){
                    		if($(this).val() == 'all'){
                    			location.href="{ contextPath }/admin/report";
                    		} else if ($(this).val() == 'magazine'){
                    			$("#submitBtn").click();
                    		} else if ($(this).val() == 'socialing'){
                    			$("#submitBtn").click();
                    		}
                    	}
                    	}};
                    </script>
                    <table class="tbl">
                        <thead>
                          <tr>
                            <th class="tbl-title"> </th>
                            <th class="tbl-title">게시글 번호</th>
                            <th class="tbl-title">카테고리</th>
                            <th class="tbl-title">제목</th>
                            <th class="tbl-title">게시자</th>
                            <th class="tbl-title">신고일</th>
                            <th class="tbl-title">신고사유</th>
                          </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="report" items="${ reportList }">
                          <tr>
                            <td class="tbl-content"> </td>
                            <td class="tbl-content">${ report.nNum }</td>
                            <td class="tbl-content">${ report.category }</td>
                            <c:choose>
                            	<c:when test="${ report.category == '소셜링' }"> 
									<td class="tbl-content title"><a onclick="socialingDetail(${ report.nNum })">${ report.noticeTitle }</a></td>                            	
                            	</c:when>
                            	<c:when test="${ report.category == '매거진' }"> 
								 	<td class="tbl-content title"><a onclick="magazineDetail(${ report.nNum })">${ report.noticeTitle }</a></td>                            	
                            	</c:when>
                            </c:choose>
                            <td class="tbl-content">${ report.reportedId }</td>
                            <td class="tbl-content">${ report.rDate }</td>
                            <td class="tbl-content">${ report.rReason }</td>
                          </tr>
                         </c:forEach>
                        </tbody>
                      </table>
                      
                      <script>
                      	function socialingDetail(nNum){
                      	 	location.href = "${ contextPath }/socialing/detail?nNum=" + nNum;
                      	}
                      	function magazineDetail(nNum){
                      		location.href = "${ contextPath }/magazine/detail?nNum=" + nNum;
                      	}
                      
                      </script>
                </article>
            </div>
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
	
	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>