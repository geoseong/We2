<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/w2_reset.css" type="text/css">
<link rel="stylesheet" href="css/01_1_mypage.css" type="text/css">

<script type="text/javascript" src="js/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="js/We2_member.js"></script>
<title>We2Mypage</title>
</head>
<body>
	<div id="wrap">
		<!-- wrap : div를 한번더 감싸고 액션의 기준이 될 수 있음-->

		<!-- 1. 상단 로고 부분-->
		<div id="header">

			<div id="headerinner">
				<h2>
					<b> <sub> <a href="index.jsp">We2</a>
					</sub>
					</b>
				</h2>

				<!-- 2. 상단 메뉴 부분-->
				<div id="nav">
					<a href="#">프로젝트 </a> <a href="#">커뮤니티 </a> <a
						href="#">프로젝트공유 </a> <a href="#">스터디룸공유
						&nbsp;</a>

					<c:choose>
						<c:when test="${empty authInfo}">

							<a href="login">로그인</a>
							<!-- #########위에 로그인 header를 넣는다! -->

						</c:when>
						<c:otherwise>

							<a href="logout">로그아웃</a>
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
				<b>MyPage</b>

				<!-- 아이디를 받는 안내 인사말-->
				<div id="second_line">
					<br> 안녕하세요<br><span><b>${mVo.name}</b>님</span>
				</div>
			</div>
			<!-- menu END -->

			<div id="contents">

				<div class="my_info">
					<span>나의 정보 보기</span><br>

					<div class="my_info_view">

			<form:form action="Mypage_Modify" name="frm" method="post" commandName="member">
			
					<!--나의 정보 보기 테이블-->
						<table>
						<tr>
						<th>이름</th>
						<td><input type="text" value="${mVo.name}" readonly/></td>
						</tr>
						
						<tr>
						<th>아이디</th>
						<td><input type="text" value="${mVo.userId}" readonly/></td>
						</tr>
						
						<tr>
						<th>전화번호</th>
						<td><input type="text" name="phone" size="20" value="${mVo.phone}"></td>
						</tr>
						
						<tr>
						<th>이메일</th>
						<td><input type="text" name="email" size="30" value="${mVo.email}"></td>
						</tr>
						
						<tr>
						<th>성별</th>
						<td><input type="text" name="gender" size="30" value="${mVo.gender}"></td>
						</tr>
						
						<tr>
						<th>가입일</th>
						<td><input type="text" name="gender" size="30" value="${mVo.regDate}"></td>
						</tr>												
						</table>

						<div class="change_leave">
						<input type="button" value="수정하기" class="add_btn" onclick="Mypage_Modify"/> 
						<input type="button" value="회원탈퇴" class="add_btn" onclick="Member_Delete"/>
						</div>
					</form:form>
					
					</div>
					<!--myinfo_view END-->

					</div>
			</div> <!-- 여기부터 지우세요 -->
		</div>
	</div>
				
				<!--myinfo END-->
				<%-- <div class="my_proj">
					<span>내 프로젝트 보기</span> <br>

					<div class="my_proj_view">

						<div class="ongoing">
							<table style="width: 600px">
								<span> 나의 프로젝트 </span>
								<c:choose>
									<c:when test="${pjtlist==null }">
										<tr>
											<td colspan="2">현재 진행중인 프로젝트가 없습니다.</td>											
										</tr>
									</c:when>
									<c:otherwise>

									<c:forEach var="pjtlist" items="${pjtlist }">
										<tr>
											<td>${pjtlist.pjtName }</td>
											<td style="text-align: right;"><a class="a_add_btn" href="Project?pjtcode=${pjtlist.pjtCode }" target="_blank">프로젝트 바로가기</a>													
											</td>												
										</tr>
									</c:forEach>

									</c:otherwise>
								</c:choose>
						</div>
						<!-- ongoing END -->
					</div>
					</div>
					<!--myproj END-->

				</div>
				<!-- contents END-->

			</div>
			<!-- section END -->

			
		</div> --%>

</body>
</html>