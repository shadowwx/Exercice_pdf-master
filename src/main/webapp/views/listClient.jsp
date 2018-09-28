<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <title><spring:message code="titre.client"/></title>
        <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
        <link href="resources/bootstrap/css/myCss-home.css" rel="stylesheet">
        <script src="resources/bootstrap/js/jquery.js"></script>
		<script src="resources/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body id="backgroundList">
    	<div id="display-left" class="col-xs-6">
		    <p><spring:message code="titre.client"/></p>
		</div>
    	<table class="table">
            <tbody>
                <tr>
                    <td valign="top">
                        <table>
                            <tbody>
                            <div class="container">
                            	<div class="row">
   									<div id="text-redirect" class="col-lg-6 align-items-center" style="text-align: center;">
			            			<c:url value="/menu" var="url" />
					                	<a href="${url}">
					                    	<p class="titleName"><spring:message code="titre.menu"/></p>
					                    </a>
						            </div>
   									<div id="text-redirect" class="col-lg-6" style="text-align: center;">
					            	<c:url value="/client" var="url" />
					                	<a href="${url}">
					                    	<p class="titleName"><spring:message code="titre.actualisation.client"/></p>
					                    </a>
					        		</div>
   									<div id="text-redirect" class="col-lg-6" style="text-align: center;">
					            	<c:url value="/displayCreationClient" var="url" />
					                	<a href="${url}">
					                    	<p class="titleName"><spring:message code="titre.creation.elementclients"/></p>
					                    </a>
					            	</div>
   									<div id="text-redirect" class="col-lg-6" style="text-align: center;">
					            	<c:url value="/displayRemoveClient" var="url" />
					                	<a href="${url}">
					                    	<p class="titleName"><spring:message code="titre.supression.elementclients"/></p>
					                    </a>
					            	</div>
					            	<div id="text-redirect" class="col-lg-6" style="text-align: center;">
					            	<c:url value="/product" var="url" />
					                	<a href="${url}">
					                    	<p class="titleName"><spring:message code="titre.product"/></p>
					                    </a>
					        		</div>
					            	<div id="text-redirect" class="col-lg-6" style="text-align: center;">
					            	<c:url value="/request" var="url" />
					                	<a href="${url}">
					                    	<p class="titleName"><spring:message code="titre.request"/></p>
					                    </a>
					        		</div>
							    </div>	
							</div>	            
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
		<table border="1" class="tablePlus">
        	<thead>
                <tr>
                    <th><spring:message code="colonne.name"/></th>
                    <th><spring:message code="colonne.firstName"/></th>
                    <th><spring:message code="colonne.billingPlace"/></th>
                    <th><spring:message code="colonne.mail"/></th>
                    <th><spring:message code="colonne.phone"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listClient}" var="client">
                    <tr>
                        <td><c:out value="${client.name}"/></td>
                        <td><c:out value="${client.firstName}"/></td>
                        <td><c:out value="${client.billingPlace}"/></td>
                        <td><c:out value="${client.mail}"/></td>
                        <td><c:out value="${client.phone}"/></td>
	                    <td>		                    
		                    <a href="downloadPDF/${client.client_id}">
		                        <img alt="Commandes" title="Commandes" src="<c:url value="/resources/images/img_order.png" />" style="width: 50px;" >
		                    </a>
		                </td>
		                <td>		                    
		                    <a href="displayEditClient/${client.client_id}">
		                        <img alt="Modifier" title="Modifier" src="<c:url value="/resources/images/img_edit.png" />" style="width: 50px;" >
		                    </a>
		                </td>
	                 </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
