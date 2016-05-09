<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>We2_(___) 게시판 _ 글쓰기</title>
</head>

<body>
<!--  게시판 영역 - css에서 #contents 블록의 테두리선(border)를 없애주시면 됩니다. -->			
			<form action="ShareUpdate" method="get" name="frm" >
				<input type="hidden" name="itemNum" value="${BoardContent.itemNum }">
				<input type="hidden" name="page" value="${page }">
				<table>
				<tr>
					<td>
						<table>
							<tr>
								<th>글번호</th>
								<td colspan="3">${BoardContent.itemNum }</td>
							</tr>
							<tr>
								<th style="width: 80px">작성자</th>
								<td>${BoardContent.userId }</td>
								<th style="width: 80px">조회수</th>
								<td>${BoardContent.itemClick }	</td>
							</tr>
							<tr>
								<th>제   목 </th>
								<td colspan="3">${BoardContent.itemTitle }</td>
							</tr>
							<tr>
								<th>사   진 </th>
								<td colspan="3">
								<a href="/We2/BoardP/pic/${BoardContent.itemPath }">${BoardContent.itemPath }</a>
								
								</td>
							</tr>
							<tr>
								<th>글내용 </th>
								<td colspan="3">
								  ${BoardContent.itemContent}
								</td>
							</tr>
						</table>
					</td>
					<td>
						<c:choose>
							<c:when test="${empty BoardContent.itemPath }">
									<!-- 기본설정경로 : 서블릿경로
										E:\JavaSmartWeb\mywork_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps -->
								<img src="/We2/BoardP/pic/noimg.JPG" style="width: 300px;">
							</c:when>
							<c:otherwise>
									<!-- 기본설정경로 : 서블릿경로
										E:\JavaSmartWeb\mywork_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps -->
								<img src="/We2/BoardP/pic/${BoardContent.itemPath }" style="width: 300px;">
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				</table>
				<br>
				<input type="submit" value="수정하기" >
				<input type="button" value="목록" onclick="location.href='ShareList?page=${page}'">
				<input type="button" value="제거하기" onclick="location.href='ShareDelete?itemNum=${BoardContent.itemNum }&page=${page}'">
		</form>
<!--  게시판 영역 끝 -->
</body>
</html>