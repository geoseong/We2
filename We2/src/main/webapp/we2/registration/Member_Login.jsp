<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인페이지</title>
<link rel="stylesheet" type="text/css" href="css/w2_reset.css">
<link rel="stylesheet" type="text/css" href="css/01_1_login.css">

<script src="js/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="js/We2_member.js"></script>

<script type="text/javascript">

$(".modal_bg").hide();
$(".second_body").hide();

//로그인을 클릭했을 때
$("#nav>a").click(function(){
	$(".modal_bg").show();
	$(".second_body").show();
});

</script>
</head>    
<body>

<%
	if(request.getParameter("logon") !=null){	
		%>
			<script>
				alert('로그인이 필요한 메뉴입니다.');
			</script>
		<%
	}
%>

<!--1.백그라운드에 깔리는 화면페이지-->
<div id="modal_bg"></div>



<div class="first_main">
 	<jsp:include page="../index.jsp" flush="false"/>
</div>


 <!--2.로그인 창 뜨는 부분-->
<div class="second_body">
    
  <div class="second_main">
      
          <div class = "exit">
              <a href="/We2"><img src ="img/index/x.png" style="width:10px; height:10px;"></a>
          </div>

          <div class="input">
          
            <form:form action="login" commandName="loginCommand" name="frm" method="POST">
            	<input type="hidden" name="pjtadd" value="${pjtadd }">
              <div class = "id">
                <span>User ID</span><br>
                <form:input path="userId" style="width:240px; height:30px;"/>
                <span class ="error" ><form:errors path="userId"/></span>
                  <br>
             </div>
               
              <div class = "pwd">
                 <span>Password</span>
                 <form:password path="pwd" style="width:240px; height:30px;"/>
                  <span class="error"><form:errors path="pwd"/></span>
                  <br>
              </div>
             
             <p align="right">
             	<div class = "remember">
             		<spring:message code="rememberUserid"/>
             		<form:checkbox path="rememberUserid"/>
             	</div>
             </p>
             
             <div class = "lost">
              <a href="/We2/lost">아이디/비밀번호 찾기</a>
             </div>
            
              <div class="login"> 
                  <input type="submit" value="로그인" class="add_btn" />
              </div>
              <div class="join"> 
                  <input type="button" value="회원가입" class="add_btn"onclick="location.href='join'";/>
              </div>
            </form:form> 
	   </div>
	
	
  </div>
</div>  <!--second_body_END-->

</body>
</html>