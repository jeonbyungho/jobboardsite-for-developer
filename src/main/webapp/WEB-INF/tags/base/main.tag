<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="base" tagdir="/WEB-INF/tags/base" %>

<%@ attribute name="title" %>
<%@ attribute name="head" fragment="true" %>
<%@ attribute name="container" fragment="true" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
		<base:head></base:head>
		<jsp:invoke fragment="head"/>
		<title>${title }</title>
	</head>
	
	<body>
		<base:nav/>
		<main class="container">
			<jsp:invoke fragment="container"/>
		</main>
		<base:footer></base:footer>
	</body>
</html>