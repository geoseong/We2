<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!

int calendarmemo_num;

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"  href="/We2/css/Schedule.css" type="text/css">
<link rel="stylesheet"  href="/We2/css/w2_reset.css" type="text/css">

<script type="text/javascript" src="/We2/js/jquery-1.12.1.min.js"></script>

<fmt:requestEncoding value="UTF-8"/>
<script>
 
function winOpen(year, month, day){
	var url = "memoAdd.do?year="+year+"&month="+month+"&day="+day;
	javascript:window.open(url, '일정관리 추가하기', 'width=550 height=450 left=150 top=100 menubar=no location=no, resizable=no, toolbar=no');
}
function winOpen2(calendarmemo_num){
	var url = "memoUpdate.do?calendarmemo_num=" + calendarmemo_num;
	/* var url = "/We2/Scheduler/memoUpdate.jsp?calendarmemo_num=" + calendarmemo_num; */
	javascript:window.open(url , '일정관리 수정하기', 'width=550 height=450 left=150 top=100 menubar=no location=no, resizable=no, toolbar=no');
}
</script>

<title>Calendar</title>
</head>
<body>

  <% 
  java.util.Calendar cal=java.util.Calendar.getInstance(); //Calendar객체 cal생성
  int currentYear=cal.get(java.util.Calendar.YEAR); //현재 날짜 기억
  int currentMonth=cal.get(java.util.Calendar.MONTH);
  int currentDate=cal.get(java.util.Calendar.DATE);
  String Year=request.getParameter("year"); //나타내고자 하는 날짜
  String Month=request.getParameter("month");
  int year, month;
  
  if(Year == null && Month == null){ //처음 호출했을 때
	  year=currentYear;
	  month=currentMonth+1;
  }
  else { //나타내고자 하는 날짜를 숫자로 변환
	   year=Integer.parseInt(Year);
	   month=Integer.parseInt(Month);
	   if(month<0) { month=11; year=year-1; } //1월부터 12월까지 범위 지정.
	   if(month>11) { month=0; year=year+1; }
  }
  // 년, 월을 request영역에 보냄.
  	request.setAttribute("month", month);
  	request.setAttribute("year", year);
  %>
  
  
  
    <div id ="wrap_c">

     <div class ="wrap_t"><!-- 테이블 전체를 감싸는 div -->
   
       <!-- 년 도 --> 
          <span><% out.print("   "+"오늘은 "+currentYear + "년 " + (currentMonth+1) + "월 "+  currentDate+"일"); %></span>
          
        <div>
          <a href="list?year=<%out.print(year);%>&month=<%out.print(month-1);%>"> < &nbsp;</a>
    
	      <span> <% out.print(year); %>년 &nbsp;&nbsp;<% out.print(month); %>월 </span>
	     
	      <a href="list?year=<%out.print(year);%>&month=<%out.print(month+1);%>"> &nbsp; > </a>
          </div> 
          <br>
          <div class = "calendar">
  
  	<!-- td와 tr 영역 너비가 내용이 많아지면 너비가 늘어납니다. 크기를 고정시켜주셔요~~ ㅜㅜ -->
      <table> <!-- 달력 부분 -->
         <tr>
          <th>S</th> <!-- 일=1 -->
          <th>M</th> <!-- 월=2 -->
          <th>T</th> <!-- 화=3 -->
          <th>W</th> <!-- 수=4 -->
          <th>T</th> <!-- 목=5 -->
          <th>F</th> <!-- 금=6 -->
          <th>S</th> <!-- 토=7 -->
          </tr>
     <!-- </table> -->
          
     <!-- 원래 새 table이 만들어졌으나 합침. <div class="calendar_2"> -->
          
    <!-- <table> -->
    
   <tr>
   <%
	   cal.set(year, month-1, 1); //현재 날짜를 현재 월의 1일로 설정
	   int startDay=cal.get(java.util.Calendar.DAY_OF_WEEK); //현재날짜(1일)의 요일
	 		//리퀘스트영역에 현재날짜(1일)의 요일을 보냄 
			request.setAttribute("startDay", startDay);
	   int end=cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH); //이 달의 끝나는 날
	   		//리퀘스트영역에 달의 끝나는 날을 보냄 
	   		request.setAttribute("end", end);
   %>
   
   <!-- jsp 내장변수지정. 스타일관계없음 -->
   <c:set var="br" value="0"></c:set>
 	
 <!-- START : 본격적인 day부분을 td태그 반복하는 부분. -->
 	<!-- 해당 월 시작 날짜 전까지 빈칸 TD를 추가. -->
   <c:forEach var="i" begin="1" end="${startDay-1 }">
		<td> </td>
		<c:set var="br" value="${br+1 }"></c:set>
		<c:if test="${(i+1%7)==0 }">
			<br>
		</c:if>
   </c:forEach>
  
	<!-- //날짜 TD  -->
	
	<div class="date">
	<c:forEach var="j" begin="1" end="${end }">
	  <!-- start : 날짜부분 -->
	  <td class="name" >
	  	<c:choose>
			<c:when test="${leader eq authInfo.userId}">
				<a href='#' onclick='javascript:winOpen(${year}, ${month}, ${j })' >
				${j}
				</a>
			</c:when>
			<c:otherwise>
				${j}
			</c:otherwise>
		</c:choose>
		<br>
 	   <!-- //내용 출력 -->	  
		<c:forEach var="content" items="${Content }">
			<c:if test="${month==content.getCalendarmemo_month()}">
				<c:if test="${j==content.getCalendarmemo_day()}">
					<a class="name_1" href="#" onclick='javascript:winOpen2("${content.getCalendarmemo_num()}")'>
					→ ${content.getCalendarmemo_contents() }
					</a>
					<br>
				</c:if>
			</c:if>
			
		</c:forEach>
	  </td>  
	  </div>  <!-- date end -->
	  <!-- end : 날짜부분 -->
	  
	  <!-- TD가 7개가 넘어가면 TR을 사용. -->
	  <c:set var="br" value="${br+1 }"></c:set>
		<c:if test="${(br%7)==0 && j != end}">
	  	</tr>
	  		
	<tr> 
		</c:if>
			</c:forEach> 
				<!-- 마지막 주의 빈 칸 TD를 채워넣는 부분 -->
				<c:forEach var="k" begin="${br }" end="35">
		<c:choose>
			<c:when test="${(k%7)!=0 }">
				<td> </td>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</c:forEach>
     </tr>
 </table>
 <!-- END : 본격적인 day부분을 td태그 반복하는 부분. -->
 
         </div> <!-- calendar end -->          
          
      </div> <!-- wrap_t end -->
   
   </div> <!-- wrap_c end -->
     
 </body>
</html>
