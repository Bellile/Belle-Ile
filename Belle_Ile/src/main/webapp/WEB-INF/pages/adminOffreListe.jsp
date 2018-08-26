<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/monCSS.css" />
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
</head>
<body>
<%@ include file="../../resources/template/headerAdmin.html"%>
	<h1>Liste des offres de voyages</h1>
		
		<c:if test="${not empty msg}">
			<h1>Une erreur s'est produite</h1>
		</c:if>


	<table class="table table-bordered">
		<tr>
			<th>Photo</th>
			<th>R�f�rence du voyage</th>
			<th>Destination</th>
			<th>Hotel</th>
			<th>Place(s) disponible(s)</th>
			<th>Nombre de nuit(s)</th>
			<th>Prix initial du s�jour</th>
			<th>Promotion</th>
			<th>R�f�rence de l'offre a�rienne</th>
			<th>Option location voiture</th>
			
		</tr>

		<c:forEach var="o" items="${listeOffre }">
			<tr>
				<td><img
					src="${pageContext.request.contextPath}/admin/offre/image?pId=${o.id_offre}" height="50px" ></td>
				<td>${o.id_offre} <br/><a
					href="<c:url value="/admin/offre/deleteOffre?pId=${o.id_offre}"/>"><i class="fas fa-trash-alt"></i></a>
					| <a href="<c:url value="/admin/offre/updateOffreLink?pId=${o.id_offre}"/>"><i class="fas fa-edit"></i></a></td>
				<td>${o.hotel.adresse.pays }- ${o.hotel.adresse.ville}</td>
				<td>${o.hotel.nom }</td>
				<td>${o.nbDispo }</td>
				<td>${o.nbNuit}</td>
				<td>${o.prix }</td>
				<td>${o.promo }</td>
				<td>${o.vol.dDepart }</td>
				<td><a href="<c:url value="/admin/vol/searchVolLink?pId=${o.vol.id_vol}"/>">${o.vol.id_vol }</a></td>
				<th></th>


			</tr>

		</c:forEach>

	</table>



</body>
</html>