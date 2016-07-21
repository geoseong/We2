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
	request.setCharacterEncoding("utf-8");
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "We2";
	String pass = "1234";
	String passd = null;
	int num = Integer.parseInt(request.getParameter("num"));
	String password = request.getParameter("passd");
	
	try{
		Connection conn = DriverManager.getConnection(url, id, pass);
		Statement stmt = conn.createStatement();
		
		String sql = "select pass from notice where num="+num;
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next()){
			passd = rs.getString(1);
		}
		if(passd.equals(password)){
			sql = "delete from notice where num="+num;
			stmt.executeUpdate(sql);
			
%>
<script type="text/javascript">
self.window.alert("해당 글을 삭제하였습니다");
location.href = "/We2/Notice.do?list=../notice/list.jsp";
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
		out.println(e.toString());
	}
%>
<body>

</body>
</html>