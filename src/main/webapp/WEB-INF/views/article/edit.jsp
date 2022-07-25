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
    <title>Edit Article</title>
</head>
<body>
<form:form method="post" modelAttribute="article">
    Tytuł:  <form:input path="title" ></form:input><br>
    Zawartość: <form:input path="content"></form:input><br>
    <form:hidden path="id"></form:hidden>
    <form:hidden path="created"/>
    <form:select path="author.id" items="${authors}" itemValue="id"></form:select><br>
    <form:checkboxes path="categories"
                     items="${categories}" itemLabel="name" itemValue="id"/><br>
    <input type="submit" value="Edytuj Artykuł">
</form:form>
</body>
</html>
