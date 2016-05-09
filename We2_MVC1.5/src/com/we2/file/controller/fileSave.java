package com.we2.file.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.we2.file.dao.FileDAO;
import com.we2.file.dto.FileVO;



@WebServlet("/fSave.do")
public class fileSave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fcode=request.getParameter("fcode");
		
		FileDAO fDao = FileDAO.getInstance();
		FileVO fVo = fDao.selectFileByCode(fcode);

		request.setAttribute("fileList", fVo);
		RequestDispatcher dispatcher= request
				.getRequestDispatcher("File/File.jsp");
		dispatcher.forward(request, response);
				
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 request.setCharacterEncoding("UTF-8");
		 
	        // �떎�슫諛쏆쓣 �뙆�씪�쓽 �씠由꾩쓣 媛��졇�샂
	        String bFile=request.getParameter("bFile");
	        //�떎�슫諛쏆쓣 �뙆�씪�씠 ���옣�릺�뼱 �엳�뒗 �뤃�뜑 �씠由�
	        String path=request.getRealPath("upload/");
	 
	 
	        // �떎�슫諛쏆쓣 �뙆�씪�쓽 �쟾泥� 寃쎈줈瑜� filePath�뿉 ���옣
	        String filePath = path + bFile;
	 
	        // �떎�슫諛쏆쓣 �뙆�씪�쓣 遺덈윭�샂
	        File file = new File(filePath);
	        byte b[] = new byte[4096];
	 
	        // page�쓽 ContentType�벑�쓣 �룞�쟻�쑝濡� 諛붽씀湲� �쐞�빐 珥덇린�솕�떆�궡
	        response.reset();
	        response.setContentType("application/octet-stream");
	 
	        // �븳湲� �씤肄붾뵫
	        String Encoding = new String(bFile.getBytes("UTF-8"), "8859_1");
	        
	        // �뙆�씪 留곹겕瑜� �겢由��뻽�쓣 �븣 �떎�슫濡쒕뱶 ���옣 �솕硫댁씠 異쒕젰�릺寃� 泥섎━�븯�뒗 遺�遺�
	        response.setHeader("Content-Disposition", "attachment; filename = " + Encoding);
	 
	        // �뙆�씪�쓽 �꽭遺� �젙蹂대�� �씫�뼱�삤湲� �쐞�빐�꽌 �꽑�뼵
	        FileInputStream in = new FileInputStream(filePath);
	 
	        // �뙆�씪�뿉�꽌 �씫�뼱�삩 �꽭遺� �젙蹂대�� ���옣�븯�뒗 �뙆�씪�뿉 �뜥二쇨린 �쐞�빐�꽌 �꽑�뼵
	        ServletOutputStream out2 = response.getOutputStream();
	 
	        int numRead;
	        // 諛붿씠�듃 諛곗뿴 b�쓽 0踰� 遺��꽣 numRead踰� 源뚯� �뙆�씪�뿉 �뜥以� (異쒕젰)
	        while((numRead = in.read(b, 0, b.length)) != -1){
	            out2.write(b, 0, numRead);
	        }
	        
	         out2.flush();
	         out2.close();
	         in.close();
	 
	        return ;
	    }
	 
	}
	 
