<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">



</script>
<title>스터디룸 공유</title>
<link rel="stylesheet" type="text/css" href="../css/w2_reset.css">
<link rel="stylesheet" type="text/css" href="../css/shopping2.css">
<script type="text/javascript" src="../js/jquery-1.12.2.min.js"></script>

<script type="text/javascript">

  function winOpen(rcode){
	var url = "Content.do?rcode=" + rcode;
	javascript:window.open(url , '상세내용보기', 'width=500 height=700 left=150 top=100 menubar=no location=no, resizable=no, toolbar=no');
}
  
  function check() {
      if (document.frm.location.value == "지역구분") {
          alert("지역을 선택해주세요.");
          document.frm.location.focus();
          return false;
      }
      
      if (document.frm.type.value == "장소구분") {
          alert("장소를 선택해주세요.");
          document.frm.type.focus();
          return false;
      }
      document.frm.submit();
      
  }
</script>


<script type="text/javascript">
  function subMenu() {
	loc = $("select[name='location']").val();
	type = $("select[name='type']").val();   
	$('#result').innerHtml = (loc +" &gt; " + type) ; 	
	$("#eeeee").html(loc +"  > "+ type);   
}
</script>



</head>
<body>
<div id="container">
	<div class="search_controll">
		<h2 class="study_room_title"><a href="List.do">스터디룸 공유</a></h2>
		
		<form action="List.do"  method="post" name="frm">
		<ul class="study_room_menu">
			<li>
				<select name='location'' id="location" onchange="subMenu()">
				 <option value="지역구분" >지역구분</option>
				 <option value="서울" <c:if test="${'서울'==location}">selected</c:if>>서울</option>
                 <option value="경기/인천" <c:if test="${'경기/인천'==location}">selected</c:if>>경기/인천</option>
                 <option value="경남/부산/울산" <c:if test="${'경남/부산/울산'==location}">selected></c:if>>경남/부산/울산</option>
                 <option value="대구/경북" <c:if test="${'대구/경북'==location}">selected</c:if>>대구/경북</option>
                 <option value="광주/전라" <c:if test="${'광주/전라'==location}">selected</c:if>>광주/광주/전라</option>
                 <option value="대전/세종/충청" <c:if test="${'대전/세종/충청'==location}">selected</c:if>>대전/세종/충청</option> 
                	        
             </select>
			</li>
			
			<li>
				<select name='type'  id="type"  onchange="subMenu()">
                	<option value="장소구분" >장소 구분</option>
                	<option value="커피전문점" <c:if test="${'커피전문점'==type}">selected</c:if>>커피전문점</option>
                	<option value="스터디카페/스터디룸" <c:if test="${'스터디카페/스터디룸'==type}">selected</c:if>>스터디카페/스터디룸</option>
                	<option value="회의실" <c:if test="${'회의실'==type}">selected</c:if>>회의실</option>               
               </select>
			</li>
			
			<li>
				<input type="submit" value="검색"  onclick="return check() ">
				
			</li>
		</ul>
		</form>
		
		<p class="study_loc" id="result"> 
		
	  <!-- 메뉴2 시작 -->   
        
        <span id="eeeee"></span>       
        
      <!-- 메뉴2 끝 --></p>
	</div>
	
	<div class="content_wrap">
		<h2>맞춤 스터디룸<a  href="studyroomwrite.do">글쓰기</a> </h2>
		<ul class="content_list">
			<c:forEach var="roomshare"  items="${studyroomList}">
				<li>
			<a  href="javascript:winOpen('${roomshare.rcode}')">   
			 	<%-- <a href="Content.do?rcode=${roomshare.rcode}"> --%> 
					<p class="content_list_img"><img src="upload/${roomshare.rpictureurl}" ></p></a>
					<p>이름 : ${roomshare.rname}</p>
				
				   
					<p>지역 : ${roomshare.rlocation }&nbsp;&nbsp; &nbsp; 종류 : ${roomshare.rlocationdetail }</p>
					 <p>인원제한수 : ${roomshare.rmember}</p>
					<%-- <p>내용 : ${roomshare.rcontent } &nbsp;&nbsp; &nbsp;</p>--%>
					<p>
					<a  href="Update.do?rcode=${roomshare.rcode}">수정하기</a> <a href="Delete.do?rcode=${roomshare.rcode }">삭제하기</a></p>				
				</li>
			
			</c:forEach>
		</ul>
	</div>
</div>


</body>
</html>