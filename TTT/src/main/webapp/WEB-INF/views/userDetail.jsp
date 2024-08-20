<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원 상세 페이지</title>
<link rel="stylesheet" href="resources/userDetail.css">
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
	<form action="/goModifyUser" method="post">
	<section class="block1">
		<div class="profile-pic">
			<img src="resources/image/${userDetail.profileImg}" alt="">
			<button class="profile-change-btn">프로필 사진 변경</button>
		</div>
		<div class="profile-info">
				<h1>${userDetail.name}</h1>
				<ul>
					<li>전화번호: ${userDetail.phone}</li>
					<li>주소: ${userDetail.address}</li>
					<li>생년월일: ${userDetail.birthdate}</li>
					<li>키: ${userDetail.height}</li>
					<li>몸무게: ${userDetail.weight}</li>
					<li>성별: ${userDetail.gender}</li>
					<li>횟수: ${userDetail.count}</li>
			</ul>
			<div class="buttons">
				<button>출석</button>
				<button>수정</button>
			</div>
		</div>
	</section>
	</form>

	<section class="block2">
		<div class="stat-card">
			<a href="goUserSchedule?userId=${userDetail.id}">
				<div class="stat-image">
					<img src="resources/image/calendar.png" alt="">
				</div>
				<div class="stat-text">
					<div class="stat-label">달력</div>
			</a>
		</div>
		</div>
		<div class="stat-card">
			<div class="stat-image">
				<a href="goMemo?userId=${userDetail.id}"> <img src="resources/image/memo.png"
					alt="Image description">
			</div>
			<div class="stat-text">
				<div class="stat-label">메모장</div>
				</a>
			</div>
		</div>
		<div class="stat-card">
			<div class="stat-image">
				<a href="pose/Gallery?userId=${userDetail.id}"> <img src="resources/image/photoalbum.png"
					alt="Image description">
			</div>
			<div class="stat-text">
				<div class="stat-label">사진첩</div>
				</a>
			</div>
		</div>
	</section>

	<footer class="footer">
		<p>Copyright © 2024-2024 Smart Human Resources Developmont 저작권법의
			보호를 안 받으니까 알아하쇼.</p>
	</footer>
</body>
</html>
