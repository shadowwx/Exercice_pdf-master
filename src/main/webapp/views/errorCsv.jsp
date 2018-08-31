<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Erreur</title>
</head>
<body>
	<p>Erreur lors de l'envoi du fichier, impossible d'intégrer les données en base.</p>
	<p><c:url value="/menu" var="url" /><a href="${url}"><spring:message code="titre.menu"/></a><p>	                    
</body>
</html>