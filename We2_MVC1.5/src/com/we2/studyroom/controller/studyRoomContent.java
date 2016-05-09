package com.we2.studyroom.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.we2.studyroom.dao.StudyRoomDAO;
import com.we2.studyroom.dto.StudyRoomVO;

/**
 * Servlet implementation class studyRoomContent
 */
@WebServlet("/Content.do")
public class studyRoomContent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rcode=request.getParameter("rcode");
		
		StudyRoomDAO rDao = StudyRoomDAO.getInstance();
		StudyRoomVO rVo = rDao.selectStudyRoomByCode(rcode);
	
		request.setAttribute("studyroomList", rVo);
		RequestDispatcher dispatcher= request
				.getRequestDispatcher("Studyroom/StudyRoomContent.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit,
				encType, new DefaultFileRenamePolicy());
		int rcode=Integer.parseInt( multi.getParameter("rcode"));
		String rname = multi.getParameter("rname");
		String rlocation =multi.getParameter("rlocation");		
		String rlocationdetail = multi.getParameter("rlocationdetail");
		int rmember = Integer.parseInt(multi.getParameter("rmember"));
		String rcontent = multi.getParameter("rcontent");
		String rpictureurl = multi.getFilesystemName("rpictureurl");
		
		StudyRoomVO rVo = new StudyRoomVO();	
		rVo.setRcode(rcode);
		rVo.setRname(rname);
		rVo.setRlocation(rlocation);
		rVo.setRlocationdetail(rlocationdetail);
		rVo.setRmember(rmember);
		rVo.setRcontent(rcontent);
		rVo.setRpictureurl(rpictureurl);
		StudyRoomDAO pDao = StudyRoomDAO.getInstance();
		pDao.insertStudyRoom(rVo);
		response.sendRedirect("List.do");
		
	}

}
