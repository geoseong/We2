package com.we2.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.we2.pjtMake.PjtMakeVO;

public class ExcelService {

	@Autowired
	ExcelDAO dao;
	
	public List<PjtMakeVO> getAllObjects(String target){
		System.out.println("ExcelService target값 : "+target);
	      // if(target.equals("pjtmake")) {
			//List<Object> pjtMake = (List<Object>)dao.getPjtMake();
			List<PjtMakeVO> pjtMake2 = dao.getPjtMake();
			for(int i=0; i<pjtMake2.size(); i++){
				System.out.println("pjtMake List("+ i +") : " +pjtMake2.get(i).getPjtName());
			}
			
		//}
	     /*  if(target.equals("willwork")) 
	    	   return dao.getWillWork();
	       if(target.equals("notify")) 
	    	   return dao.getNotify();
	       return null;*/
	       return pjtMake2;
	}
	
}
