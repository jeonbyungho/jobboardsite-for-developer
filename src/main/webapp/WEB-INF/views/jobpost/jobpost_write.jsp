<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="../include/header.jsp" %>
	<title>구인구직글 작성</title>
</head>
<body>
	<%@ include file="../include/nav.jsp" %>
    <main class="container mt-3">
    	<div>
    	<!-- Form -->
    		<form method="post" name="jobpostForm">
    		<!-- 게시판 제목 -->
    			<h3 class="fw-bold">
	    			<label for="jobpostInputTitle" class="form-label">
	    				<i class="bi bi-clipboard2"></i>제목
	    			</label>
    			</h3>
    			<input type="text" name="jobpost_title" class="form-control" id="jobpostInputTitle" maxlength="100" required/>
    			<div id="titleHelp" class="form-text">We'll never share your email with anyone else.</div>
    			
    			<hr>
    		<!-- 내용 -->
    			<textarea name="contents" class="form-control vh-100" id="jobpostTextareaContents"></textarea>
    			
    		<!-- submit 버튼 -->
    			<button type="submit" class="w-100 py-2 btn btn-primary rounded-3 mt-2">
					<i class="bi bi-pen"></i> <span>작성 완료</span>
				</button>
    		</form>
    	</div>
    </main>
    
    <%@ include file="../include/footer.jsp" %>
</body>
</html>