<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<div class="row">
		<div class="col-md-12">
			<section class="widget">
				<header>
					<h4>
						Je <span class="fw-semi-bold">fournis</span>
					</h4>
					<div class="widget-controls">
					<a class="btn"
						href="${pageContext.request.contextPath}/addSkill">
						<i
							class="glyphicon glyphicon-plus"></i>&nbsp;Ajouter une
						compétence</a>
					</div>
				</header>
				<div class="body services">
				<c:if test="${!empty userServicesOffert}">
					<table class="table table-striped">
						<tbody>
							<c:forEach var="userService" items="${userServicesOffert}">

								<tr>
									<td>
									
									<a
										href="${pageContext.request.contextPath}/remove/${userService.id}"><i
											class="glyphicon glyphicon-remove pull-right"></i></a>
											
									${userService.service.title}
									</td>

								</tr>
							</c:forEach>
						</tbody>

					</table>
					</c:if>
					<c:if test="${empty userServicesOffert}">
						Vous n'avez pas encore ajouté aucune compétence
					</c:if>
				</div>

			</section>

		</div>
	</div>


	<div class="row">
		<div class="col-md-12">
			<section class="widget">
				<header>
					<h4>
						Je <span class="fw-semi-bold">demande</span>
					</h4>
					<div class="widget-controls">
					<a class="btn"
						href="${pageContext.request.contextPath}/addNeed"><i
							class="glyphicon glyphicon-plus"></i>&nbsp;Ajouter un besoin</a>
					</div>
				</header>
				<div class="body services">
				<c:if test="${!empty userServicesDemande}">
					<table class="table table-striped">
						<tbody>

							<c:forEach var="userService" items="${userServicesDemande}">
								<tr>
									<td><a
										href="${pageContext.request.contextPath}/remove/${userService.id}"><i
											class="glyphicon glyphicon-remove pull-right"></i></a>
											
											<a
										href="${pageContext.request.contextPath}/searchcycle/${userService.id}"><i
											class="glyphicon glyphicon-search"></i>&nbsp;</a>
											
											${userService.service.title}
									</td>

								</tr>
							</c:forEach>
						</tbody>

					</table>
					</c:if>
					<c:if test="${empty userServicesDemande}">
						Vous n'avez pas encore ajouté aucun besoin
					</c:if>
				</div>
			</section>
		</div>
	</div>
