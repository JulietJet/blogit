<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Артём
  Date: 05.02.2016
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/registration">Registration</a>

<form:form class="form-signin" name='loginForm' commandName="user"
      action="/j_spring_security_check" method='post'>
    <h2 class="form-signin-heading" style="text-align: center">Please sign in</h2>
    <form:input path="username" type="text" placeholder="Username" required="true" autofocus="true"/>
    <form:password path="password" class="form-control" placeholder="Password" required="true" />
    <input class="btn btn-lg btn-primary btn-block" name="submit" type="submit" value="Sign In" />
</form:form>
</body>
</html>
