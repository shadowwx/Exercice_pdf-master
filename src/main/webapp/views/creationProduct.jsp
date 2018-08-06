<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="titre.creation.elementproducts"/></title>
    </head>
    <body>
        <form:form method="post" modelAttribute="creationProduct" action="creationProduct">

            <spring:message code="creation.elementproducts.libelle.name" />
            <form:input path="name"/>
            <b><i><form:errors path="name" cssclass="error"/></i></b><br>
            
            <spring:message code="creation.elementproducts.libelle.brand" />
            <form:input path="brand"/>
            <b><i><form:errors path="brand" cssclass="error"/></i></b><br>
            
            <spring:message code="creation.elementproducts.libelle.type" />
            <form:input path="type"/>
            <b><i><form:errors path="type" cssclass="error"/></i></b><br>
            
            <spring:message code="creation.elementproducts.libelle.weight" />
            <form:input path="weight"/>
            <b><i><form:errors path="weight" cssclass="error"/></i></b><br>            
            
            <spring:message code="creation.elementproducts.libelle.numberStock" />
            <form:input path="numberStock"/>
            <b><i><form:errors path="numberStock" cssclass="error"/></i></b><br>

            <spring:message code="creation.elementproducts.libelle.priceUnit" />
            <form:input path="priceUnit"/>
            <b><i><form:errors path="priceUnit" cssclass="error"/></i></b><br>
            
            <spring:message code="creation.elementproducts.libelle.commentary" />
            <form:input path="commentary"/>
            <b><i><form:errors path="commentary" cssclass="error"/></i></b><br>
            
            <input type="submit"/>
        </form:form>
        <table border="1">
            <thead>
                <tr>
                    <th><spring:message code="colonne.name"/></th>
                    <th><spring:message code="colonne.brand"/></th>
                    <th><spring:message code="colonne.type"/></th>
                    <th><spring:message code="colonne.numberStock"/></th>
                    <th><spring:message code="colonne.priceUnit"/></th>
                    <th><spring:message code="colonne.commentary"/></th>
                </tr>
            </thead>
			<tbody>
                <c:forEach items="${listProduct}" var="product">
                    <tr>
                        <td><c:out value="${product.name}"/></td>
                        <td><c:out value="${product.brand}"/></td>
                        <td><c:out value="${product.type}"/></td>
                        <td><c:out value="${product.numberStock}"/></td>
                        <td><c:out value="${product.priceUnit}"/></td>
                        <td><c:out value="${product.commentary}"/></td>
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