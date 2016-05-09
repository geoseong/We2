<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>

     <link rel="stylesheet" href="css/w2_reset.css" type="text/css">
     <link rel="stylesheet" href="css/board_fin.css" type="text/css">
	<link rel="stylesheet" type="text/css" href="css/board_contents.css">
	 
     <script type="text/javascript" src="js/jquery-1.12.1.min.js"></script> 
     
</head>
<body>
<div id="wrap">  <!-- wrap : div를 한번더 감싸고 액션의 기준이 될 수 있음-->

<!-- 1. 상단 로고 부분-->
    <div id = "header">
       
    <div id = "headerinner">
        <h2>
            <b>
                <sub>
                    <a href="index.jsp">We2</a>
                </sub>  
            </b>
        </h2>
        
<!-- 2. 상단 메뉴 부분-->
        <div id = "nav">

            <a href="Project">프로젝트 </a>
            <a href="ItemList">커뮤니티 </a>
            <a href="ShareList">프로젝트공유 </a>
            <a href="List.do">스터디룸공유 &nbsp;</a>
            
            <c:choose>
			 	<c:when test="${empty loginUser}">
		
			            <a href="com_we2_registration_jsp/01_1_login.jsp">로그인</a>
			            <!-- #########위에 로그인 header를 넣는다! -->
			        
				 </c:when>
				 <c:otherwise>
				
			            <a href="We2_logout.do">로그아웃</a>
			            <!-- #########위에 로그인 header를 넣는다! -->
			       
				 </c:otherwise>
			 </c:choose>
        </div>
    </div>
         </div><!-- header END -->
     
<!--3.가운데 메뉴 + 내용-->     
<div id = "section">
   <div id="menu">
       <b>Project공유</b>
        <div id = "second_line">
          <!-- 커뮤니티 밑 노란줄-->
       </div>
       <br>
          <a href="ShareList?page=group">조별과제</a><br>
          <a href="ShareList?page=exam">시험공부</a><br>
          <a href="ShareList?page=collabo">회사협업</a>
     </div> 
  
 <!-- 게시판 include 영역 -->
  <div id="contents">
  	<h1>시험공부 게시판</h1>
	<jsp:include page="${Boardpage }"/>
  </div>
     
</div><!-- section END -->
     
     
<!-- 	<div id="footer">
	Copyright © geoseong.com
	</div> -->
  </div>   
</body>
</html>