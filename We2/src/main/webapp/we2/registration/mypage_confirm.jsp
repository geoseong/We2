<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="script/We2_member.js"></script>
<img src="../img/img_01.gif" />
</head>
<body>

	<h1>We2 비밀번호를 입력해주세요 ^^</h1>
	
	<form action="/We2/We2_mypage_confirm.do" name="frm" method="post">
	<table>
		<tr>
		<td>비밀번호</td>
		<td><input type="password"  id="byteInfo" name="pwd" size="20" onkeyup="checkLength(this, 12)"></td>
		</tr>
	</table>
	</form>
</body>
</html>