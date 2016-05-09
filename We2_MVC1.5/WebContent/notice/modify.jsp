<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 수정</title>
<link rel="stylesheet" href="../css/w2_reset.css" type="text/css">
<link rel="stylesheet" href="../css/02_project.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.12.1.min.js"></script>
</head>

<script type="text/javascript">
	function modifyCheck() {
		var form = document.modifyform;

		if (!form.title.value) {
			alert("제목을 적어주세요");
			form.title.focus();
			return;
		}
		if (!form.pass.value) {
			alert("비밀번호를 적어주세요");
			form.pass.focus();
			return;
		}
		if (!form.content.value) {
			alert("내용을 적어주세요");
			form.content.focus();
			return;
		}
		form.submit();
	}
</script>

<%
	request.setCharacterEncoding("utf-8");
	Class.forName("oracle.jdbc.driver.OracleDriver");

	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "We2";
	String password = "1234";

	String writer = "";
	String title = "";
	String pass = "";
	String content = "";
	int num = Integer.parseInt(request.getParameter("num"));

	try {
		Connection conn = DriverManager.getConnection(url, id, password);
		Statement stmt = conn.createStatement();

		String sql = "select writer, pass, title, content from notice where num=" + num;
		ResultSet rs = stmt.executeQuery(sql);

		if (rs.next()) {
			writer = rs.getString(1);
			pass = rs.getString(2);
			title = rs.getString(3);
			content = rs.getString(4);
		}
		rs.close();
		stmt.close();
		conn.close();
	} catch (SQLException e) {
		out.println(e.toString());
	}
%>

<body>

	<div id="wrap_content">
		
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
			
		</table>
		<table>
			<form name=modifyform method="post" action="notice/modify_ok.jsp?num=<%=num%>">
			
			
			  <table>
				<tr>
                  <th align="center">제목</th>
				  <td><input name="title" size="50" maxlength="100" value="<%=title%>"></td>
				</tr>
				
				
				<tr>
			    <th align="center">이름</th>
			    <td style="padding-left:15px;">&nbsp;&nbsp;<%=writer%><input type="hidden" name="writer" size="50" maxlength="100" value="<%=writer%>"></td>
				</tr>
				
				<tr>
					<th align="center">비밀번호</th>
					<td><input name="pass" type="password" id="pass" size="50"
						maxlength="100"></td>
				</tr>
				
				
				<tr>
					<th align="center">내용</th>
					<td><textarea name="content" cols="110" rows="13"><%=content%></textarea></td>
				</tr>

			     </table>
			
					 <div class="c_btn">
					<input class="add_btn" type="button" value="수정하기" onclick="javascript:modifyCheck();"> 
					<input class="add_btn" type="button" value="돌아가기" onclick="javacript:history.back(-1)">
	                 </div>
			</form>
	    </table>
	</div>
</body>
</html>