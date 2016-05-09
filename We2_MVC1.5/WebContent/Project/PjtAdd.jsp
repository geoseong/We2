<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 만들기</title>
<link rel="stylesheet" type="text/css" href="css/pjt_create_style.css">

<script type="text/javascript" src="jquery/jquery-1.12.2.min.js"></script>

</head>
<body>

<form action="PjtAdd" method="post" id="make">
	<label id="lbl">원하시는 프로젝트명을 입력하세요.</label>
	<input type="text" id="pjt" name="pjt">
	
	<input type="submit" value="만들기">
<div id="result" style="margin: 10px ;height: 20px ; width: 100%; border: solid thin ;">${result }</div>
	
<script type="text/javascript">

$(function() {

		$("#make").bind("submit", function() {
			if( !$("#pjt").val()){
				alert("프로젝트명을 입력하세요.");
				return false;
			}
		});	
});

</script>
</form>

<a href="Project/index.jsp">홈으로 가기</a>
</body>
</html>