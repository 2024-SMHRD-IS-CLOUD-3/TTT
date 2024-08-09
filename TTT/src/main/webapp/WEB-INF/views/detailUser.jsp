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
			<h3>회원 정보 페이지</h3>
			<a href="main"></a>
			<div id = "user">
			<form action="goModifyUser" method="post">
				 <div>
				<input type="hidden"  name = "urId" value = "${user.urId}">
				</div>
				<table id="list" border="1">
					<tr>
						<td>프로필</td>
						<%-- <img alt="" src="/boot/Users/smhrd/Desktop/test/${board.filename}"> --%>
					</tr>
					<tr>
						<td>이름</td>
						<td> <input type="text" name = "urName" value = "${user.urName}" readonly="readonly"></td>
					</tr>
					<tr>
					<tr>
						<td>성별</td>
						<td>
						<label class="label">
              			<input type="radio" name="urGender" class="input" value="남" checked>남
             			</label>
              			<label class="label">
              			<input type="radio" name="urGender" class="input" value="여">여
              			
            			</label>
            			</td>
						<%-- <td><input type="text" name = "urGender" value = "${user.urGender}"></td>--%>
						</tr>
						<tr>
						<td >전화번호</td> 
						<td><input type="text" name = "urPhone" value = "${user.urPhone}"></td>
					</tr>
					<tr>
						<td >주소</td>
						<td ><input type="text" name = "urAddress" value = "${user.urAddress}"></td>
					</tr>
					<tr>
						<td>키</td>
						<td><input type="text" name = "urHeight" value = "${user.urHeight}"></td>
					<tr>
					<tr>
						<td>몸무게</td>
						<td><input type="text" name = "urWeight" value = "${user.urWeight}"></td>
					<tr>
					<tr>
						<td>가입일</td>
						<td><input type="text" name = "joinedAt" value = "${user.joinedAt}" readonly="readonly"></td>
					<tr>
					
						<td ><a href="userList"><button>뒤로가기</button></a></td>
						<td><input type="submit" value="수정하기"></td>
					</tr>
				</table>
			</form>
			</div>
			<!-- Scripts -->
			<!-- <script src="resources/assets/js/jquery.min.js"></script>
			<script src="resources/assets/js/jquery.scrolly.min.js"></script>
			<script src="resources/assets/js/jquery.scrollex.min.js"></script>
			<script src="resources/assets/js/skel.min.js"></script>
			<script src="resources/assets/js/util.js"></script> -->
</body>
</html>