<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Артём
  Date: 10.04.2016
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}/view/" />
<html>
<head>
    <title>Search for tag #${tag}</title>
</head>
<body>
<div>Found articles: ${fn:length(articles)}</div>
<c:forEach var="article" items="${articles}">
    <div><h4><a href="${baseURL}/${article.url}">${article.title}</a></h4></div>
</c:forEach>
</body>
</html>
