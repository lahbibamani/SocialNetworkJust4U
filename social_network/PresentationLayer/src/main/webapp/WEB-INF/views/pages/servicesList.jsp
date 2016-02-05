<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../fragments/header.jsp" />
<div class="container col-lg-offset-0 voffset40">
	<div class="content">

		<div class="col-md-10">
			<jsp:include page="../fragments/servicesList.jsp" />
		</div>
		<div class="col-md-2">
			<section class="widget login-widget">
				<jsp:include page="../fragments/userProfile.jsp" />
				<br/>
				<jsp:include page="../fragments/userServices.jsp" />

			</section>
		</div>

	</div>
</div>
<jsp:include page="../fragments/footer.jsp" />