<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div id="servicesList">
	<div class="row">
		<div class="col-md-4">
			<input id="search" type="text" placeholder="Rechercher service..."
				class="search form-control input-transparent" />
		</div>
	</div>
	<br>
	<div class="row text-center list">
		<c:forEach var="service" items="${services}">
			<div class="col-md-6 col-sm-6 hero-feature">
				<div class="thumbnail">
					<div class="caption">
						<h3 class="serviceTitle">${service.title}</h3>
						<p class="serviceDescription">${service.description}</p>
						<p>
							<c:set var="contains" value="false" />
							<c:forEach var="demandeService" items="${userServicesDemande}">
								<c:if test="${demandeService.service.id eq service.id}">
									<c:set var="contains" value="true" />
									<c:set var="id" value="${demandeService.id }" />
								</c:if>
							</c:forEach>
							<c:choose>
								<c:when test="${contains}">
									<a href="${pageContext.request.contextPath}/remove/${id}"
										class="btn btn-default"><span
										class="glyphicon glyphicon-remove text-danger"></span>&nbsp;Je
										n'ai plus besoin</a>
								</c:when>
								<c:otherwise>
									<a
										href="${pageContext.request.contextPath}/ajouterAssociation/demande/${service.id}"
										class="btn btn-default demande"><span
										class="glyphicon glyphicon-plus text-success"></span>&nbsp;Je
										demande</a>
								</c:otherwise>
							</c:choose>
							<c:set var="contains" value="false" />
							<c:forEach var="offreService" items="${userServicesOffert}">
								<c:if test="${offreService.service.id eq service.id}">
									<c:set var="contains" value="true" />
									<c:set var="id" value="${offreService.id }" />
								</c:if>
							</c:forEach>
							<c:choose>
								<c:when test="${contains}">
									<a href="${pageContext.request.contextPath}/remove/${id}"
										class="btn btn-default"><span
										class="glyphicon glyphicon-remove text-danger"></span>&nbsp;Je
										ne fournis plus</a>
								</c:when>
								<c:otherwise>
									<a
										href="${pageContext.request.contextPath}/ajouterAssociation/offre/${service.id}"
										class="btn btn-default offre"><span
										class="glyphicon glyphicon-plus text-success"></span>&nbsp;Je
										fournis</a>
								</c:otherwise>
							</c:choose>
						</p>
					</div>
				</div>
			</div>
		</c:forEach>
</div>
		<!-- JS modal with datepicker -->
		<!-- Small modal -->

		<div class="modal fade bs-example-modal-sm" tabindex="-1"
			role="dialog" aria-labelledby="mySmallModalLabel">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title"></h4>
					</div>
					<div class="modal-body">
						<div style="overflow: hidden;">
							<div class="form-group">
								<div class="row">
									<div class="col-md-12">
										<div id="datetimepicker12">
											<input type="hidden" class="form-control datevalue" />
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary save-assoc">Enregistrer</button>
					</div>
				</div>
			</div>
		</div>

	</div>
<!-- servicesList -->