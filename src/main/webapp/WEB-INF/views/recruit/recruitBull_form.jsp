<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="base" tagdir="/WEB-INF/tags/base" %>
<%@ page import="com.jobboard.web.WebURLPattern" %>

<base:main title="작성">
<jsp:attribute name="head">
	<script type="text/javascript" src="<c:url value='${WebURLPattern.RESOURCES}/js/base.js'/>"></script>
	<script type="text/javascript" src="<c:url value='${WebURLPattern.RESOURCES}/js/recruit/recruitBull_write.js'/>" defer></script>
</jsp:attribute>
<jsp:attribute name="container">
	<div>
    	<!-- Form -->
   		<form method="post" name="recruitBullForm" enctype="multipart/form-data">
   		<!-- 게시판 제목 -->
   			<h3 class="fw-bold">
    			<label for="inputTitle" class="form-label">
    				<i class="bi bi-clipboard2"></i> 제목
    			</label>
   			</h3>
   			<input type="text" name="title" class="form-control" id="inputTitle" maxlength="100" required/>
   			<div id="titleHelp" class="form-text">We'll never share your email with anyone else.</div>
   			
   			<h4 class="fw-bold">
    			<label for="inputLocation" class="form-label">
    				<i class="bi bi-building-fill"></i> 근무지
    			</label>
   			</h4>
   			<input type="text" name="location" class="form-control" id="inputLocation" maxlength="100" required/>
   			<div id="titleHelp" class="form-text">We'll never share your email with anyone else.</div>
   			
   		<!-- 이미지 업로드 -->
   			<h4 class="fw-bold">
    			<label for="inputImage" class="form-label">
    				<i class="bi bi-images"></i> 이미지
    			</label>
   			</h4>
	   		<input type="file" name="photos" class="form-control" id="inputImage" multiple/>
	   		
   			<hr>
   		<!-- 내용 -->
   			<textarea name="content" class="form-control vh-100" id="jobpostTextareaContents"></textarea>
   			
   		<!-- submit 버튼 -->
   			<button type="submit" class="w-100 py-2 btn btn-primary rounded-3 mt-2">
				<i class="bi bi-pen"></i> <span>작성 완료</span>
			</button>
   		</form>
    </div>
</jsp:attribute>
</base:main>