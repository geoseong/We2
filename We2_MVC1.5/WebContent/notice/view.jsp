<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "We2";
	String pass = "1234";
	String number=(String)request.getAttribute("num");
	int num = Integer.parseInt(number);
	/* int num = Integer.parseInt(request.getParameter("num")); */

	try {
		Connection conn = DriverManager.getConnection(url, id, pass);
		Statement stmt = conn.createStatement();

		String sql = "select num, title, writer, writedate, content from notice where num=" + request.getAttribute("num").toString();
			System.out.println("num받아오는 값 : " +request.getAttribute("num").toString());
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			String title = rs.getString(2);
			String writer = rs.getString(3);
			String writedate = rs.getString(4);
			String content = rs.getString(5);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 보기</title>
<link rel="stylesheet" href="../css/w2_reset.css" type="text/css">
<link rel="stylesheet" href="../css/02_project.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.12.1.min.js"></script>
</head>




<body>



	<div id="wrap_content">
	
					<table>
						<tr>
							<th >글번호</th>
							<td ><%=num%></td>
						</tr>
						
						<tr>
							<th>이름</th>
							<td><%=writer%></td>
						</tr>
						
						<tr>
							<th>작성일</th>
							<td ><%=writedate%></td>
						</tr>
						
						<tr>
							<th>제목</th>
							<td><%=title%></td>
						</tr>
						
						<tr>
							<th>내용</th>
							<td width="399" colspan="2" height="200"><%=content%></td>
						</tr>

						<%
							rs.close();
									stmt.close();
									conn.close();
								}
							} catch (SQLException e) {
								out.println(e.toString());
							}
						%>
                       </table>
						<div class="c_btn">
						<input class="add_btn" type="button" value="목록" onclick="location.href='/We2/Notice.do?list=../notice/list.jsp';"> 
						<input class="add_btn" type="button" value="수정" onclick="location.href='/We2/Notice.do?modify=../notice/modify.jsp&num=<%=num%>';"> 
						<input class="add_btn" type="button" value="삭제" onclick="location.href='/We2/Notice.do?delete=../notice/delete.jsp&num=<%=num%>';">
						</div>
	</div> <!-- wrap_content end -->
</body>
</html>