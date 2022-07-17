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
<c:forEach var="article" items="${last5articles}" >
    Tytuł: ${article} <br>
    Data dodania: ${article} <br>
    Zawartość: ${article} <br>
</c:forEach>
</body>
</html>
