<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

   <title>We2_메인화면</title>
    <link rel="stylesheet" href="/We2/css/01_main_intro.css" type="text/css">
    <link rel="stylesheet" href="/We2/css/w2_reset.css" type="text/css">
    <link rel="stylesheet" href="/We2/css/w3_slide.css" type="text/css">
<link rel="stylesheet" type="text/css" href="/We2/css/02_1_pjtMake.css">

    <!-- 슬라이드 이미지를 위한 준비-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <style>
      .modal_bg{
         display:none;
      }
      .pjtMakeInner{
         display:none;
      }
      
      element.style{
      width : 270px;
      }
      #ui-datepicker-div{
		width:300px;
      }
    
   </style>
   <%
	if(request.getAttribute("test") != null){
		%>
			<script>
				alert("프로젝트 생성이 완료되었습니다.");
			</script>
		<%
	}
	if(request.getAttribute("outout") != null){
		%>
			<script>
				alert("로그아웃 되었습니다.");
			</script>
		<%
	}
%>
</head>
        
<body>
<c:choose>
	<c:when test="${empty msg }">
	</c:when>
	<c:otherwise>
		<script type='text/javascript'>
			alert('${msg}');
		</script>
	</c:otherwise>
</c:choose>
		<c:set scope="request" var="alert" value="${false }"/>
		
		<a style="text-decoration: none;"></a>
<!-- '프로젝트 만들기' 메뉴의 모달창 영역 -->
<div class="modal_bg" >
<table cellpadding='3px'></table>
</div>

<div id = "bigwrap">  <!-- 화면 디자인 틀을 잡아주는 id -->

<!-- 1. 상단 로고 부분-->
<div id = "header">
    <a href="/We2"><b>We2</b></a>

 <c:choose>
    <c:when test="${empty authInfo}">

		   <div id = "nav">
            <a href="login" class="loginButton">로그인</a><!-- A태그를 사용하면 get으로 넘어간다.!! -->
            <!-- #########위에 로그인 header를 넣는다! -->
          </div>
	 </c:when>
	 
	 <c:otherwise>
	
	 	<div id = "nav2">
	 		<a href="/We2/Member_Mypage">마이페이지</a>
            <!-- #########위에 로그인 header를 넣는다! -->
         </div>
        <div id = "nav3">
            <a href="/We2/logout">로그아웃</a>
            <!-- #########위에 로그인 header를 넣는다! -->
        </div>
	   </c:otherwise>
	   
 </c:choose>

</div>
         
<!-- 2. 중간 이미지 : 부분 1(슬라이드)-->        
     <div id = "section">  <!--  중간 전체를 감싸는 틀 -->
      
      <div id = "slider">
    
        <div class="main_slider">
            <img src="/We2/img/index/main_1.jpg">
            <img src="/We2/img/index/main_2.jpg">
            <img src="/We2/img/index/main_3.jpg">
            <img src="/We2/img/index/main_4.jpg">
        </div>
        
        <div class="slider_control">
            <span class="btn_prev"><a href="#"><img src="/We2/img/index/btn-left.png" style="width:40px;"></a></span>
            <span class="btn_next"><a href="#"><img src="/We2/img/index/btn-right.png" style="width:40px"></a></span>
        </div>
        
          <div class ="img-txt"><b><span>Catch The Free Rider, We2</span></b></div>
          <div class ="img-txt-small" style="font: bold; font-size: 14px">          		
            대학생활의 최대 고민, 팀 프로젝트<br>
            We2는 팀프로젝트에 대한 부담을 덜고 협동과 커뮤니케이션 능력을<br>
			향상시킬 수 있는 팀 프로젝트의 교육적 효과를 극대화 하고자 합니다.<br>        
          </div>
    </div>
        
