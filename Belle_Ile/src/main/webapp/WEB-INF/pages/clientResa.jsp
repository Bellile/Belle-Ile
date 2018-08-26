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

	<img
		src="${pageContext.request.contextPath}/admin/offre/image?pId=${offreOut.id_offre}"
		height="50px">
	<br />${offreOut.id_offre}<br />
	<br />${offreOut.hotel.adresse.pays }-${offreOut.hotel.adresse.ville}
	<br />${offreOut.hotel.nom }
	<br />${offreOut.nbDispo }
	<br />${offreOut.nbNuit}
	<br />${offreOut.prix }
	<br />${offreOut.promo }
	<br />
	<a
		href="<c:url value="/admin/vol/searchVolLink?pId=${offreOut.vol.id_vol}"/>">${offreOut.vol.id_vol }</a>
	<br />

	<br />
	<br /> Combien de place souhaitez vous réserver ?
	<br />
	<br />


	<form:form cssClass="form-horizontal" method="POST"
		action="client/addResa" modelAttribute="resaCl"
		enctype="multipart/form-data">


		<div class="form-group" style="display: none">
			<form:label cssClass="col-sm-2 control-label" path="offre.id_offre"></form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="offre associé"
					path="offre.id_offre" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nbrePlace">Nombre</form:label>
			<div class="col-sm-10">
				<form:input cssClass="form-control" placeholder="Nombre de place"
					path="nbrePlace" />
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Lancer la
					réservation</button>
			</div>
		</div>
	</form:form>


<c:if test="${not empty msg}">
	Il n'y a pas assez de place pour ce voyage
</c:if>



</body>
</html>