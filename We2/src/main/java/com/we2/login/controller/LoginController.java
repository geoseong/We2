package com.we2.login.controller;

import java.sql.Date;
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
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginget(HttpServletRequest request, LoginCommand loginCommand,
			@RequestParam(value = "pjtadd", defaultValue = "false") String pjtadd, Model model,
			@CookieValue(value = "REMEMBER", required = false) Cookie rememberCookie) {
		if (rememberCookie != null) {
			loginCommand.setUserId(rememberCookie.getValue());
			loginCommand.setRememberUserid(true);
		}
		if (pjtadd.equals("yes")) {
			System.out.println("/login.get : pjtadd equals pjtadd");
			model.addAttribute("pjtadd", "yes");
		} else {
			System.out.println("/login.get : pjtadd not equal pjtadd , actual value - " + pjtadd);
			pjtadd = "";
		}
		return "registration/Member_Login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginpost(LoginCommand loginCommand, Errors errors, HttpSession session, HttpServletResponse response,
			String pjtadd) {
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

			System.out.println("pjtadd : " + pjtadd);
			if (pjtadd.equals("yes")) {
				System.out.println("pjtadd 값이 pjtadd과 일치함. project/addpjtmember로 이동함.");
				pjtadd = null;
				return "redirect:/project/addpjtmember";
			}

			return "/index";
		} catch (IdPasswordNotMatchingException e) {
			errors.rejectValue("userId", "idpwdNotMatching");
			return "registration/Member_Login";
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

	@RequestMapping(value = "/Member_Mypage", method = RequestMethod.GET)
	public String aopMember_MypageView(HttpServletRequest request, AuthInfo authInfo, Model model) {

		HttpSession session = request.getSession(); // 세션영역을 가져옴

		authInfo = (AuthInfo) session.getAttribute("authInfo");

		String userId = authInfo.getUserId();
		System.out.println("authInfo::::::::::" + authInfo);

		AuthInfo mVo = (AuthInfo) session.getAttribute("authInfo");
		//mVo 세션에서 가져오지 마시고, 세션정보의 userid로 db를 새로 조회해와서 모델
		System.out.println("mVo.getUserId()::::::::" + mVo.getUserId());
		System.out.println("mVo.getGender()성별 오류출력:::::" + mVo.getGender());

		List<PjtJoinVO> list = memberDao.selectAll(userId);
		model.addAttribute("pjtlist", list);

		// 세션에서 authInfo값을 가져옴
		// mVo에 모든 값이 들어가져 있고 성만 값을 가져옴!
		model.addAttribute("mVo", mVo);
		return "registration/Member_MypageView";
	}

	@RequestMapping(value = "/Member_Mypage", method = RequestMethod.POST)
	public String Member_MypageViewpost(HttpServletRequest request) {
		System.out.println("11111");
		/*
		System.out.println("파라미터 pwd : " + request.getParameter("pwd"));
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
*/
			System.out.println("22222");
			
			String name = request.getParameter("name");
			String userId =request.getParameter("userId");
			String pwd =request.getParameter("pwd");
			String pwd_confirm =request.getParameter("pwd_confirm");
			String phone =request.getParameter("phone");
			String email = request.getParameter("email");
			String gender =request.getParameter("gender");
			String RegDate= request.getParameter("regDate");
			
			System.out.println("33333");

			System.out.println("Logincontroller]]"+request.getParameter("name"));
			System.out.println("Logincontroller]]"+request.getParameter("userId"));
			System.out.println("Logincontroller]]"+request.getParameter("pwd"));
			System.out.println("Logincontroller]]"+request.getParameter("pwd_confirm"));
			System.out.println("Logincontroller]]"+request.getParameter("phone"));
			System.out.println("Logincontroller]]"+request.getParameter("email"));
			System.out.println("Logincontroller]]"+request.getParameter("gender"));
			System.out.println("Logincontroller]]"+request.getParameter("regDate"));
			
			System.out.println("44444");
			memberDao.update(name, userId, pwd, pwd_confirm, phone, email, gender, RegDate);
			System.out.println("55555");
		
		return "redirect:/Member_Mypage";
	}
	@RequestMapping(value = "/lost", method = RequestMethod.GET)
	public String forgotmember(Model model) {
		return "/registration/MemberIdandPassSearchForm";
	}
	
	@RequestMapping(value = "/idsearch", method = RequestMethod.POST)
	public String lostmember(Model model,@RequestParam(value = "name", required=false) String name,
			@RequestParam(value = "email", required=false) String email) {
		
		System.out.println("controller name : " + name + " / email : " + email);
		
		String userid=memberDao.findid(name, email);
		
		System.out.println("userid;;;;;;;;;;;"+ userid);
		model.addAttribute("lostuser", userid);
		return "/registration/MemberIdandPassSearchForm";
	}
	
}
