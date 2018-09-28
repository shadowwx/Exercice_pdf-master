<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Menu Import CSV</title>
        <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
        <link href="resources/bootstrap/css/myCss-home.css" rel="stylesheet">
        <script src="resources/bootstrap/js/jquery.js"></script>
		<script src="resources/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body id="backgroundMain">
	    <div class="return col-xs-6" style="position: absolute; z-index:10;">
	    	<p><c:url value="/menu" var="url" /><a href="${url}"><img alt="Menu Csv" src="<c:url value="/resources/images/img_back.png" />" style="width: 60px;" ></a></p>
	    </div>
	    <div class="col-xs-6">
		    <div class="row" style="text-align: center;">
				<div class="col-lg-12 logoMenu" style="text-align: center;">
	    			<p class="titleMenu">Choississez quelle type d'entité vous voulez?</p>
	    		</div>
	    	</div>
	    </div>
	    <div class="p-5"></div>
	    <div class="container">
	   		<div class="row">
	   			<div class="col-lg-6 text-menu" style="text-align: center;">   		
					<p><c:url value="/client-csv" var="url" /><a href="${url}"><img alt="Default_image" src="<c:url value="/resources/images/img_client.png" />" style="width: 100px;" ></a></p>
					<p><spring:message code="titre.importClient"/></p><br />
				</div>
				<div class="col-lg-6 logoMenu" style="text-align: center;">
					<p><c:url value="/product-csv" var="url" /><a href="${url}"><img alt="Default_image" src="<c:url value="/resources/images/img_product.png" />" style="width: 100px;" ></a></p>
					<p><spring:message code="titre.importProduct"/></p><br />
				</div>
			</div>
		</div>
    </body>
</html>