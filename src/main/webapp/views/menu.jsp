<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Menu applicatif</title>
        <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/bootstrap/css/myCss-home.css" rel="stylesheet">
        <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
        <script src="resources/bootstrap/js/jquery.js"></script>
		<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	    <style type="text/css">
	      [class*="col"] { margin-bottom: 6px; }
	      img { width: 100%; }
	    </style>
    </head>
    <body id="backgroundMain">
    <div class="container">
	    <div class="row" style="text-align: center;">
			<div class="col-lg-12 logoMenu" style="text-align: center;">
	  			<p class="titleMenu">Choississez votre traitement</p>
	  		</div>
	    </div>
    </div>
   	<div class="container">
   		<div class="row">
   			<div class="col-lg-6 logoMenu" style="text-align: center;">
				<p><c:url value="/client" var="url" /><a href="${url}"><img alt="Clients" src="<c:url value="/resources/images/img_client.png" />" style="width: 120px;" ></a></p>
				<p class="titleName"><spring:message code="titre.client"/></p><br />
			</div>
			<div class="col-lg-6 logoMenu" style="text-align: center;">
				<p><c:url value="/product" var="url" /><a href="${url}"><img alt="Produits" src="<c:url value="/resources/images/img_product.png" />" style="width: 120px;" ></a></p>
				<p class="titleName"><spring:message code="titre.product"/></p><br />
			</div>
		</div>
		<div class="row">
			<div class="col-lg-6 logoMenu" style="text-align: center;">				
				<p><c:url value="/request" var="url" /><a href="${url}"><img alt="Commandes" src="<c:url value="/resources/images/img_request.png" />" style="width: 120px;" ></a></p>
				<p class="titleName"><spring:message code="titre.request"/></p>
			</div>	
			<div class="col-lg-6 logoMenu" style="text-align: center;">				
				<p><c:url value="/csv" var="url" /><a href="${url}"><img alt="CSV" src="<c:url value="/resources/images/img_csv.png" />" style="width: 120px;" ></a></p>
				<p class="titleName"><spring:message code="titre.csv"/></p>
			</div>	
		</div>
		<div class="row" style="text-align: center;">
			<div class="col-lg-12 logoMenu" style="text-align: center;">				
				<p><c:url value="/home" var="url" /><a href="${url}"><img alt="Accueil" src="<c:url value="/resources/images/img_api.png" />" style="width: 120px;" ></a></p>
				<p class="titleName"><spring:message code="titre.home"/></p>
			</div>
		</div>
	</div>
    </body>
</html>