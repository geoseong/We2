<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 만들기</title>
<link rel="stylesheet" type="text/css" href="css/w2_reset.css">
<link rel="stylesheet" type="text/css" href="css/02_1_pjtMake.css">

<script type="text/javascript">

function pjtmessage(){
	alert("점검중입니다. (~04/08)");
}
</script>
</head>
<body>
   <div class="pjtMake">   
   	  <form method="post" action="test" >	
          
   	     <div class="pjtMakeInner">
                <h1>프로젝트 만들기</h1>
             
                <div class="frame">
	   				<div class="nameArea">
	   					<label for="pjtName">프로젝트 이름</label>
	   					<input type="text" size="26" name="pjtName" id="pjtName" style="height:25px;"> 
	   				</div>
	   				
	   				<div class="classifyArea">
	   					<label for="pjtClassify">프로젝트 분류</label>
	   					<select name="classify" style="height:25px;" >
	   						<option>조별과제</option>
	   						<option>스터디</option>
	   						<option>회사협업</option>
	   					</select> 
	   				</div>
	   				
	   				<div class="imageArea">		
	   					<label for="pjtTerm">프로젝트 기간</label>
                        
	   					<img src="img/calendar.png" class="img1" style="width:50px;">
                        
	   					<img src="img/calendar.png" class="img2" style="width:50px;">		
	   					<input type="text" size="7" name="term1" id="term1" style="height:25px;">
                        
                        <span> ~ </span>
                        
	   					<input type="text" size="7" name="term2" id="term2" style="height:25px;"> 			                
	   				</div>
	   				
	   				<div class="btn2">
	   				 	<input type="submit" value="만들기" size="100">
	   				</div>
                
                </div>
         </div> <!--pjtMakeinner END-->
   		
        </form>
       
   </div>
</body>
<script src="js/jquery-1.12.2.min.js"></script>
<!-- jQuery UI CSS파일  -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<!--  jQuery 기본 js파일 -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<!--  jQuery UI 라이브러리 js파일 -->
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script> 
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
    prevText: '이전 달' 
    });
    
function inviteuser() {
	if (document.frm.userid.value == "") {
		alert('아이디를 입력하여 주십시오.');
		frm.userid.focus();
		return;
	}
	window.open("pjtuseradd.jsp", "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}
</script>
</html>










