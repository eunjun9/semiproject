<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <%@ include file="/WEB-INF/views/admin/sideMenu.jsp"%>
                </aside>
                <article>
                    <h1 id="main-title">매출조회</h1>
                    <div class="combo-area">
                    <form name="filterForm">
                        <select name="filter">
                        	<option selected>정렬 방식</option>
                            <option value="class">클래스별</option>
                            <option value="date">날짜별</option>
                            <option value="option">결제수단별</option>
                        </select>
                    </form>
                    </div>
                    <table class="tbl">
                        <thead>
                          <tr>
                            <th class="tbl-title">정렬 방식</th>
                            <th class="tbl-title">총 매출액</th>
                            <th class="tbl-title">결제 건수</th>
                          </tr>
                        </thead>
                        <tbody>
                        <!-- 
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
                          </tr> -->
                        </tbody>
                    </table>
                </article>
            </div>
        </div>
    </div>

    <!--footer-->
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    
    <script>
	    $(function(){
			$("select[name=filter]").change(listChange);
		});
		
		function listChange() {
			if($('[name=filter]').val() == 'class') {
				$('.tbl-title:first').text('클래스별');
			} else if($('[name=filter]').val() == 'date') {
				$('.tbl-title:first').text('날짜별');
			} else if($('[name=filter]').val() == 'option') {
				$('.tbl-title:first').text('결제수단별');
			}
			
			$("tbody").html("");
		}
    </script>
    
    <script>
	    $(function(){
	    	$('[name=filter]').on('change', function () { 
        		var filter = $('[name=filter]').val();
	 			$.ajax({
	 				url : "${ contextPath }/salesList",
	 				data : { filter : filter },
	 				type : "get",
	 				dataType : "json",
	 				success : function(list) {
	 					
	 					if(list) {

		 					var str = '';
		 					$.each(list, function(i){
		 						if(list[i].nTitle != null) {
		 						str += "<tr><td class='tbl-content'>" + list[i].nTitle + "</td><td class='tbl-content'>"
		 							 + list[i].pTotal + "</td><td class='tbl-content'>"
		 							 + list[i].pCount + "</td></tr>";
		 						} else if(list[i].pDate != null) {
		 							str += "<tr><td class='tbl-content'>" + list[i].pDate + "</td><td class='tbl-content'>"
		 							 + list[i].pTotal + "</td><td class='tbl-content'>"
		 							 + list[i].pCount + "</td></tr>";
		 						} else if(list[i].pOption != null) {
		 							str += "<tr><td class='tbl-content'>" + list[i].pOption + "</td><td class='tbl-content'>"
		 							 + list[i].pTotal + "</td><td class='tbl-content'>"
		 							 + list[i].pCount + "</td></tr>";
		 						}
		 					});
		 					$("tbody").html(str);
		 					
        					$("[name=filter]").val("");
	 					} else {
	 						alert('매출 정보가 없습니다.');
	 					}
	 				},
	 				error : function(e) {
	 					console.log(e);
	 				}
	 			});
	 		});
	 	});
    </script>

</body>
</html>