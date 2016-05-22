<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일정 수정</title>

<link rel="stylesheet" type="text/css" href="../css/schedule_window.css">
</head>
<body>

  <H2>일정 수정</H2>

 <form name="frm" method="post" action="memoUpdate.do" >
 <input type="hidden" name="calendarmemo_num" value="${calendarmemo.calendarmemo_num}" >
  
  
 <table>
  <tr>
   	<th>날짜</th>
   	<td style="text-align:left;">
   	 <input type=text name="calendarmemo_year" size=2 value="${calendarmemo.calendarmemo_year}">년 &nbsp;
   	 <input type=text name="calendarmemo_month" size=1 value="${calendarmemo.calendarmemo_month}">월 &nbsp;
   	 <input type=text name="calendarmemo_day" size=1 value="${calendarmemo.calendarmemo_day}">일
    </td>
   </tr>
   
   <tr>
    <th>내용</th>
      <td colspan=5>
       <TEXTAREA name="calendarmemo_contents" class="textarea" ROWS="8" COLS="42" > ${calendarmemo.calendarmemo_contents}</TEXTAREA>
      </td>
   </tr>
    </table>
  
  
    <div class = "button">
	    <input name="add" class="add_btn" type=submit value="수정완료" onclick="return ScheduleCheck()">
	    <input name="cancel" class="add_btn" type="reset" value="다시작성">
	    <input name="delete" class="add_btn" type="button"  value="삭제"  onclick="location.href='memoDelete.do?calendarmemo_num='+${calendarmemo.calendarmemo_num}">
    </div>

  </form>
 
  

</body>
</html>