package com.we2.sharepjtboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/pjtBoard")
public class PjtBoardController {
	
	@Autowired
	PjtBoardService boardService;
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String listSpecificPageWork(@RequestParam("userId") String userId, Model model){
		System.out.println("-------------------------------");
		model.addAttribute("Content", boardService.getList(userId));
		System.out.println("--------------------------listSpecificPage");
		
		return "pjtBoard/view";
	}
}
