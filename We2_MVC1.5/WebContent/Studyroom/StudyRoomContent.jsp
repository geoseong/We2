<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="css/studyroom_content.css">



</head>
<body>
  <center>
  <H2>상세 내용</H2>
  <HR>
  </center>
  <div id = "studyroom_content">
 <form name="frm" enctype="multipart/form-data" method="post"  action="Content.do" >
 <input type="hidden" name="rcode" value="${studyroomList.rcode}" >
       <table width="200" height= "200">
	     <tr><td>
	  		<img src="upload/${studyroomList.rpictureurl}">	  
	     </td></tr>
	   </table>
 
      
	    <table>
		   <tr>		   	
		     	  <td>이름 :${studyroomList.rname}</td>
		   </tr>   
		   
		   <tr>		     
		      <td>지역 : ${studyroomList.rlocation}</td>	
		    </tr>
		    
		   <tr>		    
		      <td>종류 : ${studyroomList.rlocationdetail}</td>
		   </tr>
		   
		   <tr>	   	 
		   	  <td>인원제한 : ${studyroomList.rmember} </td>  	 
		   </tr>
		  </table>
		  
		  <table> 	   
		   <tr>  
		      <td colspan=10>
		  내용 : ${studyroomList.rcontent} </td>
		  </tr>
		  <tr>
		   <td  ><input type="button" onclick="window.close();" value="닫기">
		   </td>
		   </tr>
		 
    	  </table>
	  
	 
  </form>
  </div>
</body>
</html>