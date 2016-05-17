<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/WillWork.css">
<script>
$(".modal_bg").hide();
$(".second_body1").hide();
$(".second_body2").hide();
$(".second_body3").hide();
$(".second_body4").hide();
$(".second_body5").hide();

//멤버1을 클릭했을 때
$(".first_main>#member1").click(function(){
	$(".modal_bg").show();
	$(".second_body1").show();
});

//멤버2를 클릭했을 때
$(".first_main>#member2").click(function(){
	$(".modal_bg").show();
	$(".second_body2").show();
});
//멤버3을 클릭했을 때
$(".first_main>#member3").click(function(){
	$(".modal_bg").show();
	$(".second_body3").show();
});
//멤버4를 클릭했을 때 
$(".first_main>#member4").click(function(){
	$(".modal_bg").show();
	$(".second_body4").show();
});

//멤버5를 클릭했을 때
$(".first_main>#member5").click(function(){
	$(".modal_bg").show();
	$(".second_body5").show();
});

$(".modal_bg").click(function(){
	$(".second_body1").hide();
	$(".second_body2").hide();
	$(".second_body3").hide();
	$(".second_body4").hide();
	$(".second_body5").hide();
	$(".modal_bg").hide();
	$(".first_main").show();
});
</script>
</head>
<body>

<div class="modal_bg">
</div>


<div class="first_main">
 	<jsp:include page="WillWorkTest.jsp" flush="false"/>
</div>

<!-- 첫 번째 인물에 대한 링크 -->


 <div class="second_body1">
  <div class="second_main">
	<div class="showwork">
		<h3 class="perform_title">할 일 설정</h3>
		<div class="imgtest"><img src="img/people_m1.png" alt=""></div>
		<div class="now_work">
			<%-- <p><c:forEach var="username0" items="${results}">
						<p>${username0.name}<!-- 이름 --></p>
			</c:forEach></p> --%>
			<span class="margin_item">＊지금까지 한일</span>
			<ul class="done_work">
				<c:forEach var="user0" items="${results}" varStatus="status">
					<c:if test="${status.index ==0}">
					<p> 완료한 일: ${user0.doneWork}
					</c:if>
				</c:forEach> 
			</ul>
		</div>
	</div>
	<div class="input_work"> <!-- div안에 form을 넣으면 데이터 이동이 가능! -->
	    <form action="willwork2" method="post" class="input_form">
		<c:forEach var="user0" items="${results}" varStatus="status">
		<c:if test="${status.index ==0}">
		<label>할 일 입력</label>
		<input type="text" size="25" name="inputWork"/> <!-- 입력한 일 -->
		<input type="hidden" name="userName" value="${user0.name}"> <!-- 해당 유저네임 -->
	    <input type="submit" value="추가하기" class="add_btn"/>
	    </c:if>	
	    </c:forEach> 
		</form>
	</div>
	<div class="complet_work">
		<div>할 일 완료</div>
		<div class="checkwork">
			<form action="willwork2">
			<div>			
			<%-- <c:forEach var="user0" items="${results}" varStatus="status">
					<c:if test="${status.index==0}">
					<input type="hidden" name="userName" value="${user0.name}">
					<input type="checkbox" value="${user0.doWork}" name="complete">
				    <label>${user0.doWork}</label>	 					
					</c:if>
			</c:forEach>    --%>
			
		 	<c:forEach var="one" items="${divWorkList}" varStatus="status">
					<%-- <input type="hidden" name="userName" value="${user0.name}"> --%>
					<input type="checkbox" value="${user0.doWork}" name="complete">
				    <label>${one}</label>	 					
			</c:forEach>   
			</div>
			<input type="submit" value="완료하기" class="complete_btn"/>
		 	</form>
		</div>
	 </div>
  </div>
</div>


<!-- 두 번째 인물에 대한 링크 -->

<div class="second_body2">
  <div class="second_main">
	<div class="showwork">
		<h3 class="perform_title">할 일 설정</h3>
		<div class="imgtest"><img src="img/people_w1.png" alt=""></div>
		<div class="now_work">
				<%-- <p><c:forEach var="username1" items="${username1}">
						<p>${username1}<!-- 이름 --></p>
					</c:forEach></p> --%>
			<span class="margin_item">＊지금까지 한일</span>
			<ul class="done_work">
				<c:forEach var="user1" items="${results}" varStatus="status">
					<c:if test="${status.index ==1}">
					<p> 완료한 일: ${user1.doneWork}
					</c:if>
				</c:forEach> 
			</ul>
		</div>
	</div>
	<div class="input_work"> <!-- div안에 form을 넣으면 데이터 이동이 가능! -->
	    <form action="willwork2" method="post" class="input_form">
		<c:forEach var="user1" items="${results}" varStatus="status">
		<c:if test="${status.index ==1}">
		<label>할 일 입력</label>
		<input type="text" size="25" name="inputWork"/> <!-- 입력한 일 -->
		<input type="hidden" name="userName" value="${user1.name}"> <!-- 해당 유저네임 -->
	    <input type="submit" value="추가하기" class="add_btn"/>
	    </c:if>	
	    </c:forEach>
		</form>
	</div>
	<div class="complet_work">
		<div>할 일 완료</div>
		<div class="checkwork">
			<form action="willwork3.jsp">
			<div>			
			<c:forEach var="user1" items="${results}" varStatus="status">
						<c:if test="${status.index==1}">
						<input type="hidden" name="userName" value="${user1.name}">
						<input type="checkbox" value="${user1.doneWork}" name="complete">
					    <label>${user1.doneWork}</label>	 					
						</c:if>
			</c:forEach> 
			</div>
			<input type="submit" value="완료하기" class="complete_btn"/>
		 	</form>
		</div>
	 </div>
  </div>
