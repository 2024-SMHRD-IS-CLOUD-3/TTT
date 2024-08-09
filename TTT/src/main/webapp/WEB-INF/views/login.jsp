<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>T.T.T Trainer Time Table</title>
    <link rel="stylesheet" href="resources/login.css">
</head>
<body>
  <div class="sidebar">
    <img src="resources/로고1.png" alt="T.T.T 로고" class="logo">
    <button class="home-button" onclick="location.href='/'">홈으로</button>
  </div>
  <div class="login-wrap">
  
    <div class="login-html">
      <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">로그인</label>
      <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">회원가입</label>
      
      
      <div class="login-form">
      
      	<form action="loginCheck" method="post">
        <div class="sign-in-htm">
          <div class="group">
            <label for="user" class="label">ID</label>
            <input name="id" id="user" type="text" class="input">
          </div>
          <div class="group">
            <label for="pass" class="label">비밀번호</label>
            <input name="pw" id="pass" type="password" class="input" data-type="password">
          </div>
          <div class="group">
            <input id="check" type="checkbox" class="check" checked>
            <label for="check"><span class="icon"></span> 로그인 상태 유지</label>
          </div>
          <div class="group">
            <input type="submit" class="button" value="로그인">
          </div>
          <div class="hr"></div>
          <div class="foot-lnk">
            <a href="#forgot">비밀번호를 잃어버리셨습니까?</a>
          </div>
        </div>
        </form>
        
        <form action="registTrainer" method="post">
        <div class="sign-up-htm">
          <div class="group">
            <label for="user" class="label">아이디</label>
            <input name="id" id="user" type="text" class="input">
          </div>
          <div class="group">
            <label for="pass" class="label">비밀번호</label>
            <input name="pw" id="pass" type="password" class="input" data-type="password">
          </div>
          <div class="group">
          <!-- TODO#1 비밀번호, 비밀번호확인 일치하는지 체크하는 코드 작성 -->
            <label for="repeat-pass" class="label">비밀번호 확인</label>
            <input id="repeat-pass" type="password" class="input" data-type="password">
          </div>
          <div class="group">
            <label for="name" class="label">이름</label>
            <input name="name" id="name" type="text" class="input">
          </div>
          <!-- TODO#2 생년월일을 달력으로 선택할 수 있게 코드 작성 -->
          <div class="group">
            <label for="birthdate" class="label">생년월일</label>
            <input name="birthdate" id="birthdate" type="date" class="input">
          </div>
          <div class="group">
            <label for="phone" class="label">전화번호</label>
            <input name="phone" id="phone" type="text" class="input">
          </div>
          <div class="group">
            <label for="email" class="label">이메일</label>
            <input name="email" id="email" type="text" class="input">
          </div>
          <div class="group">
            <input type="submit" class="button" value="회원가입">
          </div>
          <div class="hr"></div>
          <div class="foot-lnk">
            <label for="tab-1">이미 회원이신가요?</label>
          </div>
        </div>
        </form>
        
        
      </div>
    </div>
    
  </div>
</body>
</html>

