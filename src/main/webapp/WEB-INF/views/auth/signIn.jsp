<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/views/include/base/metaHead.jsp" %>
	<title>로그인</title>
</head>
<body>
<%@ include file="/WEB-INF/views/include/base/navbar.jsp" %>
<main class="container">
	<form method="post" id="formSignIn">
		<label for="inputUsername">아이디</label>
		<input type="text" name="username" id="inputUsername"/>
		
		<label for="inputPassword">비밀번호</label>
		<input type="password" name="password" id="inputPassword"/>
		
		<button type="submit">로그인</button>
	</form>
</main>
<%@ include file="/WEB-INF/views/include/base/footer.jsp" %>
<script type="text/javascript" src="<c:url value='${WebURLPattern.RESOURCES}/js/base.js'/>"></script>
<script type="text/javascript" src="<c:url value='${WebURLPattern.RESOURCES}/js/signIn.js'/>"></script>
</body>
</html>