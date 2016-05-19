package com.we2.pjtMake;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.io.*;
import java.util.*;

public class MailSend{
	
	public static void main(String[] args) {
		Properties p = new Properties();
		p.put("mail.smtp.user", "hyuk9658@gmail.com"); // Google계정 아이디@gmail.com으로 설정
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");

		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");

		// Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getDefaultInstance(p, auth);
			session.setDebug(true); // 메일을 전송할 때 상세한 상황을 콘솔에 출력한다.

			// session = Session.getDefaultInstance(p);
			MimeMessage msg = new MimeMessage(session);
			String message = "Gmail SMTP 서버를 이용한 JavaMail 테스트";
			msg.setSubject("OOO님이 당신을 초대합니다. We2");
			Address fromAddr = new InternetAddress("hyuk9658@gmail.com"); // 보내는 사람의 메일주소
			msg.setFrom(fromAddr);
			Address toAddr = new InternetAddress("hyuk9658@naver.com"); // 받는 사람의 메일주소
			msg.addRecipient(Message.RecipientType.TO, toAddr);
			/*
			 * msg.setContent(message, "text/plain;charset=KSC5601");
			 * System.out.println("Message: " + msg.getContent());
			 * Transport.send(msg);
			 */
			BodyPart messageBodyPart = new MimeBodyPart();

			// Fill the message
			messageBodyPart.setText("We2 프로젝트에 당신을 초대합니다. www.naver.com"); //메시지 쓰는 곳
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			File file = new File("C:/a.jpg"); //파일 보내기 
			FileDataSource fds = new FileDataSource(file);
			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setFileName(fds.getName());
			multipart.addBodyPart(messageBodyPart);

			// Put parts in message
			// HTML을 메시지로 보내는 것은 setContent()의 특정값만 세팅하면 된다.
			// 본래 : msg.setContent(multipart, "text/plain;charset=KSC5601");
			String htmlText=null;
			msg.setContent(htmlText, "text/html");

			// Send the message
			Transport.send(msg);
			System.out.println("Gmail SMTP서버를 이용한 메일보내기 성공");
		} catch (Exception mex) { // Prints all nested (chained) exceptions as
									// well
			System.out.println("I am here??? ");
			mex.printStackTrace();
		}
	}
	public static class SMTPAuthenticator extends javax.mail.Authenticator{
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("hyuk9658@gmail.com", "password"); // Google id, pwd
		}
	}
}