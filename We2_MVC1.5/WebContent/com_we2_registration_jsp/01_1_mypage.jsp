<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/w2_reset.css" type="text/css">
<link rel="stylesheet" href="css/01_1_mypage.css" type="text/css">

<script type="text/javascript" src="js/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="js/We2_member.js"></script>
<title>We2_mypage</title>
</head>
<body>
	<div id="wrap">
		<!-- wrap : div를 한번더 감싸고 액션의 기준이 될 수 있음-->

		<!-- 1. 상단 로고 부분-->
		<div id="header">

			<div id="headerinner">
				<h2>
					<b> <sub> <a href="/We2/index.jsp">We2</a>
					</sub>
					</b>
				</h2>

				<!-- 2. 상단 메뉴 부분-->
				<div id="nav">
					<a href="02_project.html">프로젝트 </a> <a href="#">커뮤니티 </a> <a
						href="/We2/ItemList">프로젝트공유 </a> <a href="/We2/ShareList">스터디룸공유
						&nbsp;</a>

					<c:choose>
						<c:when test="${empty loginUser}">

							<a href="01_1_login.jsp">로그인</a>
							<!-- #########위에 로그인 header를 넣는다! -->

						</c:when>
						<c:otherwise>

							<a href="index.jsp">로그아웃</a>
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
					<br> 안녕하세요<br><b><h1><span>${mVo.name}</b> </h1>님</span>
				</div>
			</div>
			<!-- menu END -->

			<div id="contents">

				<div class="my_info">
					<span>나의 정보 보기</span><br>

					<div class="my_info_view">


<form action="/We2/We2_mypage.do" action="post" onsubmit="return joinCheck()" name="frm">
						<!--나의 정보 보기 테이블-->
						<table>


							<tr>
								<td>이름</td>
								<td><input type="text" name="name" size="20"
									value="${mVo.name}" readonly></td>
							</tr>

							<tr>
								<td>아이디</td>
								<td><input type="text" name="userid" size="20"
									value="${mVo.userid}" readonly></td>
							</tr>

							<tr>
								<td>암 &nbsp; 호</td>
								<td><input type="password" name="pwd" size="20">*</td>
							</tr>

							<tr height="20">
								<td width="80">암호 확인</td>
								<td><input type="password" name="pwd_check" size="20">*</td>
							</tr>

							<tr>
								<td>이메일</td>
								<td><input type="text" name="email" size="30"
									value="${mVo.email}"></td>
							</tr>

							<tr>
								<td>보조 이메일</td>
								<td><input type="text" name="sub_email" size="30"
									value="${mVo.sub_email}"></td>
							</tr>

							<tr>
								<td>전화번호</td>
								<td><input type="text" name="phone" size="20"
									value="${mVo.phone}"></td>
							</tr>

							<tr>
								<td>성별</td>
								<td><c:choose>
										<c:when test="${mVo.gender==0}">
											<input type="radio" name="gender" value="0" checked="checked"> 남성
										      <input type="radio" name="gender" value="1"> 여성
								      </c:when>
									</c:choose></td>
							</tr>
						</table>



						<div class="change_leave">
							<input type="button" value="수정하기" class="add_btn" onclick=""/> 
							<input type="button"	value="회원탈퇴" class="add_btn" onclick="location.href='com_we2_registration_jsp/We2_deleteform.jsp'" ;/>
						</div>
</form>
					</div>
					<!--myinfo_view END-->

				</div>
				<!--myinfo END-->
				<div class="my_proj">
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

			
		</div>

</body>
</html>