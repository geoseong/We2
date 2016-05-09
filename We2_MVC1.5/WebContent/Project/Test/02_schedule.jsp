<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>WE2_프로젝트</title>
    <meta charset="UTF-8"> 
     <link rel="stylesheet" href="../../css/w2_reset.css" type="text/css">
     <link rel="stylesheet" href="../../css/02_project.css" type="text/css">

     <script type="text/javascript" src="../../js/jquery-1.12.1.min.js"></script> 
</head>
    
    <script type="text/javascript">
        
    </script>
<body>
 <div id="wrap">  <!-- wrap : div를 한번더 감싸고 액션의 기준이 될 수 있음-->

<!-- 1. 상단 로고 부분-->
 <div id = "header">
       
    <div id = "headerinner">
        <h2>
            <b>
                <sub>
                    <a href="01_main.html">We2</a>
                </sub>  
            </b>
        </h2>
        <h3>프로젝트 거성</h3>
        
<!-- 2. 상단 로그인 부분-->
        <div id = "nav">
            <a href="loginForm.jsp">로그아웃</a>
        </div>
    </div>
        <!--프로젝트 진행 중 부분-->
     <div id = "ongoing"> 
            프로젝트 마감까지 &nbsp; 00일 
        </div>  
            <div class ="state_line_0">
                프로젝트 마감일 : 4월 8일 (배경흰색)
            </div>
            <div class ="state_line_1">
                <span> 마감까지 14일(파랑막대) </span> 
            </div>
     
         <!--팀원 보기 아이콘-->
         <div id = "viewfriends"><a href="#">
             <img src = "../img/viewfriends.png" style="width:31px; height:31px;"></a> 
         </div>
        <!--팀원 추가 아이콘-->
         <div id = "plusfriends"><a href="#">
             <img src = "../img/plusfriends.png" style="width:27px; height:27px;"></a> 
         </div>
     
</div><!-- header END -->
     
     
<!--3.메뉴/내용/채팅창 을 감싸는 섹션-->     
<div id = "section">
   
   <!-- 1) 왼쪽 메뉴-->
   <div class ="menu">
       
       <div class="menu_item">
           <ul>
               <li><a href="#" id="item_1">공지사항</a></li>
               <li><a href="#" id="item_2">파일공유</a></li>
               <li><a href="#" id="item_3">스케줄</a></li>
               <li><a href="#" id="item_4">할 일</a></li>
               <li><a href="#" id="item_5">프로젝트 설정</a></li>
           </ul>
       </div>
    
    </div> <!--menu div END-->
   
   <!-- 2) 가운데 내용 -->
   <div class ="contents">
    		<jsp:include page="02_project.jsp" flush="false" />
   </div>

  <!-- 3) 오른쪽 채팅창-->
  <div class = "chat">
      <div class="chat_title">
        <span> GEOSEONG TALK - 프로젝트 이름 </span>
       </div>
      <!-- 채팅창 부분은 아직... ^^;;-->
      <div class="chat_content">
         <textarea name=chat id="chat_content_view">
         </textarea>
      </div>
  </div>
      
    </div>
     
</div><!-- section END -->
     
     
<div id="footer">
Copyright © geoseong.com
</div>
  </div>  
</body>
</html>