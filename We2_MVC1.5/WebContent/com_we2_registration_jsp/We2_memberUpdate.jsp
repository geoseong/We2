<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 관리</title>
<script type="text/javascript" src="script/We2_member.js"></script>
</head>
<body>
<h2>회원 수정</h2>

<form action="/We2/We2_MemberUpdate.do" method="post" name="frm">
<table>
<tr>
<td> 이름		</td>
<td>${mVo.name}<input type="hidden" name="name" value="${mVo.name}"></td>
</tr>
<tr>
<td>아이디 </td>
<td>${mVo.userid}<input type="hidden" name="userid" value="${mVo.userid}"></td>
</tr>
<tr>
<td> 암 &nbsp; 호 </td>
<td><input type="password" name="pwd" size="20">*</td>
</tr>
<tr height="30">
<td width="80">암호 확인</td>
<td><input type="password" name="pwd_check" size="20">*</td>
</tr>
<tr>
<td> 이메일 </td>
<td> <input type="text" name="email" size="20" value="${mVo.email}"></td>
</tr>
<tr>
<td> 보조 이메일 </td>
<td> <input type="text" name="sub_email" size="20" value="${mVo.sub_email}"></td>
</tr>
<tr>
<td>전화번호</td>
<td><input type="text" name="phone" size="20" value="${mVo.phone}"></td>
</tr>
<tr>
<td>성별</td>
<td>

<c:choose>
<c:when test="${mVo.gender==1}">
<input type="radio" name="gender" value="1" checked="checked"> 남성
<input type="radio" name="gender" value="0"> 여성
</c:when>

<c:otherwise>
<input type="radio" name="gender" value="1"> 남성
<input type="radio" name="gender" value="0" checked="checked"> 여성
</c:otherwise>
</c:choose>
</td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="확인" onclick="return joincheck()">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="reset" value="취소">
</td>
</tr>
</table>
</form>
</body>
</html>