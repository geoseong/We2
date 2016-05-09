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
		/* 프로젝트 메인페이지의 가운데영역에 뿌려질 첫화면인자를 미리받아서 request영역에 보냄*/
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser")==null){
			response.sendRedirect("index.jsp");
		}else{	
		//프로젝트 코드를 받는다.
		String pjtcode=request.getParameter("pjtcode");
		
		PjtMakeDAO pDao = PjtMakeDAO.getInstance();
		PjtMakeVO pVo = pDao.selectuserpjt(pjtcode);
		
		
		session.setAttribute("project", pVo);

		 request.setAttribute("page", "../notice/list.jsp");
		 
		 // 이동하고자 하는 프로젝트 메인 jsp 변수로 정의.
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
