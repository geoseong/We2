package com.we2.login.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.we2.spring.AuthInfo;
import com.we2.spring.AuthService;
import com.we2.spring.IdPasswordNotMatchingException;
import com.we2.spring.Member;
import com.we2.spring.MemberDao;
import com.we2.spring.PjtJoinVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {
	@Autowired
	private AuthService authService;

	/*
	 * public void setAuthService(AuthService authService) { this.authService =
	 * authService; }
	 */
	@Autowired
	private MemberDao memberDao;
	/*
	 * public void setMemberDao(MemberDao memberDao) { this.memberDao =
	 * memberDao; }
	 */
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	private static final int String = 0;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Locale locale, HttpServletRequest request, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		String msgs = (String)request.getAttribute("msg");
		System.out.println("msgs : "+msgs);
		return "index";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	/*
	 * public String HomeController(Locale locale, Model model) { logger.info(
	 * "Welcome home! The client locale is {}.", locale);
	 * 
	 * Date date = new Date(); DateFormat dateFormat =
	 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	 * 
	 * String formattedDate = dateFormat.format(date);
	 * 
	 * model.addAttribute("serverTime", formattedDate );
	 * 
	 * return "home"; }
	 */

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginget(HttpServletRequest request,LoginCommand loginCommand, @RequestParam(value="pjtadd", defaultValue="false")String pjtadd, Model model,
			@CookieValue(value = "REMEMBER", required = false) Cookie rememberCookie) {
		if (rememberCookie != null) {
			loginCommand.setUserId(rememberCookie.getValue());
			loginCommand.setRememberUserid(true);
		}
		if(pjtadd.equals("pjtadd")){
			System.out.println("login.get : pjtadd equals pjtadd");
			model.addAttribute("pjtadd", "add");
		}else{
			System.out.println("login.get : pjtadd not equal pjtadd , actual : "+pjtadd);
			pjtadd="";
		}
		return "registration/Member_Login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginpost(LoginCommand loginCommand, Errors errors, HttpSession session,
			HttpServletResponse response, String pjtadd) {
		// 디버깅 여기까지 데이터가 옴!!
		System.out.println("login" + "post방식으로 Logincontroller까지 옴!!");

		// 폼 값이 올바른지 검사.
		new LoginCommandValidator().validate(loginCommand, errors);

		// 디버깅.
		logger.info("ID : " + loginCommand.getUserId() + " , PWD : " + loginCommand.getPwd());
		System.out.println("ID : " + loginCommand.getUserId() + " , PWD : " + loginCommand.getPwd());

		if (errors.hasErrors()) {
			return "registration/Member_Login";
		}

		try {
			// 로그인 커맨드로부터 id, pwd를 받아서 인증작업 거쳐서 세션에 넘어갈 변수들 바인딩객체를 리턴받음
			AuthInfo authInfo = authService.authenticate(loginCommand.getUserId(), loginCommand.getPwd());

			// 세션영역에 회원정보 추가
			session.setAttribute("authInfo", authInfo);
			System.out.println("authInfo" + (AuthInfo) session.getAttribute("authInfo"));
			// 폼에 자동완성을 원하면 쿠키에 30일동안 userid를 보이게 함.
			Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getUserId());
			rememberCookie.setPath("/"); // 해당 쿠키의 적용범위

			if (loginCommand.isRememberUserid()) {
				rememberCookie.setMaxAge(60 * 60 * 24 * 30); // 30일동안.
			} else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);

			logger.info("회원 " + authInfo.getUserId() + "로그인함.");
			System.out.println("authInfo" + "authInfo값이 제대로 나오는지 디버깅!! 로그인 컨트롤러");
			
			System.out.println("pjtadd : "+pjtadd);
			if( pjtadd.equals("add")){
				System.out.println("pjtadd 값이 pjtadd과 일치함. project/addpjtmember로 이동함.");
				pjtadd=null;
				return "redirect:/project/addpjtmember";
			}
			
			return "/index";
		} catch (IdPasswordNotMatchingException e) {
			errors.reject("idPasswordNotMatching");
			return "/index";
		} // end try-catch
	} // end loginpost()

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String member_Aggrement() {
		return "registration/Member_Aggrement";
	}

	@RequestMapping(value = "/Member_Aggrement", method = RequestMethod.POST)
	public String member_Form(Member member) {
		return "registration/Member_Join";
	}

	@RequestMapping(value = "/We2_idCheck")
	public String doGet(@RequestParam("userId") String userId, Model model) {

		// int result = mDao.confirmID(userId);
		int result = authService.idCheck(userId);

		model.addAttribute("userId", userId);
		model.addAttribute("result", result);

		return "registration/We2_idCheck";
	}

	@RequestMapping(value = "/Member_Join", method = RequestMethod.POST)
	public String member_join(Member member, Errors errors) {
		memberDao.insert(member);
		return "/index";
	}

	
	@RequestMapping(value="/Member_Mypage", method = RequestMethod.GET)
	public String aopMember_MypageView(HttpServletRequest request, AuthInfo authInfo, Model model){
		
		HttpSession session = request.getSession(); // 세션영역을 가져옴

		authInfo = (AuthInfo) session.getAttribute("authInfo");

		String userId = authInfo.getUserId();
			System.out.println("authInfo::::::::::" + authInfo);
		
		AuthInfo mVo = (AuthInfo) session.getAttribute("authInfo");
			System.out.println("mVo.getUserId()::::::::" + mVo.getUserId());
			System.out.println("mVo.getGender()성별 오류출력:::::"+ mVo.getGender());
		
		List<PjtJoinVO> list = memberDao.selectAll(userId);
			//System.out.println("list.size()::::::::::" + list.size());
		model.addAttribute("pjtlist", list);
		
		// 세션에서 authInfo값을 가져옴
		// mVo에 모든 값이 들어가져 있고 성만 값을 가져옴!
		model.addAttribute("mVo", mVo);
		return "registration/Member_MypageView";
	}

	@RequestMapping(value = "/Member_Mypage", method = RequestMethod.POST)
	public String Member_MypageViewpost(HttpServletRequest request, Member member, Model model) {

		System.out.println("파라미터 pwd : " + request.getParameter("pwd"));
		// System.out.println("파라미터 pwd : "+request.getParameter("pwd"));
		System.out.println("파라미터 pwd_conrifm : " + request.getParameter("pwd_confirm"));

		if (request.getParameter("pwd") != null) {
			System.out.println("pwd 는 not null이다.");
		}
		if (request.getParameter("pwd_confirm") != null) {
			System.out.println("pwd_confirm 는 not null이다.");
		}
		if (request.getParameter("pwd") != null && request.getParameter("pwd_conrifm") != null) {
			member.setName(request.getParameter("name"));
			member.setUserId(request.getParameter("userId"));
			member.setPwd(request.getParameter("pwd"));
			member.setPwd_confirm(request.getParameter("pwd_conrifm"));
			member.setPhone(request.getParameter("phone"));
			member.setEmail(request.getParameter("email"));
			member.setGender(request.getParameter("gender"));
			
			System.out.println("Member_Mypage값이 제대로 오니?" + member.getGender());
			
			memberDao.update(member);
		}
		return "index";
	}
	
	/*@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String member_join(HttpServletRequest request, Model model, HttpSession session) {
		
		System.out.println("/project 시작");
		
		//MemberMyPage.jsp에서 a태그로 pjtCode를 인자로 받아서 세션에 저장
		int pjtCode = Integer.parseInt(request.getParameter("pjtCode"));
			System.out.println("/project pjtCode : " + pjtCode);
		session.setAttribute("pjtCode", pjtCode);
		
		System.out.println("/project DAO 진입 전");
		
		//디비상에 날짜를 조회해서 세션에 담는다.
		int searchDate = memberDao.selectDate(pjtCode);
			System.out.println("endDate-startDate : "+searchDate);
			
		// endDate-startDate를 세션에 날림.
		session.setAttribute("day", searchDate);
		
		return "redirect:/notice/list";
	}*/
}

