<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>페이지 디자인</title>
    <link rel="stylesheet" href="resources/membershipManagement.css">
    <script src="resources/membershipManagement.js" defer></script>
</head>
<body>
    <div class="header">
        <img src="/img/logo.png" alt="Logo" class="logo">
        <nav>
            <a href="#">홈</a>
            <a href="#">마이페이지</a>
            <a href="#">일정관리</a>
            <a href="#">회원관리</a>
        </nav>
    </div>

    <div class="block1">
        <div class="action-buttons">
            <button class="action-button" onclick="addMember()">회원 추가</button>
            <button class="action-button" onclick="editMember()">회원 수정</button>
            <button class="action-button" onclick="deleteMember()">회원 삭제</button>
        </div>
        <div class="search-bar">
            <input type="text" placeholder="검색">
            <button>검색</button>
        </div>
    </div>

    <div class="block2">
        <table id="memberTable">
            <thead>
                <tr>
                    <th>NO</th>
                    <th>회원명</th>
                    <th>성별</th>
                    <th>생년월일</th>
                    <th>횟수</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Item #1</td>
                    <td>Description</td>
                    <td>Description</td>
                    <td>Description</td>
                    <td>Description</td>
                </tr>
                <tr>
                    <td>Item #2</td>
                    <td>Description</td>
                    <td>Description</td>
                    <td>Description</td>
                    <td>Description</td>
                </tr>
                <tr>
                    <td>Item #3</td>
                    <td>Description</td>
                    <td>Description</td>
                    <td>Description</td>
                    <td>Description</td>
                </tr>
                <tr>
                    <td>Item #4</td>
                    <td>Description</td>
                    <td>Description</td>
                    <td>Description</td>
                    <td>Description</td>
                </tr>
            </tbody>
        </table>
    </div>
    
    <div class="block3">

    </div>

    <div class="footer">
        Sample text. Click to select the Text Element.
    </div>
</body>
</html>
