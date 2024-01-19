<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jobboard.web.controller.WebURLPattern" %>
<nav class="navbar navbar-expand-md sticky-top bg-body border-bottom shadow-sm mb-3">
	<div class="container">
	
		<div class="navbar-brand">
			<a href="/"><i class="bi bi-layers-half">developer</i></a>
		</div>
		
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="true" aria-label="Toggle navigation">
        	<span class="navbar-toggler-icon"></span>
      	</button>
		
		<div class="navbar-collapse collapse show" id="navbarCollapse">
      		<ul class="navbar-nav me-auto mb-2 mb-md-0">
      			<li class="nav-item">
          			<a class="nav-link" href="/">Home</a>
        		</li>
        		
        		<li class="nav-item dropdown">
        			<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
        				지역별
        			</a>
        			<ul class="dropdown-menu">
        				<li><a class="dropdown-item" href="<c:url value='${WebURLPattern.RECRUIT_POSTLIST }'/>">jobpost 목록</a></li>
            			<li><a class="dropdown-item" href="<c:url value='${WebURLPattern.RECRUIT_POSTWRITE }'/>">구인구직 작성</a></li>
        			</ul>
        		</li>
      		</ul>
      		
      		<div class="d-flex">
    			<a class="btn btn-outline-primary me-2" type="button" href="<c:url value='${WebURLPattern.SIGNIN }'/>">로그인</a>
    			<a class="btn btn-outline-secondary" type="button" href="<c:url value='${WebURLPattern.SIGNUP_EMPLOYER }'/>">회원가입</a>
    		</div>
    	</div>
    	
	</div>
</nav>