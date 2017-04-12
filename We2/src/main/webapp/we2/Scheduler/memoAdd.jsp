<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="Error.jsp"%>
 

<html>
<head>
<meta charset="UTF-8">
<title>일정추가</title>

<!-- <link rel="stylesheet" type="text/css" href="/We2/css/w2_reset.css"> -->
<link rel="stylesheet" type="text/css" href="/We2/css/schedule_window.css">

<script type="text/javascript" src="/We2/js/Schedule.js"></script>
</head>
<body>

  <div id="wrap_s">
  
  <h2>일정 추가</h2>
  
 <form name="frm" method="post" action="memoAdd.do" >
  
 <table>
  <tr>
   	<th>날짜</th>
   	<td>
	<%
    // 파라미터 받는다. - 프로젝트코드
    int pjtcode = (Integer)request.getAttribute("pjtcode");

    %>

   	<input type="hidden" name="pjtcode" value="${pjtcode}" >
   	 <input type=text  id="calendarmemo_year" name='calendarmemo_year' value="${year}" size=4>년
   	 <input type=text  id="calendarmemo_month" name='calendarmemo_month' size=2 value="${month}">월
   	 <input type=text  id="calendarmemo_day" name='calendarmemo_day' size=2 value="${day}">일
    <br>
    </td>
   </tr>
   
   <tr>
    <th valign="top">내용 <br></th>
    <td colspan=5>
		<TEXTAREA name="calendarmemo_contents" class="textarea" ROWS="8" COLS="42"></TEXTAREA>
   <br> 
   </td>
    </tr>
   
  
  
  <tr>
   <td align="center" colspan=5>
    <input name="add" class="add_btn" type=submit value="추가" >
    <input name="cancel" class="add_btn" type="reset" value="다시작성">
   </td>
  </tr>
  </table>
  </form>
  </div> <!-- wrap_s end -->
</body>
</html>



