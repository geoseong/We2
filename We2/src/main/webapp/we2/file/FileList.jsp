<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일 리스트</title>
<link rel="stylesheet" type="text/css" href="../css/w2_reset.css">
<link rel="stylesheet" type="text/css" href="../css/File.css">
<script type="text/javascript">

function winOpen(fcode){
	var url = "filewrite.do";
	  javascript:window.open(url , '상세내용보기', 'width=480 height=300 left=150 top=100 menubar=no location=no, resizable=no, toolbar=no');
  }
  
  function winOpen2(fcode){
	var url = "fileupdate.do?fcode=" + fcode;
   	  javascript:window.open(url , '파일수정', 'width=530 height=300 left=150 top=100 menubar=no location=no, resizable=no, toolbar=no');
  }		
  
function winOpen3(fcode){
	var url = "filedelete.do?fcode=" + fcode;
     javascript:window.open(url , '파일삭제', 'width=480 height=300 left=150 top=100 menubar=no location=no, resizable=no, toolbar=no');
}

</script>
</head>

<body>
<div id="container">		
	
	<div class="content_wrap">
		<h2>파일 공유 </h2>
		<a  href="javascript:winOpen('${file.fcode}')" class="write"> 글쓰기</a>
		
		
		<table class="content_list">
	   			
	   			<tr class="Listtr">
		   		 	    <th id="filenum" >번호</th>
		   		 	    <th id="userId" >글쓴이</th>
		   			    <th id="filename">파일명</th>	  
		   			    <th id="filedate">날짜</th>	  
		   				<th id="filedownload">다운로드</th>
		   				<th id="fileupdate">수정</th>
		   				<th id="filedelete">삭제</th>
		   		</tr>		
		   		
				<c:forEach var="file"   items="${fileList}">																
					<tr class="Listtr">
						<td> ${file.fcode} </td>
						<td> ${file.userId} </td>
						<td> ${file.fname} </td>
						<td> ${file.fdate} </td>
					  	<td align="center">
							<a href="/We2/we2/file/data/${file.fileurl}"  download>${file.fileurl}</a>
									<!--OLD: onClick="window.open(this.href, '다운로드', 'width=400, height=430'); return false;"  -->
						</td>
						<td align="center">
							<a  href="javascript:winOpen2('${file.fcode}')">수정</a>
						</td>
						
						<td align="center">
							<a  href="javascript:winOpen3('${file.fcode}')">삭제</a>
							
						</td>		   														
					</tr>										
				</c:forEach>	 			
			</table>
			
			<!-- ★★ 페이징 카운트 넣는 곳 ★★ -->
				<div class ="counting" align="center">
				<br>
				<c:choose>
					<c:when test="${block-1==0 }">
					</c:when>
					<c:otherwise>
						<a href="list?page=${block_first - page_for_block }&category=${category}">[이전]</a>&nbsp;
					</c:otherwise>
				</c:choose>
				<c:forEach var="i" begin="${block_first }" end="${block_last}" >
					<c:choose>
						<c:when test="${i == c_page }">
							<b> [ ${i} ] </b>
						</c:when>
						<c:otherwise>
							<a href="list?page=${i }&category=${category}">
								[ ${i} ]
							</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${block==block_total }">
					</c:when>
					<c:otherwise>
						&nbsp;<a href="list?page=${block_first + page_for_block}&category=${category}">[다음]</a>
					</c:otherwise>
				</c:choose>
				</div>  
				<!-- ★★ counting end ★★ -->
				
	</div>
	
</div>
	


</body>
</html>