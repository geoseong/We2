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

@WebServlet("/We2_join.do")
public class We2_JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("com_we2_registration_jsp/We2_join.jsp");
		dispatcher.forward(request, response);
	}// 로그인폼으로부터 get방식으로 동의할시에  join서블릿으로 온다.!!!!
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String sub_email = request.getParameter("sub_email");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
	
		We2_MemberVO mVo= new We2_MemberVO();
		mVo.setName(name);
		mVo.setUserid(userid);
		mVo.setPwd(pwd);
		mVo.setEmail(email);
		mVo.setSub_email(sub_email);
		mVo.setPhone(phone);
		mVo.setGender(Integer.parseInt(gender));	
		
		We2_MemberDAO mDao=We2_MemberDAO.getInstance();
		
		int result=mDao.insertMember(mVo);
		 
		HttpSession session=request.getSession();
		
		if(result==1){
			session.setAttribute("userid",mVo.getUserid());
			request.setAttribute("message","회원 가입에 성공했습니다.");
		}else{
			request.setAttribute("message", "회원가입에 실패했습니다.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	dispatcher.forward(request, response);
	}
}

