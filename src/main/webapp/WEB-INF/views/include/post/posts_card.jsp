<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row row-cols-1 row-cols-lg-4 g-3 mt-2">
	<c:forEach var="i" items="${param.posts}">
  		<div class="col">
	    	<div class="card shadow-sm">
	    		<a href="<c:url value='${param.url}'/>" class="stretched-link"></a>
				<img src="https://source.unsplash.com/random/800x500" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">??</h5>
					<p class="card-text">Some quick example card's content.</p>
				</div>
				<div class="card-footer">
	    			<small class="text-body-secondary">Last updated 3 mins ago</small>
				</div>
			</div>
		</div>
	</c:forEach>
</div>