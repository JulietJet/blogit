<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Артём
  Date: 05.02.2016
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="blog" type="com.jahra.model.Blog"--%>
<%--@elvariable id="articles" type="java.util.ArrayList<com.jahra.model.Article>"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${blog.name}
<a href="/article/create">Create new article</a>
<c:forEach items="${articles}" var="article">
    <div>${article.title}
        <span>
            <a href="/article/create?a=${article.id}">edit</a>
            <a target="_blank" href="/view/${article.url}">preview</a></span>
    </div>
</c:forEach>
</body>
</html>
