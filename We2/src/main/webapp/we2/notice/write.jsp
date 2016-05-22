<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=uft-8">
<title>글쓰기 게시판</title>

<script type="text/javascript" src="js/jquery-1.12.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/w2_reset.css">
<link rel="stylesheet" type="text/css" href="../css/notice.css">
</head>

<script type="text/javascript">
	function writeCheck() {

		var form = document.writeform;

		if (!form.title.value) {
			alert("제목을 적어주세요");
			form.title.focus();
			return;
		}

		if (!form.writer.value) {
			alert("이름을 적어주세요");
			form.writer.focus();
			return;
		}

/* 		if (!form.pass.value) {
			alert("비밀번호 적어주세요");
			form.pass.focus();
			return;
		} */

		if (!form.content.value) {
			alert("내용을 적어주세요");
			form.contetn.focus();
			return;
		}

		form.submit();
	}
</script>

<body>

<div id="container">	
	<div id="content_wrap">
	    	<h2>공지사항</h2>
	    	
			<form name="writeform" method="post" action="write" >
							<table>
							<tr>
								<th align="center">제목</th>
								<td style="text-align:left;"><input name="title" size="70" maxlength="100"></td>
							</tr>
							
							<tr>
								<th align="center">이름</th>
								<td style="text-align:left;"><input name="writer" size="30" maxlength="100"></td>
							</tr>
<!-- 							
							
							<tr>
								<th align="center">비밀번호</th>
								<td><input type="password" name="pass" size="30"
									maxlength="100"></td>
							</tr>
						 -->
						
							<tr>
								<th align="center">내용</th>
								<td style="text-align:left;"><textarea name="content" cols="110" rows="13"></textarea></td>
							</tr>
							</table>
							
							 <div class="c_btn">
							   <input class="add_btn" type="button" value="쓰기" onclick="javascript:writeCheck()"> 
					           <input class="add_btn" type="button" value="목록" onClick="location.href='/We2/notice/list';">
							 </div>
						
			   </form>
		   
	</div> <!--content_wrap end -->
</div>
</body>
</html>

