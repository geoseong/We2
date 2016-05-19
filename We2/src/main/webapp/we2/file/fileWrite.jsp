<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/w2_reset.css">
</head>
<body>

    <H2>파일 등록</H2>
  <HR>
 <form name="frm" method="post" action="filewrite.do"  enctype="multipart/form-data" >
  
  
      <table> 
 	   	<tr>  
   		   <td>파일명 : </td>
   		   <td><input type="text" name="fname" size=15></td> 
   		 </tr>    
   		  <tr>
             <td>파일첨부 : </td>
             <td><input type="file" name="fileurl"></td>	
          </tr>
          <tr>
             <td colspan="2">(파일 용량 제한은 20MB 입니다.)</td>
          </tr>   
     </table>

		<br>
     <table>
        <tr>	  
          <td align="left" colspan=5>
 		  <input name="add" type="submit" value="파일 등록" >    
     	  <input name="cancel" type="reset" value="다시 작성">
          </td>
        </tr>
     </table>
   
</form>
</body>
</html>