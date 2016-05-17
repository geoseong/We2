package com.we2.willwork;

import java.text.ParseException;
import java.util.ArrayList;
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
	//(처음 실행했을 때 시작하는 화면 할일나누기 -> 조회)
	@RequestMapping(value="/willwork", method=RequestMethod.GET)
	public String initGet(Model model) throws ParseException{
	List<WillWorkVO> results = willWorkDAO.selectAll(); //모든 사람에 대한 정보를 가져옴
	
	// 사람 수를 구해서 그 사람 수에 맞게 정보를 가져옴
	
	//Select All에서 받아온 모든 사람 정보를 바탕으로 1차로 각 사람마다 할 일을 나누고, 2차로 콤마로 또 나눔
	
	String divDoWork1 = results.get(0).doWork; //1번 사람에 대한 할일을 담는다.
	String divDoWork2 = results.get(1).doWork;
	String divDoWork3 = results.get(2).doWork;
	String divDoWork4 = results.get(3).doWork;
	String divDoWork5 = results.get(4).doWork;
	
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
	model.addAttribute("results", results);
	
	return "/WillWork/WillWork";
}
	
	//할 일을 추가했을 때 실행되는 컨트롤러(추가 -> 조회 -> 할일나누기 )
	//특정 인물의 이름과, 입력한 일이 넘어옴!
	@RequestMapping(value="/willwork2", method=RequestMethod.POST)
	public String AddPost(HttpServletRequest request, Model model) throws ParseException{
		String doWork = request.getParameter("inputWork"); //입력한 일
		String name = request.getParameter("userName"); //해당 유저 네임
		System.out.println("할일 : " +  doWork + " 이름 : " + name);
		// 이름과 할일 추가하기
		willWorkDAO.insertDoWork(name, doWork);
		return "redirect:willwork";
	}
	
	//할일을 완료하는 버튼을 눌렀을 때 실행되는 Controller (선택한 사람의 정보조회 -> 할일 나누기 -> 제거)
	@RequestMapping(value="/willwork3", method=RequestMethod.POST)
	public String DeletePost(HttpServletRequest request, Model model) throws ParseException{
		String complete = request.getParameter("complete"); //제거하기 위해 선택한 일
		String name = request.getParameter("userName"); //해당 유저 네임
		
		List<WillWorkVO> One = willWorkDAO.selectOne(name); //네임을 통해 한 사람의 정보를 쫙 불러옴
		String doWork = One.get(0).doWork; //그 사람의 할일을 쫙 나열
		String[] doWorkList = doWork.split(","); //컴마로 구분된 문자열을 나눠서 배열에 담는다.
		ArrayList<String> list = new ArrayList<String>(); //컴마를 제거한 할 일을 리스트에 저장
		for(int i=0; i<doWorkList.length; i++)
		{
			list.add(doWorkList[i]);
		}
		
		for(int i=0; i<list.size(); i++) //리스트와 비교해서 선택한 값을 제거 
		{
			if(complete.trim().equals(list.get(i).trim()))
			{
				System.out.println("제거한 값은 : " + list.get(i));
				list.remove(i);
			}
		}
		
		/*System.out.print("제거한 후 리스트 목록 : ");
		for(int i=0; i<list.size(); i++) //제거한 후 의 목록 
		{
			System.out.print(list.get(i));
		}*/
		
		//컴마 제거 후 리스트에 담고 제거한 뒤,컴마를 붙여서 다시 합치는 작업(데이터가 1개인 경우 컴마 안붙임, 2개이상이면 컴마 붙여야함, 없는 경우 없는 값을 전달)
				String rebuild = "";
				
				if(list.size()==1){
					rebuild += list.get(0); 
				}
				
				if(list.size()>1){ //리스트 값이 2개 이상이면 컴마를 붙여서 연결
				for(int i=0; i<list.size();i++){
					rebuild += list.get(i)+",";
				}
				System.out.println();
				//System.out.println("rebuild 된 String 값 : " + rebuild);
				rebuild = rebuild.substring(0, rebuild.length()-1);
				//System.out.println("rebuild 수정 후 String 값 : " + rebuild);
				}
				if(list.size()==0)
				{
					rebuild = "";
				}
				
				//complete은 할일 완료라고 내가 선택한 거니까 doneWork에서 추가를 해주되 .. 값이 있을때만 컴마를 넣어주어야 하는데..이게문제  
				//rebuild는 complete을 제거하고 
		if(complete!=null){
		willWorkDAO.updateWillWork(name, rebuild);
		}
		
		willWorkDAO.insertDoneWork(name, complete);
		//List<WillWorkVO> results = willWorkDAO.selectAll();//모든 사람 정보를 가져옴
		//model.addAttribute("results", results);
		return "redirect:willwork";
	}
}
