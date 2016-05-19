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
    <H2>파일 수정</H2>
  
 <form name="frm" method="post" action="fileupdate.do"  enctype="multipart/form-data" >
   <input type="text" name="fcode" value="${fileList.fcode}" >
   <input type="hidden" name="fileurl" value="${fileList.fileurl}" >
      <table> 
 	   	<tr>  
   		   <th>파일명 </th>
   		   <td><input type="text" name="fname" size=30 value="${fileList.fname}"></td> 
   		 </tr>    
      </table>
       
      <table>
   		  <tr>
             <th>파일첨부</th>
	             <td>
	             <input type="file" name="fileurl" value="data/${fileList.fileurl}">
	             </td>		
          
		          <td style="font-size:12px; color:red;">
		             파일 용량 제한은 20MB 입니다.
		          </td>   
     </table>

		<br>
     <table>
        <tr>	  
          <td align="left" colspan=5>
 		  <input name="add" type=submit value="파일 등록">    
     	  <input name="cancel" type="reset" value="다시 작성">
          </td>
        </tr>
     </table>
   

</body>
</html>