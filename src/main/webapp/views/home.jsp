<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Projet PDF U'DEV</title>
        <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/bootstrap/css/myCss-home.css" rel="stylesheet">
        <script src="resources/bootstrap/js/jquery.js"></script>
		<script src="resources/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body id="bodyHome" >
    
    <h1><center>Projet PDF</center></h1>
    <div class="center">
        <center><p class="">Bonjour et bienvenue sur le projet PDF-CSV de Florian.</p></center>
        <center><p class="">Le projet à était réaliser à l'aide des ressources CGI(Entreprise) et EPSI(Formation)</p></center>
        <center><p class="">Si vous désirez vous servir de l'application, cliquez sur le bouton !</p></center>
        <center><div class="logoHome">
        	<p class="titleHome"><c:url value="/menu" var="url" /><a href="${url}"><img title="Le projet" alt="Menu" src="<c:url value="/resources/images/img_api.png" />" style="width: 200px;" ></a></p>
   		</div></center>
    </div>
    
<!--         <p>Pour commencer authentifiez-vous svp.</p>
		<form method="post" action="traitement.php">
			<p>
		       <label for="user">Utilisateur:</label>
		       <input type="text" name="user" id="user" />
		    </p>
		    <p>
		       <label for="password">Mot de passe :</label>
		       <input type="password" name="password" id="password" />
			</p>
		</form> -->
    </body>
</html>