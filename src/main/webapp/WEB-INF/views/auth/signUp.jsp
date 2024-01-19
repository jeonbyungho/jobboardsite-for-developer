<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/views/include/base/metaHead.jsp" %>
	<title>회원가입</title>
</head>
<body>
<%@ include file="/WEB-INF/views/include/base/navbar.jsp" %>
<main class="container">
	<form method="post">
		<label for="inputUsername">아이디</label>
		<input type="text" name="username" id="inputUsername"/>
		
		<label for="inputPassword">비밀번호</label>
		<input type="password" name="password" id="inputPassword"/>
		
		<button type="submit">회원 가입</button>
	</form>
</main>
<%@ include file="/WEB-INF/views/include/base/footer.jsp" %>
</body>
</html>