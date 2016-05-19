<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/w2_reset.css">
<link rel="stylesheet" type="text/css" href="../css/studyroom_window.css">

<title>스터디룸 공유_글쓰기</title>
</head>
<body>
    <H2 style="text-align:center; color:#69C5E7;">스터디룸 등록</H2>

 <form name="frm" method="post" action="studyroomwrite.do" enctype="multipart/form-data" >
  
 <table>
    <tr>
   	   <th> 이름 </th>
   	   <td><input type=text name="rname" size=15></td>
   	   <th>인원제한 </th>
   	   <td><input type="text" name="rmember" size=15 ></td> 
    </tr>  

    <tr>
      	<th>지역 </th>
      	<td> 
   		<select name='rlocation'  id="rlocation" style="float:left; height:30px;" >                
                 <option selected="selected" value="서울">서울</option>
                 <option value="경기/인천">경기/인천</option>
                 <option value="경남/부산/울산">경남/부산/울산</option>
                 <option value="대구/경북">대구/경북</option>
                 <option value="광주/전라">광주/전라</option>
                 <option value="대전/세종/충청">대전/세종/충청</option>               
          </select>
    	  </td>

   	       <th>종류 </th>
   	          <td> 
              <select name='rlocationdetail'  id="rlocationdetail"  onchange="subMenu()" style="float:left; height:30px;">                 
                   <option selected="selected"  value="커피전문점">커피전문점</option>
                   <option value="스터디카페/스터디룸">스터디카페/스터디룸</option>
                   <option value="회의실">회의실</option>               
              </select>
             </td>
         </tr>
  
   
      <tr> 
        <th>
        파일첨부 
        </th>
   		<td colspan=4 >
   			<input type="file" name="rpictureurl"> <br> 
   			
   			<span style="font-size:12px; color:red;">*파일 용량제한은 20MB 입니다.</span>
   		</td>
       </tr>

     <td colspan=5>
		<TEXTAREA name="rcontent" class="textarea" ROWS="8" COLS="52"></TEXTAREA> <br> 
	 </td>
    </table>
    
    
    <div class = "button">
       <input name="add"  class="add_btn" type=submit value="위치 등록" onclick="return ScheduleCheck()">    
       <input name="cancel"  class="add_btn"  type="reset" value="다시 작성">
    </div>
   
  </form>
  
</body>
</html>