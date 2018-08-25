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

	<h1>Rechercher une offre de voyage par son numéro référence</h1>


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

	<c:if test="${resultat==true}">
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
					src="${pageContext.request.contextPath}/admin/offre/image?pId=${offreOut.id_offre}"
					height="50px"></td>
				<td>${offreOut.id_offre}<br /> <a
					href="<c:url value="/admin/offre/deleteOffre?pId=${offreOut.id_offre}"/>"><i
						class="fas fa-trash-alt"></i></a> | <a
					href="<c:url value="/admin/offre/updateOffreLink?pId=${offreOut.id_offre}"/>"><i
						class="fas fa-edit"></i></a></td>

				<td>${offreOut.hotel.adresse.pays }-${offreOut.hotel.adresse.ville}</td>
				<td>${offreOut.hotel.nom }</td>
				<td>${offreOut.nbDispo }</td>
				<td>${offreOut.nbNuit}</td>
				<td>${offreOut.prix }</td>
				<td>${offreOut.promo }</td>
				<td>${offreOut.vol.id_vol }</td>
				<th>${offreOut.location.typeVoiture}</th>
			</tr>
		</table>
	</c:if>

	<c:if test="${not empty msg}">
		<h1>Il n'y a pas d'offre associé à ce numéro</h1>
	</c:if>




</body>
</html>