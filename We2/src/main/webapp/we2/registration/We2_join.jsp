<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>회원 관리</title>
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
					<b> <sub> <a href="01_main.html">We2</a>
					</sub>
					</b>
				</h2>

				<!-- 2. 상단 메뉴 부분-->
				<div id="nav">
					<!-- div처음 숫자 4 개 -->
					<a href="02_project.html">프로젝트 </a> <a href="#">커뮤니티 </a> <a
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
				<b>We2 회원가입 페이지</b>

				<!-- 회원가입 인사말 -->
				<div id="second_line">
					<!-- div처음 숫자 7 개 -->
					<br>안녕하세요<br> <span>We2회원가입을 위해 <br>우측의 정보를
						기입해주세요!!
					</span>
				</div>
				<!-- div처음 숫자 7 개 끝 -->
			</div>
			<!-- menu END -->
			<!-- div처음 숫자  6개 -->
		
			
			<form action="We2_join" name="frm" method="post" >
			
				<h1>
						<span> We2 회원 가입</span>
					</h1>
					<br> '*'표시 항목은 필수 입력 항목입니다.
				<div class="my_registration">
				<table>
					<tr>
						<td>이름</td>
						<td><input type="text" name="name" id="byteInfo" size="20"
							onkeyup="checkLength_1(this, 10)">*</td>
					</tr>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="userid" id="byteInfo" size="20"
							onkeyup="checkLength(this, 12)">* <input type="hidden"
							name="reid" size="20"> <input type="button" value="중복 체크"
							onclick="idCheck()"></td>
					</tr>
					<tr>
						<td>암 호</td>
						<td><input type="password" id="byteInfo" name="pwd" size="20"
							onkeyup="checkLength(this, 12)">*</td>
					</tr>
					<tr height="30">
						<td width="80">암호확인</td>
						<td><input type="password" name="pwd_check" size="20">*</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="text" name="email" size="20"></td>
					</tr>
					<tr>
						<td>보조 이메일</td>
						<td><input type="text" name="sub_email" size="20"></td>
					<tr>
						<td>전화번호</td>
						<td><input type="text" name="phone" size="20"></td>
					</tr>
					<tr>
						<td>성별</td>
						<td><input type="radio" name="gender" value="0"
							checked="checked">남성 <input type="radio" name="gender"
							value="1">여성</td>
					</tr>
				</div>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="확인" onclick="return joinCheck()">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="취소">
						</td>
					</tr>
					<tr>
						<td colspan="2">${message}</td>
					</tr>
				</table>					
				</form>
			</div>
</body>
</html>