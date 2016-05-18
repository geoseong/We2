package aop;
 
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import com.we2.spring.AuthInfo;

@Aspect
public class AOP_Session {

	@Autowired
	HttpServletResponse response;
	@Autowired
	HttpServletRequest request;
	//request=((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
	
	@Pointcut("execution(public * session*(..))")
	public void sessionCheck(){}
	
	/** sessionCheck에 대한 AOP..*/
	@Before("sessionCheck()")
	public void beforesessionCheck(JoinPoint thisJoinPoint) throws Throwable  {
		System.out.println("#### sessionCheck Aspect 시작 ####");     

		HttpSession session = request.getSession();
        AuthInfo authinfo=null;
        
        System.out.println("@Before : sessionCheck try 시작전");     
	      //try{
    	System.out.println("@Before : authinfo 정의직전");
        	authinfo = (AuthInfo) session.getAttribute("authInfo");
    	  	System.out.println("member.userid : " + authinfo.getUserId());
	
	    	  /*	if("".equals(authinfo.getUserId()) || authinfo == null){
	    	  		// 글쓴이 id와 현재 세션의 id를 비교
	    	  	} //end if
*/	    	 
	      /*}catch(NullPointerException e){
	    	 System.out.println("Advice : NullPointerException catch에 걸림.");
	    	 System.out.println("Advice : 세션에 아무것도 없음");
	    	 out.println("<script type='text/javascript'>");
	    	 out.println("	alert('로그인이 필요한 서비스입니다. 로그인 해 주세요.'); ");
	    	 out.println("</script>");
	    	 response.sendRedirect("/login"); return "redirect:/login";
	      } //end try-catch*/
	      
          /*Around : 
	    	  	pointcut으로 지정된 메소드를 proceed() 메소드로 실행.
         		Object result = joinPoint.proceed();*/
		 System.out.println("#### sessionCheck Aspect 끝 ####");
     } //end @before
	
	@AfterReturning(pointcut = "sessionCheck()", returning = "retVal")
    public void afterReturningTargetMethod(JoinPoint thisJoinPoint,
            Object retVal) {
        System.out.println("AOP_Aspect.afterReturningTargetMethod executed." + 
                           " return value is [" + retVal + "]");
    } //end @AfterReturning
	
	@AfterThrowing(pointcut = "sessionCheck()"/*, throwing = "exception"*/)
    public void afterThrowingTargetMethod(JoinPoint thisJoinPoint) throws IOException,  ServletException{
        System.out.println("AOP_Aspect.afterThrowingTargetMethod executed.");
       // HttpServletRequest request= ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        request.setAttribute("error", "sessionAfterthrowing");
    }

	 /*@After("sessionCheck()")
	    public void afterTargetMethod(JoinPoint thisJoinPoint) {
	        System.out.println("AOP_Aspect.@After executed.");
	    }*/
	
} //end Class