package com.we2.file.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.we2.file.dao.FileDAO;
import com.we2.file.dto.FileVO;


@WebServlet("/fDelete.do")
public class fileDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fcode=request.getParameter("fcode");
		
		FileDAO fDao = FileDAO.getInstance();
		FileVO fVo = fDao.selectFileByCode(fcode);

		request.setAttribute("fileList", fVo);
		RequestDispatcher dispatcher= request
				.getRequestDispatcher("File/FileDelete.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fcode=request.getParameter("fcode");		
		FileDAO rDao=FileDAO.getInstance();
		rDao.deleteFile(fcode);		
		response.sendRedirect("File/message.jsp");
	}

}
