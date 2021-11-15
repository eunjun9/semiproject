<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클래스 수정</title>

    <!--외부 스타일 시트-->
    <link href="${ contextPath }/resources/css/lesson/lesson_form.css?6" rel="stylesheet">

    <!-- font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500&display=swap" rel="stylesheet">
    
</head>
<body>
    <!-- header -->
     <%@ include file="/WEB-INF/views/common/header.jsp" %> 

 	<!-- 글 작성 폼 -->
    <div class="class_form">
        <div class="cForm_title">
            <a id="back" href="${ contextPath }/lesson/main">&lt; 클래스</a>
            <h2 id="main-title">클래스 수정</h2>
            <h4 id="sub-title">모든 입력폼은 필수 영역입니다.</h4>
        </div>
        <div id="cForm_wrapper">
            <form method="post" action="${ contextPath }/lesson/update"
					enctype="multipart/form-data">
					<input type="hidden" name="nNum" value="${ lesson.nNum }"> 
					<c:forEach items="${ lesson.photoList }" var="photo"> <!-- bid와 함께 (수정 전 원래)사진의 unique값인 changeName도 같이 넘김 -->
					<input type="hidden" name="changeName" value="${ photo.changeName }">
					</c:forEach>	
					
                <h3>어떤 클래스인가요?</h3>
                                
                <h4 id="sub_title1">카테고리를 선택하세요</h4>
                    <select id="bigC" name="bigC">
                        <option value="big" disabled>대분류 선택</option>
                        <option value="art" id="art" <c:if test="${ lesson.ctag1 == 'art'}">selected </c:if>>예술</option>
                        <option value="food" id="food" <c:if test="${ lesson.ctag1 == 'food'}">selected </c:if>>음식</option>
                        <option value="sport" id="sport" <c:if test="${ lesson.ctag1 == 'sport'}">selected </c:if>>운동</option>
                    </select>
                    
                     <select name="smallC" id="smallC">
                        <option id="small" disabled>소분류 선택</option>
                        <option value="draw" class="artS" <c:if test="${ lesson.ctag2 == 'draw'}">selected </c:if>>드로잉</option>
                        <option value="instument" class="artS" <c:if test="${ lesson.ctag2 == 'instrument'}">selected </c:if>>악기</option>
                        <option value="illust" class="artS" <c:if test="${ lesson.ctag2 == 'illust'}">selected </c:if>>일러스트</option>
                        <option value="bake" class="foodS" <c:if test="${ lesson.ctag2 == 'bake'}">selected </c:if>>베이킹</option>
                        <option value="ws" class="foodS" <c:if test="${ lesson.ctag2 == 'ws'}">selected </c:if>>양식</option>
                        <option value="jp" class="foodS" <c:if test="${ lesson.ctag2 == 'jp'}">selected </c:if>>일식</option>
                        <option value="ch" class="foodS" <c:if test="${ lesson.ctag2 == 'ch'}">selected </c:if>>중식</option>
                        <option value="ko" class="foodS" <c:if test="${ lesson.ctag2 == 'ko'}">selected </c:if>>한식</option>
                        <option value="musc" class="sportS" <c:if test="${ lesson.ctag2 == 'musc'}">selected </c:if>>근력운동</option>
                        <option value="yoga" class="sportS" <c:if test="${ lesson.ctag2 == 'yoga'}">selected </c:if>>요가</option>
                        <option value="fila" class="sportS" <c:if test="${ lesson.ctag2 == 'fila'}">selected </c:if>>필라테스</option>
                    </select><br>
                    
                    <script>
                    	$('#small').show();
	           			$('.artS').hide();
	           		 	$('.foodS').hide();
	           		 	$('.sportS').hide();
                     $(document).on('change', '#bigC', changeoption);
                     
                     function changeoption(){
                    	 if($(this).val() == 'big'){
                    		 $('#small').show();
                    		 $('.artS').hide();
                    		 $('.foodS').hide();
                    		 $('.sportS').hide();
                    	 } else if($(this).val() == 'art'){
                    		 $('.artS').show();
                    		 $('.foodS').hide();
                    		 $('.sportS').hide();
                    		 $('#small').hide();
                    	 } else if($(this).val() == 'food'){
                    		 $('.foodS').show();
                    		 $('.artS').hide();
                    		 $('.sportS').hide();
                    		 $('#small').hide();
                    	 } else if($(this).val() == 'sport'){
                    		 $('.sportS').show();
                    		 $('.artS').hide();
                    		 $('.foodS').hide();
                    		 $('#small').hide();
                    	 } 
                     }
                    </script>
                    
                <h4 id="sub_title4">가격을 입력해주세요</h4> 
                <input type="text" name="cPrice" value="${ lesson.cPrice }" placeholder="'원' 빼고 입력" >원
                <hr>
                
                <h3>상세페이지를 작성해주세요</h3>
                <div id="detatil_wrapper">
                 <div id="form_head">
                    <textarea name="nTitle" id="sub_title6" placeholder="클래스 제목을 입력하세요(최대20자)">${ lesson.nTitle }</textarea>
                    <p id="lengthck"></p>
                    <hr>
                    <label>타입</label> 
                    <input type="radio" name="class_type" value="원데이" id="oneday" <c:if test="${lesson.cCategory == '원데이' }"> checked</c:if> disabled><label for="oneday" class="btnlabel">원데이 클래스</label>
                    <input type="radio" name="class_type" value="vod" id="vod" <c:if test="${lesson.cCategory == 'vod' }"> checked </c:if> disabled><label for="vod" class="btnlabel">VOD 클래스</label><br>
                </div> 
                <div id="img_wrapper">
                    <h4 id="sub_title5">썸네일/메인 이미지를 첨부해주세요</h4>
                    <div class="image_area"><img src="${ contextPath }${ lesson.photoList.get(0).route }${ lesson.photoList.get(0).changeName }"></div>
                    <button type="button" id="fileBtn">file</button><br>
                    <input type="file" name="cThumbnail" accept="image/gif,image/jpeg,image/png">
                </div>
                </div>
                
                <!-- 파일 버튼 스크립트 -->
			    <script>
			        let fileBtn = document.querySelector("#fileBtn");
			
			        const fileElements = document.querySelectorAll("[type=file]");
			        const imageArea = document.querySelectorAll(".image_area");
			
			        /* 버튼 클릭했을 때 input type file 오픈 */
			        fileBtn.onclick = function() {
			            fileElements[0].click();
			        }
			
			        /* input type file 요소에 change 이벤트 발생 시 (파일 첨부 발생) */
			        fileElements.forEach(item => item.addEventListener('change', preview));
			
			        function preview(){
			            let index = Array.from(fileElements).indexOf(this);
			            
			            if(this.files && this.files[0]) {
			                let reader = new FileReader();
			                reader.readAsDataURL(this.files[0]);
			                reader.onload = function(){
			                    imageArea[index].innerHTML = "<img src='" + reader.result + "'>";
			                }
			            }
			        }
			    </script>
                

               
                
                <script>
                	$("#sub_title6").keyup(function(e){
                		console.log("키업");
                		var content = $(this).val();
                		$("#lengthck").val(content.length +"/");
                		if(content.length > 20){
                			alert("최대 20자까지 입력 가능합니다.");
                			$("#sub_title6").focus();
                		}
                		
                	});
                </script>
                
 				 <div id="form_body">
                    <hr><br>
                    <h4>클래스 소개를  작성해주세요</h4>
                    <textarea class="summernote" name="editordata">${ lesson.nContent }</textarea>
					<div class="image_area2"><img src="${ contextPath }${ lesson.photoList.get(1).route }${ lesson.photoList.get(1).changeName}"></div>	
                    <button type="button" id="fileBtn2">file</button><br>
                    <input type="file" name="contentImg1" accept="image/gif,image/jpeg,image/png" id="imageinfo1">
  				</div>

 				<script>
                    let fileBtn2 = document.querySelector("#fileBtn2");
                
                    const fileElements2 = document.querySelectorAll("#imageinfo1");
                    const image_area2 = document.querySelectorAll(".image_area2");
                    /* 버튼 클릭했을 때 input type file 오픈 */
                    fileBtn2.onclick = function() {
                        fileElements2[0].click(); 
                    }
                
                    /* input type file 요소에 change 이벤트 발생 시 (파일 첨부 발생) */
                    fileElements2.forEach(item => item.addEventListener('change', preview2));
                
                    function preview2(){
                        let index2 = Array.from(fileElements2).indexOf(this);

                        if(this.files && this.files[0]) {
                            let reader2 = new FileReader();
                            reader2.readAsDataURL(this.files[0]);
                            reader2.onload = function(){
                                image_area2[index2].innerHTML = "<img src='" + reader2.result + "'>";
                            }
                        }

                    }
                </script>
                
                <script>
                    let fileBtn3 = document.querySelector("#fileBtn3");
                
                    const fileElements3 = document.querySelectorAll("#imageinfo2");
                    const image_area3 = document.querySelectorAll(".image_area3");
                    /* 버튼 클릭했을 때 input type file 오픈 */
                    fileBtn3.onclick = function() {
                        fileElements3[0].click(); 
                    }
                
                    /* input type file 요소에 change 이벤트 발생 시 (파일 첨부 발생) */
                    fileElements3.forEach(item => item.addEventListener('change', preview3));
                
                    function preview3(){
                        let index3 = Array.from(fileElements3).indexOf(this);

                        if(this.files && this.files[0]) {
                            let reader3 = new FileReader();
                            reader3.readAsDataURL(this.files[0]);
                            reader3.onload = function(){
                                image_area3[index3].innerHTML = "<img src='" + reader3.result + "'>";
                            }
                        }

                    }
                </script>
                
                <hr>  
                <h4>강사 소개를  작성해주세요</h4>
                <textarea name="tutor_intro" id="tutor_intro">${ lesson.cTutor }</textarea>
                
                <!-- 원데이 클래스 일때 -->
                <c:if test="${lesson.cCategory == '원데이' }">
                <div class="offdate">
                <h4>날짜를 선택하세요</h4>
                <input type="date" name="o_date1"  value="${ lesson.oDate1 }"><label>&nbsp;부터  &nbsp;</label><input type="date" name="o_date2" value="${ lesson.oDate2 }"><label>&nbsp;까지</label><br>
                </div>
                </c:if>
                
                <!-- vod 클래스 일때 -->
                <c:if test="${lesson.cCategory == 'vod' }">
                <div class="ondate">
                	<h4>기간을 입력하세요</h4>
                	<input type="text" name="v_date" value="${ lesson.vDate }"><label>&nbsp;일</label>
                </div>
                </c:if>
                
                <!-- 타입이 오프라인일때 -->
                <c:if test="${lesson.cCategory == '원데이' }">
                <div class="offtime">
					<h4>시간을 선택하세요</h4>
                	<input type="time" name="class_time1" value="${ lesson.cTime1 }"> <label>&nbsp;부터  &nbsp;</label><input type="time" name="class_time2" value="${ lesson.cTime2 }"> <label>&nbsp;까지</label><br>
                </div>
                </c:if>
                
                
				 	<c:if test="${lesson.cCategory == '원데이' }">
						<div class="location">
						 <h4>클래스 위치를 입력하세요</h4>
		                 <input type="text" name="postcode" class="postcodify_postcode5" placeholder="우편번호" readonly>
		                 <input type="text" name="address" class="postcodify_address" placeholder="검색버튼을 클릭하세요." readonly>
		                 <button id="location_Btn" type="button">검색</button><br>
		                 <input type="text" class="postcodify_details" name="detailaddress" placeholder="상세주소를 입력하세요" ><br>
						</div>
				 	</c:if>
            	
            		<!-- 주소 api -->
					<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script> -->
					<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
					 
					<!-- "검색" 단추를 누르면 팝업 레이어가 열리도록 설정한다 -->
					<script>
						$(function() {
							$("#location_Btn").postcodifyPopUp();
						});
					</script>
            
          		<div id = "submitwrapper">
                <button type="submit" id="cf_submit">클래스 등록</button>
                </div>
            </form>
        </div>
    </div>

	<!-- footer -->
   <%@ include file="/WEB-INF/views/common/footer.jsp" %> 

</body>
</html>