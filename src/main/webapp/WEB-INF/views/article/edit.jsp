<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Артём
  Date: 01.02.2016
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create user</title>
</head>
<body>
<form:form commandName="article" method="post" action="/blog/edit">
    <input type="text" name="title"/>
    <textarea name="content"></textarea>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>
