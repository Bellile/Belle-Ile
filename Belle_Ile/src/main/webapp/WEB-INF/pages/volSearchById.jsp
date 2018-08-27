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

<%@ include file="../../resources/template/header.html"%>


	<div class="form-group" style="display: none">
		<label class="col-sm-2 control-label">Référence du voyage</label>
		<div class="col-sm-10">
			<label class="col-sm-2 control-label">${volOut.id_vol}</label>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Date de départ</label>
		<div class="col-sm-10">
			<label class="col-sm-2 control-label"><fmt:formatDate value="${volOut.dDepart}"
						pattern="dd/MM/yyyy HH:mm" /></label>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Aéroport</label>
		<div class="col-sm-10">
			<label class="col-sm-2 control-label">${volOut.depart}</label>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Date de retour</label>
		<div class="col-sm-10">
			<label class="col-sm-2 control-label"><fmt:formatDate value="${volOut.dArrivee}"
						pattern="dd/MM/yyyy HH:mm" /></label>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Aéroport</label>
		<div class="col-sm-10">
			<label class="col-sm-2 control-label">${volOut.arrivee}</label>
		</div>
	</div>



<div class="form-group">
		<label class="col-sm-2 control-label"><a href="javascript:history.go(-1)">Retour</a></label>
</div>



</body>
</html>