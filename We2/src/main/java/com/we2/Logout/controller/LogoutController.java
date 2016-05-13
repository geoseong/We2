package com.we2.Logout.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.we2.spring.auth.Member;

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
	public String We2_MemberUpdate(Member member){
		return "registration/We2_MemberUpdate";
	}
}
