<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="Error.jsp"%>
 

<html>
<head>
<meta charset="UTF-8">
<title>일정추가</title>
<script type="text/javascript" src="js/Schedule.js"></script>
</head>
<body>

  <div id="wrap_s">
  
  <h2>일정 추가</h2>
  
 <form name="frm" method="post" action="/We2/DateAdd.do" >
  
 <table>
  <tr>
   	<td>일자 : &nbsp;</td>
   	<td>
	<%
    // 파라미터 받는다. - 프로젝트코드
    String pjtcode = request.getParameter("pjtcode");
    System.out.println("pjtcode(caffl) : " + pjtcode);
    %>

   	<input type="hidden" name="pjtcode" value="<%=pjtcode%>">
   	 <input type=text name="calendarmemo_year" size=4>년
   	 <input type=text name="calendarmemo_month" size=2>월
   	 <input type=text name="calendarmemo_day" size=2>일
    <br></td>
   </tr>
   
   <tr>
    <td align="left" valign="top">내용 <br></td></tr>
   
   <tr>  
    <td colspan=5>
		<TEXTAREA name="calendarmemo_contents" class="textarea" ROWS="8" COLS="42"></TEXTAREA>
   <br> </td>
   </tr>
  
  
  <tr>
   <td align="center" colspan=5>
    <input name="add" type=submit value="추가" >
    
    <input name="cancel" type="reset" value="다시작성">
   </td>
  </tr>
  </table>
  </form>
  </div> <!-- wrap_s end -->
</body>
</html>



