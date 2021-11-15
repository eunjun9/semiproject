<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.soda.mypage.model.vo.Profile"%>

    
    <!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이 피드 메인</title>

    <!-- 외부 스타일 시트 -->
    <link rel="stylesheet" href="${ contextPath }/resources/css/mypage/othersFeedMain.css">

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

                <!-- 아이디 누르면 마이페이지로 이동-->
                <div class=id>
                    <a href="javascript:history.back();">&lt; back</a>
                </div>

                <!-- 사진부분-->
                <div class="photo-follow">
                    <div class="photo">
                        <div class="profile">
                        <c:choose>
                         
                         <c:when test="${not empty profile.profileFile.get(0).changeName}">
                            <img src="${ contextPath }${ profile.profileFile.get(0).route}${profile.profileFile.get(0).changeName}">
                          </c:when>
                          <c:otherwise>
                           <img src="${ contextPath }/resources/images/yewon/profile.png">
                          </c:otherwise>
                          </c:choose>
                        </div>

                        <div class="name-grade">
                            <div class="name">
                                <p>${ others.userName }</p>
                            </div>
                            <div class="grade">
                                <p>${others.userGrade}</p>
                            </div>
                        </div>
                    </div>

                    <!--팔로우-->
                    <div class="follow">
                        <div class="follow-num">

                            <div class="post-num-name">
                                <div class="post-num">
                                    <p>234</p>
                                </div>
                                <div class="post-name">
                                    <p>게시물</p>
                                </div>
                            </div>

                            <div class="post-num-name">
                                <div class="post_num">
                                    <p>345</p>
                                </div>
                                <div class="post-name">
                                    <p>팔로워</p>
                                </div>
                            </div>

                            <div class="post-num-name">
                                <div class="post-num">
                                    <p>433</p>
                                </div>
                                <div class="post-name">
                                    <p>팔로잉</p>
                                </div>
                            </div>
                        </div>

                        

                        <div class="email">
                            <p>${ others.userId }</p>
                        </div>

                    </div>
                </div>
                
              


                <div class="content">

                    <div class="content-inner">

                        <!--자기소개-->
                        <div class="introduction">
                        
                        <div class="tag-par">

                         <c:choose>
                                <c:when test="${!empty list }">
                            <c:forEach var="i" items="${ list }">
                            <div class="tag">
                              <p> ${i}</p>
                            </div>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                        <div class="tag">
                              <p></p>
                              </div>
                        </c:otherwise>
                        </c:choose>
                        </div>
                        
                        
                            <div class="intro">
                                <p class="intro-p">자기소개</p>
                               
                                <textarea class="intro-text">${ others.introduction }</textarea>
                                
                                
                                <p class="sns">SNS</p>
                              <p class="sns-text">${ others.sns }</p>
                            </div>
			
			
                         
                        
                         <!--피드 사진들-->
                    
            </div>
                    </div>
               <div class="img-par">
                    <div class="imgs">
                    <c:forEach var="magazine" items="${othersList}">
                    <div class="pics" onclick="detailView(${ magazine.nNum })">
               <img src="${ contextPath }${ magazine.photoList.get(0).route }${ magazine.photoList.get(0).changeName }">
               </div>
                   </c:forEach>
                   </div>
                   </div>
                  
                   
        </div>
    </div>
    
    </div>
    





    


    </div>
    
    <!-- footer -->
   <%@ include file="/WEB-INF/views/common/footer.jsp" %>

<script>
         function detailView(nNum){
            location.href = '${contextPath}/magazine/detail?nNum=' + nNum;
         }
   
         
   </script>


</body>

</html>