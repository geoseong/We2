<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일정 삭제</title>

<link rel="stylesheet" type="text/css" href="../css/schedule_window.css">
</head>
<body>

  <H2>일정 삭제</H2>

 <form action="memoDelete.do" method="POST" name="frm">
  <input type="hidden" name="calendarmemo_num" value="${calendarmemo.calendarmemo_num}" >
  
 <table>
  <tr>
   	<th>날짜</th>
   	<td>
   	 <input type=text name="calendarmemo_year" size=2 value="${calendarmemo.calendarmemo_year}">년 &nbsp;
   	 <input type=text name="calendarmemo_month" size=1 value="${calendarmemo.calendarmemo_month}">월 &nbsp;
   	 <input type=text name="calendarmemo_day" size=1 value="${calendarmemo.calendarmemo_day}">일
    </td>
   </tr>
   
   <tr>
     <th>내용</th>
       <td colspan=5>
     <TEXTAREA name="calendarmemo_contents" class="textarea" ROWS="8" COLS="42" >${calendarmemo.calendarmemo_contents}</TEXTAREA>
    </td>
   </tr>
   </table>
  

   <div class = "button">
    <input name="delete" class="add_btn" type="submit" value="삭제하기" >
   </div>
  
  </form>

</body>
</html>