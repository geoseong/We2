<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 수정</title>
<link rel="stylesheet" href="/We2/css/w2_reset.css" type="text/css"> 
<link rel="stylesheet" href="/We2/css/02_project.css" type="text/css">  
<link rel="stylesheet" type="text/css" href="/We2/css/notice.css">

<script type="text/javascript" src="/We2/js/jquery-1.12.1.min.js"></script>
</head>

<script type="text/javascript">
	function modifyCheck() {
		var form = document.modifyform;

		if (!form.title.value) {
			alert("제목을 적어주세요");
			form.title.focus();
			return;
		}
/* 		if (!form.pass.value) {
			alert("비밀번호를 적어주세요");
			form.pass.focus();
			return;
		} */
		if (!form.content.value) {
			alert("내용을 적어주세요");
			form.content.focus();
			return;
		}
		form.submit();
	}
</script>

<body>
<div id="container">
	<div id="content_wrap">
          <h2>공지사항</h2>
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
		</table>
		
		<table>
			<c:forEach items="${content}" var="content">
				<form name="modifyform" method="post" action="modify?num=${content.num }">


					<table class="notice">
						<tr>
							<th align="center">제목</th>
							<td>
								<input name="title" size="50" maxlength="100" value="${content.title }">
							</td>
						</tr>


						<tr>
							<th align="center">이름</th>
							<td style="padding-left: 15px; text-align: left">&nbsp;&nbsp;${content.writer }
								<input type="hidden" name="writer" size="50" maxlength="100" value="${content.writer} ">
							</td>
						</tr>

						<!-- 				<tr>
					<th align="center">비밀번호</th>
					<td><input name="pass" type="password" id="pass" size="50"
						maxlength="100"></td>
				</tr>
				
				 -->
						<tr>
							<th align="center">내용</th>
							<td><textarea name="content" cols="110" rows="13">${content.content }</textarea></td>
						</tr>

					</table>
					<div class="c_btn">
						<input class="add_btn" type="submit" value="수정하기" onclick="javascript:modifyCheck();">
						<input class="add_btn" type="button" value="돌아가기" onclick="javacript:history.back(-1)">
					</div>
				</form>
			</c:forEach>
		</table>
	    </div>
	</div>
</body>
</html>