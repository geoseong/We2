<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원관리</title>
<script type="text/javascript" src="script/We2_member.js"></script>
</head>
<body>
	<jsp:include page="We2_header.jsp"/>
	<h2>로그인</h2>
	<form action="We2_login.do" method="post" name="frm">
		<table>
			<tr>
				<td>아이디    </td>
				<td><input type="text" name="userid" value="${userid}"></td>
			</tr>
			<tr>
				<td>암  호    </td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="로그인"
					onclick="return loginCheck()">&nbsp;&nbsp; 
					<input type="reset" value="취소"> &nbsp;&nbsp; 
					<input type="button" value="회원가입" onclick="location.href='com_we2_registration_jsp/We2_loginForm.jsp'"></td>
			</tr>
			<tr>
				<td colspan="2">${message}</td>
			</tr>
		</table>
	</form>
</body>
</html>