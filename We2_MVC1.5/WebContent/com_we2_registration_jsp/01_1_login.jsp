<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인페이지</title>
<link rel="stylesheet" type="text/css" href="../css/w2_reset.css">
<link rel="stylesheet" type="text/css" href="../css/01_1_login.css">
<script src="/js/jquery-1.12.1.min.js"></script>
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
    <!--1.백그라운드에 깔리는 화면페이지-->
<div class="modal_bg"></div>
<div class="first_main">

	 	<jsp:include page="01_main.jsp" flush="false"/>
	
</div>

 <!--2.로그인 창 뜨는 부분-->
<div class="second_body">
    
  <div class="second_main">
      
          <div class = "exit">
              <a href="/We2/index.jsp"><img src ="../img/x.png" style="width:10px; height:10px;"></a>
          </div>

          <div class="input">
            <form action="/We2/We2_login.do" method="post" name="frm">  
              <div class = "id">
                  <span>Userid</span><br>
		        <input type="text" size="30" style="width:240px; height:30px;" name="userid"/> 
                  <br>
                </div>
               
                <div class = "pwd">
                    <span>Password</span>
		         <input type="password" size="30" style="width:240px; height:30px;" name="pwd"/>
                  <br>
                 </div>
              
              <div class = "lost">
              <a href="#">아이디 또는 비밀번호 분실</a>
             </div>
            
              <div class="login"> 
                  <input type="submit" value="로그인" class="add_btn" />
              </div>
              <div class="join"> 
                  <input type="button" value="회원가입" class="add_btn"onclick="location.href='We2_loginForm.jsp'";/>
              </div>
       	</form>
	   </div>
	
	
  </div>
</div>  <!--second_body_END-->

</body>
</html>