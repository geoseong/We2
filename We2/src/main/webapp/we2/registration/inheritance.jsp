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
	$(document).ready(function() {
		$('#pjts #pjts_op').click(function(){
		  	/* var selectbox=$('#pjts');
			var option_value = selectbox[0].value;
			alert("option_value : " + option_value); */
			var option_value= $("#pjts option:selected").val(); // val() : option:value / text() : option태그의 text
			//디버깅 : alert("pjtCode - " + option_value);
			$.ajax({
			      url : "searchpjt",
			      method : "POST",
			      data : {pjtCode : option_value}, 
			      //dataType: "JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
			      success : function(data) {
			            // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
			            //디버깅 : alert('통신성공');

			            $("#pjt").html('');
			           $("#pjt").append(data);
			            var pjtmembers = $("#pjt").text();	
			            //디버깅 : alert("#pjt : " + pjtmembers);
			            
			            var andsplit = pjtmembers.split(',');
			            $("#members").html('');
			            for ( var i in andsplit ) {
				            $("#members").append("<option value='"+ andsplit[i] +"'>"+ andsplit[i] +"</option>");
			            }
			      },
			      complete : function(data) {
			            // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
			    	  	//디버깅 : alert('통신완료 data : ' + data.status);
			      },
			      error:function(request,status,error){
			          alert("code:  "+request.status+"\n"+"message:  "+request.responseText+"\n"+"error:  "+error);
			      }
			}); //end ajax
		});
	});
	
	function popupClose(){
		inherit_form.target = opener.name;
		inherit_form.submit();
        
        if (opener != null) {
            opener.insert = null;
            self.close();
        }
	}
</script>

</head>
<body>
<form method="post" action="inheritance.do" >
	<h2>내가 방장인 프로젝트의 방장권한을 다른사람에게 인계해야 합니다.</h2>
	<div style="display: inline-block;" class="firstselect">
		<p>내가 방장인 프로젝트목록</p>
		<select id="pjts" name="pjts" size="1">
				<option>--프로젝트 선택--</option>
			<c:forEach var="projects" items="${projects }">
				<option id="pjts_op" value="${projects.pjtCode }">${projects.pjtName }</option>
			</c:forEach>
		</select>
	</div>
	<div style="margin-left: 1em; display: inline-block;" class="secondselect">
		<p>프로젝트 인원목록</p>
		<select id="members" name="members" size="1">
		</select>
	</div>
	
	<div id="pjt" style="display: none;"></div>
	
	<div style="margin-top: 1em;">${completemsg }</div>
	
	<div style="margin: 1em 0em;">
		<input type="hidden" name="userId" value="${authInfo.userId }">
		<p align="right">
		<input type="submit" value="방장권한 넘겨주기" align="right">
		</p>
	</div>
</form>


<form method="post" name="inherit_form" action="Member_delete">
<p align="right">
	<input type="submit" value="회원탈퇴" onclick="popupClose()">
</p>
</form>
</body>
</html>