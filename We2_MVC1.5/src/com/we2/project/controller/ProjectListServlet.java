package com.we2.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.we2.project.dao.ProjectDAO;
import com.we2.project.dto.ProjectVO;

/**
 * Servlet implementation class ProjectListServlet
 */
@WebServlet("/ProjectList")
public class ProjectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectDAO pDao = ProjectDAO.getInstance();		//�ܺΰ�ü�κ��� �̱��������� ��ü ����.
		
		List<ProjectVO> productList = pDao.selectAllProducts();
		request.setAttribute("productList", productList);		//List<ProjectVO> ��ü�� pjts ���̺��� ��� ������Ʈ���� ����
		
		String rmv=request.getParameter("pjtname");	//�����ϰ��� �ϴ� ������Ʈ�� pjtname�� �޴´�.
		pDao.removePjt(rmv);
		
		System.out.println(productList.size());
		RequestDispatcher dispatch = request.getRequestDispatcher("Project/Projects.jsp");
		dispatch.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
