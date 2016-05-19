<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.we2.willwork.*"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	// 파라미터 받아오기
	String doWork = request.getParameter("inputWork");
	String user = request.getParameter("userName");
	WillWorkDAO2 pDao = new WillWorkDAO2();
	// 이름과 할일 추가하기
	pDao.inputWork(doWork, user);
%>

<c:redirect url="willwork.do"></c:redirect>

</body>
</html> --%>