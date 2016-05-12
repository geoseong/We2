<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>
<%@ page import="com.we2.board.community.BoardBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Properties" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="com.we2.board.community.PageNumberingManager" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>팀원구하기</title>
</head>
<body>

<c:set var="current_page" value="${current_page}" />
<c:set var="total_cnt" value="${totalCnt}" />
<%
int c_page = Integer.parseInt((String) (pageContext.getAttribute("current_page")));
pageContext.setAttribute("c_page", c_page);
%>
<table cellspacing="1" width="700" >
<tr>
<td>총 게시물수:<c:out value="${totalCnt }" /></td>
<td><p align="right">페이지:<c:out value="${current_page }" /></p></td>
</tr>
</table>


<table cellspacing="1" width=700 >
<tr>
<td width=50><p align="center">번호</p></td>
<td width=320><p align="center">제목</p></td>
<td width=100><p align="center">이름</p></td>
<td width=100><p align="center">등록일</p></td>
<td width=100><p align="center">조회수</p></td>
</tr>

<c:forEach var="board" items="${boardList }">
<tr>
<td width=50><p align="center">${board.getcFindNum() }</p></td>
<td width=100><p align="center">${board.getUserId() }</p></td>

<td width=320><p align="center">
<a href="viewWork.do?cFindContent_cFindNum=${board.getcFindNum() }&current_page=<c:out value="${current_page }"/>&searchStr=None" title="${board.getcFindContent() }">
<c:out value="${board.getcFindContent() }" />
</a></p></td>

<td width=100><p align="center"><c:out value="${board.getcFindDate() }" /></p></td>
<td width=100><p align="center"><c:out value="${board.getcFindClick() }" /></p></td>
</tr>
</c:forEach>
<%
int rowsPerPage = 10;
int total_cnt = ((Integer)(pageContext.getAttribute("total_cnt"))).intValue();

//전체 페이지
int total_pages = PageNumberingManager.getInstance().getTotalPage(total_cnt, rowsPerPage);
pageContext.setAttribute("t_pages", total_pages);
%>
</table>
 
<table cellspacing="1" width="700" >
<tr>
<td>
<c:forEach var="i" begin="1" end="${t_pages}">
<a href="listSpecificPageWork.do?current_page=${i }">[<c:if test="${i==c_page}"><b></c:if>${i }<c:if test="${i==c_page}"></b></c:if>]</a>
</c:forEach>
</td>
</tr>

</table>
 
<table width=700>
<tr>
<td><input type="button" value="글쓰기" onclick="window.location='show_write_form.do'"></td>
<td><form name="searchf" method="post" action="searchWithSubject.do">
<p align="right"><input type="text" name="searchStr" size="50" maxlength="50">
<input type=submit value="글찾기"></p>
</form>
</td>
</tr>
</table>




</body>
</html>