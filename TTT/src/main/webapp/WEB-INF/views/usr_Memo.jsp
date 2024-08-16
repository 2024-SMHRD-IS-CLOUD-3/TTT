<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메모장 페이지</title>
    <link rel="stylesheet" href="resources/usr_Memo.css">
</head>
<body>
    <div class="header">
        <img src="resources/logo.png" alt="Logo" class="logo">
        <nav>
            <a href="/">홈</a>
            <a href="goMyPage">마이페이지</a>
            <a href="goMain">일정관리</a>
            <a href="goUsr_Management">회원관리</a>
        </nav>
    </div>

    <div class="main-content">
        <div class="sidebar">
            <div class="profile">
                <div class="profile-image">
                    <img src="${getProfile_img}" alt="프로필 사진">
                </div>
                <div class="profile-name">
                    <p>${getName}</p>
                </div>
            </div>
        </div>

        <div class="block1">
            <div class="header-controls">
                <div class="header-title">
                    <h1>트레이닝 일지 및 메모장</h1>
                </div>
                <div class="controls">
                    <button id="addNoteButton">추가</button>
                </div>
            </div>
            <div id="noteContainer" class="note-container">
                <!-- 메모지가 추가될 영역 -->
            </div>
        </div>
    </div>

    <footer class="footer">
        <p>  Copyright © 2024-2024 Smart Human Resources Developmont 저작권법의 보호를 안 받으니까 알아하쇼.</p>
    </footer>

    <script src="resources/js/usr_Memo.js"></script>
</body>
</html>
