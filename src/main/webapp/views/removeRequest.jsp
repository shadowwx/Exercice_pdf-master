<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
        <link href="resources/bootstrap/css/myCss-home.css" rel="stylesheet">
        <script src="resources/bootstrap/js/jquery.js"></script>
		<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<title>Suppression des commandes</title>
</head>
<body id="backgroundList">
   	<div class="return col-xs-6" style="position: absolute; z-index:10;">
    	<p><c:url value="/request" var="url" /><a href="${url}"><img alt="Liste des Commandes" src="<c:url value="/resources/images/img_back.png" />" style="width: 60px;" ></a></p>
    </div>
    <div class="col-xs-6">
	    <div class="row" style="text-align: center;">
			<div class="col-lg-12 logoMenu" style="text-align: center;">
    			<p class="titleMenu">Suppression d'une commande</p>
    		</div>
    	</div>
    </div>
	<div class="p-5"></div>
	<div class="col-xs-6">
	    <div class="row" style="text-align: center;">
			<div class="col-lg-12 logoMenu" style="text-align: center;">
	   			<c:url value="/menu" var="url" />
	              	<a href="${url}">
	                  	<spring:message code="titre.retour.menu"/>
	               </a>
	   		</div>
	   	</div>
	</div>
	<div class="p-4"></div>
</body>
</html>