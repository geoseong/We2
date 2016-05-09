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

@WebServlet("/We2_deleteMember.do")

public class We2_deleteMember extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	HttpSession session = request.getSession();
	
	String url = "com_we2_registration_jsp/We2_mypage_confirm.jsp";
	
	We2_MemberVO member = (We2_MemberVO)session.getAttribute("loginUser");
	try{
		if(member !=null){
			We2_MemberDAO mDao = We2_MemberDAO.getInstance();
			int result = mDao.deleteMember(member.getUserid());
			if (result==1){
				request.setAttribute("message", "회원탈퇴에 성공하였습니다.");
			}else{
				request.setAttribute("message", "회원탈퇴에 실패했습니다.");
			}
		}else{
			request.setAttribute("message", "로그인을 먼저해주세요");
		}
		
	}catch(Exception e){
		e.getStackTrace();
		request.setAttribute("message", "잘못된 접근입니다 다시 시도해주세요");
	}
	session.invalidate();
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("com_we2_registration_jsp/We2_login.jsp");	
	dispatcher.forward(request, response);
	}
}