package com.we2.willwork;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
   System.out.println("첫번째줄 너왔니?");
  
   int pjtCode =(int)session.getAttribute("pjtCode");
   		System.out.println("코드 세션테스트 : " + pjtCode);
   int countPeople = willWorkDAO.selectPeople(pjtCode);
   		System.out.println("이 프로젝트에 참여중인 사람수는 : "+countPeople);
   List<WillWorkVO> results = willWorkDAO.selectAll(pjtCode);

   String divDoWork1="";
   String divDoWork2="";
   String divDoWork3="";
   String divDoWork4="";
   String divDoWork5="";
   
   
   if(countPeople==1)
   {
	   System.out.println("debug1..");
   divDoWork1 = results.get(0).doWork; 
   		System.out.println("debug2..");
   String [] divWorkList1 = divDoWork1.split(","); 
   		System.out.println("debug3..");
   model.addAttribute("divWorkList1", divWorkList1);
   }
   else if(countPeople==2)
   {
	   divDoWork1 = results.get(0).doWork; 
	   		System.out.println("debug2-1..");
	   String [] divWorkList1 = divDoWork1.split(","); 
	   		System.out.println("debug2-2..");
	   		
	   divDoWork2 = results.get(1).doWork;
	   		System.out.println("debug2-3..");
	   String [] divWorkList2 = divDoWork2.split(","); 
	   		System.out.println("debug2-4..");
	   model.addAttribute("divWorkList1", divWorkList1);
	   model.addAttribute("divWorkList2", divWorkList2);
   }
   else if(countPeople==3)
   {
	   divDoWork1 = results.get(0).doWork; 
	   divDoWork2 = results.get(1).doWork;
	   divDoWork3 = results.get(2).doWork;
	   String [] divWorkList1 = divDoWork1.split(",");
	   String [] divWorkList2 = divDoWork2.split(",");
	   String [] divWorkList3 = divDoWork3.split(",");
	   model.addAttribute("divWorkList1", divWorkList1);
	   model.addAttribute("divWorkList2", divWorkList2);
	   model.addAttribute("divWorkList3", divWorkList3);
   }
   else if(countPeople==4)
   {
	   divDoWork1 = results.get(0).doWork; 
	   divDoWork2 = results.get(1).doWork;
	   divDoWork3 = results.get(2).doWork;
	   divDoWork4 = results.get(3).doWork;
	   String [] divWorkList1 = divDoWork1.split(",");
	   String [] divWorkList2 = divDoWork2.split(",");
	   String [] divWorkList3 = divDoWork3.split(",");
	   String [] divWorkList4 = divDoWork4.split(",");
	   model.addAttribute("divWorkList1", divWorkList1);
	   model.addAttribute("divWorkList2", divWorkList2);
	   model.addAttribute("divWorkList3", divWorkList3);
	   model.addAttribute("divWorkList4", divWorkList4);
   }
   else if(countPeople==5)
   {
	   divDoWork1 = results.get(0).doWork; 
	   divDoWork2 = results.get(1).doWork;
	   divDoWork3 = results.get(2).doWork;
	   divDoWork4 = results.get(3).doWork;
	    divDoWork5 = results.get(4).doWork;
	    
	   System.out.println("세번째 줄 너 왔니?");
	   String [] divWorkList1 = divDoWork1.split(",");
	   String [] divWorkList2 = divDoWork2.split(",");
	   String [] divWorkList3 = divDoWork3.split(",");
	   String [] divWorkList4 = divDoWork4.split(",");
	   String [] divWorkList5 = divDoWork5.split(",");
	  
	   model.addAttribute("divWorkList1", divWorkList1);
	   model.addAttribute("divWorkList2", divWorkList2);
	   model.addAttribute("divWorkList3", divWorkList3);
	   model.addAttribute("divWorkList4", divWorkList4);
	   model.addAttribute("divWorkList5", divWorkList5);
   }
  
   
  /* divDoWork1 = results.get(0).doWork; 
   divDoWork2 = results.get(1).doWork;
   divDoWork3 = results.get(2).doWork;
   divDoWork4 = results.get(3).doWork;
    divDoWork5 = results.get(4).doWork;
    
   System.out.println("세번째 줄 너 왔니?");
   String [] divWorkList1 = divDoWork1.split(",");
   String [] divWorkList2 = divDoWork2.split(",");
   String [] divWorkList3 = divDoWork3.split(",");
   String [] divWorkList4 = divDoWork4.split(",");
   String [] divWorkList5 = divDoWork5.split(",");
  
   model.addAttribute("divWorkList1", divWorkList1);
   model.addAttribute("divWorkList2", divWorkList2);
   model.addAttribute("divWorkList3", divWorkList3);
   model.addAttribute("divWorkList4", divWorkList4);
   model.addAttribute("divWorkList5", divWorkList5);*/
   
   model.addAttribute("countPeople", countPeople);
   model.addAttribute("results", results);
   model.addAttribute("page", "../WillWork/WillWork");
   return "myproject/myproject";
}
   
   @RequestMapping(value="/willwork2", method=RequestMethod.POST)
   public String AddPost(HttpServletRequest request, Model model, HttpSession session) throws ParseException{
      String doWork = request.getParameter("inputWork"); //�Է��� ��
      String name = request.getParameter("userName"); //�ش� ���� ����
      System.out.println("할일 : " +  doWork + " 이름 : " + name);
      
      int pjtCode =(int)session.getAttribute("pjtCode");
      willWorkDAO.insertDoWork(name, doWork, pjtCode);
      return "redirect:/willwork/list";
   }
   
   @RequestMapping(value="/willwork3", method=RequestMethod.POST)
   public String DeletePost(HttpServletRequest request, Model model, HttpSession session) throws ParseException{
      String complete = request.getParameter("complete"); 
      String name = request.getParameter("userName");
      int pjtCode =(int)session.getAttribute("pjtCode");
      
      List<WillWorkVO> One = willWorkDAO.selectOne(name, pjtCode); //������ ���� �� ����� ������ �� �ҷ���
      String doWork = One.get(0).doWork; //�� ����� ������ �� ����
      String[] doWorkList = doWork.split(","); //�ĸ��� ���е� ���ڿ��� ������ �迭�� ��´�.
      ArrayList<String> list = new ArrayList<String>(); //�ĸ��� ������ �� ���� ����Ʈ�� ����
      for(int i=0; i<doWorkList.length; i++)
      {
         list.add(doWorkList[i]);
      }
      
      for(int i=0; i<list.size(); i++) //����Ʈ�� ���ؼ� ������ ���� ���� 
      {
         if(complete.trim().equals(list.get(i).trim()))
         {
            System.out.println("������ ���� : " + list.get(i));
            list.remove(i);
         }
      }
      
            String rebuild = "";
            if(list.size()==1){
               rebuild += list.get(0); 
            }
            if(list.size()>1){ //����Ʈ ���� 2�� �̻��̸� �ĸ��� �ٿ��� ����
            for(int i=0; i<list.size();i++){
               rebuild += list.get(i)+",";
            }
            System.out.println();
            //System.out.println("rebuild �� String �� : " + rebuild);
            rebuild = rebuild.substring(0, rebuild.length()-1);
            //System.out.println("rebuild ���� �� String �� : " + rebuild);
            }
            if(list.size()==0)
            {
               rebuild = "";
            }
            
            //complete�� ���� �Ϸ��� ���� ������ �Ŵϱ� doneWork���� �߰��� ���ֵ� .. ���� �������� �ĸ��� �־��־�� �ϴµ�..�̰Թ���  
            //rebuild�� complete�� �����ϰ� 
      if(complete!=null){
      willWorkDAO.updateWillWork(name, rebuild);
      }
      
      willWorkDAO.insertDoneWork(name, complete);
      //List<WillWorkVO> results = willWorkDAO.selectAll();//��� ��� ������ ������
      //model.addAttribute("results", results);
      return "redirect:/willwork/list";
   }
}