<!-- 3. 중간 메뉴 : 부분 2 (아래의 4개 박스)--> 
    <div id = "menu">
    
  <!-- 3.-1 중간 메뉴의 box--> 
            <!--id: 한문서에 한번 /class:한문서에 여러번--> 
         <!-- 게시판 영역부분 -->
            <div id = "box-wrap">
                <div class = "box" style="background-color:#CE6628;">  <!-- 프로젝트 만들기 -->
                    <a class="makeButton">
                         <img src = "/We2/img/index/icon_01.png" style="width:200px"> 
                    </a>
                </div>
                <div class = "box" style="background-color:#E99323;"> <!-- 커뮤니티 -->
                    <a href="cBoard/list?page=1&category=cFindwork">
                       <img src = "/We2/img/index/icon_02.png" style="width:200px">   
                    </a>
                </div>
                <div class = "box" style="background-color:#1591BE;"> <!-- 프로젝트 공유 -->
                    <a href="pjtBoard/list?page=1&category=pGroup">
                      <img src = "/We2/img/index/icon_03.png" style="width:200px"> 
                    </a>
                </div>
                <div class = "box" style="background-color:#166BA3; "> <!-- 스터디룸 공유 -->
                    <a href="studyroom/list?page=1">
                      <img src = "/We2/img/index/icon_04.png" style="width:200px"> 
                    </a>
                </div>
            </div>  <!--box-wrap END-->
            
         </div>  <!--menu_END-->
        
    </div> <!--section END-->


    <div id = "footer">
        Copyright © geoseong.com
    </div> 
    
  </div><!--big wrap END-->  
  
    <script type="text/javascript" src="/We2/js/jquery-1.12.1.min.js"></script> 
    <!-- <script type="text/javascript" src="/We2/js/main_slider2.js"></script> -->
    
   
   <div class="pjtMake">   
        <form method="post" action="pjtMake">   
           <div class="pjtMakeInner">
                <h1 style="margin-top:20px;">프로젝트 만들기</h1>
                
                <img src="/We2/img/index/x.png" id="exit2" style="width:10px;" >
                 
                <div class="frame">
                  <div class="nameArea">
                     <label for="pjtName">프로젝트 이름</label>
                     <input type="text" size="25" name="pjtName" id="pjtName" style="height:25px;"> 
                  </div>
                  
                  <div class="classifyArea">
                     <label for="pjtClassify">프로젝트 분류</label>
                     <select name="pjtClassify" >
                        <option>조별과제</option>
                        <option>스터디</option>
                        <option>회사협업</option>
                     </select> 
                  </div>
                  
                  <div class="imageArea">      
                     <label for="pjtTerm">프로젝트 기간</label>
	   					<img src="/We2/img/index/calendar.png" class="img1" style="width:50px;">
	   					<img src="/We2/img/index/calendar.png" class="img2" style="width:50px;">		
	   					<input type="text" size="7" name="startDate" id="term1" style="height:25px;">
                        <span> &nbsp;~ </span>
                    	<input type="text" size="7" name="endDate" id="term2" style="height:25px;">                          
                  </div>
                  
                  
               
                  <!-- <div class="inviteArea">
                     <label for="pjtInvite">프로젝트 초대</label>
                     준비 중입니다.
                      <input type="text" size="26" name="invite" style="height:25px;">
                        <div class="btn1">
                      <input type="button" value="초대하기" size="50" onclick="invitemember()">
                      </div>
                  </div> 
                   -->
                  <div class="btn2" style="padding-top:30px;">
                      <input type="submit" value="만들기" size="100">
                  </div>
                </div>
         </div> <!--pjtMakeinner END-->
         
        </form>
       
   </div>


     
 
    </body>
<!-- <script src="js/jquery-1.12.2.min.js"></script> -->
<!-- jQuery UI CSS파일  -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<!--  jQuery 기본 js파일 -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<!--  jQuery UI 라이브러리 js파일 -->
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script type="text/javascript"> 
$("#term1").datepicker({  
   changeMonth: true, 
    changeYear: true,
    nextText: '다음 달',
    prevText: '이전 달' 
    });
$("#term2").datepicker({  
   changeMonth: true, 
    changeYear: true,
    nextText: '다음 달',
//     prevText: '이전 달' 
    });
    
$(".modal_bg").hide();
$(".pjtMakeInner").hide();

   $(".makeButton").click(function(){
      
      $(".pjtMakeInner").attr("display","block");
      $(".modal_bg").attr("display","block");   
      $(".pjtMakeInner").show();
      $(".modal_bg").show();   
   });
   
   $("#exit2").click(function(){
      
      $(".pjtMakeInner").attr("display","none");
      $(".modal_bg").attr("display","none");   
      $(".modal_bg").hide();
      $(".pjtMakeInner").hide();
   
   });
    
</script>

    <script type="text/javascript" src="/We2/js/main_slider2.js"></script>
    
    <script type="text/javascript">
       
     function invitemember(){
        
         if (document.frm.userId.value == "") {
            alert('아이디를 입력하여 주십시오.');
            frm.userId.focus();
            return;
         }
         var url = "We2_idCheck?userId=" + document.frm.userId.value;
         window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
     }
   </script>
</head>

</html>