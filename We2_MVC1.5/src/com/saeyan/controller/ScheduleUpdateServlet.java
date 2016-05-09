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
 * Servlet implementation class ScheduleUpdateServlet
 */
@WebServlet("/DateUpdate.do")
public class ScheduleUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String calendarmemo_num = request.getParameter("calendarmemo_num");
			System.out.println("calendarmemo_num : " + calendarmemo_num);
			
		ScheduleDAO sDao = ScheduleDAO.getInstance();
		ScheduleVO sVo = sDao.selectScheduleByCalendarmemo_num(calendarmemo_num);
		
		System.out.println("異쒕젰�뀒�뒪�듃getCalendarmemo_day ::::: "+sVo.getCalendarmemo_day());
		
		request.setAttribute("calendarmemo", sVo);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("Scheduler/memoUpdate.jsp");
		dispatcher.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException  {
		request.setCharacterEncoding("UTF-8");

		
		
		String calendarmemo_num = request.getParameter("calendarmemo_num");
		int calendarmemo_year = Integer.parseInt(request.getParameter("calendarmemo_year"));
		int calendarmemo_month = Integer.parseInt(request.getParameter("calendarmemo_month"));
		int calendarmemo_day = Integer.parseInt(request.getParameter("calendarmemo_day"));
		String calendarmemo_contents = request.getParameter("calendarmemo_contents");
		/*String calendarmemo_id = request.getParameter("calendarmemo_id");
		String calendarmemo_passwd = request.getParameter("calendarmemo_passwd");
*/
		ScheduleVO sVo = new ScheduleVO();
		sVo.setCalendarmemo_num(Integer.parseInt(calendarmemo_num));
		sVo.setCalendarmemo_year(calendarmemo_year);
		sVo.setCalendarmemo_month(calendarmemo_month);
		sVo.setCalendarmemo_day(calendarmemo_day);
		sVo.setCalendarmemo_contents(calendarmemo_contents);
		/*sVo.setCalendarmemo_id(calendarmemo_id);
		sVo.setCalendarmemo_passwd(calendarmemo_passwd);*/
		ScheduleDAO sDao = ScheduleDAO.getInstance();
		sDao.updateSchedule(sVo);
	
		response.sendRedirect("/We2/Scheduler/message.jsp");
	}

}