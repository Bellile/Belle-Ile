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
</head>
<body>

	<h1>Modifier une offre de voyage</h1>


	<form:form cssClass="form-horizontal" method="POST"
		action="searchOffre" modelAttribute="offreSearch"
		enctype="multipart/form-data">


		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id_offre">Référence de l'offre</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control"
					placeholder="référence de l'offre" path="id_offre" />
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Rechercher</button>
			</div>
		</div>
	</form:form>

	<c:if test="${not empty resultat}">
		<table class="table table-bordered">
			<tr>
				<th>Photo</th>
				<th>Référence du voyage</th>
				<th>Destination</th>
				<th>Hotel</th>
				<th>Place(s) disponible(s)</th>
				<th>Nombre de nuit(s)</th>
				<th>Prix initial du séjour</th>
				<th>Promotion</th>
				<th>Référence de l'offre aérienne</th>
				<th>Option location voiture</th>

			</tr>

			<tr>
				<td><img
					src="${pageContext.request.contextPath}/admin/offre/image?pId=${offreSearch.id_offre}"
					height="50px"></td>
				<td>${offreSearch.id_offre}<br /> <a
					href="<c:url value="/admin/offre/deleteOffre?pId=${offreSearch.id_offre}"/>"><i
						class="fas fa-trash-alt"></i></a> | <a
					href="<c:url value="/admin/offre/updateOffreLink?pId=${offreSearch.id_offre}"/>"><i
						class="fas fa-edit"></i></a></td>

				<td>${offreSearch.hotel.adresse.pays }-${offreSearch.hotel.adresse.ville}</td>
				<td>${offreSearch.hotel.nom }</td>
				<td>${offreSearch.nbDispo }</td>
				<td>${offreSearch.nbNuit}</td>
				<td>${offreSearch.prix }</td>
				<td>${offreSearch.promo }</td>
				<td>${offreSearch.vol.id_vol }</td>
				<th></th>
			</tr>
		</table>
	</c:if>

	<c:if test="${not empty msg}">
		<h1>La modification a échoué</h1>
	</c:if>




</body>
</html>