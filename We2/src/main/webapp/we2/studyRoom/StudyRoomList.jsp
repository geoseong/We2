<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page import="com.we2.studyroom.StudyRoomBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Properties" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="com.we2.studyroom.RPagingManager" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">



</script>
<title>스터디룸 공유</title>
<link rel="stylesheet" type="text/css" href="../css/w2_reset.css">
<link rel="stylesheet" type="text/css" href="../css/shopping2.css">
<link rel="stylesheet" type="text/css" href="../css/board_fin.css" >  <!-- 게시판 틀 -->
<script type="text/javascript" src="../js/jquery-1.12.1.min.js"></script>

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
  function winOpen(rcode){ 
		var url = "StudyRoomContent.do?rcode=" + rcode;
		  javascript:window.open(url , '상세내용보기', 'width=500 height=700 left=150 top=100 menubar=no location=no, resizable=no, toolbar=no');
	  }
	  
	  function winOpen2(rcode){
		var url = "StudyRoomupdate.do?rcode=" + rcode;

	   	  javascript:window.open(url , '상세내용보기', 'width=530 height=530 left=150 top=100 menubar=no location=no, resizable=no, toolbar=no');
	  }		

  function winOpen3(rcode){
		var url = "StudyRoomdelete.do?rcode=" + rcode;
		    javascript:window.open(url , '상세내용보기', 'width=530 height=530 left=150 top=100 menubar=no location=no, resizable=no, toolbar=no');
		}


	function winOpen4(){   // 글쓰기
		var url = "studyroomwrite.do";
	     javascript:window.open(url , '상세내용보기', 'width=530 height=530 left=150 top=100 menubar=no location=no, resizable=no, toolbar=no');
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
		<h2 class="study_room_title"><a href="list?page=1">스터디룸 공유</a></h2>
		
		<form action="List?page=1"  method="post" name="frm">
		<ul class="study_room_menu">
			<li>
				<select name='location' id="location" onchange="subMenu()" style="width:350px; height:40px;">
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
				<select name='type'  id="type"  onchange="subMenu()" style="width:350px;height:40px;">
                	<option value="장소구분" >장소 구분</option>
                	<option value="커피전문점" <c:if test="${'커피전문점'==type}">selected</c:if>>커피전문점</option>
                	<option value="스터디카페/스터디룸" <c:if test="${'스터디카페/스터디룸'==type}">selected</c:if>>스터디카페/스터디룸</option>
                	<option value="회의실" <c:if test="${'회의실'==type}">selected</c:if>>회의실</option>               
               </select>
			</li>
			
			<li>
				<input type="submit" value="검색" class="add_btn" onclick="return check() " style="width:220px;height:40px;">
				
			</li>
		</ul>
		</form>
		
		<p class="study_loc" id="result"> 
		
	  <!-- 메뉴2(검색 결과값 글씨) 시작 -->   
        
        <span id="eeeee"></span>       
        
      <!-- 메뉴2 끝 --></p>
	</div>
	    
	
	  <div class="content_wrap">
		
		<ul class="content_list">
			<c:forEach var="roomshare" items="${Content}">
				<li>
			<a href="javascript:winOpen('${roomshare.rcode}')">   
			 	<%-- <a href="Content.do?rcode=${roomshare.rcode}"> --%> 
				 <p class="content_list_img">
					 <img src="data/${roomshare.rpictureurl}" >
				 </p>
			  </a>
			      <div class="detail_txt">
					 <p><b>이름 :</b> ${roomshare.rname}</p>				   
					 <p><b>지역 :</b> ${roomshare.rlocation }&nbsp;&nbsp; &nbsp; 
					    <b>종류 :</b> ${roomshare.rlocationdetail }</p>
					 <p><b>인원제한수 :</b> ${roomshare.rmember}</p>
					<%-- <p>내용 : ${roomshare.rcontent } &nbsp;&nbsp; &nbsp;</p>--%>
					<p>
					<a href="javascript:winOpen2('${roomshare.rcode}')" class="update">수정하기</a> 
					<a href="javascript:winOpen3('${roomshare.rcode}')" class="delete">삭제하기</a>
					<%-- <a  href="StudyRoomdelete.do?rcode=${roomshare.rcode}">삭제하기</a> --%> 
					<%-- <input type="submit" name="삭제하기" meaction="StudyRoomdelete.do?rcode=${roomshare.rcode }"> --%>
					</p>				
				  </div>
				</li>
			
			</c:forEach>			
		</ul>
		
	</div> <!-- content_wrap end -->
	
	
		<!-- ★★ 페이징 카운트 넣는 곳 ★★ -->
		     <div class="counting">
				<tr>
				   <div class = "write">
	                 <a href="javascript:winOpen4()" >글쓰기</a>
	                </div>
				<td colspan="6">
				<c:choose>
					<c:when test="${block-1==0 }">
					</c:when>
					<c:otherwise>
						<a href="list?page=${block_first - page_for_block }">[이전]</a>&nbsp;
					</c:otherwise>
				</c:choose>
				
				<c:forEach var="i" begin="${block_first }" end="${block_last}" >
					<c:choose>
						<c:when test="${i == c_page }">
							<b> [ ${i} ] </b>
						</c:when>
						<c:otherwise>
							<a href="list?page=${i }">
								[ ${i} ]
							</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${block==block_total }">
						&nbsp;[다음]
					</c:when>
					<c:otherwise>
						&nbsp;<a href="list?page=${block_first + page_for_block}">[다음]</a>
					</c:otherwise>
				</c:choose>
				</td>
				</tr>
				
				
				
			</div>  <!-- paging end -->
     </div> <!-- container end -->


</body>
</html>