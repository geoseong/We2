<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <title>WE2_프로젝트</title>

     <link rel="stylesheet" href="/We2/css/w2_reset.css" type="text/css">
     <link rel="stylesheet" href="/We2/css/02_project.css" type="text/css">
    <!-- 규민c 공지사항 css : 
    	해당 기능이 이 공통으로 사용되는 jsp페이지에 포함되면 다른 메뉴의 css와 충돌 일어나서 
    	해당 기능 jsp에다가 css를 넣어 놓음 
     <link rel="stylesheet" type="text/css" href="../css/notice_board_contents.css">  -->
    <!-- 동한c 자료실 css : 
    	해당 기능이 이 공통으로 사용되는 jsp페이지에 포함되면 다른 메뉴의 css와 충돌 일어나서 
    	해당 기능 jsp에다가 css를 넣어 놓음 
     <link rel="stylesheet" type="text/css" href="../css/File.css"> -->
     
     <script type="text/javascript" src="/We2/js/jquery-1.12.1.min.js"></script> 

 <script>
 
var myVar = setInterval(myTimer, 1000*60*60*24);

 <% Object day = session.getAttribute("day");
 %>
 
	function myTimer(){
	  if($(".state_line_1").width()<1032){
 		$(".state_line_1").animate({width:"+="+1032/<%= day %>});
	 }
} 

</script> 
</head>
    
<body>
 <div id="wrap">  <!-- wrap : div를 한번더 감싸고 액션의 기준이 될 수 있음-->

<!-- 1. 상단 로고 부분-->
 <div id = "header">
    <div id = "headerinner">
        <h1>
            <b>
                <sub>
                    <a href="/We2">We2</a>
                </sub>  
            </b>
        </h1>
        <h3>${project.pjtName} </h3>
        
<!-- 2. 상단 로그인 부분-->
        <div id = "nav">
            <a href="/We2/logout">로그아웃</a>
        </div>
    </div>
        <!--프로젝트 진행 중 부분-->
      
     <div id = "deadline"> <!--deadline아이콘-->
     
            <img src = "/We2/img/project/deadline.png" style = "width:85px; height:45px;">
            <div class ="state_line_0"></div>
            <div class ="state_line_1">
                <span> <%=day%>일</span> <!-- 이 부분 session에 담았으니  이리로 넘어오는 컨트롤러에서 빈에 담아줘야 하-->
            </div>
     </div>
         <!--팀원 보기 아이콘-->
         <!-- <div id = "viewfriends"><a href="#">
             <img src = "/We2/img/project/viewfriends.png" style="width:31px; height:31px;"></a> 
         </div>
        팀원 추가 아이콘
         <div id = "plusfriends"><a href="#">
             <img src = "/We2/img/project/plusfriends.png" style="width:27px; height:27px;"></a> 
         </div> -->
     
</div><!-- header END -->
     
     
<!--3.메뉴/내용/채팅창 을 감싸는 섹션-->     
<div id = "section">
   
   <!-- 1) 왼쪽 메뉴-->
   <div class ="menu">
       
       <div class="menu_item">
           <ul>
               <li><a href="/We2/notice/list" id="item_1">공지사항</a></li>
               <li><a href="/We2/file/list?page=1" id="item_2">파일공유</a></li>
               <li><a href="/We2/scheduler/list" id="item_3">스케줄</a></li>
               <li><a href="/We2/willwork/list" id="item_4">할 일</a></li>
               <li><a href="/We2/project/setting" id="item_5">프로젝트 정보</a></li>
           </ul>
       </div>
    
    </div> <!--menu div END-->
   
   <!-- 2) 가운데 내용 ---------------------------------->
   
   <%String willwork = request.getParameter("willwork"); %>
   <div class ="contents">
    	<jsp:include page="${page}.jsp" flush="false"></jsp:include>
   </div>
			<!--  contents 영역 끝 ----------------------------------->
   
  <!-- 3) 오른쪽 채팅창-->
  <div class = "chat">
      <div class="chat_title">
      	<!-- <img src="/We2/img/G_talk_3.png"/> -->
      </div>
     
        <jsp:include page="broadcast.jsp"></jsp:include> 

      
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