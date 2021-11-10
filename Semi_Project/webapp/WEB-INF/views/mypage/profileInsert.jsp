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
    <link rel="stylesheet" href="${ contextPath }/resources/css/mypage/profileRevise.css">

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
                
                
                
                <form method="post" name="modifyForm" action="${contextPath}/profile/insert" enctype="multipart/form-data">
                <input type ="hidden" name="userId" value="${profile.userId}">
				<input type="hidden" name="changeName">
				
				
					
                
                
                    <!--프로필-->
                    <div class="profile">
                    
                    <img>
                    <input type="file" name="pic" accept="image/gif,image/jpeg,image/png"> 
                    </div>
                    
                    

                    <!--자기소개-->
                    <div class="introduction">
                        <p>자기소개</p>
                        <textarea name="introduction">${profile.introduction}</textarea>
                    </div>

                    <!--피드, 모임내역-->
                    <div class="choose">

                    </div>

                    <div class="sns">
                        <div class="sns-title">
                            <p>SNS</p>
                        </div>

                        <div class="insta">
                            <textarea name="sns">${profile.sns}</textarea>
                        </div>
                        
                    </div>
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                     <%
                String[] checkedInterest = {"", "", "", "", "", "", "", 
                		"", "", "", "", "", "", "",
                		"", "", "", "", "", "", ""};
                
                Profile profile = new Profile();
                     
                
                if(profile.getInterest() != null){
                   String[] interest = profile.getInterest().split("\\|");
                   for(int i = 0; i < interest.length; i++){
                      switch(interest[i]){
                         case "마케팅" : checkedInterest[0] = "checked"; break;
                         case "브랜딩" : checkedInterest[1] = "checked"; break;
                         case "기획" : checkedInterest[2] = "checked"; break;
                         case "스타트업" : checkedInterest[3] = "checked"; break;
                         case "디자인" : checkedInterest[4] = "checked"; break;
                         case "개발" : checkedInterest[5] = "checked"; break;
                         case "영상" : checkedInterest[6] = "checked"; break;
                         case "유튜브" : checkedInterest[7] = "checked"; break;
                         case "음악" : checkedInterest[8] = "checked"; break;
                         case "미술" : checkedInterest[9] = "checked"; break;
                         case "영화" : checkedInterest[10] = "checked"; break;
                         case "시" : checkedInterest[11] = "checked"; break;
                         case "에세이" : checkedInterest[12] = "checked"; break;
                         case "소설" : checkedInterest[13] = "checked"; break;
                         case "힐링" : checkedInterest[14] = "checked"; break;
                         case "철학" : checkedInterest[15] = "checked"; break;
                         case "요리" : checkedInterest[16] = "checked"; break;
                         case "와인" : checkedInterest[17] = "checked"; break;
                         case "한국술" : checkedInterest[18] = "checked"; break;
                         case "사케" : checkedInterest[19] = "checked"; break;
                         case "맥주" : checkedInterest[20] = "checked"; break;
                      }
                   }
         
                }
             %>
                    

                    <div class="interest">
                        <div class="interest-title">관심사</div>
                        <div class="career">커리어</div>
                        <div class="career-checkbox">
                            <input type="checkbox" name="interest" value="마케팅" <%= checkedInterest[0] %>><label for="marketing">마케팅</label>
                            <input type="checkbox" name="interest" value="브랜딩" <%= checkedInterest[1] %>><label for="branding">브랜딩</label>
                            <input type="checkbox" name="interest" value="기획" <%= checkedInterest[2] %>><label for="planning">기획</label>
                            <input type="checkbox" name="interest" value="스타트업" <%= checkedInterest[3] %>><label for="startup">스타트업</label>
                                                        <br>
                            <input type="checkbox" name="interest" value="디자인" <%= checkedInterest[4] %>><label for="design">디자인</label>
                            <input type="checkbox" name="interest" value="개발" <%= checkedInterest[5] %>><label for="developement">개발</label>
                            <input type="checkbox" name="interest" value="영상" <%= checkedInterest[6] %>><label for="video">영상</label>
                            <input type="checkbox" name="interest" value="유튜브" <%= checkedInterest[7] %>><label for="youtube">유튜	브</label>
                        </div>

                        <div class="culture">문화예술</div>
                        <div class="culture-checkbox">
                        <input type="checkbox" name="interest" value="음악" <%= checkedInterest[8] %>><label for="music">음악</label>
                            <input type="checkbox" name="interest" value="미술" <%= checkedInterest[9] %>><label for="art">미술</label>
                            <input type="checkbox" name="interest" value="영화" <%= checkedInterest[10] %>><label for="movie">영화</label>
                        
                        </div>

                        <div class="write">글쓰기</div>
                        <div class="write-checkbox">
                        <input type="checkbox" name="interest" value="시" <%= checkedInterest[11] %>><label for="poem">시</label>
                            <input type="checkbox" name="interest" value="에세이" <%= checkedInterest[12] %>><label for="essay">에세이</label>
                            <input type="checkbox" name="interest" value="소설" <%= checkedInterest[13] %>><label for="novel">소설</label>
                        </div>

                        <div class="lifestyle">라이프스타일</div>
                        <div class="lifestyle-checkbox">
                        <input type="checkbox" name="interest" value="힐링" <%= checkedInterest[14] %>><label for="healing">힐링</label>
                            <input type="checkbox" name="interest" value="철학" <%= checkedInterest[15] %>><label for="philosophy">철학</label>
                        </div>

                        <div class="food">푸드 드링크</div>
                        <div class="food-checkbox">
                         <input type="checkbox" name="interest" value="요리" <%= checkedInterest[16] %>><label for="cooking">요리</label>
                            <input type="checkbox" name="interest" value="와인" <%= checkedInterest[17] %>><label for="wine">와인</label>
                             <input type="checkbox" name="interest" value="한국술" <%= checkedInterest[18] %>><label for="korea">한국술</label>
                            <br>
                             <input type="checkbox" name="interest" value="사케" <%= checkedInterest[19] %>><label for="sake">사케</label>
                            <input type="checkbox" name="interest" value="맥주" <%= checkedInterest[20] %>><label for="beer">맥주</label>
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


<script src="${ contextPath }/resources/js/imagePreview.js"></script>


  	<!-- footer -->
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

    </div>


</body>

</html>