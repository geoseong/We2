package com.we2.studyroom.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.we2.studyroom.dao.StudyRoomDAO;
import com.we2.studyroom.dto.StudyRoomVO;


@WebServlet("/Write.do")
public class studyRoomWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		// 회원 로그인여부 검사.
		if(session.getAttribute("loginUser")==null){
			response.sendRedirect("Studyroom/mustlogon.jsp");
		}else{	
			RequestDispatcher dispatcher= request
					.getRequestDispatcher("Studyroom/StudyRoomWrite.jsp");
			dispatcher.forward(request, response);
		}
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		
			ServletContext context = getServletContext();
			String path = context.getRealPath("upload");
			String encType = "UTF-8";
			int sizeLimit = 20 * 1024 * 1024;
			
			MultipartRequest multi = new MultipartRequest(request, path, sizeLimit,
					encType, new DefaultFileRenamePolicy());
			
			
			String rname = multi.getParameter("rname");
			int rmember = Integer.parseInt(multi.getParameter("rmember"));
			String rcontent = multi.getParameter("rcontent");
			String rpictureurl = multi.getFilesystemName("rpictureurl");		
			String rlocation = multi.getParameter("location");
			String rlocationdetail = multi.getParameter("type");
			
			StudyRoomVO rVo = new StudyRoomVO();		
				rVo.setRname(rname);
				rVo.setRlocation(rlocation);			
				rVo.setRlocationdetail(rlocationdetail);
				rVo.setRmember(rmember);
				rVo.setRcontent(rcontent);
				rVo.setRpictureurl(rpictureurl);
			StudyRoomDAO pDao = StudyRoomDAO.getInstance();
			pDao.insertStudyRoom(rVo);
			response.sendRedirect("Studyroom/close.jsp");
		}
	

	}


