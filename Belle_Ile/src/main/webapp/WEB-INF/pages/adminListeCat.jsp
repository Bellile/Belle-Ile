<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title>Liste Categories</title>
</head>
<body>
<%@ include file="../../resources/template/headerAdmin.html"%>
<table class="table table-bordered">
	<tr>
		<th>Océan</th>
		<th>Operation</th>
	</tr>
	<c:forEach var="cat" items="${listeCat}">
		<tr>
			<td>${cat.ocean}</td>
			<td><a href='<c:url value="/admin/cat/updCatLink?pId=${cat.id_cat}"></c:url>'>Modifier</a> 
			| <a href='<c:url value="/admin/cat/delCatLink/${cat.id_cat}"></c:url>'>Supprimer</a></td>
		</tr>
	</c:forEach>
</table>	
</body>
</html>