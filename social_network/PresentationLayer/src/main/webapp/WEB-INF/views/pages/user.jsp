<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../fragments/header.jsp" />
<div class="container col-lg-offset-0 voffset40">
	<div class="content">
		<div class="row">
			<div class="col-md-10">
				<section class="widget">
					<header class="jumbotron hero-spacer">
						<h2>Liste des utilisateurs</h2>
								<a class="btn btn-transparent pull-right"
									href="${pageContext.request.contextPath}/inscription">Ajouter
									utilisateur</a>

					</header>
					
					<c:choose>
						<c:when test="${users.size() == 1}">
						Pas d'utilisateurs trouvés
					</c:when>
						<c:otherwise>

							
							<table class="table table-striped">
								<thead>
									<tr>
										<th>NOM Prenom</th>
										<th>Email</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="u" items="${users}">
										<c:if test="${user.email != u.email}">
											<tr>
												<td><img class="image"
													src="<c:url value="/resources/img/avatars/${u.img}.png" />" alt=""
													height="50"> ${u.name} ${u.firstName}</td>


												<td>${u.email }</td>
												<td><a class="btn btn-transparent"
													href="${pageContext.request.contextPath}/removeuser/${u.email}">Supprimer
														utilisateur</a></td>
											</tr>
										</c:if>
									</c:forEach>
								</tbody>

							</table>
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