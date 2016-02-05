<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../fragments/header.jsp" />

<div class="error-page container">
	<main id="content" class="error-container" role="main">
	<div class="row">
		<div
			class="col-lg-4 col-sm-6 col-xs-10 col-lg-offset-4 col-sm-offset-3 col-xs-offset-1">
			<div class="error-container">
				<h1 class="error-code">403</h1>
				<p class="error-info">
					<c:choose>
						<c:when test="${empty user}">
							<h2>You do not have permission to access this page!</h2>
						</c:when>
						<c:otherwise>
							<h2>
								Hey '${user.name}' <br />You do not have permission to
								access this page!
							</h2>
						</c:otherwise>
					</c:choose>
				</p>
			</div>
		</div>
	</div>
	</main>

</div>

<jsp:include page="../fragments/footer.jsp" />