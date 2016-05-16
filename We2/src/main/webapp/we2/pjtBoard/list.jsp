<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>included List Page</title>
</head>
<body>
<!--  게시판 영역 - css에서 #contents 블록의 테두리선(border)를 없애주시면 됩니다. -->

<form:form action="find" method="post" commandName="pjtBoardBean">
		
				<div class="write">
				<a href="write?category=${category }">글쓰기</a>
				</div>
				
			
				<table class="list">
				
				<tr><th>글번호</th> <th>제목</th> <th>작성자</th> <th>작성일</th> <th>조회수</th></tr>
				

				<!-- 반복문 : c:forEach의 items에는 배열이나 List변수가 오는 자리이다. -->
				<c:forEach var="content"  items="${Content}" >	
					<tr class="record">	
						<td>${content.itemNum }</td>
						<td>
								<a href="content?itemNum=${content.itemNum }&category=${category}">${content.itemContent }</a>
						</td>
						<td>${content.userId }</td>
						<td>${content.itemDate }</td>
						<td>${content.itemClick }</td>
					</tr>		
				</c:forEach>
				</table>
			<!-- ★★ 페이징 카운트 넣는 곳 ★★ -->
				
				<div class ="counting">
				<c:choose>
					<c:when test="${block-1==0 }">
					</c:when>
					<c:otherwise>
						<a href="list?page=${block_first - page_for_block }&category=${category}">[이전]</a>&nbsp;
					</c:otherwise>
				</c:choose>
				<c:forEach var="i" begin="${block_first }" end="${block_last}" >
					<c:choose>
						<c:when test="${i == c_page }">
							<b> [ ${i} ] </b>
						</c:when>
						<c:otherwise>
							<a href="list?page=${i }&category=${category}">
								[ ${i} ]
							</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${block==block_total }">
					</c:when>
					<c:otherwise>
						&nbsp;<a href="list?page=${block_first + page_for_block}&category=${category}">[다음]</a>
					</c:otherwise>
				</c:choose>
				</div>  <!-- counting end -->
			
			<!-- 검색. -->
				
				 <div class="search">
					<select id="find" name="find" size="1">
					   <option value="itemTitle">제목</option>
					   <option value="userId">아이디</option>
					   <option value="itemContent ">내용</option>					   
					 </select>
					
					 	<input type="text" name="findword">
					 	<input class="add_btn" type="submit" value="검색">
				</div> <!-- search end -->
				
		
 </form:form>
<!--  게시판 영역 끝 -->
</body>
</html>