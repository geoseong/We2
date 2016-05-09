<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project만들기</title>
     <link rel="stylesheet" href="../css/w2_reset.css" type="text/css">
     <link rel="stylesheet" href="../css/02_project.css" type="text/css">
</head>
<body>
<jsp:include page="header.jsp" flush="false" />
<table>
<tr>
	<td id="left" >
			<jsp:include page="left.jsp" flush="false" />
	</td>
	<td id="center">
			<jsp:include page="${page }.jsp" flush="false" />
			
	</td>
</tr>
</table>

</body>
</html>