package com.we2.logout.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.we2.spring.Member;
import com.we2.spring.MemberUpdateService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LogoutController {

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	} // end logout()

	@RequestMapping(value = "/We2_MemberUpdate", method = RequestMethod.POST)
	public void We2_MemberUpdate(Member member) {

	}
}
