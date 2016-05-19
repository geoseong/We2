<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/File.css">
<script type="text/javascript">

function fileDownLoad(){
    
    $('#downloadForm').submit();
    if(files==null){
        files="";
    }
    else{
        out.println("<form id='downloadForm' action='fileDownload.aj' method='post'>");
        out.println("<input type='hidden' value='"+files+"' name='fileName'>");
        out.println("</form>");
    }

}

</script>
</head>

<body>
   <input type="hidden" name="fcode" value="${fileList.fcode}" >


 <h2> 파일 다운로드 </h2>
 <form action = "fileSave.jsp" method = "post">
 
 <table border = "0" cellpadding="8" cellspacing="5">



 <td>파일첨부 : <input type="file" name="fileurl" value="${fileList.fileurl}"></td>

 
 <tr align = "center">
  <td colspan = "2"> <input type = "submit" value = "다운로드" onclick="fileDownLoad()"> </td>
 </tr>
 </table>
 </form>

</body>
</html>