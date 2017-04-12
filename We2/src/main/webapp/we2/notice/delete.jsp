<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 삭제</title>
<link rel="stylesheet" href="../css/w2_reset.css" type="text/css">
<link rel="stylesheet" href="../css/02_project.css" type="text/css">
<script type="text/javascript" src="../js/jquery-1.12.1.min.js"></script>
</head>
<body>
	<script type="text/javascript">
		function deleteCheck() {
			var form = document.deleteform;

			if (!form.passd.value) {
				alert("비밀번호를 적어주세요");
				form.passd.focus();
				return;
			}
			form.submit();
		}
	</script>


	<div class="contents">
		<h2>
			<b>게시판 별 프로젝트 내용 넣는 곳</b>
		</h2>




		<%
			int num = Integer.parseInt(request.getParameter("num"));
		%>

		<table>
			<form name="deleteform" method="post"
				action="notice/delete_ok.jsp?num=<%=num%>">
				<tr>
					<td>
						<table width="100%" cellpadding="0" cellspacing="0" border="1">
							<tr>
								<td align="center">비밀번호를 입력하면 삭제</td>
							</tr>
						</table>
						<table>
							<tr>
								<td>&nbsp;</td>
								<td align="center">비밀번호</td>
								<td><input name="passd" type="password" size="50"
									maxlength="100"></td>
								<td>&nbsp;</td>
							</tr>
							<tr height="1" bgcolor="#dddddd">
								<td conspan="4"></td>
							</tr>
							<tr align="center">
								<td>&nbsp;</td>
								<td colspan="2"><input type="button" value="삭제"
									onclick="javascript:deleteCheck();"> <input
									type="button" value="취소" onclick="javascript:history.back(-1)">
								<td>&nbsp;</td>
							</tr>
						</table>
					</td>
				</tr>
			</form>
		</table>
	</div>


</body>
</html>