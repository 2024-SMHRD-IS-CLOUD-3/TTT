<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>
    <link rel="stylesheet" href="resources/myPage.css">
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
<form action="registTrainer" method="post">
    <div class="profile-block">
        <div class="profile-image-container">
            <div class="profile-image">
                <img src= "profileImg" alt="">
            </div>
            <div class="profile-name">${loginTrainer.name}</div>
            <button class="change-photo">프로필 사진 변경</button>
        </div>
        <div class="profile-info">
            <label for="id">아이디</label>
            <input name="id" type="text" id="id" placeholder="${loginTrainer.id}">
        
            <label for="password">비밀번호</label>
            <input name="pw" type="password" id="password">
            
            <lable for="password">비밀번호 확인</lable>
            <input name="pw" type="password" id="password">
        
            <label for="birthdate">생년월일</label>
            <input name="birthdate" type="date" id="birthdate" placeholder="${loginTrainer.birthdate}">
        
            <label for="phone">전화번호</label>
            <input name="phone" type="tel" id="phone" placeholder="${loginTrainer.phone}">
        
            <label for="email">이메일</label>
            <input name="email" type="email" id="email" placeholder="${loginTrainer.email}">
        
        	
            <form action="logout" method="post">
                    <button class="update" type="submit">수   정</button>
            </form>
            <hr color="white">
            <form action="deleteTrainer" method="post">
            <button class="submit"><a href ="#">회원탈퇴</a></button>
        </div>
    </div>

    <div class="footer">
        Copyright © 2024-2024 Smart Human Resources Developmont 저작권법의 보호를 안 받으니까 알아하쇼.
    </div>
</body>
</html>
