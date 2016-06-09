package com.we2.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.we2.notice.NoticeDto;
import com.we2.pjtMake.PjtMakeVO;
import com.we2.scheduler.SchedulerBean;
import com.we2.willwork.WillWorkVO;

@Controller
public class XlsController {

	@Autowired
	ExcelService service;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	
	//엑셀파일 변환 및 다운로드
	@RequestMapping(value="/excel_transform", method=RequestMethod.GET)
	public String excelTransform(HttpSession session, 
			@RequestParam("target") String target, 
			String pjtname,
			Map<String,Object> ModelMap) throws Exception{
		
		int pjtCode = (Integer)session.getAttribute("pjtCode");
			System.out.println("/xlsctrler pjtcode : "+pjtCode);

		
		// 프로젝트 Overview
		List<PjtMakeVO> overview = service.getPjtMake(pjtCode);
		// 할 일
		List<WillWorkVO> willwork =service.getWillWork(pjtCode);
		// 공지사항
		List<NoticeDto> notice = service.getNotice(pjtCode);
		// 스케쥴러
		List<SchedulerBean> scheduler = service.getSchedule(pjtCode);
				
		ModelMap.put("overview", overview);
		ModelMap.put("willwork", willwork);
		ModelMap.put("notice", notice);
		ModelMap.put("scheduler", scheduler);
		
		ModelMap.put("target", target);
	    ModelMap.put("pjtname", pjtname);
	    
	    return "excelView";
	}
	
}
