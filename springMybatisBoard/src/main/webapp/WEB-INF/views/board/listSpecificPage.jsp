<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<%@ page import="mysite.com.app.*" %><!-- mysite.com.app.BoardBean -->
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Properties" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="mysite.com.app.PageNumberingManager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>목록</title>

<link rel="stylesheet" type="text/css" href="css/boardcss.css" >
</head>

<body>
<c:set var="current_page" value="${current_page }"/>
<c:set var="total_cnt" value="${totalCnt }"/>
<%
	int c_page=Integer.parseInt( (String) (pageContext.getAttribute("current_page") ));
	pageContext.setAttribute("c_page", c_page);
%>
<table cellspacing="1" style="width: 700px; border: 0px;">
	<tr>
		<td>총 게시물수: <c:out value="${totalCnt }"/></td>
		<td><p align="right"> 페이지: <c:out value="${current_page }"/>
	</tr>
</table>

<table cellspacing="1" style="width: 700px; border: 1px solid black;">
	<tr>
		<th width="50" id="hi"><p align="center">번호</p></th>
		<th width="100"><p align="center">이름</p></th>
		<th width="320"><p align="center">제목</p></th>
		<th width="100"><p align="center">등록일</p></th>
		<th width="100"><p align="center">조회수</p></th>
	</tr>

	<c:forEach var="board" items="${boardList }">
		<tr>
			<td width="50"><p align="center">${board.getId() }</p></td>
			<td width="100"><p align="center">${board.getName() }</p></td>
			<td width="320">
				<p align="center">
					<a href="viewWork.do?memo_id=${board.getId() }&current_page=<c:out value="${current_page }"/>&searchStr=None" title="${board.getMemo() }"><c:out value="${board.getSubject() }"/></a>
				</p>
			</td>
			<td width="100"><p align="center"><c:out value="${board.getCreated_date() }"/></p></td>
			<td width="100"><p align="center"><c:out value="${board.getHits() }"/></p></td>
		</tr>
	</c:forEach>
	<%
		int rowsPerPage=2;
		int total_cnt = ( (Integer)(pageContext.getAttribute("total_cnt")) ).intValue();
		
		// 전체 페이지
		int total_pages = PageNumberingManager.getInstance().getTotalPage(total_cnt, rowsPerPage);
		pageContext.setAttribute("t_pages", total_pages);
	%>
</table>

<table cellspacing="1" style="width: 700px; border: 1px dotted black; text-align: center;">
	<tr>
		<td>
		<c:forEach var="i" begin="1" end="${t_pages }">
			<a href="listSpecificPageWork.do?current_page=${i }">
				[
				<c:if test="${i == c_page }"><b></c:if>
				${i }
				<c:if test="${i == c_page }"></b></c:if>
				]			
			</a>
		</c:forEach>
		</td>
	</tr>
</table>

<table width="700">
	<tr>
		<td><input type="button" value="글쓰기" onclick="window.location='show_write_form.do'"></td>
		<td>
			<form name="searchf" method="post" action="searchWithSubject.do">
			<p align="right">
				<input type="text" name="searchStr" size="50" maxlength="50">
				<input type="submit" value="글찾기">
			</p>
			</form>
		</td>
	</tr>
</table>
</body>
</html>