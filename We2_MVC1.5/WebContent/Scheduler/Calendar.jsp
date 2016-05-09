<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"
 	import="com.we2.project.dto.*"%>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="javax.servlet.jsp.jstl.sql.*" %>
<%@page import="com.saeyan.dto.ScheduleVO" %>
<%@page import="java.util.List" %>
<link rel="stylesheet"  href="css/Schedule.css" type="text/css">
<link rel="stylesheet"  href="css/w2_reset.css" type="text/css">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!

int calendarmemo_num;

%>
<%
   //데이터베이스를 연결하는 관련 변수를 선언한다
  Connection conn= null;
  PreparedStatement pstmt = null;
   //데이터베이스를 연결하는 관련 정보를 문자열로 선언한다
  String jdbc_driver= "oracle.jdbc.driver.OracleDriver"; //JDBC 드라이버의 클래스 경로
  String jdbc_url= "jdbc:oracle:thin:@localhost:1521:orcl";  //접속하려는 데이터베이스의 정보
  
   //JDBC 드라이버 클래스를 로드한다.
  Class.forName("oracle.jdbc.driver.OracleDriver");
   //데이터베이스 연결 정보를 이용해서 Connection 인스턴스를 확보한다.
  conn= DriverManager.getConnection(jdbc_url, "We2", "1234");
  if (conn== null) {
   out.println("No connection is made!");
  }
  %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script>
function winOpen(pjtcode){
	var url = 'Scheduler/memoAdd.jsp?pjtcode='+ pjtcode;
	javascript:window.open(url, '일정관리 추가하기', 'width=400 height=330 left=150 top=100 menubar=no location=no, resizable=no, toolbar=no');
}
function winOpen2(calendarmemo_num){
	var url = "/We2/DateUpdate.do?calendarmemo_num=" + calendarmemo_num;
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
  }
  else { //나타내고자 하는 날짜를 숫자로 변환
	   year=Integer.parseInt(Year);
	   month=Integer.parseInt(Month);
	   if(month<0) { month=11; year=year-1; } //1월부터 12월까지 범위 지정.
	   if(month>11) { month=0; year=year+1; }
  }
  
  %>
 <div id="wrap_c">

     <div class ="top"><!-- 달력 상단 부분, 더 좋은 방법이 없을까? -->
   
       <!-- 년 도--> 
    
          <a href="Calendar.jsp?year=<%out.print(year);%>&month=<%out.print(month-1);%>"> < &nbsp;</a>
    
	      <span> <% out.print(year); %>년 &nbsp;&nbsp;<% out.print(month+1); %>월 </span>
	     
	      <a href="Calendar.jsp?year=<%out.print(year);%>&month=<%out.print(month+1);%>"> &nbsp; > </a>
     
          <span><% out.print("   "+"오늘은 "+currentYear + "년 " + (currentMonth+1) + "월 "+  currentDate+"일"); %></span>
  
        </div> <!-- top end -->
    
      <div class = "calendar">
  
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
          </table>
          
          <div class="calendar_2">
          <table>
           <tr>
    <%
    
    // 파라미터 받는다. - 프로젝트코드
    String pjtcode = request.getParameter("pjtcode");
    System.out.println("pjtcode(cal) : " + pjtcode);
    
   cal.set(year, month, 1); //현재 날짜를 현재 월의 1일로 설정
   int startDay=cal.get(java.util.Calendar.DAY_OF_WEEK); //현재날짜(1일)의 요일
   int end=cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH); //이 달의 끝나는 날
   int br=0; //7일마다 줄 바꾸기
   
	   for(int i=0; i<(startDay-1); i++) { //빈칸출력
	    out.println("<td>&nbsp;</td>");
	    br++;
	    if((br%7)==0) {
	     out.println("<br>");
	    }
	   } //end for
   
	   
   for(int i=1; i<=end; i++) { //날짜출력
	   out.println("<td id='name'><a  href='#' onclick='javascript:winOpen("+pjtcode+")' >"+ i +"</a>"+ "<br>");

      //메모(일정) 추가 부분
      int memoyear, memomonth, memoday, memonum;
      ResultSet rs=null;
      try{
        // select 문장을 문자열 형태로 구성한다.
       String sql= "SELECT * FROM calendarmemo where calendarmemo_year=? and calendarmemo_month=? and calendarmemo_day=? and pjtcode=?";
       pstmt= conn.prepareStatement(sql);
       		pstmt.setInt(1, year);
       		pstmt.setInt(2, (month+1));
       		pstmt.setInt(3, i); 
       		pstmt.setString(4, pjtcode);
        // select 를 수행하면 데이터 정보가 ResultSet 클래스의 인스턴스로 리턴
       rs= pstmt.executeQuery();
        
       while (rs.next()) { // 마지막 데이터까지 반복함.
        //날짜가 같으면 데이터 출력       
	   
	   
        	memoyear=rs.getInt("calendarmemo_year");
	        memomonth=rs.getInt("calendarmemo_month");
	        memoday=rs.getInt("calendarmemo_day");
	        memonum=rs.getInt("calendarmemo_num");      
	        
	    	System.out.println("memonum : " + memonum);
	    	out.println("<a  href='#' onclick='javascript:winOpen2("+memonum+") '>"+rs.getString("calendarmemo_contents")+"</a>"+"<br>"); 
       } //end while
       rs.close();
      }
      catch(Exception e) {
       System.out.println(e);
      };
    out.println("</td>");
    
    br++;
    
    if((br%7)==0 && i!=end) {
     out.println("</tr><tr>");
    } //end if
   } //end for
   while((br++)%7!=0) //말일 이후 빈칸출력
    out.println("<td></td>");
   %>



      </tr>
      </table>
  
      </div> <!-- calendar_2 end -->
     
      </div> <!-- calendar end -->
   </div>  <!-- wrap_c end -->
     
 </body>
</html>
