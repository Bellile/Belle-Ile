<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Ajout de la librairie bootstrap.css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/monCSS.css" />
</head>
<title>Liste des hotels</title>
</head>
<body>
<table class="table table-bordered">
	<tr>
		<th>Nom</th>
		<th>Adresse</th>
		<th>Prestation</th>
		<th>Piscine</th>
		<th>Plage</th>
		<th>Ocean</th>
		<th>Photo</th>
		<th>Opération</th>
	</tr>
	<c:forEach var="h" items="${listeHotel}">
		<tr>
			<td>${h.nom}</td>
			<td><a target="blank" href="https://www.google.fr/maps/place/${h.adresse.rue}+${h.adresse.cp}+${h.adresse.ville}+${h.adresse.pays}"> Nous trouver</a></td>
			<td>${h.prestation}</td>
			<td>${h.piscine}</td>
			<td>${h.plage}</td>
			<td>${h.categorie.ocean}</td>
			<td><img src="${pageContext.request.contextPath}/image/hotel?pId=${h.id_hotel}" style="max-height: 150px; max-width: 150px"></td>
			<td><a href='<c:url value="/admin/hot/updHotelLink?pId=${h.id_hotel}"></c:url>'>Modifier</a> 
			| <a href='<c:url value="/admin/hot/delHotelLink/${h.id_hotel}"></c:url>'>Supprimer</a></td>
		</tr>
	</c:forEach>
</table>











</body>
</html>