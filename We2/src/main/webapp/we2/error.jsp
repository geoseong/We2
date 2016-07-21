<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>We2 error page</title>
<style type="text/css">
#atag:hover{
    text-decoration: none;
    color: rgb(0, 117, 200);
}
</style>
</head>
<body>

<div style="color: blue;">
	<h1>Welcome to We2 Error page ^^</h1><br>
	
	<span style="font-size: 12pt; color: rgb(0, 117, 200);">
		<a href="/We2"  id="atag">
		<b>이전 페이지로 돌아가기</b>
		</a>
	</span>
</div>
<br>
<div style="font-size: 12pt; color: red ; border: 2px dotted black; margin: 20px; padding:20px;">
<b>원인 : </b>
<br>${error }
</div>
<%
	String errormsg = (String)request.getAttribute("error");
	String pagemsg = (String)request.getAttribute("page");
	System.out.println("error : " + errormsg);
	System.out.println("page : " + page.toString());
	System.out.println("pagemsg : " + pagemsg);
%>
<c:choose>
	<c:when test="${error eq 'sessionAfterthrowing' }">
		<c:redirect url="/login?logon=n"></c:redirect>
	</c:when>
	<c:when test="${error.contains('NullPointer') }">
		<c:redirect url="/login?logon=n"></c:redirect>
	</c:when>
</c:choose>
</body>
</html>