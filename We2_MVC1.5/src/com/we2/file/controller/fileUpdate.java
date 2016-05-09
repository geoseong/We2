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


@WebServlet("/fUpdate.do")
public class fileUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			String fcode=request.getParameter("fcode");
			
			FileDAO fDao = FileDAO.getInstance();
			FileVO fVo = fDao.selectFileByCode(fcode);
			System.out.println("fcode"+fcode);
			request.setAttribute("fileList", fVo);
			RequestDispatcher dispatcher= request
					.getRequestDispatcher("File/FileUpdate.jsp");
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
		
		String fcode=multi.getParameter("fcode");
		String fname = multi.getParameter("fname");
		//String fileurl =multi.getParameter("fileurl");		
		//String fdate = multi.getParameter("fdate");

		System.out.println("filename - " + filename);
		System.out.println("fcode - "+fcode);	
		System.out.println("rname - "+fname);
		//System.out.println("fileurl - "+fileurl);
		//System.out.println("fdate - "+fdate);
			
		
		FileVO fVo = new FileVO();		
		fVo.setFcode(Integer.parseInt(fcode));
		fVo.setFname(fname);
		fVo.setFileurl(filename);
		//fVo.setFdate(fdate);
	
		FileDAO rDao = FileDAO.getInstance();
		rDao.updateFile(fVo);
		
		request.setAttribute("msg", "�뙆�씪 �닔�젙�씠 �셿猷뚮릺�뿀�뒿�땲�떎.");
		
		response.sendRedirect("File/message.jsp");
	}
}
