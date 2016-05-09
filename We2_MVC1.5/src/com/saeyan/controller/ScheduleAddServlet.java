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
 * Servlet implementation class ScheduleAddServlet
 */
@WebServlet("/DateAdd.do")
public class ScheduleAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doget(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher= request
				.getRequestDispatcher("memoAdd.jsp");
		dispatcher.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	
		int calendarmemo_year = Integer.parseInt(request.getParameter("calendarmemo_year"));
		int calendarmemo_month = Integer.parseInt(request.getParameter("calendarmemo_month"));
		int calendarmemo_day = Integer.parseInt(request.getParameter("calendarmemo_day"));
		String calendarmemo_contents = request.getParameter("calendarmemo_contents");
		String pjtCode = request.getParameter("pjtcode");
		
		System.out.println("¼­ºí¸´ pjtcode " + pjtCode);
		System.out.println(calendarmemo_year);
		
		ScheduleVO sVo = new ScheduleVO();

		sVo.setCalendarmemo_year(calendarmemo_year);
		sVo.setCalendarmemo_month(calendarmemo_month);
		sVo.setCalendarmemo_day(calendarmemo_day);
		sVo.setCalendarmemo_contents(calendarmemo_contents);
		sVo.setPjtCode(pjtCode);
		
		ScheduleDAO sDao = ScheduleDAO.getInstance();
		sDao.insertSchedule(sVo);
	
		response.sendRedirect("/We2/Scheduler/message.jsp");
	}

}
