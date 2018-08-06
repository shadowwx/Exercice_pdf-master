<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <title><spring:message code="titre.request"/></title>
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
				            	<c:url value="/request" var="url" />
				                	<a href="${url}">
				                    	<spring:message code="titre.actualisation.request"/>
				                    </a>
				            </td></tr>
				            <tr><td>
				            	<c:url value="/displayCreationRequest" var="url" />
				                	<a href="${url}">
				                    	<spring:message code="titre.creation.elementrequests"/>
				                    </a>
				            </td></tr>
				            <tr><td>
				            	<c:url value="/displayRemoveRequest" var="url" />
				                	<a href="${url}">
				                    	<spring:message code="titre.supression.elementrequests"/>
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
                    <th><spring:message code="colonne.request_billNumber"/></th>
                    <th><spring:message code="colonne.totalPrice"/></th>
                    <th><spring:message code="colonne.dateCreation"/></th>
                    <th><spring:message code="colonne.confirmation"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listRequest}" var="request">
                    <tr>
                        <td><c:out value="${request.request_billNumber}"/></td>
                        <td><c:out value=""/></td>
                        <td><c:out value="${request.dateCreation}"/></td>
                        <td><c:out value="${request.confirmation}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>