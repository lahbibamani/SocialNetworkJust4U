<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="../fragments/header.jsp" />
<div class="container col-lg-offset-0 voffset40">
	<div class="content">
		<div class="row">
			<div class="col-md-10">
				<section class="widget">
					<header class="jumbotron hero-spacer">
						<h2>Cycles</h2>
					</header>
					<c:choose>
						<c:when test="${empty cycle}">
						Pas de collaborations trouvées
					</c:when>
						<c:otherwise>
							
							<c:forEach var="c" items="${cycle}" varStatus="loop">
							
							<c:set var="accepted" value="false" />
							<c:forEach var="echange" items="${c.echanges}">
								<c:if test="${echange.offrant.email eq user.email}">
									<c:set var="accepted" value="${echange.accepted}" />
								</c:if>
							</c:forEach>
								<h4>
									cycle ${loop.index+1} <c:if test="${accepted =='true'}"> : accepté</c:if>
									
									
										<c:if test="${accepted =='false'}">
										<a class="btn btn-transparent pull-right"
										href="${pageContext.request.contextPath}/delete/${c.id}">Ignorer échange</a>&nbsp;&nbsp;&nbsp;
											<a class="btn btn-transparent pull-right"
										href="${pageContext.request.contextPath}/requestechange/${loop.index}/${c.userService.id}">Accepter échange</a>
									</c:if>
									

								</h4>
								<table class="table table-striped">
									<thead>
										<tr>
											<th>Offrant</th>
											<th>Demandeur</th>
											<th>Service</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="echange" items="${c.echanges}">
											<tr>
												<td><img class="image"
													src="<c:url value="/resources/img/avatars/${echange.offrant.img}.png" />" alt=""
													height="50"> ${echange.offrant.name}
													${echange.offrant.firstName}</td>


												<td><img class="image"
													src="<c:url value="/resources/img/avatars/${echange.demandeur.img}.png" />" alt=""
													height="50"> ${echange.demandeur.name}
													${echange.demandeur.firstName}</td>
												<td>${echange.service.title}</td>
											</tr>
										</c:forEach>
									</tbody>

								</table>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</section>
			</div>
			<div class="col-md-2">
				<section class="widget login-widget">
					<c:choose>
						<c:when test="${pageContext.request.userPrincipal.name != null}">
							<jsp:include page="../fragments/userProfile.jsp" />
						</c:when>
						<c:otherwise>
							<jsp:include page="../fragments/login.jsp" />
						</c:otherwise>
					</c:choose>
				</section>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../fragments/footer.jsp" />