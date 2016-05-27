package com.we2.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.activation.FileDataSource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.we2.pjtMake.PjtMakeVO;

public class We2MailSender{

	/*private JavaMailSenderImpl mailSender;
    
	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}*/
	
	@Autowired
    private JavaMailSender mailSender;
	@Autowired
    private SimpleMailMessage preConfiguredMessage;
	@Autowired
    private ServletContext servletContext;
	
	public void sendEmail(String captain, String[] usermail,PjtMakeVO pjtinfo,List<String> members)
    {
		// 첨부파일 및 이미지를 삽입하기 위한 클래스변수 MimeMessage 정의.
		MimeMessage message = mailSender.createMimeMessage();
        try {
        	// 서버 파일경로를 알아내서 저장한다.
        	String path = servletContext.getRealPath("we2/");
				System.out.println("파일경로 : " + path+"\n");
			
			// MimeMessage 를 도와주는 클래스.. -.-a
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
            
            // 여러사람 체크된 메일 받아서 InternetAddress[]에 넣는다.
            InternetAddress[] toList=new InternetAddress[usermail.length];
        		for(int i=0; i<usermail.length ; i++){ 
        			System.out.println("usermail["+i+"] : "+usermail[i]);
        			toList[i] = new InternetAddress(usermail[i]);
        			System.out.println("toList["+i+"] : "+toList[i]);
        		}
        	System.out.println("for문 끝.");
        	
			// 메일내용 앞부분
			String mailheader = 
					"<strong>안녕하세요</strong>, 반갑습니다." 
					+ "<br><img src='cid:abc'>";
			
			// 메일내용 body부분 내용을 넣을 변수.
			String mailbody=null;
			// 메일내용 body부분이 입력된 파일 불러오기.
			FileReader fr = new FileReader(path+"myproject/mailcontent/header");
			BufferedReader br = new BufferedReader(fr);
			
			// body부분이 들어있는 파일을 추가하는 작업.
			while( (mailbody=br.readLine()) != null ){
				mailheader = mailheader + mailbody; 
			}
			
			// 프로젝트 인원을 담는다.
			String pjtmember="";
			for(String memba : members){
				pjtmember = pjtmember + memba;
			}
			System.out.println("pjtmember : " + pjtmember);
			
			// 메일내용에 변수를 넣어야 하는 부분은 직접 해준다 ㅜ
			mailbody = 
				"<input type='hidden' name='pjtCode' value='"+pjtinfo.getPjtCode()+"'>"+
				"<strong>"+captain+"</strong> 님께서<br>"+
				pjtinfo.getPjtClassify()+ " - <strong>"+ pjtinfo.getPjtName() + "</strong>"+
				" 프로젝트에 당신을 초대하였습니다.<br><br>" +
				"<span style='font-weight: bold; color: purple; font-size: large;'>프로젝트 정보</span><br>" +
				"<table><tr><th>프로젝트 이름 </th><td style='padding:10px;'>  "+pjtinfo.getPjtName()+"</td></tr>"+
				"<tr><th>시작일 </th><td style='padding:10px;'>  "+pjtinfo.getStartDate()+"</td></tr>"+
				"<tr><th>마감일 </th><td style='padding:10px;'>  "+pjtinfo.getEndDate()+"</td></tr>"+
				"<tr><th>팀원 </th><td style='padding:10px;'>"+
				pjtmember
				+
				"</td></tr></table>";
			mailheader = mailheader + mailbody; 
			
			// 메일내용 뒷부분
			br = new BufferedReader(new FileReader(path+"myproject/mailcontent/footer"));
			String mailfooter="";
			// body부분이 들어있는 파일을 추가하는 작업.
			while( (mailfooter=br.readLine()) != null ){
				mailheader = mailheader + mailfooter; 
			}
			
			//디버깅 : 내용확인
				System.out.println("내용 : " + mailheader);
			
			// 메일제목설정
			messageHelper.setSubject("We2 프로젝트에 당신을 초대합니다.");
			// 메일내용 설정
            messageHelper.setText(mailheader, true);
            // "보내는사람멜주소", "보내는사람이름"
            messageHelper.setFrom("We2", "We2_admin_Team");
            // "받는사람멜주소", "받는사람이름", "인코딩"
            messageHelper.setTo(toList/*new InternetAddress(toList, "니임","UTF-8")*/);
            
            // htmlText에 들어갈 이미지 지정
            messageHelper.addInline("abc", new FileDataSource(path+"img/people_m2.png"));
            // 종합해서 메일을 보낸다.
            mailSender.send(message);
	
        } catch (MailException e) {
            e.printStackTrace();
            return;
        } catch (Throwable e) {
            e.printStackTrace();
            return;
        } //end try-catch
    }
    
}
