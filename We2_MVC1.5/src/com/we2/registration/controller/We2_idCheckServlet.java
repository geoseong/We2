package com.we2.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.we2.registration.dao.We2_MemberDAO;

@WebServlet("/We2_idCheck.do")
public class We2_idCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");

		com.we2.registration.dao.We2_MemberDAO mDao = com.we2.registration.dao.We2_MemberDAO.getInstance();

		int result = mDao.confirmID(userid);

		request.setAttribute("userid", userid);
		request.setAttribute("result", result);

		RequestDispatcher dispatcher = request.getRequestDispatcher("com_we2_registration_jsp/We2_idCheck.jsp");
		dispatcher.forward(request, response);
	}
}