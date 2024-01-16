<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<jsp:include page="./include/header.jsp">
		<jsp:param name="title" value="메인"/>
	</jsp:include>
</head>
<body>
	<%@ include file="./include/nav.jsp" %>
    <a href="/login">로그인</a>
    <a href="/jobpost">구인구직 게시판</a>
</body>
</html>