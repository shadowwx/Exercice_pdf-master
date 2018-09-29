<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" 
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="titre.creation.elementrequests"/></title>
        <meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>jQuery UI Datepicker - Default functionality</title>
		<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">		
		<link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		<link href="resources/bootstrap/css/myCss-home.css" rel="stylesheet">
		<script src="resources/bootstrap/js/jquery.js"></script>
		<script src="resources/bootstrap/js/bootstrap.min.js"></script>
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<script>
			$( function() {
			  $( "#datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' });
			} );
		</script>
		<script>
			
				var clientsData = [];
				$(document).ready(function(){
					$.ajax("/projet-pdf-csv/jsonApi/clients").success(function(data){
						data.forEach(function(element, index)
						{
							if(element.firstName !== undefined && element.name !== undefined)
							{
								clientsData.push({label: element.firstName + " " + element.name, value: element.firstName + " " + element.name, id: element.id});
							}
							else if(element.firstName !== undefined)
							{
								clientsData.push({label: element.firstName, value: element.firstName, id: element.id});
							}
							else if(element.name !== undefined)
							{
								clientsData.push({label: element.name, value: element.name, id: element.id});
							}
						});
						$("#clientName").autocomplete({source: clientsData,
							select: function(event, ui)
							{
								$("#clientId").attr("value", ui.item.id);
							}
							
						})});
				})
		</script>
    </head>
    <body id="backgroundList">
    	<div class="return col-xs-6" style="position: absolute; z-index:10;">
	    	<p><c:url value="/request" var="url" /><a href="${url}"><img alt="Liste des Commandes" src="<c:url value="/resources/images/img_back.png" />" style="width: 60px;" ></a></p>
	    </div>
	    <div class="col-xs-6">
		    <div class="row" style="text-align: center;">
				<div class="col-lg-12 logoMenu" style="text-align: center;">
	    			<p class="titleMenu">Ajout d'une Commande</p>
	    		</div>
	    	</div>
	    </div>
	   
	    <div id="input-creation" class="tablePlus">
        <form:form method="post" modelAttribute="creationRequest" action="creationRequest">

			<spring:message code="creation.elementrequests.libelle.client" />

			<input type="text" id="clientName"/>
			<form:input id="clientId" path="clientId" cssStyle="display:none"/>
			
            <spring:message code="creation.elementrequests.libelle.dateDelivery" /> 
            <form:input type="text" id="datepicker" path="dateDelivery" alt="calendrier" /><br />
            
            <spring:message code="creation.elementrequests.libelle.deliveryPlace" />
            <form:input path="deliveryPlace"/>
            <b><i><form:errors path="deliveryPlace" cssclass="error"/></i></b><br>
            
            <input type="radio" name="confirmation" value=true > Oui
            <input type="radio" name="confirmation" value=false checked> Non
            <b><i><form:errors path="confirmation" cssclass="error"/></i></b><br>

			<br />
	
			<c:forEach items='${productList}' var="product" varStatus="status">
				
				<div>
					<input name="products[${status.count}].name" type="text" value="${product.name}"/>
					<input name="products[${status.count}].weight" value="${product.weight}"/>
				</div>			
			
			</c:forEach>

           	<div class="p-4"></div>
            <input type="submit"/>
            <div class="p-4"></div>
        </form:form>
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