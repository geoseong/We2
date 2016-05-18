package interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class AOPException {

	public AOPException(){
		super();
	}
	
	public AOPException(String err, Exception exception, HttpServletResponse response) throws IOException{
		PrintWriter out=response.getWriter();
		out.println("<script type='text/javascript'>");
	   	 out.println("	alert('AOP에서 에러뿌림.'); ");
	   	 out.println("</script>");
	   	 response.sendRedirect("/login"); /*"redirect:/login";*/
	}
}
