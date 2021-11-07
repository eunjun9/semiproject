<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클래스 상세페이지</title>

	<!--외부 스타일 시트-->
    <link href="${ contextPath }/resources/css/lesson/lesson_detail.css?1" rel="stylesheet">
    <link href="${ contextPath }/resources/css/lesson/lesson_datepicker.css" rel="stylesheet">
    <!-- font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500&display=swap" rel="stylesheet">

    <!-- JQuery-->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

</head>
<body>

<div class="class_detail_wrapper">
    <!-- header -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
        
        <!-- 클래스 상세 페이지 헤더-->
        <div class="class_detail1">
            <div class="cDetail_h" >
                <h2 class="cMTitle">${ lesson.nTitle }<hr></h2>
                <img class="cThumbnail" src="${ contextPath }${ lesson.photoList.get(0).route }${ lesson.photoList.get(0).changeName }">
            </div>
            <h4 class="cTutor">강사</h4><p>${ lesson.userName }</p>
            <h4 class="cType">타입</h4><p>${ lesson.cCategory } 클래스 / ${ lesson.cType }</p>
        </div>
        
        <c:choose>
        	<c:when test="${ lesson.cCategory eq '온라인' || lesson.cType eq 'online'}" >
        			<div class="payment">
			            <h4 id="pTitle">${ lesson.nTitle }</h4>
			            <p id="pTime">${ lesson.cTime1 } 시간 <hr></p>
			            <h3 id="pPrice">50,000원</h3>
			            <button id="selCalBtn">수강하기</button>
					</div>
        	</c:when>
        	
        	<c:when test="${ lesson.cType eq '오프라인' || lesson.cType eq 'offline'}" >
       				 <div class="payment">
			            <h4 id="pTitle">${ lesson.nTitle }</h4>
			            <p id="pTime">${ lesson.cTime1 } ~ ${ lesson.cTime2 } <hr></p>
			            <h3 id="pPrice">50,000원</h3>
			            <button id="selCalBtn">수강하기</button>
	    			</div>

	    			 <script>
			            $(function(){ 
			                $("#selCalBtn").click(function(){ 
			                    $(".modal").fadeIn(); 
			                }); 
			                
			                 $("#payBtn").click(function(){ 
			                    if(confirm('결제화면으로 이동하시겠습니까?')){
			                    	// 결제 화면 
			                        // location.href = "${contextPath}/";
			                    }  else {
			                        $(".modal").fadeOut(); 
			                    }
			                 }); 
			                 $("#cartBtn").click(function(){ 
			                	var confirm = confirm('장바구니에 추가하시겠습니까?');
			                    if(confirm == true){
			                        // 확인 눌렀을 때 장바구니로 이동
			                        var nNum = ${'#nNum'}.val();
			                    	location.href = "${contextPath}/wishlist/add?nNum="+ nNum;
			                    }else if(confirm == false){
			                    	// 취소 눌렀을 때 
			                    	 $(".modal").fadeOut(); 
			                    } else {
			                        $(".modal").fadeOut(); 
			                    }
			                 }); 
			            });
			            </script>
        	</c:when>
        </c:choose>
       


    <div class="modal">
            <div class="container">
                <div class="my-calendar clearfix">
                  <div class="clicked-date">
                    <div class="cal-day"></div>
                    <div class="cal-date"></div>
                  </div>
                  <div class="calendar-box">
                    <div class="ctr-box clearfix">
                      <button type="button" title="prev" class="btn-cal prev">
                      </button>
                      <span class="cal-month"></span>
                      <span class="cal-year"></span>
                      <button type="button" title="next" class="btn-cal next">
                      </button>
                    </div>
                    <table class="cal-table">
                      <thead>
                        <tr>
                          <th>일</th>
                          <th>월</th>
                          <th>화</th>
                          <th>수</th>
                          <th>목</th>
                          <th>금</th>
                          <th>토</th>
                        </tr>
                      </thead>
                      <tbody class="cal-body"></tbody>
                    </table>
                  </div>
                </div>
            </div>
              
            <div class="cPayBtn">
                <button id="cartBtn">장바구니</button>
                <button id="payBtn">결제하기</button>
            </div> 

    </div>

    <script>
    const init = {
      monList: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
      dayList: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
      today: new Date(),
      monForChange: new Date().getMonth(),
      activeDate: new Date(),
      getFirstDay: (yy, mm) => new Date(yy, mm, 1),
      getLastDay: (yy, mm) => new Date(yy, mm + 1, 0),
      nextMonth: function () {
        let d = new Date();
        d.setDate(1);
        d.setMonth(++this.monForChange);
        this.activeDate = d;
        return d;
      },
      prevMonth: function () {
        let d = new Date();
        d.setDate(1);
        d.setMonth(--this.monForChange);
        this.activeDate = d;
        return d;
      },
      addZero: (num) => (num < 10) ? '0' + num : num,
      activeDTag: null,
      getIndex: function (node) {
        let index = 0;
        while (node = node.previousElementSibling) {
          index++;
        }
        return index;
      }
    };
    
    const $calBody = document.querySelector('.cal-body');
    const $btnNext = document.querySelector('.btn-cal.next');
    const $btnPrev = document.querySelector('.btn-cal.prev');
    
    /**
     * @param {number} date
     * @param {number} dayIn
    */
    function loadDate (date, dayIn) {
      document.querySelector('.cal-date').textContent = date;
      document.querySelector('.cal-day').textContent = init.dayList[dayIn];
    }
    
    /**
     * @param {date} fullDate
     */
    function loadYYMM (fullDate) {
      let yy = fullDate.getFullYear();
      let mm = fullDate.getMonth();
      let firstDay = init.getFirstDay(yy, mm);
      let lastDay = init.getLastDay(yy, mm);
      let markToday;  // for marking today date
   
      if (mm === init.today.getMonth() && yy === init.today.getFullYear()) {
        markToday = init.today.getDate();
      }
    
      document.querySelector('.cal-month').textContent = init.monList[mm];
      document.querySelector('.cal-year').textContent = yy;
    
      let trtd = '';
      let startCount;
      let countDay = 0;
      for (let i = 0; i < 6; i++) {
        trtd += '<tr>';
        for (let j = 0; j < 7; j++) {
          if (i === 0 && !startCount && j === firstDay.getDay()) {
            startCount = 1;
          }
          if (!startCount) {
            trtd += '<td>'
          } else {
            let fullDate = yy + '.' + init.addZero(mm + 1) + '.' + init.addZero(countDay + 1);
            trtd += '<td class="day';
            trtd += (markToday && markToday === countDay + 1) ? ' today" ' : '"';
            trtd += ` data-date="${countDay + 1}" data-fdate="${fullDate}">`;
          }
          trtd += (startCount) ? ++countDay : '';
          if (countDay === lastDay.getDate()) { 
            startCount = 0; 
          }
          trtd += '</td>';
        }
        trtd += '</tr>';
      }
      $calBody.innerHTML = trtd;
    }
    
    /**
     * @param {string} val
     */
    function createNewList (val) {
      let id = new Date().getTime() + '';
      let yy = init.activeDate.getFullYear();
      let mm = init.activeDate.getMonth() + 1;
      let dd = init.activeDate.getDate();
      const $target = $calBody.querySelector(`.day[data-date="${dd}"]`);
     
      let date = yy + '.' + init.addZero(mm) + '.' + init.addZero(dd);
    
      let eventData = {};
      eventData['date'] = date;
      eventData['memo'] = val;
      eventData['complete'] = false;
      eventData['id'] = id;
      init.event.push(eventData);
      $todoList.appendChild(createLi(id, val, date));
    }
    
    
    loadYYMM(init.today);
    loadDate(init.today.getDate(), init.today.getDay());
    
    $btnNext.addEventListener('click', () => loadYYMM(init.nextMonth()));
    $btnPrev.addEventListener('click', () => loadYYMM(init.prevMonth()));
    
    $calBody.addEventListener('click', (e) => {
      if (e.target.classList.contains('day')) {
        if (init.activeDTag) {
          init.activeDTag.classList.remove('day-active');
        }
        let day = Number(e.target.textContent);
        loadDate(day, e.target.cellIndex);
        e.target.classList.add('day-active');
        console.log(day);
        init.activeDTag = e.target;
        init.activeDate.setDate(day);
        reloadTodo();
    }
});
</script>
    
    

