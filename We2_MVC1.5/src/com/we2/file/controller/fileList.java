package com.we2.file.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.we2.file.dao.FileDAO;
import com.we2.file.dto.FileVO;


@WebServlet("/fList.do")
public class fileList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String FileList = request.getParameter("File");
		
		request.setAttribute("page", FileList);
		
		
		FileDAO fDao=FileDAO.getInstance();
		List<FileVO> fileList = fDao.selectAllFiles();
		request.setAttribute("fileList", fileList);
		
	/*request.setAttribute("roomshare", "FileList.jsp");*/
	
		RequestDispatcher dispatcher= request.getRequestDispatcher("/Project/02_project.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
