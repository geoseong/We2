package com.we2.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.we2.project.dao.PjtMakeDAO;
import com.we2.project.dao.WillWorkDAO;
import com.we2.project.dto.PjtMakeVO;
import com.we2.registration.dto.We2_MemberVO;

@WebServlet("/pjtmake.do")
public class pjtMakeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser")==null){
			request.setAttribute("message", "로그인 하고 다시 이용해 주세요.");
			response.sendRedirect("/We2/index.jsp");			
		}else{

			PjtMakeDAO pDao = PjtMakeDAO.getInstance();
			
			List<PjtMakeVO> pjtMake = pDao.selectAll();
			request.setAttribute("pjtMake", pjtMake);
			
	
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Project/pjtMake.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		We2_MemberVO mVo = (We2_MemberVO) session.getAttribute("loginUser");
		
		request.setCharacterEncoding("UTF-8");
		
		if(session.getAttribute("loginUser")==null){
			request.setAttribute("message", "로그인 하고 다시 이용해 주세요.");
			response.sendRedirect("/We2/index.jsp");			
		}else{
			
			String pjtName = request.getParameter("pjtName");
			String pjtClassify = request.getParameter("classify");
			String term1 = request.getParameter("term1");
			String term2 = request.getParameter("term2");
			String userId = mVo.getUserid();
			String name = mVo.getName();
			
			PjtMakeVO pVo = new PjtMakeVO();
			//pVo.setPjtCode(pjtCode);
			pVo.setPjtName(pjtName);
			pVo.setPjtClassify(pjtClassify);
			pVo.setStartDate(term1);
			pVo.setEndDate(term2);
			pVo.setUserId(userId);
			
			PjtMakeDAO pDao = PjtMakeDAO.getInstance();
			pDao.insertPjtMake(pVo);
			
			pDao.insertWillworkmake(userId, name);
			response.sendRedirect("/We2/index.jsp");
		}
	}
}
