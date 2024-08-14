<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원페이지</title>
    <link rel="stylesheet" href="/resources/memberSchedule.css">
	<link href="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/main.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js"></script>
	<script src="resources/calendar.js"></script>
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
    <div class="sidebar">
        <div class="profile">
            <div class="profile-image">
                <img src="/img/face.jpg" alt="">
            </div>
            <div class="profile-name">
                <p>홍길동</p>
            </div>
        </div>
    </div>
    <div class="main-content">
        <div class="block1">
            <div id="calendar"></div>
        </div>
    </div>
    <footer class="footer">
        <p>Sample text. Click to select the Text Element.</p>
        <p>Image from Freepik</p>
    </footer>
</body>
</html>