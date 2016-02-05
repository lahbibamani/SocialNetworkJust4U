
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:forEach var="us" items="${userServices}">
	<section class="widget">
		<section class="search-result-item">
			<a class="image-link" href="#"> <img class="image"
				src="<c:url value="/resources/img/avatars/${us.person.img}.png" />">
			</a>
			<div class="search-result-item-body">
				<div class="row">
					<div class="col-sm-10">
						<h3 class="search-result-item-heading">
							<a href="#">${us.person.firstName} ${us.person.name}</a>
							<c:choose>
								<c:when test='${us.typeService == "DEMANDE"}'>
									a besoin de votre aide
								</c:when>
								<c:otherwise>a ajouté une nouvelle compétence</c:otherwise>
							</c:choose>
						</h3>
						<p class="fs-mini text-muted">disponible du ${us.startDate} à
							${us.endDate}, publiée le ${us.creationDate}</p>
						<h4>${us.service.title}</h4>
						<p class="info">${us.service.description}</p>

					</div>
					<div class="col-sm-2 text-align-center">
						<a class="btn btn-primary btn-info btn-sm" href="#">Contacter</a>
					</div>
				</div>
			</div>

		</section>

		<header> </header>
		<div class="body">
			<div class="chat">

				<div id="${us.id}" class="chat-messages">
					<c:forEach var="c" items="${comments}">
						<c:if test="${c.userService.id == us.id}">
							<div class="chat-message">
								<div class="sender pull-right">
									<div class="icon">
										<img src="<c:url value="/resources/img/avatars/${c.sender.img}.png" />"
											class="img-circle" alt="">
									</div>
									<div class="time" style="width: 53px">${c.datePost}</div>
								</div>
								<div class="chat-message-body on-left">
									<span class="arrow"></span>
									<div class="sender">
										<c:if test="${user.email == c.sender.email}">
										<a
										href="${pageContext.request.contextPath}/removecomment/${c.id}"><i
											class="glyphicon glyphicon-remove pull-left"></i></a>
										
										</c:if>
										<a href="#">${c.sender.name} ${c.sender.firstName}</a>
									</div>
									<div class="text">${c.content}</div>
								</div>
							</div>

						</c:if>
					</c:forEach>
					<footer class="chat-footer row">
						<div class="col-xs-10">
							<input value="" type="text"
								class="new-message form-control input-transparent"
								placeholder="écrire un commentaire...">
						</div>
						<div class="col-xs-2">
							<button type="button"
								class="new-message-btn btn btn-transparent btn-block">Publier</button>
						</div>
					</footer>
				</div>
			</div>
		</div>
	</section>
</c:forEach>