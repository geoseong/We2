package com.we2.pjtMake;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class pjtMakeCtrl{
	
	@RequestMapping(value="/pjtMake", method=RequestMethod.GET)
	public String test(){
		return "pjtMake/pjtMake";
	}
	
	@RequestMapping(value="test", method=RequestMethod.POST)
	public String test2(HttpServletRequest httpServletRequest , Model model){
		
		String pjtName = httpServletRequest.getParameter("pjtName");
		String classify = httpServletRequest.getParameter("classify");
		String term1 = httpServletRequest.getParameter("term1");
		String term2 = httpServletRequest.getParameter("term2");
		
		model.addAttribute("pjtName", pjtName);
		model.addAttribute("classify", classify);
		model.addAttribute("term1", term1);
		model.addAttribute("term2", term2);
		
		return "test";
	}
}
