<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="../include/header.jsp" %>
	<title>회원가입</title>
</head>
<body>
	<%@ include file="../include/nav.jsp" %>
    <main class="container mt-3">
    	<div class="border">
    		<form method="post">
    		
    			<label for="inputUsername" class="form-label">아이디</label>
    			<input type="text" name="username" id="inputUsername" class="form-control" aria-describedby="UsernameHelpBlock" maxlength="20" required>
    			<div id="UsernameHelpBlock" class="form-text">
  					Your password must be 8-20 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
				</div>
				
    			<label for="inputPassword" class="form-label">비밀번호</label>
    			<input type="password" name="passowrd" id="inputPassword" class="form-control" aria-describedby="passwordHelpBlock" maxlength="20" required>
    			<div id="passwordHelpBlock" class="form-text">
  					Your password must be 8-20 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
				</div>
				
				<hr>
				
				<label for="inputRealname" class="form-label">이름</label>
    			<input type="text" name="realname" id="inputRealname" class="form-control" aria-describedby="realnameHelpBlock" maxlength="10" required>
    			<div id="realnameHelpBlock" class="form-text">
  					Your password must be 8-20 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
				</div>
				
				<label for="inputEmail" class="form-label">email</label>
    			<input type="email" name="email" id="inputEmail" class="form-control" aria-describedby="emailHelpBlock">
    			<div id="emailHelpBlock" class="form-text">
  					Your password must be 8-20 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
				</div>
				
    			<button type="submit" class="w-100 btn btn-primary btn-lg">
    				<i class="bi bi-person-check"></i>
    				<span>회원가입</span>
    			</button>
    		</form>
    	</div>
    </main>
</body>
</html>