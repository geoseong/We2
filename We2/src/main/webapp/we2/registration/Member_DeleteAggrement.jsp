<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="/style/We2_MemberStyle.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="css/w2_reset.css" type="text/css">
<link rel="stylesheet" href="css/01_1_mypageform.css" type="text/css">
<!-- 여기 까지 css 적용!! -->

<script type="text/javascript" src="/js/jquery-1.12.1.min.js"></script>
		
<script type="text/javascript">
	function chk() {
		var req = document.form.req.checked;
		var num = 0;

		if (req == true) {
			num = 1;
		}

		if (num == 1) {
			document.form.submit();
		} else {
			alert("탈퇴 정보에 동의하셔야 합니다.");
		}
	} //end delete

	function nochk() {
		alert("동의하지 않으면 탈퇴할 수 없습니다");
		return false;

	} //end nochk
</script>

	<style>
	.td{width:30px; background-color:lime;}
	</style> <!-- 약관동의 겉에 나오는 라인에 선을 넣었음 -->
	
<title>We2회원탈퇴폼</title>

</head>

<body>

<div id="wrap">  <!-- wrap : div를 한번더 감싸고 액션의 기준이 될 수 있음-->
	<form action="Member_delete" method="post" name="form">
		<!-- 주의점 js로 넘어갈때 form안에 있는 name이름을 항상주의!!! -->
		
	<!-- 1. 상단 로고 부분-->
    <div id = "header">
       
    <div id = "headerinner">
        <h2>
            <b>
                <sub>
                    <a href="/We2">We2</a>
                </sub>  
            </b>
        </h2>
        </div>
		</div><!-- header end -->
		
					
					
		<div id ="section">
					
				   <h1><span>We2 탈퇴동의</span></h1>
					<br> 
					<textarea rows="30" cols="100" readonly="readonly">  
We2 회원탈퇴에 등록합니다.
개정 2016.05.20
[제 5 장 계약해지 및 이용제한]

제 18조 (계약해지 및 이용제한)
We2 회원이 이용계약을 해지하고자 하는 때 에는 회원 본인이 온라인을 통해 당 사이트에 해지 신청을 하여야 합니다. 당 사이트는 회원이 다음 각 호의 어느 하나에 해당하는 행위를 하였을 경우 사전통지 없이 이용계약을 해지하거나 또는 기간을 정하여 서비스 이용을 중지할 수 있습니다. 

1. 타인의 서비스 아이디(ID) 및 비밀번호를 도용한 경우 

2. 서비스 운영을 고의로 방해한 경우 

3. 가입한 이름이 실명이 아닌 경우 

4. 같은 사용자가 다른 아이디(ID)로 이중등록을 한 경우 

5. 공공질서 및 미풍양속에 저해되는 내용을 고의로 유포시킨 경우 

6. 회원이 국익 또는 사회적 공익을 저해할 목적으로 서비스이용을 계획 또는 실행하는 경우 

7. 타인의 명예를 손상시키거나 불이익을 주는 행위를 한 경우 

8. 서비스의 안정적 운영을 방해할 목적으로 다량의 정보를 전송하거나 광고성 정보를 전송하는 경우 

9. 정보통신설비의 오작동이나 정보 등의 파괴를 유발시키는 컴퓨터 바이러스 프로그램 등을 유포하는 경우 

10. 다른 회원 또는 제3자의 지적재산권을 침해하는 경우 

11. 방송통신심의위원회 등 외부기관의 시정요구가 있거나 불법선거운동과 관련하여 선거관리위원회의 유권해석을 받은 경우 

12. 타인의 개인정보, 이용자아이디(ID) 및 비빌번호를 부정하게 사용하는 경우 

13. 당 사이트의 서비스 정보를 이용하여 얻은 정보를 해양수산부의 사전 승낙없이 복제 또는 유통시키거나 상업적 으로 이용하는 경우 

14. 회원이 자신의 카페와 게시판에 음란물을 게재하거나 음란사이트로 링크하는 경우 

15. 본 약관을 포함하여 기타 당 사이트가 정한 이용조건에 위반한 경우    	

[부칙]
(시행일) 이 약관은 2016년 05월 20일부터 시행합니다.
* 본 약관에 동의하지 않으면 회원가입을 하실 수 없습니다.
   </textarea> 
   <br>
   <br>
   <br> 

 	
<h2>회원탈퇴에 동의 하시면 체크해주세요!!&nbsp;&nbsp;<input type="checkbox" name="req"></h2> 	
 	
 	<div class="select">
				<input class="add_btn" type="button" value="동의합니다" onclick="return chk()" style ="width:150px;" /> 
				<input class="add_btn" type="button"value="동의하지 않습니다" onclick="return nochk()" style ="width:150px;" />
			</div>
	    </div>  <!-- section end -->
	    </form>
	</div>  <!-- wrap end -->
</body>
</html>