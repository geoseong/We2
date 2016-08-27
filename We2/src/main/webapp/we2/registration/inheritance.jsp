<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery_latest_160826.js"></script>
<script type="text/javascript">
		/* var select = document.getElementById("select_id");
		var option_value = select.options[select.selectedIndex].value;
		var option_text   = select.options[select.selectedIndex].text; */
	$(document).ready(function() {
		$('#pjts #pjts_op').click(function(){
		  	var selectbox=$('#pjts');
			var option_value = selectbox[0].value;
			alert("option_value : " + option_value);
			$.ajax({
			      url : "searchpjt",
			      method : "POST",
			      data : {pjtCode : option_value}, 
			      //dataType: "text", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
			      success : function(data) {
			            // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
			            // data.length = 727
			            //$(".secondselect").html(data);
			            alert('통신성공');
			            var responsebody = new Array();
			            responsebody = data;
			            alert("리스트길이는? " + responsebody.length + ", 리스트값은? " + responsebody[0]);
			    	  	//$("#brdfilepath").html("없음");
			      },
			      complete : function(data) {
			            // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
			    	  	alert('통신완료 data : ' + data.status);
			      },
			      // error : function(xhr, status, error) {
			       //     alert("에러발생 - 파일이 안지워져요. status : " + status + ", xhr : " + xhr.value + ", error : "+ error);
			      //} 
			      error:function(request,status,error){
			          alert("code:  "+request.status+"\n"+"message:  "+request.responseText+"\n"+"error:  "+error);
			      }
			}); //end ajax
		});
	});
</script>
</head>
<body>
<h2>내가 방장인 프로젝트의 방장권한을 다른사람에게 인계해야 합니다.</h2>
<div style="display: inline-block;" class="firstselect">
	<p>내가 방장인 프로젝트목록</p>
		<select id="pjts" size="1">
			<c:forEach var="projects" items="${projects }">
			<option id="pjts_op" value="${projects.pjtCode }">${projects.pjtName }</option>
			</c:forEach>
		</select>
</div>
<div style="margin-left: 1em; display: inline-block;" class="secondselect">
	<p>프로젝트 인원목록</p>
		<select id="members" size="1">
			<c:forEach var="member" items="${pjtmember }">
			<option value="${member }">${member }</option>
			</c:forEach>
		</select>
</div>
</body>
</html>