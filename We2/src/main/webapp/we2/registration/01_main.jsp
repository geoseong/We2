<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

   <title>We2_메인화면</title>
    <link rel="stylesheet" href="css/01_main_intro.css" type="text/css">
    <link rel="stylesheet" href="css/w2_reset.css" type="text/css">
    <link rel="stylesheet" href="css/w3_slide.css" type="text/css">

    <!-- 슬라이드 이미지를 위한 준비-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
</head>
        
<body>
   
<!-- 1. 상단 로고 부분-->
<div id = "header">
    <a href="#"><b>We2</b></a>

 <c:choose>
	 <c:when test="${empty loginUser}">

		<div id = "nav">
            <a href="login" class="loginButton">로그인</a>
            <!-- #########위에 로그인 header를 넣는다! -->
        </div>

	 </c:when>
	 
	 <c:otherwise>
	
	 	<div id = "nav2">
	 		<a href="registration/We2_mypage_confirm.jsp">마이페이지</a>
            <!-- #########위에 로그인 header를 넣는다! -->
        </div>
        
        <div id = "nav3">
            <a href="/We2/We2_logout.do">로그아웃</a>
            <!-- #########위에 로그인 header를 넣는다! -->
        </div>
	
	 </c:otherwise>
 </c:choose>

</div>
         
<!-- 2. 중간 이미지 : 부분 1(슬라이드)-->        
    <div id = "section_1">
        <div class="main_slider">
            <img src="img/index/main_01.jpg">
            <img src="img/index/main_02.jpg">
            <img src="img/index/main_03.jpg">
            <img src="img/index/main_04.jpg">
        </div>
        
        <div class="slider_control">
            <span class="btn_prev"><a href="#"><img src="img/btn-left.png" style="width:40px;"></a></span>
            <span class="btn_next"><a href="#"><img src="img/btn-right.png" style="width:40px"></a></span>
        </div>
        
          <div class ="img-txt"><b><span>Catch The Free Rider, We2</span></b></div>
          <div class ="img-txt-small"><b>
              <span> 대학생활의 최대 고민, 팀 프로젝트 
              <p>We2는 팀프로젝트에 대한 부담을 덜고 협동과 커뮤니케이션 능력을</p>
              <p>향상시킬 수 있는 팀 프로젝트의 교육적 효과를 극대화 하고자 합니다.</p>
              </b>
              </span> 
           </div>
    </div>
        
<!-- 3. 중간 메뉴 : 부분 2 (아래의 4개 박스)--> 
    <div id = "section_2">
        
        <div id="menutitle">
        <span>Menu</span> 
           
        </div>
  <!-- 3.-1 중간 메뉴의 box--> 
            <!--id: 한문서에 한번 /class:한문서에 여러번--> 
			<!-- 게시판 영역부분 -->
            <div id = "box-wrap">
                <div class = "box" style="background-color:#CE6628;">
                    <a href="02_project.html">
                        프로젝트
                    </a>
                </div>
                <div class = "box" style="background-color:#E99323;">
                    <a href="03_community_fin.html">
                        커뮤니티  
                    </a>
                </div>
                <div class = "box" style="background-color:#1591BE;">
                    <a href="03_community_fin.html">
                        프로젝트 공유
                    </a>
                </div>
                <div class = "box" style="background-color:#166BA3; ">
                    <a href="03_community_fin.html">
                        스터디룸 공유
                    </a>
                </div>
            </div>
            
        
    </div> <!--section_2 END-->


    <div id = "footer">
        Copyright © geoseong.com
    </div> 
       <script type="text/javascript" src="js/jquery-1.12.1.min.js"></script> 
    <script type="text/javascript" src="js/main_slider2.js"></script>
    
    </body>