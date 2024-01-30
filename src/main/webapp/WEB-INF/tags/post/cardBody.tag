<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="itemList" required="true" type="java.util.List"%>

<c:forEach var="item" items="${itemList}">
	<div class="col">
    	<div class="col card shadow-sm">
    		<a href="<c:url value='#'/>" class="stretched-link"></a>
			<img src="https://source.unsplash.com/random/800x500" class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">${item.title }</h5>
				<p class="card-text">Some quick example card's content.</p>
			</div>
			<div class="card-footer">
    			<small class="text-body-secondary">Last updated 3 mins ago</small>
			</div>
		</div>
	</div>
</c:forEach>