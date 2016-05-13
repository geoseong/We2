package com.we2.Logout.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.we2.spring.auth.AuthInfo;
import com.we2.spring.auth.MemberUpdateService;
import com.we2.spring.auth.IdPasswordNotMatchingException;
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
	public void We2_MemberUpdate(Member member) {
		class MemberUpdateController {

			private MemberUpdateService memberUpdateService;

			public String setMemberUpdateService(MemberUpdateService memberUpdateService) {
				this.memberUpdateService = memberUpdateService;

				return "registration/We2_MemberUpdate";
			}
		}
	}
}