<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일 등록</title>
<link rel="stylesheet" type="text/css" href="../css/w2_reset.css">
<link rel="stylesheet" type="text/css" href="../css/studyroom_window.css">
</head>
<body>

    <H2 style="text-align:center; color:#69C5E7;">파일 등록</H2>

 <form name="frm" method="post" action="filewrite.do"  enctype="multipart/form-data" >
  
  
      <table> 
 	   	<tr>  
   		   <th>파일명 </th>
   		   <td><input type="text" name="fname" size=30></td> 
   		 </tr>    
   		  <tr>
             <th>파일첨부 </th>
             <td><input type="file" name="fileurl" style="width:150px;">
              <span style="font-size:12px; color:red;">
		             *파일 용량 제한은 20MB 입니다.
		          </span>
             </td>	
          </tr>
            
     </table>

			  
         <div class = "button">
 		  <input name="add" class="add_btn" type="submit" value="파일 등록" >    
     	  <input name="cancel" class="add_btn" type="reset" value="다시 작성">
         </div>
   
</form>
</body>
</html>