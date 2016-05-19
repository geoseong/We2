<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

  <H2>일정 수정</H2>
 
  
  
 <form name="frm" method="post" action="memoUpdate.do" >
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
     <TEXTAREA name="calendarmemo_contents" class="textarea" ROWS="8" COLS="42" > ${calendarmemo.calendarmemo_contents}</TEXTAREA>
   <br> </td>
   </tr>
  
  
  
  <tr>
   <td align="center" colspan=5>
    <input name="add" type=submit value="수정완료" onclick="return ScheduleCheck()">
    <input name="cancel" type="reset" value="다시작성">
    <input name="delete" type="button"  value="삭제"  onclick="location.href='memoDelete.do?calendarmemo_num='+${calendarmemo.calendarmemo_num}">
   
   </td>
  </tr>
  </table>
  </form>
 
  

</body>
</html>