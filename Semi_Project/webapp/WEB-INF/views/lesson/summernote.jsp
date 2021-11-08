<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- 썸머노트 -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script> 
    <script src="lang/summernote-ko-KR.js"></script>

    <link href="${ contextPath }/resources/css/lesson/lesson_form.css?3" rel="stylesheet">
</head>
<body>

  <div id="form_body">
                    <hr><br>
                    <h4>클래스 소개를 작성하세요</h4>
                    <!--썸머노트-->
                    <textarea class="summernote" name="editordata"></textarea>
  </div>

 <!-- 썸머노트 스크립트 -->
    <script>
    $(document).ready(function() {
    	  $('#summernote').summernote();
    	});
    </script>
</body>
</html>