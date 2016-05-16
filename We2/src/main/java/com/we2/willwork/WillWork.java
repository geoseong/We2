package com.we2.willwork;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/willwork.do")
public class WillWork extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WillWorkDAO pDao = WillWorkDAO.getInstance();
		
		// �Ӹ����� ���Ѵ�.
		int pjtcode = 0;
		int counts = pDao.Pjtcount(pjtcode);
		
		// �Ӹ�����ŭ userid�� �迭�� �޴´�.
		String[] users = new String[counts];
		
		// ����� ����Ʈ�� �迭�� �ޱ�
		users=pDao.Pjtlists(pjtcode);	

		//�ش� ������Ʈ�� ���� ��� ������ ����.
	
		List<WillWorkVO> willWork = pDao.selectpjtusers(pjtcode);		
		request.setAttribute("WillWork", willWork);		
			
		//����� ���� �̸�(name)�� ����� userid �迭�� �̿��Ͽ� �޾Ƴ��� request�� ������
		for(int i=0; i<users.length; i++){
			String userName = pDao.userName(users[i]);
			request.setAttribute("username"+i, userName);
		}
				
	// ���������� �����ִ� �迭�� ����Ͽ� �ؾ� �� �� ����Ʈ �̾Ƽ� setAttribute��Ŵ
		// �� �������� List, String[], String ������ �ϳ��� �����ϰ� ����.
		
		// 1. ',' ������ ������ �� �׸��� �迭������ �����ϱ� ���� ����.
		String[] doworklist0=null;
		String[] doworklist1=null;
		String[] doworklist2=null;
		String[] doworklist3=null;
		String[] doworklist4=null;
	
		String[] doneworklist0=null;
		String[] doneworklist1=null;
		String[] doneworklist2=null;
		String[] doneworklist3=null;
		String[] doneworklist4=null;
		
		// 2. SQL���� ������� �����ϴ� String ���� ����
		String dowork0=null;
		String dowork1=null;
		String dowork2=null;
		String dowork3=null;
		String dowork4=null;
		
		String donework0=null;
		String donework1=null;
		String donework2=null;
		String donework3=null;
		String donework4=null;
		
		// 3. SQL���� ������� �޴� List�迭 ���� - ����� �迭�� �ϳ��� �־ ���ϰ� �� ���� List�迭�� �޴´�.
		List<WillWorkVO> doWork0=pDao.doworklist(users[0]);
		List<WillWorkVO> doWork1=pDao.doworklist(users[1]);
		List<WillWorkVO> doWork2=pDao.doworklist(users[2]);
		List<WillWorkVO> doWork3=pDao.doworklist(users[3]);
		List<WillWorkVO> doWork4=pDao.doworklist(users[4]);
		
		// 4. request������ DB���� doWork, doneWork ���� ������.
		request.setAttribute("user0", doWork0);
		request.setAttribute("user1", doWork1);
		request.setAttribute("user2", doWork2);
		request.setAttribute("user3", doWork3);
		request.setAttribute("user4", doWork4);

		/*${user0}.doWork��� ����ϸ� doWork�� ��� ������ ��µ�*/
		/*${user0}.doneWork��� ����ϸ� doneWork�� ��� �Ϸ��� ���� ��µ�*/
		
		// 4-1. �迭�� �� ���� �����ϱ� ���� ���� 
		//List<WillWorkVO> �������� 0��° �� (����� 1�� ���̱� ������ )�� String������ ����
		dowork0=doWork0.get(0).getDoWork();
		dowork1=doWork1.get(0).getDoWork();
		dowork2=doWork2.get(0).getDoWork();
		dowork3=doWork3.get(0).getDoWork();
		dowork4=doWork4.get(0).getDoWork();

		donework0=doWork0.get(0).getDoneWork();
		donework1=doWork0.get(0).getDoneWork();
		donework2=doWork0.get(0).getDoneWork();
		donework3=doWork0.get(0).getDoneWork();
		donework4=doWork0.get(0).getDoneWork();

		// 4-2. ',' ������ ������ �� �׸��� �迭������ ����
		doworklist0=dowork0.split(",");
		doworklist1=dowork1.split(",");
		doworklist2=dowork2.split(",");
		doworklist3=dowork3.split(",");
		doworklist4=dowork4.split(",");

		
		doneworklist0=donework0.split(",");	
		doneworklist1=donework1.split(",");	
		doneworklist2=donework2.split(",");	
		doneworklist3=donework3.split(",");	
		doneworklist4=donework4.split(",");	
	
			
		
		/**select�� �ؼ� ..
		String donework0 : ��� ������ ����Ǿ� �ִ�..

		a : �� ���� �迭�� ,�� ����
		b : �Ϸ� �������� �迭�� �޾Ƽ� �� �ε����� ����
		
		a==b 
		���ϰ� �Ϸ��� ���� �ߺ��Ǹ�

		 true : �Ϸ��� �Ͽ� �߰�. / false : �� ���� �����.
			
		true�̸� ���� �Ƚ�Ŵ			----> �Ϸ��� �� String ������ �߰�.
		false�� ���� 

		String += �����۴� ���ٷ� ��ħ
		�׸��� doWork �÷��� Update.

		doneWork �÷��� Select�� ������.
		+�Ϸ��� �� string�� ���ļ� doneWork �÷��� Update.*/
		
		//a --- 5�� �ο��� ���°���� �� ���캼 ��.
		// : doworklist0=dowork0.split(",");
		
		//b
		String[] worklist=null;
		
		//a==b true / false String ����
		String istrue = "";
		String isfalse = "";
		
		
		/** ������� user ���� if������ �Ǻ��ؼ� �ֱ�*/

		// üũ�� �� �޴� �迭.
		if(request.getAttribute("workarray")!=null){
			
			String username = (String)request.getAttribute("username");
				System.out.println("willwork3 - username : " + username);

			// jsp���� �޾ƿ� username�� DAO���� ���� name�� ���ؼ� �Ʒ� �ڵ��� �Ǻ��� �ֱ�
			String[] compareuser = null;
			if( username.equals(doWork0.get(0).getName()) ){
				compareuser = doworklist0;			
			}else if( username.equals(doWork1.get(0).getName()) ){
				compareuser = doworklist1;
			}else if( username.equals(doWork2.get(0).getName()) ){
				compareuser = doworklist2;
			}else if( username.equals(doWork3.get(0).getName()) ){
				compareuser = doworklist3;
			}else if( username.equals(doWork4.get(0).getName()) ){
				compareuser = doworklist4;
			}
			System.out.println("����� ����� ����:"+compareuser[0]);
			
			//ArrayList�� ���Ͽ� ���� ��ü ������ ����
			ArrayList<String> list = new ArrayList<String>();
			for(int i=0; i<compareuser.length; i++){
				list.add(compareuser[i]);
			}
			
			worklist = (String[])request.getAttribute("workarray");

		
			for(int i=0; i<compareuser.length; i++){
				for(int j=0; j<worklist.length; j++){
					if(compareuser[i].trim().equals(worklist[j].trim())){
						/*istrue+=", "+doworklist1[i];
						isequal[j]=doworklist1[i];
						System.out.println("isequal - "+isequal[j]);
						System.out.println(doworklist1[i] +"--"+worklist[j]+ " : ��ġ");*/	
						list.remove(compareuser[i]);			
					}else{
						//isfalse+=worklist[j];
				//System.out.println(doworklist1[i] +"--"+worklist[j]+ " : ����ġ");						
					} //end if
				}
			} //end for
			
			//remove �� list�� ����غ���
			for(int i=0; i<list.size();i++){
				istrue += list.get(i)+", ";
				System.out.println("�ؾ� �� �Ͽ� ���ƾ� �ϴ� �� : " + list.get(i));
				
			}
			
			for(int i=0; i<worklist.length;i++){
				isfalse += worklist[i]+", ";
				System.out.println("�ؾ� �� �Ͽ��� ���ܽ��Ѿ� �ϴ� �� : " + worklist[i]);
			}
			
			isfalse = isfalse.substring(0, isfalse.length()-2);
				System.out.println("��ǥ�� �� isfalse : " + isfalse);
			
			istrue = istrue.substring(0, istrue.length()-2);
				System.out.println("��ǥ�� �� istrue : " + istrue);
			
			
		pDao.inputdoWork(istrue, username);
		pDao.inputdoneWork(isfalse, username);
		
		} //end if

		// setAttribute - �ؾ� �� ��
		request.setAttribute("dowork0", doworklist0);
		request.setAttribute("dowork1", doworklist1);
		request.setAttribute("dowork2", doworklist2);
		request.setAttribute("dowork3", doworklist3);
		request.setAttribute("dowork4", doworklist4);
		
		// setAttribute - �Ϸ� �� ��
		request.setAttribute("donework0", doneworklist0);
		request.setAttribute("donework1", doneworklist1);
		request.setAttribute("donework2", doneworklist2);
		request.setAttribute("donework3", doneworklist3);
		request.setAttribute("donework4", doneworklist4);
		
		System.out.println("--------������� �����");
		if(request.getAttribute("redirect")!=null){
			response.sendRedirect("willwork.do");
		}else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("WillWork.jsp");
			dispatcher.forward(request, response);
		}
		
		
	} //end doGet
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
