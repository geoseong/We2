/*package com.we2.willwork;

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
		
		// 머릿수를 구한다.
		int pjtcode = 0;
		int counts = pDao.Pjtcount(pjtcode);
		
		// 머릿수만큼 userid를 배열로 받는다.
		String[] users = new String[counts];
		
		// 사용자 리스트를 배열로 받기
		users=pDao.Pjtlists(pjtcode);	

		//해당 프로젝트에 대한 모든 정보를 추출.
	
		List<WillWorkVO> willWork = pDao.selectpjtusers(pjtcode);		
		request.setAttribute("WillWork", willWork);		
			
		//사용자 실제 이름(name)을 사용자 userid 배열을 이용하여 받아내서 request에 보내기
		for(int i=0; i<users.length; i++){
			String userName = pDao.userName(users[i]);
			request.setAttribute("username"+i, userName);
		}
				
	// 유저정보를 갖고있는 배열를 사용하여 해야 할 일 리스트 뽑아서 setAttribute시킴
		// 각 유저마다 List, String[], String 변수를 하나씩 보유하고 있음.
		
		// 1. ',' 단위로 나눠진 각 항목을 배열변수에 저장하기 위해 정의.
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
		
		// 2. SQL문의 결과값을 저장하는 String 변수 정의
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
		
		// 3. SQL문의 결과값을 받는 List배열 정의 - 사용자 배열을 하나씩 넣어서 할일과 한 일을 List배열로 받는다.
		List<WillWorkVO> doWork0=pDao.doworklist(users[0]);
		List<WillWorkVO> doWork1=pDao.doworklist(users[1]);
		List<WillWorkVO> doWork2=pDao.doworklist(users[2]);
		List<WillWorkVO> doWork3=pDao.doworklist(users[3]);
		List<WillWorkVO> doWork4=pDao.doworklist(users[4]);
		
		// 4. request영역에 DB안의 doWork, doneWork 값을 보낸다.
		request.setAttribute("user0", doWork0);
		request.setAttribute("user1", doWork1);
		request.setAttribute("user2", doWork2);
		request.setAttribute("user3", doWork3);
		request.setAttribute("user4", doWork4);

		${user0}.doWork라고 출력하면 doWork의 모든 할일이 출력됨
		${user0}.doneWork라고 출력하면 doneWork의 모든 완료한 일이 출력됨
		
		// 4-1. 배열에 할 일을 저장하기 위한 과정 
		//List<WillWorkVO> 변수값의 0번째 값 (결과가 1행 뿐이기 떄문에 )을 String변수에 저장
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

		// 4-2. ',' 단위로 나눠진 각 항목을 배열변수에 저장
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
	
			
		
		*//**select를 해서 ..
		String donework0 : 모든 할일이 저장되어 있는..

		a : 할 일을 배열로 ,로 나눔
		b : 완료 아이템을 배열로 받아서 각 인덱스에 저장
		
		a==b 
		할일과 완료한 일이 중복되면

		 true : 완료한 일에 추가. / false : 할 일을 지우기.
			
		true이면 포함 안시킴			----> 완료할 일 String 영역에 추가.
		false면 포함 

		String += 아이템다 한줄로 합침
		그리고 doWork 컬럼을 Update.

		doneWork 컬럼을 Select로 가져옴.
		+완료할 일 string을 합쳐서 doneWork 컬럼에 Update.*//*
		
		//a --- 5명 인원중 몇번째인지 잘 살펴볼 것.
		// : doworklist0=dowork0.split(",");
		
		//b
		String[] worklist=null;
		
		//a==b true / false String 변수
		String istrue = "";
		String isfalse = "";
		
		
		*//** 여기부터 user 변수 if문으로 판별해서 넣기*//*

		// 체크한 걸 받는 배열.
		if(request.getAttribute("workarray")!=null){
			
			String username = (String)request.getAttribute("username");
				System.out.println("willwork3 - username : " + username);

			// jsp에서 받아온 username과 DAO에서 받은 name을 비교해서 아래 코딩에 판별해 넣기
			String[] compareuser = null;
			if( username.equals(doWork0.get(0).getName()) ){
				compareuser = doworklist0; //컴마를 나누어 놓은 첫 번째 사람 할 일			
			}else if( username.equals(doWork1.get(0).getName()) ){
				compareuser = doworklist1; //두 번째 사람 할 일
			}else if( username.equals(doWork2.get(0).getName()) ){
				compareuser = doworklist2; //세 번째 사람 할 일
			}else if( username.equals(doWork3.get(0).getName()) ){
				compareuser = doworklist3; // 네 번째 사람 할 일
			}else if( username.equals(doWork4.get(0).getName()) ){
				compareuser = doworklist4; //다섯 번째 사람 할 일
			}
			System.out.println("지목된 사람의 할일:"+compareuser[0]);
			
			//ArrayList에 할일에 대한 전체 데이터 저장
			ArrayList<String> list = new ArrayList<String>();
			for(int i=0; i<compareuser.length; i++){
				list.add(compareuser[i]);
			}
			
			worklist = (String[])request.getAttribute("workarray");

		
			for(int i=0; i<compareuser.length; i++){
				for(int j=0; j<worklist.length; j++){
					if(compareuser[i].trim().equals(worklist[j].trim())){
						istrue+=", "+doworklist1[i];
						isequal[j]=doworklist1[i];
						System.out.println("isequal - "+isequal[j]);
						System.out.println(doworklist1[i] +"--"+worklist[j]+ " : 일치");	
						list.remove(compareuser[i]);			
					}else{
						//isfalse+=worklist[j];
				//System.out.println(doworklist1[i] +"--"+worklist[j]+ " : 불일치");						
					} //end if
				}
			} //end for
			
			//remove 후 list를 출력해보면
			for(int i=0; i<list.size();i++){
				istrue += list.get(i)+", ";
				System.out.println("해야 할 일에 남아야 하는 값 : " + list.get(i));
			}
			
			for(int i=0; i<worklist.length;i++){
				isfalse += worklist[i]+", ";
				System.out.println("해야 할 일에서 제외시켜야 하는 값 : " + worklist[i]);
			}
			
			isfalse = isfalse.substring(0, isfalse.length()-2);
				System.out.println("쉼표를 뺀 isfalse : " + isfalse);
			
			istrue = istrue.substring(0, istrue.length()-2);
				System.out.println("쉼표를 뺀 istrue : " + istrue);
			
			
		pDao.inputdoWork(istrue, username);
		pDao.inputdoneWork(isfalse, username);
		
		} //end if

		// setAttribute - 해야 할 일
		request.setAttribute("dowork0", doworklist0);
		request.setAttribute("dowork1", doworklist1);
		request.setAttribute("dowork2", doworklist2);
		request.setAttribute("dowork3", doworklist3);
		request.setAttribute("dowork4", doworklist4);
		
		// setAttribute - 완료 한 일
		request.setAttribute("donework0", doneworklist0);
		request.setAttribute("donework1", doneworklist1);
		request.setAttribute("donework2", doneworklist2);
		request.setAttribute("donework3", doneworklist3);
		request.setAttribute("donework4", doneworklist4);
		
		System.out.println("--------여기까지 실행됨");
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
*/