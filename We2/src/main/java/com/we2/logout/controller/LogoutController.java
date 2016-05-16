package com.we2.logout.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.we2.spring.Member;

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
	public String form(Model model, Member member) {
		List<String> genderTypes = new ArrayList<String>();
		genderTypes.add("남성");
		genderTypes.add("여성");
		model.addAttribute("genderTypes", genderTypes);
		return "registration/Member_Update";

	}
}
