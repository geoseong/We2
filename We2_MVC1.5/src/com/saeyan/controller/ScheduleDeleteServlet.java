


package com.saeyan.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.ScheduleDAO;
import com.saeyan.dto.ScheduleVO;

/**
 * Servlet implementation class ScheduleDeleteServlet
 */
@WebServlet("/DateDelete.do")
public class ScheduleDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String calendarmemo_num = request.getParameter("calendarmemo_num");
		
		ScheduleDAO sDao = ScheduleDAO.getInstance();
		ScheduleVO sVo = sDao.selectScheduleByCalendarmemo_num(calendarmemo_num);
		
		request.setAttribute("calendarmemo", sVo);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("Scheduler/memoDelete.jsp");
		dispatcher.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String calendarmemo_num = request.getParameter("calendarmemo_num");
		ScheduleDAO sDao= ScheduleDAO.getInstance();
		sDao.	deleteSchedule(calendarmemo_num);
		
		response.sendRedirect("/We2/Scheduler/message.jsp");
		
}}