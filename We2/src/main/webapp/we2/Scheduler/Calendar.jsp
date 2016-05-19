<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List" %>
<link rel="stylesheet"  href="../css/Schedule.css" type="text/css">
<link rel="stylesheet"  href="../css/w2_reset.css" type="text/css">
<link rel="stylesheet"  href="../css/File.css" type="text/css">

<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!

int calendarmemo_num;

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script>
function winOpen(pjtcode){
	var url = "memoAdd.do";
	javascript:window.open(url, '일정관리 추가하기', 'width=400 height=330 left=150 top=100 menubar=no location=no, resizable=no, toolbar=no');
}
function winOpen2(calendarmemo_num){
	var url = "memoUpdate.do?calendarmemo_num=" + calendarmemo_num;
	/* var url = "/We2/Scheduler/memoUpdate.jsp?calendarmemo_num=" + calendarmemo_num; */
	javascript:window.open(url , '일정관리 수정하기', 'width=400 height=330 left=150 top=100 menubar=no location=no, resizable=no, toolbar=no');
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
	  month=currentMonth;
	  System.out.println("currentMonth : "+month);
  }
  else { //나타내고자 하는 날짜를 숫자로 변환
	   year=Integer.parseInt(Year);
	   month=Integer.parseInt(Month);
	   if(month<0) { month=11; year=year-1; } //1월부터 12월까지 범위 지정.
	   if(month>11) { month=0; year=year+1; }
  }
  // 월을 request영역에 보냄.
  	request.setAttribute("month", month);
  %>
 <div id="wrap_c">

     <div class ="top"><!-- 달력 상단 부분, 더 좋은 방법이 없을까? -->
   
       <!-- 년 도 --> 
          <span><% out.print("   "+"오늘은 "+currentYear + "년 " + (currentMonth+1) + "월 "+  currentDate+"일"); %></span>
          
      <div>
          <a href="list?year=<%out.print(year);%>&month=<%out.print(month-1);%>&pjtcode=10"> < &nbsp;</a>
    
	      <span> <% out.print(year); %>년 &nbsp;&nbsp;<% out.print(month); %>월 </span>
	     
	      <a href="list?year=<%out.print(year);%>&month=<%out.print(month+1);%>&pjtcode=10"> &nbsp; > </a>
   	  <div>
  
        </div> <!-- top end -->
    
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
    // 파라미터 받는다. - 프로젝트코드
    String pjtcode = request.getParameter("pjtcode");
    System.out.println("pjtcode(cal) : " + pjtcode);
    
   cal.set(year, month, 1); //현재 날짜를 현재 월의 1일로 설정
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
	<c:forEach var="j" begin="1" end="${end }">
	  <td id='name'>
	  
		<a href='#' onclick='javascript:winOpen("+pjtcode+")' >
			${j}
		</a>
	  <br>
 	<!-- //내용 출력 -->	  
		<c:forEach var="content" items="${Content }">
			<a href="#" onclick='javascript:winOpen2("${content.calendarmemo_num}")'>
				<c:if test="${month==content.calendarmemo_month}">
					<c:if test="${j==content.calendarmemo_day}">
					${content.calendarmemo_contents }<br>
					</c:if>
				</c:if>
			</a>
		<br>
		</c:forEach>
	  </td>
	  
	  <!-- TD가 7개가 넘어가면 TR을 사용. -->
	  <c:set var="br" value="${br+1 }"></c:set>
		 <c:if test="${(br%7)==0 && j != end}">
	  		</tr><tr>
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
      </div> <!-- calendar_2 end -->
     
      </div> <!-- calendar end -->
   </div>  <!-- wrap_c end -->
     
 </body>
</html>
