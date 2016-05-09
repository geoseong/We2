package com.we2.project.page;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.we2.project.dao.PjtMakeDAO;
import com.we2.project.dto.PjtMakeVO;

@WebServlet("/Project")
public class PageCtrler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* ������Ʈ ������������ ��������� �ѷ��� ùȭ�����ڸ� �̸��޾Ƽ� request������ ����*/
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser")==null){
			response.sendRedirect("index.jsp");
		}else{	
		//������Ʈ �ڵ带 �޴´�.
		String pjtcode=request.getParameter("pjtcode");
		
		PjtMakeDAO pDao = PjtMakeDAO.getInstance();
		PjtMakeVO pVo = pDao.selectuserpjt(pjtcode);
		
		
		session.setAttribute("project", pVo);

		 request.setAttribute("page", "../notice/list.jsp");
		 
		 // �̵��ϰ��� �ϴ� ������Ʈ ���� jsp ������ ����.
		String fwdpath =  "Project/02_project.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(fwdpath);					
		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
