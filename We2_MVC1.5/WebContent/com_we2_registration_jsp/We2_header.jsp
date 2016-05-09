<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상단바</title>
<style type="text/css">
 td{
 	border: 1px solid black;
 	width: 200px;
 	text-align: center;
 }
 table.mainmenu td.login:HOVER{
    background-color: pink;
 }
 
</style>
</head>
<body>
	<table class="mainmenu" align="center">
	<c:if test="${empty loginUser}">	
		<tr>
			<td></td><td></td>					
			<td class="login"> <a name="login" href="/We2/We2_login.do" style="text-decoration: none;">로그인</a></td>
			<td>마이페이지<br>
			<span style="color:red">(로그인 후 사용 가능)</span>
			</td>
		</tr>	
	</c:if>
	<c:if test="${!empty loginUser }">
		<tr>
			<td> ${loginUser.name}님 반갑습니다.</td>
			<td class="login"> <a href="/We2/We2_logout.do" style="text-decoration: none;">로그아웃</a></td>
			

			<td class="login">
			  <a href="/We2/We2_mypage.do" style="text-decoration: none;">마이페이지</a>
			</td>
		</tr>		
	</c:if>
	</table>
</body>
</html>