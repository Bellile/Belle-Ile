<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>accueil</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/monCSS.css" />
</head>
<body>


	<%@ include file="../../resources/template/header.html"%>


	<form class="form-inline my-2 my-lg-0" id="recherche" action="../rech/offre?pRech=${rech}" method="GET">
		<input class="form-control mr-sm-2" type="search" placeholder="Search"
			aria-label="Search" name="pRech" id="rech">
		<button class="btn btn-primary btn-md" type="submit">Search</button>
	</form>
	<c:if test="${not empty msg}">
		<h3 >Aucune offre ne correspond à votre recherche.</h3>
	</c:if>


	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>




		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active"
					style="max-height: 500px; min-height: 500px; text-align: center; font-size: 60px">Bienvenue chez Belle Ile Voyage</div>

				<c:forEach var="h" items="${listeHotel}">
					<div class="item"
						style="max-height: 500px; min-height: 500px; padding-left: 40%; padding-right: 40%">
						<img
							src="${pageContext.request.contextPath}/image/hotel?pId=${h.id_hotel}"
							style="max-height: 800px; padding-top: 150px">
						<h3>"${h.nom}"</h3>
					</div>
				</c:forEach>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>







		<div class="row">
			<c:forEach var="o" items="${listeOffre}">
				<div class="col-md-4" >
				<div class="thumbnail" style="background: linear-gradient(to top right,rgb(0,0,0, 0.5), rgb(105,105,105, 0.15), rgb(0, 0, 0, 1)) no-repeat; border: 1px solid grey; border-radius: 12px">
					<a href=""> <img
						src="${pageContext.request.contextPath}/image/offre?pId=${o.id_offre}"
						style="width: 100%">
					</a>
					<a href="<c:url value="/resa/showResaLink?pId=${o.id_offre}"/>">réserver</a>
					<div class="caption" style="display: block; border-radius: 12px">
						<div style="display: inline">
							<label>Destination : ${o.hotel.adresse.pays}</label>
							<label>Hotel : ${o.hotel.nom}</label>
						</div>
						<div>
						<label>Place(s) disponible(s) : ${o.nbDispo} </label>
						</div>
						<div>
						<label>Nombre de nuit(s) : ${o.nbNuit}</label>
						</div>
						<label>Prix initial du séjour : ${o.prix} euros</label>
						<label style="border: 1px solid grey; color: red">PROMO : ${o.promo*100} %</label>
						<label style="color: red">Prix après réduction : ${o.prix - o.prix*o.promo} euros</label>
						<label>Depart : de ${o.vol.depart} le <a href="<c:url value="/accueil/searchVolLink?pId=${o.vol.id_vol}"/>">${o.vol.dDepart}</a></label>
					</div>
				</div>
				</div>
			</c:forEach>
		</div>

		<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />


		<%@ include file="../../resources/template/footer.html"%>
</body>
</html>



