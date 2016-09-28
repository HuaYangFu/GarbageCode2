<%--
  Created by IntelliJ IDEA.
  User: 傅華暘
  Date: 2016/9/26
  Time: 下午 05:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Show All Users</title>
</head>
<body>
<center>
    <table border=1 STYLE="margin-top: 10%">
    <tr>
        <th>User Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>DOB</th>
        <th>Email</th>
        <th colspan=2>Action</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.userid}" /></td>
            <td><c:out value="${user.firstName}" /></td>
            <td><c:out value="${user.lastName}" /></td>
            <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${user.dob}" /></td>
            <td><c:out value="${user.email}" /></td>
            <td><a href="UserController?action=edit&userId=<c:out value="${user.userid}"/>">Update</a></td>
            <td><a href="UserController?action=delete&userId=<c:out value="${user.userid}"/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
    <div style="margin-top: 1%;width: 20%;height: 50%;">
        <jsp:include page="insert.jsp"/>
    </div>
</center>
</body>
</html>
