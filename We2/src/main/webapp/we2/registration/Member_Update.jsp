<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/w2_reset.css" type="text/css">
<link rel="stylesheet" href="css/01_1_mypageform.css" type="text/css">

<script src="js/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="js/We2_member.js"></script>
<script type="text/javascript">
	
</script>
<title><spring:message code="member.info" /></title>
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
					<b> <sub> <a href="index.jsp">We2</a> <!-- 원래 페이지로 돌아감 -->
					</sub>
					</b>
				</h2>

				<!-- 2. 상단 메뉴 부분-->
				<div id="nav">
					<!-- div처음 숫자 4 개 -->
					<a href="#">프로젝트 </a> <a href="#">커뮤니티 </a> <a href="#">프로젝트공유
					</a> <a href="#">스터디룸공유 &nbsp;</a> <a href="#">로그아웃</a>
				</div>
				<!-- div처음 숫자 4 개 끝 -->
			</div>
			<!-- div처음 숫자 3개 끝 -->
		</div>
		<!-- header END -->
		<!-- div처음 숫자 2개 끝 -->
		<!-- 3. 가운데 회원가입 부분 -->

		<div id="section">

			<div id="menu">

				<b>MyPage</b>
				<div id="second_line"></div>

			</div>
			<!-- menu END -->


			<div id="contents">

				<div class="my_registration">


					<!-- 회원정보 -->
					<spring:message code="member.info" />
					<form:form action="Member_Update" commandName="member"
						method="POST">

						<!-- 회원정보 상세 내용을 감싸는 div -->
						<table>
							<tr>
								<th><spring:message code="name" /></th>
								<td><form:input path="name" /> <form:errors path="name" />
								<td>
							</tr>
							<tr>
								<th><spring:message code="userId" /></th>
								<td><form:input path="userId" /></td>
								<form:errors path="userId" />
							</tr>
							<tr>
								<th><spring:message code="pwd" /></th>
								<td><form:input path="pwd" /></td>
								<form:errors path="pwd" />
							</tr>
							<tr>
								<th><spring:message code="pwd.confirm" /></th>
								<td><form:input path="pwd_confirm" /></td>
								<form:errors path="pwd_confirm" />
							</tr>
							<tr>
								<th><spring:message code="phone" /></th>
								<td><form:password path="phone" /></td>
								<form:errors path="phone" />
							</tr>
							<tr>
								<th><spring:message code="email" /></th>
								<td><form:password path="email" /></td>
								<form:errors path="email" />
							</tr>
							<tr>
								<th><spring:message code="gender" /></th>
								<td><input type="radio" class="radio" name="gender"
									value="0" checked="checked">남성 <input type="radio"
									class="radio" name="gender" value="1">여성</td>
							</tr>
						</table>
						<!-- table end -->
						<!-- 회원수정버튼 -->
						<input type="submit" value="확인" onclick="return joincheck()">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="reset" value="취소">
					</form:form>
				</div>
				<!-- my_registration end -->
			</div>
			<!-- contents end -->
		</div>
		<!-- section end -->
	</div>
	<!-- wrap EDN -->
</body>
</html>