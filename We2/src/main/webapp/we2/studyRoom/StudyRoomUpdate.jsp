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

  <H2 style="text-align:center; color:#69C5E7;">스터디룸 수정</H2>

  
  
 <form name="frm" enctype="multipart/form-data" method="post"  action="StudyRoomupdate.do" >
 <input type="hidden" name="rcode" value="${studyroomList.rcode}" >

  
 <table>
   <tr>
   	 <th> 위치명 </th>
   	  <td>
   	  	<input type="text" name="rname" size=10 value="${studyroomList.rname}">
   	  </td>  
   	  
   	 <th>인원제한  </th>
   	  <td>
   	  	<input type="text" name="rmember" size=10 value="${studyroomList.rmember}">
   	  </td>  	 
     </tr>
   
   <tr>
   	<th>종류 </th>
   		   <td> 
               <select name='rlocationdetail'  id="rlocationdetail" style="float:left; height:30px;" >                
                 <option selected="selected" value="커피전문점">커피전문점</option>
                 <option value="스터디카페/스터디룸">스터디카페/스터디룸</option>
                 <option value="회의실">회의실</option>               
               </select>
             </td>
   	<th>지역 </th>
   	   	<td>
   		<select name='rlocation'  id="rlocation"  style="float:left; height:30px;">                                  
                	<option selected="selected" value="서울">서울</option>
                	<option value="경기/인천">경기/인천</option>
                	<option value="경남/부산/울산">경남/부산/울산</option>
                	<option value="대구/경북">대구/경북</option>
                	<option value="광주/전라">광주/전라</option>
                	<option value="대전/세종/충청">대전/세종/충청</option>                     
             </select>
    	</td>
    </tr>
    
            <tr>
         <td colspan=5 >
   		    <p class="content_list_img">
			 
			</p>
   			<input type="file" name="rpictureurl" value="${studyroomList.rpictureurl}" style="text-align:center;">
  			<span style="font-size:12px; color:red;">*파일 용량제한은 20MB 입니다.</span>
   		   </td>
       </tr>
   
 
    <td colspan=5>
		<TEXTAREA name="rcontent" class="textarea" ROWS="8" COLS="52">${studyroomList.rcontent}</TEXTAREA>
	
    </td>
   </table>
  
  
 
   <div class = "button">
    <input name="add" class="add_btn" type=submit value="위치 수정" onclick="return ScheduleCheck()"> 
    <input name="cancel" class="add_btn" type="reset" value="다시 작성">
   </div>
 
  <!-- <tr>
   <td align="center" colspan=5>
    <input name="add" type=submit value="위치 수정">
    
    <input name="cancel" type="reset" value="다시 작성">
   </td>
  </tr>
  </table> -->
  </form>
</body>
</html>