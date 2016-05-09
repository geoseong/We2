<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>We2_(___) 게시판 _ 글쓰기</title>
</head>
<body>
<!--  게시판 영역 - css에서 #contents 블록의 테두리선(border)를 없애주시면 됩니다. -->
		<form method="post" enctype="multipart/form-data" name="frm">
		<input type="hidden" name="page" value="${page }">
				<table>
					<tr>
						<th> 작성자 </th>
						<td>${loginUser.userid }</td>
					</tr>
					<tr>
						<th> 제    목 </th>
						<td><input type="text" name="title" size="80"></td>
					</tr>
					<tr>
						<th> 자    료 </th>
						<td><input type="file" name="path" >
						(주의사항 : 업로드 용량 제한은 20MB 입니다.)
						</td>
					</tr>
					<tr>
						<th> 글내용 </th>
						<td><textarea rows="10" cols="80" name="context"></textarea>
						</td>
					</tr>
				</table>
				<br>
				<input type="submit" value="등록" >
				<input type="button" value="목록" onclick="location.href='ShareList?page=${page}'">
		</form>
<!--  게시판 영역 끝 -->
</body>
</html>