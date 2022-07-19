<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 19.07.2022
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author List</title>
</head>
<body>
Lista Autorów: <br>
<c:forEach var="author" items="${authors}" >
    Imię: ${author.firstName} <br>
    Nazwisko: ${author.lastName} <br>
    <a href="/authors/edit?authorId=${author.id}">Edytuj</a>   <a href="/authors/delete?authorId=${author.id}">Usuń</a> <br>
    ...........<br>
</c:forEach>
<a href="/authors/add">Dodaj Autora</a>
</body>
</html>
