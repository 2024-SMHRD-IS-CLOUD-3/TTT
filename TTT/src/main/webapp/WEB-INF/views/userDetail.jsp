<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원 상세 페이지</title>
<link rel="stylesheet" href="resources/usr_Member.css">
</head>
<body>
	<div class="header">
		<img src="resources/logo.png" alt="Logo" class="logo">
		<nav>
			<a href="/">홈</a> <a href="goMyPage">마이페이지</a> <a href="goMain">일정관리</a>
			<a href="goUserManagePage">회원관리</a>
		</nav>
	</div>
	<form action="/goModifyUser" method="post">
	<section class="block1">
		<div class="profile-pic">
			<img src=${user.Profile_Img } alt="프로필 사진">
			<button class="profile-change-btn">프로필 사진 변경</button>
		</div>
		<div class="profile-info">
				<h1>${user.usr_Name}</h1>
				<ul>
					<li>전화번호: ${user.usr_Phone}</li>
					<li>주소: ${user.usr_Addr}</li>
					<li>생년월일: ${user.usr_Birthdate}</li>
					<li>키: ${user.usr_Height}</li>
					<li>몸무게: ${user.usr_Weight}</li>
					<li>성별: ${user.usr_Gender}</li>
					<li>횟수: ${user.exer_Count}</li>
			</ul>
			<div class="buttons">
				<button>출석</button>
				<button>횟수 수정</button>
			</div>
		</div>
	</section>
	</form>

	<section class="block2">
		<div class="stat-card">
			<a href="#">
				<div class="stat-image">
					<img src="resources/calendar.png" alt="Image description">
				</div>
				<div class="stat-text">
					<div class="stat-label">달력</div>
			</a>
		</div>
		</div>
		<div class="stat-card">
			<div class="stat-image">
				<a href="#"> <img src="resources/memo.png"
					alt="Image description">
			</div>
			<div class="stat-text">
				<div class="stat-label">메모장</div>
				</a>
			</div>
		</div>
		<div class="stat-card">
			<div class="stat-image">
				<a href="#"> <img src="resources/photoalbum.png"
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
