<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Getting Started: Handling Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h1>Form</h1>
    <form action="#" th:action="@{/client}" th:object="${client}" method="post">
    	<p>Name: <input type="text" th:field="*{name}" /></p>
    	<p>FirstName: <input type="text" th:field="*{firstName}" /></p>
    	<p>Billing Place: <input type="text" th:field="*{billingPlace}" /></p>
    	<p>Mail: <input type="text" th:field="*{mail}" /></p>
        <p>Phone: <input type="text" th:field="*{phone}" /></p>
        <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
    </form>
</body>
</html>