<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 상세 페이지</title>
    <link rel="stylesheet" href="resources/scheduleManagement.css">
    <link href="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/main.min.css" rel="stylesheet">
    <link href="resources/calendar.css" rel="stylesheet">
</head>
<body>
    <div class="header">
        <img src="/resources/image/logo.png" alt="Logo" class="logo">
        <nav>
            <a href="/">홈</a>
            <a href="goMyPage">마이페이지</a>
            <a href="goMain">일정관리</a>
            <a href="selectUser" class="protected">회원관리</a>
        </nav>
    </div>

    <div class="block1">
        <div id="calendar"></div>
        
	    <!-- 모달 HTML 구조 -->
		<div id="eventModal">
	        <div class="modal-content">
	            <h2 id="modalTitle">Event Title</h2>
	
	            <input type="text" id="eventTitle" placeholder="제목">
	
	            <input type="text" id="eventDescription" placeholder="메모">
	
	            <input type="text" id="trainerId" placeholder="트레이너ID">
	
	            <input type="text" id="userId" placeholder="회원ID">
	
	            <input type="color" id="eventColor" value="#ff0000">
	
	            <input type="text" id="eventStatus" placeholder="일정 상태">
	
	            <button id="saveEvent" class="modal-button">저장</button>
	            <button id="deleteEvent" class="modal-delete-button">삭제</button>
	            <button id="closeModal" class="modal-close-button">닫기</button>
	        </div>
	    </div>

        <!-- FullCalendar JS -->
        <script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js"></script>

        <script src="resources/js/calendar.js"></script>
    
    </div>

    <div class="footer">
        <p>Sample text. Click to select the Text Element.</p>
    </div>
</body>
</html>
