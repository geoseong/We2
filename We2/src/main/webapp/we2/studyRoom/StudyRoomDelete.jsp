<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/w2_reset.css">
<link rel="stylesheet" type="text/css" href="../css/studyroom_window.css">

</head>
<body>

  <H2 style="text-align:center; color:#69C5E7;">스터디룸 삭제</H2>

  
 <form name="frm" method="post" action="StudyRoomdelete.do" >
 <input type="hidden" name="rcode" value="${studyroomList.rcode}" >
  
  
 <table>
   <tr>
   	 <th> 위치명 </th>
   	  <td>
   	  	<input type="text" name="rname" size=10 value="${studyroomList.rname}">
   	  </td>  
   	  
   	 <th>인원수  </th>
   	  <td>
   	  	<input type="text" name="rmember" size=10 value="${studyroomList.rmember}">
   	  </td>  	 
     </tr>
     
  <tr>
   	<th>위 치 </th>
       <td><input type=text name="rlocation" size=10 value="${studyroomList.rlocation}">
       </td>

      <th>장 소 </th>
   	  <td><input type=text name="rlocationdetail" size=10 value="${studyroomList.rlocationdetail}">
     </td>
   </tr>
   

    <td colspan=5>
		<TEXTAREA name="rcontent" class="textarea" ROWS="8" COLS="52">${studyroomList.rcontent}</TEXTAREA>
    </td>
   </table>
  
   <div class = "button">
       <input name="delete" class="add_btn" type=submit  value="삭제하기" >
       <input name="back" class="add_btn" type="button"   value="뒤로가기"  onclick="location.href='List.do'">
  </div>
 
  </form>
</body>
</html>