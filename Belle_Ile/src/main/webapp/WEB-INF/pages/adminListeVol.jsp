<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Liste des vols</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/monCSS.css" />
</head>
<body>




<table class="table">
	<tr>
		<th>Lieu de départ</th>
		<th>Date</th>
		<th>Lieu d'arrivée</th>
		<th>Date</th>
		<th>Opération</th>
	</tr>
	
	<c:forEach var="vol" items="${listeVol}">
		<tr>
			<td>${vol.depart}</td>
			<td><fmt:formatDate value="${vol.dDepart}" pattern="dd/MM/yyyy HH:mm"/></td>
			<td>${vol.arrivee}</td>
			<td><fmt:formatDate value="${vol.dArrivee}" pattern="dd/MM/yyyy HH:mm"/></td>
			<td><a href="<c:url value="/admin/vol/deleteVol?pId=${vol.id_vol}"/>">Supprimer</a>
		</tr>
		
	</c:forEach>
</table>



</body>
</html>