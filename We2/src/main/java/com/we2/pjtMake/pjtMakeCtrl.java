package com.we2.pjtMake;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.we2.spring.AuthInfo;

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
	public String test2(@ModelAttribute PjtMakeVO pjtMakeVO,HttpServletRequest request, HttpSession session, Model model) throws ParseException{
		
		//프로젝트 만들기를 클릭했을 때, 이 정보를 DB에 저장하는 DAO
		pjtMakeDAO.insertPjtMake(pjtMakeVO);
		
		//pjtManager에 디비를 추가 할 때 필요한 컬럼은(userId, pjtCode, isLeader)이다.
		//또한 프로젝트를 만드는 사람은 로그인한 사람이니 그 사람의 아이디를 불러와서 userId를 넘겨주고 또 리더로 지정해주면 된다.
		AuthInfo member= (AuthInfo)session.getAttribute("authInfo");
		String userId = member.getUserId(); 
		
		// 방금 생성한 프로젝트 코드를 조회하는 DAO
		int pjtCode = pjtMakeDAO.selectCode();
		System.out.println("프로젝트를 만든 이 사람의 프로젝트 코드는 : " + pjtCode + " 입니다." );
		
		//필요한 컬럼을 다 받았으니 pjtManager를 추가한다.
		pjtMakeDAO.inserPjtManager(userId, pjtCode);
		
		//날짜 구하는 Dao 
		int dateSearch = pjtMakeDAO.searchDate(userId);
		System.out.println(dateSearch);
			session.setAttribute("day", dateSearch);
		
		//프로젝트 생성이 성공했습니다 메시지를 뿌려주기 위한 설정
		request.setAttribute("test", "success");
		return "/index";
		}
	
	/*@RequestMapping(value="/invite", method=RequestMethod.GET)
	public String test2() throws ParseException{
	return "/pjtMake/invite";
	}
	
	@RequestMapping(value="/invite", method=RequestMethod.POST)
	public String test2(HttpServletRequest request, Model model) throws ParseException{
		MailSend.main(null);
		SMTPAuthenticator sMTPAuthenticator = new SMTPAuthenticator();
		sMTPAuthenticator.getPasswordAuthentication();
		return "/pjtMake/success";
	}*/
	
}