<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<head>
   <meta charset="UTF-8">
   <title>매거진 게시글 작성</title>

   <!-- 외부 스타일 시트 -->
   <link href="../css/magazineWrite.css" rel="stylesheet">
   <link href="../css/Headerfooter.css" rel="stylesheet">

   <!-- favicon (Real Favicon Generator)-->
   <link rel="icon" type="image/x-icon" href="resources/image/khfavicon.ico">

   <!-- 글꼴 -->
   <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
   <!--font-family: 'Noto Sans KR', sans-serif;-->

   <!-- JQuery-->
   <script src="../js/jquery-3.6.0.min.js"></script>

   <!-- 썸머노트 -->
   <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
   <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
   <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
   <script src="lang/summernote-ko-KR.js"></script>
</head>


<body>

   <!--header-->

   <div class="header">
      <div class="head-inner">

         <div class="logo">
            <img src="../image/logo.png">
         </div>

         <div class="big-category">
            <div class="category1">
               <a href="#">SOCIALING</a>
               <a href="#">CLASS</a>
               <a href="#">MAGAZINE</a>
            </div>
            <div class="category2">
               <a href="#">CART</a>
               <a href="#">MYPAGE</a>
            </div>
         </div>

      </div>
   </div>

   <div class="body-super">
      <div class="body-inner">

         <div class="board_content">
            <!-- 
               파일 업로드를 위해서는 반.드.시 enctype을 지정해주어야 함 : 인코딩 타입 지정
               application/x-www-form-urlencoded
               : 기본값, 모든 문자들은 서버로 보내지기 전에 인코딩 됨을 명시
               multipart/form-data
               : 모든 문자들을 인코딩하지 않음을 명시
               이 방식은 form 요소가 파일이나 이미지를 서버로 전송할 때 사용
               text/plain
               : 공백 문자(만)는 "+" 기호로 변환하지만, 나머지 문자는 모두 인코딩 되지 않음을 명시
             -->
            <form method="post" action="${ contextPath }/gallery/insert" enctype="multipart/form-data">

               <div class="title-big">
                  <div class="title">작성하기</div>
               </div>
               <div class="content">
                  <h4>
                     <span class="title_span">&nbsp;</span> 카테고리
                  </h4>
                  <span class="input_area"> <select name="category">
                        <option value="10">소셜링</option>
                        <option value="20">원데이클래스</option>
                        <option value="30">VOD</option>
                        <option value="40">기타</option>
                     </select>
                  </span>
                  <h4>
                     <br>
                     <span class="title_span">&nbsp;</span> 제목
                  </h4>
                  <span class="input_area"> <input type="text" name="title" required>
                  </span>

                  <h4>
                     <br>
                     <span class="title_span">&nbsp;</span> 내용
                  </h4>
                  <div id="form_body">
                     <!--썸머노트-->
                     <textarea class="summernote" name="editordata"></textarea>
                  </div>
               </div>

               <div class="btn_area">
                  <button class="button" type="button">목록으로</button>
                  <button class="submit" type="submit">작성하기</button>
               </div>
            </form>
         </div>
      </div>
   </div>
   </div>

   <script src="${ contextPath }/resources/js/imagePreview.js"></script>


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


   <!--footer-->
   <div class="footer">
      <div class="foot-inner">
         <div class="foot-logo">
            S O D A</div>
         <div class="information">
            <ul>주식회사 소셜 다이닝</ul>
            <ul>대표 : 홍길동 | 개인정보관리책임자 : 홍길동 | 전화 : 02-123-4567 | 이메일 : soda@gmail.com</ul>
            <ul>주소 : 서울 강남구 테헤란로 14길 6 남도빌딩 2층 | 사업자등록번호 : 000-00-00000</ul>
            <ul> 통신판매 : 제 2021-서울강남-0000호</ul>
            <ul>영업시간 : 월-금 오후 2시-7시</ul>
         </div>
         <div class="foot-category">
            <ul><a href="#">소다소개</a></ul>
            <ul><a href="#">공지사항 </a></ul>
            <ul><a href="#">강사신청</a></ul>
            <ul><a href="#">자주묻는질문</a></ul>
         </div>


      </div>
   </div>
   <div class="final">
      <div class="foot-final">
         <a href="#">이용약관 | </a>
         <a href="#">개인정보처리방침 | </a>
         <a href="#">사업자정보확인</a>
      </div>
   </div>

</body>

</html>