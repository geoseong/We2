<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link rel="stylesheet" type="text/css" href="css/w2_reset.css"> -->
<link rel="stylesheet" type="text/css" href="../css/studyroom_window.css">

<title>스터디룸 공유_글쓰기</title>
<script type="text/javascript" src="/We2/js/jquery-1.12.1.min.js"></script> 

<script type="text/javascript">
$(window).ready(function() {
	var file = document.frm.rpictureurl;
	$(file).change(function(){
		var filetype = file.files[0].type;
		var typeimage = filetype.indexOf('image');
		var typemultipart = filetype.indexOf('multipart/related');
		if(typeimage==0 || typemultipart==0){
		}else{
			alert('이미지파일만 올리셔야 합니다.');
		}
	});
});
	/*
	 이미지 관련 MIME타입들..
	 mht : multipart/related
	jpg : image/jpeg
	dib : image/bmp
	bmp : image/bmp
	gif : image/gif
	png : image/png
	 */
function validation(){
	
	// 유효성검사
	var rname = document.frm.rname;
	if(document.frm.rname.value.length==0){
		alert('위치명을 입력해 주세요.');
		return false;
	}
	if(document.frm.rmember.value.length==0){
		alert('인원제한을 입력해 주세요.');
		return false;
	}
	
	/* START : 인원 숫자만 입력되게 하기*/
		var rmember = document.frm.rmember;
		if(isNaN(rmember.value)){
			alert('인원제한은 숫자만 입력되어야 합니다');
			return false;
		}
	/* END : 인원 숫자만 입력되게 하기*/
	
		
	/* START : 파일타입 구별*/
		var file = document.frm.rpictureurl;
		if(file.value.trim() == ""){
			alert('스터디룸 사진 업로드 해주세요!! ㅎ.');
			return false;
		}else{
			var filetype = file.files[0].type;
			var typeimage = filetype.indexOf('image');
			var typemultipart = filetype.indexOf('multipart/related');
		}
		if(typeimage==0 || typemultipart==0){
		}else{
			alert('이미지파일만 올리셔야 합니다.');
			return false;
		}
	/* END : 파일타입 구별*/
	
	document.frm.submit();
} //end validation()
</script>
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
   			<input type="file" name="rpictureurl" > <br> 
   			
   			<span style="font-size:12px; color:red;">*파일 용량제한은 20MB 입니다.</span>
   		</td>
       </tr>
	<tr>
     <td colspan=5>
		<TEXTAREA name="rcontent" class="textarea" ROWS="8" COLS="52"></TEXTAREA> <br> 
	 </td>
	</tr>
    </table>
    
    
    <div class = "button">
       <input name="add"  class="add_btn" type="button" value="위치 등록" onclick="return validation()">    
       <input name="cancel"  class="add_btn"  type="reset" value="다시 작성">
    </div>
   
 </form>
  
</body>
</html>