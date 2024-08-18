<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>갤러리 페이지</title>
    <link rel="stylesheet" href="resources/usr_gallery.css">
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

    <div class="sidebar">
        <div class="profile">
            <div class="profile-image">
                <img src="#" alt="프로필 사진">
            </div>
            <div class="profile-name">
                <p></p>
            </div>
        </div>
    </div>

<!-- 비교하기 팝업 -->
<div id="compareModal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <h2>비교할 사진을 선택하세요</h2>
        <div id="imageSelection"></div>
        <button id="compareImagesBtn">비교하기</button>
    </div>
</div>

<!-- 비교 결과를 표시할 영역 -->
<div id="comparisonResult" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <h2>비교 결과</h2>
        <div class="comparison-container">
            <img id="firstImage" class="comparison-image">
            <img id="secondImage" class="comparison-image">
        </div>
        <input type="range" id="opacityRange" min="0" max="100" value="50">
    </div>
</div>
    

    <div class="main-content" id="mainContent">
        <div class="section" id="section1">
            <div class="content-header">
                <div class="gallery-title">
                    갤러리
                </div>
                <div class="content-buttons">
                    <button id="compareBtn">비교 하기</button>
                    <button id="addPhotoBtn">사진 추가</button>
                </div>
            </div>
        </div>

        <div class="section" id="section2">
            <!-- 카드가 추가될 곳 -->
        </div>
    </div>

    <div id="imageModal" class="modal">
        <span class="close">&times;</span>
        <img class="modal-content" id="modalImage">
    </div>

   

    <script src="resources/js/usr_gallery.js"></script>
</body>
</html>