<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 19.07.2022
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Author</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
   Imię:  <form:input path="firstName" ></form:input><br>
   Nazwisko:  <form:input path="lastName"></form:input>
    <input type="submit" value="Dodaj Autora">
</form:form>
</body>
</html>
