<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/w2_reset.css">
<title>Insert title here</title>
</head>
<body>
    <H2>파일 수정</H2>
  <HR>
  
 <form name="frm" method="post" action="fUpdate.do"  enctype="multipart/form-data" >
   <input type="hidden" name="fcode" value="${fileList.fcode}" >
   <input type="hidden" name="fileurl" value="${fileList.fileurl}" >
      <table> 
 	   	<tr>  
   		   <td>파일명 : </td>
   		   <td><input type="text" name="fname" size=15 value="${fileList.fname}"></td> 
   		 </tr>    
      </table>
       
      <table>
   		  <tr>
             <td>파일첨부 : <input type="file" name="fileurl" value="upload/${fileList.fileurl}"></td>		
          </tr>
          <tr>
             <td>(파일 용량 제한은 20MB 입니다.)</td>
          </tr>   
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