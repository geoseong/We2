package com.we2.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.we2.registration.dao.We2_MemberDAO;
import com.we2.registration.dto.We2_MemberVO;

@WebServlet("/We2_login.do")//jsp에서 전송된 파일을 어노테이션으로 받는	다..
public class We2_LoginServlet extends HttpServlet { //최상위 객체인 httpservlet을 통해 상속을 받는다.
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		
		//String url = "com_we2_registration_jsp	/We2_login.jsp";
		String url = "/index.jsp";
			// 경로 설정시 항상 대소문자를 주의하자!!
		HttpSession session = request.getSession();
			// 허공에 떠도는 session을 불러 들이기 위해 인스턴스화를 하여 정보를 가져와하고 이후 if문을 통해 그것을 실행
		if (session.getAttribute("loginUser") != null) {
			//url = "com_we2_registration_jsp/We2_main.jsp";
		}else{
			request.setAttribute("message", "로그인 후 이용해 주세요.");	
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		} // 항상 몇개의 { 이 열어있고 닫혀져 있는지 확인을 할것!! 
// 싱글톤 서블릿은 한 개의 객체만 생성하고 계속 재사용을 한다. client의 요청시 service에서 계속해서 실행하게 됨
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "/index.jsp";
		// post방식으로 넘어온것을 url을 통해 전송을 한다.
		request.setCharacterEncoding("UTF-8");

		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		//parameter로 userid와 pwd의 정보를 가져와서 String 형으로 담는다.~~
		We2_MemberDAO mDao = We2_MemberDAO.getInstance();
		int result = mDao.userCheck(userid, pwd);
		HttpSession session = request.getSession();
		
		if (result == 1) {
			
			We2_MemberVO mVo = mDao.getMember(userid);

			session.setAttribute("loginUser", mVo);
			
			request.setAttribute("message", "안녕하세요!"+mVo.getUserid()+"님.");
			
			//url = "com_we2_registration_jsp/We2_main.jsp";
			url = "/index.jsp";
			
		} else if (result == 0) {
			//url="alert/notmatch.jsp";
	
		} else if (result == -1) {
			//url="alert/notexist.jsp";
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

		}
	}