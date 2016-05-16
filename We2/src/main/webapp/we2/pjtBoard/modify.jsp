<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>We2_프로젝트 게시판 _ 업데이트 하기</title>
</head>
<body>
<!--  게시판 영역 - css에서 #contents 블록의 테두리선(border)를 없애주시면 됩니다. -->			
			<form action="modify" method="post" enctype="multipart/form-data" name="frm">
				<input type="hidden" name="itemNum" value="${BoardUpdate.getItemNum() }">
				<input type="hidden" name="category" value="${category }">
				<table class="modify">
				<tr>
					<td style="border:none; padding:0px;">
					
						<table >
							<tr>
								<th>글번호</th>
								<td colspan="3">${BoardUpdate.getItemNum() }</td>
							</tr>
							<tr>
								<th style="width: 80px">작성자</th>
								<td>${BoardUpdate.getUserId() }</td>
								<th style="width: 80px">조회수</th>
								<td>${BoardUpdate.getItemClick() }	</td>
							</tr>
							<tr>
								<th>제   목 </th>
								<td colspan="3"><input type="text" style="width:590px;"value="${BoardUpdate.getItemTitle() }" name="itemTitle"></td>
							</tr>
							<tr>
								<th>첨부파일</th>
								<td colspan="3">
								<input type="file" name="itemPath">								
								</td>
							</tr>
							<tr>
								<th>글내용 </th>
								<td colspan="3">
								<textarea rows="10" cols="80" name="itemContent">${BoardUpdate.getItemContent()}</textarea>
								</td>
							</tr>
						</table>
					</td>
					<td style="width:200px; border:0.5px solid #d3d3d3;">
						<c:choose>
							<c:when test="${empty BoardUpdate.getItemPath() }">
									<!-- 기본설정경로 : 서블릿경로
										E:\JavaSmartWeb\mywork_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps -->
								<img src="/We2/we2/pjtBoard/data/noimg.JPG">
							</c:when>
							<c:otherwise>
									<!-- 기본설정경로 : 서블릿경로
										E:\JavaSmartWeb\mywork_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps -->
								<img src="/We2/we2/pjtBoard/data/${BoardUpdate.getItemPath() }">
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				</table>
				
				<div class="write_btn" style="text-align:center;">
				<input type="submit" value="수정" >
				<input type="button" value="목록" style="padding: 5px;" onclick="location.href='/We2/pjtBoard/list?page=1&category=${category}'">
			    </div>
			</form>
<!--  게시판 영역 끝 -->
</body>
</html>