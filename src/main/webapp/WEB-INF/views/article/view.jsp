<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Артём
  Date: 03.03.2016
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${article.title}</title>
</head>
<body>
<h2>${article.title}</h2>
${article.content}
<c:forEach items="${article.tags}" var="tag">
    <span><a href="/tag/find/${tag.name}">#${tag.name}</a></span>
</c:forEach>
</body>
</html>
