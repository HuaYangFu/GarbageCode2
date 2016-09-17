<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<title>SpringMvc & MongoCrud</title>

	<spring:url value="/resources/core/css/hello.css" var="coreCss" />
	<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
	<spring:url value="/resources/core/css/hello.js" var="coreJs" />
	<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />

	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${coreCss}" rel="stylesheet" />

</head>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">SpringMvc & MongoCrud</a>
		</div>
	</div>
</nav>

<div class="jumbotron">
	<div class="container">
		<h1>SpringMvc & MongoCrud</h1>
	</div>
</div>
	<form action="FormController.do">
		欄位名:<input type="text" name="name" value="${name}"/>
		欄位值:<input type="text" name="value" value="${value}"/>

		<input type="submit" value="新增" name="add" />
		<input type="submit" value="查詢" name="query"/>
		<input type="submit" value="刪除" name="remove"/><br>

		欄位名:<input type="text" name="newName" value="請輸入新欄位名"/>
		欄位值:<input type="text" name="newValue" value="請輸入新欄位值"/>

		<input type="submit" value="更改" name="updata"/>
	</form>
<hr>
<jsp:include flush="true" page="resultView.jsp"/><
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</html>