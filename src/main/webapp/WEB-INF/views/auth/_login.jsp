<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="../include/header.jsp" %>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css"></link>
	<title>로그인</title>
</head>
<body>
	<%@ include file="../include/nav.jsp" %>
	<main class="container mt-3">
	    <div class="w-100 m-auto border" id="form-login">
	    <!-- 개인, 기업 회원 메뉴 -->
	   		<ul class="nav nav-tabs justify-content-center mb-3">
				<li>
					<button class="nav-link active" data-bs-toggle="tab">개인회원</button>
				</li>
				<li>
					<button class="nav-link" data-bs-toggle="tab">기업회원</button>
				</li>
			</ul>
		<!-- 로그인 입력란 -->
			<form method="post">
				<div class="form-floating mb-3">
					  <input type="text" name="username" class="form-control" id="floatingInput" placeholder="Username">
					  <label for="floatingInput">아이디</label>
				</div>
				<div class="form-floating mb-3">
					  <input type="password" name="userpassword" class="form-control" id="floatingPassword" placeholder="Password">
					  <label for="floatingPassword">비밀번호</label>
				</div>
				
				<button type="submit" class="btn btn-primary w-100 py-2">로그인</button>
			</form>
		<!-- 계정 관련 링크 -->
			<div class="row justify-content-md-center mt-3">
				<div class="col col-lg-auto">
					<a class="link-secondary" href="#">아이디 찾기</a>
				</div>
				<div class="col col-lg-auto">
					<a class="link-secondary" href="#">비밀번호 찾기</a>
				</div>
				<div class="col col-lg-auto">
					<a class="link-primary" href="/join">회원가입</a>
				</div>
			</div>
	    </div>
	</main>
</body>
</html>