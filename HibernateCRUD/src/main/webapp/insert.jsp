<%--
  Created by IntelliJ IDEA.
  User: 傅華暘
  Date: 2016/9/26
  Time: 下午 05:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Add new user</title>
</head>
<body>
<form method="POST" action='UserController' name="frmAddUser" style="text-align: right">
    User ID : <input type="text" readonly="readonly" name="userid" value="<c:out value="${user.userid}" />" /><br/>
    First Name : <input type="text" name="firstName" value="<c:out value="${user.firstName}" />" /><br/>
    Last Name : <input type="text" name="lastName" value="<c:out value="${user.lastName}" />" /><br/>
    DOB : <input type="text" name="dob" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${user.dob}" />" /><br/>
    Email : <input type="text" name="email" value="<c:out value="${user.email}" />" /><br/>
    <input type="submit" value="Submit" />
</form>
</body>
</html>