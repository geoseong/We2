package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SchedulePageServlet
 */
@WebServlet("/DateSchedule")
public class SchedulePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // 파라미터 받는다. - 프로젝트코드
	    String pjtcode = request.getParameter("pjtcode");
	    System.out.println("pjtcode : " + pjtcode);
	    
	    request.setAttribute("page", "/Scheduler/Calendar.jsp");
	    RequestDispatcher dispatcher = request.getRequestDispatcher("Project/02_project.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
