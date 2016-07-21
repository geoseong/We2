<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=uft-8">
<title>글쓰기 게시판</title>

<script type="text/javascript" src="/We2/js/jquery-1.12.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="/We2/css/w2_reset.css">
<link rel="stylesheet" type="text/css" href="/We2/css/notice.css">
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
							<table style="width: 30%">
							<tr>
								<th align="center">제목</th>
								<td style="text-align:left;"><input name="title"  maxlength="100" size="100%"></td>
							</tr>
							
							<tr>
								<th align="center">이름</th>
								<td style="text-align:left;">
									<input type="hidden" name="writer" value="${authInfo.userId }">
									${authInfo.userId }
								</td>
							</tr>
						
							<tr>
								<th align="center">내용</th>
								<td style="text-align:left;"><textarea name="content" cols="100%" rows="13"></textarea></td>
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

