package com.we2.pjtMake;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.we2.spring.AuthInfo;
import com.we2.spring.MemberDao;
import com.we2.utils.We2MailSender;
import com.we2.willwork.WillWorkDAO2;

@Controller
@RequestMapping("/project")
public class PjtSettingCtrl {

	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;
	@Autowired
	PjtMakeDAO pDao;
	@Autowired
	MemberDao mDao;
	@Autowired
   	WillWorkDAO2 wDao;
	@Autowired
    private We2MailSender emailSender;

	
	@RequestMapping(method = RequestMethod.GET)
	public String projectsession(HttpServletRequest request, Model model, HttpSession session) throws ParseException {
		
		System.out.println("/project 시작");
		
		//MemberMyPage.jsp에서 a태그로 pjtCode를 인자로 받아서 세션에 저장
		int pjtCode = Integer.parseInt(request.getParameter("pjtCode"));
			System.out.println("/project pjtCode : " + pjtCode);
		session.setAttribute("pjtCode", pjtCode);
		
		PjtMakeVO pjtVo = pDao.selectAllpjtInfo(pjtCode);
		session.setAttribute("project", pjtVo);
		// 이 프로젝트의 방장(userid)를 세션에 보냄
		session.setAttribute("leader", pDao.selectLeader(pjtCode));
		
		//디비상에 날짜를 조회해서 세션에 담는다.
		int totalDate = mDao.selectDate(pjtCode);
			System.out.println("총 프로젝트 일수 : "+totalDate);
			
		int remainDate = mDao.remainDate(pjtCode);
			System.out.println("현재 잔여 프로젝트 일수 : "+remainDate);
		
		// endDate-startDate를 세션에 날림.
		session.setAttribute("totalDate", totalDate);
		session.setAttribute("remainDate", remainDate);
		
				
		return "redirect:/notice/list";
	}
	
