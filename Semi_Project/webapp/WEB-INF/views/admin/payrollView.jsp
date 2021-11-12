<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지_정산내역</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/admin/admin-style.css">
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
                    <div class="admin-menu">
                        <ul id="menu">
                          <li class="member menu">
                            <a href="${ contextPath }//mypage/adminmain">회원관리</a> 
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
                        <select id="year" name="year" class="select">
                        <!-- db에서 year 추출해서 가져오기(년도는 계속 추가되기 때문에).. -->
                        <option value="${ year }">년</option>
						</select>
						 
						 <!-- 1부터 12까지 forEach로 반복해서 option value 넣어주기 -->
						<select id="month" name="month" class="select">
						<option value="">월</option>
						<c:forEach var="i" begin="1" end="12">
						    <option value="${i}">${i}</option>
						</c:forEach>
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
        
        <script>
        
        $(function() { 
        	$('#year').on('change', function () { 
        		year = $(this).val(); 
        		month = $(this).val(); 
        		
        		if (month != "") {
        			jQuery.ajax({
        				type: "GET", 
        				url: "${ contextPath }/payroll", 
        				data: { category: '1', year: ${ year }, month: month }, 
        				datatype: "JSON", 
        				success: function (result) { 
        					
        					var html = "<tr><td>" + result.클래스명 + "</td><td>" + result.강사명 + "</td><td>"
								+ result.강사계정 + "</td><td>" + result.강사groupby월별합계 + "</td><td>" + result.정산금액(수수료뺀)
								+ "</td></tr>";
								$("#tbl tbody").append(html);
								
        						}); 
        					}, 
        					error: function (e) { 
        						console.log("조회오류 "); 
        						} 
        					}); 
        			} else { 
        				$("#tbl tbody").attr("disabled", true);
        				}
        			});

        	
        	
        	
        	
        });

        
        
        
        
        
        
        
        
        
        
        
        
        $(function(){
        	$("#year option:selected").val()
			$("#btn7").click(function(){
				$.ajax({
					url : "${ pageContext.servletContext.contextPath }/jqTest7",
					data : { userNo : $("#input7").val() },
					dataType : "json",
					type : "get",
					success : function(user) {
						console.log(user);
						/* table8의 tbody에 행으로 응답된 user 정보 추가 */
						
						if(user) {
							var html = "<tr><td>" + user.no + "</td><td>" + user.name + "</td><td>"
									+ user.age + "</td><td>" + user.gender + "</td></tr>";
									$("#table7 tbody").append(html);
						}else{
							alert('사용자 정보가 없습니다.');
						}
					},
					error : function(e) {
						console.log(e);
					}
				
				})
			});
			
		});
        </script>

</body>
</html>