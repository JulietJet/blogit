<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<a href="/registration">Registration</a> <a href="/?lang=en">EN</a> | <a href="/?lang=ru">RU</a>
<div>${SPRING_SECURITY_LAST_EXCEPTION}</div>
<form class="form-signin" name='loginForm' commandName="user"
      action="/j_spring_security_check" method='post'>
    <input name="username" type="text" placeholder="Username" required autofocus/>
    <input type="password" name="password" class="form-control" placeholder="Password" required />
    <input name="submit" type="submit" value="Sign In" />
</form>
<spring:message code="hello" />
</body>
</html>
