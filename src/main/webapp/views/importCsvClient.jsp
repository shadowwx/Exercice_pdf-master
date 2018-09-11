<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="titre.csv"/></title>
	</head>
	<body>
	<form:form method="post" enctype="multipart/form-data" action="uploadCsvClient">
		<fieldset>
	        <legend>Choisir un fichier Client</legend>	        
			<label>Votre fichier doit être un CSV de type client :</label>
			<input type="file" name="file" />
			<br /><br />
			<button type="submit" value="upload">Envoyer</button>
			<br />
		</fieldset>
	</form:form>
	</body>
</html>