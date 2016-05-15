<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/w2_reset.css" type="text/css">
<link rel="stylesheet" href="css/01_1_mypage.css" type="text/css">
<link rel="stylesheet" href="css/01_1_mypage.css" type="text/css">

<script src="js/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="js/We2_member.js"></script>
<script type="text/javascript">
</script>
<title>
<spring:message code="member.register"/></title>
</head>
<body>
	<div id="wrap">
		<!-- div 처음 숫자 1개 -->
		<!-- wrap : div를 한번더 감싸고 액션의 기준이 될 수 있음-->
		<!-- 1. 상단 로고 부분-->
		<div id="header">
			<!-- div처음 숫자 2 개 -->

			<div id="headerinner">
				<!-- div처음 숫자 3 개 -->
				<h2>
					<b> <sub> <a href="index.jsp">We2</a>
						<!-- 원래 페이지로 돌아감 -->
					</sub>
					</b>
				</h2>

				<!-- 2. 상단 메뉴 부분-->
				<div id="nav">
					<!-- div처음 숫자 4 개 -->
					<a href="#">프로젝트 </a> <a href="#">커뮤니티 </a> <a
						href="#">프로젝트공유 </a> <a href="#">스터디룸공유 &nbsp;</a> <a href="#">로그아웃</a>
				</div>
				<!-- div처음 숫자 4 개 끝 -->
			</div>
			<!-- div처음 숫자 3개 끝 -->
		</div>
		<!-- header END -->
		<!-- div처음 숫자 2개 끝 -->
		<!-- 3. 가운데 회원가입 부분 -->
		<div id="section">
			<!-- div처음 숫자 5 개 -->
			<div id="menu">
				<!-- div처음 숫자 6 개 -->
				<!-- 회원가입 인사말 -->
				<div id="second_line">
					<!-- div처음 숫자 7 개 -->
				</div>
				<!-- div처음 숫자 7 개 끝 -->
			</div>
			<!-- menu END -->
			<!-- div처음 숫자  6개 -->

			
			<div class="my_registration">
			
			<h2><spring:message code="member.info"/></h2>
			<form:form action="Member_Join" name="frm" method="post" commandName="registerRequest">
			
			<p>
			<label><spring:message code="name"/>:<br>
			:<form:input path="name"/>		
			<form:errors path="name"/>	
			</label> 
			</p>
			
			<p>
			<label><spring:message code="userId"/>:<br>
			:<form:input path="userId"/>		
			<form:errors path="userId"/>
			<input type="button" value="중복 체크" onclick="idCheck()">	
			</label> 
			</p>
			
			<p>
			<label><spring:message code="pwd"/>:<br>
			:<form:input path="pwd" id="byteInfo" name="pwd" size="20" onkeyup="checkLength(this, 12)"/>		
			<form:errors path="pwd"/>	
			</label> 
			</p>
			
			<p>
			<label><spring:message code="pwd.confirm"/>:<br>
			:<form:input path="pwd_confirm"/>		
			<form:errors path="pwd_confirm"/>	
			</label> 
			</p>
			
			<p>
			<label><spring:message code="phone"/>:<br>
			:<form:input path="phone"/>		
			<form:errors path="phone"/>	
			</label> 
			</p>
			
			<p>
			<label><spring:message code="email"/>:<br>
			:<form:input path="email"/>		
			<form:errors path="email"/>	
			</label> 
			</p>
			
			<p>
			<label><spring:message code="gender"/>:<br>
			<input type="radio" name="gender" value="0" checked="checked">남성 
			<input type="radio" name="gender" value="1">여성	
			</label> 
			</p>
			
			<input type="submit" value="<spring:message code="register.btn"/>">
			
			 </div> 
			</form:form>
		</div>
		</div>
</body>
</html>