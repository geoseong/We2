package com.we2.logout.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

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
		public String logout(HttpSession session) {
		session.invalidate();
		return "index";
		} // end logout()
	}
