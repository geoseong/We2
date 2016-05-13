package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.we2.registration.AuthInfo;

public class AOP_Aspect {
	
	public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable  {
		 
		System.out.println("#### LoginAspect 시작 ####");     
		 
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        AuthInfo authinfo=null;
        
	      try{
	    	  authinfo = (AuthInfo) session.getAttribute("authInfo");
	    	  	System.out.println("member.userid : " + authinfo.getUserId());
	
	    	  	if("".equals(authinfo.getUserId()) || authinfo == null){
	    	  		// 글쓴이 id와 현재 세션의 id를 비교
	    	  	} //end if
	    	 
	      }catch(NullPointerException e){
	    	 System.out.println("NullPointerException catch에 걸림.");
	    	 System.out.println("Advice : 로그인을 하시오");
	    	 return "redirect:/login";
	      }
		          
         // pointcut으로 지정된 메소드를 proceed() 메소드로 실행.
         Object result = joinPoint.proceed();
		         
		 System.out.println("#### LoginAspect 끝 ####");
		 
         return result;
	     } //end loginCheck 
	 
} //end Class