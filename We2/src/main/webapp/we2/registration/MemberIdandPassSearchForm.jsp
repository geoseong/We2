<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title>아이디찾기/비밀번호찾기</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="/We2/css/w2_reset.css" type="text/css">
<link rel="stylesheet" href="/We2/css/board_fin.css" type="text/css">
<script type="text/javascript" src="/We2/js/jquery-1.12.1.min.js"></script>
</head>
<body>

	<div id="wrap">
		<!-- wrap : div를 한번더 감싸고 액션의 기준이 될 수 있음-->

		<!-- 1. 상단 로고 부분-->
		<!-- 1. 상단 로고 부분-->
		<div id="header">

			<div id="headerinner">
				<h2 style="top: 26px;">
					<b> <a href="/We2">We2</a>
					</b>
				</h2>

				<!-- 2. 상단 메뉴 부분-->
				<div id="nav">

					<a href="/We2/Member_Mypage">프로젝트 </a>
            <a href="/We2/cBoard/list?page=1&category=cFindwork">커뮤니티 </a>
            <a href="/We2/pjtBoard/list?page=1&category=pGroup">프로젝트공유 </a>
            <a href="/We2/studyroom/list?page=1">스터디룸공유 &nbsp;</a>
					<c:choose>
						<c:when test="${empty loginUser}">

							<a href="com_we2_registration_jsp/01_1_login.jsp">로그인</a>
							<!-- #########위에 로그인 header를 넣는다! -->

						</c:when>
						<c:otherwise>

							<a href="We2_logout.do">로그아웃</a>
							<!-- #########위에 로그인 header를 넣는다! -->

						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
		<!-- header END -->

		<!--3.가운데 메뉴 + 내용-->
		<div id="section">
			<div id="menu">
				<b>아이디찾기/비밀번호찾기</b>
				<!-- 게시판 타이틀 밑의 선-->
				<div id="second_line" style="background-color: #166BA3;"></div>

			</div>

			<div id="contents">

				<div style="display: inline-block; padding: 5px;">
					<h2>아이디/패스워드 찾기</h2>
					<span><spring:message code="member.lost" /></span>
					<form action="idsearch" method="POST">
						<table>
							<tr>
								<th><spring:message code="name" /></th>
								<td><input type="text" name="name" /></td>
							</tr>
							<tr>
								<th><spring:message code="email" /></th>
								<td><input type="text" name="email" /></td>
							</tr>
						</table>
						<input type="submit" value="아이디찾기" />
					</form>
				</div>
				<div style="display: inline-block; padding: 5px;">
				${lostuser}
				</div>		
			</div>

		</div>
		<!-- section END -->


		<!-- <div id="footer">
Copyright © geoseong.com
</div> -->
	</div>
</body>
</html>