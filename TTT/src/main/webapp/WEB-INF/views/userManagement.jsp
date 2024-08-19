<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>페이지 디자인</title>
<link rel="stylesheet" href="resources/userManagement.css">
<script src="resources/js/userManagement.js" defer></script>
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

   <div class="block1">
      <div class="action-buttons">
         <button class="action-button" onclick="addMember()">
            <a href="goUserRegistration">회원 추가</a>
         </button>
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
               <th>비고</th>
            </tr>
         </thead>
         <c:forEach items="${userList}" var="user" varStatus="i">
                  <tr>
                     <td>${i.count}</td>
                     <td><a href="goDetailUser?userId=${user.usr_Id}">${user.usr_Name}</a></td>
                     <td>${user.usr_Gender}</td>
                     <td>${user.usr_Birthdate}</td>
                     <td>${user.count}</td>
                     <td><a href="goDeleteUser?userId=${user.usr_Id}" style="color: black">삭제</td>
                  </tr>
        </c:forEach>
      </table>
   </div>

   <div class="block3"></div>

   <div class="footer">Copyright © 2024-2024 Smart Human Resources
      Developmont 저작권법의 보호를 안 받으니까 알아하쇼.</div>
</body>
</html>
