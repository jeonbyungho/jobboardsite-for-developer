<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="../include/header.jsp" %>
	<title>구인구직</title>
</head>
<body>
	<%@ include file="../include/nav.jsp" %>
    
    <main class="container mt-3">
    	
    <!-- 옵션 -->
    	<div>
    	</div>
    	
    <!-- 게시판 목록 -->
    <jsp:include page="../include/post/posts_card.jsp"></jsp:include>
    
	<!-- 게시판 페이징 -->
	<jsp:include page="../include/post/pagination.jsp"></jsp:include>
    </main>
    
    <%@ include file="../include/footer.jsp" %>
</body>
</html>