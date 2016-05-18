<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AOP</title>
</head>
<body>
<div style="color: blue;">
	<h1>A O P</h1>
</div>
${error }<br><br>
${page }

<%
	String errormsg = (String)request.getAttribute("error");
	String pagemsg = (String)request.getAttribute("page");
	System.out.println("error : " + errormsg);
	System.out.println("page : " + page.toString());
	System.out.println("pagemsg : " + pagemsg);
%>
<c:choose>
	<c:when test="${error eq 'sessionAfterthrowing' }">
		<c:redirect url="/login"></c:redirect>
	</c:when>
</c:choose>
</body>
</html>