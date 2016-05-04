<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
</head>
<body>

<form name="write" method="post" action="DoWriteBoard.do">
<table cellspacing="1" style="width: 700px; border: 3px dotted black;">
	<tr>
		<td width="70"><p align="center">번호</p></td>
		<td></td>
	</tr>
	<tr>
		<td width="70"><p align="center">이름</p></td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td width="70"><p align="center">이메일</p></td>
		<td><input type="text" name="mail"></td>
	</tr>
	<tr>
		<td width="70"><p align="center">제목</p></td>
		<td><input type="text" name="subject" width="320px"></td>
	</tr>
	<tr>
		<td width="70"><p style="text-align: center; vertical-align: top;" >내용</p></td>
		<td><textarea rows="20" cols="50" name="memo">내용을 입력하세요.</textarea></td>
	</tr>
	<tr>
		<td align="center">
			<input type="submit" value="글쓰기">
		</td>
		<td>
			<p align="right">
			<input type="button" value="돌아가기" onclick="history.back(-1)">
			</p>
		</td>
	</tr>
</table>
</form>

</body>
</html>