<!-- 클래스 상세 페이지 바디-->
<div class="class_detail2">
    <hr>
    <h4>클래스 소개</h4>
    <div class="cDetail_b">
       <!--  <h3  id="cBodyText1">비싼 터프팅건 없이, <br>집에서 감각적인 소품을 만들어볼까요?</h3>
        <img name="cBodyImg1"  class="cBodyImg" src="../resources/image/body1.JPG">
        <pre class="cBodyText2">안녕하세요, 터프팅 작업 기법을 이용해 러그를 비롯해 다양한 실생활 소품을 만들고 있는 피스오브애플입니다. 
            터프팅이라는 말이 생소한 분들도 있을 거예요. 
            터프팅건이라는 총 모양의 기계를 이용해 원단에 실을 쏘아 모양을 만들어 내는 작업입니다.
        </pre>
        <br>
        <img name="cBodyImg2"  class="cBodyImg" src="../resources/image/body2.JPG">
        <pre class="cBodyText2">안녕하세요, 터프팅 작업 기법을 이용해 러그를 비롯해 다양한 실생활 소품을 만들고 있는 피스오브애플입니다. 
            터프팅이라는 말이 생소한 분들도 있을 거예요. 
            터프팅건이라는 총 모양의 기계를 이용해 원단에 실을 쏘아 모양을 만들어 내는 작업입니다.
        </pre> -->
         <pre class="cBodyText2">${ lesson.nContent }</pre>
        
        <hr>
    </div>
