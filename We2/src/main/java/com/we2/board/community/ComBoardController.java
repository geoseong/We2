package com.we2.board.community;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/comm_board")
public class ComBoardController {

	@RequestMapping
	public String comm_board(Model model){
		model.addAttribute("cnt", "hellow");
		System.out.println("comm_board 경로 , comm_board/cb_index.jsp 리턴 메서드");
		return "/comm_board/cb_index";
	}
	
	@RequestMapping(value="/offer")
	public String offer(){
		System.out.println("comm_board/offer 경로 , comm_board/offer.jsp 리턴 메서드");
		return "/comm_board/offer";
	}
	
	@RequestMapping(value="/blabla")
	public String blabla(){
		System.out.println("comm_board/offer 경로 , comm_board/blabla.jsp 리턴 메서드");
		return "/comm_board/blabla";
	}
}
