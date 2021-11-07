<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클래스 등록</title>

    <!--외부 스타일 시트-->
    <link href="${ contextPath }/resources/css/lesson/lesson_form.css?4" rel="stylesheet">

    <!-- font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500&display=swap" rel="stylesheet">
    
    <!-- 썸머노트 -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
   

</head>
<body>
    <!-- header -->
     <%@ include file="/WEB-INF/views/common/header.jsp" %> 
         <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 		 <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script> 
		 <script src="${ contextPath }resources/js/summernote-ko-KR.js"></script> 
 	<!-- 글 작성 폼 -->
    <div class="class_form">
        <div class="cForm_title">
            <a id="back" href="${ contextPath }/lesson/main">&lt; 클래스</a>
            <h2 id="main-title">클래스 등록</h2>
            <h4 id="sub-title">모든 입력폼은 필수 영역입니다.</h4>
        </div>
        <div id="cForm_wrapper">
            <form method="post" action="${ contextPath }/lesson/insert"
					enctype="multipart/form-data">
                <h3>어떤 클래스인가요?</h3>
                                
                <h4 id="sub_title1">카테고리를 선택하세요</h4>
                    <select id="bigC" name="bigC" required>
                        <option value="big" selected disabled>대분류 선택</option>
                        <option value="art" id="art">예술</option>
                        <option value="food" id="food">음식</option>
                        <option value="sport" id="sport">운동</option>
                    </select>
                    
                     <select name="smallC" id="smallC" required>
                        <option id="small" selected disabled>소분류 선택</option>
                        <option value="10" class="artS">드로잉</option>
                        <option value="20" class="artS">악기</option>
                        <option value="30" class="artS">일러스트</option>
                        <option value="40" class="foodS">베이킹</option>
                        <option value="50" class="foodS">양식</option>
                        <option value="60" class="foodS">일식</option>
                        <option value="70" class="foodS">중식</option>
                        <option value="80" class="foodS">한식</option>
                        <option value="90" class="sportS">근력운동</option>
                        <option value="100" class="sportS">요가</option>
                        <option value="110" class="sportS">필라테스</option>
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
                <input type="text" name="cPrice" placeholder="'원' 빼고 입력" required>원
                <hr>
                
                <h3>상세페이지를 작성해주세요</h3>
                
                <div id="img_wrapper">
                    <h4 id="sub_title5">썸네일/메인 이미지를 첨부해주세요</h4>
                    <div class="image_area"></div>
                    <button type="button" id="fileBtn">file</button><br>
                    <input type="file" name="cThumbnail" accept="image/gif,image/jpeg,image/png" required>
                </div>

                <div id="form_head">
                    <textarea name="nTitle" id="sub_title6" placeholder="클래스 제목을 입력하세요(최대25자)" required></textarea>
                    <hr>
                    <label>타입</label> 
                    <input type="radio" name="class_type" value="원데이" id="oneday"><label for="oneday" class="btnlabel">원데이 클래스</label>
                    <input type="radio" name="class_type" value="vod" id="vod"><label for="vod" class="btnlabel">VOD 클래스</label><br>
                </div> 
                
                
 				 <div id="form_body">
                    <hr><br>
                    <h4>클래스 소개를 작성하세요</h4>
                    <textarea class="summernote" name="editordata"></textarea>
					<div class="image_area2"></div>
                    <button type="button" id="fileBtn2">file</button><br>
                    <input type="file" name="contentImg1" accept="image/gif,image/jpeg,image/png" id="imageinfo1">
                    <div id="img">
                    <div class="image_area3"></div>
                    <button type="button" id="fileBtn3">file</button><br>
                    <input type="file" name="contentImg
                    lesso2" accept="image/gif,image/jpeg,image/png" id="imageinfo2">
                    </div>
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


                 <!-- 썸머노트 스크립트 -->
   	 <script>
        $(document).ready(function(){
            $('.summernote').summernote({
                height : 300,
                minHeight :null,
                maxHeight: null,
                focus:true,
                lang:'ko-KR',
                toolbar: [
                    // [groupName, [list of button]]
                    ['fontname', ['fontname']]
                    , ['fontsize', ['fontsize']]
                    , ['style', ['bold', 'italic', 'underline', 'strikethrough', 'clear']]
                    , ['color', ['forecolor', 'color']]
                    , ['table', ['table']]
                    , ['para', ['ul', 'ol', 'paragraph']]
                    , ['height', ['height']]
                    , ['insert', ['picture', 'link', 'video']]
                    , ['view', ['fullscreen', 'help']]
                ] , 
                fontNames: ['Arial', 'Araial Black', 'Comic Sans MS', 'Courier New', '맑은 고딕', '궁서', 
                '굴림체', '굴림', '돋움체','바탕체'] ,
                fontSizes: ['8', '9', '10', '11', '12', '14', '16', '18', '20', '22', '24', '28', '30', '36'
                    , '40', '48', '50', '60', '72']
            })
        });
           
    </script> 
                
                <hr>  
                <h4>강사 소개를 작성하세요</h4>
                <textarea name="tutor_intro" id="tutor_intro" required></textarea>
                
                <!-- 원데이 클래스 일때 -->
                <div class="offdate">
                <h4>날짜를 선택하세요</h4>
                <input type="date" name="class_date" required><br>
                </div>
                
                <!-- vod 클래스 일때 -->
                <div class="ondate">
                	<h4>기간을 입력하세요</h4>
                	<input type="text" name="class_date"><label>&nbsp;일</label>
                </div>
                
                <!-- 타입이 오프라인일때 -->
                <div class="offtime">
					<h4>시간을 선택하세요</h4>
                	<input type="time" name="class_time1"> <label>&nbsp;부터  &nbsp;</label><input type="time" name="class_time2" > <label>&nbsp;까지</label><br>
                </div>
                
				<div class="location">
                <h4>클래스 위치를 입력하세요</h4>
                <input type="text" name="postcode" class="postcodify_postcode5" placeholder="우편번호" readonly>
                <input type="text" name="address" class="postcodify_address" placeholder="검색버튼을 클릭하세요." readonly>
                <button id="location_Btn" type="button">검색</button><br>
                <input type="text" class="postcodify_details" name="detailaddress" placeholder="상세주소를 입력하세요" ><br>
				</div>
            	
            		<!-- 주소 api -->
					<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script> -->
					<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
					 
					<!-- "검색" 단추를 누르면 팝업 레이어가 열리도록 설정한다 -->
					<script>
						$(function() {
							$("#location_Btn").postcodifyPopUp();
						});
					</script>
            
            
            	<script>
                	$(document).ready(function(){
                		$(".offdate").css("display", "none");    // 원데이 날짜
                		$(".ondate").css("display", "none");     // vod 날짜
                		$(".offtime").css("display", "none");    // 원데이 시간
                		$(".location").css("display", "none");   // 장소 
                		 
                		$("#oneday").change(function(){
                			$(".offdate").show(300);
                			$(".ondate").hide(300);
                			$(".offtime").show(300);
                            $(".location").show(300);
                		});
                		
                		$("#vod").change(function(){
                			$(".ondate").show(300);
                			$(".offdate").hide(300);
                			$(".offtime").hide(300);
                            $(".location").hide(300);
                		});
                		
                	});
                </script>	
            
                <button type="submit" id="cf_submit">클래스 등록</button>
            </form>
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

	<!-- footer -->
   <%@ include file="/WEB-INF/views/common/footer.jsp" %> 

</body>
</html>