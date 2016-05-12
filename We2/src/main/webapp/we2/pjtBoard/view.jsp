<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 공유 게시판</title>
</head>
<body>

<p>게시번호 : ${Content.itemNum }</p>
<p>타이틀 : ${Content.itemTitle }</p>
<p>회원ID : ${Content.userId }</p>
<p>글쓴날짜 : ${Content.itemDate }</p>
<p>조회수 : ${Content.itemHit }</p>
<p>내용 : ${Content.itemContent }</p>

</body>
</html>