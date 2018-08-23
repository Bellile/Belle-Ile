<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>afficher liste location voiture</title>

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

	<table class="table">
		<tr>
			<th>Durée</th>
			<th>photo</th>
			<th>prix pour la journée</th>
			<th>Type de la voiture</th>
		</tr>
		<c:forEach var="lc" items="${listeLC}">
			<tr>
				<td>${lc.duree }</td>
				<td>${lc.photo }</td>
				<td>${lc.prixJournee }</td>
				<td>${lc.typeVoiture }</td>
								
			</tr>
		</c:forEach>
	</table>




</body>
</html>