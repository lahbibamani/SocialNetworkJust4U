<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../fragments/header.jsp" />
<div class="container col-lg-offset-0 voffset40">
	<div class="content">
		<div class="row">
			<div class="col-md-10">
				<section class="widget">
					<header class="jumbotron hero-spacer">
						<h1>A Warm Welcome!</h1>
					</header>
					<div>
					<h3><b>Just 4 you</b> est une application de rencontre et
						d'entraide entre personnes. Elle offre à ses utilisateurs une
						plateforme pour rendre service aux autres grâce aux compétences afin de satisfaire en
						contre partie des besoins. Il suffit de s'inscrire en
						renseignant des informations personnelles qui resteront privées; Nous donnons attention 
						à la vie privée !<br> Après avoir été inscrit et authentifié,
						vous pouvez consulter les offres ainsi que les demandes des
						autres utilisateurs soit en consultant votre page d'accueil (avec la
						possibilité d'ajouter un commentaire sur une publication), soit en
						lançant une recherche. Il peut, ainsi, solliciter une demande
						auprès d'une personne qui ne peut être transmise que dans le cas
						où il peut y avoir un échange de services. Dans le cas contaire,
						l'utilisateur peut lancer une recherche plus avancée dont le
						résultat est un cycle d'échange de services entre 10 utilisateurs
						au maximum. Une fois la demande est transmise, tout les
						utilisateurs concernés seront notifiés et peuvent soit accepter soit
						refuser. En cas de refus de la part d'un partenaire, le cycle
						d'échange est annulé et les utilisateurs sont notifiés.
						</h3>
						</div>
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