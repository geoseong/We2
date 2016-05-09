<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "java.sql.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>

<body>
<%
	request.setCharacterEncoding("utf-8");

	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id  = "We2";
	String password = "1234";
	
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String pass = request.getParameter("pass");
	String content = request.getParameter("content");
	
	try{
		Connection conn = DriverManager.getConnection(url, id, password);
		
		String sql = "insert into notice(num, title, writer, pass, content, writedate) VALUES (NOTICE_SEQ.nextval,?,?,?,?,SYSDATE)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, title);
		pstmt.setString(2, writer);
		pstmt.setString(3, pass);
		pstmt.setString(4, content);
		
		pstmt.execute();
		pstmt.close();
		
		conn.close();
	}catch(SQLException e){
		out.println(e.toString());
	}
%>

<script type="text/javascript">
self.window.alert("입력한 글을 저장하였습니다");
location.href = "/We2/Notice.do?list=../notice/list.jsp"
</script>

</body>
</html>