package com.we2.notice;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.ui.Model;

public class NoticeList implements Notice{

	@Override
	public void execute(Model model) {
		
		System.out.println("22222222222222222");
		
/*		NoticeDao dao = new NoticeDao();
		ArrayList<NoticeDto> dtos = dao.list();
		
		model.addAttribute("list", dtos);*/
	}
}
