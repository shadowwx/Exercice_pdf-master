<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="titre.suppression.elementclient"/></title>
        <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
        <link href="resources/bootstrap/css/myCss-home.css" rel="stylesheet">
        <script src="resources/bootstrap/js/jquery.js"></script>
		<script src="resources/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body id="backgroundList">
    	<div class="return col-xs-6" style="position: absolute; z-index:10;">
	    	<p><c:url value="/client" var="url" /><a href="${url}"><img alt="Liste des clients" src="<c:url value="/resources/images/img_back.png" />" style="width: 60px;" ></a></p>
	    </div>
	    <div class="col-xs-6">
		    <div class="row" style="text-align: center;">
				<div class="col-lg-12 logoMenu" style="text-align: center;">
	    			<p class="titleMenu">Suppression d'un Client</p>
	    		</div>
	    	</div>
	    </div>
        <table border="1" class="tablePlus">
            <thead>
                <tr>
                    <th><spring:message code="colonne.name"/></th>
                    <th><spring:message code="colonne.firstName"/></th>
                    <th><spring:message code="colonne.billingPlace"/></th>
                    <th><spring:message code="colonne.mail"/></th>
                    <th><spring:message code="colonne.phone"/></th>
                    <th>&nbsp;</th>
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
                        <td>
                            <c:url value="/removeClient" var="url">
                                <c:param name="client_id" value="${client.client_id}"/>
                            </c:url>
                            <a href="${url}">
                                <spring:message code="suppression.supprimer.libelle" />
                            </a>
                        </td>
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