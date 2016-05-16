<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*, com.we2.sharepjtboard.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 이미지 보기</title>

<link rel="stylesheet" type="text/css" href="..css/w2_reset.css">
<link rel="stylesheet" type="text/css" href="..css/board_modal.css">
<link rel="stylesheet" href="../css/board_fin.css" type="text/css">
<link rel="stylesheet" href="../css/board_contents.css" type="text/css" >

<script src="js/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="../js/We2_member.js"></script>
<script type="text/javascript" src="../js/board.js"></script>

<script type="text/javascript">

$(".modal_bg").hide();
$(".second_body").hide();

//그림을 클릭했을 때
$("#image").click(function(){
	$(".modal_bg").show();
	$(".second_body").show();
});

</script>


</head>
<body>
<!--1.백그라운드에 깔리는 화면페이지-->
<div class="modal_bg"></div>  <!-- 검정 화면 -->

<div class="first_main">
 	<jsp:include page="boardmain.jsp" flush="false"/>
</div>

<div class="second_body">
    <div class = "second_main">
     <c:if test="${BoardContent.getItemDataType().contains('image') }">
		<img src="/We2/we2/pjtBoard/data/${BoardContent.getItemPath() }" style="width:800px;">
     </c:if>
	</div> <!-- second_main end -->
</div> <!-- second_body -->

</body>
</html>