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

<script type="text/javascript"
	src="https://cdn.rawgit.com/openlayers/openlayers.github.io/master/en/v5.1.3/build/ol.js"></script>
<link rel="stylesheet"
	href="https://cdn.rawgit.com/openlayers/openlayers.github.io/master/en/v5.1.3/css/ol.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/monCSS.css" />
<style>
.map {
	height: 480px;
	width: 100%;
}
</style>
</head>
<title>MAP</title>
</head>
<body>
<%@ include file="../../resources/template/header.html"%>

	<h2>Nos destinations</h2>
	
	<div id="map" class="map"></div>
	<script type="text/javascript">
		var map = new ol.Map({
			target : 'map',
			layers : [ new ol.layer.Tile({
				source : new ol.source.OSM()
			}) ],
			view : new ol.View({
				center : ol.proj.fromLonLat([ 55.579705921163, -21.291119716615]),
				zoom : 3
			})
		});
		var marker = new ol.Feature({
			geometry: new ol.geom.Point(
			ol.proj.fromLonLat([ 55.579705921163, -21.291119716615 ])),// Cordinates of New York's Town Hall
		});
			
		var vectorSource = new ol.source.Vector({
			features: [marker]
		});
	
		var markerVectorLayer = new ol.layer.Vector({
			source: vectorSource,
		});
		map.addLayer(markerVectorLayer);
		
		//Points
		var marker = new ol.Feature({
			geometry: new ol.geom.Point(
			ol.proj.fromLonLat([ 46.329345703125, -9.42626953125 ])),// Cordinates of New York's Town Hall
		});
			
		var vectorSource = new ol.source.Vector({
			features: [marker]
		});
	
		var markerVectorLayer = new ol.layer.Vector({
			source: vectorSource,
		});
		map.addLayer(markerVectorLayer);
		
		//Points
		var marker = new ol.Feature({
			geometry: new ol.geom.Point(
			ol.proj.fromLonLat([ -150.55064251108, -17.018832165335  ])),// Cordinates of New York's Town Hall
		});
			
		var vectorSource = new ol.source.Vector({
			features: [marker]
		});
	
		var markerVectorLayer = new ol.layer.Vector({
			source: vectorSource,
		});
		map.addLayer(markerVectorLayer);
	</script>
</body>
</html>