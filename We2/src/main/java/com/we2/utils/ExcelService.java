package com.we2.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.we2.notice.NoticeDto;
import com.we2.pjtMake.PjtMakeVO;
import com.we2.scheduler.SchedulerBean;
import com.we2.willwork.WillWorkVO;

public class ExcelService {

	@Autowired
	ExcelDAO dao;
	/*public void setDao(ExcelDAO dao){
		this.dao=dao;
	}*/
	
	public List<PjtMakeVO> getPjtMake(int pjtCode){
		List<PjtMakeVO> pjtMake2 = dao.getPjtMake(pjtCode);
	    return pjtMake2;
	}
	
	public List<WillWorkVO> getWillWork(int pjtCode){
		List<WillWorkVO> willwork = dao.getWillWork(pjtCode);
		return willwork;
	}
	
	public List<NoticeDto> getNotice(int pjtCode){
		 List<NoticeDto> notice = dao.getNotice(pjtCode);
		 return notice;
	}
	
	public List<SchedulerBean> getSchedule(int pjtCode){
		List<SchedulerBean> scheduler = dao.getSchedule(pjtCode);
		return scheduler;
	}
	
}
