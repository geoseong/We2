<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>We2_(___) 게시판 _ 업데이트 하기</title>
</head>
<body>
<!--  게시판 영역 - css에서 #contents 블록의 테두리선(border)를 없애주시면 됩니다. -->			
			<form action="ItemUpdate" method="post" enctype="multipart/form-data" name="frm">
				<input type="hidden" name="itemNum" value="${BoardUpdate.itemNum }">
				<input type="hidden" name="page" value="${page }">
				<table>
				<tr>
					<td>
						<table>
							<tr>
								<th>글번호</th>
								<td colspan="3">${BoardUpdate.itemNum }</td>
							</tr>
							<tr>
								<th style="width: 80px">작성자</th>
								<td>${BoardUpdate.userId }</td>
								<th style="width: 80px">조회수</th>
								<td>${BoardUpdate.itemClick }	</td>
							</tr>
							<tr>
								<th>제   목 </th>
								<td colspan="3"><input type="text" value="${BoardUpdate.itemTitle }" name="itemTitle"></td>
							</tr>
							<tr>
								<th>사   진 </th>
								<td colspan="3">
								<input type="file" name="itemPath">								
								</td>
							</tr>
							<tr>
								<th>글내용 </th>
								<td colspan="3">
								<textarea rows="10" cols="80" name="itemContent">${BoardUpdate.itemContent}</textarea>
								</td>
							</tr>
						</table>
					</td>
					<td>
						<c:choose>
							<c:when test="${empty BoardUpdate.itemPath }">
									<!-- 기본설정경로 : 서블릿경로
										E:\JavaSmartWeb\mywork_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps -->
								<img src="/We2/BoardC/pic/noimg.JPG">
							</c:when>
							<c:otherwise>
									<!-- 기본설정경로 : 서블릿경로
										E:\JavaSmartWeb\mywork_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps -->
								<img src="/We2/BoardC/pic/${BoardUpdate.itemPath }">
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				</table>
				<br>
				<input type="submit" value="수정" >
				<input type="button" value="취소" onclick="location.href='ItemList?page=${page}'">
			</form>
<!--  게시판 영역 끝 -->
</body>
</html>