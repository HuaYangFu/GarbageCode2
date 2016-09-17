<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="java.util.ArrayList"
import="com.model.*"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>歡迎登入</h1><br>
<form action=dataControl?flag=search method=post>
<input type=submit value=搜尋>
<input type=text name=id>
</form>
<a href=addUser.jsp>新增用戶</a>
	<%	
//接收數據===================================================================================================================
	String S_pageNow = (String)request.getAttribute("pageNow");
	int pageNow = Integer.parseInt(S_pageNow);

	String S_pagecount = (String)request.getAttribute("pagecount");
	int pagecount = Integer.parseInt(S_pagecount);

	ArrayList al = (ArrayList)request.getAttribute("result");
	%>
<table border=1>
	<tr>
		<th>id</th>
		<th>name</th>
		<th>psw</th>
		<th>time</th>
		<th>delete</th>
		<th>edit</th>
	</tr>	
	<% 
//數據待入===================================================================================================================
	for(int i = 0 ; i<al.size() ; i++){
	userbean ub = (userbean)al.get(i);
	
		out.print("<tr>");
		out.print("<th>"+ub.getId()+"</th>");
		out.print("<th>"+ub.getName()+"</th>");
		out.print("<th>"+ub.getPsw()+"</th>");
		out.print("<th>"+ub.getTime()+"</th>");
		out.print("<th><a href=dataControl?id='"+ub.getId()+"'&flag=delete>刪除用戶</a></th>");
		out.print("<th><a href=editUser.jsp?id='"+ub.getId()+"'&name='"+ub.getName()+"'&psw='"+ub.getPsw()+"'>修改用戶</a></th>");
		out.print("</tr>");
	}
	%>
</table>
	<%
//底下超連結================================================================================================================
	
	if(pageNow > 1){
	out.println("<a href=dataControl?pageNow="+(pageNow-1)+"&flag=fenya>上一頁</a>");
	}
	
	
	for (int i = 1 ; i <al.size() ; i++) {
		out.println("<a href=dataControl?pageNow="+i+"&flag=fenya>" + i + "</a>");
		}

	
	if(pageNow >= pagecount){
	out.println("<a href=dataControl?pageNow="+(pageNow+1)+"&flag=fenya>下一頁</a>");
	}
	
	%>
</center>
</body>
</html>