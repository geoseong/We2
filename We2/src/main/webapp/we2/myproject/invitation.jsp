<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 팀원 추가.</title>
<link rel="stylesheet" type="text/css" href="/We2/css/File.css">
</head>
<body>

<h2>이메일 검색 회원 리스트</h2>
<div style="font-size: 9pt;">
* 초대할 회원의 이메일 주소로 초대메일이 발송되며, 메일내용의 '초대수락'버튼을 눌러야지만 프로젝트 리스트에 추가됩니다. 
</div>
<c:if test="${ !alert.contains('hi') }">
	   ${alert}
	<c:set scope="session" var="alert" value="hi"/>
</c:if>

<form action="invitation" method="post">
<table style="margin: 10px; width: 98%">
	<tr class="Listtr">
		<th style="width: 5%">&nbsp;</th>
		<th style="width: 45%">이메일</th>
 		<th style="width: 20%">사용자명</th>
 		<th style="width: 20%">유저 아이디</th>
 		<th style="width: 10%">성별</th>	  
	</tr>	
	<c:forEach var="searchemail" items="${searchemail }">
	<tr>
		<td><input type="checkbox" name="item" value="${searchemail.getUserId() }"></td>
		<td>${searchemail.getEmail() }</td>
		<td>${searchemail.getName() }</td>
		<td>${searchemail.getUserId() }</td>
		<td>${searchemail.getGender() }</td>
	</tr>
	</c:forEach>
</table>
   <input type="submit" class="add_btn" value="초대메일 보내기" 
	   style="float:right ; border: none;background: #4CC4EE; color: #fff;
		    font-weight: 400; font-size: 15px; width: 150px; height: 30px; 
		    border-radius: 5px; text-align: center; ">
</form>      
</body>
</html>