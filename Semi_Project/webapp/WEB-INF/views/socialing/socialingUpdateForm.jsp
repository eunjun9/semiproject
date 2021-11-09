<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소셜링_글 작성</title>

<!-- 외부 스타일 시트 -->
<link href="${ contextPath }/resources/css/socialing/socialing_form.css?2" rel="stylesheet">

<!-- 글꼴 (Noto Sans) -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

</head>
<body>
	<!--header-->
    <%@ include file="/WEB-INF/views/common/header.jsp" %>

    <!-- body -->
    <div class="writing body">
        <div class="body-inner">
            <div class="w-title">
                <a id="back" href="${ contextPath }/socialing/main">&lt; 소셜링</a>
                <p id="main-title">글 수정하기</p>
                <h3 id="sub-title">모든 입력폼은 필수 영역입니다.</h3>
            </div>
            <article id="wrapper">
            	<!-- 파일 업로드를 위해서 enctype 지정 -->
                <form method="post" action="${ contextPath }/socialing/update" enctype="multipart/form-data">
                	<input type="hidden" name="nNum" value="${ socialing.nNum }">
				<c:forEach items="${ socialing.photoList }" var="photo">
					<input type="hidden" name="changeName" value="${ photo.changeName }">
				</c:forEach>
                
                    <h1 id="w-main-title">어떤 활동을 하는 소셜링인가요?</h1>
                    <h4 id="w-sub-title">제목을 입력해 주세요 (최대 30자)</h4>
                    <input type="text" id="inputTitle" name="inputTitle" placeholder="연희동 카페투어 함께 가요!" 
                    value="${ soclaling.nTitle }" required>
                    
                    <h2 id="w-sub-title2">설명</h2>
                    <h4 id="w-sub-title3">썸네일 이미지를 첨부해주세요</h4>
                    <div class="image_area">
                    <img src="${ contextPath }${ socialing.photoList.get(0).route }${ socialing.photoList.get(0).changeName }"></div>
                    <button type="button" id="fileBtn">file</button><br>
                    <input type="file" name="thumbnail" accept="image/gif,image/jpeg,image/png" required>
                    <textarea id="content" name="content" placeholder="함께 이야기하고 싶은 주제나 꼭 알려주고 싶은 내용을 입력해 주세요"
                     required>${ socialing.nContent }</textarea>
                    <hr>
                    
                    <h1 id="w-main-title2">언제 어디서 만나나요?</h1>
                    <h4 id="w-sub-title4">날짜를 선택하세요</h4>
                    <input type="date" name="dateIn" value="${ socialing.sdate }" required>
                    <h4 id="w-sub-title5">시간을 선택하세요</h4>
                    <input type="time" name="timeIn" value="${ socialing.stime }" required>
                    <h4 id="w-sub-title5">장소를 입력하세요</h4>
                    <input type="radio" id="offline" name="type" value="OFF" <c:if test='${ socialing.stype == "OFF" }'>checked</c:if>>
                    <label for="offline">오프라인</label>
                    <input type="radio" id="online" name="type" value="ON" <c:if test='${ socialing.stype == "ON" }'>checked</c:if>>
                    <label for="online">온라인</label><br>
                    
					<div class="placeArea1">
			            <input type="text" id="inputPlace" name="inputPlace" class="postcodify_address" 
			            placeholder="ex. 서울특별시 강남구 테헤란로 / Zoom" value='${ socialing.splace.split("\\|")[0] }' required>&nbsp;&nbsp;
		            <!-- 오프라인 선택 시 출력 / 온라인 선택 시 숨김 -->
		            <span class="placeArea2" <c:if test='${ socialing.stype == "ON" }'>style="display:none"</c:if>>
			            <button type="button" class="search" id="postcodify_search_button">검색</button><br>
			            <input type="text" id="inputPlace2" name="inputPlace" class="postcodify_details" 
			            placeholder="상세 주소를 입력해 주세요" value='${ socialing.splace.split("\\|")[1] }'><br>
		            </span>
					</div>
                    
                    <h4 id="w-sub-title5">인원 설정</h4>
                    <select id="min" name="min">
                        <option value="2" <c:if test="${ socialing.minMember == 2 }">selected</c:if>>2명</option>
                        <option value="3" <c:if test="${ socialing.minMember == 3 }">selected</c:if>>3명</option>
                        <option value="4" <c:if test="${ socialing.minMember == 4 }">selected</c:if>>4명</option>
                        <option value="5" <c:if test="${ socialing.minMember == 5 }">selected</c:if>>5명</option>
                        <option value="6" <c:if test="${ socialing.minMember == 6 }">selected</c:if>>6명</option>
                        <option value="7" <c:if test="${ socialing.minMember == 7 }">selected</c:if>>7명</option>
                        <option value="8" <c:if test="${ socialing.minMember == 8 }">selected</c:if>>8명</option>
                    </select>
                    <p id="wave">~</p>
                    <select id="max" name="max">
                        <option value="2" <c:if test="${ socialing.maxMember == 2 }">selected</c:if>>2명</option>
                        <option value="3" <c:if test="${ socialing.maxMember == 3 }">selected</c:if>>3명</option>
                        <option value="4" <c:if test="${ socialing.maxMember == 4 }">selected</c:if>>4명</option>
                        <option value="5" <c:if test="${ socialing.maxMember == 5 }">selected</c:if>>5명</option>
                        <option value="6" <c:if test="${ socialing.maxMember == 6 }">selected</c:if>>6명</option>
                        <option value="7" <c:if test="${ socialing.maxMember == 7 }">selected</c:if>>7명</option>
                        <option value="8" <c:if test="${ socialing.maxMember == 8 }">selected</c:if>>8명</option>
                    </select><br>
                    
                    <div class="center">
                        <button type="submit" id="w-submit">소셜링 등록</button>
                    </div>
                </form>
            </article>
        </div>
    </div>

    <!-- jQuery와 Postcodify를 로딩한다 -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>

    <!-- "검색" 단추를 누르면 팝업 레이어가 열리도록 설정한다 -->
    <script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>

    <script>
    	// 썸네일 이미지 첨부 시 미리보기
        let fileBtn = document.querySelector("#fileBtn");

        const fileElements = document.querySelector("[type=file]");
        const imageArea = document.querySelector(".image_area");

        fileBtn.onclick = function() {
            fileElements.click();
        }

        fileElements.addEventListener('change', preview);

        function preview(){       
            if(this.files && this.files[0]) {
                let reader = new FileReader();
                reader.readAsDataURL(this.files[0]);
                reader.onload = function(){
                    imageArea.innerHTML = "<img src='" + reader.result + "'>";
                }
            }
        }
    </script>
    
    <script>
    	$(function(){
    		// 온라인, 오프라인 선택에 따른 입력창 변경
    		$("input:radio").change(checkedChange);

    		// min > max일 경우 경고창 출력 후 max와 같은 값으로 변경
    		$("#min").change(checkedMin);
    		// min > max일 경우 경고창 출력 후 min과 같은 값으로 변경
    		$("#max").change(checkedMax);
    	});
    	
    	function checkedChange() {
            if($(this).val() == 'ON') {
    			$(".placeArea2").css("display", "none");	
            } else {
    			$(".placeArea2").css("display", "inline");
            }
    	}
    	
    	function checkedMin() {
    		if($("#min").val() > $("#max").val()) {
    			alert('최소 인원이 최대 인원을 넘을 수 없습니다.');
    			$("#min").val($("#max").val());
    		}
    	}
    	
    	function checkedMax() {
    		if($("#min").val() > $("#max").val()) {
    			alert('최소 인원이 최대 인원을 넘을 수 없습니다.');
    			$("#max").val($("#min").val());
    		}
    	}
    </script>

    <!--footer-->
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>