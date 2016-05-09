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
		// 로그인 정보를 갖고 있는 객체를 session영역에서가져오고, 그 객체에서 getter 메소드 사용. 
		String userid = mVo.getUserid();
			System.out.println("doPost : userid - " + userid);
			
		// 회원 정보를 보냄.
		request.setAttribute("mVo", mVo);
		
		//기존 form의 name = key 값을 받아옴.
		String pwd = request.getParameter("pwd");		
			System.out.println("doPost : pwd : " + pwd);
			
	
		try {
			if (pwd != null) {	// pwd가 null이 아니면
				// SQL을 쓰기위한 객체 인스턴스화
				We2_MemberDAO mDao = We2_MemberDAO.getInstance();
								
				int result = mDao.confirmMember(userid,pwd);
				
				System.out.println("result값 : " + result);

				if (result==1){
					PjtMakeDAO pDAO = PjtMakeDAO.getInstance();
					List<PjtMakeVO> pjtlist = pDAO.selectUserpjts(userid);
					request.setAttribute("pjtlist", pjtlist);
					
					request.setAttribute("message", "We2 마이페이지입니다. ^^.");	
					//RequestDispatcher dispatcher = request.getRequestDispatcher("com_we2_registration_jsp/We2_mypage.jsp");
					RequestDispatcher dispatcher = request.getRequestDispatcher("com_we2_registration_jsp/01_1_mypage.jsp");
					
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("message", "We2 마이페이지접속에 실패했습니다.");
					
					// 다른페이지로 이동시키는 코딩 추가.
					response.sendRedirect("We2_login.do");
				} //end if
			} else {
				request.setAttribute("message", "비밀번호를  먼저 입력 해주세요");				
				response.sendRedirect("com_we2_registration_jsp/We2_mypage_confirm.jsp");
			}
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("message", "잘못된 접근입니다 다시 시도해주세요");
		}

	}
}