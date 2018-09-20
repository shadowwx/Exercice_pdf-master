<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="titre.edit.elementclients"/></title>
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
            	<form:form method="post" modelAttribute="client" action="editClient" object="${editClient.client_id}">            	
	                    <tr>
	                        <td><input type="text" id="name" name="name" value="<c:out value="${editClient.name}"/>"></td>
	                        <td><input type="text" id="firstName" name="firstName" value="<c:out value="${editClient.firstName}"/>"></td>
	                        <td><input type="text" id="billingPlace" name="billingPlace" value="<c:out value="${editClient.billingPlace}"/>"></td>
	                        <td><input type="text" id="mail" name="mail" value="<c:out value="${editClient.mail}"/>"></td>
	                        <td><input type="text" id="phone" name="phone" value="<c:out value="${editClient.phone}"/>"></td>
	                        <td>		                    
			                    <input type="submit"/>
			                </td>
	                    </tr>
                </form:form>
            </tbody>
        </table>
        <p><b><i><form:errors path="name" cssclass="error"/></i></b><br></p>
        <p><b><i><form:errors path="firstName" cssclass="error"/></i></b><br></p>
        <p><b><i><form:errors path="billingPlace" cssclass="error"/></i></b><br></p>
        <p><b><i><form:errors path="mail" cssclass="error"/></i></b><br></p>
        <p><b><i><form:errors path="phone" cssclass="error"/></i></b><br></p>
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