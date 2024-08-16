<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 등록 페이지</title>
    <link rel="stylesheet" href="resources/usr_registration.css">
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

    <div class="form-container">
        <h2>회원등록</h2>
        <form>
            <label for="name">이름</label>
            <input type="text" id="name" placeholder="이름" required>

            <label for="phone">전화번호</label>
            <input type="tel" id="phone" placeholder="전화번호" required>

            <label for="address">주소</label>
            <input type="text" id="address" placeholder="주소" required>

            <label for="birthdate">생년월일</label>
            <input type="date" id="birthdate" required>

            <label for="height">키</label>
            <input type="number" id="height" placeholder="키(cm)" required>

            <label for="weight">몸무게</label>
            <input type="number" id="weight" placeholder="몸무게(kg)" required>

            <label for="gender">성별</label>
            <div class="gender">
                <input type="radio" id="male" name="gender" value="남자" required>
                <label for="male">남자</label>
                <input type="radio" id="female" name="gender" value="여자">
                <label for="female">여자</label>
            </div>

            <label for="sessions">횟수</label>
            <input type="number" id="sessions" placeholder="횟수" required>

            <button type="submit">등록</button>
        </form>
    </div>

    <div class="footer">
        Copyright © 2024-2024 Smart Human Resources Developmont 저작권법의 보호를 안 받으니까 알아하쇼.
    </div>
</body>
</html>
