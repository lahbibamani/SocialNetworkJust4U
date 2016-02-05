<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>

<title>Just4U</title>
<link href="<c:url value="/resources/img/logo.png" />"
	rel="shortcut icon">

<meta charset="utf-8" />
<link
	href="<c:url value="/resources/lib/font-awesome/css/font-awesome.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/ie10mobile.css" />"
	rel="stylesheet">

<link href="<c:url value="/resources/css/application.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/jquery-ui.css" />"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="logo pull-left">

			<h4>
				<a href="${pageContext.request.contextPath}/"> <span
					class="fa fa-home"></span>&nbsp <strong>Echange de
						Services entre particuliers </strong><small> plateforme de
						rencontre et d'entraide à but non lucratif</small>
				</a>
			</h4>

		</div>
		<header class="page-header">
			<div class="navbar">

				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<div class="pull-right">

						<ul class="nav navbar-nav navbar-right pull-right">


							<li role="presentation"><a title="liste de services"
								href="${pageContext.request.contextPath}/services-list"
								class="link"> <i class="glyphicon glyphicon-list"></i>
							</a></li>

							
							<li id="group_notif" class="dropdown"><a href="#"
								title="demandes de collaboration" class="dropdown-toggle"
								data-toggle="dropdown"> <i class="fa fa-group"></i> 
								<c:choose> 
								<c:when test="${!empty cyclenotif}">
								<span id="notif" class="count">1</span>
								</c:when>
								<c:otherwise>
									<span id="notif" class="hidden count">1</span>
								</c:otherwise>
							</c:choose>
								
							</a>
								<ul id="support-menu" class="dropdown-menu support" role="menu">

									<li role="presentation">
									<c:choose> 
								<c:when test="${!empty cyclenotif}">
								
								<a id="col" href="${ pageContext.request.contextPath}/collab/${ cyclenotif.id}"
										class="support-ticket">
											<div class="picture">
												<span class="label label-important"><i
													class="fa fa-bell-o"></i></span>
											</div>
											
											<div id="details" class="details">${cyclenotif.person.email } voudrait collaborer avec vous</div>
									</a>
								
								</c:when>
								<c:otherwise>
									<a id="col" href="#"
										class="support-ticket">
											<div class="picture">
												<span class="label label-important"><i
													class="fa fa-bell-o"></i></span>
											</div>
											
											<div id="details" class="details">Aucune notification</div>
									</a>
								</c:otherwise>
							</c:choose>
									</li>
									<li role="presentation"><a
										href="${ pageContext.request.contextPath}/collab"
										class="text-align-center see-all"> Voir tous les
											collaborations <i class="fa fa-arrow-right"></i>
									</a></li>
								</ul></li>
							<li class="divider"></li>

							<li><a href="${pageContext.request.contextPath}/home"
								title="Acuueil"> <i class="fa fa-home"></i>
							</a></li>

							<li class="hidden-xs dropdown"><a href="#" title="Account"
								id="account" class="dropdown-toggle" data-toggle="dropdown">
									<i class="fa fa-user"></i>
							</a>
								<ul id="account-menu" class="dropdown-menu account" role="menu">
									<li role="presentation" class="account-picture"><img
										src="<c:url value="/resources/img/avatars/${user.img}.png" />"
										alt=""> ${user.name} ${user.firstName}</li>

									<li role="presentation"><a
										href="${pageContext.request.contextPath}/addSkill"
										class="link"> <i class="glyphicon glyphicon-plus"></i>
											Compétence
									</a></li>
									<li role="presentation"><a
										href="${pageContext.request.contextPath}/addNeed" class="link">
											<i class="glyphicon glyphicon-plus"></i> Besoin
									</a></li>
								</ul></li>
							<li class="visible-xs"><a href="#" class="btn-navbar"
								data-toggle="collapse" data-target=".sidebar" title=""> <i
									class="fa fa-bars"></i>
							</a></li>
							<c:set var="admin" value="false" />
							<c:forEach var="item" items="${user.userRole}">
								<c:if test="${item.role eq 'ROLE_ADMIN'}">
									<c:set var="admin" value="true" />
								</c:if>
							</c:forEach>
							<c:if test="${admin}">
								<li><a href="${pageContext.request.contextPath}/users"
									title="Réglage"> <i class="glyphicon glyphicon-cog"></i>
								</a></li>
							</c:if>
							<li class="hidden-xs"><a
								href="${pageContext.request.contextPath}/j_spring_security_logout"><i
									class="fa fa-sign-out"></i></a></li>
						</ul>
					</div>

				</c:if>
			</div>
		</header>
		<input type="hidden" id="role" value="${user}" />
	</div>