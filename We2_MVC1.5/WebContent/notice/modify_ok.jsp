<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "We2";
	String pass = "1234";
	String password = "";
	
	try{
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String passw = request.getParameter("pass");
		
		Connection conn = DriverManager.getConnection(url, id, pass);
		Statement stmt = conn.createStatement();
		
		String sql = "select pass from notice where num="+num;
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next()){
			password = rs.getString(1);
		}
		if(password.equals(passw)){
			sql = "update notice set title='"+title+"',content='"+content+"'where num="+num;
			stmt.executeUpdate(sql);
%>
<script type="text/javascript">
	self.window.alert("글이 수정되었습니다");
	location.href = "/We2/Notice.do?view=../notice/view.jsp&num=<%=num%>";
</script>
<%
			rs.close();
			stmt.close();
			conn.close();
		}else{
%>
<script type="text/javascript">
	self.window.alert("비밀번호를 틀렸습니다");
	location.href = "javascript:history.back()";
</script>
<%
		}
	}catch(SQLException e){
		out.print(e.toString());
	}
%>

<body>

</body>
</html>