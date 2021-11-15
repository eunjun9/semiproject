<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.soda.mypage.model.vo.Profile"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>프로필 수정</title>

    <!-- 외부 스타일 시트 -->
    <link rel="stylesheet" href="${ contextPath }/resources/css/mypage/profileModify.css">

    <!-- favicon (Real Favicon Generator)-->
    <link rel="icon" type="image/x-icon" href="resources/image/khfavicon.ico">
    
    <!-- 글꼴 -->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <!--font-family: 'Noto Sans KR', sans-serif;-->

    <!-- JQuery-->
    <script src="../js/jquery-3.6.0.min.js"></script>


</head>

<body>
    <!-- header -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
 


    <!--body-->
    <div class="body-super">
        <div class="body-inner">
            <div class="body-inner-blue">
                <div class="body-inner2">
                
                
                
                <form method="post" name="modifyForm" action="${contextPath}/profile/insertview" enctype="multipart/form-data" onclick="return checks()">
                <input type ="hidden" name="userId" value="${profile.userId}">
				<input type="hidden" name="changeName">
				
				
					
                
                
                    <!--프로필-->
                    <div class="profile">
                    
                   <img src="${ contextPath }/resources/images/yewon/profile.png">
                    <input type="file" name="pic" accept="image/gif,image/jpeg,image/png"> 
                    </div>
                    
                    

                    <!--자기소개-->
                    <div class="introduction">
                        <p>자기소개</p>
                        <textarea id="introduction" name="introduction"></textarea>
                    </div>

                    <!--피드, 모임내역-->
                    <div class="choose">

                    </div>

                    <div class="sns">
                        <div class="sns-title" id="sns-title">
                            <p>SNS</p>
                        </div>

                        <div class="insta">
                            <textarea name="sns" id="sns"></textarea>
                        </div>
                        
                    </div>
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
               
                    

                    <div class="interest">
                        <div class="interest-title">관심사</div>
                        <div class="career">커리어</div>
                        <div class="career-checkbox">
                            <input type="checkbox" name="interest" id="interest" value="마케팅"><label for="marketing">마케팅</label>
                            <input type="checkbox" name="interest" id="interest" value="브랜딩" ><label for="branding">브랜딩</label>
                            <input type="checkbox" name="interest" id="interest" value="기획" ><label for="planning">기획</label>
                            <input type="checkbox" name="interest" id="interest" value="스타트업" ><label for="startup">스타트업</label>
                                                        <br>
                            <input type="checkbox" name="interest" id="interest" value="디자인"><label for="design">디자인</label>
                            <input type="checkbox" name="interest"  id="interest" value="개발"><label for="developement">개발</label>
                            <input type="checkbox" name="interest"  id="interest" value="영상"><label for="video">영상</label>
                            <input type="checkbox" name="interest" id="interest" value="유튜브"><label for="youtube">유튜	브</label>
                        </div>

                        <div class="culture">문화예술</div>
                        <div class="culture-checkbox">
                        <input type="checkbox" name="interest" id="interest" value="음악"><label for="music">음악</label>
                            <input type="checkbox" name="interest" id="interest" value="미술"><label for="art">미술</label>
                            <input type="checkbox" name="interest" id="interest" value="영화"><label for="movie">영화</label>
                        
                        </div>

                        <div class="write">글쓰기</div>
                        <div class="write-checkbox">
                        <input type="checkbox" name="interest" id="interest" value="시"><label for="poem">시</label>
                            <input type="checkbox" name="interest" id="interest" value="에세이" ><label for="essay">에세이</label>
                            <input type="checkbox" name="interest" id="interest" value="소설" ><label for="novel">소설</label>
                        </div>

                        <div class="lifestyle">라이프스타일</div>
                        <div class="lifestyle-checkbox">
                        <input type="checkbox" name="interest" id="interest" value="힐링"><label for="healing">힐링</label>
                            <input type="checkbox" name="interest"  id="interest" value="철학" ><label for="philosophy">철학</label>
                        </div>

                        <div class="food">푸드 드링크</div>
                        <div class="food-checkbox">
                         <input type="checkbox" name="interest" id="interest" value="요리"><label for="cooking">요리</label>
                            <input type="checkbox" name="interest" id="interest" value="와인"><label for="wine">와인</label>
                             <input type="checkbox" name="interest" id="interest" value="한국술"><label for="korea">한국술</label>
                            <br>
                             <input type="checkbox" name="interest" id="interest" value="사케"><label for="sake">사케</label>
                            <input type="checkbox" name="interest" id="interest" value="맥주" ><label for="beer">맥주</label>
                        </div>
                    </div>
                    
                    <div class="btn_area">
						<button class="button" type="button">취소하기</button>
						<button class="submit" type="submit">저장하기</button>

					</div>
                    
	
				</form>		

                </div>
            </div>
        </div>
    </div>


