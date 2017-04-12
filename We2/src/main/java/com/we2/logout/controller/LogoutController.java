package com.we2.logout.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.we2.pjtMake.PjtMakeVO;
import com.we2.spring.AuthInfo;
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

	@RequestMapping(value = "/Delete_form", method = RequestMethod.GET)
	public String Delete_form(Model model, HttpSession session) {
		AuthInfo mVo = (AuthInfo)session.getAttribute("authInfo");
		model.addAttribute("userId", mVo.getUserId());
		return "registration/Member_DeleteAggrement";
	}
	
	/** 회원탈퇴전 자신이 방장인 프로젝트 인수인계화면 띄우기 */
	@RequestMapping(value = "/inheritance.do", method = RequestMethod.GET)
	public String inheritance_get(Model model, /*HttpSession session,*/ HttpServletRequest request) {
		String userId = request.getParameter("userId");
		List<PjtMakeVO> selectpjt = memberDao.selectproject(userId);
		model.addAttribute("projects", selectpjt);
		return "registration/inheritance";
	}

	/** 회원탈퇴전 자신이 방장인 프로젝트 멤버들 뿌리기 */
	@RequestMapping(value = "/searchpjt", method = RequestMethod.POST)
	public @ResponseBody List<String> searchpjt(Model model, int pjtCode) {
		List<String> mypjt = memberDao.selectmembers_mypjt(pjtCode);
		for(int i=0; i<mypjt.size(); i++){
			if(i != mypjt.size()-1){
				mypjt.set(i, mypjt.get(i)+",");
			}
		}
		return mypjt;
	}
	
	/** 회원탈퇴전 자신이 방장인 프로젝트 인수인계시키기 */
	@RequestMapping(value = "/inheritance.do", method = RequestMethod.POST)
	public String inheritance(Model model, HttpServletRequest request, HttpSession session) {
		int pjtCode=Integer.parseInt(request.getParameter("pjts"));
		String members=request.getParameter("members");
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		memberDao.updateownerpjt(pjtCode, members, authInfo.getUserId());
		
		model.addAttribute("completemsg", " ' " + memberDao.selectpjtname(pjtCode) +" ' 프로젝트의 방장이  ' " + members + " ' 로 바뀌었습니다.");
		return inheritance_get(model, request);
	}
	
	/** 회원삭제 */
	@RequestMapping(value = "/Member_delete", method = RequestMethod.POST)
	public String Member_delete(HttpServletRequest request,HttpSession session, Model model) {
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String userId = authInfo.getUserId();
		
		if(memberDao.confirmpjtowner(userId) !=null){
			model.addAttribute("msg", 
					"아직 방장권한을 인계하지 않은 프로젝트가 남아있습니다. 다시 한 번 확인 후 탈퇴 진행 해주세요.");
		}else{
			try{
				memberDao.delete(authInfo);
			}catch(Exception e){
				e.getStackTrace();
				request.setAttribute("message", "잘못된 접근입니다. 다시 시도해 주세요");
			}
			model.addAttribute("msg", "회원삭제가 완료되었습니다.");
			session.invalidate();
		}
		return "/index";
	}
}
