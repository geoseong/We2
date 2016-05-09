<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여태껏 만들어진 프로젝트리스트.</title>
<link rel="stylesheet" type="text/css" href="css/pjt_list.css">
</head>
<body>

<div id="wrap" align="center">
<h1>여태껏 만들어진 프로젝트리스트</h1>
<table class="list">
	<tr>
		<td colspan="5" style="border: white; text-align: right;">
			<a href="/We2/Project/index.jsp">index로 가기</a>
		</td>
	</tr>
	
	<tr><th>프로젝트명</th> <th>유저아이디</th><th style="width: 7%">관리</th>
	
	<!-- 반복문 : c:forEach의 items에는 배열이나 List변수가 오는 자리이다. -->
	<c:forEach var="product" items="${productList }">	
		<tr class="record">
			<td><a href="We2_page?pjtname=${product.pjtname }" target="_blank">${product.pjtname }</a></td>
			<td>${product.userid }</td>	
			<td><a href="ProjectList?pjtname=${product.pjtname }">삭제하기</a></td>
		</tr>		
	</c:forEach>
	
</table>
</div>

</body>
</html>