</div>

<!-- 클래스 상세 페이지 푸터-->
<div class="class_detail3">
    <h4>강사 소개</h4>
    <pre id="cTutorIntro">${ lesson.cTutor }</pre> <hr>
    
    <h4>위치</h4>
    <p id="cPlace">${ lesson.cLocation }</p><hr>
    <h4>환불 정책</h4>
    <p>환불 정책에 따라 클래스 수강일로부터 7일 전 까지 전액 환불이 가능합니다.</p><hr>
    
    <!-- 문의사항 나중에 처리 -->
    <!-- <h4>문의 사항</h4>
    <div class="cQnA">
        <form>
            <input type="text" name="cQuestion" placeholder=" 강사님께 문의하실 내용을 입력해주세요." size="110">
            <button name="qSubmit" class="qBtn">등록</button><br>
            <div class="outer">
                <p class="cQuestion1"> 가져가야 될 준비물이 있을까요?</p>
                <p class="aStatus">답변 대기</p>
                작성자 본인만 가능
                <textarea class="cAnswer" placeholder="답변을 작성해주세요."></textarea>
                <button name="aSubmit" class="aBtn">등록</button> 
            </div>
            <div class="outer">
                <p class="cQuestion2"> 가져가야 될 준비물이 있을까요?</p>
                <p class="aStatus">답변 완료</p>
                <p class="cAnswer" >아니요 준비물은 없습니다.</p>
            </div>
            <div class="outer">
                <p class="cQuestion2"> 가져가야 될 준비물이 있을까요?</p>
                <p class="aStatus">답변 완료</p>
                <p class="cAnswer" >아니요 준비물은 없습니다.</p>
            </div>
            <div class="outer">
                <p class="cQuestion2"> 가져가야 될 준비물이 있을까요?</p>
                <p class="aStatus">답변 완료</p> 
                <p class="cAnswer" >아니요 준비물은 없습니다.</p>
            </div>
        </form> -->

            <div class="btnArea">
              <button onclick="location.href='${ contextPath }/lesson/main'">목록보기</button>
              <!-- 작성자 본인만 가능 -->
              <c:if test="${ loginUser.userId == lesson.userId }">
              <button onclick="updateLessonView();">수정하기</button>
              <button onclick="deleteLesson();">삭제하기</button>
              </c:if>
            </div>
    </div>
    
    <!-- 문의사항 스크립트 -->
    <script>
        $('.cQuestion2').click(function(){
            if($(this).siblings('.cAnswer').css('display') == 'none'){ // question다음의 컨텐츠 영역이 display=none일 때
                $('p.cAnswer').slideUp();       // 기존에 열려있는 콘텐츠는 닫고
                $(this).siblings('.cAnswer').slideDown();  // 클릭한 메뉴의 콘텐츠는 밑으로 스르륵 내려오게
            }else{
                $(this).siblings('.cAnswer').slideUp();    // display=none 이 아닐 때 클릭 시 위로 올라가게
            }
        });
        </script>
	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</div>
	
	<c:if test="${ loginUser.userId == lesson.userId }">
		<form name="lessonForm" method="post">
			<input type="hidden" name="nNum" value="${ lesson.nNum }">
		</form>
		<script>
			function updateLessonView(){
				document.forms.lessonForm.action = "${ contextPath }/lesson/updateView";
				document.forms.lessonForm.submit();
			}
			
			function deleteLesson(){
				if(confirm("이 게시글을 삭제하시겠습니까?")){
					document.forms.lessonForm.action = "${ contextPath }/lesson/delete";
					document.forms.lessonForm.submit();
				}
			}
		</script>
	</c:if>

</body>
</html>