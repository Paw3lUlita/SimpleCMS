<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 17.07.2022
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
</head>
<body>
<a href="/articles">Artykuły</a>
<a href="/categories">Kategorie</a>
<a href="/authors">Autorzy</a><br>
Ostatnie 5 artykułów:<br>
<c:forEach var="article" items="${last5articles}" >
    Tytuł: ${article.title} <br>
    Data dodania: ${article.created} <br>
    Zawartość: ${article.content} <br>
</c:forEach><br>

Wszystkie kategorie:
<c:forEach var="category" items="${categories}">
    <a href="/categories/articles-by-category/${category.id}">${category.name}</a>
</c:forEach>
</body>
</html>
