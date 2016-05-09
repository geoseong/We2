package com.we2.registration.controller;

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
import com.we2.project.dto.PjtMakeVO;
import com.we2.registration.dao.We2_MemberDAO;
import com.we2.registration.dto.We2_MemberVO;

/**
 * Servlet implementation class We2_mypage_confirm
 */
@WebServlet("/We2_mypage_confirm.do")
public class We2_mypage_confirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		We2_MemberVO mVo = (We2_MemberVO)session.getAttribute("loginUser");
		// �α��� ������ ���� �ִ� ��ü�� session����������������, �� ��ü���� getter �޼ҵ� ���. 
		String userid = mVo.getUserid();
			System.out.println("doPost : userid - " + userid);
			
		// ȸ�� ������ ����.
		request.setAttribute("mVo", mVo);
		
		//���� form�� name = key ���� �޾ƿ�.
		String pwd = request.getParameter("pwd");		
			System.out.println("doPost : pwd : " + pwd);
			
	
		try {
			if (pwd != null) {	// pwd�� null�� �ƴϸ�
				// SQL�� �������� ��ü �ν��Ͻ�ȭ
				We2_MemberDAO mDao = We2_MemberDAO.getInstance();
								
				int result = mDao.confirmMember(userid,pwd);
				
				System.out.println("result�� : " + result);

				if (result==1){
					PjtMakeDAO pDAO = PjtMakeDAO.getInstance();
					List<PjtMakeVO> pjtlist = pDAO.selectUserpjts(userid);
					request.setAttribute("pjtlist", pjtlist);
					
					request.setAttribute("message", "We2 �����������Դϴ�. ^^.");	
					//RequestDispatcher dispatcher = request.getRequestDispatcher("com_we2_registration_jsp/We2_mypage.jsp");
					RequestDispatcher dispatcher = request.getRequestDispatcher("com_we2_registration_jsp/01_1_mypage.jsp");
					
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("message", "We2 �������������ӿ� �����߽��ϴ�.");
					
					// �ٸ��������� �̵���Ű�� �ڵ� �߰�.
					response.sendRedirect("We2_login.do");
				} //end if
			} else {
				request.setAttribute("message", "��й�ȣ��  ���� �Է� ���ּ���");				
				response.sendRedirect("com_we2_registration_jsp/We2_mypage_confirm.jsp");
			}
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("message", "�߸��� �����Դϴ� �ٽ� �õ����ּ���");
		}

	}
}