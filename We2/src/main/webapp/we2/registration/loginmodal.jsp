<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인모달</title>
</head>
<body>

<div class="modal">
    
  <div class="second_main">
      
          <div class = "exit">
              <a href="/We2"><img src ="img/index/x.png" style="width:10px; height:10px;"></a>
          </div>

          <div class="input">
            <form:form action="login" commandName="loginCommand" name="frm">
              <div class = "id">
                <span>User ID</span><br>
                <form:input path="userid" style="width:240px; height:30px;"/>
                <span id="error" style="color: gray; font-size: 7px;"><form:errors path="userid"/></span>
                  <br>
             </div>
               
              <div class = "pwd">
                 <span>Password</span>
                 <form:password path="pwd" style="width:240px; height:30px;"/>
                  <span class="error"><form:errors path="pwd"/></span>
                  <br>
              </div>
             
             <p align="right">
             	<label>
             		<spring:message code="rememberUserid"/>
             		<form:checkbox path="rememberUserid"/>
             	</label>
             </p>
              
             <div class = "lost">
              <a href="#">아이디 또는 비밀번호 분실</a>
             </div>
            
              <div class="login"> 
                  <input type="submit" value="로그인" class="add_btn" />
              </div>
              <div class="join"> 
                  <input type="button" value="회원가입" class="add_btn"onclick="location.href='We2_loginForm.jsp'";/>
              </div>
            </form:form> 
	   </div>
	
	
  </div>
</div>  <!--second_body_END-->

</body>
<script src="js/jquery-1.12.1.min.js"></script>
</html>