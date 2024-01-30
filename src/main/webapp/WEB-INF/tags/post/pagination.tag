<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="pagination" required="true" type="com.jobboard.web.model.Pagination"%>

<nav class="mt-3">
	<ul class="pagination justify-content-center">
	<%-- Prev 버튼 --%>
		<c:if test="${pagination.prevPage}">
			<li class="page-item">
				<a class="page-link" href="/${pagination.startPageNumber - 1}"><i class="bi bi-caret-left-fill"></i></a>
			</li>
		</c:if>
	<%-- Page 번호 --%>
		<c:forEach var="pageNo" begin="${pagination.startPageNumber}" end="${pagination.endPageNumber}">
			<c:set var="pageStatu" value="${pageNo == pagination.currentPage ? 'page-link active' : 'page-link' }" scope="page"/>
			<li class="page-item"><a class="${pageStatu }" href="/${pageNo}">${pageNo}</a></li>
		</c:forEach>
	<%-- Next 버튼 --%>
		<c:if test="${pagination.nextPage}">
			<li class="page-item">
				<a class="page-link" href="$/${pagination.endPageNumber + 1}"><i class="bi bi-caret-right-fill"></i></a>
			</li>
		</c:if>
	</ul>
</nav>