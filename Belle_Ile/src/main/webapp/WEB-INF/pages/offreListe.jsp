<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Ajout de la librairie bootstrap.css -->
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
<title>Liste des offres</title>
</head>
<body>
	<div class="row">
		<c:forEach var="o" items="${listeOffre}">
			<div class="col-md-4">
				<div class="thumbnail">
					<a href=""> <img
						src="${pageContext.request.contextPath}/image/offre?pId=${o.id_offre}"
						style="width: 100%">
					</a>
					<a href="<c:url value="/resa/showResaLink?pId=${o.id_offre}"/>">réserver</a>
					<div>${o.hotel.nom}</div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>