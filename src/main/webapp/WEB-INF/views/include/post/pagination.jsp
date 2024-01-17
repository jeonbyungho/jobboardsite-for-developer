<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="startPageNo" value="${param.startPageNo}" scope="page"/>
<c:set var="endPageNo" value="${param.endPageNo}" scope="page"/>
<c:set var="currPageNo" value="${param.currPageNo}" scope="page"/>
<c:set var="endPagingCheck" value="${param.endPagingCheck}" scope="page"/>
<c:set var="url" value="${param.url}" scope="page"/>

<nav class="mt-3">
	<ul class="pagination justify-content-center">
	<%-- Prev 버튼 --%>
		<c:if test="${currPageNo > 1}">
			<li class="page-item">
				<a class="page-link" href="#"><i class="bi bi-caret-left-fill"></i></a>
			</li>
		</c:if>
	<%-- Page 번호 --%>
		<c:forEach var="pageNo" begin="${startPageNo}" end="${endPageNo}">
			<c:set var="pageStatu" value="${pageNo == currPageNo ? 'page-link active' : 'page-link' }" scope="page"/>
			<li class="page-item"><a class="${pageStatu }" href="${url}">${pageNo}</a></li>
		</c:forEach>
	<%-- Next 버튼 --%>
		<c:if test="${endPagingCheck}">
			<li class="page-item">
				<a class="page-link" href="#"><i class="bi bi-caret-right-fill"></i></a>
			</li>
		</c:if>
	</ul>
</nav>