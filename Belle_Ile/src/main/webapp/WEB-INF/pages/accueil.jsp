<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>accueil</title>

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

<<<<<<< HEAD
<%@ include file="../../resources/template/header.html"%>
=======
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>
>>>>>>> branch 'master' of https://github.com/Bellile/Belle-Ile.git

<<<<<<< HEAD
<br/>
<br/>



<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active" style="max-height: 500px; min-height: 500px">
      <h1>Salut</h1>
    </div>

	<c:forEach var="h" items="${liste}">
    	<div class="item" style="max-height: 500px; min-height: 500px; padding-left: 25%; padding-right: 25%">
      		<img src="${pageContext.request.contextPath}/image/hotel?pId=${h.id_hotel}"  style="max-height: 400px;">
    		<h3>"${h.nom}"</h3>
    	</div>
    </c:forEach>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>








<div class="row">
  <div class="col-md-4">
    <div class="thumbnail">
      <a href="/w3images/lights.jpg">
        <img src="${pageContext.request.contextPath}/image/hotel?pId=${h.id_hotel}" style="width:100%">
        <div class="caption">
          <p>Lorem ipsum...</p>
        </div>
      </a>
    </div>
  </div>
  <div class="col-md-4">
    <div class="thumbnail">
      <a href="/w3images/nature.jpg">
        <img src="/w3images/nature.jpg" alt="Nature" style="width:100%">
        <div class="caption">
          <p>Lorem ipsum...</p>
        </div>
      </a>
    </div>
  </div>
  <div class="col-md-4">
    <div class="thumbnail">
      <a href="/w3images/fjords.jpg">
        <img src="/w3images/fjords.jpg" alt="Fjords" style="width:100%">
        <div class="caption">
          <p>Lorem ipsum...</p>
        </div>
      </a>
    </div>
  </div>
</div>


<div class="row">
  <div class="col-md-4">
    <div class="thumbnail">
      <a href="/w3images/lights.jpg">
        <img src="/w3images/lights.jpg" alt="Lights" style="width:100%">
        <div class="caption">
          <p>Lorem ipsum...</p>
        </div>
      </a>
    </div>
  </div>
  <div class="col-md-4">
    <div class="thumbnail">
      <a href="/w3images/nature.jpg">
        <img src="/w3images/nature.jpg" alt="Nature" style="width:100%">
        <div class="caption">
          <p>Lorem ipsum...</p>
        </div>
      </a>
    </div>
  </div>
  <div class="col-md-4">
    <div class="thumbnail">
      <a href="/w3images/fjords.jpg">
        <img src="/w3images/fjords.jpg" alt="Fjords" style="width:100%">
        <div class="caption">
          <p>Lorem ipsum...</p>
        </div>
      </a>
    </div>
  </div>
</div>

<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>


<%@ include file="../../resources/template/footer.html"%>
=======
  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active" style="max-height: 500px; min-height: 500px">
      <h1>Salut</h1>
    </div>
>>>>>>> branch 'master' of https://github.com/Bellile/Belle-Ile.git

	<c:forEach var="h" items="${liste}">
    	<div class="item" style="max-height: 500px; min-height: 500px; padding-left: 25%; padding-right: 25%">
      		<img src="${pageContext.request.contextPath}/image/hotel?pId=${h.id_hotel}"  style="max-height: 400px;">
    		<h3>"${h.nom}"</h3>
    	</div>
    </c:forEach>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>


</body>
</html>



