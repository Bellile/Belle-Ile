<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ajout vol</title>
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
	<div class="container">
		<h1>Renseigner les informations du vol</h1>

		<h1>${msg }</h1>


		<h1>Conditions de voyages</h1>


		<form:form cssClass="form-horizontal" method="POST" action="addVol"
			modelAttribute="volAjout">

			<div class="form-group">
				<form:label cssClass="col-sm-2 control-label" path="dDepart">Date de d�part</form:label>
				<div class="col-sm-10">
					<form:input type="date" cssClass="form-control"
						placeholder="Date de d�part" path="dDepart" />
				</div>
			</div>
			
			<div class="form-group">
				<form:label cssClass="col-sm-2 control-label" path="depart">A�roport de d�part</form:label>
				<div class="col-sm-10">
					<form:input cssClass="form-control"
						placeholder="a�roport de d�part" path="depart" />
				</div>
			</div>



			<div class="form-group">
				<form:label cssClass="col-sm-2 control-label" path="dArrivee">Date d'arriv�e</form:label>
				<div class="col-sm-10">
					<form:input type="date" cssClass="form-control"
						placeholder="Date d'arriv�e" path="dArrivee" />
				</div>
			</div>


			<div class="form-group">
				<form:label cssClass="col-sm-2 control-label" path="arrivee">A�roport d'arriv�e</form:label>
				<div class="col-sm-10">
					<form:input cssClass="form-control"
						placeholder="a�roport de d�part" path="arrivee" />
				</div>
			</div>



			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Ajouter</button>
				</div>
			</div>


		</form:form>


	</div>
</body>
</html>