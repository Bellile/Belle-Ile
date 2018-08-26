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
<title>Formulaire d'ajout d'une catégorie</title>
</head>
<body>
<%@ include file="../../resources/template/headerAdmin.html"%>
<h1 >${msg}</h1>
<form:form cssClass="form-horizontal" method="POST" action="updCat"
		modelAttribute="modifCat">
		<form:label cssClass="col-sm-2 control-label" path="ocean">Id_cat</form:label>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id_cat">Océan</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Id_cat" path="id_cat" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="ocean">Océan</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Ocean" path="ocean" />
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