<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티게시판 _write</title>
<script type="text/javascript">
	$(window).ready(function() {
		$("#file").change(function() {
			var maxSize = 20*1024*1024;
			var size = $("#file")[0].files[0].size;
			
			if(size > maxSize) {
				$("div .msg").html("파일 용량이 20 MB 를 초과하였습니다.");
			}else{
				$("div .msg").html("");
			}
		});
	});
	
	function filesizechk(){
		var maxSize = 20*1024*1024;
		var size = $("#file")[0].files[0].size;
		
		if(size > maxSize) {
			alert("파일 용량이 20 MB 를 초과하였습니다.");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<!--  게시판 영역 - css에서 #contents 블록의 테두리선(border)를 없애주시면 됩니다. -->
		<form action="write?category=${category }" method="post" enctype="multipart/form-data" name="frm">
<%-- 		<input type="text" name="category" value="${category }">--%>				
				<table>
					<tr>
						<th> 작성자 </th>
						<td>${authInfo.userId }</td>
					</tr>
					<tr>
						<th class="write_th"> 제    목 </th>
						<td>
							<input type="text" name="itemTitle" size="80">
						</td>
					</tr>
					<tr>
						<th> 자    료 </th>
						<td><input type="file" name="file" id="file">
						(주의사항 : 업로드 용량 제한은 20MB 입니다.)
						<div class="msg" style="text-align: left; font-size: 8px; font: bold; color: red;"></div>
						</td>
					</tr>
					<tr>
						<th> 글내용 </th>	
						<td>
							<textarea rows="10" cols="80" name="itemContent"></textarea>
						</td>
					</tr>
				</table>
				<br>
			<div class="write_btn" align="right" >
				<input type="submit" value="등록" style="padding: 5px;"onclick="return filesizechk()">
				<input type="button" value="목록" style="padding: 5px;" onclick="location.href='/We2/cBoard/list?page=1&category=${category}'">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
		</form>
<!--  게시판 영역 끝 -->
</body>
</html>