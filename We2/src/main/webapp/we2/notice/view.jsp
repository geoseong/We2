<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%-- <%
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
%> --%>
<%-- 						<%
							rs.close();
									stmt.close();
									conn.close();
								}
							} catch (SQLException e) {
								out.println(e.toString());
							}
						%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 보기</title>
<link rel="stylesheet" href="/We2/css/w2_reset.css" type="text/css">
<link rel="stylesheet" href="/We2/css/02_project.css" type="text/css">
<link rel="stylesheet" type="text/css" href="../css/notice.css">
<script type="text/javascript" src="/We2/js/jquery-1.12.1.min.js"></script>
</head>




<body>
<div id="container">	

			<div id="content_wrap">
            	<h2>공지사항</h2>

				<c:forEach items="${content}" var="content">
				
			<table style="margin-top:30px;">
						<tr>
							<th style="width:200px;">글번호</th>
							<td >${content.num }</td>
						</tr>
						
						<tr>
							<th>이름</th>
							<td>${content.writer }</td>
						</tr>
						
						<tr>
							<th>작성일</th>
							<td >${content.writedate }</td>
						</tr>
						
						<tr>
							<th>제목</th>
							<td>${content.title }</td>
						</tr>
						
						<tr>
							<th>내용</th>
							<td width="399" colspan="2" height="200" style="text-align: left">${contentbr }</td>
						</tr>

                       </table>
						<div class="c_btn">
						<c:choose>
						<c:when test="${content.writer eq authInfo.userId }">
							<input class="add_btn" type="button" value="목록" onclick="location.href='/We2/notice/list';"> 
							<input class="add_btn" type="button" value="수정" onclick="location.href='/We2/notice/modify_view?num=${content.num }';"> 
							<input class="add_btn" type="button" value="삭제" onclick="location.href='/We2/notice/delete?num=${content.num }';">
						</c:when>
						<c:otherwise>
							<input class="add_btn" type="button" value="목록" onclick="location.href='/We2/notice/list';"> 
						</c:otherwise>
						</c:choose>
						</div>
						</c:forEach>
	    </div> <!-- wrap_content end -->
	
	</div>
</body>
</html>