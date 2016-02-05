<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<header class="text-align-center">
	<h3>Connectez-vous à votre compte</h3>
</header>
<div class="body">
	<c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>
	<form name="f" action="j_spring_security_check" method="post">
		<fieldset>
			<div class="form-group no-margin">


				<div class="input-group input-group-lg">
					<span class="input-group-addon"> <i class="fa fa-user"></i>
					</span> <input id="email" type="email" class="form-control input-lg"
						placeholder="email..." name="j_username">
				</div>

			</div>
			<br />
			<div class="form-group">


				<div class="input-group input-group-lg">
					<span class="input-group-addon"> <i class="fa fa-lock"></i>
					</span> <input id="password" type="password" class="form-control input-lg"
						placeholder="mot de passe..." name="j_password">
				</div>

			</div>
		</fieldset>
		<div class="form-actions">
			<button type="submit" class="btn btn-block btn-primary">
				<small>Se connecter</small>
			</button>
			<div class="forgot">
				<a href="${pageContext.request.contextPath}/inscription" class="forgot"> s'inscrire </a>

			</div>
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</div>
</section>
