<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project_left</title>

<link rel="stylesheet" type="text/css" href="css/pjt_left_style.css">

<style type="text/css">
#button li #active {
        border-left: 10px solid #1c64d1;
        border-right: 10px solid #5ba3e0;
        background-color: #2586d7;
        color: #fff;
}
</style>
</head>

<body>
<div id="button">
	<ul>
		<!-- CSS Tabs -->		
		<li><a id="notice" href="We2_page?page=pjt_notice&pjtname=${pjt}">공지사항</a></li>
		<li><a id="todo" href="We2_page?page=pjt_todo&pjtname=${pjt}">할 일 리스트</a></li>
		<li><a id="schedule" href="We2_page?page=pjt_schedule&pjtname=${pjt}">스케쥴</a></li>
		<li><a id="data" href="We2_page?page=pjt_data&pjtname=${pjt}">자료실</a></li>
		<li><a id="share" href="We2_page?page=pjt_share&pjtname=${pjt}">공유하기</a></li>
	</ul>
</div>
</body>

</html>