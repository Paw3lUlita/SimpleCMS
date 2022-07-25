<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 20.07.2022
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Articles</title>
</head>
<body>
Lista Artykułów: <br>
<c:forEach var="article" items="${articles}" >
    ${article.title} <br>
    ${article.content} <br>

    ..........<br>
    Dodano: ${article.created} <br>
    Zmodyfikowano: ${article.updated} <br>
    Autor: ${article.author} <br>
    <a href="/articles/edit?articleId=${article.id}">Edytuj</a>   <a href="/articles/delete?articleId=${article.id}">Usuń</a> <br>
    **************<br>
</c:forEach>
<a href="/articles/add">Dodaj artykuł</a>
</body>
</html>
