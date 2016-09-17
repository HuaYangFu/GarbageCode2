<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>修改用戶</h1>

<% 
out.print("<table border=1>");
out.print("<form action=dataControl?flag=edit method=post>");
out.print("<tr><td>ID</td><td><input type=text readonly name=id value="+request.getParameter("id")+"></td></tr>");
out.print("<tr><td>name</td><td><input type=text name=name value="+request.getParameter("name")+"></td></tr>");
out.print("<tr><td>psw</td><td><input type=text name=psw value="+request.getParameter("psw")+"></td></tr>");
out.print("<tr><td><input type=submit value=修改></td></tr>");
out.print("</form>");
out.print("</table>");
%>

</center>
</body>
</html>