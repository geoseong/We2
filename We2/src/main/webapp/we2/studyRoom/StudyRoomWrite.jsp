<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/w2_reset.css">

<title>Insert title here</title>
</head>
<body>
    <H2>위치 등록</H2>
  <HR>
 <form name="frm" method="post" action="studyroomwrite.do" enctype="multipart/form-data" >
  
 <table>
    <tr>
   	   <td> 이름 : </td>
   	   <td><input type=text name="rname" size=12></td>
   	   <td>인원제한 : </td>
   	   <td><input type="text" name="rmember" size=12 ></td> 
    </tr>  
    	 

   
    <tr>
      	<td>지역 :</td>
      	<td>
   		<select name='rlocation'  id="rlocation"  >                
                 <option selected="selected" value="서울">서울</option>
                 <option value="경기/인천">경기/인천</option>
                 <option value="경남/부산/울산">경남/부산/울산</option>
                 <option value="대구/경북">대구/경북</option>
                 <option value="광주/전라">광주/전라</option>
                 <option value="대전/세종/충청">대전/세종/충청</option>               
          </select>
    	  </td>

   	       <td>종류 :</td>
   	          <td > 
              <select name='rlocationdetail'  id="rlocationdetail"  onchange="subMenu()" >                 
                   <option selected="selected"  value="커피전문점">커피전문점</option>
                   <option value="스터디카페/스터디룸">스터디카페/스터디룸</option>
                   <option value="회의실">회의실</option>               
              </select>
             </td>
   </tr>
   </table>
   <table>
   <tr>
        <td>
        파일첨부 :
        </td>
   		<td>
   			<input type="file" name="rpictureurl"><td>(파일 용량 제한은 20MB 입니다.)</td>
   		</td>
   </tr>
   
  
   
   <tr>
    
    <td colspan=5>
		<TEXTAREA name="rcontent" class="textarea" ROWS="8" COLS="52"></TEXTAREA>	 
   <br> </td>
   </tr>
  
  
  <tr>
   <td align="center" colspan=5>
     <input name="add" type=submit value="위치 등록" onclick="return ScheduleCheck()">    
     <input name="cancel" type="reset" value="다시 작성">
   </td>
  </tr>
  </table>
  </form>
  
</body>
</html>