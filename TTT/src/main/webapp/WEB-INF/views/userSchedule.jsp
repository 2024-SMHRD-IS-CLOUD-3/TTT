<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 페이지</title>
    <link rel="stylesheet" href="resources/userSchedule.css">
	  	<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js'></script>
	    <script>
	
	      document.addEventListener('DOMContentLoaded', function() {
	        var calendarEl = document.getElementById('calendar');
	        var calendar = new FullCalendar.Calendar(calendarEl, {
	          initialView: 'dayGridMonth'
	        });
	        calendar.render();
	      });
	
	    </script>
	
</head>
<body>
    <div class="header">
        <img src="resources/image/logo.png" alt="Logo" class="logo">
        <nav>
            <a href="/">홈</a>
            <a href="goMyPage">마이페이지</a>
            <a href="goMain">일정관리</a>
            <a href="selectUser">회원관리</a>
        </nav>
    </div>
    <div class="sidebar">
        <div class="profile">
            <div class="profile-image">
                <img src="#" alt="프로필 사진">
            </div>
            <div class="profile-name">
                <p>홍길동</p>
            </div>
        </div>
    </div>
    <div class="main-content">
        <div class="block1">
            <div class="block1" id='calendar'></div>
        </div>
    </div>
    <footer class="footer">
        <p> Copyright © 2024-2024 Smart Human Resources Developmont 저작권법의 보호를 안 받으니까 알아하쇼.</p>
    </footer>
</body>
</html>