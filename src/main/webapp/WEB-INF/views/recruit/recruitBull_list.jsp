<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="base" tagdir="/WEB-INF/tags/base" %>
<%@ taglib prefix="post" tagdir="/WEB-INF/tags/post" %>

<base:main title="목록">
<jsp:attribute name="container">
	<!-- 옵션 -->
   	<div>
   	</div>
    	
    <!-- 게시판 목록 -->
    <div class="row row-cols-1 row-cols-lg-4 g-3 mt-2">
	    <post:cardBody itemList="${recruitBulls }">
	    </post:cardBody>
    </div>
    
	<!-- 게시판 페이징 -->
	<post:pagination pagination="${pagination }">
	</post:pagination>
</jsp:attribute>
</base:main>