package com.we2.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.we2.registration.dao.We2_MemberDAO;
import com.we2.registration.dto.We2_MemberVO;

@WebServlet("/We2_login.do")//jsp���� ���۵� ������ ������̼����� �޴�	��..
public class We2_LoginServlet extends HttpServlet { //�ֻ��� ��ü�� httpservlet�� ���� ����� �޴´�.
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		
		//String url = "com_we2_registration_jsp	/We2_login.jsp";
		String url = "/index.jsp";
			// ��� ������ �׻� ��ҹ��ڸ� ��������!!
		HttpSession session = request.getSession();
			// ����� ������ session�� �ҷ� ���̱� ���� �ν��Ͻ�ȭ�� �Ͽ� ������ �������ϰ� ���� if���� ���� �װ��� ����
		if (session.getAttribute("loginUser") != null) {
			//url = "com_we2_registration_jsp/We2_main.jsp";
		}else{
			request.setAttribute("message", "�α��� �� �̿��� �ּ���.");	
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		} // �׻� ��� { �� �����ְ� ������ �ִ��� Ȯ���� �Ұ�!! 
// �̱��� ������ �� ���� ��ü�� �����ϰ� ��� ������ �Ѵ�. client�� ��û�� service���� ����ؼ� �����ϰ� ��
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "/index.jsp";
		// post������� �Ѿ�°��� url�� ���� ������ �Ѵ�.
		request.setCharacterEncoding("UTF-8");

		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		//parameter�� userid�� pwd�� ������ �����ͼ� String ������ ��´�.~~
		We2_MemberDAO mDao = We2_MemberDAO.getInstance();
		int result = mDao.userCheck(userid, pwd);
		HttpSession session = request.getSession();
		
		if (result == 1) {
			
			We2_MemberVO mVo = mDao.getMember(userid);

			session.setAttribute("loginUser", mVo);
			
			request.setAttribute("message", "�ȳ��ϼ���!"+mVo.getUserid()+"��.");
			
			//url = "com_we2_registration_jsp/We2_main.jsp";
			url = "/index.jsp";
			
		} else if (result == 0) {
			//url="alert/notmatch.jsp";
	
		} else if (result == -1) {
			//url="alert/notexist.jsp";
			request.setAttribute("message", "�������� �ʴ� ȸ���Դϴ�.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

		}
	}