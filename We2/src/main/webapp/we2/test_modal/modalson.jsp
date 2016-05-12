<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Modal Son</title>

<script type="text/javascript">
/*
자식창에서 페이지 이동이 있을경우 새창으로 열리는 경우가 있습니다.
이럴 경우에는 submit하는 함수 전에 
document.addrform.target = 'selfWin';
window.name = 'selfWin';
소스를 추가하고, 
body태그 안에 있는 form 태그에 onsubmit="return false;"를 추가하면 자식창 내부에서 페이지 이동이 이루어집니다.
*/
	
	//페이지 이동
	function  goLink(){
		document.addrform.action = '../registration/login.jsp';
		
		document.addrform.target = 'selfWin';
		window.name = 'selfWin';
		
		document.addrform.submit();
		document.addrform.action = ''; 
	}
	
	//창 닫기
	function closeModal(){
		window.returnValue='ok';
		window.close();
	}
</script>

</head>
<body>

<form name="addrform" id="addform" action="" method="post" onsubmit="return false;">
	<input type="button" name="btn" value="페이지 이동" onclick="JavaScript:goLink();"> 
		<br />
	<A href="javascript: closeModal();">창닫기</A> 
</form>


</body>
</html>