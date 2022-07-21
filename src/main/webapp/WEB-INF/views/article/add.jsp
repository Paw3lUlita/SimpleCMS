<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 21.07.2022
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Article</title>
</head>
<body>
<form:form method="post" modelAttribute="article">
    <form:input path="title" ></form:input><br>
    <form:input path="content"></form:input><br>
    <form:select path="author.id" items="${authors}" itemValue="id"></form:select><br>
    <form:checkboxes path="categories"
                     items="${categories}" itemLabel="name" itemValue="id"/><br>
    <input type="submit" value="Dodaj Kategorię">
</form:form>
</body>
</html>
