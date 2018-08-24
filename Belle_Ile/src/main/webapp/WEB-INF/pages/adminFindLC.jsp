<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Afficher une location de voiture par son id </title>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/monCSS.css" />
</head>
<body>



	<form:form cssClass="form-horizontal" metho="POST"
		action="soumettreSearchLC" modelAttribute="lcSearch">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id_location">ID</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="id_location" path="id_location" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Rechercher</button>
			</div>
		</div>
	</form:form>

	<table class="table">
		<tr>
			<th>ID</th>
			<th>Durée</th>
			<td>Photo }</td>
			<th>Prix Journée</th>
			<th>Type de voiture</th>
		</tr>
		<tr>
			<td>${lcFind.id }</td>
			<td>${lcFind.duree }</td>
			<td>${lcFind.photo }</td>
			<td>${lcFind.prixJournee }</td>
			<td>${lcFind.typeVoiture }</td>
			
		</tr>
	</table>

	<h1 style="color: blue">${msg}</h1>



</body>
</html>