package com.we2.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ExcelService {

	@Autowired
	ExcelDAO dao;
	
	public List<Object> getAllObjects(String target){
		
	       if(target.equals("article")) 	   
	    	   return dao.getPjtMake();
	       if(target.equals("comment")) 
	    	   return dao.getWillWork();
	       if(target.equals("file")) 
	    	   return dao.getNotify();
	       return null;
	}
	
}
