<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*, com.we2.sharepjtboard.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>We2_ 프로젝트 게시판 _ 글쓰기</title>
</head>
<script type="text/javascript" src="../js/board.js"></script>
<body onload="boardidCheck()">
<!--  게시판 영역 - css에서 #contents 블록의 테두리선(border)를 없애주시면 됩니다. -->			
			<%-- <form:form action="content" method="get" name="frm" commandName="PjtBoardBean"> --%>
			<form action="modify" method="get" name="frm" >
			<%-- <form:input path="itemNum" value="${BoardContent.get(0).getItemNum()}"/>
			<form:hidden path="category" value="${category }"/> --%>
				
				<input type="hidden" name="itemNum" value="${BoardContent.getItemNum() }">
				<input type="hidden" name="category" value="${category }">
				<table>
				<tr>
					<td>
						<table>
							<tr>
								<th>글번호</th>
								<td colspan="3">${BoardContent.getItemNum() }</td>
							</tr>
							<tr>
								<th style="width: 80px">작성자</th>
								<td>${BoardContent.getUserId()}</td>
								<th style="width: 80px">조회수</th>
								<td>${BoardContent.getItemClick() }	</td>
							</tr>
							<tr>
								<th>제   목 </th>
								<td colspan="3">${BoardContent.getItemTitle() }</td>
							</tr>
							<tr>
								<th>첨부파일</th>
								<td colspan="3">
								
								<c:choose>
									<c:when test="${empty BoardContent.getItemPath() }">
											<!-- 기본설정경로 : 서블릿경로
												E:\JavaSmartWeb\mywork_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps -->
										- 첨부파일 없음 -
									</c:when>
									<c:otherwise>
											<!-- 기본설정경로 : 서블릿경로
												E:\JavaSmartWeb\mywork_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps -->
										<a href="we2/pjtBoard/data/${BoardContent.getItemPath() }" >${BoardContent.getItemPath() }</a>
									</c:otherwise>
								</c:choose>
								</td>
							</tr>
							<tr>
								<th>글내용 </th>
								<td colspan="3">
								  ${BoardContent.getItemContent()}
								</td>
							</tr>
						</table>
					</td>
					<td>
						<c:choose>
							<c:when test="${empty BoardContent.getItemPath() }">
									<!-- 기본설정경로 : 서블릿경로
										E:\JavaSmartWeb\mywork_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps -->
								<img src="/We2/we2/pjtBoard/data/noimg.JPG" style="width: 300px;">
							</c:when>
							<c:when test="${BoardContent.getItemDataType().contains('image') }">
								<img src="/We2/we2/pjtBoard/data/${BoardContent.getItemPath() }" style="width: 300px;">
							</c:when>
							<c:otherwise>
									<!-- 기본설정경로 : 서블릿경로
										E:\JavaSmartWeb\mywork_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps -->
								<img src="/We2/we2/pjtBoard/data/datafile.jpg" style="width: 300px;">
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				</table>
				<br>
				<input type="submit" value="수정하기" style="padding: 5px;">
				<input type="button" value="목록" style="padding: 5px;" onclick="location.href='/We2/pjtBoard/list?page=1&category=${category}'">
				<input type="button" value="제거하기" style="padding: 5px;" onclick="location.href='delete?itemNum=${BoardContent.getItemNum() }&category=${category}'">
		</form>
		<%-- </form:form> --%>
<!--  게시판 영역 끝 -->
</body>
</html>