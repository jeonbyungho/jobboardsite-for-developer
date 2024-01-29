<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="base" tagdir="/WEB-INF/tags/base" %>

<base:main title="목록">
<jsp:attribute name="container">
	<!-- 옵션 -->
    	<div>
    	</div>
    	
    <!-- 게시판 목록 -->
    <c:import url="/WEB-INF/views/include/post/posts_card.jsp">
    	<c:param name="posts" value="${recruitBulls }"/>
    	<c:param name="url" value="${WebURLPattern.RECRUIT_POSTDETAIL }"/>
    </c:import>
    
	<!-- 게시판 페이징 -->
	<c:import url="/WEB-INF/views/include/post/post_paging.jsp">
		<c:param name="startPageNo" value="${pagination.startPageNumber }"/>
		<c:param name="endPageNo" value="${pagination.endPageNumber }"/>
		<c:param name="currentPageNo" value="${pagination.currentPage }"/>
		<c:param name="startPagingCheck" value="${pagination.prevPage }"/>
		<c:param name="endPagingCheck" value="${pagination.nextPage }"/>
		<c:param name="url" value="${WebURLPattern.RECRUIT_POSTLIST }"/>
	</c:import>
</jsp:attribute>
</base:main>