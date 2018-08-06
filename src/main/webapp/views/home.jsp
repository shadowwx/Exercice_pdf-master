<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Projet PDF U'DEV</title>
    </head>
    <body>
    <h1>Projet PDF</h1>
        <p>Bonjour et bienvenue sur le projet PDF de Florian.</p>
        <p>Pour commencer authentifiez-vous svp.</p>
		<form method="post" action="traitement.php">
			<p>
		       <label for="user">Utilisateur:</label>
		       <input type="text" name="user" id="user" />
		    </p>
		    <p>
		       <label for="password">Mot de passe :</label>
		       <input type="password" name="password" id="password" />
			</p>
		</form>
    </body>
</html>