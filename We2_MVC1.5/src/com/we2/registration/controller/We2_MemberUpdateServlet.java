package com.we2.registration.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.jrockit.jfr.RequestDelegate;
import com.we2.registration.dao.We2_MemberDAO;
import com.we2.registration.dto.We2_MemberVO;

@WebServlet("/We2_MemberUpdate.do")
public class We2_MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		
		com.we2.registration.dao.We2_MemberDAO mDao = com.we2.registration.dao.We2_MemberDAO.getInstance();

		com.we2.registration.dto.We2_MemberVO mVo = mDao.getMember(userid);
		request.setAttribute("mVo", mVo);

		RequestDispatcher dispatcher = request.getRequestDispatcher("com_we2_registration_jsp/We2_memberUpdate.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String sub_email = request.getParameter("sub_email");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
     
		com.we2.registration.dto.We2_MemberVO mVo = new com.we2.registration.dto.We2_MemberVO();
		mVo.setUserid(userid);
		mVo.setPwd(pwd);
		mVo.setEmail(email);
		mVo.setSub_email(sub_email);
		mVo.setPhone(phone);
		mVo.setGender(Integer.parseInt(gender));

		com.we2.registration.dao.We2_MemberDAO mDao = com.we2.registration.dao.We2_MemberDAO.getInstance();

		mDao.updateMember(mVo);
		response.sendRedirect("/We2/We2_login.do");
	}
}