<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WE2_프로젝트</title>
<link rel="stylesheet" type="text/css" href="/We2/css/w2_reset.css">
<link rel="stylesheet" type="text/css" href="/We2/css/notice.css">
 
</head>
<!-- toString().contains('글쓰기가') -->
<%-- 	<c:when test="${msg.toString().contains('글쓰기가') || msg.toString().contains('수정') || msg.toString().contains('삭제') }"> --%>
<c:choose>
	<c:when test="${empty msg}">
	</c:when>
	<c:otherwise>
		<script type='text/javascript'>
			alert('${msg}');
		</script>
	</c:otherwise>
</c:choose>
		<c:set scope="request" var="alert" value="${false }"/>
		
<body>

	<div id="container">	
	
			<div id="content_wrap">
			
					<h2>공지사항</h2>
				
				<!-- 글쓰기 버튼 -->
				<div class="btn">
                  <form action="write_view" method="get" name ="random ">
				     <input class ="add_btn_write" type="submit" value="글쓰기" >
			      </form> 
			   </div> <!-- write_text end-->
			   
			   <div class="count">
				</div>
				<!-- 표 안의 내용  -->
				<div class="board_contents">
			    <form method = "get" name = "list">
				
				<table>	
					<tr>
						<th>번호</th>
						<th style="width:50%;">제목</th>
						<th style="width:20%;">작성자</th>
						<th style="width:20%;">작성일</th>
					</tr>
			
					</tr>
					<c:forEach items="${content}" var="content">
					<tr  align="center" border="1">
						<td align="center">${content.num }</td>
						<td align="center"><a href = "/We2/notice/view?num=${content.num }">${content.title }</a></td>
						<td align="center">${content.writer }</td>
						<td align="center">${content.writedate }</td>
					</tr>
					</c:forEach>
					
				</table>
			</form>
	   </div><!-- board contents end -->

	</div> <!-- content_wrap end -->
</div> <!-- container_wrap -->
</body>
</html>