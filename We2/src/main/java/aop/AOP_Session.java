package aop;
 
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
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
	@Autowired
	HttpSession session;
	//request=((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
	
	@Pointcut("execution(public * com.we2..*.aop*(..))")
	public void sessionCheck(){}
	
	/** sessionCheck에 대한 AOP..*/
	@Before("sessionCheck()")
	public void beforesessionCheck(JoinPoint thisJoinPoint) throws Throwable  {
			System.out.println("@Before 시작 -----");
    	AuthInfo authinfo = (AuthInfo) session.getAttribute("authInfo");
    	  	System.out.println("		@Before] member.userid : " + authinfo.getUserId());
    	  	System.out.println("@Before 끝 -----");
     } //end @before
	
	@AfterReturning(pointcut = "aop.AOP_Session.sessionCheck()", returning = "retVal")
    public void afterReturningTargetMethod(JoinPoint thisJoinPoint, Object retVal) {
			System.out.println("@AfterReturning 시작------\n return value is [" + retVal + "]\n@AfterReturning 끝------------------");
    } //end @AfterReturning
	
	@AfterThrowing(pointcut = "aop.AOP_Session.sessionCheck()", throwing = "ex")
    public void afterThrowingTargetMethod(JoinPoint thisJoinPoint , Throwable ex) throws IOException,  ServletException{
        	System.out.println("@AfterThrowing 시작 -----");
       // HttpServletRequest request= ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String ex_str=ex.toString();
        	System.out.println("@AfterThrowing 시작------\nThrowable ex - " + ex_str+"\n@AfterThrowing 끝------------------");
        request.setAttribute("error", ex_str);
    }

	 @After("sessionCheck()")
	    public void afterTargetMethod(JoinPoint thisJoinPoint) {
	        System.out.println("@After 시작------------\n@After 끝------------------");
	    }
	
} //end Class