<script>

function checks(){

	var getIntroduction = document.getElementById("introduction");
	var getSns = document.getElementById("sns");
var getInterest = document.getElementById("interest");

var introduction = getIntroduction.value;

var sns = getSns.value;

var interest = getInterest.value;

if(!regExp.test(introduction)) { 
alert("자기 소개를 입력해주세요"); 
getIntroduction.value =""; 
getIntroduction.focus(); 
return false;
} else if(!regExp.test(sns)){
	alert("sns를 등록해주세요"); 
	getIntroduction.value =""; 
	getIntroduction.focus(); 
	return false;
	
} if(document.data.interest[0].checked==false && 
		document.data.interest[1].checked==false && 
		document.data.interest[2].checked==false && 
		document.data.interest[3].checked==false && 
		document.data.interest[4].checked==false && 
		document.data.interest[5].checked==false && 
		document.data.interest[6].checked==false && 
		document.data.interest[7].checked==false && 
		document.data.interest[8].checked==false && 
		document.data.interest[9].checked==false && 
		document.data.interest[10].checked==false && 
		document.data.interest[11].checked==false && 
		document.data.interest[12].checked==false && 
		document.data.interest[13].checked==false && 
		document.data.interest[14].checked==false && 
		document.data.interest[15].checked==false && 
		document.data.interest[16].checked==false && 
		document.data.interest[17].checked==false && 
		document.data.interest[18].checked==false && 
		document.data.interest[19].checked==false && 
		document.data.interest[20].checked==false && 
		document.data.interest[21].checked==false){ //체크박스 
	alert("박스 체크좀"); 
		return false;
}


}

</script>


<!-- <script>
<script>
// 사용자 입력 값 유효성 검사용 함수
function validate(){
	// 알맞은 값 입력 시 넘어가게 js로 구현
	return true;
}

$("#idCheck").on('click', function(){
	
	var userId = $("[name=userId]");
	// 아이디 중복 시 false, 아이디 사용 가능 시 true 값을 가지는 변수
	var isUsable = false;
	
	if(!userId || userId.val().length < 4) {
		alert("아이디는 최소 4자리 이상이어야 합니다.");
		userId.focus();
	} else {
		$.ajax({
			url : "${contextPath}/idCheck",
			type : "post",
			data : { userId : userId.val() },
			success : function(result) {
				console.log(result);
				if(result == "fail"){
					alert("사용할 수 없는 아이디입니다.");
					userId.focus();
				} else{
					if(confirm("사용 가능한 아이디입니다. 사용하시겠습니까?")){
						// 더 이상 아이디 입력 공간을 바꿀 수 없도록 처리
						userId.attr('readonly', true);
						/* 사용 가능한 아이디라는 flag */
						isUsable = true;
					} else {
						// 다시 아이디 입력 공간을 바꿀 수 있도록 처리
						userId.attr('readonly', false);
						userId.foucs();
						/* 사용 불가능한 아이디라는 flag */
						isUsable = false;
					}
				}
				/* 아이디 중복 체크 후 중복이 아니며 사용하겠다고 선택한 경우
				버튼의 disabled 속성 제거 */
				if(isUsable){
					$("#joinBtn").removeAttr("disabled");
				} else {
					$("#joinBtn").attr("disabled", true);
				}
			},
			error : function(e) {
				console.log(e);
			}
		});
	}

});

</script> -->




<script src="${ contextPath }/resources/js/imagePreview.js"></script>


  	<!-- footer -->
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

    </div>


</body>

</html>