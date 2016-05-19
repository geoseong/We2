package com.we2.pjtMake;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.we2.utils.MailSend;
import com.we2.utils.MailSend.SMTPAuthenticator;

@Controller
@RequestMapping("/project")
public class PjtCtrl {

	@Autowired
	HttpServletRequest request;
	@Autowired
	PjtMakeDAO pDao;
	@Autowired
	HttpSession session;
	@Autowired
    private ServletContext servletContext;
	
	@RequestMapping(value="/setting", method=RequestMethod.GET)
	public String aopsettingGet(Model model){
		// pjtCode를 받는다. 
		session.getAttribute("pjtCode");
		
		pDao.addpjtMember();
		
		// JSP:INCLUDE PAGE
		  model.addAttribute("page", "../myproject/setting");
		return "myproject/myproject";
	}
	
	@RequestMapping(value="/mailsend", method=RequestMethod.GET)
	public String aopmailsendGet(Model model, String memberId){
		// pjtCode를 받는다. 
				session.getAttribute("pjtCode");
		
		// 메일전송 태그를 갖고있는 파일경로 지정.
		String path=servletContext.getRealPath("we2/mailsend");
		
		MailSend mailsend = new MailSend();
		mailsend.main(path, "imf4@naver.com");
		SMTPAuthenticator smtpauth = new SMTPAuthenticator();
		smtpauth.getPasswordAuthentication();
		
		// JSP:INCLUDE PAGE
		  model.addAttribute("page", "setting");
		return "myproject/myproject";
	}
	
}
