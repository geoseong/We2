<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.we2.project.dao.*"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String [] doworkList = null;
	//String dowork = (String)request.getParameter("complete");
	//String doworkList = (String)request.getParameter("complete");
	//out.println(dowork);
	
	// 파라미터 받기
	doworkList = request.getParameterValues("complete");
	String username = request.getParameter("userName");
		
	
	// 체크한 항목 콘솔에서 확인하기.
	int length = doworkList.length;
	for(int i=0; i<length; i++){		
		out.println(i + "번지 : " + doworkList[i]);
	}
	
	// 파라미터 받은 것 서블릿에 보내기
	request.setAttribute("workarray", doworkList);
	request.setAttribute("username", username);
	request.setAttribute("redirect", "y");
	
 	RequestDispatcher dispatcher=request.getRequestDispatcher("willwork.do");
	dispatcher.forward(request, response);

%>
<%-- <c:redirect url="willwork.do"></c:redirect> --%>
</body>
</html>