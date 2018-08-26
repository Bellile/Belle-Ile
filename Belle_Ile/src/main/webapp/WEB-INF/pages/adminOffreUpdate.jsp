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
<%@ include file="../../resources/template/headerAdmin.html"%>
	<h1>Modifier une offre de voyage</h1>


	<form:form cssClass="form-horizontal" method="POST"
		action="updateOffre" modelAttribute="offreUpdate"
		enctype="multipart/form-data">

		<div class="form-group">
			Référence du voyage :<form:label cssClass="col-sm-2 control-label" path="id_offre">${offreUpdate.id_offre}</form:label>
			<div class="col-sm-10" style="display: none">
				<form:input cssClass="control-label" path="id_offre"></form:input>
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="hotel.id_hotel">Destination - Hotel</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Hotel"
					path="hotel.id_hotel" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nbDispo">Nombre de places disponibles</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="nombre de place"
					path="nbDispo" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nbNuit">Nombre de nuit</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="nombre de nuit"
					path="nbNuit" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="prix">Prix du séjour</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="prix du séjour"
					path="prix" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="promo">Appliquer une promo</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control"
					placeholder="indice de promotion" path="promo" />
			</div>
		</div>

		<div class="form-group">
			<label Class="col-sm-2 control-label">Photo</label>
			<div class="col-sm-10">
				<input Class="form-control" type="file" name="file" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Modifier</button>
			</div>
		</div>
	</form:form>

	<c:if test="${not empty msg}">
		<h1>La modification a échoué</h1>
	</c:if>


</body>
</html>