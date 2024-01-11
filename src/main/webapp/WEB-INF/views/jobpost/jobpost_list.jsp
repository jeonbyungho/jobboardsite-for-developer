<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="../include/header.jsp" %>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css"></link>
	<title>구인구직</title>
</head>
<body>
	<%@ include file="../include/nav.jsp" %>
    
    <main class="container mt-3">
    	
    	<div>
    		<h4>구인구직</h4>
    	</div>
    	
    	<div class="row row-cols-1 row-cols-md-4 g-4 mt-3">
    		<c:forEach begin="1" end="40">
	    		<div class="col position-relative">
	    			<a href="/jobpost/detail/" class="stretched-link"></a>
			    	<div class="card shadow">
						<img src="https://source.unsplash.com/random/800x500" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title">Example Title</h5>
							<p class="card-text">Some quick example card's content.</p>
						</div>
						<div class="card-footer">
       						<small class="text-body-secondary">Last updated 3 mins ago</small>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		
    </main>
    
</body>
</html>