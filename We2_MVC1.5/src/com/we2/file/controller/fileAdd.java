package com.we2.file.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.we2.file.dao.FileDAO;
import com.we2.file.dto.FileVO;


@WebServlet("/fAdd.do")
public class fileAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher= request
				.getRequestDispatcher("File/FileAdd.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		 //�씠踰덉뿏 �뙆�씪怨� 愿��젴�맂 �뙆�씪硫뷀꽣瑜� 媛��졇�삩�떎.
		   Enumeration files = multi.getFileNames();
		   
		   String filename = null;
		   //�씠踰덉뿏 �뙆�씪愿��젴 �뙆�씪硫뷀꽣瑜� 爰쇰궡蹂몃떎...
		   while(files.hasMoreElements()){
		      String name = (String)files.nextElement();//�뙆�씪硫뷀꽣�씠由꾩쓣 媛��졇�삩�뮘
		      filename = multi.getFilesystemName(name);//�씠由꾩쓣 �씠�슜�빐 ���옣�맂 �뙆�씪�씠由꾩쓣 媛��졇�삩�떎.
		      System.out.println("name : " + name);
		      System.out.println("�떎�젣 �뙆�씪 �씠由� : " + filename);
	      }
		      
		String fname = multi.getParameter("fname");
		//String fileurl = multi.getParameter("fileurl");		
		
		FileVO fVo = new FileVO();		
			fVo.setFname(fname);
			fVo.setFileurl(filename);			
			
		FileDAO pDao = FileDAO.getInstance();
		pDao.insertFile(fVo);
		response.sendRedirect("message.jsp");
	}
}
