<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="mt-3">
	<ul class="pagination justify-content-center">
	<%-- Prev 버튼 --%>
		<c:if test="${param.startPagingCheck}">
			<li class="page-item">
				<a class="page-link" href="${param.url}/${param.startPageNo - 1}"><i class="bi bi-caret-left-fill"></i></a>
			</li>
		</c:if>
	<%-- Page 번호 --%>
		<c:forEach var="pageNo" begin="${param.startPageNo}" end="${param.endPageNo}">
			<c:set var="pageStatu" value="${pageNo == param.currentPageNo ? 'page-link active' : 'page-link' }" scope="page"/>
			<li class="page-item"><a class="${pageStatu }" href="${param.url}/${pageNo}">${pageNo}</a></li>
		</c:forEach>
	<%-- Next 버튼 --%>
		<c:if test="${param.endPagingCheck}">
			<li class="page-item">
				<a class="page-link" href="${param.url}/${param.endPageNo + 1}"><i class="bi bi-caret-right-fill"></i></a>
			</li>
		</c:if>
	</ul>
</nav>