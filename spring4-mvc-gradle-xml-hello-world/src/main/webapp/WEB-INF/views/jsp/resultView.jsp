<%--
  Created by IntelliJ IDEA.
  User: jacky
  Date: 2016/9/7
  Time: 下午4:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%>
<html>
    <head>
        <spring:url value="/resources/core/css/hello.js" var="coreJs" />
        <spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
    <c:forEach items="${result}" var="user">
        <h3>${user.name} ${user.sex}</h3>
    </c:forEach>
    </body>
    <script src="${coreJs}"></script>
    <script src="${bootstrapJs}"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</html>
