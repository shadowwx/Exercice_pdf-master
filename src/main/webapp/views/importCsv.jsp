<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="titre.csv"/></title>
		<script type="text/javascript">
	            function verifier()
	            {
	                var typemime=document.getElementById('csv').value.split('.');
	                if(typemime.length!=0)
	                    {
	                        if(typemime[typemime.length-1].toLowerCase()!='csv')
	                            {alert('Fichier csv Invalide')}
	                            else
	                                {
	                                    document.forms[0].submit();
	                                }
	                    }
	            }
	    </script>
	</head>
	<body>
	<form:form method="post" enctype="multipart/form-data" modelAttribute="importCsv" action="importCsv ">
		<fieldset>
	        <legend>Envoi de fichier</legend>
	        
			<label for="fichier">Emplacement du fichier <span class="requis">*</span></label>
			<input type="file" name="fichier" id="fichier"/><br />
<%-- 			<span class="succes"><c:out value="${fichier}" /></span> --%>
			<br />
			
			<input type="submit" />
			<br />
		</fieldset>
	</form:form>
	</body>
</html>