	@RequestMapping(value="/setting", method=RequestMethod.GET)
	public String settingGet(Model model, 
			@RequestParam(value="msg", defaultValue="false")String msg,
			@RequestParam(value="delusers", defaultValue="false")String delusers){
		
		System.out.println("/project setting : welcome to setting method");
		
		// pjtCode를 받는다. 
		int pjtCode = (Integer)session.getAttribute("pjtCode");
			System.out.println("/project setting pjtcode : "+pjtCode);
				
		// SQL : 방장의 ID 구하기
		String pjtleader = pDao.selectLeader(pjtCode);
		// 현재 로그인된 사람의 id 구하기
		AuthInfo member = (AuthInfo)session.getAttribute("authInfo");
		String loggedinmem=member.getUserId();
			System.out.println("현재 로그인된 사용자 - " + loggedinmem);
		
		// member와 pjtleader를 비교해서 일치하면 방장, 아니면 방장 아님.
		String isleader="";
			System.out.println("당신은 리더입니까? "+isleader);
			System.out.println("pjtleader : " + pjtleader);
		
		if(pjtleader == null){
			isleader="N";
			System.out.println("is not leader");
		}else if(pjtleader.equals(loggedinmem)){
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
		
		// msg 보내기
		if(msg.equals("done")){
			model.addAttribute("msg", delusers+"의 탈퇴처리가 완료되었습니다");
		}else if(msg.equals("periodfail")){
			model.addAttribute("msg", "시작날짜와 종료날짜 둘 다 선택 해 주셔야 합니다.");
		}else if(msg.equals("perioddone")){
			model.addAttribute("msg", "프로젝트 기간수정이 완료되었습니다.");
		}
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
		int pjtCode = (Integer)session.getAttribute("pjtCode");
			System.out.println("/project invitation.POST pjtcode : "+pjtCode);
			
		String[] usermails=request.getParameterValues("item");
		for(int i=0; i<usermails.length; i++){
			System.out.println("/invitation.POST usermails["+i+"] : "+usermails[i]);
		}
		
		AuthInfo authinfo=(AuthInfo)session.getAttribute("authInfo");
		String captain=authinfo.getName();
			System.out.println("/project invitation.POST 현재 로그인된 사용자 : " + captain);
		
		// 선택된 유저들, pjtMake의 정보 모두 select , pjtManager의 회원정보 select
		emailSender.sendEmail(captain, usermails, pDao.selectAllpjtInfo(pjtCode), pDao.selectAllpjtMem(pjtCode));

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
	public String mailaddpost(Model model, HttpServletRequest request){
		// 디버깅 시작	
			System.out.println("/addmember.POST 시작");
		int pjtCode=Integer.parseInt(request.getParameter("pjtCode"));
			System.out.println("/project addmember POST pjtCode : " + pjtCode);
		String pjtadd=request.getParameter("pjtadd");
			System.out.println("/project addmember POST pjtadd : " + pjtadd);
			model.addAttribute("pjtadd", pjtadd);
			
		// 세션에 pjtCode 보냄.
		session.setAttribute("pjtCode", pjtCode);
		
		if(session.getAttribute("authInfo")==null){
			return "redirect:/login";
		}
			System.out.println("/project/addpjtmember로 redirect");
		return "redirect:/project/addpjtmember";
	}
	
	@RequestMapping(value="/addpjtmember", method=RequestMethod.GET)
	public String mailadd(Model model){
		int pjtCode=0;
		
		if(session.getAttribute("pjtCode")==null){
			return "redirect:/login";
		}else{
			pjtCode=(Integer)session.getAttribute("pjtCode");
				System.out.println("/project addpjtmember.POST pjtcode : "+pjtCode);
		}
		
		// 현재 로그인중인 user의 userid를 뽑아냄.
		AuthInfo authinfo = (AuthInfo)session.getAttribute("authInfo");
		String userId = authinfo.getUserId();
		String username = authinfo.getName();
		
		// 현재 로그인된 유저가 가입하려는 프로젝트에 가입되어있나 확인.
		if(pDao.checkpjtmember(pjtCode, userId)!=null){
			model.addAttribute("msg", "이미 해당 프로젝트에 참여 중이십니다.");
			return "index";
		}else{
			System.out.println("pDao.checkpjtmember가 null");
		}
		
		 pDao.addpjtMember(pjtCode, userId);
		 wDao.adduserWillwork(userId, pjtCode, username);
		 System.out.println("/project addpjtmember.GET insert 완료됨");
		 
		model.addAttribute("msg", "해당 프로젝트 가입이 완료되었습니다 마이페이지에서 확인 해 보세요.");
		return "index";
	}
	
	
	@RequestMapping(value="/pjtmemDel", method=RequestMethod.GET)
	public String pjtmemDel(Model model, String[] team_member){
		int pjtCode = (Integer)session.getAttribute("pjtCode");
		
		String delusers = "";
		
		for(int i=0; i<team_member.length; i++){
			System.out.println("/pjtmemDel team_member : " + team_member[i]);
			if(delusers.length()<=1){
				delusers = delusers + pDao.checkmembeforedel(pjtCode, team_member[i]);
			}else{
				delusers = delusers + " , "+pDao.checkmembeforedel(pjtCode, team_member[i]);
			}
			pDao.pjtmgrmemDel(pjtCode, team_member[i]);
			pDao.pjtwillworkmemDel(pjtCode, team_member[i]);
		}
		System.out.println("지워진 유저들 : " + team_member.toString());
		
		// Model객체에 보내기
		model.addAttribute("msg", "done");
		model.addAttribute("delusers", delusers);
		
		return "redirect:/project/setting";
	}
	
	@RequestMapping(value="/pjtPeriodModify", method=RequestMethod.POST)
	public String pjtPeriodModify(Model model, 
			@RequestParam(value="startDate", defaultValue="false")String startDate,
			@RequestParam(value="endDate", defaultValue="false")String endDate) throws ParseException {
		
		int pjtCode = (Integer)session.getAttribute("pjtCode");
		
		pDao.updatePjtMake(startDate, endDate, pjtCode);
		
			//디비상에 날짜를 조회해서 세션에 담는다.
			int totalDate = mDao.selectDate(pjtCode);
				System.out.println("프로젝트 일수 : "+totalDate);
			int remainDate = mDao.remainDate(pjtCode);
				System.out.println("현재 잔여 프로젝트 일수 : "+remainDate);
				
			// endDate-startDate를 세션에 날림.
			session.setAttribute("totalDate", totalDate);
			session.setAttribute("remainDate", remainDate);
			
			// Model객체에 보내기
			model.addAttribute("msg", "perioddone");
			
		return "redirect:/project/setting";
	}
}
