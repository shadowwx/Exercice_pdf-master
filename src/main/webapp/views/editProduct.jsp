<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="titre.edit.elementproducts"/></title>
        <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
        <link href="resources/bootstrap/css/myCss-home.css" rel="stylesheet">
        <script src="resources/bootstrap/js/jquery.js"></script>
		<script src="resources/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <table border="1">
            <thead>
            <form:form method="post" modelAttribute="editProduct" action="editProduct" object="${editProduct.product_reference}">
                <tr>
                    <th><spring:message code="colonne.name"/><td><input type="text" id="name" name="name" value="<c:out value="${editProduct.name}"/>"></td></th>
                </tr>    
                <tr>
                    <th><spring:message code="colonne.brand"/><td><input type="text" id="brand" name="brand" value="<c:out value="${editProduct.brand}"/>"></td></th>
                </tr>    
                <tr>    
                    <th><spring:message code="colonne.type"/><td><input type="text" id="type" name="type" value="<c:out value="${editProduct.type}"/>"></td></th>
                </tr>    
                <tr>    
                    <th><spring:message code="colonne.weight"/><td><input type="text" id="weight" name="weight" value="<c:out value="${editProduct.weight}"/>"></td></th>
                </tr>    
                <tr>    
                    <th><spring:message code="colonne.numberStock"/><td><input type="text" id="numberStock" name="numberStock" value="<c:out value="${editProduct.numberStock}"/>"></td></th>
                </tr>    
                <tr>    
                    <th><spring:message code="colonne.priceUnit"/><td><input type="text" id="priceUnit" name="priceUnit" value="<c:out value="${editProduct.priceUnit}"/>"></td></th>
                </tr>       
<%--                 <tr>    
                    <th><spring:message code="colonne.tva"/><td><option value="${editProduct.product_reference}">${editProduct.tva}</option></td></th>
                </tr> --%> 
                    
                <td style="display:none"><input type="hidden" id="product_reference" name="product_reference" value="<c:out value="${editProduct.product_reference}"/>"></td>
            </thead>
        </table>
        <br />
        <spring:message code="colonne.commentary"/><br />
        <textarea type="text" id="commentary" name="commentary" rows="15" cols="56"><c:out value="${editProduct.commentary}"/></textarea>
        <br />
        <input type="submit"/>
        </form:form>
        <br />
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