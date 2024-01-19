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
		<label for="inputUsername" class="form-label">아이디</label>
		<input type="text" name="username" class="form-control" id="inputUsername" required/>
		
		<label for="inputPassword" class="form-label">비밀번호</label>
		<input type="password" name="password" class="form-control" id="inputPassword" required/>
		
		<label for="inputRegistrationNo" class="form-label">사업자번호</label>
		<input type="text" name="businessRegistrationNumber" class="form-control" id="inputRegistrationNo" required/>
		
		<label for="inputCompanyName" class="form-label">회사명</label>
		<input type="text" name="companyName" class="form-control" id="inputCompanyName" required/>
		
		<label for="inputEmail" class="form-label">이메일</label>
		<input type="email" name="email" class="form-control" id="inputEmail" required/>
		
		<label for="inputFoundingDate" class="form-label">창립일</label>
		<input type="date" name="foundingDate" class="form-control" id="inputFoundingDate" required/>
		
		<button type="submit" class="btn btn-primary">회원 가입</button>
	</form>
</main>
<%@ include file="/WEB-INF/views/include/base/footer.jsp" %>
</body>
</html>