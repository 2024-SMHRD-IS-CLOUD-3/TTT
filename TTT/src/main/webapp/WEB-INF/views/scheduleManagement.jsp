<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 상세 페이지</title>
    <link rel="stylesheet" href="resources/scheduleManagement.css">
    <link href="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/main.min.css" rel="stylesheet">
    <link href="resources/calendar.css" rel="stylesheet">
</head>
<body>
    <div class="header">
        <img src="/resources/logo.png" alt="Logo" class="logo">
        <nav>
            <a href="#">홈</a>
            <a href="#">마이페이지</a>
            <a href="#">일정관리</a>
            <a href="#">회원관리</a>
        </nav>
    </div>

    <div class="block1">
        <div id="calendar"></div>

       <!-- 모달 HTML 구조 -->
		<div id="eventModal">
        <div class="modal-content">
            <h2 id="modalTitle">Event Title</h2>

            <label for="eventTitle">Event Title</label>
            <input type="text" id="eventTitle" placeholder="Enter event title">

            <label for="eventDescription">Event Description</label>
            <input type="text" id="eventDescription" placeholder="Enter event description">

            <label for="trainerId">Trainer ID</label>
            <input type="text" id="trainerId" placeholder="Enter trainer ID">

            <label for="userId">User ID</label>
            <input type="text" id="userId" placeholder="Enter User ID">

            <label for="eventColor">Event Color</label>
            <input type="color" id="eventColor" value="#ff0000">

            <label for="eventStatus">Event Status</label>
            <input type="text" id="eventStatus" placeholder="Enter event status">

            <button id="saveEvent" class="modal-button">Save Event</button>
            <button id="deleteEvent" class="modal-delete-button">Delete Event</button>
            <button id="closeModal" class="modal-close-button">Close</button>
        </div>
    </div>

        <!-- FullCalendar JS -->
        <script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js"></script>

        <script src="resources/calendar.js"></script>
    
    </div>

    <div class="footer">
        <p>Sample text. Click to select the Text Element.</p>
    </div>
</body>
</html>
