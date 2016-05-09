<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<@session.setAttribute("id", request.getParameter("id"));%>
<@session.setAttribute("password", request.getParameter("password"));%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>세션 로그인</title>
</head>
<body>
<center>
<h3>Login Success!!</h3>
<h3>Login ID : <%=(String)session.getAttribute("id")%></h3>
<h3>Login PASSWORD : <%=(String)session.getAttribute("password")%></h3>
<a href="We2_sessionLogout.jsp">로그아웃</a>
</center>
</body>
</html>