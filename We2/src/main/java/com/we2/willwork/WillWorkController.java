package com.we2.willwork;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class WillWorkController {
	
	
	private WillWorkDAO2 willWorkDAO;
	
	public void setWillWorkDAO(WillWorkDAO2 willWorkDAO) {
		this.willWorkDAO = willWorkDAO;
	}
	
	@RequestMapping(value="/willwork", method=RequestMethod.GET)
	public String test2(Model model) throws ParseException{
	List<WillWorkVO> results = willWorkDAO.selectAll();
	model.addAttribute("results", results);
	return "/WillWork/WillWork";
	}
	
	@RequestMapping(value="/willwork2", method=RequestMethod.POST)
	public String test2(HttpServletRequest request,Model model) throws ParseException{
		String doWork = request.getParameter("inputWork"); //�Է��� ��
		String name = request.getParameter("userName"); //�ش� ���� ����
		// �̸��� ���� �߰��ϱ�
		willWorkDAO.insertWillWork(name, doWork);
		
	return "/WillWork/WillWork";
	}
	
}
