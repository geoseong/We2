package com.we2.logout.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.we2.spring.AuthInfo;
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
	public String Member_delete(HttpServletRequest request,HttpSession session, Model model) {
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");

			System.out.println("logout]]]+"+authInfo);
			System.out.println("logout[[["+authInfo.getUserId());
		
		try{
			memberDao.delete(authInfo);
		}catch(Exception e){
			e.getStackTrace();
			request.setAttribute("message", "잘못된 접근입니다. 다시 시도해 주세요");
		}
		model.addAttribute("msg", "회원삭제가 완료되었습니다.");
		session.invalidate();
		return "/index";
	}
}
