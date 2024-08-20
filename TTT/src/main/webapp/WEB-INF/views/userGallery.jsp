<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>갤러리 페이지</title>
<link rel="stylesheet"
	href="/resources/userGallery.css">
</head>
<body>
	<div class="header">
		<img src="/resources/image/logo.png"
			alt="Logo" class="logo">
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
				<img src="/resources/image/default_profile.png" alt="">
			</div>
			<div class="profile-name">
				<p>${poseUser.name}</p>
				<input type="hidden" id="userIdField" value="${poseUser.id}">
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
				<img id="firstImage" class="comparison-image"> <img
					id="secondImage" class="comparison-image">
			</div>
			<input type="range" id="opacityRange" min="0" max="100" value="50">
		</div>
	</div>

	<div class="main-content" id="mainContent">
		<div class="section" id="section1">
			<div class="content-header">
				<div class="gallery-title">갤러리</div>
				<div class="content-buttons">
					<button id="compareBtn">비교하기</button>
					<button id="addPhotoBtn">사진 추가</button> <!-- section2에서 실행 -->
				</div>
			</div>
		</div>

		<div class="section" id="section2">
			<!-- 데이터베이스에서 가져온 Pose 데이터를 반복하여 출력합니다. -->
			<c:forEach var="pose" items="${poses}">
                <div class="card" data-pose-id="${pose.poseIdx}">
                    <img src="${pageContext.request.contextPath}/resources/${pose.poseImg}" alt="Pose Image" />
                    <p>등록 일자: ${pose.createdAt}</p>
                    <p>타입: ${pose.poseType}</p>
                    <button class="delete-btn">삭제</button>
                </div>
            </c:forEach>
		</div>
	</div>

	<script src="/resources/js/userGallery.js"></script>
	 <script>
        document.querySelectorAll('.card').forEach(card => {
            const poseIdx = card.getAttribute('data-pose-id');
            addCardEventListeners(card, poseIdx);
        });
    </script>
</body>
</html>