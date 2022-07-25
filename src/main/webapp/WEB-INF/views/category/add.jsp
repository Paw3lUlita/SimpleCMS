<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 18.07.2022
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
</head>
<body>
<form:form method="post" modelAttribute="category">
    <form:input path="name" ></form:input><form:errors path="name"/><br>
    <form:input path="description"></form:input><form:errors path="description"/>
    <input type="submit" value="Dodaj Kategorię">
</form:form>
</body>
</html>
