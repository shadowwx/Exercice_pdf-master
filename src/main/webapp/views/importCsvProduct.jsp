<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="titre.csv"/></title>
        <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
        <link href="resources/bootstrap/css/myCss-home.css" rel="stylesheet">
        <script src="resources/bootstrap/js/jquery.js"></script>
		<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body id="backgroundUpload">
		<div id="return-left" class="col-xs-6" style="position: absolute; z-index:10;">
	    	<p><c:url value="/csv" var="url" /><a href="${url}"><img alt="Choix du type de CSV" src="<c:url value="/resources/images/img_back.png" />" style="width: 60px;" ></a></p>
			<p class="titleName">Retour</p>
		</div>
		<div id="return-right" class="col-xs-6">
	    	<p><c:url value="/menu" var="url" /><a href="${url}"><img alt="Retour au menu principal" src="<c:url value="/resources/images/img_api.png" />" style="width: 60px;" ></a></p>
	    	<p class="titleName">Accueil</p>
	    </div>
		<form:form method="post" enctype="multipart/form-data" action="uploadCsvProduct">
			<fieldset>
			<div class="container">
		    	<div class="row" style="text-align: center;">
					<div class="col-lg-12" style="text-align: center;">
		        		<p class="titleMenu">Choisir un fichier Produit</p>
					   	<div class="p-5"></div>
					   	<img alt="Nouveaux Stocks" src="<c:url value="/resources/images/img_product-stock.png" />" style="width: 450px;" >
					   	<div class="p-5"></div>         
						<label>Votre fichier doit être un CSV de type produit :</label><br />
						<input type="file" name="file" />
						<div class="p-5"></div>
					</div>
		        </div>
		   	</div>	
			<center><button  type="submit" class="btn btn-secondary btn-lg btn-block" style="width: 50%;" value="upload">Envoyer</button></center>
			</fieldset>
		</form:form>
	</body>
</html>