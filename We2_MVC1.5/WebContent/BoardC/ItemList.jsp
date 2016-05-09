<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>We2_(___) 게시판</title>
<script type="text/javascript">
	var msg = "${msg}";
	$(function() {
		if(msg.value != null){
			alert("${msg}");
		}
	});
</script>

</head>
<body>
<!--  게시판 영역 - css에서 #contents 블록의 테두리선(border)를 없애주시면 됩니다. -->
<form action="ItemList" name="search" method="get">
<input type="hidden" name="page" value="${page}">
		
				<div class="write_community">
				 <a href="ItemWrite?page=${page}">글쓰기</a>
				 </div>
				
				<table class="list">
				<tr>
				<th style="width:10%">글번호</th> 
				<th style="width:40%">제목</th> 
				<th style="width:20%">작성자</th> 
				<th style="width:20%">작성일</th> 
				<th style="width:10%">조회수</th>
				</tr>
				

				<!-- 반복문 : c:forEach의 items에는 배열이나 List변수가 오는 자리이다. -->
				<c:forEach var="BoardList"  items="${BoardList}" >	
					<tr class="record">	
						<td>${BoardList.itemNum }</td>
						<td>
								<a href="ItemContent?itemNum=${BoardList.itemNum }&page=${page}">${BoardList.itemTitle }</a>
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
				</table>
					
				      <div class="search">
					  <select id="find" name="find" size="1" >
					     <option value="itemTitle">제목</option>
					     <option value="userId">아이디</option>
					     <option value="itemContent ">내용</option>					   
					  </select>
					
					 	<input type="text" name="findword">
					 	<input class="add_btn" type="submit" value="검색">
					 </div>
		
     </form>
    <!--  게시판 영역 끝 -->
</body>
</html>