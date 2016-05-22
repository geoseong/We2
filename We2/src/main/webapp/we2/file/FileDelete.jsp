<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/w2_reset.css">
<link rel="stylesheet" type="text/css" href="../css/studyroom_window.css">
<title>Insert title here</title>
</head>
<body>
    <H2 style="text-align:center; color:#69C5E7;">파일 삭제</H2>
  
 <form name="frm" method="post" action="filedelete.do?fcode=${fileList.fcode}"  >
     <input type="hidden" name="fcode" value="${fileList.fcode}" >
  
      <table> 
 	   	<tr>  
   		   <th>파일명</th>
   		   <td><input type="text" name="fname" size=30 value="${fileList.fname}"></td> 
   		 <tr>
   		    <th>첨부파일</th>
   		   <td> <img src=""value="${fileList.fcode}"> </td> 
   		 </tr>    
      </table>

      <div class = "button">
 		  <input name="add" class="add_btn" type=submit value="삭제하기" >    
     	  <input name="cancel"  class="add_btn" type="button"  value="취소" onclick="window.close()">
      </div>    
   
</body>
</html>