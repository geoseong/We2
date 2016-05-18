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
public class AOP_Auth {

	@Autowired
	HttpServletResponse response;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;
	
	@Pointcut("execution(public * test*(..))")
	public void authCheck(){}
	
	/** authCheck에 대한 AOP..*/
	@Before("authCheck()")
	public void beforeauthCheck(JoinPoint thisJoinPoint) throws Throwable  {
		System.out.println("#### Auth Aspect 시작 ####");     

		//HttpSession session = request.getSession();
		
        AuthInfo authinfo=(AuthInfo) session.getAttribute("authInfo");
    	  	System.out.println("member.userid : " + authinfo.getUserId());
		
    	  	System.out.println("#### Auth Aspect 끝 ####");
     } //end @before
	
	@AfterReturning(pointcut = "authCheck()", returning = "retVal")
    public void afterReturningauthCheck(JoinPoint thisJoinPoint,
            Object retVal) {
        System.out.println("AOP_Aspect.AfterReturning 실행됨." + 
                           " return value is [" + retVal + "]");
    } //end @AfterReturning
	
	@AfterThrowing(pointcut = "authCheck()", throwing = "ex")
    public void afterThrowingauthCheck(JoinPoint thisJoinPoint, Throwable ex) throws IOException,  ServletException{
        System.out.println("AOP_Aspect.afterThrowingTargetMethod executed.");
       // HttpServletRequest request= ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        request.setAttribute("error", "authentication");
    }
	
}
