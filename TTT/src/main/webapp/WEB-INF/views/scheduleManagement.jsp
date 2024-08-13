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

        <div id="eventModal">
            <div id="eventModalContent">
                <h2 id="modalTitle"></h2>
                <label for="eventTitle">회원이름</label>
                <!-- TODO 회원이름은 디비에서 불러와야함 -->
                <input type="text" id="eventTitle" />
    
                <label for="eventDescription">세부사항</label>
                <!-- TODO 세부사항도 디비에서 불러와야함. + 수정도 할 수 있어야 함. -->
                <input type="text" id="eventDescription" />
<!--     
                <label for="eventStartDate">Start Date:</label>
                <input type="date" id="eventStartDate" />
                <label for="eventStartTime">Start Time:</label>
                <input type="time" id="eventStartTime" />
    
                <label for="eventEndDate">End Date:</label>
                <input type="date" id="eventEndDate" />
                <label for="eventEndTime">End Time:</label>
                <input type="time" id="eventEndTime" /> -->
    
                <button id="saveEvent">Save</button>
                <button id="deleteEvent">Delete</button>
                <button id="closeModal">Cancel</button>
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
