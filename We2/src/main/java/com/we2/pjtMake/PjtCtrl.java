package com.we2.pjtMake;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.we2.spring.AuthInfo;
import com.we2.spring.MemberDao;
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
	MemberDao mDao;
	@Autowired
    private ServletContext servletContext;
	

	/** pjtCode 세션 보내기 테스트용. */
	@RequestMapping(method = RequestMethod.GET)
	public String projectsession(HttpServletRequest request, Model model, HttpSession session) {
		
		System.out.println("/project 시작");
		
		//MemberMyPage.jsp에서 a태그로 pjtCode를 인자로 받아서 세션에 저장
		int pjtCode = Integer.parseInt(request.getParameter("pjtCode"));
			System.out.println("/project pjtCode : " + pjtCode);
		session.setAttribute("pjtCode", pjtCode);
		
		System.out.println("/project DAO 진입 전");
		
		//디비상에 날짜를 조회해서 세션에 담는다.
		int searchDate = mDao.selectDate(pjtCode);
			System.out.println("endDate-startDate : "+searchDate);
			
		// endDate-startDate를 세션에 날림.
		session.setAttribute("day", searchDate);
		
		return "redirect:/notice/list";
	}
	
	@RequestMapping(value="/setting", method=RequestMethod.GET)
	public String settingGet(Model model){
		// pjtCode를 받는다. 
		int pjtCode = Integer.parseInt(request.getParameter("pjtCode"));
			System.out.println("/project setting GET pjtCode : " + pjtCode);
				
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
	
	@RequestMapping(value="/invitation", method=RequestMethod.GET)
	public String mailsendGet(Model model) {
			System.out.println("invitation.get] Welcome!!");
		String email=request.getParameter("email");
			System.out.println("invitation.get] email : " + email);
		
		// request영역 보냄
		model.addAttribute("searchemail",mDao.selectByEmail(email));
		return "myproject/invitation";
	}
	
	@RequestMapping(value="/invitation", method=RequestMethod.POST)
	public String mailsendPost(Model model){
		int pjtCode = Integer.parseInt(request.getParameter("pjtCode"));
			System.out.println("/project invitation POST pjtCode : " + pjtCode);
			String[] ids=request.getParameterValues("item");
		
		// 메일전송 태그를 갖고있는 파일경로 지정.
		String path=servletContext.getRealPath("we2/mailsend");
		
		MailSend mailsend = new MailSend();
		
		for(String a : ids){
			System.out.println("invitation.post] 선택된 id들 : " + a);
			mailsend.main(path, a);
		}
		SMTPAuthenticator smtpauth = new SMTPAuthenticator();
		smtpauth.getPasswordAuthentication();
		
		
		// alert 메시지.
			String message=
					"<script type='text/javascript'>"
					+"alert('이메일 발송이 완료되었습니다.');"
					/*+"opener.location.reload();"*/
					+"self.close();"
					+ "</script>";
		 model.addAttribute("alert",message);
		 return "myproject/invitation";
	}
	
	@RequestMapping(value="/addmember", method=RequestMethod.GET)
	public String mailaddgt(Model model){
		System.out.println("/addmember.get 시작");
		 AuthInfo authinfo = (AuthInfo)session.getAttribute("authInfo");
		 String userId = authinfo.getUserId();
		 int pjtCode = Integer.parseInt(request.getParameter("pjtCode"));
			System.out.println("/project addmember GET pjtCode : " + pjtCode);
		
		pDao.addpjtMember(pjtCode, userId);
		return "index";
	}
	
}
