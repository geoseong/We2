<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="../js/board.js"></script>
<meta charset="UTF-8">
<title>We2_ 프로젝트 게시판 _ 글쓰기</title>
</head>
<body>
<!--  게시판 영역 - css에서 #contents 블록의 테두리선(border)를 없애주시면 됩니다. -->
		<form action="write?category=${category }" method="post" enctype="multipart/form-data" name="frm">
			<input type="hidden" name="page" value="1">
			<%-- <input type="text" name="category" value="${category }">		 --%>		
				<table>
					<tr>
						<th> 작성자 </th>
						<td>${authInfo.userId }</td>
					</tr>
					<tr>
						<th class="write_th"> 제    목 </th>
						<td>
							<input type="text" name="itemTitle" size="80">
						</td>
					</tr>
					<tr>
						<th> 자    료 </th>
						<td><input type="file" name="file" >
						(주의사항 : 업로드 용량 제한은 20MB 입니다.)
						</td>
					</tr>
					<tr>
						<th> 글내용 </th>	
						<td>
							<textarea rows="10" cols="80" name="itemContent"></textarea>
						</td>
					</tr>
				</table>
				<br>
			<div class="write_btn" align="right" >
				<input type="submit" value="등록" style="padding: 5px;"onclick="return charcheck()">
				<input type="button" value="목록" style="padding: 5px;" onclick="location.href='/We2/pjtBoard/list?page=1&category=${category}'">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
		</form>
<!--  게시판 영역 끝 -->
</body>
</html>