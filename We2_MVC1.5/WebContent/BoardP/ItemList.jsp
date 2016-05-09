<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>We2_(___) 게시판</title>


</head>
<body>
<!--  게시판 영역 - css에서 #contents 블록의 테두리선(border)를 없애주시면 됩니다. -->
<form action="ShareList" name="search" method="get">
<input type="hidden" name="page" value="${page }">
		<table class="list">
				<tr>
					<td colspan="5" style="border: white; text-align: right;">
						<a href="ShareWrite?page=${page}">글쓰기</a>
					</td>
				</tr>
				
				<tr><th>글번호</th> <th>제목</th> <th>작성자</th> <th>작성일</th> <th>조회수</th></tr>
				

				<!-- 반복문 : c:forEach의 items에는 배열이나 List변수가 오는 자리이다. -->
				<c:forEach var="BoardList"  items="${BoardList}" >	
					<tr class="record">	
						<td>${BoardList.itemNum }</td>
						<td>
								<a href="ShareContent?itemNum=${BoardList.itemNum }&page=${page}">${BoardList.itemTitle }</a>
						</td>
						<td>${BoardList.userId }</td>
						<td>${BoardList.itemDate }</td>
						<td>${BoardList.itemClick }</td>
					</tr>		
				</c:forEach>
				
				<tr>
				<!-- ★★ 페이징 카운트 넣는 곳 ★★ -->
				<td colspan="6">
					${pagecounting }
				</td>
				</tr>
				
				<tr>
					
					<td>
					<select id="find" name="find" size="1">
					   <option value="itemTitle">제목</option>
					   <option value="userId">아이디</option>
					   <option value="itemContent ">내용</option>					   
					 </select>
					 </td>
					 <td>
					 	<input type="text" name="findword">
					 	<input type="submit" value="검색">
					 </td>
					
				</tr>
				
		</table>
 </form>
<!--  게시판 영역 끝 -->
</body>
</html>