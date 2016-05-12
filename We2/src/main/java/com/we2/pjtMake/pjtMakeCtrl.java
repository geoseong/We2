package com.we2.pjtMake;

import java.text.ParseException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String test2(@ModelAttribute PjtMakeVO pjtMakeVO) throws ParseException{
		System.out.println(pjtMakeVO.getPjtName());
		System.out.println(pjtMakeVO.getPjtClassify());
		System.out.println(pjtMakeVO.getStartDate());
		System.out.println(pjtMakeVO.getEndDate());
	pjtMakeDAO.insertPjtMake(pjtMakeVO);
	return "/pjtMake/test";
	}
}