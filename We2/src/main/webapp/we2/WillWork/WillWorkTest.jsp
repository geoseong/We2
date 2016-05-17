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

	<!-- <script type="text/javascript">
	
	$(".modal_bg").hide();
	$(".second_body").hide();
	
	//로그인을 클릭했을 때
	$("#nav>a").click(function(){
		$(".modal_bg").show();
		$(".second_body").show();
	});
	</script> -->

<body>
<!-- <div class="modal_bg">
</div>
<div class="first_main"> -->

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

</body>

<script src="js/jquery-1.11.0.min.js"></script>
<script src="js/WillWork.js"></script>

</html>