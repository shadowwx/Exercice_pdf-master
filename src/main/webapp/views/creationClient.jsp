<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" 
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="titre.creation.elementclients"/></title>
        <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
        <link href="resources/bootstrap/css/myCss-home.css" rel="stylesheet">
        <script src="resources/bootstrap/js/jquery.js"></script>
		<script src="resources/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body id="backgroundList">
    	<div class="return col-xs-6" style="position: absolute; z-index:10;">
	    	<p><c:url value="/client" var="url" /><a href="${url}"><img alt="Listes des clients" src="<c:url value="/resources/images/img_back.png" />" style="width: 60px;" ></a></p>
	    </div>
	    <div class="col-xs-6">
		    <div class="row" style="text-align: center;">
				<div class="col-lg-12 logoMenu" style="text-align: center;">
	    			<p class="titleMenu">Ajout d'un Client</p>
	    		</div>
	    	</div>
	    </div>
	    <div id="input-creation" class="tablePlus">
	        <form:form method="post" modelAttribute="creationClient" action="creationClient">
	
	            <spring:message code="creation.elementclients.libelle.name" /> 
	            <form:input path="name"/>
	            <b><i><form:errors path="name" cssclass="error"/></i></b><br>
	
	            <spring:message code="creation.elementclients.libelle.firstName" />
	            <form:input path="firstName"/>
	            <b><i><form:errors path="firstName" cssclass="error"/></i></b><br>
	            
	            <spring:message code="creation.elementclients.libelle.billingPlace" />
	            <form:input path="billingPlace"/>
	            <b><i><form:errors path="billingPlace" cssclass="error"/></i></b><br>
	            
	            <spring:message code="creation.elementclients.libelle.mail" />
	            <form:input path="mail"/>
	            <b><i><form:errors path="mail" cssclass="error"/></i></b><br>
	            
	            <spring:message code="creation.elementclients.libelle.phone" />
	            <form:input path="phone"/>
	            <b><i><form:errors path="phone" cssclass="error"/></i></b><br>
	            <div class="p-4"></div>
	            <input type="submit"/>
	            <div class="p-4"></div>
        </form:form>
        </div>
        <table border="1" class="tablePlus">
            <thead>
                <tr>
                    <th><spring:message code="colonne.name"/></th>
                    <th><spring:message code="colonne.firstName"/></th>
                    <th><spring:message code="colonne.billingPlace"/></th>
                    <th><spring:message code="colonne.mail"/></th>
                    <th><spring:message code="colonne.phone"/></th>
                </tr>
            </thead>
			<tbody>
                <c:forEach items="${listClient}" var="client">
                    <tr>
                        <td><c:out value="${client.name}"/></td>
                        <td><c:out value="${client.firstName}"/></td>
                        <td><c:out value="${client.billingPlace}"/></td>
                        <td><c:out value="${client.mail}"/></td>
                        <td><c:out value="${client.phone}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
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