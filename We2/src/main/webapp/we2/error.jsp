<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>error page</title>
<style type="text/css">
#atag:hover{
    text-decoration: underline;
    color: rgb(0, 117, 200);
}
</style>
</head>
<body>
<div style="color: blue;">
	<h1>Error page ^^</h1>
	<span style="font-size: 12pt; color: rgb(0, 117, 200);">
		<a href="/We2" style="text-decoration: none;" id="atag">
		<b>이전 페이지로 돌아가기</b>
		</a>
	</span>
</div>
<span style="font-size: 12pt; color: red ; border: 2px dotted black; padding: 20px;">
원인 : ${errormsg }
</span>
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
	<c:when test="${error eq 'authentication' }">
		<c:redirect url="/pjtBoard/list?page=1&category=group"></c:redirect>
	</c:when>
</c:choose>
</body>
</html>