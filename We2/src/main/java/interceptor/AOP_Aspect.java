package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AOP_Aspect {

	public void letsgoaop(){
		System.out.println("AOP:Before설정 메시지");
	}
	
	public boolean logincheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		if(session != null){
			Object authInfo = session.getAttribute("authInfo");
			if(authInfo != null){
				return true;
			}
		} //end if
		response.sendRedirect(request.getContextPath() + "/login");
		return false;
	} //end preHandle;
}
