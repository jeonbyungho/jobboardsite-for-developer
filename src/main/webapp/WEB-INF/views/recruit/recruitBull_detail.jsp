<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="base" tagdir="/WEB-INF/tags/base" %>

<base:main title="작성">
<jsp:attribute name="container">
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
</jsp:attribute>
</base:main>