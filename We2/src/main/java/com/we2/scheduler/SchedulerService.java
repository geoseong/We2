package com.we2.scheduler;


import java.text.ParseException;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SchedulerService {

	@Autowired
	private SchedulerMapper schedulerMapper;
	
	public ArrayList<SchedulerBean> getlist(int pjtcode) throws ParseException{
		System.out.println("schedulerservice getList");
		return schedulerMapper.getList(pjtcode);
	}
	
	public SchedulerBean getSearchbycalendarmemo_num(int calendarmemo_num){
		return this.schedulerMapper.getSearchbycalendarmemo_num(calendarmemo_num);
	}
	

	public void insertScheduler (SchedulerBean schedulerBean){
		System.out.println("게시물 insert 완료.");
		schedulerMapper.insertScheduler(schedulerBean);
	}
	public void deleteScheduler(int calendarmemo_num){
		this.schedulerMapper.deleteScheduler(calendarmemo_num);
		
	}
	
	public void updateScheduler(
			 int pjtcode,
			 int calendarmemo_num,
			 int calendarmemo_year, 
			 int calendarmemo_month, 
			 int calendarmemo_day, 
			 String calendarmemo_contents
			){
		System.out.println("studyroomservice updaterow");
		this.schedulerMapper.updateScheduler(pjtcode, calendarmemo_num, calendarmemo_year, calendarmemo_month, calendarmemo_day, calendarmemo_contents);
	}
}

