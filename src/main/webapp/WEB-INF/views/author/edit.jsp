<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 19.07.2022
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Author</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
    Nazwa:  <form:input path="firstName" ></form:input><br>
    Opis: <form:input path="lastName"></form:input><br>
    <form:hidden path="id"></form:hidden>
    <input type="submit" value="Edytuj Autora">
</form:form>
</body>
</html>
