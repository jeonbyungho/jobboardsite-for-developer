<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="base" tagdir="/WEB-INF/tags/base" %>

<base:main title="로그인">
<jsp:attribute name="container">
	<form method="post" id="formSignIn">
		<label for="inputUsername">아이디</label>
		<input type="text" name="username" id="inputUsername"/>
		
		<label for="inputPassword">비밀번호</label>
		<input type="password" name="password" id="inputPassword"/>
		
		<button type="submit">로그인</button>
	</form>
	<script type="text/javascript" src="<c:url value='${WebURLPattern.RESOURCES}/js/base.js'/>"></script>
	<script type="text/javascript" src="<c:url value='${WebURLPattern.RESOURCES}/js/auth/signIn.js'/>"></script>
</jsp:attribute>
</base:main>