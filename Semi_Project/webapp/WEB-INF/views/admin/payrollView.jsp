<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지_정산내역</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/admin/admin-payroll.css">
<!-- 외부 폰트 -->
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
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
                   <%@ include file="/WEB-INF/views/admin/sideMenu.jsp"%>
                   
                </aside>

                <article>
                    <h1 id="main-title">정산내역</h1>
                    <div class="combo-area">
                    <p class="yearText"></p> <p class="monthText"></p>
                        <select id="year" name="year" class="select">
                        <!-- db에서 year 추출해서 가져오기(년도는 계속 추가되기 때문에).. -->
                        <option value="" selected>년</option>
                        <c:forEach var="pYear" items="${ payrollYear }">
                        <option value="${ pYear.optionYear }">${ pYear.optionYear }</option>
                        </c:forEach>
						</select>
						 
						 <!-- 1부터 12까지 forEach로 반복해서 option value 넣어주기 -->
						<select id="month" name="month" class="select">
						<option value="" selected>월</option>
						<c:forEach var="i" begin="1" end="12">
						    <option value="${i}">${i}</option>
						</c:forEach>
						</select>
                    </div>
                    <table class="tbl" style="width:750px;">
                        <thead>
                          <tr>
                         	<th class="tbl-title">클래스번호</th>
                            <th class="tbl-title">클래스명</th>
                            <th class="tbl-title">강사명</th>
                            <th class="tbl-title">강사계정</th>
                            <th class="tbl-title">월별 총 수익</th>
                            <th class="tbl-title">정산금액</th>
                          </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </article>
            </div>
        </div>
    </div>

    <!--footer-->
    <%@ include file="/WEB-INF/views/common/footer.jsp"%>

	<script>
	$(function(){
		$('#year').on('change', function () { 
			$(".tbl tbody").html("");
		});
		$('#month').on('change', function () { 
			$(".tbl tbody").html("");
		});
		
	});
	</script>
        
        <script>
        
        $(function() { 
        	$('#year').on('change', function () { 
        		var year = $('#year').val();
        		
        		$('#month').on('change', function () { 
        			var month = $('#month').val();
        		
        			// 비동기식으로 테이블 데이터 조회해오기
        			$.ajax({
        				type: "GET", 
        				url: "${ contextPath }/payroll", 
        				data: { year: year, month: month }, 
        				datatype: "JSON", 
        				success: function (result) { 
        					console.log(result);
        					
        					var data = '';
        					$.each(result, function(i){
        							data += "<tr><td>" + result[i].nNum + "</td><td>" 
        							+ result[i].nTitle + "</td><td>" + result[i].userName
        							+ "</td><td>" + result[i].userId + "</td><td>" 
        							+ result[i].total + "</td><td>" + result[i].taxTotal
        							+ "</td></tr>";
        							
        							// $(".tbl tbody").append(data);
        					 });
        					// 테이블에 행 추가
        					$(".tbl tbody").html(data);
        					// 선택값 초기화
        					$("#year").val("");
        					$("#month").val("");
        					
        					
        				}, 
        					error: function (e) { 
        						console.log("조회오류 "); 
        						} 
        				})
        				$("data").remove();
        			
        		
        			});
        	});
        });
        

  </script>

</body>
</html>