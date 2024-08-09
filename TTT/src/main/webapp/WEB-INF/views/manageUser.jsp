<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>		
			<div id="userList">
				<table id = "userList" border="1">
					<tr>
						<td>NO</td>
						<td>이름</td>
						<td>성별</td>
						<td>전화번호</td>
						
					</tr>
					<c:forEach items="${userList}" var="user" varStatus="i">
						<tr>
							<td>${i.count}</td>
							<td><a href="goDetailUser?urId=${user.urId}">${user.urName}</a></td>
							<td>${user.urGender}</td>
							<td>${user.urPhone}</td>
							<td><a href="goDeleteUser?urId=${user.urId}" style="color: black">삭제</td>
						</tr>
					</c:forEach>
				</table>
				
				<a href="goCreateUser"><button id="createUser">회원추가</button></a>
			</div>

</body>
</html>