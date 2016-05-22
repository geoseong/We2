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
	/*int pjtCode = Integer.parseInt(request.getParameter("pjtCode"));*/
	
	@RequestMapping("/list")
	public String list(Model model) {
		/*Notice notice = new NoticeList();
		notice.execute(model);*/
		System.out.println("///////list session 받기 전.--------");
		/*String pjtCode = (String)session.getAttribute("pjtCode");*/
		String pjtCode = "20";
		//int  pjtCode = Integer.parseInt(code);
		System.out.println("/list pjtcode : "+pjtCode);
		
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
		/*session.setAttribute("pjtCode", pjtCode);*/
		//int pjtCode = Integer.parseInt((String)session.getAttribute("pjtCode"));
		/*String pjtCode = (String)session.getAttribute("pjtCode");*/
		String pjtCode = "20";
		System.out.println("/write pjtcode : "+pjtCode);
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		model.addAttribute("title", title);
		model.addAttribute("writer", writer);
		model.addAttribute("content", content);
		
		/*model.addAttribute("page", "../notice/list");*/
		model.addAttribute("content", noticeDao.write(request, pjtCode));
		
		return list(model);
	}
	
	@RequestMapping("/view")
	public String view(@RequestParam("num") String num, Model model){
		//int pjtCode = Integer.parseInt((String)session.getAttribute("pjtCode"));
		/*String pjtCode = (String)session.getAttribute("pjtCode");*/
		String pjtCode = "20";
		System.out.println("/view pjtcode : "+pjtCode);
		
		model.addAttribute("num", num);
		model.addAttribute("page", "../notice/view");
		model.addAttribute("content", noticeDao.view(num, pjtCode));
		
		return "myproject/myproject"; 
	}
	
	@RequestMapping("/modify")
	public String modify(@RequestParam("num") String num, Model model, HttpServletRequest request) {
		System.out.println("111111111111");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		model.addAttribute("num", num);
/*		model.addAttribute("title", title);
		model.addAttribute("content", content);*/
		
		//int Code = Integer.parseInt((String)session.getAttribute("pjtCode"));
		/*String pjtCode = (String)session.getAttribute("pjtCode");*/
		String pjtCode = "20";
		System.out.println("/modify pjtcode : "+pjtCode);
		
		model.addAttribute("page", "../notice/list");
		
		model.addAttribute("content", noticeDao.modify(num, request, pjtCode));
		model.addAttribute("content",noticeDao.list(pjtCode));
		
		return "myproject/myproject";
	}
	
	@RequestMapping("/modify_view")
	public String modify_view(@RequestParam("num") String num, Model model) {
		
		//int pjtCode = Integer.parseInt((String)session.getAttribute("pjtCode"));
		/*String pjtCode = (String)session.getAttribute("pjtCode");*/
		String pjtCode = "20";
		System.out.println("/modify_view pjtcode : "+pjtCode);
		
		model.addAttribute("num", num);
		model.addAttribute("content", noticeDao.view(num, pjtCode));
		model.addAttribute("page", "../notice/modify");
		
		return "myproject/myproject";
	}
	
	@RequestMapping("/delete") 
	public String delete(@RequestParam("num") String num, Model model) {
		model.addAttribute("num", num);
		model.addAttribute("page", "../notice/list");
		model.addAttribute("content", noticeDao.delete(num, model));
		
		//int pjtCode = Integer.parseInt((String)session.getAttribute("pjtCode"));
		/*String pjtCode = (String)session.getAttribute("pjtCode");*/
		String pjtCode = "20";
		System.out.println("/delete pjtcode : "+pjtCode);
		
		model.addAttribute("content",noticeDao.list(pjtCode));
		
		return "myproject/myproject";
	}
}
