<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WE2_프로젝트</title>
 
</head>
<body>

	<script type="text/javascript">
		
	</script>
<body>
	
			<div id="wrap_content">
			
					<h1>공지사항</h1>
				
				<!-- 글쓰기 버튼 -->
				<div class="btn">
                  <form action="Notice.do" method="get" name =" random ">
				     <input class ="add_btn" type="submit" value="글쓰기">
					 <input class="add_btn" type="hidden" name="write" value="../notice/write.jsp">
			      </form> 
			   </div> <!-- write_text end-->
			   
			     <!-- <form action="Notice.do" method="get" name =" random ">
				<table  cellpadding="0" cellspacing="0" border="0">
					<tr align="right">
						<td><input type="submit" value="글쓰기">
						<input type="hidden" name="write" value="../notice/write.jsp">
						</td>
					</tr>
				</table>
			   </form> -->
			   
			   <div class="count">
				<%
					Class.forName("oracle.jdbc.driver.OracleDriver");
					String url = "jdbc:oracle:thin:@localhost:1521:orcl";
					String id = "We2";
					String pass = "1234";
					int total = 0;

					try {
						Connection conn = DriverManager.getConnection(url, id, pass);
						Statement stmt = conn.createStatement();

						String sqlCount = "select count(*) from notice";
						ResultSet rs = stmt.executeQuery(sqlCount);

						if (rs.next()) {
							total = rs.getInt(1);
						}
						out.print("총 게시물: " + total + "개");

						String sqlList = "select num, title, writer, writedate from notice order by num desc ";
						rs = stmt.executeQuery(sqlList);
				%>
				</div>
				<!-- 표 안의 내용  -->
				<div class="board_contents">
			    <form method = "get" name = "list">
				
				<table>	
					<tr>
						<th>번호</th>
						<th style="width:50%;">제목</th>
						<th style="width:20%;">작성자</th>
						<th style="width:20%;">작성일</th>
					</tr>
					<%
						if (total == 0) {
					%>
					<tr align="center" height="30">
						<td>등록된 글이 없습니다.</td>
					</tr>
					<%
						} else {
								while (rs.next()) {
									int num = rs.getInt(1);
									String title = rs.getString(2);
									String writer = rs.getString(3);
									Timestamp writedate = rs.getTimestamp(4);
									System.out.println("rs값 : " +rs.getInt(1));
					%>
					<tr  align="center" border="1">
						<td align="center"><%=num%></td>
						<td align="center"><a href = "/We2/Notice.do?view=../notice/view.jsp&num=<%=num%>"><%=title%></a></td>
						<td align="center"><%=writer%></td>
						<td align="center"><%=writedate%></td>
						
					</tr>
					
					<%
						}
							}
							rs.close();
							stmt.close();
							conn.close();
						} catch (SQLException e) {
							out.println(e.toString());
						}
					%>

				</table>
			</form>
	   </div><!-- board contents end -->

			
       
	
	</div> <!-- wrap end -->

</body>
</html>