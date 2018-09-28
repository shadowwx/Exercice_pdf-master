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
		<link rel="stylesheet" href="/resources/demos/style.css">
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
            <form:select name="request" path="client" size="1" width="20" >
            	<c:forEach items="${listRequest}" var="request">
			        <option>
			        	<c:out value="${request.client.name}" />
			        </option>
			    </c:forEach>
            </form:select>

            <spring:message code="creation.elementrequests.libelle.dateCreation" />
            <form path="dateCreation" id="iop" class="java.util.Date">
            	<c:set var="today" value="<%=new java.util.Date()%>" />
            	<strong><fmt:formatDate type = "date" value = "${today}" pattern="yyyy-MM-dd" /></strong>
            </form>
            
            <spring:message code="creation.elementrequests.libelle.dateDelivery" /> 
            <form:input type="text" id="datepicker" path="dateDelivery" alt="calendrier" /><br />
            
            <spring:message code="creation.elementrequests.libelle.deliveryPlace" />
            <form:input path="deliveryPlace"/>
            <b><i><form:errors path="deliveryPlace" cssclass="error"/></i></b><br>
            
            <spring:message code="creation.elementrequests.libelle.confirmation" />
            <form path="confirmation">
	            <input type="radio" name="confirmation" value=true > Oui
	            <input type="radio" name="confirmation" value=false checked> Non
            </form>
            <b><i><form:errors path="confirmation" cssclass="error"/></i></b><br>

			<br />
	
			<spring:message code="creation.elementrequests.libelle.detailsRequest" />
            <form:select name="request" path="detailsRequests" size="1" width="20" >
            	<c:forEach items="${listRequest}" var="request">
			        <option>
			        	<c:out value="${request.detailsRequests}" />
			        </option>
			    </c:forEach>
            </form:select>

			<spring:message code="creation.elementrequests.libelle.quantity" />
            <form:input path="detailsRequests"/>
            <b><i><form:errors path="detailsRequests" cssclass="error"/></i></b><br>

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