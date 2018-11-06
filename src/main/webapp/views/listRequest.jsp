<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <title><spring:message code="titre.request"/></title>
        <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
        <link href="resources/bootstrap/css/myCss-home.css" rel="stylesheet">
        <script src="resources/bootstrap/js/jquery.js"></script>
		<script src="resources/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body id="backgroundList">
    	<div id="display-left" class="col-xs-6">
		    <p><spring:message code="titre.request"/></p>
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
					            	<c:url value="/request" var="url" />
					                	<a href="${url}">
					                    	<p class="titleName"><spring:message code="titre.actualisation.request"/></p>
					                    </a>
					        		</div>
   									<div id="text-redirect" class="col-lg-6" style="text-align: center;">
					            	<c:url value="/displayCreationRequest" var="url" />
					                	<a href="${url}">
					                    	<p class="titleName"><spring:message code="titre.creation.elementrequests"/></p>
					                    </a>
					            	</div>
   									<div id="text-redirect" class="col-lg-6" style="text-align: center;">
					            	<c:url value="/displayRemoveRequest" var="url" />
					                	<a href="${url}">
					                    	<p class="titleName"><spring:message code="titre.supression.elementrequests"/></p>
					                    </a>
					            	</div>
					            	
					            	<div id="text-redirect" class="col-lg-6" style="text-align: center;">
					            	<c:url value="/client" var="url" />
					                	<a href="${url}">
					                    	<p class="titleName"><spring:message code="titre.client"/></p>
					                    </a>
					        		</div>
   									<div id="text-redirect" class="col-lg-6" style="text-align: center;">
					            	<c:url value="/product" var="url" />
					                	<a href="${url}">
					                    	<p class="titleName"><spring:message code="titre.product"/></p>
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
                    <th><spring:message code="colonne.request_billNumber"/></th>
                    <th><spring:message code="colonne.dateCreation"/></th>
                    <th><spring:message code="colonne.confirmation"/></th>
                    <th><spring:message code="colonne.client"/></th>
                    <th colspan="2"><spring:message code="colonne.action"/></th>     
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listRequest}" var="request">
                    <tr>
                        <td id="center"><c:out value="${request.request_billNumber}"/></td>
                        <td><c:out value="${request.dateCreation}"/></td>
                        <td id="center"><c:choose>
						    <c:when test="${request.confirmation == true}">
						       <spring:message code="choose.oui"/>
						    </c:when>
						    <c:otherwise>
						       <p><strong><font color="red"><spring:message code="choose.non"/></font></strong></p>
						    </c:otherwise>
						</c:choose></td>
                        <td><c:out value="${request.client.name}"/></td>
	                        <td id="center">
			                    <c:url value="/Facture-Pdf" var="url">			                    
				                        <c:param name="request_billNumber" value="${request.request_billNumber}"/>
			                    </c:url>
			                    <a href="${url}">
			                        <img alt="PDF" title="Télécharger PDF" src="<c:url value="/resources/images/img_pdf.png" />" style="width: 50px;" >
			                    </a>
			                </td>
			                <td id="center">		                    
			                    <a href="displayEditRequest/${request.request_billNumber}">
			                        <img alt="Modifier" title="Modifier" src="<c:url value="/resources/images/img_edit.png" />" style="width: 50px;" >
			                    </a>
			                </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="p-5"></div>
    </body>
</html>