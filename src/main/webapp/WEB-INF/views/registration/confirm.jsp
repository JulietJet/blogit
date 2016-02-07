<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Артём
  Date: 07.02.2016
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${isConfirmed}">
        Confirmation success!
    </c:when>
    <c:otherwise>
        Confirmation error!
    </c:otherwise>
</c:choose>
<spring:message key="confirm.redirect.title"/> <span id="countdown">5</span>
<script type="text/javascript">
    function countdown() {
        var i = document.getElementById('countdown');
        if (parseInt(i.innerHTML) <= 1) {
            location.href = 'http://localhost:8088';
        }
        i.innerHTML = parseInt(i.innerHTML)-1;
    }
    setInterval('countdown()',1000);
</script>
</body>
</html>
