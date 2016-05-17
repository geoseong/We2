<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <H2>파일 삭제</H2>
  <HR>
  
 <form name="frm" method="post" action="fDelete.do"  >
     <input type="hidden" name="fcode" value="${fileList.fcode}" >
  
      <table> 
 	   	<tr>  
   		   <td>파일명 : </td>
   		   <td><input type="text" name="fname" size=15 value="${fileList.fcode}"></td> 
   		 </tr>    
      </table>
       
 

		<br>
     <table>
        <tr>	  
          <td align="left" colspan=5>
 		  <input name="add" type=submit value="삭제하기" >    
     	  <input name="cancel"  type="button"  value="취소" onclick="window.close()">
          </td>
        </tr>
     </table>
   
</body>
</html>