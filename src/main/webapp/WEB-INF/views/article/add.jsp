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
    Tytuł:  <form:input path="title" ></form:input><form:errors path="title"/> <br>
    Zawartość: <form:input path="content"></form:input><form:errors path="content"/><br>
    <form:select path="author.id" items="${authors}" itemValue="id"></form:select><form:errors path="author.id"/><br>
    <form:checkboxes path="categories"
                     items="${categories}" itemLabel="name" itemValue="id"/><form:errors path="categories"/><br>
    <input type="submit" value="Dodaj Artykuł">
</form:form>
</body>
</html>
