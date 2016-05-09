<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=uft-8">
<title>글쓰기 게시판</title>

<script type="text/javascript" src="js/jquery-1.12.1.min.js"></script>
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

		if (!form.pass.value) {
			alert("비밀번호 적어주세요");
			form.pass.focus();
			return;
		}

		if (!form.content.value) {
			alert("내용을 적어주세요");
			form.contetn.focus();
			return;
		}

		form.submit();
	}
</script>

<body>


	<div id="wrap_content">
	
		<table>
			<form name="writeform" method="post" action="notice/write_ok.jsp" >
				
						
						<table>
							
							<tr>
								<th align="center">제목</th>
								<td><input name="title" size="70" maxlength="100"></td>
							</tr>
							
							<tr>
								<th align="center">이름</th>
								<td><input name="writer" size="30" maxlength="100"></td>
							</tr>
							
							
							<tr>
								<th align="center">비밀번호</th>
								<td><input type="password" name="pass" size="30"
									maxlength="100"></td>
							</tr>
						
						
							<tr>
								<th align="center">내용</th>
								<td><textarea name="content" cols="120" rows="13"></textarea></td>
							</tr>
							</table>
							 <div class="c_btn">
							 <input class="add_btn" type="button" value="쓰기" onclick="javascript:writeCheck()"> 
					         <input class="add_btn" type="button" value="목록" onClick="location.href='/We2/Notice.do?list=../notice/list.jsp';">
							 </div>
						
			   </form>
		   </table>
	</div> <!-- wrap content end -->
</body>
</html>

