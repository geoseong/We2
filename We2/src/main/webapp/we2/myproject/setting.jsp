<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 설정</title>

     <link rel="stylesheet" type="text/css" href="/We2/css/setting.css"> 
<script type="text/javascript">

	function winOpen(email){
		var url = "invitation?email="+email;
		var mailvalue=document.pjtfrm.useremail.value;
		if(mailvalue.length==0){
			alert("이메일주소는 입력되어야 합니다.");
			return false;
		}
		javascript:window.open(url , '프로젝트 멤버초대.', 'width=600 height=270 left=150 top=100 menubar=no location=no, resizable=no, toolbar=no');
		return true;
	}

</script>     

</head>
<body>
  
   <h2 style="float:left;">프로젝트 정보</h2>
   
    <div class = "pjt_info">
    
      <table>
	       <tr>
	         <th>프로젝트 이름 </th>
	         	<td>&nbsp;&nbsp;&nbsp;${pjtInfo.pjtName }</td>
	       </tr>
	       
	       <tr>
	      	 <th>시작일 </th>
	      	 	<td>&nbsp;&nbsp;&nbsp;${pjtInfo.startDate }</td>
	       </tr>
	      
	       <tr>
	     	 <th>마감일 </th>
	      	 	<td>&nbsp;&nbsp;&nbsp;${pjtInfo.endDate }</td>
	       </tr>
	       
	       <tr>
	      	 <th>팀원 </th>
	      		 <td>
	      		 &nbsp;&nbsp;&nbsp;
					<c:forEach var="pjtmem" items="${pjtmem }" varStatus="status">
						${pjtmem }<c:if test="${not status.last}">, </c:if>
					</c:forEach>
				</td>
	       </tr>
      </table>
   
    </div> <!-- pjt_info end -->
   
   
<c:if test="${isleader eq 'Y' }">
   <h2 style="float:left;">팀원 관리</h2>
   
  	 <div class = "pjt_team">
   
      	<table>
       
	       <tr>
		       <th>팀원 추가 </th>
		       <td  colspan="3">
		       <form name="pjtfrm">
		       		<input type="email" size="45" name="useremail" id="email_bg" style="width:75%; height:25px; float:left;">  		       	
		       	    <input type="button" class="add_btn" value="회원검색..." size="20" onclick="return winOpen(document.pjtfrm.useremail.value)">
		       </form>
		       </td>
	       </tr>
	       
          <tr> 	   
      		<th rowspan="4">팀원 강퇴 </th>
		        <td style="border:0;">
			        <img src="../img/people_m1.png" class="ppl_1" style="width:70px;">
					 <form action="" style="border-bottom:0; border-left:0;">
					    <input type="checkbox" class="check" name="team_member" value="Bike">박태성
					 </form>
		        </td>
        
		        <td style="border:0;">
			        <img src="../img/people_m2.png" class="ppl_1" style="width:70px;">
					 <form action="">
					     <input type="checkbox" class="check"name="team_member" value="Bike">정준영
				     </form>
		        </td>
		        
		        <!-- 팀원강퇴하기 버튼 -->
		        <td rowspan="4" style="width:8%; vertical-align:bottom; padding-right:20px; border-left:0;">
	        	<input type="submit" class="add_btn" value="팀원강퇴" size="20" >
	            </td>
		        
        </tr>
        
		<tr>
            <td style="border:0;">
		        <img src="../img/people_w3.png" class="ppl_1" style="width:70px;">
			    <form action="">
			       	<input type="checkbox" class="check"name="team_member" value="Bike">전주영
			     </form>
	        </td>
        
	        <td style="border:0;">
		        <img src="../img/people_m3.png" class="ppl_1" style="width:70px;">
			    <form action="">
			      <input type="checkbox" class="check" name="team_member" value="Bike">박상혁
		        </form>
	        </td>
        
       </tr>
       
        <tr>
            <td style="border:0;" >
		        <img src="../img/people_m5.png" class="ppl_1" style="width:70px;">
			    <form action="">
			       	<input type="checkbox" class="check" name="team_member" value="Bike">박규민
			     </form>
	        </td>
        
	        <td style="border:0;">
		       <!--  <img src="../img/people_m6.png" class="ppl_1" style="width:70px;">
			    <form action="">
			      <input type="checkbox"  class="check" name="team_member" value="Bike">김동한
		        </form> -->
	        </td>   
       </tr>
        
   </table>
   
   </div> <!-- pjt_team end -->
  </c:if>
   
   <h2>프로젝트 기간 수정</h2>
 
      <div id = "pjt_time">
      
	      <div class="imageArea">               
		   		<img src="/We2/img/index/calendar.png" class="img1" style="width:50px;">          
		   		<img src="/We2/img/index/calendar.png" class="img2" style="width:50px;">	
		   </div>
       
	        <div class="time">   
		   		<input type="text" size="7" name="term1" id="term1" style="height:25px;">               
	           		 <span> ~ </span>            
	            <input type="text" size="7" name="endDate" id="term2" style="height:25px;"> 
	            
	            <input type="submit" class="add_btn" value="수정하기" size="20" style="margin-right:5px;" >                             
	        </div>
     </div>  
     <!-- pjt_time end -->

</body>

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
 
 
// 이메일 입력 관련 부분 
$(function() {
    //포커스가 들어온 경우 배경 이미지 제거
	 $("#email_bg").focus(function(){
		 $(this).css("background-image","none");
	 });
    
    // 포커스가 빠져나간 경우
    $("#email_bg").blur(function() {
      //입력값이 있다면?
       if($(this).val()) {
    	 $(this).css("background-image","none");
    	}else{
    	 $(this).css("background-image","url(../img/input_email.png)");
    }
  });
});
	
 
 </script>

</html>