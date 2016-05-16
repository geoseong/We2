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
<c:if test="${not empty results}">
	<div class="people" id="member1">
			<div>
					<img src="img/people_m1.png"/>
			</div>
		 <div class="state_work">
				<a class="tag1">
					 <c:forEach var="user0" items="${results}" varStatus="status">
						<c:if test="${status.index ==0}">
							<p> ${user0.name}<!-- 이름 -->
							<p> 해야할 일 : ${user0.doWork}
							<p> 완료한 일: ${user0.doneWork}
						</c:if>
					</c:forEach> 
					
			    	<%-- <p> 해야할 일 : 				    	
			    		<c:forEach var="user0" items="${results}">
				    		<c:if test="${status.index==0}">
								${user0.doWork}
							</c:if>
			    		</c:forEach>   		
					</p>
					
			    	<p> 완료한 일:
				    
				    	<c:forEach var="user0" items="${results}">
				    		<c:if test="${status.index ==0}">
							<p>${user0.doneWork}</p>
							</c:if>
			    		</c:forEach>   					    			
				    	
			    	</p> --%>
			    </a>
		</div>	
	</div>
</c:if>
	
	
	
<!-- User2 -->
<c:if test="${not empty results }">
	<div class="people" id="member2">
			<div>
					<img src="img/people_w1.png"/>
			</div>
			 <div class="state_work">
					<a class="tag1">
						<c:forEach var="user1" items="${results}" varStatus="status">
							<c:if test="${status.index ==1}">
							<p> ${user1.name}<!-- 이름 -->
							<p> 해야할 일 : ${user1.doWork}		
							<p> 완료한 일: ${user1.doneWork}
						</c:if>
						</c:forEach>
						
				    	<%-- <p> 해야할 일 : 				    	
				    		<c:forEach var="user1" items="${results }">
					    		<c:if test="${status.index ==1}">
								${user1.doWork}
								</c:if>
				    		</c:forEach>   		
						</p>
						
				    	<p> 완료한 일:
					    
				    	<c:forEach var="user1" items="${results}">
				    			<c:if test="${status.index ==1}">
								${user1.doneWork}
								</c:if>
			    		</c:forEach>   					    			
					    	
				    	</p> --%>
				    </a>
			</div>	
		</div>
</c:if>
	
<!-- User3 -->
<c:if test="${not empty results }">
	<div class="people" id="member3">
			<div>
					<img src="img/people_m2.png"/>
			</div>
			<div class="state_work">
					<a class="tag1">
						<c:forEach var="user2" items="${results}" varStatus="status">
							<c:if test="${status.index ==2}">
							<p> ${user2.name}<!-- 이름 -->
							<p> 해야할 일 : ${user2.doWork}		
							<p> 완료한 일: ${user2.doneWork}
						</c:if>
						</c:forEach>
						
				    	<%-- <p> 해야할 일 : 				    	
				    		<c:forEach var="user2" items="${results }">
				    			${user2.doWork}
				    		</c:forEach>   		
						</p>
						
				    	<p> 완료한 일:
					    	<c:forEach var="user2" items="${results }">
					    			${user2.doneWork}
				    		</c:forEach>   					    			
				    	</p> --%>
				    </a>
			</div>	
	</div>
</c:if>

<!-- User4 -->
<c:if test="${not empty results }">
	<div class="people" id="member4">
			<div>
					<img src="img/people_w2.png"/>
			</div>
			 <div class="state_work">
					<a class="tag1">
						<c:forEach var="user3" items="${results}" varStatus="status">
							<c:if test="${status.index ==3}">
							<p> ${user3.name}<!-- 이름 -->
							<p> 해야할 일 : ${user3.doWork}		
							<p> 완료한 일: ${user3.doneWork}
						</c:if>
						</c:forEach>
				    	<%-- <p> 해야할 일 : 				    	
				    		<c:forEach var="user3" items="${results}">
				    			${user3.doWork}
				    		</c:forEach>   		
						</p>
						
				    	<p> 완료한 일:
					    
					    	<c:forEach var="user3" items="${results}">
					    			${user3.doneWork}
				    		</c:forEach>   					    			
					    	
				    	</p> --%>
				    </a>
			</div>	
	</div>
</c:if>

<!-- User5 -->
<c:if test="${not empty results }">
	<div class="people" id="member5">
			<div>
					<img src="img/people_m6.png"/>
			</div>
		 <div class="state_work">
				<a class="tag1">
					<c:forEach var="user4" items="${results}" varStatus="status">
							<c:if test="${status.index ==4}">
							<p> ${user3.name}<!-- 이름 -->
							<p> 해야할 일 : ${user4.doWork}		
							<p> 완료한 일: ${user4.doneWork}
						</c:if>
						</c:forEach>
			    	<%-- <p> 해야할 일 : 				    	
			    		<c:forEach var="user4" items="${results }">
			    			${user4.doWork}
			    		</c:forEach>   		
					</p>
					
			    	<p> 완료한 일:
				    
				    	<c:forEach var="user4" items="${results}">
				    			${user4.doneWork}
			    		</c:forEach>   					    			
				    	
			    	</p> --%>
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
		<label>할 일 입력</label>
		<input type="text" size="25" name="inputWork"/> <!-- 입력한 일 -->
		<input type="hidden" name="userName" value="${username0}"> <!-- 해당 유저네임 -->
	    <input type="submit" value="추가하기" class="add_btn"/>
		</form>
	</div>
	<div class="complet_work">
		<div>할 일 완료</div>
		<div class="checkwork">
			<form action="willwork2">
			<div>			
			<c:forEach var="user0" items="${results}" varStatus="status">
					<c:if test="${status.index==0}">
					<input type="hidden" name="userName" value="${user0.name}">
					<input type="checkbox" value="${user0.doneWork}" name="complete">
				    <label>${user0.doneWork}</label>	 					
					</c:if>
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
<script src="js/WillWork.js"></script>

</html>