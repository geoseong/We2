package com.we2.logout.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@RequestMapping(value = "Delete_form", method = RequestMethod.GET)
	public String Delete_form() {
		return "registration/Member_DeleteAggrement";
	}
	
	@RequestMapping(value= "Member_delete", method= RequestMethod.POST)
	public String Member_delete(Member member, HttpServletRequest request){
	
		HttpSession session = request.getSession(); // 세션영역을 가져옴
		
		member = (Member)session.getAttribute("member");
		
		try{
			if(member !=null){
			Member mDao = Member.getInstance();
			int result = mDao.d
		}
		
		
	return "/index";
	}
}
