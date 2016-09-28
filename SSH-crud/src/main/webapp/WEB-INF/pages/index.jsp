<%--
  Created by IntelliJ IDEA.
  User: 傅華暘
  Date: 2016/9/28
  Time: 下午 06:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>springMVC+spring+hibernate-CRUD</h1>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Age</th>
            <th>Admin</th>
            <th>Date</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${userList}" var="emp">
            <tr>
                <th><c:out value="${emp.id}"/></th>
                <th><c:out value="${emp.name}"/></th>
                <th><c:out value="${emp.age}"/></th>
                <th><c:out value="${emp.admin}"/></th>
                <th><c:out value="${emp.createdDate}"/></th>
                <th><a href="editUser?id=<c:out value='${emp.id}'/>">Edit</a></th>
                <th><a href="deleteUser?id=<c:out value='${emp.id}'/>">Delete</a></th>
            </tr>
        </c:forEach>
    </table>
    <div style="margin-top: 1%">
        <a href="createUser"style="padding: 8px 30px 12px 30px;border: 2px solid #333;text-decoration: none">新增</a>
    </div>
    <div style="margin-top: 1%">
    <c:if test="${(userObject != null)||(user != null)}">
      <jsp:include page="edit.jsp"/>
    </c:if>
    </div>
</center>
</body>
</html>
