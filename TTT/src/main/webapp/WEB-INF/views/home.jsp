<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang='en'>
  <head>
    <meta charset='utf-8' />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>T.T.T Trainer Time Table</title>
    <link rel="stylesheet" href="resources/home.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> <!-- jQuery를 사용하기 위해 추가 -->
  </head>
  <body>
    <header class="header">
        <div class="logo">
            <img src="resources/image/logo.png" alt="T.T.T 로고">
        </div>
        <nav class="nav">
            <ul>
                <li><a href="goMyPage" class="protected">마이페이지</a></li>
                <li><a href="goMain" class="protected">일정관리</a></li>
                <li><a href="selectUser" class="protected">회원관리</a></li>
            </ul>
        </nav>
    </header>

    <div class="block1" style="background-image: url('resources/image/home2.jpg'); background-size: cover; background-position: center;">
        <div class="overlay">
            <h1>T . T . T<br>Trainer Time Table</h1>
            <h3>효율적인 트레이닝, 성공적인 일정관리</h3>
            <br>
            
            <c:if test="${not empty loginTrainer}">
                <form action="logout" method="post">
                    <button type="submit" style="background-color: #6c757d; color: white;">로그아웃</button>
                </form>
            </c:if>
            <c:if test="${empty loginTrainer}">
                <button><a href="goLogin" style="text-decoration: none; color: white;">로그인</a></button>
            </c:if>
        </div>
    </div>

    <div class="block2">
        <h2>효율적인 트레이닝을 위한 최선의 선택</h2>
        <p>당신의 시간과 고객, 특수한 회원들을 위한 서비스를 제공합니다.</p>
        <button>소개 페이지</button>
    </div>

    <div class="block3">
        <h2>TTT 주요 기능</h2>
        <p>TTT에서는 다음과 같은 서비스를 제공합니다.</p>
        <div class="features">
            <div class="feature">
                <img src="resources/image/아이콘1.jpg" alt="아이콘1">
                <h3>일정관리</h3>
                <p>바쁜 일정을 쉽게 관리하고 한 눈에 볼 수 있는<br> 캘린더 서비스</p>
            </div>
            <div class="feature">
                <img src="resources/image/아이콘2.png" alt="아이콘2">
                <h3>회원 관리</h3>
                <p>소중한 회원들을 편리하게 관리하기 위한 <br>회원관리 서비스</p>
            </div>
            <div class="feature">
                <img src="resources/image/아이콘3.png" alt="아이콘3">
                <h3>자세 인식</h3>
                <p>교정이 필요한 특수한 회원들을 보조하기 위한<br> 자세 인식 서비스</p>
            </div>
        </div>
    </div>

    <footer class="footer">
        <p>Copyright © 2024-2024 Smart Human Resources Developmont 저작권법의 보호를 안 받으니까 알아하쇼.</p>
    </footer>

    <script>
        $(document).ready(function(){
            var isLoggedIn = ${not empty loginTrainer}; // 로그인 여부 확인

            $(".protected").click(function(event){
                if (!isLoggedIn) { // 로그인이 안되어 있을 경우
                    event.preventDefault(); // 기본 링크 이동 막기
                    alert("로그인이 필요합니다."); // 경고창 띄우기
                    window.location.href = "goLogin"; // 로그인 페이지로 이동
                }
            });
        });
    </script>
  </body>
</html>

