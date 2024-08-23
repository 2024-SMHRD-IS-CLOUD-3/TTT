<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메모장 페이지</title>
    <link rel="stylesheet" href="resources/userMemo.css">
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

    <div class="main-content">
        <div class="sidebar">
            <div class="profile">
                <div class="profile-image">
                    <img src="/resources/image/default_profile.png" alt="">
                </div>
                <div class="profile-name">
                	<p>${memoUser.name}</p>
					<input type="hidden" id="userIdField" value="${memoUser.id}">
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
                <c:forEach var="memo" items="${memoList}">
					<div class="note" data-memo-id="${memo.memoIdx}">
						<div class="note-header">
							<div class="note-buttons">
								<button class="edit-btn">수정</button>
								<button class="delete-btn">삭제</button>
							</div>
						</div>
						<div class="note-content">${memo.memoContent}</div>
						<div class="note-footer">작성 날짜: ${memo.createdAt}</div>
					</div>
				</c:forEach>
            </div>
        </div>
    </div>

    <script src="resources/js/userMemo.js"></script>
    <script>
    document.querySelectorAll('.note').forEach(note => {
        const memoIdx = note.getAttribute('data-memo-id');
        addNoteEventListeners(note, memoIdx);
    });
    </script>
    <footer class="footer">
        <p>  Copyright © 2024-2024 Smart Human Resources Developmont 저작권법의 보호를 안 받으니까 알아하쇼.</p>
    </footer>

</body>
</html>
