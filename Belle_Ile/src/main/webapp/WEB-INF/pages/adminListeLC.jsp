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

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css"/>
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
<%@ include file="../../resources/template/headerAdmin.html"%>
	<table class="table">
		<tr>
		
			<th>photo</th>
			<th>prix pour la journ�e</th>
			<th>Type de la voiture</th>
		</tr>
		<c:forEach var="lc" items="${listeLC}">
			<tr>
				
				<td><img src="${pageContext.request.contextPath}/image/locationVoiture?pId=${lc.id_location}" style ="max-height: 100px; max-height:100px"/></td>			
				<td>${lc.prixJournee }</td>
				<td>${lc.typeVoiture }</td>
				

				<td><a href='<c:url value="/admin/location/modifLCLink?pId=${lc.id_location}"></c:url>'>Modifier</a>
					| <a href='<c:url value="/admin/location/supprLCLink/${lc.id_location}"></c:url>'>Supprimer</a></td>


			</tr>
		</c:forEach>
	</table>




</body>
</html>