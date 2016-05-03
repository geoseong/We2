<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home</title>
	
<style type="text/css">

</style>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<div style="border: 1px solid black; display: inline-block; padding: 10px; vertical-align: top;">
<p>
	<a href="<c:url value='/comm_board'/>">커뮤니티 게시판으로 이동</a>
</p>
<p>
	<a href="<c:url value='/comm_board/offer'/>">커뮤니티 게시판 - 구인게시판으로 이동</a>
</p>
<p>
	<a href="<c:url value='/comm_board/blabla'/>">커뮤니티 게시판 - 잡담게시판으로 이동</a>
</p>
</div>

<div style="border: 1px solid black; display: inline-block; padding: 10px; vertical-align: top;">
<p>
	<a href="<c:url value='/pjt_board'/>">프로젝트공유 게시판으로 이동</a>
</p>
<p>
	<a href="<c:url value='/pjt_board/group'/>">프로젝트공유 게시판 - 조별과제게시판으로 이동</a>
</p>
<p>
	<a href="<c:url value='/pjt_board/exam'/>">프로젝트공유 게시판 - 시험공부게시판으로 이동</a>
</p>
<p>
	<a href="<c:url value='/pjt_board/collabo'/>">프로젝트공유 게시판 - 회사협업게시판으로 이동</a>
</p>
</div>
</body>
</html>
