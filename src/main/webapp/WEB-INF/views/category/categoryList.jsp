<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 18.07.2022
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>
Lista Kategorii: <br>
<c:forEach var="category" items="${categories}" >
    Nazwa: ${category.name} <br>
    Opis: ${category.description} <br>
    <a href="/categories/edit?categoryId=${category.id}">Edytuj</a>   <a href="/categories/delete?categoryId=${category.id}">Usuń</a> <br>
    ...........<br>
</c:forEach>
<a href="/categories/add">Dodaj Kategorię</a>
</body>
</html>
