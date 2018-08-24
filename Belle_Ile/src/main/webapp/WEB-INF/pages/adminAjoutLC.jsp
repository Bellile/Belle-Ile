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


	<form:form cssClass="form-horizontal" method="POST" action="addLC"
		modelAttribute="lcAjout">


		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="prixJournee">Prix à la journée</form:label>
			<div class="col-sm-10">
				<form:input type="number" cssClass="form-control"
					placeholder="Prix à la journée" path="prixJournee" />
			</div>
		</div>


		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="typeVoiture">type de Voiture</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Type de véhicule"
					path="typeVoiture" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="duree">Duree</form:label>
			<div class="col-sm-10">
				<form:input type="number" cssClass="form-control"
					placeholder="Durée" path="duree" />
			</div>
		</div>




		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Ajout</button>
			</div>
		</div>
	</form:form>
	<h1>${msg}</h1>








</body>
</html>