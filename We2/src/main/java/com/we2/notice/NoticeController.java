package com.we2.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	HttpServletRequest request;
	@Autowired
	NoticeDao noticeDao;
	@Autowired
	HttpSession session;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("///////list session 받기 전.--------");
		int pjtCode = (Integer)session.getAttribute("pjtCode");
			System.out.println("/notice list pjtcode : "+pjtCode);
		
		model.addAttribute("page", "../notice/list");
		model.addAttribute("content",noticeDao.list(pjtCode));
		
		return "myproject/myproject"; 
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model){
		model.addAttribute("page", "../notice/write");
		return "myproject/myproject";
	}
	
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		int pjtCode = (Integer)session.getAttribute("pjtCode");
			System.out.println("/notice write pjtcode : "+pjtCode);
		model.addAttribute("content", noticeDao.write(request, pjtCode));
		model.addAttribute("msg", "글쓰기가 완료되었습니다.");
		return list(model);
	}
	
	@RequestMapping("/view")
	public String view(@RequestParam("num") String num, Model model){
		int pjtCode = (Integer)session.getAttribute("pjtCode");
			System.out.println("/notice view pjtcode : "+pjtCode);
		
		// <br>내용이 포함된 내용 보내기.
		String content=noticeDao.view(num, pjtCode).get(0).getContent().replace("\r\n", "<br>");
		model.addAttribute("contentbr", content);
		
		model.addAttribute("num", num);
		model.addAttribute("page", "../notice/view");
		model.addAttribute("content", noticeDao.view(num, pjtCode));
		
		return "myproject/myproject"; 
	}
	
	@RequestMapping("/modify")
	public String modify(@RequestParam("num") String num, Model model) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		model.addAttribute("num", num);

		int pjtCode = (Integer)session.getAttribute("pjtCode");
			System.out.println("/notice modify pjtcode : "+pjtCode);
		
		//model.addAttribute("page", "../notice/list");
		
		model.addAttribute("content", noticeDao.modify(num, request, pjtCode));
		//--model.addAttribute("content",noticeDao.list(pjtCode));
		model.addAttribute("msg", "수정이 완료되었습니다.");
		return list(model);
	}
	
	@RequestMapping("/modify_view")
	public String modify_view(@RequestParam("num") String num, Model model) {
		
		int pjtCode = (Integer)session.getAttribute("pjtCode");
			System.out.println("/notice modify_view pjtcode : "+pjtCode);
		
		model.addAttribute("num", num);
		model.addAttribute("content", noticeDao.view(num, pjtCode));
		model.addAttribute("page", "../notice/modify");
		
		return "myproject/myproject";
	}
	
	
	@RequestMapping("/delete") 
	public String delete(@RequestParam("num") String num, Model model) {
		model.addAttribute("num", num);
		//model.addAttribute("page", "../notice/list");
		//model.addAttribute("content", noticeDao.delete(num, model));
		
		int pjtCode = (Integer)session.getAttribute("pjtCode");
			System.out.println("/notice delete pjtcode : "+pjtCode);
		
		noticeDao.delete(num);
		//--model.addAttribute("content",noticeDao.list(pjtCode));
		
		model.addAttribute("msg", "삭제가 완료되었습니다.");
		return list(model);
	}
}
