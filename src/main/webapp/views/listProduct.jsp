<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <title><spring:message code="titre.product"/></title>
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
				            	<c:url value="/product" var="url" />
				                	<a href="${url}">
				                    	<spring:message code="titre.actualisation.product"/>
				                    </a>
				            </td></tr>
				            <tr><td>
				            	<c:url value="/displayCreationProduct" var="url" />
				                	<a href="${url}">
				                    	<spring:message code="titre.creation.elementproducts"/>
				                    </a>
				            </td></tr>
				            <tr><td>
				            	<c:url value="/displayRemoveProduct" var="url" />
				                	<a href="${url}">
				                    	<spring:message code="titre.supression.elementproducts"/>
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
                    <th><spring:message code="colonne.product_reference"/></th>
                    <th><spring:message code="colonne.name"/></th>
                    <th><spring:message code="colonne.brand"/></th>
                    <th><spring:message code="colonne.type"/></th>
                    <th><spring:message code="colonne.numberStock"/></th>
                    <th><spring:message code="colonne.priceUnit"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listProduct}" var="product">
                    <tr>
                        <td><c:out value="${product.product_reference}"/></td>
                        <td><c:out value="${product.name}"/></td>
                        <td><c:out value="${product.brand}"/></td>
                        <td><c:out value="${product.type}"/></td>
                        <td><c:out value="${product.numberStock}"/></td>
                        <td><c:out value="${product.priceUnit}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>