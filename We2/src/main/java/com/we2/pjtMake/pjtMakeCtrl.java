package com.we2.pjtMake;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.we2.pjtMake.MailSend.SMTPAuthenticator;

@Controller
public class pjtMakeCtrl{
	
	
	private PjtMakeDAO pjtMakeDAO;
	
	public void setPjtMakeDAO(PjtMakeDAO pjtMakeDAO) {
		this.pjtMakeDAO = pjtMakeDAO;
	}
	
	/*@RequestMapping(value="/pjtMake", method=RequestMethod.GET)
	public String test(){
		return "pjtMake/pjtMake";
	}*/

	@RequestMapping(value="/pjtmake", method=RequestMethod.POST)
	public String test2(@ModelAttribute PjtMakeVO pjtMakeVO) throws ParseException{
		System.out.println(pjtMakeVO.getPjtName());
		System.out.println(pjtMakeVO.getPjtClassify());
		System.out.println(pjtMakeVO.getStartDate());
		System.out.println(pjtMakeVO.getEndDate());
	pjtMakeDAO.insertPjtMake(pjtMakeVO);
	return "/pjtMake/test";
	}
	
	@RequestMapping(value="/invite", method=RequestMethod.GET)
	public String test2() throws ParseException{
	return "/pjtMake/invite";
	}
	
	@RequestMapping(value="/invite", method=RequestMethod.POST)
	public String test2(HttpServletRequest request, Model model) throws ParseException{
		MailSend.main(null);
		SMTPAuthenticator sMTPAuthenticator = new SMTPAuthenticator();
		sMTPAuthenticator.getPasswordAuthentication();
		return "/pjtMake/success";
	}
	
}