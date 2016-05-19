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
@RequestMapping("/willwork")
public class WillWorkController {
	
	private WillWorkDAO2 willWorkDAO;
	public void setWillWorkDAO(WillWorkDAO2 willWorkDAO) {
		this.willWorkDAO = willWorkDAO;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String initGet(Model model) throws ParseException{
	List<WillWorkVO> results = willWorkDAO.selectAll(); 
	
	
	String divDoWork1 = results.get(0).doWork; 
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
	
	model.addAttribute("page", "../WillWork/WillWork");
	
	return "myproject/myproject";
}
	
	//�� ���� �߰����� �� ����Ǵ� ��Ʈ�ѷ�(�߰� -> ��ȸ -> ���ϳ����� )
	//Ư�� �ι��� �̸���, �Է��� ���� �Ѿ��!
	@RequestMapping(value="/willwork2", method=RequestMethod.POST)
	public String AddPost(HttpServletRequest request, Model model, String pjtCode) throws ParseException{
		String doWork = request.getParameter("inputWork"); //�Է��� ��
		String name = request.getParameter("userName"); //�ش� ���� ����
		System.out.println("���� : " +  doWork + " �̸� : " + name);
		// �̸��� ���� �߰��ϱ�
		
		willWorkDAO.insertDoWork(name, doWork, pjtcode);
		return "redirect:willwork";
	}
	
	//������ �Ϸ��ϴ� ��ư�� ������ �� ����Ǵ� Controller (������ ����� ������ȸ -> ���� ������ -> ����)
	@RequestMapping(value="/willwork3", method=RequestMethod.POST)
	public String DeletePost(HttpServletRequest request, Model model) throws ParseException{
		String complete = request.getParameter("complete"); //�����ϱ� ���� ������ ��
		String name = request.getParameter("userName"); //�ش� ���� ����
		
		List<WillWorkVO> One = willWorkDAO.selectOne(name); //������ ���� �� ����� ������ �� �ҷ���
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
		
		/*System.out.print("������ �� ����Ʈ ��� : ");
		for(int i=0; i<list.size(); i++) //������ �� �� ��� 
		{
			System.out.print(list.get(i));
		}*/
		
		//�ĸ� ���� �� ����Ʈ�� ��� ������ ��,�ĸ��� �ٿ��� �ٽ� ��ġ�� �۾�(�����Ͱ� 1���� ��� �ĸ� �Ⱥ���, 2���̻��̸� �ĸ� �ٿ�����, ���� ��� ���� ���� ����)
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
		return "redirect:willwork";
	}
}