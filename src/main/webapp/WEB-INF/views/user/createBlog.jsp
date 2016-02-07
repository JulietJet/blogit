<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Артём
  Date: 07.02.2016
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/dashboard/create" method="post">
    <input type="text" name="name" placeholder="title"/>
    <input type="submit" value="create"/>
</form>

</body>
</html>
