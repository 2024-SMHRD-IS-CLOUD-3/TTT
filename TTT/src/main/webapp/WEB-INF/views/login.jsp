<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인/회원가입 페이지</title>
<link rel="stylesheet" href="resources/login.css">
</head>
<body>

	<header class="header">
		<div class="logo">
			<img src="/resources/image/logo.png" alt="T.T.T 로고">
		</div>
		<nav class="nav">
			<ul>
				<li><a href="goMyPage">마이페이지</a></li>
				<li><a href="goMain">일정관리</a></li>
				<li><a href="goUsr_Management">회원관리</a></li>
			</ul>
		</nav>
	</header>

	<div class="black-box">
		<div class="toggle-container">
			<input type="radio" id="login" name="toggle" checked> <input
				type="radio" id="signup" name="toggle">
			<div class="login-block">
				<div class="toggle-labels">
					<label for="login" class="active">로그인</label> <label for="signup">회원가입</label>
				</div>
				<div class="forms">
					<div class="form login-form">
						 <form action="loginCheck" method="post">
							<label for="login-id">아이디</label>
							<input name="id" type="text" id="login-id" placeholder="ID" required>
							<label for="login-password">비밀번호</label>
							<input name="pw" type="password" id="login-password" placeholder="비밀번호" required> <label>
								<input type="checkbox" checked> 로그인 상태 유지
							</label>
							<button type="submit">로그인</button>
							<br> <br>
							<hr>
							<br> <a href="#">비밀번호를 잊어버리셨습니까?</a>
						</form>
					</div>
					<div class="form signup-form">
					<form action="registTrainer" method="post">
							<label for="signup-id">아이디</label>
							<input name="id" type="text" id="signup-id" placeholder="아이디" required>

							<label for="signup-password">비밀번호</label>
							<input name="pw" type="password" id="signup-password" placeholder="비밀번호" required>

							<label for="signup-password-confirm">비밀번호 확인</label>
							<input name="pwCheck" type="password" id="signup-password-confirm" placeholder="비밀번호 확인" required>

							<label for="signup-name">이름</label>
							<input name="name" type="text" id="signup-name" placeholder="이름" required>

							<label for="signup-birthdate">생년월일</label>
							<input name="birthdate" type="date" id="signup-birthdate" placeholder="생년월일" required>

							<label for="signup-phone">전화번호</label>
							<input name="phone" type="tel" id="signup-phone" placeholder="전화번호" required>

							<label for="signup-email">이메일</label>
							<input name="email" type="email" id="signup-email" placeholder="이메일" required>

							<button type="submit">회원가입</button>
							<br>
							<br>
							<hr>
							<br>
							<a href="goLogin">이미 회원이세요?</a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="footer">Copyright © 2024-2024 Smart Human Resources Developmont 저작권법의 보호를 안 받으니까 알아하쇼.</div>
	<script src="resources/js/login.js"></script>
</body>
</html>
