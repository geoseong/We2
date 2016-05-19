<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<link rel="stylesheet" type="text/css" href="css/studyroom_content.css">
<link rel="stylesheet" type="text/css" href="css/w2_reset.css">
<link rel="stylesheet" type="text/css" href="../css/studyroom_window.css">



</head>
<body>

  <H2 style="text-align:center; color:#69C5E7;">상세 내용</H2>


  <div id = "studyroom_content">
  <form name="frm" enctype="multipart/form-data" method="get"  action="StudyRoomContent.do" >
  <input type="hidden" name="rcode" value="${studyroomList.rcode}" >
  
       <table>
	     <tr>
	       <td>
	  		<img src="/we2/studyRoom/data/${studyroomList.rpictureurl}">	  
	        </td>
	     </tr>
	   </table>
 
      
	    <table style= "line-height:25px;">
		   <tr>		
		      <th>
		        이름
		      </th>   	
		      <td> ${studyroomList.rname}</td>
		   </tr>   
		   
		   <tr>	
		      <th>
		        지역
		      </th> 
		      <td>${studyroomList.rlocation}</td>	
		    </tr>
		    
		    <tr>
		      <th>
		        종류
		      </th> 		    
		      <td>${studyroomList.rlocationdetail}</td>
		   </tr>
		   
		   <tr>
		      <th>
		        인원제한
		      </th>	   	 
		   	  <td>${studyroomList.rmember} </td>  	 
		   </tr>
		</table>
		  
		<table>   
		   <tr>  
		      <th>
		        내용
		      </th>
		     <td colspan=10>${studyroomList.rcontent} </td>
		  </tr>
	     </table>
		  
		  
		   <div class = "button">
		   <input type="button" class="add_btn" onclick="window.close();" value="닫기">
		   </div>

  </form>
  </div>
</body>
</html>