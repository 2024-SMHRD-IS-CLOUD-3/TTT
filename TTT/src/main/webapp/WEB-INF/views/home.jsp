<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang='en'>
  <head>
    <meta charset='utf-8' />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>T.T.T Trainer Time Table</title>
    <link rel="stylesheet" href="resources/home.css">

    
  </head>
 <body>
    <header class="header">
        <div class="logo">
            <img src="resources/image/logo.png" alt="T.T.T 로고">
        </div>
        <nav class="nav">
            <ul>
                <li><a href="goMyPage">마이페이지</a></li>
                <li><a href="goMain">일정관리</a></li>
                <li><a href="userList">회원관리</a></li>
            </ul>
        </nav>
    </header>

    <div class="block1" style="background-image: url('resources/image/home2.jpg'); background-size: cover; background-position: center;">
        <div class="overlay">
            <h1>T . T . T<br>Trainer Time Table</h1>
            <h3>효율적인 트레이닝, 성공적인 일정관리</h3>
            <br>
            <button><a href="goLogin">로그인</a></button>
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
                <img src="resources\아이콘1.jpg" alt="아이콘1">
                <h3>일정관리</h3>
                <p>바쁜 일정을 쉽게 관리하고 한 눈에 볼 수 있는<br> 캘린더 서비스</p>
                <button><a href ="goMain">이동하기</a></button>
            </div>
            <div class="feature">
                <img src="resources/아이콘2.png"  alt="아이콘2">
                <h3>회원 관리</h3>
                <p>소중한 회원들을 편리하게 관리하기 위한 <br>회원관리 서비스</p>
                <button><a href ="goUsr_Management">이동하기</a></button>
            </div>
            <div class="feature">
                <img src="resources/아이콘3.png" alt="아이콘3">
                <h3>자세 인식</h3>
                <p>교정이 필요한 특수한 회원들을 보조하기 위한<br> 자세 인식 서비스</p>
                <button><a href ="goUsr_gallery">이동하기</a></button>
            </div>
            <div class="feature">
                <img src="resources/아이콘4.png" alt="아이콘4">
                <h3>게시판</h3>
                <p>타 트레이너들과 생각을 의논하고 공유할 수 있는 <br>게시판 서비스</p>
                <button><a href ="#">이동하기</a></button>
            </div>
        </div>
    </div>

    <footer class="footer">
        <p>Copyright © 2024-2024 Smart Human Resources Developmont 저작권법의 보호를 안 받으니까 알아하쇼.</p>
    </footer>
        <script>
        // 여기에 로그인 여부를 확인하는 로직을 구현합니다.
        // 예를 들어, 로그인 상태를 나타내는 변수로 isLoggedIn을 사용할 수 있습니다.
        var isLoggedIn = true; // 실제 구현에서는 이 값을 서버에서 받아와야 합니다.

        // 페이지가 로드될 때 실행되는 함수
        document.addEventListener("DOMContentLoaded", function() {
            if (isLoggedIn) {
                var loginButton = document.getElementById("loginButton");
                if (loginButton) {
                    loginButton.style.display = "none";
                }
            }
        });
    </script>
    
    
</body>
</html>
