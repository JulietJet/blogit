<%--
  Created by IntelliJ IDEA.
  User: Артём
  Date: 01.02.2016
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
    <title>Title</title>
</head>
<body>
<h2>Create user</h2>
<form:form commandName="user" method="post" action="/user/create">
    <input type="text" name="username" placeholder="user name"/>
    <input type="password" name="password" placeholder="password"/>
    <input type="email" name="email" placeholder="email"/>
    <input type="submit" value="create"/>
</form:form>
</body>
</html>

</body>
</html>
