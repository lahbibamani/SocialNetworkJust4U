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
						d'entraide entre personnes. Elle offre � ses utilisateurs une
						plateforme pour rendre service aux autres gr�ce aux comp�tences afin de satisfaire en
						contre partie des besoins. Il suffit de s'inscrire en
						renseignant des informations personnelles qui resteront priv�es; Nous donnons attention 
						� la vie priv�e !<br> Apr�s avoir �t� inscrit et authentifi�,
						vous pouvez consulter les offres ainsi que les demandes des
						autres utilisateurs soit en consultant votre page d'accueil (avec la
						possibilit� d'ajouter un commentaire sur une publication), soit en
						lan�ant une recherche. Il peut, ainsi, solliciter une demande
						aupr�s d'une personne qui ne peut �tre transmise que dans le cas
						o� il peut y avoir un �change de services. Dans le cas contaire,
						l'utilisateur peut lancer une recherche plus avanc�e dont le
						r�sultat est un cycle d'�change de services entre 10 utilisateurs
						au maximum. Une fois la demande est transmise, tout les
						utilisateurs concern�s seront notifi�s et peuvent soit accepter soit
						refuser. En cas de refus de la part d'un partenaire, le cycle
						d'�change est annul� et les utilisateurs sont notifi�s.
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