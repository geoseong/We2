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
	
	public void sendEmail(String[] usermail)
    {
		// 첨부파일 및 이미지를 삽입하기 위한 클래스변수 MimeMessage 정의.
		MimeMessage message = mailSender.createMimeMessage();
        try {
        	// 서버 파일경로를 알아내서 저장한다.
        	String path = servletContext.getRealPath("WEB-INF/views/");
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
			String mailheader = "<strong>안녕하세요</strong>, 반갑습니다." 
					+ "<br><img src='cid:abc'>";
			
			// 메일내용 body부분 내용을 넣을 변수.
			String mailbody=null;
			// 메일내용 body부분이 입력된 파일 불러오기.
			FileReader fr = new FileReader(path+"mailsend");
			BufferedReader br = new BufferedReader(fr);
			
			// body부분이 들어있는 파일을 추가하는 작업.
			while( (mailbody=br.readLine()) != null ){
				mailheader = mailheader + mailbody; 
			}
			// 매일내용 뒷부분 (옵션사항 : 넣을려면 넣고..)
			String mailfooter="";
			mailheader = mailheader + mailfooter;
			
			//디버깅 : 내용확인
				System.out.println("내용 : " + mailheader);
			
			// 메일제목설정
			messageHelper.setSubject("[공지] 회원 가입 안내");
			// 메일내용 설정
            messageHelper.setText(mailheader, true);
            // "보내는사람멜주소", "보내는사람이름"
            messageHelper.setFrom("We2", "We2_admin_Team");
            // "받는사람멜주소", "받는사람이름", "인코딩"
            messageHelper.setTo(toList/*new InternetAddress(toList, "니임","UTF-8")*/);
            
            // htmlText에 들어갈 이미지 지정
            messageHelper.addInline("abc", new FileDataSource(path+"people_m2.png"));

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
