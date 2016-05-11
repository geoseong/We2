package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;

public class AOP_Aspect {

	public void letsgoaop(){
		System.out.println("AOP:Before설정 메시지");
	}
	
	
	 public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		 
		 System.out.println("#### LoginAspect 시작 ####");     
		 
         HttpServletRequest request = null;
         HttpServletResponse response = null;
		         
	         for ( Object o : joinPoint.getArgs() ){ 
	             if ( o instanceof HttpServletRequest ) {
	                 request = (HttpServletRequest)o;
	             } //end if
	             if ( o instanceof HttpServletResponse ) {
	                 response = (HttpServletResponse)o;
	             } //end if
	         } //end for
		 
                 
	       try{
	    	   HttpSession session =request.getSession();
               if(session==null){
		        	 System.out.println("Advice : 로그인 자체가 안되어 있음");
               }else{
	             if(session.getAttribute("authInfo")==null){
	            	System.out.println("Advice : authInfo 세션 객체가 영역에 없음."); 
	            	response.sendRedirect(request.getContextPath() + "/login");
	             } // end if
               } //end if
	               
	               /* String userEnterType = (String) session.getAttribute("UserEnterType");
	  
	                System.out.println("### Margo ==> loginId : " + loginId);
	                 if (loginId == null || "".equals(loginId)) {
	                     System.out.println("### Margo ==> in if loginId : "
	                             + loginId);
	                     throw new RuntimeException("먼저 로그인을 하셔야 합니다.");
	                 }   //end if  	
*/	         }catch(Exception e){
					System.out.println("런타임에러?");
		             //throw new RuntimeException("먼저 로그인을 하셔야 합니다.");
					response.sendRedirect(request.getContextPath() + "/login");
	         } // end try-catch
	         
         
         // pointcut으로 지정된 메소드를 proceed() 메소드로 실행.
         Object result = joinPoint.proceed();
		         
		 System.out.println("#### LoginAspect 끝 ####");
		 
         return result;
	     } //end loginCheck 
	 
} //end Class