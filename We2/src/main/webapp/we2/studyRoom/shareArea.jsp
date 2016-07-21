<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>WE2_스터디룸 공유</title>
    <meta charset="UTF-8"> 
     <link rel="stylesheet" href="../css/w2_reset.css" type="text/css">
     <link rel="stylesheet" href="../css/board_fin.css" type="text/css">
     <script type="text/javascript" src="js/jquery-1.12.1.min.js"></script> 
</head>
<body>

 <div id="wrap">  <!-- wrap : div를 한번더 감싸고 액션의 기준이 될 수 있음-->

<!-- 1. 상단 로고 부분-->
  <!-- 1. 상단 로고 부분-->
    <div id = "header">
       
    <div id = "headerinner">
        <h2 style="top:26px;">
            <b>
                <a href="/We2">We2</a> 
            </b>
        </h2>
        
<!-- 2. 상단 메뉴 부분-->
        <div id = "nav">

            <a href="../Member_Mypage">프로젝트 </a>
            <a href="../cBoard/list?page=1&category=cFindwork">커뮤니티 </a>
            <a href="../pjtBoard/list?page=1&category=pGroup">프로젝트공유 </a>
            <a href="../studyroom/list?page=1">스터디룸공유 &nbsp;</a>
            
            <!-- 로그인 되어있으면 로그인만 표시, 안되어있으면 로그아웃만 표시. -->
            <c:choose>
			 	<c:when test="${empty authInfo}">
			            <a href="/We2/login">로그인</a>
				 </c:when>
				 <c:otherwise>
			            <a href="/We2/logout">로그아웃</a>
				 </c:otherwise>
			 </c:choose>
			 
        </div>
    </div>
         </div><!-- header END -->
     
<!--3.가운데 메뉴 + 내용-->     
<div id = "section">
   <div id="menu">
       <b>스터디룸 공유</b>
        <!-- 게시판 타이틀 밑의 선-->
        <div id = "second_line" style="background-color:#166BA3;" >
       
       </div>

     </div> 
  
  <div id="contents">
 	<jsp:include page="${studyroompage }.jsp"/> 
  </div>
     
</div><!-- section END -->
     
     
<!-- <div id="footer">
Copyright © geoseong.com
</div> -->
 </div>  
</body>
</html>