package com.we2.logout.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.we2.spring.Member;
import com.we2.spring.MemberDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LogoutController {
	@Autowired
	private MemberDao memberDao;

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session, HttpServletRequest request) {
		session.invalidate();
		request.setAttribute("outout", "logout");
		return "index";
	} // end logout()

	@RequestMapping(value = "/Delete_form", method = RequestMethod.GET)
	public String Delete_form() {
		return "registration/Member_DeleteAggrement";
	}

	@RequestMapping(value = "/Member_delete", method = RequestMethod.POST)
	public String Member_delete(Member member, HttpServletRequest request , Model model) {

		HttpSession session = request.getSession(); // 세션영역을 가져온다

		member = (Member) session.getAttribute("member");
			System.out.println("member;;;;;;");
		try{
			memberDao.delete(member);
		}catch(Exception e){
			e.getStackTrace();
			request.setAttribute("message", "잘못된 접근입니다. 다시 시도해 주세요");
		}
		session.invalidate();
		return "/index";
	}
}
