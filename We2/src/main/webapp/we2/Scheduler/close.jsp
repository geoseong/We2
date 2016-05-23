<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


</head>
<c:choose>
	<c:when test="${msg.toString().contains('글쓰기가') || msg.toString().contains('수정') || msg.toString().contains('삭제') }">
		<script type='text/javascript'>
			alert('${msg}');
			opener.location.reload(); 
			self.close();
		</script>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>
		<c:set scope="request" var="alert" value="${false }"/>
		
<script type="text/javascript" src="/We2/js/jquery-1.12.1.min.js"></script>
<body>

<!-- <script type="text/javascript">
function cclose(){
	
	alert("요청이 완료되었습니다.");
	opener.location.reload(); 
	self.close();
}

</script> -->
</body>
</html>