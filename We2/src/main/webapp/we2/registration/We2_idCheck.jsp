<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원관리</title>
<script type="text/javascript" src="js/We2_member.js"></script>
<style>


h2{
   margin-bottom:20px;
   color: #4CC4EE;   
   font-size:25px;
   font-weight:800;
   text-align: center;
}

.id {
  font-size:16px;
}

form {
text-align:center;
color:#424444;
}


/* 중복체크 버튼 */
#add_btn{
   border:none;
   background:#d3d3d3;
   color:#424444;
    font-weight:400;
    font-size:13px;
   width:80px;
   height:29px;
   
   
}

#add_btn:hover{
    background-color: black;
    opacity:0.3;
}

/* 사용 버튼 */
#add_btn_1 {
   border:none;
   margin-top:10px;
   background:#4CC4EE;
   color:#fff;
    font-weight:600;
    font-size:15px;
   width:100px;
   height:35px;
   border-radius:5px;
}

#add_btn_1:hover{
    background-color: black;
    opacity:0.3;
}


</style>



</head>
<body>
   <h2>아이디 중복확인</h2>
   
   <div id = "check"></div>
   <form action="We2_idCheck" method="get" name="frm">
     <span style="font-size: 16px;">아이디</span>
        <input type="text" class="id" name="userId" style="height:24px;"> 
        <input type="submit" id="add_btn" value="중복 체크"> <br><br>
      <c:if test="${result == 1}">
         <script type="text/javascript">
            opener.document.frm.userId.value = "";
         </script>
            *${userId}는 이미 사용 중인 아이디입니다.
      </c:if>            
               
        <c:if test="${result == -1}">
            *${userId}는 사용가능한 아이디입니다. <br>
         	<input type="button" value="사용하기" id="add_btn_1" class="cancel" onclick="idOk('${userId}')">
         </c:if>
    </form>

  </body>
</html>