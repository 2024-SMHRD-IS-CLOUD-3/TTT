<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>T.T.T Trainer Time Table</title>
	<link rel="stylesheet" href="resources/CreateUser.css">
</head>
  <body>
        <h2 class="">
          <a class="" data-href="#">회원 등록 </a>
        </h2>

          <form action="createUser" method="post" enctype="multipart/form-data">
            <div class="group">
              <label  class="label">이름</label>
              <input type="text"  name="urName" class="input">
            </div>
            <div class="group">
              <label class="label">전화번호</label>
              <input type="text" name="urPhone" class="input">
            </div>
            <div class="group">
              <label class="label">주소</label>
              <input type="text" name="urAddress" class="input">
            </div>
            <div>
              <label class="label">키</label>
              <input type="text" name="urHeight" class="input">
            </div>
            <div>
              <label class="label">몸무게</label>
              <input type="text" name="urWeight" class="input">
            </div>
            <div class="group">
              <label class="label">성별</label>
              <input type="text" name="urGender" class="input">
            </div>
            <div>
              <label for="pass" class="label">프로필사진</label>
              <input type="text" name="profileImg" class="input">
            </div>
            <div>
            <input type="submit" name="button" value="등록">
            </div>
          </form>

  
</body></html>