<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <title>WE2_프로젝트</title>

     <link rel="stylesheet" href="css/w2_reset.css" type="text/css">
     <link rel="stylesheet" href="css/02_project.css" type="text/css">
     <link rel="stylesheet" type="text/css" href="css/board_contents.css"> 
     
     <script type="text/javascript" src="js/jquery-1.12.1.min.js"></script> 
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
                    <a href="01_main.jsp">We2</a>
                </sub>  
            </b>
        </h2>
        <h3> GEOSEONG </h3>
        
<!-- 2. 상단 로그인 부분-->
        <div id = "nav">
            <a href="#">로그아웃</a>
        </div>
    </div>
        <!--프로젝트 진행 중 부분-->
      
     <div id = "deadline"> <!--deadline아이콘-->
     
            <img src = "img/deadline.png" style="width:85px;">
      
            <div class ="state_line_0"></div>
            
            <div class ="state_line_1">
                <span> D-DAY : 14일 </span> 
            </div>
     </div>
         <!--팀원 보기 아이콘-->
         <div id = "viewfriends"><a href="#">
             <img src = "img/viewfriends.png" style="width:31px; height:31px;"></a> 
         </div>
        <!--팀원 추가 아이콘-->
         <div id = "plusfriends"><a href="#">
             <img src = "img/plusfriends.png" style="width:27px; height:27px;"></a> 
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
   
   <!-- 2) 가운데 내용 ---------------------------------->
   <div class ="contents">
   
    	<form action="ItemContent" method="post">
	
			<div id="contents">
			<span> 프로젝트 공유 </span>
			     <div class="write">			
				      <a href="ItemWrite">글쓰기</a>
				  </div>	
				
				<table class="list">
				
				  <tr style="font-size:15px; color:#1591BE;">
				  <th style="width:100px;">글번호</th> <th style="width:400px;">제목</th> <th style="width:150px;">작성자</th> <th style="width:150px;">작성일</th> <th style="width:100px;">조회수</th>
				  </tr>
				

				<!-- 반복문 : c:forEach의 items에는 배열이나 List변수가 오는 자리이다. -->
				<c:forEach var="BoardList" items="${BoardList }">	
					<tr class="record">	
						<td>${BoardList.cTeamNum }</td>
						<td><input type="submit" value="${BoardList.cTeamTitle }" name="cTeamTitle" id="cTeamTitle">
								<input type="hidden" name="cTeamNum" value="${BoardList.cTeamNum }">
								<input type="hidden" name="count" value="y">
						</td>
						<td>${BoardList.userId }</td>
						<td>${BoardList.cTeamDate }</td>
						<td>${BoardList.cTeamClick }</td>
					</tr>		
				</c:forEach>
				
				<div class="count">
				<!-- ★★ 페이징 카운트 넣는 곳 ★★ -->
				<td class="paging" colspan="5" 	>
					${pagecounting }
				</td>
				</tr>
				</div>
			</table>
			
			</div>
		</form>
			<!--  contents 영역 끝 ----------------------------------->


   </div>

  <!-- 3) 오른쪽 채팅창-->
  <div class = "chat">
      <div class="chat_title">
        
        <img src="img/G_talk_2.png"/>
        
       </div>
      <!-- 채팅창 부분은 아직... ^^;;-->
      <div class="chat_content">
          <textarea name=chat id="messageWindow" rows="10" cols="50" readonly="true">
         </textarea>
        
         <textarea name=input id="inputMessage" type="text" >
         </textarea>
           
       
        <input type="submit" value="입력" onclick="send()" style="height:44px; background-color:#1591BE;"  />
    
      </div>
      
<!--
      <fieldset>
        <textarea id="messageWindow" rows="10" cols="50" readonly="true"></textarea>
        <br/>
        <input id="inputMessage" type="text"/>
        <input type="submit" value="send" onclick="send()" />
    </fieldset>
               
-->
      
  </div>
     
</div><!-- section END -->
     
     
<div id="footer">
Copyright © geoseong.com
</div>
  </div>  
</body>
</html>