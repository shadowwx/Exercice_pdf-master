<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Menu applicatif</title>
    </head>
    <body>
    <h1>Choississez votre traitement</h1>
   		
		<p><c:url value="/client" var="url" /><a href="${url}"><img alt="Default_image" src="<c:url value="/resources/images/img_client.png" />" style="width: 100px;" ></a></p>
		<p><spring:message code="titre.client"/></p><br />
		
		
		
		<p><c:url value="/product" var="url" /><a href="${url}"><img alt="Default_image" src="<c:url value="/resources/images/img_product.png" />" style="width: 100px;" ></a></p>
		<p><spring:message code="titre.product"/></p><br />
		
		
		
		<p><c:url value="/csv" var="url" /><a href="${url}"><img alt="Default_image" src="<c:url value="/resources/images/img_csv.png" />" style="width: 100px;" ></a></p>
		<p><spring:message code="titre.csv"/></p>
		
    </body>
</html>