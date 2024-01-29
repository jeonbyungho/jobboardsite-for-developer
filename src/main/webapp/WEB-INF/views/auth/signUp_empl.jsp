<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="base" tagdir="/WEB-INF/tags/base" %>

<base:main title="회원가입">
<jsp:attribute name="container">
	<form method="post" id="formSignUp">
		<div class="row mb-3">
			<label for="inputUsername" class="col-sm-2 col-form-label">아이디</label>
			<div class="col-sm-4">
				<input type="text" name="username" class="form-control" id="inputUsername" required/>
			</div>
			<div class="col-sm-2"><button type="button" id="btnDuplicateUsernameCheck" class="btn btn-primary">중복확인</button></div>
		</div>
		
		<div class="row mb-3">
			<label for="inputPassword" class="col-sm-2 col-form-label">비밀번호</label>
			<div class="col-sm-4">
				<input type="password" name="password" class="form-control" id="inputPassword" required/>
			</div>
		</div>
		
		<label for="inputRegistrationNo" class="col-sm-2 col-form-label">사업자번호</label>
		<input type="text" name="businessRegistrationNumber" class="form-control" id="inputRegistrationNo" required/>
		
		<label for="inputCompanyName" class="col-sm-2 col-form-label">회사명</label>
		<input type="text" name="companyName" class="form-control" id="inputCompanyName" required/>
		
		<label for="inputEmail" class="col-sm-2 col-form-label">이메일</label>
		<input type="email" name="email" class="form-control" id="inputEmail" required/>
		
		<label for="inputFoundingDate" class="col-sm-2 col-form-label">창립일</label>
		<input type="date" name="foundingDate" class="form-control" id="inputFoundingDate" required/>
		
		<button type="submit" class="btn btn-primary">회원 가입</button>
	</form>
	<script type="text/javascript" src="<c:url value='${WebURLPattern.RESOURCES}/js/base.js'/>"></script>
	<script type="text/javascript" src="<c:url value='${WebURLPattern.RESOURCES}/js/auth/signUp.js'/>"></script>
</jsp:attribute>
</base:main>