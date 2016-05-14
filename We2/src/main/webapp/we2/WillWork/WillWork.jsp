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
</head>
<body>

<div class="modal_bg">
</div>
<div class="first_main">

<!-- User1 -->	
<c:if test="${not empty username0 }">
	<div class="people" id="member1">
			<div>
					<img src="img/people_m1.png"/>
			</div>
		 <div class="state_work">
				<a class="tag1">
					<c:forEach var="username0" items="${username0 }">
						<p>${username0}<!-- 이름 --></p>
					</c:forEach>
			    	<p> 해야할 일 : 				    	
			    		<c:forEach var="user0" items="${user0 }">
			    			${user0.doWork}
			    		</c:forEach>   		
					</p>
					
			    	<p> 완료한 일:
				    
				    	<c:forEach var="user0" items="${user0 }">
				    			${user0.doneWork}
			    		</c:forEach>   					    			
				    	
			    	</p>
			    </a>
		</div>	
	</div>
</c:if>
	
	
	
<!-- User2 -->
<c:if test="${not empty username1 }">
	<div class="people" id="member2">
			<div>
					<img src="img/people_w1.png"/>
			</div>
			 <div class="state_work">
					<a class="tag1">
						<c:forEach var="username1" items="${username1 }">
							<p>${username1}<!-- 이름 --></p>
						</c:forEach>
				    	<p> 해야할 일 : 				    	
				    		<c:forEach var="user1" items="${user1 }">
				    			${user1.doWork}
				    		</c:forEach>   		
						</p>
						
				    	<p> 완료한 일:
					    
					    	<c:forEach var="user1" items="${user1}">
					    			${user1.doneWork}
				    		</c:forEach>   					    			
					    	
				    	</p>
				    </a>
			</div>	
		</div>
</c:if>
	
<!-- User3 -->
<c:if test="${not empty username2 }">
	<div class="people" id="member3">
			<div>
					<img src="img/people_m2.png"/>
			</div>
			 <div class="state_work">
					<a class="tag1">
						<c:forEach var="username2" items="${username2 }">
							<p>${username2}<!-- 이름 --></p>
						</c:forEach>
				    	<p> 해야할 일 : 				    	
				    		<c:forEach var="user2" items="${user2 }">
				    			${user2.doWork}
				    		</c:forEach>   		
						</p>
						
				    	<p> 완료한 일:
					    	<c:forEach var="user2" items="${user2 }">
					    			${user2.doneWork}
				    		</c:forEach>   					    			
				    	</p>
				    </a>
			</div>	
	</div>
</c:if>

<!-- User4 -->
<c:if test="${not empty username3 }">
	<div class="people" id="member4">
			<div>
					<img src="img/people_w2.png"/>
			</div>
			 <div class="state_work">
					<a class="tag1">
						<c:forEach var="username3" items="${username3 }">
							<p>${username3}<!-- 이름 --></p>
						</c:forEach>
				    	<p> 해야할 일 : 				    	
				    		<c:forEach var="user3" items="${user3 }">
				    			${user3.doWork}
				    		</c:forEach>   		
						</p>
						
				    	<p> 완료한 일:
					    
					    	<c:forEach var="user3" items="${user3 }">
					    			${user3.doneWork}
				    		</c:forEach>   					    			
					    	
				    	</p>
				    </a>
			</div>	
	</div>
</c:if>

<!-- User5 -->
<c:if test="${not empty username4 }">
	<div class="people" id="member5">
			<div>
					<img src="img/people_m6.png"/>
			</div>
		 <div class="state_work">
				<a class="tag1">
					<c:forEach var="username4" items="${username4 }">
						<p>${username4}<!-- 이름 --></p>
					</c:forEach>
			    	<p> 해야할 일 : 				    	
			    		<c:forEach var="user4" items="${user4 }">
			    			${user4.doWork}
			    		</c:forEach>   		
					</p>
					
			    	<p> 완료한 일:
				    
				    	<c:forEach var="user4" items="${user4 }">
				    			${user4.doneWork}
			    		</c:forEach>   					    			
				    	
			    	</p>
			    </a>
		</div>	
	</div>
</c:if>
</div>


<!-- 첫 번째 인물에 대한 링크 -->

