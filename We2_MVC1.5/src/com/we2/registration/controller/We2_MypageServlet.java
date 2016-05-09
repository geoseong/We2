package com.we2.registration.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.we2.registration.dao.We2_MemberDAO;
import com.we2.registration.dto.We2_MemberVO;

@WebServlet("/We2_mypage.do")
public class We2_MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		We2_MemberVO emp = (We2_MemberVO) session.getAttribute("loginUser");
		
		if (emp != null) {
			String url = "com_we2_registration_jsp/We2_mypage_confirm.jsp";

			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("/We2/We2_login.do");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		We2_MemberVO member = new We2_MemberVO();

		We2_MemberVO emp = (We2_MemberVO) session.getAttribute("loginUser");
		member.setUserid(emp.getUserid());
		member.setPwd(request.getParameter("pwd"));
		member.setName(emp.getName());
		member.setEmail(request.getParameter("email"));
		member.setSub_email(request.getParameter("sub_email"));
		member.setPhone(request.getParameter("phone"));
		
		if (request.getParameter("gender") != null)
			member.setGender(Integer.parseInt(request.getParameter("gender").trim()));

		We2_MemberDAO mDao = We2_MemberDAO.getInstance();
		mDao.updateMember(member);


		request.setAttribute("member", emp);
		request.setAttribute("message", "회원 정보가 수정되었습니다.");

		session.setAttribute("loginUser", emp);
		
		int result = mDao.userCheck(member.getUserid(), member.getPwd());
		session.setAttribute("result", result);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
}
