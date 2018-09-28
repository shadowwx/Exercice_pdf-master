<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="titre.edit.elementclients"/></title>
        <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
        <link href="resources/bootstrap/css/myCss-home.css" rel="stylesheet">
        <script src="resources/bootstrap/js/jquery.js"></script>
		<script src="resources/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <table border="1">
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
            	<form:form method="post" modelAttribute="editClient" action="editClient" object="${editClient.client_id}">            	
	                    <tr>
	                        <td><input type="text" id="name" name="name" value="<c:out value="${editClient.name}"/>"></td>
	                        <td><input type="text" id="firstName" name="firstName" value="<c:out value="${editClient.firstName}"/>"></td>
	                        <td><input type="text" id="billingPlace" name="billingPlace" value="<c:out value="${editClient.billingPlace}"/>"></td>
	                        <td><input type="text" id="mail" name="mail" value="<c:out value="${editClient.mail}"/>"></td>
	                        <td><input type="text" id="phone" name="phone" value="<c:out value="${editClient.phone}"/>"></td>
	                        <td style="display:none"><input type="hidden" id="client_id" name="client_id" value="<c:out value="${editClient.client_id}"/>"></td>
	                        <td>		                    
			                    <input type="submit"/>
			                </td>
	                    </tr>
                </form:form>
            </tbody>
        </table>
        <table>
            <tbody>
                <tr>
                    <td valign="top">
                        <table>
                            <tbody>
					        <tr><td>
					           	<c:url value="/menu" var="url" />
					               	<a href="${url}">
					                   	<spring:message code="titre.retour.menu"/>
					                   </a>
					        </td></tr>
					        </tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
    </body>
</html>