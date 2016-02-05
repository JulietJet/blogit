<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Артём
  Date: 05.02.2016
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="status" type="java.lang.String"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Sign up</title>
</head>
${status}
<form:form action="/registration" commandName="user">
    <form:input path="username"/><form:errors path="username"/>
    <form:input path="email"/><form:errors path="email"/>
    <form:password path="password"/><form:errors path="password"/>
    <input type="submit" value="Sign up"/>
</form:form>
