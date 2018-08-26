<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout client</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
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

<%@ include file="../../resources/template/header.html"%>

	<form:form cssClass="form-horizontal" method="POST" action="addCL"
		modelAttribute="clAjout" enctype="multipart/form-data">


		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="mail">Mail</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Mail" path="mail" />
			</div>
		</div>


		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="mdp">Mot de passe</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Mot de passe"
					path="mdp" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nom">Nom</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Nom" path="nom" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="prenom">Prenom</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Prenom"
					path="prenom" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="dn">Date de naissance</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Date de naissance"
					path="dn" />
			</div>
		</div>

		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="tel">Telephone</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Telephone"
					path="tel" />
			</div>
		</div>


		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="adresse.rue">Rue</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Rue"
					path="adresse.rue" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="adresse.cp">Code postale</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Code postale"
					path="adresse.cp" />
			</div>
		</div>


		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="adresse.ville">Ville</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Ville"
					path="adresse.ville" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="adresse.pays">Pays</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Pays"
					path="adresse.pays" />
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