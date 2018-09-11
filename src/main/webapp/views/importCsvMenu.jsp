<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Menu Import CSV</title>
    </head>
    <body>
    <h1>Choississez quelle type d'entiter vous voulez?</h1>
   		
		<p><c:url value="/client-csv" var="url" /><a href="${url}"><img alt="Default_image" src="<c:url value="/resources/images/img_client.png" />" style="width: 100px;" ></a></p>
		<p><spring:message code="titre.importClient"/></p><br />
	
		<p><c:url value="/product-csv" var="url" /><a href="${url}"><img alt="Default_image" src="<c:url value="/resources/images/img_product.png" />" style="width: 100px;" ></a></p>
		<p><spring:message code="titre.importProduct"/></p><br />

    </body>
</html>