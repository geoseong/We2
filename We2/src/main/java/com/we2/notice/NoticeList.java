package com.we2.notice;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.ui.Model;

public class NoticeList implements Notice{

	@Override
	public void execute(Model model) {
		
/*		NoticeDao dao = new NoticeDao();
		ArrayList<NoticeDto> dtos = dao.list();
		
		model.addAttribute("list", dtos);*/
	}
}
