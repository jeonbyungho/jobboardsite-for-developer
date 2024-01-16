<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="../include/header.jsp" %>
	<title>구인구직 상세 페이지</title>
</head>
<body>
	<%@ include file="../include/nav.jsp" %>
	
    <main class="container mt-3">
		<div class="row g-5">
		<!-- left 게시판 내용 -->
			<div class="col-md-8">
			<!-- 이미지 -->
				<div id="carouselExampleIndicators" class="carousel slide mb-3">
					  <div class="carousel-indicators">
					    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
					    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
					    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
					  </div>
					  <div class="carousel-inner rounded-2">
					    <div class="carousel-item active">
					      <img src="https://source.unsplash.com/random/800x500?apple" class="d-block w-100" alt="...">
					    </div>
					    <div class="carousel-item">
					      <img src="https://source.unsplash.com/random/800x500" class="d-block w-100" alt="...">
					    </div>
					    <div class="carousel-item">
					      <img src="https://source.unsplash.com/random/800x500?banana" class="d-block w-100" alt="...">
					    </div>
					  </div>
					  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
					    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
					    <span class="visually-hidden">Previous</span>
					  </button>
					  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
					    <span class="carousel-control-next-icon" aria-hidden="true"></span>
					    <span class="visually-hidden">Next</span>
					  </button>
				</div>
			<!-- 제목 -->
				<h3 class="fw-bold">
					<i class="bi bi-clipboard2"></i>
        			<span>프론트엔드 개발자(웹)</span>
      			</h3>
      		<!-- 고용주 | 근무 지역 -->
      			<p class="blog-post-meta"><i class="bi bi-building-fill"></i> 회사명 | 서울.한국</p>
      			<hr>
      		<!-- 내용 -->
      			<p>교육은 참 어렵습니다. 잘 가르치고, 잘 배우며, 잘 키우는 것은 결코 쉽지 않습니다. 
      				우리의 시간과 에너지가 유한하기 때문입니다. 맡은 학생 모두에게 좀 더 깊은 가르침을 줄 수 있고 학생 스스로 배우는 법을 깨우치도록 하는 기술, 
      				클래스팅은 모두가 한계 없이 배움에 연결되도록 현장을 이해하는 교육 기술을 연구합니다.</p>
      				
      			<h4>주요업무</h4>
      			<ul>
      				<li>해외 시장 조사 및 국가별 GTM 전략 도출 및 실행</li>
      				<li>해외 시장 진입을 위한 다양한 콘텐츠의 localization</li>
      				<li>잠재 고객과 기회 발굴, 미팅 및 피칭</li>
      				<li>해외 (잠재) 고객 리드 확보를 위한 채널 관리 (linkedin, blog..)</li>
      			</ul>
      			
      			<h4>자격요건</h4>
      			<ul>
      				<li>네이티브급 영어 구사 능력 (written spoken)</li>
      				<li>적극적이고 주도적인 업무 태도</li>
      				<li>IT, 소프트웨어 서비스에 대한 빠른 이해력</li>
      			</ul>
      			
      			<h4>혜택 및 복지</h4>
      			<p>클래스팅은 클래스터가 가장 중요한 일에 집중할 수 있도록 지원합니다.
					최고의 동료들과 치열하게 고민하고 도전할 수 있도록 최적의 몰입 환경을 만들고 아낌없이 보상하며 성장을 지원합니다.
				</p>
				
				<h4>일하는 것이 즐거운 클래스터</h4>
      			<ul>
      				<li>업계 최고 수준의 보상</li>
					<li>업계 최고의 동료들과 함께하는 즐거움</li>
					<li>몰입을 위한 최상의 업무환경 제공</li>
					<li>업계 최고 수준의 업무용 장비 지원</li>
      			</ul>
      			
      			<h4>기술스택</h4>
      				<span class="badge bg-primary-subtle border border-primary-subtle text-primary-emphasis rounded-pill">Java</span>
      				<span class="badge bg-warning-subtle border border-warning-subtle text-warning-emphasis rounded-pill">JavaScript</span>
			</div>
		<!-- right 고용주 정보 -->
			<div class="col-md-4">
				<div class="position-sticky" style="top: 5rem;">
					<div class="p-4 mb-3 border rounded">
						<h5 class="fw-bold">채용 정보</h5>
						
						<button class="w-100 py-2 mb-2 btn btn-outline-primary rounded-3">
							<i class="bi bi-bookmark"></i> <span>북마크</span>
						</button>
						<button class="w-100 py-2 mb-2 btn btn-primary rounded-3">
							<i class="bi bi-person-bounding-box"></i> <span>지원하기</span>
						</button>
					</div>
				</div>
			</div>
		</div>
    </main>
    
    <%@ include file="../include/footer.jsp" %>
</body>
</html>