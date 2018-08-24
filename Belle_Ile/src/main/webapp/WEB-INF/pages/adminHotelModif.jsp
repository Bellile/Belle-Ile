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
<title> </title>
</head>
<body>
<form:form cssClass="form-horizontal" method="POST" action="updHotel"
		modelAttribute="hotelModif" enctype="multipart/form-data">
		<div class="form-group" style="display: none">
			<form:label cssClass="col-sm-2 control-label" path="id_hotel">Id</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Id" path="id_hotel" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nom">Nom</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Nom" path="nom" />
			</div>
		</div>
				<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="prestation">Prestation</form:label>
			<div class="col-sm-10">
				<form:select path="prestation">
					<form:option value="demi-pension">Demi-pension</form:option>
					<form:option value="pension complete">Pension complète</form:option>
					<form:option value="tout compris">Tout compris</form:option>
				</form:select>
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="piscine">Piscine</form:label>
			<div class="col-sm-10">
				<form:checkbox path="piscine"/>
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="plage">Plage</form:label>
			<div class="col-sm-10">
				<form:checkbox path="plage"/>
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="categorie.id_cat">Océan</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Ocean" path="categorie.id_cat" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="adresse.rue">Rue</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Rue" path="adresse.rue" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="adresse.cp">Code Postal</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Code postal" path="adresse.cp" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="adresse.ville">Ville</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Ville" path="adresse.ville" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="adresse.pays">Pays</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Pays" path="adresse.pays" />
			</div>
		</div>
		<div class="form-group">
			<label Class="col-sm-2 control-label" >Photo</label>
			<div class="col-sm-10">
				<input Class="form-control" type="file" name="file"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">ADD</button>
			</div>
		</div>
</form:form>
</body>
</html>