package com.we2.project.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.we2.project.dao.ProjectDAO;

/**
 * Servlet implementation class FileExport
 */
@WebServlet("/PjtAdd")
public class PjtAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// page forward
		RequestDispatcher dispatcher=request.getRequestDispatcher("Project/PjtAdd.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���θ���� ������Ʈ �̸��� �Ķ���ͷ� �޴´�.
			String getname=request.getParameter("pjt");
			
		// ���� �������� ������Ʈ�� ����� ���� - getpath
			String svlPath=getServletContext().getRealPath("./");		
				System.out.println(svlPath);
			
			File getfile = new File(svlPath);
			String getpath = getfile.getParentFile().getParentFile().getParentFile().getParentFile().getParentFile().getParentFile().toString();
				System.out.println(getpath);
			
		// 0. �̸��۾�
			// �̸� �Ǿձ��ڸ� �빮�ڷ� ����� �۾�.
			String pjtfront1=getname.substring(0, 1);
			String initupper=pjtfront1.toUpperCase();
			
			// �̸��� �ι�° ���ں��� �������������� �����ؼ� �տ� ��ȯ�� �빮�� ù���ڿ� ��ħ
			String pjtlast=getname.substring(1, getname.length());
			String filename=initupper + pjtlast;
		
		// �� FileCopyControl���� ��ü �ν��Ͻ�ȭ
			PjtCtrler fCopy = new PjtCtrler();
			
		// �� ProjectDAO���� ��ü �ν��Ͻ�ȭ - DB������ ����.
			ProjectDAO pDao = ProjectDAO.getInstance();
			
		// 1. ������Ʈ �����̸� �ߺ��˻�
			int result=pDao.checkName(filename);			
			
			if(result==1){
				// 1-1. WebContent ����. 
				//slc : �������ϰ��, tlc : ��������ϰ��
					File slc=new File(getpath+"/We2/WebContent/Project/We2_page/");
					File tlc=new File(getpath+"/We2/WebContent/Project/" + filename);					
					fCopy.setFileCopy(slc, tlc);
					
				// 1-2. ������Ʈ ����Ʈ DB�� ����ϱ�
				pDao.insertMember(filename);
				request.setAttribute("result", "������Ʈ ������ �����Ͽ����ϴ�.");
			}else{
				request.setAttribute("result", "�̹� �����ϴ� ������Ʈ �̸��Դϴ�. �ٽ� �õ��� �ּ���.");
			}
		
		// Tomcat���� Refresh.
			//2. ��Ĺ�� ���� Refresh�� ���� �ӽù������� jar������ WEB-INF/lib/ �ȿ� Copy�� �Ѵ�. �� 10�� �ɸ��� ����.	
			// sourcecopy : jar�� �����ϴ� ��� , sourcepaste : WEB-INF/lib/
			File sourcecopy = new File(getpath+"/We2/WebContent/ojdbc5.jar");
			File sourcepaste = new File(getpath+"/We2/WebContent/WEB-INF/lib/ojdbc5.jar");
			fCopy.setFileCopy(sourcecopy, sourcepaste);
			fCopy.tempDel(sourcepaste); 
		
		// attribute�� ��� jsp�������� �̵�
		RequestDispatcher dispatcher=request.getRequestDispatcher("/Project/PjtAdd.jsp");
		dispatcher.forward(request, response);
	}

}
