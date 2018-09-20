<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Getting Started: Handling Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h1>Result</h1>
    <p th:text="'name: ' + ${client.name}" />
    <p th:text="'firstName: ' + ${client.firstName}" />
    <p th:text="'billingPlace: ' + ${client.billingPlace}" />
    <p th:text="'mail: ' + ${client.mail}" />
    <p th:text="'phone: ' + ${client.phone}" />
    <a href="client1">Submit another message</a>
</body>
</html>