</div>


<!-- 세 번째 인물에 대한 링크 -->


<div class="second_body3">
  <div class="second_main">
	<div class="showwork">
		<h3 class="perform_title">할 일 설정</h3>
		<div class="imgtest"><img src="img/people_m2.png" alt=""></div>
		<div class="now_work">
			<%-- <p><c:forEach var="username2" items="${username2}">
						<p>${username2}<!-- 이름 --></p>
					</c:forEach></p> --%>
			<span class="margin_item">＊지금까지 한일</span>
			<ul class="done_work">
				
			    <c:forEach var="user2" items="${results}" varStatus="status">
					<c:if test="${status.index ==2}">
					<p> 완료한 일: ${user2.doneWork}
					</c:if>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="input_work"> <!-- div안에 form을 넣으면 데이터 이동이 가능! -->
	    <form action="willwork2" method="post" class="input_form">
		<label>할 일 입력</label>
		<input type="text" size="25" name="inputWork"/>
		<input type="hidden" name="userName" value="${username2}">
	    <input type="submit" value="추가하기" class="add_btn"/>
		</form>
	</div>
	<div class="complet_work">
		<div>할 일 완료</div>
		<div class="checkwork">
			<form action="willwork3.jsp">
			<div>			
			<c:forEach var="user2" items="${results}" varStatus="status">
						<c:if test="${status.index==2}">
						<input type="hidden" name="userName" value="${user2.name}">
						<input type="checkbox" value="${user2.doneWork}" name="complete">
					    <label>${user2.doneWork}</label>	 					
						</c:if>
			</c:forEach> 
			</div>
			<input type="submit" value="완료하기" class="complete_btn"/>
		 	</form>
		</div>
	 </div>
  </div>
</div>


<!-- 네 번째 인물에 대한 링크 -->

<div class="second_body4">
  <div class="second_main">
	<div class="showwork">
		<h3 class="perform_title">할 일 설정</h3>
		<div class="imgtest"><img src="img/people_w2.png" alt=""></div>
		<div class="now_work">
			<%-- <p><c:forEach var="username3" items="${username3}">
						<p>${username3}<!-- 이름 --></p>
					</c:forEach></p> --%>
			<span class="margin_item">＊지금까지 한일</span>
			<ul class="done_work">
				<c:forEach var="user3" items="${results}" varStatus="status">
					<c:if test="${status.index ==3}">
					<p> 완료한 일: ${user3.doneWork}
					</c:if>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="input_work"> <!-- div안에 form을 넣으면 데이터 이동이 가능! -->
	    <form action="willwork2" method="post" class="input_form">
		<label>할 일 입력</label>
		<input type="text" size="25" name="inputWork"/>
		<input type="hidden" name="userName" value="${username3}">
	    <input type="submit" value="추가하기" class="add_btn"/>
		</form>
	</div>
	<div class="complet_work">
		<div>할 일 완료</div>
		<div class="checkwork">
			<form action="willwork3.jsp">
			<div>			
			<c:forEach var="user3" items="${results}" varStatus="status">
						<c:if test="${status.index==3}">
						<input type="hidden" name="userName" value="${user3.name}">
						<input type="checkbox" value="${user3.doneWork}" name="complete">
					    <label>${user3.doneWork}</label>	 					
						</c:if>
			</c:forEach>    
			</div>
			<input type="submit" value="완료하기" class="complete_btn"/>
		 	</form>
		</div>
	 </div>
  </div>
</div>


<!-- 다섯 번째 인물에 대한 링크 -->
<div class="second_body5">
  <div class="second_main">
	<div class="showwork">
		<h3 class="perform_title">할 일 설정</h3>
		<div class="imgtest"><img src="img/people_m6.png" alt=""></div>
		<div class="now_work">
			<%-- <p><c:forEach var="username4" items="${username4 }">
						<p>${username4}<!-- 이름 --></p>
					</c:forEach></p> --%>
			<span class="margin_item">＊지금까지 한일</span>
			<ul class="done_work">
				<c:forEach var="user4" items="${results}" varStatus="status">
					<c:if test="${status.index ==4}">
					<p> 완료한 일: ${user4.doneWork}
					</c:if>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="input_work"> <!-- div안에 form을 넣으면 데이터 이동이 가능! -->
	    <form action="willwork2" method="post" class="input_form">
		<label>할 일 입력</label>
		
		<input type="text" size="25" name="inputWork"/>
		<input type="hidden" name="userName" value="${username4}">
	    <input type="submit" value="추가하기" class="add_btn"/>
		</form>
	</div>
	<div class="complet_work">
		<div>할 일 완료</div>
		<div class="checkwork">
						<form action="willwork3.jsp">
			<div>			
			<c:forEach var="user4" items="${results}" varStatus="status">
					<c:if test="${status.index==4}">
					<input type="hidden" name="userName" value="${user4.name}">
					<input type="checkbox" value="${user4.doneWork}" name="complete">
				    <label>${user4.doneWork}</label>	 					
					</c:if>
			</c:forEach> 
			</div>
			<input type="submit" value="완료하기" class="complete_btn"/>
		 	</form>
	     	</div>
	      </div>
  	   </div>
	</div>
</body>

<script src="js/jquery-1.11.0.min.js"></script>
<script src="js/WillWorkTest.js"></script>

</html>