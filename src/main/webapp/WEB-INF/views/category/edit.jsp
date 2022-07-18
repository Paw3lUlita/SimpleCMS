<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 18.07.2022
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit category</title>
</head>
<body>
<form:form method="post" modelAttribute="category">
    Nazwa:  <form:input path="name" ></form:input><br>
    Opis: <form:input path="description"></form:input><br>
    <form:hidden path="id"></form:hidden>
    <input type="submit" value="Edytuj Kategorię">
</form:form>
</body>
</html>
