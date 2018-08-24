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

	<div class="container">
		<h1>Modifier les informations du vol</h1>




		<form:form cssClass="form-horizontal" method="POST" action="updateVol"
			modelAttribute="volUpdate">

			<div class="form-group" >
				<form:label cssClass="col-sm-2 control-label" path="id_vol">numéro du voyage</form:label>
				<div class="col-sm-10">
					<form:input cssClass="form-control" placeholder="Id" path="id_vol"
						 />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-sm-2 control-label" path="dDepart">Date de départ</form:label>
				<div class="col-sm-10">
					<form:input type="date" cssClass="form-control"
						placeholder="Date de départ" path="dDepart" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-sm-2 control-label" path="depart">Aéroport de départ</form:label>
				<div class="col-sm-10">
					<form:input cssClass="form-control"
						placeholder="aéroport de départ" path="depart" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-sm-2 control-label" path="dArrivee">Date d'arrivée</form:label>
				<div class="col-sm-10">
					<form:input type="date" cssClass="form-control"
						placeholder="Date d'arrivée" path="dArrivee" />
				</div>
			</div>

			<div class="form-group">
				<form:label cssClass="col-sm-2 control-label" path="arrivee">Aéroport d'arrivée</form:label>
				<div class="col-sm-10">
					<form:input cssClass="form-control"
						placeholder="aéroport de départ" path="arrivee" />
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

	</div>




</body>
</html>