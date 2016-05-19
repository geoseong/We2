<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

  <H2>일정 삭제</H2>
  <HR>
 <form name="frm" method="post" action="memoDelete.do">
  <input type="hidden" name="calendarmemo_num" value="${calendarmemo.calendarmemo_num}" >
  
  
 <table>
  <tr>
   	<td>일자 : &nbsp;</td>
   	<td>
   	 <input type=text name="calendarmemo_year" size=4 value="${calendarmemo.calendarmemo_year}">년
   	 <input type=text name="calendarmemo_month" size=2 value="${calendarmemo.calendarmemo_month}">월
   	 <input type=text name="calendarmemo_day" size=2 value="${calendarmemo.calendarmemo_day}">일
    <br></td>
   </tr>
   
   <tr>
    <td align="left" valign="top">내용 <br></td></tr>
   
   <tr>  
    <td colspan=5>
     <TEXTAREA name="calendarmemo_contents" class="textarea" ROWS="8" COLS="42" >${calendarmemo.calendarmemo_contents}</TEXTAREA>
   <br> </td>
   </tr>
  
  
  
  <tr>
   <td align="center" colspan=5>
  
    <input name="delete" type=submit value="삭제하기" >
    <input name="back" type="button"   value="뒤로가기"  onclick="location.href='memoUpdate.do'+calendarmemo_num">
  
   </td>
  </tr>
  </table>
  </form>

</body>
</html>