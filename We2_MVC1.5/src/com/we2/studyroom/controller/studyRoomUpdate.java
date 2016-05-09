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

@WebServlet("/Update.do")
public class studyRoomUpdate extends HttpServlet {
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
					.getRequestDispatcher("Studyroom/StudyRoomUpdate.jsp");
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
		String rcode=multi.getParameter("rcode");
		String rname = multi.getParameter("rname");
		String rlocation =multi.getParameter("location");		
		String rlocationdetail = multi.getParameter("type");
		int rmember = Integer.parseInt(multi.getParameter("rmember"));
		String rcontent = multi.getParameter("rcontent");
		String rpictureurl = multi.getFilesystemName("rpictureurl");
		
		System.out.println("rcode - "+rcode);	
		System.out.println("rname - "+rname);
		System.out.println("rlocation - "+rlocation);
		System.out.println("rlocationdetail - "+rlocationdetail);
		System.out.println("rmember - "+rmember);
		System.out.println("rcontent - "+rcontent);		
		System.out.println("rpictureurl - "+rpictureurl);
		
		
		StudyRoomVO rVo = new StudyRoomVO();		
		rVo.setRcode(Integer.parseInt(rcode));
		rVo.setRname(rname);
		rVo.setRlocation(rlocation);
		rVo.setRlocationdetail(rlocationdetail);
		rVo.setRmember(rmember);
		rVo.setRcontent(rcontent);
		rVo.setRpictureurl(rpictureurl);
		
		StudyRoomDAO rDao = StudyRoomDAO.getInstance();
		rDao.updateStudyRoom(rVo);
		
		
		response.sendRedirect("Studyroom/close.jsp");
		
		
	}

}
