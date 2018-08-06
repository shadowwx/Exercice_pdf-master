<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <title><spring:message code="titre.client"/></title>
    </head>
    <body>
    	<table>
            <tbody>
                <tr>
                    <td valign="top">
                        <table>
                            <tbody>
				    		<tr><td>
				            	<c:url value="/menu" var="url" />
				                	<a href="${url}">
				                    	<spring:message code="titre.menu"/>
				                    </a>
				            </td></tr>
				            <tr><td>
				            	<c:url value="/client" var="url" />
				                	<a href="${url}">
				                    	<spring:message code="titre.actualisation.client"/>
				                    </a>
				            </td></tr>
				            <tr><td>
				            	<c:url value="/displayCreationClient" var="url" />
				                	<a href="${url}">
				                    	<spring:message code="titre.creation.elementclients"/>
				                    </a>
				            </td></tr>
				            <tr><td>
				            	<c:url value="/displayRemoveClient" var="url" />
				                	<a href="${url}">
				                    	<spring:message code="titre.supression.elementclients"/>
				                    </a>
				            </td></tr>			            
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
		<table border="1">
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
    </body>
</html>
