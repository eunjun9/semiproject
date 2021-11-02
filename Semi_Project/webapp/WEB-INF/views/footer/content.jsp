<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소다소개</title>

	<!-- 외부 스타일 시트 -->
    <link href="resources/css/footer/footer_aboutsoda.css" rel="stylesheet">

    <!-- 글꼴 (Noto Sans) -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

</head>
<body>
    <!-- header -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	
    <!-- 소다 소개 본문 -->
    <div id="about_soda">
        <img src="resources/image/aboutsoda.jpg">
        <h1>S O D A</h1>
        <h4 id="title1">좋아하는 취향에서부터</h4>
        <h4 id="title2">좋아하게 될 사람들까지</h4>


        <h3 id="title3">소셜 다이닝, 소다는</h3>
        <pre id="content1">내 안의 다양한 가능성들에 주목하는 취향 기반의 모임 공동체입니다. 비교적 자유로운 모임을 즐길 수 있는 소셜링을 통해 각자의 취향에 맞는 사람들과 
취향에 맞는 시간을 즐길 수 있습니다. 새로운 취향을 탐색하기 위해 전문가에게 깊이있는 수업을 받을 수 있는 클래스는 짧게는 하루, 길게는 몇 개월에 걸쳐 
운영되고 있습니다. 혼자서 하기에는 어려운 일들도 함께 같이 하며, 서로를 통해 성장하는 시간을 가질 수 있습니다.  
        </pre>

        <div id="entire_wrapper">
            <div id="sub_title1">
                <h3>취향</h3>
                <pre class="content2"><b>취향 기반의 모임 공동체입니다.</b>
취향은 질문으로부터 시작합니다. 내가 원하는 것은
무엇인지, 이것은 왜 좋은지 나쁜지, 더 나은 것은 
없는지 궁금해 할 때, 우리는 깊어집니다. 남들과는 
좀 다른 내가 됩니다. 소다에서는 취향을 매개로 
해야 할 일들 사이에, 주어진 길 너머에 있는 내 안의 
또다른 가능성을 발견합니다.
                </pre>
            </div>
            
            <div id="sub_title2">
                <h3>깊이</h3>
                <pre class="content2"><b>더 깊이있는 모임 공동체입니다.</b>
좋아하니까 더 많이 알고 싶은 거죠. 그래서 우리는 
더 깊이 파고듭니다. 수박 겉 핥기 식의 지식이 아닌, 
깊이있는 클래스가 있습니다. 소다에는 좋아하는
것에 한 발 더 가까이 다가가는 즐거움이 있습니다.
                </pre>

            </div>

            <div id="sub_title3">
                <h3>사귐</h3>
                <pre class="content2"><b>즐거운 만남이 있는 모임입니다.</b>
좋은 벗과 함께라면 아무리 먼 길을 걸어도 외롭지 
않은 법이죠. 지금 우리에게 필요한 건 좋은 것을 
함께 나눌 수 있는 친구입니다. 문토에서는 취향이 
통하는 사람, 말이 통하는 사람들을 만날 수 있습니다.
                </pre>
            </div>
            
        </div>
    </div>
	
	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>