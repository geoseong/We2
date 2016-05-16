<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 공유 게시판</title>

	<link rel="stylesheet" href="../css/w2_reset.css" type="text/css">
	<link rel="stylesheet" href="../css/board_fin.css" type="text/css">
	<link rel="stylesheet" href="../css/board_contents.css" type="text/css" >
	
	<script type="text/javascript" src="../js/jquery-1.12.1.min.js"></script> 
   
</head>

<body>
 <!-- wrap : div를 한번더 감싸고 액션의 기준이 될 수 있음-->
<div id="wrap"> 

<!-- 1. 상단 로고 부분-->
    <div id = "header">
       
    <div id = "headerinner">
        <h2>
            <b>
                <sub>
                    <a href="/We2">We2</a>
                </sub>  
            </b>
        </h2>
        
<!-- 2. 상단 메뉴 부분-->
        <div id = "nav">

            <a href="Project">프로젝트 </a>
            <a href="ItemList">커뮤니티 </a>
            <a href="/We2/pjtBoard/group/list?page=1">프로젝트공유 </a>
            <a href="List.do">스터디룸공유 &nbsp;</a>
            
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
       <b>프로젝트공유</b>
        <div id = "second_line" style="background-color:#1591BE;">
          <!-- 커뮤니티 밑 노란줄-->
       </div>
       <br>
          <a href="/We2/pjtBoard/group/list?page=1">조별과제</a><br>
          <a href="/We2/pjtBoard/exam/list?page=1">시험공부</a><br>
          <a href="/We2/pjtBoard/collabo/list?page=1">회사협업</a>
     </div> 
  
	 <!-- 게시판 include 영역 -->
	  <div id="contents">
	  	<h2>조별과제 게시판</h2>
	  	
			<jsp:include page="${Boardpage }.jsp"/>
			
	  </div>
     
</div><!-- section END -->
     
	 <!--     
		<div id="footer">
		Copyright © geoseong.com
		</div> -->
  </div>   
</body>
</html>