<div class="second_body1">
  <div class="second_main">
	<div class="showwork">
		<h3 class="perform_title">할 일 설정</h3>
		<div class="imgtest"><img src="img/people_m1.png" alt=""></div>
		<div class="now_work">
			<p><c:forEach var="username0" items="${username0}">
						<p>${username0}<!-- 이름 --></p>
			</c:forEach></p>
			<span class="margin_item">＊지금까지 한일</span>
			<ul class="done_work">
				<c:forEach var="user0" items="${user0}">
				    ${user0.doneWork}<p>
			    </c:forEach>  
			</ul>
		</div>
	</div>
	<div class="input_work"> <!-- div안에 form을 넣으면 데이터 이동이 가능! -->
	    <form action="willwork2.jsp" method="get" class="input_form">
		<label>할 일 입력</label>
		<input type="text" size="25" name="inputWork"/>
		<input type="hidden" name="userName" value="${username0}">
	    <input type="submit" value="추가하기" class="add_btn"/>
		</form>
	</div>
	<div class="complet_work">
		<div>할 일 완료</div>
		<div class="checkwork">
			<form action="willwork3.jsp">
			<div>			
			<c:forEach var="dowork0" items="${dowork0}">
					<input type="hidden" name="userName" value="${username0}">
					<input type="checkbox" value="${dowork0 }" name="complete">
					<label>${dowork0}</label>						
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
				<p><c:forEach var="username1" items="${username1}">
						<p>${username1}<!-- 이름 --></p>
					</c:forEach></p>
			<span class="margin_item">＊지금까지 한일</span>
			<ul class="done_work">
				<c:forEach var="user1" items="${user1 }">
				    ${user1.doneWork} 
			    </c:forEach>  
			</ul>
		</div>
	</div>
	<div class="input_work"> <!-- div안에 form을 넣으면 데이터 이동이 가능! -->
	    <form action="willwork2.jsp" method="get" class="input_form">
		<label>할 일 입력</label>
		<input type="text" size="25" name="inputWork"/>
		<input type="hidden" name="userName" value="${username1}">
	    <input type="submit" value="추가하기" class="add_btn"/>
		</form>
	</div>
	<div class="complet_work">
		<div>할 일 완료</div>
		<div class="checkwork">
			<form action="willwork3.jsp">
			<div>			
			<c:forEach var="dowork1" items="${dowork1}">
					<input type="hidden" name="userName" value="${username1}">
					<input type="checkbox" value="${dowork1 }" name="complete">
					<label>${dowork1}</label>						
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
			<p><c:forEach var="username2" items="${username2}">
						<p>${username2}<!-- 이름 --></p>
					</c:forEach></p>
			<span class="margin_item">＊지금까지 한일</span>
			<ul class="done_work">
				<c:forEach var="user2" items="${user2 }">
				    ${user2.doneWork}<p>
			    </c:forEach>  
			</ul>
		</div>
	</div>
	<div class="input_work"> <!-- div안에 form을 넣으면 데이터 이동이 가능! -->
	    <form action="willwork2.jsp" method="get" class="input_form">
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
			<c:forEach var="dowork2" items="${dowork2}">
					<input type="hidden" name="userName" value="${username2}">
					<input type="checkbox" value="${dowork2 }" name="complete">
					<label>${dowork2}</label>						
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
			<p><c:forEach var="username3" items="${username3}">
						<p>${username3}<!-- 이름 --></p>
					</c:forEach></p>
			<span class="margin_item">＊지금까지 한일</span>
			<ul class="done_work">
				<c:forEach var="user3" items="${user3}">
				    ${user3.doneWork}<p>
			    </c:forEach>  
			</ul>
		</div>
	</div>
	<div class="input_work"> <!-- div안에 form을 넣으면 데이터 이동이 가능! -->
	    <form action="willwork2.jsp" method="get" class="input_form">
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
			<c:forEach var="dowork3" items="${dowork3}">
					<input type="hidden" name="userName" value="${username3}">
					<input type="checkbox" value="${dowork3 }" name="complete">
					<label>${dowork3}</label>						
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
			<p><c:forEach var="username4" items="${username4 }">
						<p>${username4}<!-- 이름 --></p>
					</c:forEach></p>
			<span class="margin_item">＊지금까지 한일</span>
			<ul class="done_work">
				<c:forEach var="user4" items="${user4 }">
				    ${user4.doneWork}<p>
			    </c:forEach>  
			</ul>
		</div>
	</div>
	<div class="input_work"> <!-- div안에 form을 넣으면 데이터 이동이 가능! -->
	    <form action="willwork2.jsp" method="get" class="input_form">
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
			<c:forEach var="dowork4" items="${dowork4}">
					<input type="hidden" name="userName" value="${username4}">
					<input type="checkbox" value="${dowork4 }" name="complete">
					<label>${dowork4}</label>						
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
<script src="js/WillWork.js"></script>

</html>