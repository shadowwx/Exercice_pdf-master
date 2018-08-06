<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="titre.creation.elementclients"/></title>
    </head>
    <body>
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
            
            <input type="submit"/>
        </form:form>
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