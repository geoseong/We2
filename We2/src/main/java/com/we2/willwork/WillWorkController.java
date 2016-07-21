package com.we2.willwork;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/willwork")
public class WillWorkController {
   
   private WillWorkDAO2 willWorkDAO;
   public void setWillWorkDAO(WillWorkDAO2 willWorkDAO) {
      this.willWorkDAO = willWorkDAO;
   }
   
   @RequestMapping(value="/list", method=RequestMethod.GET)
   public String initGet(Model model, HttpSession session) throws ParseException{

	   int pjtCode =(Integer)session.getAttribute("pjtCode");
	   int countPeople = willWorkDAO.selectPeople(pjtCode);
	   List<WillWorkVO> results = willWorkDAO.selectAll(pjtCode);
 
      Map<Integer, String[]> map = new HashMap<Integer, String[]>();
      
	     for(int i=1; i < countPeople+1; i++){	
		   	map.put(i, results.get(i-1).doWork.split(","));
		   	model.addAttribute("divWorkList"+i , map.get(i));
	     }
	   model.addAttribute("countPeople", countPeople);
	   model.addAttribute("results", results);
	   model.addAttribute("page", "../WillWork/WillWork");
	   model.addAttribute("count", 1);
	   return "myproject/myproject";
}
   
   @RequestMapping(value="/willwork2", method=RequestMethod.POST)
   public String AddPost(HttpServletRequest request, Model model, HttpSession session){
      String doWork = request.getParameter("inputWork"); 
      String name = request.getParameter("userName"); 
      
      int pjtCode =(Integer)session.getAttribute("pjtCode");
      
      // doWork 컬럼이 비어있는 지 확인하기
      String isDoWorkEmpty = willWorkDAO.selectOne(name, pjtCode).get(0).getDoWork();
      String isEmpty="";
      	System.out.println("isDoWorkEmpty의 내용 : " + isDoWorkEmpty);
      	if(!isDoWorkEmpty.isEmpty()){
      		isEmpty=isDoWorkEmpty;
      	}
      // 할 일 추가하기
      willWorkDAO.insertDoWork(name, isEmpty, doWork, pjtCode);
      
      return "redirect:/willwork/list";
   }
   
   @RequestMapping(value="/willwork3", method=RequestMethod.POST)
   public String DeletePost(HttpServletRequest request, Model model, HttpSession session) throws ParseException{
      String complete = request.getParameter("complete"); 
      String name = request.getParameter("userName");
      int pjtCode =(Integer)session.getAttribute("pjtCode");
      
      List<WillWorkVO> One = willWorkDAO.selectOne(name, pjtCode); 
      String doWork = One.get(0).doWork; 
      String[] doWorkList = doWork.split(","); 
      ArrayList<String> list = new ArrayList<String>(); 
      for(int i=0; i<doWorkList.length; i++)  {
         list.add(doWorkList[i]);
      }
      
      for(int i=0; i<list.size(); i++)  {
         if(complete.trim().equals(list.get(i).trim())) {
            System.out.println("WillWorkDAO list.get("+i+") : " + list.get(i));
            list.remove(i);
         }
      }
      
        String rebuild = "";
            if(list.size()==1){
               rebuild += list.get(0); 
            }
            if(list.size()>1){ 
	            for(int i=0; i<list.size();i++){
	               rebuild += list.get(i)+",";
	            }
	            rebuild = rebuild.substring(0, rebuild.length()-1);
            }
            if(list.size()==0) {
               rebuild = "";
            }
            
      if(complete!=null){
    	  willWorkDAO.updateWillWork(name, rebuild);
      }
      
      willWorkDAO.updateDoneWork(name, complete);
      return "redirect:/willwork/list";
   }
}