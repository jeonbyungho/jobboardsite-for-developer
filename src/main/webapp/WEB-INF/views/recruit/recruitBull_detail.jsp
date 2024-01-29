<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/views/include/base/metaHead.jsp" %>
	<title>구인구직</title>
</head>
<body>
<%@ include file="/WEB-INF/views/include/base/navbar.jsp" %>
<main class="container">
	<div class="row g-5">
	<%-- 왼쪽 --%>
		<div class="col-md-8" id="recruitBullPost">
			<div id="recruitBullTitle">
				${recruitbull.title }
			</div>
			<div id="recruitBullContent">
				${recruitbull.content }
			</div>
		</div>
	<%-- 오른쪽 --%>
		<div class="col-md-4" id="employerInfo">
			<c:import url="/WEB-INF/views/include/post/recruit/information_card.jsp">
			</c:import>
		</div>
	</div>
</main>
<%@ include file="/WEB-INF/views/include/base/footer.jsp" %>
</body>
</html>