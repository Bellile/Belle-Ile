<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> </title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/monCSS.css" />
</head>
<body>

<%@ include file="../../resources/template/header.html"%>

<h1>Liste des offres de voyages</h1>
		
		<c:if test="${not empty msg}">
			<h1>Une erreur c'est produite</h1>
		</c:if>

		<div class="row">
			<c:forEach var="o" items="${listeOffreEnCours}">
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




</body>
</html>