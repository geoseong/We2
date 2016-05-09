package com.we2.studyroom.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.we2.studyroom.dto.StudyRoomVO;
import com.we2.studyroom.dao.StudyRoomDAO;

@WebServlet("/List.do")
public class studyRoomList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudyRoomDAO rDao=StudyRoomDAO.getInstance();
		List<StudyRoomVO> studyroomList = null;
		studyroomList= rDao.selectAllStudyRooms();
		
		
		request.setAttribute("studyroomList", studyroomList);
		request.setAttribute("roomshare", "StudyRoomList.jsp");
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("Studyroom/shareArea.jsp");
		dispatcher.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String rlocation =request.getParameter("location");		
		String rlocationdetail = request.getParameter("type");
		
			System.out.println("rlocation : " + rlocation);
			System.out.println("rlocationdetail : " + rlocationdetail);
		
		StudyRoomDAO rDao = StudyRoomDAO.getInstance();
		List<StudyRoomVO> studyroomList = rDao.searchStudyRoom(rlocation, rlocationdetail);		
	
		request.setAttribute("studyroomList", studyroomList);	
	    request.setAttribute("roomshare", "StudyRoomList.jsp");
		
		RequestDispatcher dispatcher= request
				.getRequestDispatcher("Studyroom/shareArea.jsp");
		dispatcher.forward(request, response);
}
}