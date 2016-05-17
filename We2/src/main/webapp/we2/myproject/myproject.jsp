<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <title>WE2_프로젝트</title>

     <link rel="stylesheet" href="../css/w2_reset.css" type="text/css">
     <link rel="stylesheet" href="../css/02_project.css" type="text/css">
     <link rel="stylesheet" type="text/css" href="../css/notice_board_contents.css"> 
     <link rel="stylesheet" type="text/css" href="../css/File.css">
     
     <script type="text/javascript" src="../js/jquery-1.12.1.min.js"></script> 

 <script>
var myVar = setInterval(myTimer, 5000);
function myTimer(){
   $(".state_line_1").animate({width:"+=80"});
}
</script> 
</head>
    
<body>
 <div id="wrap">  <!-- wrap : div를 한번더 감싸고 액션의 기준이 될 수 있음-->

<!-- 1. 상단 로고 부분-->
 <div id = "header">
       
    <div id = "headerinner">
        <h2>
            <b>
                <sub>
                    <a href="Project/02_project.jsp">We2</a>
                </sub>  
            </b>
        </h2>
        <h3>${project.pjtName } </h3>
        
<!-- 2. 상단 로그인 부분-->
        <div id = "nav">
            <a href="#">로그아웃</a>
        </div>
    </div>
        <!--프로젝트 진행 중 부분-->
      
     <div id = "deadline"> <!--deadline아이콘-->
     
            <img src = "/We2/img/deadline.png" style = "width:85px; height:45px;">
      
            <div class ="state_line_0"></div>
            
            <div class ="state_line_1">
                <span> D-14</span> 
            </div>
     </div>
         <!--팀원 보기 아이콘-->
         <div id = "viewfriends"><a href="#">
             <img src = "/We2/img/viewfriends.png" style="width:31px; height:31px;"></a> 
         </div>
        <!--팀원 추가 아이콘-->
         <div id = "plusfriends"><a href="#">
             <img src = "/We2/img/plusfriends.png" style="width:27px; height:27px;"></a> 
         </div>
     
</div><!-- header END -->
     
     
<!--3.메뉴/내용/채팅창 을 감싸는 섹션-->     
<div id = "section">
   
   <!-- 1) 왼쪽 메뉴-->
   <div class ="menu">
       
       <div class="menu_item">
           <ul>
               <li><a href="/We2/Notice.do?list=/notice/list.jsp&pjtcode=${project.pjtCode }" id="item_1">공지사항</a></li>
               <li><a href="/We2/fList.do?File=/File/FileList.jsp&pjtcode=${project.pjtCode }" id="item_2">파일공유</a></li>
               <li><a href="/We2/DateSchedule?&pjtcode=${project.pjtCode }" id="item_3">스케줄</a></li>
           </ul>
       </div>
    
    </div> <!--menu div END-->
   
   <!-- 2) 가운데 내용 ---------------------------------->
   <div class ="contents">

    	<jsp:include page=".jsp"></jsp:include>
			<!--  contents 영역 끝 ----------------------------------->
   </div>
  <!-- 3) 오른쪽 채팅창-->
  <div class = "chat">
      <div class="chat_title">
      	<img src="img/G_talk_2.png"/>
      </div>
     
        <%-- <jsp:include page="${page }.jsp"></jsp:include> --%>

      
  </div>
     
</div><!-- section END -->
     
 <!--     
<div id="footer">
Copyright © geoseong.com
</div> -->
  </div>  
</body>

<script>
$(".state_line_1").click(function(){
	clearInterval(myVar);
});
</script>


</html>