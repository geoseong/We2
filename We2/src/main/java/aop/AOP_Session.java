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
	
	@Pointcut("execution(public * com.we2.sharepjtboard.PjtBoardController.aop*(..))")
	public void sessionCheck(){}
	
	/** sessionCheck에 대한 AOP..*/
	@Before("sessionCheck()")
	public void beforesessionCheck(JoinPoint thisJoinPoint) throws Throwable  {
		System.out.println("#### sessionCheck Aspect 시작 ####");     

    	System.out.println("@Before : authinfo 정의직전");
    	AuthInfo authinfo = (AuthInfo) session.getAttribute("authInfo");
    	  	System.out.println("AOP] member.userid : " + authinfo.getUserId());
	
		 System.out.println("#### sessionCheck Aspect 끝 ####");
     } //end @before
	
	@AfterReturning(pointcut = "aop.AOP_Session.sessionCheck()", returning = "retVal")
    public void afterReturningTargetMethod(JoinPoint thisJoinPoint,
            Object retVal) {
        System.out.println("AOP_Aspect.afterReturningTargetMethod 실행됨." + 
                           " return value is [" + retVal + "]");
       /* AuthInfo authinfo = (AuthInfo)request.getAttribute("authInfo");
        System.out.println("afterthrowing.authinfo = " + authinfo.getPhone());*/
    } //end @AfterReturning
	
	@AfterThrowing(pointcut = "aop.AOP_Session.sessionCheck()", throwing = "ex")
    public void afterThrowingTargetMethod(JoinPoint thisJoinPoint , Throwable ex) throws IOException,  ServletException{
        System.out.println("AOP_Aspect.afterThrowingTargetMethod executed.");
       // HttpServletRequest request= ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        System.out.println("Throwable ex - " + ex);
        request.setAttribute("error", "sessionAfterthrowing");
       
    }

	 @After("sessionCheck()")
	    public void afterTargetMethod(JoinPoint thisJoinPoint) {
	        System.out.println("AOP_Aspect.@After executed.");
	    }
	
} //end Class