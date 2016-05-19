package com.we2.pjtMake;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.we2.spring.AuthInfo;
import com.we2.utils.MailSend;
import com.we2.utils.MailSend.SMTPAuthenticator;

@Controller
@RequestMapping("/project")
public class PjtCtrl {

	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;
	@Autowired
	PjtMakeDAO pDao;
	@Autowired
    private ServletContext servletContext;
	
	
	@RequestMapping("/")
	public String makepjtsession(String pjtCode) {
		session.setAttribute("pjtCode", pjtCode);
		
		return "redirect:/project/setting";
	}

	@RequestMapping(value="/setting", method=RequestMethod.GET)
	public String aopsettingGet(Model model){
		// pjtCode를 받는다. 
		String pjtCode=(String)session.getAttribute("pjtCode");
		System.out.println("session에서 받은 pjtCode = " + pjtCode);
		
		// SQL : 방장의 ID 구하기
		String pjtleader = pDao.selectLeader(pjtCode);
			System.out.println("이바닥의 방장은 바로 - " + pjtleader);
		// 현재 로그인된 사람의 id 구하기
		AuthInfo member = (AuthInfo)session.getAttribute("authInfo");
		String loggedinmem=member.getUserId();
			System.out.println("현재 로그인된 사용자 - " + loggedinmem);
		
		// member와 pjtleader를 비교해서 일치하면 방장, 아니면 방장 아님.
		String isleader="N";
			System.out.println("당신은 리더입니까? "+isleader);
		if(pjtleader.equals(loggedinmem)){
			isleader="Y";
			System.out.println("다시 묻습니다. 당신은 리더입니까? "+isleader);
		}
		
		/* request 영역에 보내기*/
		// SQL : pjtMake의 정보 모두 select
		model.addAttribute("pjtInfo", pDao.selectAllpjtInfo(pjtCode));
		// SQL : pjtManager의 회원정보 select
		model.addAttribute("pjtmem", pDao.selectAllpjtMem(pjtCode));
		// 리더냐 아니냐 (Y/N)
		model.addAttribute("isleader",isleader);
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
