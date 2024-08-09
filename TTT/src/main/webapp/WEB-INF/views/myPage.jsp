<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>프로필 변경</title>
    <link rel="stylesheet" href="resources/myPage.css">
</head>
<body>
    <div class="container">
        <div class="profile-section">
            <h2>프로필 변경</h2>
            <div class="current-profile-picture">
                <!-- <h3>현재 프로필 사진:</h3> -->
                <img src="current-profile-picture.jpg" alt="현재 프로필 사진" width="150">
            </div>
            <form action="/update-profile-picture" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="profile-picture">프로필 사진:</label>
                    <input type="file" id="profile-picture" name="profile-picture" accept="image/*">
                </div>
                <button type="submit">사진 변경</button>
            </form>
            
        </div>
        <div class="details-section">
            <h2>개인정보 수정</h2>
            <form action="/update-details" method="post">
                <div class="form-group">
                    <label for="username">아이디</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="form-group">
                    <label for="username"> 이름</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="form-group">
                    <label for="email">이메일</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="username">전화번호</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="form-group">
                    <label for="password">비밀번호</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <div class="form-group">
                    <label for="confirm-password">비밀번호 확인</label>
                    <input type="password" id="confirm-password" name="confirm-password" required>
                </div>
                <button type="submit">수정</button>
            </form>
        </div>
    </div>
</body>
</html>
