<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <title><spring:message code="titre.product"/></title>
        <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
        <link href="resources/bootstrap/css/myCss-home.css" rel="stylesheet">
        <script src="resources/bootstrap/js/jquery.js"></script>
		<script src="resources/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body id="backgroundList">
    	<div id="display-left" class="col-xs-6">
		    <p><spring:message code="titre.product"/></p>
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
					            	<c:url value="/product" var="url" />
					                	<a href="${url}">
					                    	<p class="titleName"><spring:message code="titre.actualisation.product"/></p>
					                    </a>
					        		</div>
   									<div id="text-redirect" class="col-lg-6" style="text-align: center;">
					            	<c:url value="/displayCreationProduct" var="url" />
					                	<a href="${url}">
					                    	<p class="titleName"><spring:message code="titre.creation.elementproducts"/></p>
					                    </a>
					            	</div>
   									<div id="text-redirect" class="col-lg-6" style="text-align: center;">
					            	<c:url value="/displayRemoveProduct" var="url" />
					                	<a href="${url}">
					                    	<p class="titleName"><spring:message code="titre.supression.elementproducts"/></p>
					                    </a>
					            	</div>
					            	<div id="text-redirect" class="col-lg-6" style="text-align: center;">
					            	<c:url value="/client" var="url" />
					                	<a href="${url}">
					                    	<p class="titleName"><spring:message code="titre.client"/></p>
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
                    <th><spring:message code="colonne.product_reference"/></th>
                    <th><spring:message code="colonne.name"/></th>
                    <th><spring:message code="colonne.brand"/></th>
                    <th><spring:message code="colonne.type"/></th>
                    <th><spring:message code="colonne.numberStock"/></th>
                    <th><spring:message code="colonne.priceUnit"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listProduct}" var="product">
                    <tr>
                        <td><c:out value="${product.product_reference}"/></td>
                        <td><c:out value="${product.name}"/></td>
                        <td><c:out value="${product.brand}"/></td>
                        <td><c:out value="${product.type}"/></td>
                        <td><c:out value="${product.numberStock}"/></td>
                        <td><c:out value="${product.priceUnit}"/></td>
                        <td>
		                    <a href="displayEditProduct/${product.product_reference}">
		                        <img alt="Modifier" title="Modifier" src="<c:url value="/resources/images/img_edit.png" />" style="width: 50px;" >
		                    </a>
		                </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>