<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="./include/header.jsp" %>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css"></link>
	<title>홈페이지</title>
</head>
<body>
	<%@ include file="./include/nav.jsp" %>
    <a href="/login">로그인</a>
    <a href="/jobpost">구인구직 게시판</a>
</body>
</html>