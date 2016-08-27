<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../We2/css/we2_reset.css">
<link rel="stylesheet" type="text/css" href="/We2/css/WillWork.css">
</head>
<body>
<%int i=1; %> <!--  할 일을 구분하기 위한 변수 -->
<%int j=1; %> <!-- 멤버를 구분하기 위한 변수 -->
<div class="modal_bg">
</div>

<div class="first_main">
<div class = "title" >
<h2> 할 일 </h2>
</div>

<c:if test="${countPeople >= 1}">
	<c:forEach var="user"  items="${results}" varStatus="status"   begin="0"  end="${countPeople-1}" >
	<div class="people"  id="member<%=j%>">
			<div>
				<img src="../img/people_m2.png">
			</div>
			<div class="state_work"> <!-- 이름과 할 일 부분 묶은 것 -->
						<div>
							<p>${user.name}
						</div>
						<div class="dowork_donework">
							<div>
							해야할 일 : ${user.doWork}
							</div>
							<div>
							완료한 일  : ${user.doneWork}
							</div>
						</div>
			</div>
	</div>
	<%j++; %>
	</c:forEach>
</c:if>
</div> <!-- fistmain -->


<!-- n 번째 인물에 대한 링크 -->
<c:if test="${countPeople >= 1}">
	<c:forEach var="user" items="${results}" varStatus="status" begin="0" end="${countPeople-1}">
		<div class="second_body<%=i%>">
		  <div class="second_main">
			<div class="showwork">
				<h3 class="perform_title">할 일 설정</h3>
				<div class="imgtest"><img src="../img/people_m2.png" alt=""></div>
				<div class="now_work">
					<span class="margin_item">지금까지 한 일  </span>
					 <form action="willwork2" method="post" class="input_form">
					<ul class="done_work">
							<p> 완료한 일: ${user.doneWork} </p>
					</ul>
					</form>
				</div> <!-- 지금까지 한 일 -->
			</div>
			
			<div class="input_work"> <!-- div안에 form을 넣으면 데이터 이동이 가능! -->
			    <form action="willwork2" method="post" class="input_form">
					<label>할 일 입력</label>
					<input type="text" size="25" name="inputWork"/> <!-- 입력한 일 -->
					<input type="hidden" name="userName" value="${user.name}"> <!-- 해당 유저네임 -->
				    <input type="submit" value="추가하기" class="add_btn"/>
				</form>
			</div>
			
			<div class="complet_work">
				<div>할 일 완료 </div>
				<div class="checkwork">
					<form action="willwork3" method="post">
					<div>			
					      <input type="hidden" name="userName" value="${user.name}">
						<!-- 할 일 수만큼 반복해서 돌려줌 -->
						
						<!-- 위에서 forEach가 반복되는중이다. -->
							<c:set var="divWorkList" value="divWorkList${status.count}"></c:set>
								<c:forEach var="divWorkList"  items="${requestScope[divWorkList]}" varStatus="status">
							 	<c:if test="${divWorkList ne ''}">
								<input type="checkbox" name="complete" value="${divWorkList}" >
								<label>${divWorkList}</label>	 
								</c:if>	
								</c:forEach>
					</div>
					<input type="submit" value="완료하기" class="complete_btn"/>
				 	</form>
				</div>
			 </div>
		  	</div>
			</div>
			<%i++; %>				
</c:forEach>
</c:if>
</body>

<script src="/We2/js/WillWork.js"></script>

</html>