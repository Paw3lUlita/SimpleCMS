<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 28.07.2022
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Articles by Category</title>
</head>
<body>
Wszystkie artykuły w kategorii ${category.name}:<br>

<c:forEach items="${articlesByCategory}" var="article">
Tytuł: ${article.title} <br>
Data dodania: ${article.created} <br>
Zawartość: ${article.content} <br>

</c:forEach>
</body>
</html>
