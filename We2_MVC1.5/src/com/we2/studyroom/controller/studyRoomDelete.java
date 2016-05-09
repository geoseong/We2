package com.we2.studyroom.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.we2.studyroom.dao.StudyRoomDAO;
import com.we2.studyroom.dto.StudyRoomVO;



@WebServlet("/Delete.do")
public class studyRoomDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 회원 로그인여부 검사.
		if(session.getAttribute("loginUser")==null){
			response.sendRedirect("Studyroom/mustlogon.jsp");
		}else{	
			String rcode=request.getParameter("rcode");
			
			StudyRoomDAO rDao = StudyRoomDAO.getInstance();
			StudyRoomVO rVo = rDao.selectStudyRoomByCode(rcode);
			
		
		
			request.setAttribute("studyroomList", rVo);	
			RequestDispatcher dispatcher= request
					.getRequestDispatcher("Studyroom/StudyRoomDelete.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String rcode=request.getParameter("rcode");		
		StudyRoomDAO rDao=StudyRoomDAO.getInstance();
		rDao.deleteStudyRoom(rcode);		
		
		response.sendRedirect("Studyroom/delete.jsp");
	}

}
