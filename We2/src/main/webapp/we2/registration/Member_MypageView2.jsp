<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.we2.spring.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	AuthInfo authinfo = (AuthInfo)request.getAttribute("authInfo2");
	System.out.println("JSP]" + authinfo.getEmail());
	System.out.println("JSP]" + authinfo.getUserid());
%>
<input type="text" value="${authInfo2.userid}">
</body>
</html>